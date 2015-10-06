package ca.mcgill.ecse429.conformancetest.generator;

import ca.mcgill.ecse429.conformancetest.statemodel.Transition;

public class NodeData {
	
	String nodeName;
	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public Transition getTransition() {
		return transition;
	}

	public void setTransition(Transition transition) {
		this.transition = transition;
	}

	Transition transition;
	
	public NodeData(String name, Transition transition) {
		this.nodeName = name;
		this.transition = transition;
		
	}

}
