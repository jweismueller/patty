package com.prodyna.academy.patty.api.criteria;

import java.util.regex.Pattern;

import com.prodyna.academy.patty.api.Node;
import com.prodyna.academy.patty.api.TextFile;

public class ContentCriterion extends AbstractCriterion {

	private Pattern p;

	public ContentCriterion(String regex) {
		p = Pattern.compile(regex);
	}

	@Override
	public boolean matches(Node node) {
		if (node instanceof TextFile) {
			TextFile textFile = (TextFile) node;
			return p.matcher(textFile.getContent()).matches();
		} else {
			return false;
		}
	}
}
