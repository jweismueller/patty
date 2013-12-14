/**
 * 
 */
package com.prodyna.academy.patty.service.filter;

import com.prodyna.academy.patty.domain.Node;

/**
 * @author aheizenreder
 *
 */
public class NoFilter implements Filter {

	/* (non-Javadoc)
	 * @see com.prodyna.academy.patty.service.filter.Filter#matches(com.prodyna.academy.patty.domain.Node)
	 */
	@Override
	public boolean matches(Node aNode) {
		return true;
	}

}
