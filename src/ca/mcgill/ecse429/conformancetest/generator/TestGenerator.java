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
		
		GenericTree<State> _roundPathTree = new GenericTree<>();
		
		// Create Root for the tree
		GenericTreeNode<State> _root = new GenericTreeNode<>();
		_root.setData(_sm.getStartState());
		_roundPathTree.setRoot(_root);
		
		List<Transition> _transition = findTransitionsFromState(_sm.getState(1));
		System.out.println(_transition.toString());
	}
	
	/**
	 * Find all transitions for a particular state
	 * @param aState
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
	
	
}
