package com.prodyna.academy.patty.test;

import com.prodyna.academy.patty.domain.EventMessage;
import com.prodyna.academy.patty.domain.Node;
import com.prodyna.academy.patty.service.NodeObserver;

public class MyNodeObserver implements NodeObserver {

	@Override
	public void notifyObserver(Node aNode, EventMessage message) {
		System.out.println(message.getMessage());
	}
}
