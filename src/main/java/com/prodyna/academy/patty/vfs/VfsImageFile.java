package com.prodyna.academy.patty.vfs;

import com.prodyna.academy.patty.api.ImageFile;
import com.prodyna.academy.patty.api.visitor.Visitor;

public class VfsImageFile extends VfsBinaryFile implements ImageFile {

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
