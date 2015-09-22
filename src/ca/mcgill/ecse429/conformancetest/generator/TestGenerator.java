package ca.mcgill.ecse429.conformancetest.generator;

import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;
import net.vivin.GenericTree;
import net.vivin.GenericTreeNode;

public class TestGenerator {

	public static void main(String[] args) {
		
		// Load the xml file to state machine
		PersistenceStateMachine.loadStateMachine("ccoinbox.xml");

		// Check state machine
		StateMachine _sm = StateMachine.getInstance();
		System.out.println(_sm.getStartState().getName());
		
		buildTree();
	}
	
	
	static <T> void buildTree(){
		GenericTree<String> _tree = new GenericTree<>();
		GenericTreeNode<String> _root = new GenericTreeNode<>();
		_root.setData("Hello, This is root");
		_tree.setRoot(_root);
		
		System.out.println(_tree.getRoot().toString());
	}
}
