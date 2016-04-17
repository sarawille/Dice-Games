package tests;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.Hand;
import scoring.ScoreCategory;
import scoring.ScoreEquations2;

public class TestScore2 {
	
	static Hand testHand;
	static ScoreEquations2 newTest;
	static HashMap<String, Integer> testHandValues;
	static HashMap<ScoreCategory, Integer> testScoreCategoryOptions;
	static HashMap<ScoreCategory, Integer> testScoreBoard;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testHand = new Hand(5, 6);
		newTest = new ScoreEquations2(testHand);
		testHandValues = new HashMap<>();
		testScoreCategoryOptions = new HashMap<>();
		testScoreBoard = new HashMap<>();
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
		testHandValues.put("1", 1);
		testHandValues.put("2", 1);
		testHandValues.put("3", 1);
		testHandValues.put("4", 0);
		testHandValues.put("5", 2);
		testHandValues.put("6", 0);
		
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
		newTest.countHandValues(testHand);
		
		assertEquals(testHandValues.get("1"), newTest.handValues.get("1"));
		assertEquals(testHandValues.get("2"), newTest.handValues.get("2"));
		assertEquals(testHandValues.get("3"), newTest.handValues.get("3"));
		assertEquals(testHandValues.get("4"), newTest.handValues.get("4"));
		assertEquals(testHandValues.get("5"), newTest.handValues.get("5"));
		assertEquals(testHandValues.get("6"), newTest.handValues.get("6"));
	}
	
	@Test
	public void testCalcUpperScores() {
		testScoreCategoryOptions.put(ScoreCategory.ONES, 1*1);
		testScoreCategoryOptions.put(ScoreCategory.TWOS, 1*2);
		testScoreCategoryOptions.put(ScoreCategory.THREES, 1*3);
		testScoreCategoryOptions.put(ScoreCategory.FOURS, 0*4);
		testScoreCategoryOptions.put(ScoreCategory.FIVES, 2*5);
		testScoreCategoryOptions.put(ScoreCategory.SIXES, 0*6);
		
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
		newTest.countHandValues(testHand);
		newTest.calcUpperScores(testHand);
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.ONES), 
					 newTest.scoreCategoryOptions.get(ScoreCategory.ONES));
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.TWOS), 
				 	 newTest.scoreCategoryOptions.get(ScoreCategory.TWOS));
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.THREES), 
			 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.THREES));
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FOURS), 
					 newTest.scoreCategoryOptions.get(ScoreCategory.FOURS));
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FIVES), 
					 newTest.scoreCategoryOptions.get(ScoreCategory.FIVES));
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.SIXES), 
			 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.SIXES));
	}

}
