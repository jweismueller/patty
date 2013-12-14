package com.prodyna.academy.patty.service.filter;

import com.prodyna.academy.patty.domain.ImageFile;
import com.prodyna.academy.patty.domain.Node;

/**
 * return true in case node is a ImageFile
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class ImageFilter implements Filter {

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
		return (aNode instanceof ImageFile);
	}
}
