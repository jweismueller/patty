package com.prodyna.academy.patty.api.criteria;

import com.prodyna.academy.patty.api.Node;

public interface Criterion {

	boolean matches(Node node);

}
