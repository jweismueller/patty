/**
 * 
 */
package com.prodyna.academy.patty.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prodyna.academy.patty.service.AllFileFilter;
import com.prodyna.academy.patty.service.CountVisitor;
import com.prodyna.academy.patty.service.ImageFilter;
import com.prodyna.academy.patty.service.NodeObserver;
import com.prodyna.academy.patty.service.PrettyListVisitor;
import com.prodyna.academy.patty.service.PrintVisitor;
import com.prodyna.academy.patty.service.UnsupportedFileType;

/**
 * implements a file manager as a singleton.
 * 
 * @author aheizenreder
 * 
 */
public class VirtualFileManager implements FileManager {

	private static FileManager fileManager;

	private final Map<Node, List<NodeObserver>> observers = new HashMap<Node, List<NodeObserver>>();

	private final Folder root;

	public synchronized static FileManager getInstance() {
		if (fileManager == null) {
			fileManager = new VirtualFileManager();
		}
		return fileManager;
	}

	private VirtualFileManager() {
		root = FilesystemAbstractFactory.createFolder("root");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prodyna.academy.patty.domain.NodeObserver#notifyObserver()
	 */
	public void notifyObserver(final Node aNode, EventMessage eventMessage) {
		final List<NodeObserver> observerList = observers.get(aNode);

		if (observerList != null) {
			for (final NodeObserver nodeObserver : observerList) {
				nodeObserver.notifyObserver(aNode, eventMessage);
			}
		}

		// propagate notify event to all parent until root reached
		if (!aNode.isRoot()) {
			Folder parent = aNode.getParent();
			notifyObserver(parent, eventMessage);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prodyna.academy.patty.domain.FileManager#getRoot()
	 */
	public Folder getRoot() {
		return root;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.domain.FileManager#newNode(com.prodyna.academy
	 * .patty.domain.FileType)
	 */
	public Node newTextFileNode(final String name, final long size,
			final String textEncoding, final long pageCount)
			throws UnsupportedFileType {
		Node node;

		node = FilesystemAbstractFactory.createTextFile(name, new TextSpecification(textEncoding, pageCount, size));

		return node;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.domain.FileManager#newNode(com.prodyna.academy
	 * .patty.domain.FileType)
	 */
	public Node newMediaFileNode(final FileType fType, final String name,
			final long size, final long height, final long width)
			throws UnsupportedFileType {
		Node node;

		switch (fType) {
		case IMAGE:
			node = FilesystemAbstractFactory.createImageFile(name, new MediaSpecification(size, height, width));
			break;
		case VIDEO:
			node = FilesystemAbstractFactory.createVideoFile(name, new MediaSpecification(size, height, width));
			break;
		default:
			throw new UnsupportedFileType();
		}

		return node;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.service.FileManager#newFolderNode(com.prodyna
	 * .academy.patty.service.FileType, java.lang.String)
	 */
	public Node newFolderNode(final String name) throws UnsupportedFileType {
		Node node;

		node = FilesystemAbstractFactory.createFolder(name);

		return node;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.domain.FileManager#add(com.prodyna.academy.
	 * patty.domain.Folder, com.prodyna.academy.patty.domain.Node)
	 */
	public Node add(final Folder parent, final Node aNode) {
		aNode.setParent(parent);
		parent.add(aNode);
		notifyObserver(parent, new EventMessage("new node "+aNode.getName()+" added"));
		return aNode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.domain.FileManager#delete(com.prodyna.academy
	 * .patty.domain.Node)
	 */
	public Node delete(final Node aNode) {
		aNode.delete();
		notifyObserver(aNode.getParent(), new EventMessage("node "+aNode.getName()+" deleted"));
		return aNode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.domain.FileManager#list(com.prodyna.academy
	 * .patty.domain.Node)
	 */
	public List<Node> list(final Node aNode) {
		return aNode.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.domain.FileManager#register(com.prodyna.academy
	 * .patty.domain.NodeObserver, com.prodyna.academy.patty.domain.Node)
	 */
	public void register(final NodeObserver aObserver, final Node aNode) {
		List<NodeObserver> observerList = observers.get(aNode);

		if (observerList == null) {
			observerList = new ArrayList<NodeObserver>();
			observers.put(aNode, observerList);
		}

		observerList.add(aObserver);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.domain.FileManager#unRegister(com.prodyna.academy
	 * .patty.domain.NodeObserver)
	 */
	public void unRegister(final NodeObserver aObserver, final Node aNode) {
		final List<NodeObserver> observerList = observers.get(aNode);

		if (observerList != null) {
			observerList.remove(aObserver);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.service.FileManager#move(com.prodyna.academy
	 * .patty.domain.Node, com.prodyna.academy.patty.domain.Folder)
	 */
	public Node move(final Node aNode, final Folder newParent) {
		final Folder oldParentFolder = aNode.getParent();
		oldParentFolder.deleteChild(aNode);
		notifyObserver(oldParentFolder, new EventMessage("node "+aNode.getName()+" removed"));

		newParent.add(aNode);
		notifyObserver(newParent, new EventMessage("node "+aNode.getName()+" moved"));
		return aNode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.service.FileManager#getImageFileAmount(com.
	 * prodyna.academy.patty.domain.Node)
	 */
	public int getImageFileAmount(Node aNode) {
		CountVisitor visitor = new CountVisitor();
		visitor.setFilter(new ImageFilter());

		aNode.accept(visitor);

		return visitor.getCountResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.service.FileManager#getFileAmount(com.prodyna
	 * .academy.patty.domain.Node)
	 */
	public int getFileAmount(Node aNode) {
		CountVisitor visitor = new CountVisitor();
		visitor.setFilter(new AllFileFilter());

		aNode.accept(visitor);

		return visitor.getCountResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.service.FileManager#findByFileName(com.prodyna
	 * .academy.patty.domain.Folder, java.lang.String)
	 */
	public String findByFileName(Folder aNode, String fileName) {
		PrintVisitor visitor = new PrintVisitor();
		visitor.setFilter(new FilenameFilter(fileName));

		aNode.accept(visitor);

		return visitor.getResultList();
	}

	@Override
	public String prettyList(Node aNode) {
		PrettyListVisitor prettyListVisitor = new PrettyListVisitor();
		aNode.accept(prettyListVisitor);
		return prettyListVisitor.getPretyListString();
	}
}
