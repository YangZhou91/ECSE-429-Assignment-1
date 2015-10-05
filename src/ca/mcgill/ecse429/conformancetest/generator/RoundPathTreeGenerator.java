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
	public static GenericTree<String> roundPathTree;

	public RoundPathTreeGenerator(String fileName) {
		// load xml
		PersistenceStateMachine.loadStateMachine(fileName);
		_sm = StateMachine.getInstance();
		roundPathTree = new GenericTree<>();
		// set root
		GenericTreeNode<String> _root = new GenericTreeNode<>();
		_root.setData(_sm.getStartState().getName());
		roundPathTree.setRoot(_root);

		buildRoundPathTree(_root);
	}

	public static GenericTree<String> getRoundPathTree() {
		return roundPathTree;
	}
	
	public StateMachine getSM() {
		return _sm;
	}

	public static void setRoundPathTree(GenericTree<String> _roundPathTree) {
		RoundPathTreeGenerator.roundPathTree = _roundPathTree;
	}

	/**
	 * Generate a round path tree by specified root
	 * 
	 * @param rootNode
	 *            root node
	 */
	static void buildRoundPathTree(GenericTreeNode<String> rootNode) {
		if (_sm == null) {
			_sm = StateMachine.getInstance();
		}
		for (Transition transition : getOutTransitions(rootNode.getData())) {
			State nextState = transition.getTo();
			GenericTreeNode<String> childNode = new GenericTreeNode<>();
			childNode.setData(nextState.getName());
			rootNode.addChild(childNode);
			boolean isTerminal = isTerminal(childNode);

			if (!isTerminal) {
				buildRoundPathTree(childNode);
			}
		}
	}

	// Find all round trip path tree
	public List<List<Transition>> findTestCases() {
		List <Transition> unmodifiableTransitions = StateMachine.getInstance().getTransitions();
		List<Transition> allTransitions = new ArrayList<Transition>();
		for (int i = 0; i < unmodifiableTransitions.size(); ++i) {
			allTransitions.add(unmodifiableTransitions.get(i));
		}
		
		List<State> states_checked = new ArrayList<State>();
		List<Transition> processed_transition = new ArrayList<Transition>();
		List<List<Transition>> RoundTripPaths = new ArrayList<List<Transition>>(); 
		State currentState;
		boolean pathFound;
		List <State> FinalStates = new ArrayList<State>();
		boolean isFinalState;
		List <State> PotentialFinalStates = new ArrayList<State>();
		for (int i = 0; i < allTransitions.size(); ++i) {
			PotentialFinalStates.add(allTransitions.get(i).getTo());
		}
		
		for (int i = 0; i < PotentialFinalStates.size(); ++i) {
			isFinalState = true;
			for (int j = 0; j < allTransitions.size(); ++j) {
				if (PotentialFinalStates.get(i).equals(allTransitions.get(j).getFrom())) {
					isFinalState = false;
				}
			}
			if (isFinalState) {
				FinalStates.add(PotentialFinalStates.get(i));
			}
		}

		do {
			currentState = _sm.getStartState();
			processed_transition = new ArrayList<Transition>();
			states_checked.clear();
			states_checked.add(currentState);
			pathFound = false;

			for (int i = 0; i < allTransitions.size(); ++i) {
				if (allTransitions.get(i).getFrom().getName().equals(currentState.getName()) == true) {
					processed_transition.add(allTransitions.get(i));
					currentState = allTransitions.get(i).getTo();

					if (states_checked.contains(currentState) || FinalStates.contains(currentState)) {
						allTransitions.remove(i);
						pathFound = true;
						i = -1;
						break;
					} else {
						states_checked.add(currentState);
						i = -1;
					}
				}
			}

			if (pathFound == false) {
				allTransitions.remove(processed_transition.get(processed_transition.size() - 1));
			} else {
				RoundTripPaths.add(processed_transition);
			}
		} while (allTransitions.size() > 0);
		return RoundTripPaths;
	}

	/**
	 * To determine whether a node is a terminal node
	 * 
	 * @param aNode
	 * @return true if it is a terminal
	 */
	static boolean isTerminal(GenericTreeNode<String> aNode) {
		boolean isTerminal = false;
		if (aNode.equals(roundPathTree.getRoot())) {
			return false;
		}
		GenericTreeNode<String> parentNode = aNode.getParent();

		while (!parentNode.equals(roundPathTree.getRoot())) {
			if (aNode.equals(parentNode)) {
				return true;
			} else {
				parentNode = (GenericTreeNode<String>) parentNode.getParent();
			}
		}
		return isTerminal;

	}

	/**
	 * Get all transitions go out from a state
	 * 
	 * @param stateName
	 * @return a list of transitions
	 */
	static List<Transition> getOutTransitions(String stateName) {

		ArrayList<Transition> _outTransitions = new ArrayList<>();
		for (Transition transition : _sm.getTransitions()) {
			if (transition.getFrom().getName().equals(stateName)) {
				_outTransitions.add(transition);
			}
		}

		return _outTransitions;
	}

	/**
	 * Print tree by the level order
	 * 
	 * @param tree
	 */
	static void printTree(GenericTree<String> tree) {
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