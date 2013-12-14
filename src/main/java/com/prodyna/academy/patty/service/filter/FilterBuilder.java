package com.prodyna.academy.patty.service.filter;

import com.prodyna.academy.patty.domain.FileType;

public class FilterBuilder {
	
	private Filter resultFilter;
	
	public FilenameFilter buildFilenameFilter(String filenamePattern) {
		return new FilenameFilter(filenamePattern);
	}
	
	public SizeFilter buildSizeFilter() {
		return new SizeFilter();
	}
	
	public AndFilter buildAndFilter(Filter criterion1, Filter criterion2) {
		return new AndFilter(criterion1, criterion2);
	}
	
	public OrFilter buildOrFilter(Filter criterion1, Filter criterion2) {
		return new OrFilter(criterion1, criterion2);
	}
	
	public FiletypeFilter buildFiletypeFilter(FileType fileType) {
		return new FiletypeFilter(fileType);
	}
	
	public Filter and(Filter criterion) {
		resultFilter = new AndFilter(resultFilter, criterion);
		return resultFilter;
	}
	
	public Filter or(Filter criterion) {
		resultFilter = new OrFilter(resultFilter, criterion);
		return resultFilter;
	}
}
