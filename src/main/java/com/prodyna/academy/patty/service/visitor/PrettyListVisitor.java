/**
 * 
 */
package com.prodyna.academy.patty.service.visitor;

import java.io.File;

import com.prodyna.academy.patty.domain.Folder;
import com.prodyna.academy.patty.domain.ImageFile;
import com.prodyna.academy.patty.domain.TextFile;
import com.prodyna.academy.patty.domain.VideoFile;

/**
 * @author aheizenreder
 * 
 */
public class PrettyListVisitor extends BasicVisitor implements Visitor {

	private static final int DEFAULT_NUM_OF_MOVES = 2;

	private static final String DEFAULT_MOVE_STRING = " ";

	private StringBuilder prefixBuilder;

	private int numOfMoves;

	private String move;

	private StringBuilder result;

	public PrettyListVisitor() {
		super();
		prefixBuilder = new StringBuilder();
		result = new StringBuilder();
		numOfMoves = DEFAULT_NUM_OF_MOVES;
		move = DEFAULT_MOVE_STRING;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.service.BasicVisitor#visit(com.prodyna.academy
	 * .patty.domain.ImageFile)
	 */
	@Override
	public void visit(ImageFile file) {
		printNameLine(file.getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.service.BasicVisitor#visit(com.prodyna.academy
	 * .patty.domain.TextFile)
	 */
	@Override
	public void visit(TextFile file) {
		printNameLine(file.getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.service.BasicVisitor#visit(com.prodyna.academy
	 * .patty.domain.VideoFile)
	 */
	@Override
	public void visit(VideoFile file) {
		printNameLine(file.getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.academy.patty.service.BasicVisitor#visit(com.prodyna.academy
	 * .patty.domain.Folder)
	 */
	@Override
	public void visit(Folder folder) {
		printNameLine(folder);
		// add moves to the prefix
		addMoves();
		// go trough children
		super.visit(folder);
		// remove moves from prefix
		removeMoves();
	}

	/**
	 * @return the numOfMoves
	 */
	public int getNumOfMoves() {
		return numOfMoves;
	}

	/**
	 * @param numOfMoves
	 *            the numOfMoves to set
	 */
	public void setNumOfMoves(int numOfMoves) {
		this.numOfMoves = numOfMoves;
	}

	/**
	 * @return the move
	 */
	public String getMove() {
		return move;
	}

	/**
	 * @return the result
	 */
	public String getPretyListString() {
		return result.toString();
	}

	/**
	 * @param move
	 *            the move to set
	 */
	public void setMove(String move) {
		this.move = move;
	}

	private void addMoves() {
		for (int i = 0; i < numOfMoves; i++) {
			prefixBuilder.append(move);
		}
	}

	/**
	 * removes number of characters corresponds to the value of getNumOfMoves()
	 * from the end of prefix.
	 */
	private void removeMoves() {
		for (int i = 0; i < numOfMoves; i++) {
			prefixBuilder.deleteCharAt(prefixBuilder.length() - 1);
		}
	}

	/**
	 * @param file
	 */
	private void printNameLine(String fileName) {
		result.append(prefixBuilder.toString());
		result.append(fileName);
		result.append(System.lineSeparator());
	}

	private void printNameLine(Folder folder) {
		result.append(prefixBuilder.toString());
		result.append(folder.getName());
		result.append(File.separator);
		result.append(System.lineSeparator());
	}

}
