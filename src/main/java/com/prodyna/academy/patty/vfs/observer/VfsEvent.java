package com.prodyna.academy.patty.vfs.observer;

import com.prodyna.academy.patty.api.Node;
import com.prodyna.academy.patty.api.observer.Event;
import com.prodyna.academy.patty.vfs.VfsNode;

public class VfsEvent implements Event {

	private VfsNode node;

	public VfsEvent(VfsNode node) {
		this.node = node;
	}

	@Override
	public Node getNode() {
		return node;
	}

}
