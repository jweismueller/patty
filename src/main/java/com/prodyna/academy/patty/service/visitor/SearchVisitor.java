/**
 * 
 */
package com.prodyna.academy.patty.service.visitor;

import java.util.HashSet;
import java.util.Set;

import com.prodyna.academy.patty.domain.Folder;
import com.prodyna.academy.patty.domain.ImageFile;
import com.prodyna.academy.patty.domain.Node;
import com.prodyna.academy.patty.domain.TextFile;
import com.prodyna.academy.patty.domain.VideoFile;
import com.prodyna.academy.patty.service.filter.Filter;

/**
 * @author aheizenreder
 * 
 */
public class SearchVisitor extends BasicVisitor implements Visitor {

	private Filter filter;

	private Set<Node> results;

	public SearchVisitor() {
		results = new HashSet<Node>();
	}

	public SearchVisitor(Filter filter) {
		this.filter = filter;
		results = new HashSet<Node>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.service.visitor.BasicVisitor#visit(com.prodyna
	 * .academy.patty.domain.ImageFile)
	 */
	@Override
	public void visit(ImageFile file) {
		if (filter.matches(file)) {
			results.add(file);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.service.visitor.BasicVisitor#visit(com.prodyna
	 * .academy.patty.domain.TextFile)
	 */
	@Override
	public void visit(TextFile file) {
		if (filter.matches(file)) {
			results.add(file);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.service.visitor.BasicVisitor#visit(com.prodyna
	 * .academy.patty.domain.VideoFile)
	 */
	@Override
	public void visit(VideoFile file) {
		if (filter.matches(file)) {
			results.add(file);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.service.visitor.BasicVisitor#visit(com.prodyna
	 * .academy.patty.domain.Folder)
	 */
	@Override
	public void visit(Folder folder) {
		// go through child nodes
		super.visit(folder);

		if (filter.matches(folder)) {
			results.add(folder);
		}
	}

	public Set<Node> getResults() {
		return results;
	}

	/**
	 * @return the filter
	 */
	public Filter getFilter() {
		return filter;
	}

	/**
	 * @param filter
	 *            the filter to set
	 */
	public void setFilter(Filter filter) {
		this.filter = filter;
	}
}
