package testYahtzee;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.Die;
import business.Hand;

public class TestHand {
	
	static Hand myHand;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		myHand = new Hand();
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
	public void testHandNotNull() {
		assertNotNull(myHand);
	}
	
	@Test
	public void testRollAndReadHand() {
		int result;
		myHand.roll(0);
		result = myHand.readFaceUp(0);
		assertTrue(result >= 1 && result <= 6);
		myHand.roll(1);
		result = myHand.readFaceUp(1);
		assertTrue(result >= 1 && result <= 6);
		myHand.roll(2);
		result = myHand.readFaceUp(2);
		assertTrue(result >= 1 && result <= 6);
		myHand.roll(3);
		result = myHand.readFaceUp(3);
		assertTrue(result >= 1 && result <= 6);
		myHand.roll(4);
		result = myHand.readFaceUp(4);
		assertTrue(result >= 1 && result <= 6);
	}
	
	@Test
	public void testRollAllAndReadHand() {
		int result;
		myHand.rollAll();
		result = myHand.readFaceUp(0);
		assertTrue(result >= 1 && result <= 6);
		result = myHand.readFaceUp(1);
		assertTrue(result >= 1 && result <= 6);
		result = myHand.readFaceUp(2);
		assertTrue(result >= 1 && result <= 6);
		result = myHand.readFaceUp(3);
		assertTrue(result >= 1 && result <= 6);
		result = myHand.readFaceUp(4);
		assertTrue(result >= 1 && result <= 6);
	}
	
	@Test
	public void testSortItems() {
		myHand.rollAll();
		myHand.sortItems();
		
		assertTrue(myHand.fiveDice.get(0).readFaceUp() <= myHand.fiveDice.get(1).readFaceUp());
		assertTrue(myHand.fiveDice.get(1).readFaceUp() <= myHand.fiveDice.get(2).readFaceUp());
		assertTrue(myHand.fiveDice.get(2).readFaceUp() <= myHand.fiveDice.get(3).readFaceUp());
		assertTrue(myHand.fiveDice.get(3).readFaceUp() <= myHand.fiveDice.get(4).readFaceUp());
	}
	
	//TODO complete print hand test
	@Test
	public void testPrintHand() {
		
	}

}
