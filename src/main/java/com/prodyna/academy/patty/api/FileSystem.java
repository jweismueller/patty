package com.prodyna.academy.patty.api;

public interface FileSystem {

	Folder getRoot();

	void add(Folder f, Node n);

	void rename(Node n, String name);

	void move(Node n, Folder target);

	void delete(Node n);

}
