package com.prodyna.academy.patty.api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.prodyna.academy.patty.api.observer.Event;
import com.prodyna.academy.patty.vfs.observer.VfsDefaultObserver;
import com.prodyna.academy.patty.vfs.visitor.VfsPrintVisitor;

public class SmokeTest extends AbstractTest {

	private final ExecutorService executor = Executors.newFixedThreadPool(10);

	private final FileManager manager = FileManager.getInstance();

	private final Multimap<String, Event> eventMap = Multimaps.<String, Event> synchronizedMultimap(ArrayListMultimap
			.<String, Event> create());

	@Test
	public void testFileSystem() throws Exception {
		final Logger log = LoggerFactory.getLogger(this.getClass());
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

		//
		observerTest();
		Assert.assertEquals(5, eventMap.get("r1").size());
		Assert.assertEquals(5, eventMap.get("r2").size());
		//
		VfsPrintVisitor printVisitor = new VfsPrintVisitor();
		root.accept(printVisitor);
		log.info("PrintVisitor: \n" + printVisitor.toString());
		//

	}

	public void observerTest() throws Exception {
		{
			Runnable r1 = new Runnable() {
				final Logger log = LoggerFactory.getLogger("r1");

				@Override
				public void run() {
					Folder lorem = (Folder) manager.getFileSystem().getRoot().list("lorem").first();
					manager.getObserverManager().addObserver(lorem, new VfsDefaultObserver() {

						@Override
						public void notify(Event e) {
							log.info(">>> got event " + e.getClass());
							eventMap.put("r1", e);
						}

						@Override
						public boolean isRecursive() {
							return true;
						}

					});

				}
			};
			executor.execute(r1);
		}
		{
			Runnable r2 = new Runnable() {
				final Logger log = LoggerFactory.getLogger("r2");

				@Override
				public void run() {
					Folder root = manager.getFileSystem().getRoot();
					manager.getObserverManager().addObserver(root, new VfsDefaultObserver() {

						@Override
						public void notify(Event e) {
							log.info(">>> got folder change at node: " + e.getNode().getName());
							eventMap.put("r2", e);
						}

					});

				}
			};
			executor.execute(r2);
		}
		{
			Runnable r3 = new Runnable() {
				final Logger log = LoggerFactory.getLogger("r3");

				@Override
				public void run() {
					Folder root = manager.getFileSystem().getRoot();
					Folder lorem = (Folder) manager.getFileSystem().getRoot().list("lorem").first();
					Folder ipsum = (Folder) manager.getFileSystem().getRoot().list("ipsum").first();
					TextFile t1 = manager.getFileFactory().createTextFile("lorem1.txt", getSampleText());
					TextFile t2 = manager.getFileFactory().createTextFile("lorem2.txt", getSampleText());
					TextFile t3 = manager.getFileFactory().createTextFile("lorem3.txt", getSampleText());
					TextFile t4 = manager.getFileFactory().createTextFile("lorem4.txt", getSampleText());
					TextFile t5 = manager.getFileFactory().createTextFile("lorem5.txt", getSampleText());
					log.info("adding t1 to 'lorem'");
					manager.getFileSystem().add(lorem, t1);
					log.info("adding t2 to 'lorem'");
					manager.getFileSystem().add(lorem, t2);
					log.info("adding t3 to 'lorem'");
					manager.getFileSystem().add(lorem, t3);
					log.info("adding t4 to 'lorem'");
					manager.getFileSystem().add(lorem, t4);
					log.info("adding t5 to 'lorem'");
					manager.getFileSystem().add(lorem, t5);
					Assert.assertEquals(2955, root.getSize());
					manager.getFileSystem().move(t5, ipsum);
					Assert.assertEquals(2955 - 591, lorem.getSize());
					Assert.assertEquals(591, ipsum.getSize());
				}
			};
			executor.execute(r3);
		}
		executor.awaitTermination(1, TimeUnit.SECONDS);
	}
}
