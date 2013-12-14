package com.prodyna.academy.patty.service.filter;

import com.prodyna.academy.patty.domain.Node;

public class AndFilter implements Filter {
	private Filter criterion1;
	private Filter criterion2;
	
	AndFilter(Filter criterion1, Filter criterion2) {
		super();
		this.criterion1 = criterion1;
		this.criterion2 = criterion2;
	}

	public boolean matches(Node node) {
		return criterion1.matches(node) && criterion2.matches(node);
	}
}
