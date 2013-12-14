package com.prodyna.academy.patty.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.prodyna.academy.patty.domain.FileManager;
import com.prodyna.academy.patty.domain.Folder;
import com.prodyna.academy.patty.domain.Node;
import com.prodyna.academy.patty.domain.VirtualFileManager;
import com.prodyna.academy.patty.service.UnsupportedFileType;

public class VirtualFileManagerTest {

	private final FileManager vfm = VirtualFileManager.getInstance();

	@Test
	public void testAddFolder() {
		final Folder root = vfm.getRoot();
		assertNotNull(root);

		Node textFileNode;
		try {
			textFileNode = vfm.newTextFileNode("Textfile.txt", 512, "UTF-8", 1);
			assertNotNull(textFileNode);

			final Node addedNode = vfm.add(root, textFileNode);

			assertNotNull(addedNode);

			final List<Node> list = vfm.list(root);
			assertTrue(list.size() == 1);
			
			final String findByFileName = vfm.findByFileName(root, "Textfile.txt");
			assertEquals(findByFileName, "[/: Textfile.txt 512 UTF-8 1] ");
			
			int fileAmount = vfm.getFileAmount(root);
			assertEquals(fileAmount, 1);
			
			vfm.delete(textFileNode);
			List<Node> list2 = vfm.list(root);
			assertTrue(list2.size() == 0);
			
		} catch (final UnsupportedFileType e) {
			e.printStackTrace();
		}
	}
}