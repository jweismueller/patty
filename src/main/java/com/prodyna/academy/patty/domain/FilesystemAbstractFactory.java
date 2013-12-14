package com.prodyna.academy.patty.domain;

/**
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class FilesystemAbstractFactory {
	
	public static Folder createFolder(String name) {
		return new Folder(name);
	}
	
	public static ImageFile createImageFile(String name, MediaSpecification spec) {
		return new ImageFile(name, spec.getSize(), spec.getHeight(), spec.getWidth());
	}
	
	public static TextFile createTextFile(String name, TextSpecification spec) {
		return new TextFile(name, spec.getSize(), spec.getTextEncoding(), spec.getPageCount());
	}
	
	public static VideoFile createVideoFile(String name, MediaSpecification spec) {
		return new VideoFile(name, spec.getSize(), spec.getHeight(), spec.getWidth());
	}
}
