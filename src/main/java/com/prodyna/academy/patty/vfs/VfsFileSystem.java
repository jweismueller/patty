package com.prodyna.academy.patty.vfs;

import com.prodyna.academy.patty.api.FileSystem;
import com.prodyna.academy.patty.api.Folder;
import com.prodyna.academy.patty.api.Node;
import com.prodyna.academy.patty.api.observer.Event;
import com.prodyna.academy.patty.vfs.observer.VfsEvent;
import com.prodyna.academy.patty.vfs.observer.VfsFolderChangeEvent;
import com.prodyna.academy.patty.vfs.observer.VfsObserverManager;

public class VfsFileSystem implements FileSystem {

	private VfsObserverManager observerManager = new VfsObserverManager();

	private final VfsFolder root;

	public VfsFileSystem() {
		root = new VfsFolder();
		root.setName("");
	}

	@Override
	public VfsFolder getRoot() {
		return root;
	}

	@Override
	public void add(Folder f, Node n) {
		VfsNode node = (VfsNode) n;
		VfsFolder folder = (VfsFolder) f;
		node.setParent(f);
		VfsFolderChangeEvent event = new VfsFolderChangeEvent(folder);
		observerManager.notify(event);
	}

	@Override
	public void rename(Node n, String name) {
		VfsNode node = (VfsNode) n;
		node.setName(name);
		Event e = new VfsEvent(node);
		observerManager.notify(e);
	}

	@Override
	public void move(Node n, Folder target) {
		VfsFolder parent = (VfsFolder) n.getParent();
		parent.getChildren().remove(n);
		VfsNode node = (VfsNode) n;
		node.setParent(target);
	}

	@Override
	public void delete(Node n) {
		VfsNode node = (VfsNode) n;
		node.setParent(null);
		VfsFolder parent = (VfsFolder) n.getParent();
		parent.getChildren().remove(n);
		observerManager.removeObservers(n);
	}

	public VfsObserverManager getObserverManager() {
		return observerManager;
	}

}
