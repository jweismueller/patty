package com.prodyna.academy.patty.api.criteria;

import com.prodyna.academy.patty.api.Node;

public class AndCriterion extends AbstractCriterion {

	private Criterion c0;

	private Criterion c1;

	public AndCriterion(Criterion c0, Criterion c1) {
		this.c0 = c0;
		this.c1 = c1;
	}

	@Override
	public boolean matches(Node node) {
		return c0.matches(node) && c1.matches(node);
	}
}
