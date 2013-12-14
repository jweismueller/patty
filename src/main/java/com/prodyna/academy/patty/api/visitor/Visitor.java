package com.prodyna.academy.patty.api.visitor;

import com.prodyna.academy.patty.api.Folder;
import com.prodyna.academy.patty.api.Node;

public interface Visitor {

	void visit(Node node);

	void visit(Folder folder);

}
