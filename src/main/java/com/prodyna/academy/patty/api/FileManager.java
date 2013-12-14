package com.prodyna.academy.patty.api;

import com.prodyna.academy.patty.api.oberserver.ObserverManager;
import com.prodyna.academy.patty.vfs.VfsFileFactory;
import com.prodyna.academy.patty.vfs.VfsFileSystem;

public class FileManager {

	private static FileManager FILE_MANAGER = new FileManager();

	private VfsFileFactory fileFactory;

	private VfsFileSystem fileSystem;

	private FileManager() {
		fileFactory = new VfsFileFactory();
		fileSystem = new VfsFileSystem();
	}

	public static FileManager getInstance() {
		return FILE_MANAGER;
	}

	public FileSystem getFileSystem() {
		return fileSystem;
	}

	public FileFactory getFileFactory() {
		return fileFactory;
	}

	public ObserverManager getObserverManager() {
		return fileSystem.getObserverManager();
	}

}
