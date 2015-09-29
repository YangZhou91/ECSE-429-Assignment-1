package ca.mcgill.ecse429.conformancetest.generator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


import ca.mcgill.ecse429.conformancetest.statemodel.State;
import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.Transition;
import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;
import net.vivin.GenericTree;
import net.vivin.GenericTreeNode;

public class RoundPathTreeGenerator {
	
	public static StateMachine _sm;
	public static GenericTree<String> _roundPathTree;
	
	public static final String CCOIN = "ccoinbox.xml";
	
	public static void main(String[] args) {
		
		PersistenceStateMachine.loadStateMachine(CCOIN);
		_sm = StateMachine.getInstance();
		_roundPathTree = new GenericTree<>();
		// set root
		GenericTreeNode<String> _root = new GenericTreeNode<>();
		_root.setData(_sm.getStartState().getName());
		_roundPathTree.setRoot(_root);
		
		
		buildRoundPathTree(_root);
		printTree(_roundPathTree);
	}
	
	static void buildRoundPathTree(GenericTreeNode<String> aNode){
		if (_sm == null) {
			_sm = StateMachine.getInstance();
		}
		for (Transition transition : getOutTransitions(aNode.getData())) {
			State nextState = transition.getTo();
			GenericTreeNode<String> childNode = new GenericTreeNode<>();
			childNode.setData(nextState.getName());
			aNode.addChild(childNode);
			boolean isTerminal = isTerminal(childNode);
			
			if (!isTerminal) {
				buildRoundPathTree(childNode);
			}
		}
	}
	
	static boolean isTerminal(GenericTreeNode<String> aNode){
		boolean isTerminal = false;
		if (aNode.equals(_roundPathTree.getRoot())) {
			return false;
		}
		GenericTreeNode<String> parentNode = aNode.getParent();
		
		while (!parentNode.equals(_roundPathTree.getRoot())) {
			if (aNode.equals(parentNode)) {
				return true;
			}
			else{
				parentNode = (GenericTreeNode<String>) parentNode.getParent();
			}
		}
		return isTerminal;
		
	}
	
	static List<Transition> getOutTransitions (String stateName){
		
		ArrayList<Transition> _outTransitions = new ArrayList<>();
		for (Transition transition : _sm.getTransitions()) {
			if (transition.getFrom().getName().equals(stateName)) {
				_outTransitions.add(transition);
			}
		}
		
		return _outTransitions;
	}
	
	static void printTree(GenericTree<String> tree){
		Queue<GenericTreeNode<String>> currentLevel = new LinkedList<>();
		Queue<GenericTreeNode<String>> nextLevel = new LinkedList<>();
		
		currentLevel.add(tree.getRoot());
		while (!currentLevel.isEmpty()) {
			Iterator<GenericTreeNode<String>> iter = currentLevel.iterator();
			while (iter.hasNext()) {
				GenericTreeNode<String> currentNode = iter.next();
				if (!currentNode.getChildren().isEmpty()) {
					for (GenericTreeNode<String> childNode : currentNode.getChildren()) {
						nextLevel.add(childNode);
					}
				}
				System.out.println(currentNode);
			}
			System.out.println();
			currentLevel = nextLevel;
			nextLevel = new LinkedList<>();
		}
	}
}