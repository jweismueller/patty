package com.prodyna.academy.patty.api;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prodyna.academy.patty.api.criteria.CriteriaBuilder;
import com.prodyna.academy.patty.api.criteria.Criterion;
import com.prodyna.academy.patty.vfs.visitor.VfsPrintVisitor;
import com.prodyna.academy.patty.vfs.visitor.VfsSearchVisitor;

public class CriterionTest extends AbstractTest {

	private final FileManager manager = FileManager.getInstance();

	@Test
	public void testFileSystem() throws Exception {
		final Logger log = LoggerFactory.getLogger(this.getClass());
		Folder root = manager.getFileSystem().getRoot();
		Assert.assertEquals("", root.getName());
		//
		final Folder lorem = manager.getFileFactory().createFolder("lorem");
		manager.getFileSystem().add(root, lorem);
		final Folder ipsum = manager.getFileFactory().createFolder("ipsum");
		manager.getFileSystem().add(root, ipsum);
		//
		TextFile t1 = manager.getFileFactory().createTextFile("hase.txt", getSampleText());
		TextFile t2 = manager.getFileFactory().createTextFile("igel.txt", getSampleText());
		TextFile t3 = manager.getFileFactory().createTextFile("hund.txt", getSampleText());
		TextFile t4 = manager.getFileFactory().createTextFile("pferd.txt", getSampleText());
		manager.getFileSystem().add(lorem, t1);
		manager.getFileSystem().add(lorem, t2);
		manager.getFileSystem().add(lorem, t3);
		manager.getFileSystem().add(lorem, t4);
		TextFile t5 = manager.getFileFactory().createTextFile("katze.txt", "326479324");
		TextFile t6 = manager.getFileFactory().createTextFile("fisch.txt", "49743");
		TextFile t7 = manager.getFileFactory().createTextFile("kuh.txt", "329749324");
		TextFile t8 = manager.getFileFactory().createTextFile("maulwurf.txt", "...");
		manager.getFileSystem().add(ipsum, t5);
		manager.getFileSystem().add(ipsum, t6);
		manager.getFileSystem().add(ipsum, t7);
		manager.getFileSystem().add(ipsum, t8);
		//
		VfsPrintVisitor printVisitor = new VfsPrintVisitor();
		root.accept(printVisitor);
		log.info("PrintVisitor: \n" + printVisitor.toString());
		//
		Criterion c = CriteriaBuilder.get().name("h.*").sizeGe(500).and().regex("[0-9]+").or().getCriteria();
		VfsSearchVisitor searchVisitor = new VfsSearchVisitor(c);
		root.accept(searchVisitor);
		for (Node n : searchVisitor.getResults()) {
			log.info(n.printPath());
		}

	}
}
