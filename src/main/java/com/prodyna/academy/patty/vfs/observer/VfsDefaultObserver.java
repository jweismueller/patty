package com.prodyna.academy.patty.vfs.observer;

import com.prodyna.academy.patty.api.observer.Event;
import com.prodyna.academy.patty.api.observer.Observer;

public abstract class VfsDefaultObserver implements Observer {

	@Override
	public void notify(Event e) {

	}

	@Override
	public boolean isRecursive() {
		return false;
	}

}
