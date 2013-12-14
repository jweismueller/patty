package com.prodyna.academy.patty.vfs;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.prodyna.academy.patty.api.TextFile;
import com.prodyna.academy.patty.api.visitor.Visitor;

public class VfsTextFile extends VfsFile implements TextFile {

	private String content;

	private Charset charset = StandardCharsets.UTF_8;

	public String getContent() {
		return content;
	}

	VfsTextFile() {
	}

	@Override
	public int getSize() {
		return content.getBytes().length;
	}

	public int getPageCount() {
		return 1;
	}

	public String getEncoding() {
		return charset.toString();
	}

	void setContent(String content, Charset charset) {
		this.content = content;
		this.charset = charset;
	}

	public void setContent(String content) {
		this.content = content;
		this.charset = StandardCharsets.UTF_8;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
