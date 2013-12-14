package com.prodyna.academy.patty.vfs;

import java.util.UUID;

import com.prodyna.academy.patty.api.Folder;
import com.prodyna.academy.patty.api.Node;
import com.prodyna.academy.patty.api.visitor.Visitor;

public abstract class VfsNode implements Node, Comparable<VfsNode> {

	private String uuid = UUID.randomUUID().toString();

	private String name;

	private Folder parent;

	public abstract int getSize();

	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	public String getUuid() {
		return uuid;
	}

	public Folder getParent() {
		return parent;
	}

	void setParent(Folder parent) {
		this.parent = parent;
		VfsFolder folder = (VfsFolder) parent;
		folder.getChildren().add(this);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public boolean isRoot() {
		return getParent() == null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VfsNode other = (VfsNode) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	@Override
	public int compareTo(VfsNode o) {
		return this.uuid.compareTo(o.uuid);
	}

}
