package com.prodyna.academy.patty.api;

import com.prodyna.academy.patty.api.visitor.Visitable;

public interface Node extends Visitable {

	String getUuid();

	Folder getParent();

	String getName();

	int getSize();

	boolean isRoot();

	String printPath();

}
