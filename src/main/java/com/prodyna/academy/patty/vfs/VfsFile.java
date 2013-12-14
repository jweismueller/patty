package com.prodyna.academy.patty.vfs;

import com.prodyna.academy.patty.api.visitor.Visitor;

public abstract class VfsFile extends VfsNode {

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
