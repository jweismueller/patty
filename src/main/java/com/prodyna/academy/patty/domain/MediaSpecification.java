package com.prodyna.academy.patty.domain;

public class MediaSpecification extends FileSpecification {
	private long height;
	private long width;
	
	public MediaSpecification(long size, long height, long width) {
		super();
		setSize(size);
		this.height = height;
		this.width = width;
	}

	public long getHeight() {
		return height;
	}

	public long getWidth() {
		return width;
	}
}
