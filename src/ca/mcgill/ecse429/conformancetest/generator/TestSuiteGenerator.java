/**
 * ECSE 429 Assignment 1
 * Name: 
 * Yang Zhou(260401719)
 * Yan Liu(260152375)
 */


package ca.mcgill.ecse429.conformancetest.generator;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.Transition;


public class TestSuiteGenerator {
	
	public static void main(String[] args) throws IOException {

//		RoundPathTreeGenerator generator = new RoundPathTreeGenerator("legislation.xml");
		RoundPathTreeGenerator generator = new RoundPathTreeGenerator("ccoinbox.xml");

		
		StateMachine sm;
		sm = StateMachine.getInstance();
		String packageName = sm.getPackageName();
		String className = sm.getClassName();
		String fix_packageName = packageName.replaceAll(Pattern.quote("."), "/");
		String fix_className = className.replaceFirst(Pattern.quote(".java"), "");
		
		
		File file = new File("./src/" + fix_packageName + "/GeneratedTest" + className);
	    file.createNewFile();
	    FileWriter output = new FileWriter(file); 
	    
	    output.write("package " + sm.getPackageName() + ";\n\n"
	    		+ "import static org.junit.Assert.*;\n"
	    		+ "import org.junit.After;\n"
	    		+ "import org.junit.Before;\n"
	    		+ "import org.junit.Test;\n\n");
		
	    output.write("public class GeneratedTest" + fix_className  + " {\n"
	    		+ "protected " + fix_className + " SM;\n\n"
	    		+ "@Before\n"
	    		+ "public void setUp() throws Exception {\n"
	    		+ "SM = new " + fix_className + "();\n"
	    		+ "}\n\n"
	    		+ "@After\n"
	    		+ "public void tearDown() throws Exception {\n"
	    		+ "SM = null;\n"
	    		+ "}\n\n");
	    
	    List<List<Transition>> testCases;
	    
	    testCases = generator.findTestCases();
	    
	    for (int i = 0; i < testCases.size(); ++i) {
		    output.write("@Test\n");
		    output.write("public void conformanceTest" + (i+1) + "() {\n");
		    output.write("assertTrue(SM.getStateFullName().equals(\"" + testCases.get(i).get(0).getTo().getName() + "\"));\n");
		    for (int j = 1; j < testCases.get(i).size(); ++j) {
			    output.write("SM." + testCases.get(i).get(j).getEvent() + "();\n");
			    output.write("assertTrue(SM.getStateFullName().equals(\"" + testCases.get(i).get(j).getTo().getName() + "\"));\n");
		    }
		    output.write("}\n\n");
	    }    
	    output.write("}\n");
	    output.flush();
	    output.close();	
	}

}
