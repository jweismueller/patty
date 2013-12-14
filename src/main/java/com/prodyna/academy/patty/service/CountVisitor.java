package com.prodyna.academy.patty.service;

import com.prodyna.academy.patty.domain.ImageFile;
import com.prodyna.academy.patty.domain.TextFile;
import com.prodyna.academy.patty.domain.VideoFile;

/**
 * visit all nodes in hierarchy and count if filter matches
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class CountVisitor extends BasicVisitor implements Visitor {
	private int countResult;
	private Filter filter;
	
	/* (non-Javadoc)
	 * @see com.prodyna.academy.patty.service.Visitor#visit(com.prodyna.academy.patty.domain.ImageFile)
	 */
	@Override
	public void visit(final ImageFile file) {
		if(filter.matches(file)) {
			countResult++;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.prodyna.academy.patty.service.Visitor#visit(com.prodyna.academy.patty.domain.TextFile)
	 */
	@Override
	public void visit(final TextFile file) {
		if(filter.matches(file)) {
			countResult++;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.prodyna.academy.patty.service.Visitor#visit(com.prodyna.academy.patty.domain.VideoFile)
	 */
	@Override
	public void visit(final VideoFile file) {
		if(filter.matches(file)) {
			countResult++;
		}
	}

	public int getCountResult() {
		return countResult;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}
}