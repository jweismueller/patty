package com.prodyna.academy.patty.service;

import java.util.Set;

import com.prodyna.academy.patty.domain.Folder;
import com.prodyna.academy.patty.domain.ImageFile;
import com.prodyna.academy.patty.domain.Node;
import com.prodyna.academy.patty.domain.TextFile;
import com.prodyna.academy.patty.domain.VideoFile;

public abstract class BasicVisitor implements Visitor {

	@Override
	public void visit(ImageFile file) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(TextFile file) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(VideoFile file) {
		// TODO Auto-generated method stub

	}
	
	/* (non-Javadoc)
	 * @see com.prodyna.academy.patty.service.Visitor#visit(com.prodyna.academy.patty.domain.Folder)
	 */
	@Override
	public void visit(final Folder folder) {
		Set<Node> children = folder.getChildren();
		for (Node node : children) {
			node.accept(this);
		}
	}

}
