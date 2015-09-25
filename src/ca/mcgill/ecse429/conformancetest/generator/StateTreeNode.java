package ca.mcgill.ecse429.conformancetest.generator;

import net.vivin.GenericTreeNode;

/**
 * Tree Node has leaf attribute
 * @author Yang Zhou(260401719)
 * Yan Liu
 *
 * @param <T>
 */
public class StateTreeNode<T> extends GenericTreeNode<T> {
	
	public boolean isLeaf;

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	
}
