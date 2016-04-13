package testYahtzee;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.Die;
import business.Hand;

public class TestDie {
	
	static Die myDie;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		myDie = new Die();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDieNotNull() {
		assertNotNull(myDie);
	}
	
	@Test
	public void testRollAndRead() {
		myDie.roll();
		int result = myDie.readFaceUp();
		assertTrue(result >= 1 && result <= 6);
	}
	
	@Test
	public void testDieVisual() {
		String row;
		row = myDie.dieVisual1(5);
		assertEquals("o   o", row);
		row = myDie.dieVisual2(5);
		assertEquals("  o  ", row);
		row = myDie.dieVisual3(5);
		assertEquals("o   o", row);
	}
	
}
