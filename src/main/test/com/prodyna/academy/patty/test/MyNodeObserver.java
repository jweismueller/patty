package com.prodyna.academy.patty.test;

import com.prodyna.academy.patty.domain.Node;
import com.prodyna.academy.patty.service.NodeObserver;

public class MyNodeObserver implements NodeObserver {

	@Override
	public void notifyObserver(Node aNode) {
		System.out.println("I'm called!");
	}
}
