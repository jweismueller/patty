package com.prodyna.academy.patty.vfs;

import com.prodyna.academy.patty.api.visitor.Visitor;

public abstract class VfsBinaryFile extends VfsFile {

	private byte[] content;

	public byte[] getContent() {
		return content;
	}

	@Override
	public int getSize() {
		return content.length;
	}

	void setContent(byte[] content) {
		this.content = content;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
