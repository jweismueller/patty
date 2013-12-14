package com.prodyna.academy.patty.service.visitor;

import com.prodyna.academy.patty.service.filter.Filter;

/**
 * visit all nodes in hierarchy and count if filter matches
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class CountVisitor extends SearchVisitor implements Visitor {

	public CountVisitor(){
		
	}
	
	public CountVisitor(Filter filter){
		super(filter);
	}

	public int getCountResult() {
		return getResults().size();
	}

}