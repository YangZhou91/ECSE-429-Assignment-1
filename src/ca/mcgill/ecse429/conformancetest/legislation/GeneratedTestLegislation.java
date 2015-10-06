package ca.mcgill.ecse429.conformancetest.legislation;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GeneratedTestLegislation {
protected Legislation SM;

@Before
public void setUp() throws Exception {
SM = new Legislation();
}

@After
public void tearDown() throws Exception {
SM = null;
}

@Test
public void conformanceTest1() {
assertTrue(SM.getStateFullName().equals("inPreparation"));
SM.introduceInSenate();
assertTrue(SM.getStateFullName().equals("inSenate"));
SM.voteFails();
assertTrue(SM.getStateFullName().equals("inPreparation"));
}

@Test
public void conformanceTest2() {
assertTrue(SM.getStateFullName().equals("inPreparation"));
SM.introduceInSenate();
assertTrue(SM.getStateFullName().equals("inSenate"));
SM.votePasses();
assertTrue(SM.getStateFullName().equals("inHouseOfCommons"));
SM.voteFails();
assertTrue(SM.getStateFullName().equals("inPreparation"));
}

@Test
public void conformanceTest3() {
assertTrue(SM.getStateFullName().equals("inPreparation"));
SM.introduceInSenate();
assertTrue(SM.getStateFullName().equals("inSenate"));
SM.votePasses();
assertTrue(SM.getStateFullName().equals("inHouseOfCommons"));
SM.votePasses();
assertTrue(SM.getStateFullName().equals("inSenate"));
}

@Test
public void conformanceTest4() {
assertTrue(SM.getStateFullName().equals("inPreparation"));
SM.introduceInSenate();
assertTrue(SM.getStateFullName().equals("inSenate"));
SM.votePasses();
assertTrue(SM.getStateFullName().equals("inHouseOfCommons"));
SM.votePasses();
assertTrue(SM.getStateFullName().equals("finalized"));
}

@Test
public void conformanceTest5() {
assertTrue(SM.getStateFullName().equals("inPreparation"));
SM.introduceInSenate();
assertTrue(SM.getStateFullName().equals("inSenate"));
SM.votePasses();
assertTrue(SM.getStateFullName().equals("finalized"));
}

@Test
public void conformanceTest6() {
assertTrue(SM.getStateFullName().equals("inPreparation"));
SM.introduceInHouse();
assertTrue(SM.getStateFullName().equals("inHouseOfCommons"));
SM.voteFails();
assertTrue(SM.getStateFullName().equals("inPreparation"));
}

@Test
public void conformanceTest7() {
assertTrue(SM.getStateFullName().equals("inPreparation"));
SM.introduceInHouse();
assertTrue(SM.getStateFullName().equals("inHouseOfCommons"));
SM.votePasses();
assertTrue(SM.getStateFullName().equals("inSenate"));
SM.voteFails();
assertTrue(SM.getStateFullName().equals("inPreparation"));
}

@Test
public void conformanceTest8() {
assertTrue(SM.getStateFullName().equals("inPreparation"));
SM.introduceInHouse();
assertTrue(SM.getStateFullName().equals("inHouseOfCommons"));
SM.votePasses();
assertTrue(SM.getStateFullName().equals("inSenate"));
SM.votePasses();
assertTrue(SM.getStateFullName().equals("inHouseOfCommons"));
}

@Test
public void conformanceTest9() {
assertTrue(SM.getStateFullName().equals("inPreparation"));
SM.introduceInHouse();
assertTrue(SM.getStateFullName().equals("inHouseOfCommons"));
SM.votePasses();
assertTrue(SM.getStateFullName().equals("inSenate"));
SM.votePasses();
assertTrue(SM.getStateFullName().equals("finalized"));
}

@Test
public void conformanceTest10() {
assertTrue(SM.getStateFullName().equals("inPreparation"));
SM.introduceInHouse();
assertTrue(SM.getStateFullName().equals("inHouseOfCommons"));
SM.votePasses();
assertTrue(SM.getStateFullName().equals("finalized"));
}

}
