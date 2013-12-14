package com.prodyna.academy.patty.service.filter;

import com.prodyna.academy.patty.domain.File;
import com.prodyna.academy.patty.domain.Node;

public class SizeFilter implements Filter {
	private long min = Long.MIN_VALUE;
	private long max = Long.MAX_VALUE;
	
	SizeFilter min(final long min) {
		this.min = min;
		return this;
	}

	SizeFilter max(final long max) {
		this.max = max;
		return this;
	}

	@Override
	public boolean matches(final Node aNode) {
		if(aNode instanceof File) {
			final File file = (File) aNode;
			final long nodeSize = file.getSize();
			
			return (nodeSize >= min) && (nodeSize <= max);
			
		}
		return false;
	}
}
