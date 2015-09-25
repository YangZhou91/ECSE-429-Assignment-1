package ca.mcgill.ecse429.conformancetest.generator;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AbstractDocument.LeafElement;

import ca.mcgill.ecse429.conformancetest.statemodel.State;
import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.Transition;
import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;
import net.vivin.GenericTree;
import net.vivin.GenericTreeNode;

public class TestGenerator {
	
	public static StateMachine _sm;
	public static GenericTree<State> _roundPathTree;
	
	public static void main(String[] args) {
		
		// Load the xml file to state machine
		PersistenceStateMachine.loadStateMachine("ccoinbox.xml");
		_sm = StateMachine.getInstance();
		buildRoundPathTree();
	}
	
	/**
	 * Build the roundPathTree by given the state machine
	 */
	static <T> void buildRoundPathTree(){
		
		if (_sm == null) {
			_sm = StateMachine.getInstance();
		}
		
		// Init a RoundPathTree tree
		_roundPathTree = new GenericTree<>();
		for (State _state : _sm.getStates()) {
			
			// initial state
			if (_state.equals(_sm.getStartState())) {
				setRoot(_state);
				
				List<StateTreeNode<State>> _children = findChildren((StateTreeNode<State>) _roundPathTree.getRoot());
				for (StateTreeNode<State> _child : _children) {
					setChild((StateTreeNode<State>)_roundPathTree.getRoot(), _child);
				}
				
			}
			// Other states
			else{
				List<StateTreeNode<State>> _parents = findParents(childNode)
			}
		}
		
		
		System.out.println("Root's child:" + _roundPathTree.getRoot().getNumberOfChildren());
		System.out.println("Root's child name: " + _roundPathTree.getRoot().getChildAt(0).getData().getName());
	}
	
	/**
	 * Find all transitions from a particular state
	 * @param aState any state
	 * @return a list contain all transition from aState
	 */
	static List<Transition> findTransitionsFromState(State aState){
		
		List<Transition> _resultTransitions = new ArrayList<>();
		List<Transition> _allTransitions = _sm.getTransitions();

		String _targetStateName = aState.getName();
		for (Transition transition : _allTransitions) {
			String fromName = transition.getFrom().getName();
			if (fromName.equals(_targetStateName)) {
				_resultTransitions.add(transition);
			}
			else{
				// do nothing
			}
		}
		return _resultTransitions;
	}
	
	static List<Transition> findTransitionsToState(State aState){
		List<Transition> _resultTransitions = new ArrayList<>();
		List<Transition> _allTransitions = _sm.getTransitions();

		String _targetStateName = aState.getName();
		for (Transition transition : _allTransitions) {
			String toState = transition.getTo().getName();
			if (toState.equals(_targetStateName)) {
				_resultTransitions.add(transition);
			}
			else{
				// do nothing
			}
		}
		return _resultTransitions;
	}
	
	static void setRoot(State rootState){
		if (_roundPathTree == null) {
			_roundPathTree = new GenericTree<>();
		}
		// Create tree node
		StateTreeNode<State> _root = new StateTreeNode<>();
		_root.setData(rootState);
		
		_roundPathTree.setRoot(_root);
	}
	
	static void setChild(State parentNode, State childNode){
		StateTreeNode<State> _parentNode = new StateTreeNode<>();
		StateTreeNode<State> _childNode = new StateTreeNode<>();
		
		_parentNode.setData(parentNode);
		_childNode.setData(childNode);
		
		setChild(_parentNode, _childNode);
		
	}
	
	static void setChild(StateTreeNode<State> parentNode, StateTreeNode<State> childNode){
		
		parentNode.addChild(childNode);
	}
	
	static List<StateTreeNode<State>> findChildren(StateTreeNode<State> parentNode){
		
		List<Transition> _fromThisState = findTransitionsFromState(parentNode.getData());
		List<StateTreeNode<State>> _children = new ArrayList<>();
		
		for (Transition _transition : _fromThisState) {
			StateTreeNode<State> _child = new StateTreeNode<>();
			_child.setData(_transition.getTo());
			_children.add(_child);
		}
		
		return _children;
	}
	
	static List<StateTreeNode<State>>  findParents(State aState){
		return null;
	}
	
	// This method is a little misleading.
	// It should be a state can have multiple parents instead of node
	static List<StateTreeNode<State>> findParents(StateTreeNode<State> childNode){
		
		List<Transition> _toThisState = findTransitionsToState(childNode.getData());
		List<StateTreeNode<State>> _parents = new ArrayList<>();
		
		for (Transition _transition : _toThisState) {
			StateTreeNode<State> _parent = new StateTreeNode<>();
			_parent.setData(_transition.getFrom());
			_parents.add(_parent);
		}
		return _parents;
	}
}
