package ca.mcgill.ecse429.conformancetest.ccoinbox;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GeneratedTestCCoinBox {
protected CCoinBox SM;

@Before
public void setUp() throws Exception {
SM = new CCoinBox();
}

@After
public void tearDown() throws Exception {
SM = null;
}

@Test
public void conformanceTest1() {
assertTrue(SM.getStateFullName().equals("empty"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("notAllowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("notAllowed"));
}

@Test
public void conformanceTest2() {
assertTrue(SM.getStateFullName().equals("empty"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("notAllowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("notAllowed"));
}

@Test
public void conformanceTest3() {
assertTrue(SM.getStateFullName().equals("empty"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("notAllowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("notAllowed"));
}

@Test
public void conformanceTest4() {
assertTrue(SM.getStateFullName().equals("empty"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("notAllowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("notAllowed"));
}

@Test
public void conformanceTest5() {
assertTrue(SM.getStateFullName().equals("empty"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("notAllowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.vend();
assertTrue(SM.getStateFullName().equals("empty"));
SM.vend();
assertTrue(SM.getStateFullName().equals("notAllowed"));
SM.vend();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("notAllowed"));
}

@Test
public void conformanceTest6() {
assertTrue(SM.getStateFullName().equals("empty"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("notAllowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.vend();
assertTrue(SM.getStateFullName().equals("empty"));
SM.vend();
assertTrue(SM.getStateFullName().equals("notAllowed"));
SM.vend();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("notAllowed"));
}

@Test
public void conformanceTest7() {
assertTrue(SM.getStateFullName().equals("empty"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("notAllowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.vend();
assertTrue(SM.getStateFullName().equals("empty"));
SM.vend();
assertTrue(SM.getStateFullName().equals("notAllowed"));
SM.vend();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.vend();
assertTrue(SM.getStateFullName().equals("empty"));
SM.vend();
assertTrue(SM.getStateFullName().equals("notAllowed"));
SM.vend();
assertTrue(SM.getStateFullName().equals("allowed"));
}

@Test
public void conformanceTest8() {
assertTrue(SM.getStateFullName().equals("empty"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("notAllowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.vend();
assertTrue(SM.getStateFullName().equals("empty"));
SM.vend();
assertTrue(SM.getStateFullName().equals("notAllowed"));
SM.vend();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("notAllowed"));
}

@Test
public void conformanceTest9() {
assertTrue(SM.getStateFullName().equals("empty"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("notAllowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.vend();
assertTrue(SM.getStateFullName().equals("empty"));
SM.vend();
assertTrue(SM.getStateFullName().equals("notAllowed"));
SM.vend();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("allowed"));
}

@Test
public void conformanceTest10() {
assertTrue(SM.getStateFullName().equals("empty"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("notAllowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.vend();
assertTrue(SM.getStateFullName().equals("empty"));
SM.vend();
assertTrue(SM.getStateFullName().equals("notAllowed"));
SM.vend();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.returnQtrs();
assertTrue(SM.getStateFullName().equals("empty"));
SM.reset();
assertTrue(SM.getStateFullName().equals("empty"));
SM.addQtr();
assertTrue(SM.getStateFullName().equals("allowed"));
SM.vend();
assertTrue(SM.getStateFullName().equals("empty"));
SM.vend();
assertTrue(SM.getStateFullName().equals("notAllowed"));
SM.vend();
assertTrue(SM.getStateFullName().equals("allowed"));
}

}
