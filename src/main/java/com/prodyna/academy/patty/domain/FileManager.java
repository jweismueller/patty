package com.prodyna.academy.patty.domain;

import java.util.List;

import com.prodyna.academy.patty.service.NodeObserver;
import com.prodyna.academy.patty.service.UnsupportedFileType;

/**
 * This is the interface for file manager of a virtual file system.
 * 
 * @author aheizenreder
 * 
 */
public interface FileManager extends NodeObserver {

	// entry point
	Folder getRoot();

	// structure methods
	Node newTextFileNode(String name, long size,
			String textEncoding, long pageCount) throws UnsupportedFileType;
	Node newMediaFileNode(FileType fType, String name, long size, long height,
			long width) throws UnsupportedFileType;
	Node newFolderNode( String name) throws UnsupportedFileType;

	Node add(Folder parent, Node aNode);
	Node delete(Node aNode);
	List<Node> list(Node aNode);
	
	String prettyList(Node aNode);
	
	Node move(Node aNode, Folder newParent);

	// observer management
	void register(NodeObserver aObserver, Node aNode);
	void unRegister(NodeObserver aObserver, Node aNode);

	int getImageFileAmount(Node aNode);
	int getFileAmount(Node aNode);

	String findByFileName(Folder aNode, String fileName);
}
