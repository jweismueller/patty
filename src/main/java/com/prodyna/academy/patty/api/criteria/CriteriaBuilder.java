package com.prodyna.academy.patty.api.criteria;

import java.util.Stack;

import com.prodyna.academy.patty.api.criteria.SizeCriterion.OP;

public class CriteriaBuilder {

	private Stack<Criterion> collect = new Stack<>();

	public static CriteriaBuilder get() {
		return new CriteriaBuilder();
	}

	public CriteriaBuilder and() {
		AndCriterion c = new AndCriterion(collect.pop(), collect.pop());
		collect.push(c);
		return this;
	}

	public CriteriaBuilder or() {
		OrCriterion c = new OrCriterion(collect.pop(), collect.pop());
		collect.push(c);
		return this;
	}

	public Criterion getCriteria() {
		return collect.peek();
	}

	public CriteriaBuilder regex(String r) {
		ContentCriterion c = new ContentCriterion(r);
		collect.push(c);
		return this;
	}

	public CriteriaBuilder name(String r) {
		NameCriterion c = new NameCriterion(r);
		collect.push(c);
		return this;
	}

	public CriteriaBuilder sizeLe(int size) {
		SizeCriterion c = new SizeCriterion(size, OP.LE);
		collect.push(c);
		return this;
	}

	public CriteriaBuilder sizeGe(int size) {
		SizeCriterion c = new SizeCriterion(size, OP.GE);
		collect.push(c);
		return this;
	}

}
