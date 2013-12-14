package com.prodyna.academy.patty.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.prodyna.academy.patty.service.Visitor;

/**
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class Folder extends Node {
	private final Set<Node> children = new HashSet<Node>();

	Folder(final String name) {
		super.setName(name);
	}

	public void add(final Node node) {
		node.setParent(this);
		children.add(node);
	}

	public void deleteChild(final Node node) {
		children.remove(node);
	}

	@Override
	public void delete() {
		for (final Node child : children) {
			child.delete();
		}

		final Folder parentFolder = (Folder) getParent();
		parentFolder.deleteChild(this);
	}

	@Override
	public List<Node> list() {
		return new ArrayList<Node>(children);
	}

	@Override
	public void accept(final Visitor visitor) {
		visitor.visit(this);
	}
	
	public Set<Node> getChildren() {
		return children;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Folder [getName()=" + getName() + ", getSize()=" + getSize()
				+ ", getParent()=" + getParent() + "]";
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
		Folder other = (Folder) obj;
		if (children == null) {
			if (other.children != null) {
				return false;
			}
		} else if (!children.equals(other.children)) {
			return false;
		}
		return true;
	}
}
