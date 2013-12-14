package com.prodyna.academy.patty.api;

import java.util.SortedSet;

public interface Folder extends Node {

	SortedSet<Node> list();

	SortedSet<Node> list(String regexp);

	SortedSet<File> listFiles();

	SortedSet<Folder> listFolders();

}
