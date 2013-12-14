package com.prodyna.academy.patty.domain;

import com.prodyna.academy.patty.service.visitor.Visitor;

/**
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class VideoFile extends File {
	private long height;
	private long width;

	VideoFile(final String name, final long size, final long height,
			final long width) {
		this.height = height;
		this.width = width;
		super.setName(name);
		super.setSize(size);
	}

	public long getHeight() {
		return height;
	}

	public void setHeight(final long height) {
		this.height = height;
	}

	public long getWidth() {
		return width;
	}

	public void setWidth(final long width) {
		this.width = width;
	}

	@Override
	public void accept(final Visitor visitor) {
		visitor.visit(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VideoFile [height=" + height + ", width=" + width
				+ ", getName()=" + getName() + ", getSize()=" + getSize()
				+ ", getParent()=" + getParent() + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (height ^ (height >>> 32));
		result = prime * result + (int) (width ^ (width >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		VideoFile other = (VideoFile) obj;
		if (height != other.height) {
			return false;
		}
		if (width != other.width) {
			return false;
		}
		return true;
	}

}