package com.prodyna.academy.patty.vfs.visitor;

import java.util.ArrayList;
import java.util.List;

import com.prodyna.academy.patty.api.ImageFile;
import com.prodyna.academy.patty.api.Node;
import com.prodyna.academy.patty.api.TextFile;
import com.prodyna.academy.patty.api.VideoFile;
import com.prodyna.academy.patty.api.criteria.Criterion;

public class VfsSearchVisitor extends AbstractVfsVisitor {

	private Criterion criterion;

	private List<Node> results = new ArrayList<>();

	public VfsSearchVisitor(Criterion criterion) {
		this.criterion = criterion;
	}

	@Override
	public void visit(TextFile file) {
		if (criterion.matches(file)) {
			results.add(file);
		}
	}

	@Override
	public void visit(ImageFile file) {
		if (criterion.matches(file)) {
			results.add(file);
		}
	}

	@Override
	public void visit(VideoFile file) {
		if (criterion.matches(file)) {
			results.add(file);
		}
	}

	public List<Node> getResults() {
		return results;
	}

}
