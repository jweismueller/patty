package com.prodyna.academy.patty.domain;

import java.util.Collections;
import java.util.List;

import com.prodyna.academy.patty.service.Visitor;

/**
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public abstract class Node {
	private String name;
	private long size;
	private Folder parent;

	public String getName() {
		return name;
	}

	void setName(final String name) {
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	void setSize(final long size) {
		this.size = size;
	}

	public Folder getParent() {
		return parent;
	}

	void setParent(final Folder parent) {
		this.parent = parent;
	}

	public void delete() {

	}

	public List<Node> list() {
		return Collections.emptyList();
	}

	public void accept(Visitor visitor) {

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + (int) (size ^ (size >>> 32));
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
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Node other = (Node) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (parent == null) {
			if (other.parent != null) {
				return false;
			}
		} else if (!parent.equals(other.parent)) {
			return false;
		}
		if (size != other.size) {
			return false;
		}
		return true;
	}
	
	public boolean isRoot() {
		return (getParent() != null);
	}
}