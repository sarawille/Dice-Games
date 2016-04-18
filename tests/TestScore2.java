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
import scoring.YahtzeeGameScore;

public class TestScore2 {
	
	static Hand testHand;
	static YahtzeeGameScore newTest;
	static HashMap<String, Integer> testHandValues;
	static HashMap<ScoreCategory, Integer> testScoreCategoryOptions;
	static HashMap<ScoreCategory, Integer> testScoreBoard;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testHand = new Hand(5, 6);
		newTest = new YahtzeeGameScore();
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
		//Test that Upper Scores (Ones, Twos, Three, Fours, Fives, Sixes) will be scored 
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
		newTest.resetScoreBoard();
		newTest.countHandValues(testHand);
		newTest.calcUpperScores();
		
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
		
		//Test that Upper Scores cannot be scored more than once
		newTest.scoreCategoryOptions.put(ScoreCategory.ONES, 0);  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.ONES, 10);  //player already scored Ones
		testScoreCategoryOptions.put(ScoreCategory.ONES,0);  //expect 0
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.ONES), 
				 newTest.scoreCategoryOptions.get(ScoreCategory.ONES));
		
		newTest.scoreCategoryOptions.put(ScoreCategory.TWOS, 0);  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.TWOS, 10);  //player already scored Twos
		testScoreCategoryOptions.put(ScoreCategory.TWOS,0);  //expect 0
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.TWOS), 
				 newTest.scoreCategoryOptions.get(ScoreCategory.TWOS));
		
		newTest.scoreCategoryOptions.put(ScoreCategory.THREES, 0);  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.THREES, 10);  //player already scored Threes
		testScoreCategoryOptions.put(ScoreCategory.THREES ,0);  //expect 0
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.THREES), 
				 newTest.scoreCategoryOptions.get(ScoreCategory.THREES));
		
		newTest.scoreCategoryOptions.put(ScoreCategory.FOURS, 0);  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.FOURS, 10);  //player already scored Fours
		testScoreCategoryOptions.put(ScoreCategory.FOURS ,0);  //expect 0
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FOURS), 
				 newTest.scoreCategoryOptions.get(ScoreCategory.FOURS));
		
		newTest.scoreCategoryOptions.put(ScoreCategory.FIVES, 0);  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.FIVES, 10);  //player already scored Fives
		testScoreCategoryOptions.put(ScoreCategory.FIVES ,0);  //expect 0
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FIVES), 
				 newTest.scoreCategoryOptions.get(ScoreCategory.FIVES));
		
		newTest.scoreCategoryOptions.put(ScoreCategory.SIXES, 0);  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.SIXES, 10);  //player already scored Sixes
		testScoreCategoryOptions.put(ScoreCategory.SIXES ,0);  //expect 0
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.SIXES), 
				 newTest.scoreCategoryOptions.get(ScoreCategory.SIXES));
	}
	
	@Test
	public void testCalcThreeOfAKind() {
		//Test that Three of a Kind will be scored 
		testScoreCategoryOptions.put(ScoreCategory.THREE_OF_A_KIND, 12);
		
		while (testHand.diceInHand.get(0).readFaceUp() != 4){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 2){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 4){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 2){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 4){
			testHand.rollDie(4);
		}
		newTest.resetScoreBoard();
		newTest.countHandValues(testHand);
		newTest.calcThreeOfAKind();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND));
		
		//Test that Three of a Kind cannot be scored more than once
		newTest.scoreCategoryOptions.put(ScoreCategory.THREE_OF_A_KIND, 0);  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.THREE_OF_A_KIND, 10);  //player already scored 3K
		testScoreCategoryOptions.put(ScoreCategory.THREE_OF_A_KIND ,0);  //expect 0
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND));
	}
	
	@Test
	public void testCalcFourOfAKind() {
		//Test that Four of a Kind will be scored 
		testScoreCategoryOptions.put(ScoreCategory.FOUR_OF_A_KIND, 20);
		
		while (testHand.diceInHand.get(0).readFaceUp() != 5){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 5){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 4){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 5){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 5){
			testHand.rollDie(4);
		}
		newTest.resetScoreBoard();
		newTest.countHandValues(testHand);
		newTest.calcFourOfAKind();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND), 
		 	 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND));
		
		//Test that Four of a Kind cannot be scored more than once
		newTest.scoreCategoryOptions.put(ScoreCategory.FOUR_OF_A_KIND, 0);  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.FOUR_OF_A_KIND, 10);  //player already scored 4K
		testScoreCategoryOptions.put(ScoreCategory.FOUR_OF_A_KIND ,0);  //expect 0
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND), 
	 	 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND));
	}

	@Test
	public void testCalcFullHouse() {
		//Test that Full House will be scored 
		testScoreCategoryOptions.put(ScoreCategory.FULL_HOUSE, 25);
		
		while (testHand.diceInHand.get(0).readFaceUp() != 1){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 2){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 1){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 2){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 2){
			testHand.rollDie(4);
		}
		newTest.resetScoreBoard();
		newTest.countHandValues(testHand);
		newTest.calcFullHouse();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FULL_HOUSE), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.FULL_HOUSE));
		
		//Test that Small Straight cannot be scored more than once
		newTest.scoreCategoryOptions.put(ScoreCategory.FULL_HOUSE, 0);  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.FULL_HOUSE, 25);  //player already scored FH
		testScoreCategoryOptions.put(ScoreCategory.FULL_HOUSE ,0);  //expect 0
			
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FULL_HOUSE), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.FULL_HOUSE));
	}
	

	@Test
	public void testCalcSmallStraight() {
		//Test that Small Straight will be scored 
		testScoreCategoryOptions.put(ScoreCategory.SMALL_STRAIGHT, 30);
		
		while (testHand.diceInHand.get(0).readFaceUp() != 1){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 2){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 1){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 3){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 4){
			testHand.rollDie(4);
		}
		newTest.resetScoreBoard();
		newTest.countHandValues(testHand);
		newTest.calcSmallStraight();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT));
		
		//Test that Small Straight cannot be scored more than once
		newTest.scoreCategoryOptions.put(ScoreCategory.SMALL_STRAIGHT, 0);  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.SMALL_STRAIGHT, 30);  //player already scored SS
		testScoreCategoryOptions.put(ScoreCategory.SMALL_STRAIGHT ,0);  //expect 0
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT));
}
	
	@Test
	public void testCalcLargeStraight() {
		//Test that Large Straight will be scored 
		testScoreCategoryOptions.put(ScoreCategory.LARGE_STRAIGHT, 40);
		
		while (testHand.diceInHand.get(0).readFaceUp() != 1){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 2){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 5){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 3){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 4){
			testHand.rollDie(4);
		}
		newTest.resetScoreBoard();
		newTest.countHandValues(testHand);
		newTest.calcLargeStraight();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT));
		
		//Test that Large Straight cannot be scored more than once
		newTest.scoreCategoryOptions.put(ScoreCategory.LARGE_STRAIGHT, 0);  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.LARGE_STRAIGHT, 40);  //player already scored LS
		testScoreCategoryOptions.put(ScoreCategory.LARGE_STRAIGHT ,0);  //expect 0
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT));
	}
	
	@Test
	public void testCalcChance() {
		//Test that Chance will be scored 
		testScoreCategoryOptions.put(ScoreCategory.CHANCE, 11);
		
		while (testHand.diceInHand.get(0).readFaceUp() != 1){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 2){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 1){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 3){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 4){
			testHand.rollDie(4);
		}
		newTest.resetScoreBoard();
		newTest.countHandValues(testHand);
		newTest.calcChance();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.CHANCE), 
		 	 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.CHANCE));
		
		//Test that Large Straight cannot be scored more than once
		newTest.scoreCategoryOptions.put(ScoreCategory.CHANCE, 0);  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.CHANCE, 40);  //player already scored LS
		testScoreCategoryOptions.put(ScoreCategory.CHANCE,0);  //expect 0
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.CHANCE), 
	 	 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.CHANCE));
	}
}
