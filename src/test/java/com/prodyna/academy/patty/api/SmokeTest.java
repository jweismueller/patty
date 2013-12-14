package com.prodyna.academy.patty.api;

import org.junit.Assert;
import org.junit.Test;

public class SmokeTest extends AbstractTest {

	private final FileManager manager = FileManager.getInstance();

	@Test
	public void testFileSystem() throws Exception {
		Folder root = manager.getFileSystem().getRoot();
		Assert.assertEquals("", root.getName());
		manager.getFileSystem().rename(root, "rooty");
		Assert.assertEquals("rooty", root.getName());
		//
		final Folder lorem = manager.getFileFactory().createFolder("lorem");
		manager.getFileSystem().add(root, lorem);
		final Folder ipsum = manager.getFileFactory().createFolder("ipsum");
		manager.getFileSystem().add(root, ipsum);
		//
		Folder loremTest = (Folder) manager.getFileSystem().getRoot().list("lorem").first();
		Assert.assertEquals(lorem.getUuid(), loremTest.getUuid());
	}
}
