package com.prodyna.academy.patty.vfs.visitor;

import com.prodyna.academy.patty.api.Folder;
import com.prodyna.academy.patty.api.Node;

public class VfsPrintVisitor extends AbstractVfsVisitor {

	private int indention = 0;

	private StringBuilder out = new StringBuilder();

	@Override
	public void visit(Node node) {
		out.append(indention()).append("- ").append(node.getName()).append("\n");
	}

	@Override
	public void visit(Folder folder) {
		out.append(indention()).append("+ ").append(folder.getName()).append("\n");
		indention++;
		super.visit(folder);
		indention--;
	}

	private String indention() {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < indention; i++) {
			out.append("    ");
		}
		return out.toString();
	}

	@Override
	public String toString() {
		return out.toString();
	}

}
