package tests;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.Hand;
import scoring.ScoreEquations2;

public class TestScore2 {
	static ScoreEquations2 newTest;
	static Hand testHand;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testHand = new Hand(5, 6);
		newTest = new ScoreEquations2(testHand);
		
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
	public void testCountHand() {
		HashMap<String, Integer> testHandValues = new HashMap<>();
		testHandValues.put("1", 1);
		testHandValues.put("2", 1);
		testHandValues.put("3", 1);
		testHandValues.put("4", 0);
		testHandValues.put("5", 2);
		
		while (testHand.diceInHand.get(0).readFaceUp() != 1){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 2){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 3){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 5){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 5){
			testHand.rollDie(4);
		}
		newTest.countHand(testHand);
		
		assertEquals(testHandValues.get("1"), newTest.handValues.get("1"));
		assertEquals(testHandValues.get("2"), newTest.handValues.get("2"));
		assertEquals(testHandValues.get("3"), newTest.handValues.get("3"));
		assertEquals(testHandValues.get("4"), newTest.handValues.get("4"));
		assertEquals(testHandValues.get("5"), newTest.handValues.get("5"));
	}

}
