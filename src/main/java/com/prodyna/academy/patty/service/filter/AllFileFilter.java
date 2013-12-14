package com.prodyna.academy.patty.service.filter;

import com.prodyna.academy.patty.domain.File;
import com.prodyna.academy.patty.domain.Node;

/**
 * return true for all Files
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class AllFileFilter implements Filter {

	@Override
	public boolean matches(Node aNode) {
		return (aNode instanceof File);
	}
}
