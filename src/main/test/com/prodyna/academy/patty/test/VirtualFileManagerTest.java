package com.prodyna.academy.patty.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.prodyna.academy.patty.domain.FileManager;
import com.prodyna.academy.patty.domain.FileType;
import com.prodyna.academy.patty.domain.Folder;
import com.prodyna.academy.patty.domain.Node;
import com.prodyna.academy.patty.domain.VirtualFileManager;
import com.prodyna.academy.patty.service.UnsupportedFileType;

public class VirtualFileManagerTest {

	private final FileManager vfm = VirtualFileManager.getInstance();

	@Test
	public void testVfm() {
		final Folder root = vfm.getRoot();
		assertNotNull(root);

		Node textFileNode;
		try {
			//create textFile
			textFileNode = vfm.newTextFileNode("Textfile.txt", 512, "UTF-8", 1);
			assertNotNull(textFileNode);

			//register observer for root node
			vfm.register(new MyNodeObserver(), root);
			
			//add node to root folder
			final Node addedNode = vfm.add(root, textFileNode);
			assertNotNull(addedNode);

			//root folder now has to have one child (textfile)
			final List<Node> list = vfm.list(root);
			assertTrue(list.size() == 1);
			
			//check if visitor finds newly created textfile
			final String findByFileName = vfm.findByFileName(root, "Textfile.txt");
			assertEquals(findByFileName, "[/: Textfile.txt 512 UTF-8 1] ");
			
			//root folder now has to have one child (textfile)
			final int fileAmount = vfm.getFileAmount(root);
			assertEquals(1, fileAmount);
			
			//there should be no image files
			final int imageFileAmount = vfm.getImageFileAmount(root);
			assertEquals(0, imageFileAmount);
			
			//delete textfile and check if root node now has no children anymore
			vfm.delete(textFileNode);
			final List<Node> list2 = vfm.list(root);
			assertTrue(list2.size() == 0);
			
			//prepare testing move functionality
			final Folder newFolderNode = (Folder) vfm.newFolderNode("sub-folder");
			vfm.add(root, newFolderNode);
			assertNotNull(newFolderNode);
			
			final Node newMediaFileNode = vfm.newMediaFileNode(FileType.VIDEO, "media.avi", 1024, 800, 600);
			assertNotNull(newMediaFileNode);
			vfm.add(root, newMediaFileNode);
			
			final List<Node> list3 = vfm.list(root);
			assertTrue(list3.size() == 2);
			
			vfm.move(newMediaFileNode, newFolderNode);
			final List<Node> list4 = vfm.list(root);
			assertTrue(list4.size() == 1);

			final List<Node> list5 = vfm.list(newFolderNode);
			assertTrue(list5.size() == 1);
			
			String prettyList = vfm.prettyList(root);
			System.out.println(prettyList);
		} catch (final UnsupportedFileType e) {
			e.printStackTrace();
		}
	}
}