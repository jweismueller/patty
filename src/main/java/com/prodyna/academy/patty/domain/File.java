package com.prodyna.academy.patty.domain;

import java.util.List;

/**
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public abstract class File extends Node {

	@Override
	public void delete() {
		Folder parentFolder = (Folder) getParent();
		parentFolder.deleteChild(this);
	}

	@Override
	public List<Node> list() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return "File [getName()=" + getName() + "]";
	}

}
