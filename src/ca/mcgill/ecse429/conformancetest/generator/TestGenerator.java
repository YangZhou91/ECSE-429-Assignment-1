package ca.mcgill.ecse429.conformancetest.generator;

import java.util.ArrayList;
import java.util.List;

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
		
		_roundPathTree = new GenericTree<>();
		
		
		
		System.out.println("Root's child:" + _roundPathTree.getRoot().getNumberOfChildren());
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
}
