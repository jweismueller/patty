package com.prodyna.academy.patty.vfs.observer;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.prodyna.academy.patty.api.Node;
import com.prodyna.academy.patty.api.observer.Event;
import com.prodyna.academy.patty.api.observer.Observer;
import com.prodyna.academy.patty.api.observer.ObserverManager;

public class VfsObserverManager implements ObserverManager {

	private Multimap<String, Observer> map = Multimaps.<String, Observer> synchronizedMultimap(ArrayListMultimap
			.<String, Observer> create());

	@Override
	public void addObserver(Node n, Observer o) {
		map.put(n.getUuid(), o);
	}

	@Override
	public void removeObserver(Node n, Observer o) {
		map.get(n.getUuid()).remove(o);
	}

	public void notify(Event e) {
		notify(e.getNode(), e);
	}

	private void notify(Node n, Event e) {
		String uuid = n.getUuid();
		for (Observer observer : map.get(uuid)) {
			observer.notify(e);
			if (observer.isRecursive() && !n.isRoot()) {
				notify(e.getNode().getParent(), e);
			}
		}
	}

	public void removeObservers(Node node) {
		map.removeAll(node.getUuid());
	}
}
