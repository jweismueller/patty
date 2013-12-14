package com.prodyna.academy.patty.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.prodyna.academy.patty.service.filter.Filter;

/**
 * return true in case of an match of filename
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class FilenameFilter implements Filter {
	private String filenamePattern;
	
	private Pattern pattern;
	
	public FilenameFilter(String filenamePattern) {
		this.filenamePattern = filenamePattern;
		pattern = Pattern.compile(filenamePattern);
	}

	@Override
	public boolean matches(Node aNode) {
		String nodeName = aNode.getName();
		Matcher matcher = pattern.matcher(nodeName);
		return matcher.matches();
	}

	public String getFilename() {
		return filenamePattern;
	}
}
