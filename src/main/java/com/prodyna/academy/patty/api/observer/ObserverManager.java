package com.prodyna.academy.patty.api.observer;

import com.prodyna.academy.patty.api.Node;

public interface ObserverManager {

	void addObserver(Node n, Observer o);

	void addObserver(Node n, FolderChangeObserver o);

	void removeObserver(Node n, Observer o);

	void removeObserver(Node n, FolderChangeObserver o);

}
