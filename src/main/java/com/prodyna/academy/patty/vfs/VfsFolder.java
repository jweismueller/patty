package com.prodyna.academy.patty.vfs;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Pattern;

import com.prodyna.academy.patty.api.File;
import com.prodyna.academy.patty.api.Folder;
import com.prodyna.academy.patty.api.Node;
import com.prodyna.academy.patty.api.visitor.Visitor;

public class VfsFolder extends VfsNode implements Folder {

	private SortedSet<VfsNode> children = new TreeSet<>();

	VfsFolder() {

	}

	public SortedSet<VfsNode> getChildren() {
		return children;
	}

	@Override
	public int getSize() {
		int out = 0;
		for (VfsNode node : children) {
			out += node.getSize();
		}
		return out;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public SortedSet<File> listFiles() {
		SortedSet<File> out = new TreeSet<>();
		for (VfsNode node : children) {
			if (node instanceof File) {
				out.add((File) node);
			}
		}
		return out;
	}

	@Override
	public SortedSet<Folder> listFolders() {
		SortedSet<Folder> out = new TreeSet<>();
		for (VfsNode node : children) {
			if (node instanceof Folder) {
				out.add((Folder) node);
			}
		}
		return out;
	}

	@Override
	public SortedSet<Node> list() {
		return new TreeSet<Node>(children);
	}

	@Override
	public SortedSet<Node> list(String regexp) {
		Pattern p = Pattern.compile(".*" + regexp + ".*");
		SortedSet<Node> out = new TreeSet<>();
		for (VfsNode node : children) {
			if (p.matcher(node.getName()).matches()) {
				out.add(node);
			}
		}
		return out;
	}

}
