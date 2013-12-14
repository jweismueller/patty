package com.prodyna.academy.patty.api.visitor;

import com.prodyna.academy.patty.api.Folder;
import com.prodyna.academy.patty.api.ImageFile;
import com.prodyna.academy.patty.api.Node;
import com.prodyna.academy.patty.api.TextFile;
import com.prodyna.academy.patty.api.VideoFile;

public interface Visitor {

	void visit(Node node);

	void visit(Folder folder);

	void visit(TextFile file);

	void visit(ImageFile file);

	void visit(VideoFile file);

}
