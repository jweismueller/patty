package com.prodyna.academy.patty.service;

import com.prodyna.academy.patty.domain.ImageFile;
import com.prodyna.academy.patty.domain.TextFile;
import com.prodyna.academy.patty.domain.VideoFile;

/**
 * visit all nodes and print attributes if filter matches
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
/**
 * @author aheizenreder
 *
 */
public class PrintVisitor extends BasicVisitor implements Visitor {
	private Filter filter;
	private StringBuffer resultBuffer = new StringBuffer();

	/** 
	 * print informations to a image file matched to the filter.
	 */
	@Override
	public void visit(ImageFile file) {
		if(filter.matches(file)) {
			String parentFolder = file.getParent().getName();
			String name = file.getName();
			long size = file.getSize();
			long height = file.getHeight();
			long width = file.getWidth();
			
			resultBuffer.append("[" + parentFolder + ": ");
			resultBuffer.append(name + " ");
			resultBuffer.append(size + " ");
			resultBuffer.append(height + "x" + width + "] ");
		}
	}

	/** 
	 * print informations to a text file matched to the filter.
	 */
	public void visit(TextFile file) {
		if(filter.matches(file)) {
			String parentFolder = file.getParent().getName();
			String name = file.getName();
			long size = file.getSize();
			String textEncoding = file.getTextEncoding();
			long pageCount = file.getPageCount();
			
			resultBuffer.append("[" + parentFolder + ": ");
			resultBuffer.append(name + " ");
			resultBuffer.append(size + " ");
			resultBuffer.append(textEncoding + " ");
			resultBuffer.append(pageCount + "] ");
		}
	}

	/** 
	 * print informations to a video file matched to the filter.
	 */
	public void visit(VideoFile file) {
		if(filter.matches(file)) {
			String parentFolder = file.getParent().getName();
			String name = file.getName();
			long size = file.getSize();
			long height = file.getHeight();
			long width = file.getWidth();
			
			resultBuffer.append("[" + parentFolder + ": ");
			resultBuffer.append(name);
			resultBuffer.append(size);
			resultBuffer.append(height + "x" + width + "] ");
		}
	}

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public String getResultList() {
		return resultBuffer.toString();
	}
}