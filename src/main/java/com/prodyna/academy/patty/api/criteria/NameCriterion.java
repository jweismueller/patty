package com.prodyna.academy.patty.api.criteria;

import java.util.regex.Pattern;

import com.prodyna.academy.patty.api.Node;

public class NameCriterion extends AbstractCriterion {

	private Pattern p;

	public NameCriterion(String regex) {
		p = Pattern.compile(regex);
	}

	@Override
	public boolean matches(Node node) {
		boolean b = p.matcher(node.getName()).matches();
		return b;
	}
}
