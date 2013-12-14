package com.prodyna.academy.patty.vfs.visitor;

import com.prodyna.academy.patty.api.Folder;
import com.prodyna.academy.patty.api.ImageFile;
import com.prodyna.academy.patty.api.Node;
import com.prodyna.academy.patty.api.TextFile;
import com.prodyna.academy.patty.api.VideoFile;
import com.prodyna.academy.patty.api.visitor.Visitor;

public abstract class AbstractVfsVisitor implements Visitor {

	@Override
	public void visit(Folder folder) {
		for (Node node : folder.list()) {
			node.accept(this);
		}
	}

	@Override
	public void visit(Node node) {

	}

	@Override
	public void visit(TextFile file) {

	}

	@Override
	public void visit(ImageFile file) {

	}

	@Override
	public void visit(VideoFile file) {

	}

}
