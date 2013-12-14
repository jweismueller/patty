package com.prodyna.academy.patty.api.observer;

public interface Observer {

	void notify(Event e);

	boolean isRecursive();

}
