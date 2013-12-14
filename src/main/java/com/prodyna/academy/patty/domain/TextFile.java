package com.prodyna.academy.patty.domain;

import com.prodyna.academy.patty.service.visitor.Visitor;

/**
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class TextFile extends File {
	private String textEncoding;
	private long pageCount;

	TextFile(final String name, final long size, final String textEncoding,
			final long pageCount) {
		this.textEncoding = textEncoding;
		this.pageCount = pageCount;
		super.setName(name);
		super.setSize(size);
		super.setType(FileType.TEXT);
	}

	public String getTextEncoding() {
		return textEncoding;
	}

	void setTextEncoding(final String textEncoding) {
		this.textEncoding = textEncoding;
	}

	public long getPageCount() {
		return pageCount;
	}

	void setPageCount(final long pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public void accept(final Visitor visitor) {
		visitor.visit(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TextFile [textEncoding=" + textEncoding + ", pageCount="
				+ pageCount + ", getName()=" + getName() + ", getSize()="
				+ getSize() + ", getParent()=" + getParent() + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (pageCount ^ (pageCount >>> 32));
		result = prime * result
				+ ((textEncoding == null) ? 0 : textEncoding.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		TextFile other = (TextFile) obj;
		if (pageCount != other.pageCount) {
			return false;
		}
		if (textEncoding == null) {
			if (other.textEncoding != null) {
				return false;
			}
		} else if (!textEncoding.equals(other.textEncoding)) {
			return false;
		}
		return true;
	}
	
	
}