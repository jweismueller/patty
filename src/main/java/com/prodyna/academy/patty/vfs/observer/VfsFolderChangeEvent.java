package com.prodyna.academy.patty.vfs.observer;

import com.prodyna.academy.patty.vfs.VfsNode;

public class VfsFolderChangeEvent extends VfsEvent {

	public VfsFolderChangeEvent(VfsNode node) {
		super(node);
	}

}
