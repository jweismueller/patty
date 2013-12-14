package com.prodyna.academy.patty.api.criteria;

import com.prodyna.academy.patty.api.Node;

public class NullCriterion extends AbstractCriterion {

	@Override
	public boolean matches(Node node) {
		return true;
	}

}
