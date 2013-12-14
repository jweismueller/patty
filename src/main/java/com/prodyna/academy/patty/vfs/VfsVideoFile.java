package com.prodyna.academy.patty.vfs;

import com.prodyna.academy.patty.api.VideoFile;
import com.prodyna.academy.patty.api.visitor.Visitor;

public class VfsVideoFile extends VfsBinaryFile implements VideoFile {

	VfsVideoFile() {
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
