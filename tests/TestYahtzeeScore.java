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
import scoring.YahtzeeScore;
import scoring.YahtzeeScoreBoard;

public class TestYahtzeeScore {
	
	static Hand testHand;
	static YahtzeeScoreBoard newTest;
	static HashMap<String, Integer> testHandValues;
	static HashMap<ScoreCategory, Integer> testScoreCategoryOptions;
	static HashMap<ScoreCategory, Integer> testScoreBoard;
	
	//TODO extract test for 0 points vs should have points

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testHand = new Hand(5, 6);
		newTest = new YahtzeeScoreBoard();
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
		YahtzeeScore.calcUpperScores(ScoreCategory.ONES, 1);
		YahtzeeScore.calcUpperScores(ScoreCategory.TWOS, 2);
		YahtzeeScore.calcUpperScores(ScoreCategory.THREES, 3);
		YahtzeeScore.calcUpperScores(ScoreCategory.THREES, 4);
		YahtzeeScore.calcUpperScores(ScoreCategory.FOURS, 5);
		YahtzeeScore.calcUpperScores(ScoreCategory.SIXES, 6);
		
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
	
	//TODO separate out test for upper scores by number
	
	@Test
	public void testCalcUpperScoresOnlyOnce() {
		//Test that Upper Scores cannot be scored more than once
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
		while (testHand.diceInHand.get(4).readFaceUp() != 6){
			testHand.rollDie(4);
		}
		newTest.countHandValues(testHand);
		
		newTest.resetScoreCategoryOptions();  //reset possible points
		
		newTest.scoreBoard.put(ScoreCategory.ONES, 10);  //player already scored Ones
		testScoreCategoryOptions.put(ScoreCategory.ONES,0);  //expect 0
		
		newTest.scoreBoard.put(ScoreCategory.TWOS, 10);  //player already scored Twos
		testScoreCategoryOptions.put(ScoreCategory.TWOS,0);  //expect 0
		
		newTest.scoreBoard.put(ScoreCategory.THREES, 10);  //player already scored Threes
		testScoreCategoryOptions.put(ScoreCategory.THREES ,0);  //expect 0
		
		newTest.scoreBoard.put(ScoreCategory.FOURS, 10);  //player already scored Fours
		testScoreCategoryOptions.put(ScoreCategory.FOURS ,0);  //expect 0
		
		newTest.scoreBoard.put(ScoreCategory.FIVES, 10);  //player already scored Fives
		testScoreCategoryOptions.put(ScoreCategory.FIVES ,0);  //expect 0
		
		newTest.scoreBoard.put(ScoreCategory.SIXES, 10);  //player already scored Sixes
		testScoreCategoryOptions.put(ScoreCategory.SIXES ,0);  //expect 0
		
		YahtzeeScore.calcUpperScores(ScoreCategory.ONES, 1);
		YahtzeeScore.calcUpperScores(ScoreCategory.TWOS, 2);
		YahtzeeScore.calcUpperScores(ScoreCategory.THREES, 3);
		YahtzeeScore.calcUpperScores(ScoreCategory.THREES, 4);
		YahtzeeScore.calcUpperScores(ScoreCategory.FOURS, 5);
		YahtzeeScore.calcUpperScores(ScoreCategory.SIXES, 6);
		
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
	
	@Test
	public void testCalcThreeOfAKindTrue() {
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
		newTest.resetScoreCategoryOptions();
		newTest.resetScoreBoard();
		newTest.countHandValues(testHand);
		newTest.calcThreeOfAKind();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND));
	}
	
	@Test
	public void testCalcThreeOfAKindFalse() {
		//Test that Three of a Kind will NOT be scored 
		testScoreCategoryOptions.put(ScoreCategory.THREE_OF_A_KIND, 0);
		
		while (testHand.diceInHand.get(0).readFaceUp() != 3){
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
		newTest.resetScoreCategoryOptions();
		newTest.resetScoreBoard();
		newTest.countHandValues(testHand);
		newTest.calcThreeOfAKind();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND));
	}
	
	@Test
	public void testCalcThreeOfAKindOnlyOnce() {
		//Test that Three of a Kind cannot be scored more than once
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
		newTest.resetScoreCategoryOptions();  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.THREE_OF_A_KIND, 10);  //player already scored 3K
		testScoreCategoryOptions.put(ScoreCategory.THREE_OF_A_KIND ,0);  //expect 0
		newTest.calcThreeOfAKind();
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND));
	}
	
	@Test
	public void testCalcFourOfAKindTrue() {
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
		newTest.resetScoreCategoryOptions();
		newTest.resetScoreBoard();
		newTest.countHandValues(testHand);
		newTest.calcFourOfAKind();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND), 
		 	 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND));
	}
	
	@Test
	public void testCalcFourOfAKindFalse() {
		//Test that Four of a Kind will NOT be scored 
		testScoreCategoryOptions.put(ScoreCategory.FOUR_OF_A_KIND, 0);
		
		while (testHand.diceInHand.get(0).readFaceUp() != 1){
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
		newTest.resetScoreCategoryOptions();
		newTest.resetScoreBoard();
		newTest.countHandValues(testHand);
		newTest.calcFourOfAKind();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND), 
		 	 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND));
	}

	@Test
	public void testFourOfAKindOnlyOnce() {
		//Test that Four of a Kind cannot be scored more than once
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
		newTest.resetScoreCategoryOptions();  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.FOUR_OF_A_KIND, 10);  //player already scored 4K
		testScoreCategoryOptions.put(ScoreCategory.FOUR_OF_A_KIND ,0);  //expect 0
		newTest.calcFourOfAKind();
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND), 
	 	 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND));
	}
	
	@Test
	public void testCalcFullHouseTrue() {
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
		newTest.resetScoreCategoryOptions();
		newTest.resetScoreBoard();
		newTest.countHandValues(testHand);
		newTest.calcFullHouse();
				
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FULL_HOUSE), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.FULL_HOUSE));
	}
	
	@Test
	public void testCalcFullHouseFalse() {
		//Test that Full House will NOT be scored 
		testScoreCategoryOptions.put(ScoreCategory.FULL_HOUSE, 0);
		
		while (testHand.diceInHand.get(0).readFaceUp() != 5){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 1){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 3){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 1){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 6){
			testHand.rollDie(4);
		}
		newTest.resetScoreCategoryOptions();
		newTest.resetScoreBoard();
		newTest.countHandValues(testHand);
		newTest.calcFullHouse();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FULL_HOUSE), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.FULL_HOUSE));
	}
	
	@Test
	public void testCalcFullHouseOnlyOnce() {
		//Test that Full House cannot be scored more than once
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
		newTest.resetScoreCategoryOptions();  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.FULL_HOUSE, 25);  //player already scored FH
		testScoreCategoryOptions.put(ScoreCategory.FULL_HOUSE ,0);  //expect 0
		newTest.countHandValues(testHand);
		newTest.calcFullHouse();
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FULL_HOUSE), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.FULL_HOUSE));
	}
	

	@Test
	public void testCalcSmallStraightTrue() {
		//Test that Small Straight will be scored 
		testScoreCategoryOptions.put(ScoreCategory.SMALL_STRAIGHT, 30);
		
		while (testHand.diceInHand.get(0).readFaceUp() != 3){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 1){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 6){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 5){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 4){
			testHand.rollDie(4);
		}
		newTest.resetScoreCategoryOptions();
		newTest.resetScoreBoard();
		newTest.countHandValues(testHand);
		newTest.calcSmallStraight();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT));
}
	
	@Test 
	public void testCalcSmallStraightFalse() {
		//Test that Small Straight will NOT be scored if it doesn't happen
		testScoreCategoryOptions.put(ScoreCategory.SMALL_STRAIGHT, 0);
		
		while (testHand.diceInHand.get(0).readFaceUp() != 2){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 4){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 3){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 6){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 6){
			testHand.rollDie(4);
		}
		newTest.resetScoreCategoryOptions();
		newTest.resetScoreBoard();
		newTest.countHandValues(testHand);
		newTest.calcSmallStraight();
						
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT));
	}
	
	@Test
	public void testCalcSmallStraightOnlyOnce() {
		//Test that Small Straight cannot be scored more than once
		while (testHand.diceInHand.get(0).readFaceUp() != 1){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 2){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 3){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 4){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 5){
			testHand.rollDie(4);
		}
		newTest.resetScoreCategoryOptions();  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.SMALL_STRAIGHT, 30);  //player already scored SS
		testScoreCategoryOptions.put(ScoreCategory.SMALL_STRAIGHT ,0);  //expect 0
		newTest.countHandValues(testHand);
		newTest.calcSmallStraight();
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT));
	}
	
	@Test
	public void testCalcLargeStraightTrue() {
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
		newTest.resetScoreCategoryOptions();
		newTest.resetScoreBoard();
		newTest.countHandValues(testHand);
		newTest.calcLargeStraight();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT));

	}
	
	@Test 
	public void testCalcLargeStraightFalse() {
		//Test that Small Straight will NOT be scored if it doesn't happen
		testScoreCategoryOptions.put(ScoreCategory.LARGE_STRAIGHT, 0);
		
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
		while (testHand.diceInHand.get(4).readFaceUp() != 1){
			testHand.rollDie(4);
		}
		newTest.resetScoreCategoryOptions();
		newTest.resetScoreBoard();
		newTest.countHandValues(testHand);
		newTest.calcLargeStraight();
				
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT));
	}
	
	@Test
	public void testCalcLargeStraightOnlyOnce() {
		//Test that Large Straight cannot be scored more than once
		while (testHand.diceInHand.get(0).readFaceUp() != 1){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 2){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 3){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 4){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 5){
			testHand.rollDie(4);
		}
		newTest.resetScoreCategoryOptions();  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.LARGE_STRAIGHT, 40);  //player already scored LS
		testScoreCategoryOptions.put(ScoreCategory.LARGE_STRAIGHT ,0);  //expect 0
		newTest.countHandValues(testHand);
		newTest.calcLargeStraight();
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT), 
		 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT));
	}
	
	@Test
	public void testCalcChance() {
		//Test that Chance will be scored 
		testScoreCategoryOptions.put(ScoreCategory.CHANCE, 19);
		
		while (testHand.diceInHand.get(0).readFaceUp() != 1){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 2){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 6){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 6){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 4){
			testHand.rollDie(4);
		}
		newTest.resetScoreCategoryOptions();
		newTest.resetScoreBoard();
		newTest.countHandValues(testHand);
		newTest.calcChance();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.CHANCE), 
		 	 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.CHANCE));

	}
	
	@Test
	public void testCalcChanceOnlyOnce() {
		//Test that Chance cannot be scored more than once
		newTest.resetScoreCategoryOptions();  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.CHANCE, 40);  //player already scored Chance
		testScoreCategoryOptions.put(ScoreCategory.CHANCE,0);  //expect 0
		newTest.calcChance();
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.CHANCE), 
	 	 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.CHANCE));
	}
	
	@Test
	public void testCalcYahtzee() {
		//Test that Yahtzee will be scored 
		testScoreCategoryOptions.put(ScoreCategory.YAHTZEE, 50);
		while (testHand.diceInHand.get(0).readFaceUp() != 1){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 1){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 1){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 1){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 1){
			testHand.rollDie(4);
		}
		newTest.resetScoreCategoryOptions();
		newTest.resetScoreBoard();
		newTest.countHandValues(testHand);
		newTest.calcYahtzee(50);
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.YAHTZEE), 
	 	 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.YAHTZEE));
	}
	
	@Test
	public void testCalcSecondYahtzee() {
		//Test that second Yahtzee will be worth 100 points
		while (testHand.diceInHand.get(0).readFaceUp() != 1){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 1){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 1){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 1){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 1){
			testHand.rollDie(4);
		}
		newTest.resetScoreCategoryOptions();  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.YAHTZEE, 50);  //player already scored a Yahtzee
		testScoreCategoryOptions.put(ScoreCategory.YAHTZEE, 100);  //expect 100
		newTest.countHandValues(testHand);
		newTest.calcYahtzee(100);
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.YAHTZEE), 
	 	 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.YAHTZEE));
	}
	
	@Test
	public void testCalcYahtzeeIsZero() {
		//Test that Yahtzee cannot be scored if it is already scored as 0
		while (testHand.diceInHand.get(0).readFaceUp() != 1){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 1){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 1){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 1){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 1){
			testHand.rollDie(4);
		}
		newTest.resetScoreCategoryOptions();  //reset possible points
		newTest.scoreBoard.put(ScoreCategory.YAHTZEE, 0);  //player already scored Yahtzee as 0
		testScoreCategoryOptions.put(ScoreCategory.YAHTZEE, 0);  //expect 0
		newTest.countHandValues(testHand);
		newTest.calcYahtzee(0);
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.YAHTZEE), 
	 	 	 	 newTest.scoreCategoryOptions.get(ScoreCategory.YAHTZEE));
	}
	
	@Test
	public void testFindMaxValue() {
		int maxValue = 2;
		while (testHand.diceInHand.get(0).readFaceUp() != 2){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 4){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 3){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 6){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 6){
			testHand.rollDie(4);
		}
		newTest.countHandValues(testHand);
		assertEquals(maxValue, newTest.findMaxValueCount());
	}
	
	@Test //TODO arrange test so that i can see that all are on or all are off (getzeros())
	public void testListScoringOptions() {	
		testScoreCategoryOptions.put(ScoreCategory.ONES, 1*3);
		testScoreCategoryOptions.put(ScoreCategory.TWOS, 2*1);
		testScoreCategoryOptions.put(ScoreCategory.FIVES, 5*1);
		testScoreCategoryOptions.put(ScoreCategory.THREE_OF_A_KIND, 1*3);
		testScoreCategoryOptions.put(ScoreCategory.CHANCE, 1*3+2+5);
		
		while (testHand.diceInHand.get(0).readFaceUp() != 1){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 2){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 1){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 1){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 5){
			testHand.rollDie(4);
		}
		newTest.countHandValues(testHand);
		newTest.calculateScoreOptions();
		newTest.listScoringOptions();
		
		String expected = "1 \t Ones \t\t\t" + testScoreCategoryOptions.get(ScoreCategory.ONES) + " points\n" +
				"2 \t Twos \t\t\t" + testScoreCategoryOptions.get(ScoreCategory.TWOS) + " points\n" +
				"5 \t Fives \t\t\t" + testScoreCategoryOptions.get(ScoreCategory.FIVES) + " points\n" +
				"3K \t 3 of a Kind  \t\t" + testScoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND) + " points\n" +
				"C \t Chance \t\t" +testScoreCategoryOptions.get(ScoreCategory.CHANCE) + " points\n";
		
		assertTrue(expected.equals(newTest.scoreMenu.toString()));
	}
	
	@Test
	public void testGetZeros() {
		
	}
	
	@Test
	public void testGetUserChoice() {
		
	}
}
