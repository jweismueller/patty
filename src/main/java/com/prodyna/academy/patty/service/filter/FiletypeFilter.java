package com.prodyna.academy.patty.service.filter;

import com.prodyna.academy.patty.domain.FileType;
import com.prodyna.academy.patty.domain.Node;

/**
 * return true in case node is a ImageFile
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class FiletypeFilter implements Filter {
	
	private FileType filetype;

	FiletypeFilter(FileType filetype) {
		super();
		this.filetype = filetype;
	}

	/**
	 * checks the node to be a image file.
	 * 
	 * @param aNode
	 *            a node instance to check.
	 * 
	 * @return true if the node is a image file, else false.
	 */
	@Override
	public boolean matches(final Node aNode) {
		return aNode.getType().equals(filetype);
	}
}
