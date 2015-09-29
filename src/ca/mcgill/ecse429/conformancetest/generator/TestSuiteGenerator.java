package ca.mcgill.ecse429.conformancetest.generator;

import net.vivin.GenericTree;

public class TestSuiteGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoundPathTreeGenerator generator = new RoundPathTreeGenerator("ccoinbox.xml");
		generator.printTree(generator.getRoundPathTree());
	}

}
