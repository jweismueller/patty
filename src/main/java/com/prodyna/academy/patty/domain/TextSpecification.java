package com.prodyna.academy.patty.domain;

public class TextSpecification extends FileSpecification {
	private String textEncoding;
	private long pageCount;
	
	public TextSpecification(String textEncoding, long pageCount, long size) {
		super();
		this.textEncoding = textEncoding;
		this.pageCount = pageCount;
		setSize(size);
	}

	public String getTextEncoding() {
		return textEncoding;
	}

	public long getPageCount() {
		return pageCount;
	}
}
