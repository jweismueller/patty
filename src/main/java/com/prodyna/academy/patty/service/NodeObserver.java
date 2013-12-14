/**
 * 
 */
package com.prodyna.academy.patty.service;

import com.prodyna.academy.patty.domain.EventMessage;
import com.prodyna.academy.patty.domain.Node;

/**
 * Interface for file observer
 * 
 * @author aheizenreder
 *
 */
public interface NodeObserver {

	void notifyObserver(Node aNode, EventMessage message);
}
