package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.Hand;

public class TestHand {
	
	static Hand myHand;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		myHand = new Hand(5, 6);
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
		myHand.rollDie(0);
		result = myHand.readDie(0);
		assertTrue(result >= 1 && result <= 6);
		myHand.rollDie(1);
		result = myHand.readDie(1);
		assertTrue(result >= 1 && result <= 6);
		myHand.rollDie(2);
		result = myHand.readDie(2);
		assertTrue(result >= 1 && result <= 6);
		myHand.rollDie(3);
		result = myHand.readDie(3);
		assertTrue(result >= 1 && result <= 6);
		myHand.rollDie(4);
		result = myHand.readDie(4);
		assertTrue(result >= 1 && result <= 6);
	}
	
	@Test
	public void testRollAllAndReadHand() {
		int result;
		myHand.rollAll();
		result = myHand.readDie(0);
		assertTrue(result >= 1 && result <= 6);
		result = myHand.readDie(1);
		assertTrue(result >= 1 && result <= 6);
		result = myHand.readDie(2);
		assertTrue(result >= 1 && result <= 6);
		result = myHand.readDie(3);
		assertTrue(result >= 1 && result <= 6);
		result = myHand.readDie(4);
		assertTrue(result >= 1 && result <= 6);
	}
	
	@Test
	public void testSortItems() {
		myHand.rollAll();
		myHand.sortItems();
		
		assertTrue(myHand.diceInHand.get(0).readFaceUp() <= myHand.diceInHand.get(1).readFaceUp());
		assertTrue(myHand.diceInHand.get(1).readFaceUp() <= myHand.diceInHand.get(2).readFaceUp());
		assertTrue(myHand.diceInHand.get(2).readFaceUp() <= myHand.diceInHand.get(3).readFaceUp());
		assertTrue(myHand.diceInHand.get(3).readFaceUp() <= myHand.diceInHand.get(4).readFaceUp());
	}

}
