package com.prodyna.academy.patty.api.criteria;

import com.prodyna.academy.patty.api.File;
import com.prodyna.academy.patty.api.Node;

public class SizeCriterion extends AbstractCriterion {

	private int size;

	private OP op;

	public static enum OP {
		LE, GE
	}

	public SizeCriterion(int size, OP op) {
		this.size = size;
		this.op = op;
	}

	@Override
	public boolean matches(Node node) {
		if (node instanceof File) {
			File file = (File) node;
			switch (op) {
			case GE:
				return file.getSize() >= size;
			case LE:
				return file.getSize() <= size;
			default:
				throw new IllegalStateException();
			}
		} else {
			return false;
		}
	}

}
