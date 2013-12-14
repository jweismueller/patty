package com.prodyna.academy.patty.api.oberserver;

public interface Observer {

	void notify(Event o);

	boolean isRecursive();

}
