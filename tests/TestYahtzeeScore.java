package tests;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.Hand;
import scoring.DiceScore;
import scoring.ScoreCategory;
import scoring.YahtzeeScore;
import scoring.YahtzeeScoreBoard;

public class TestYahtzeeScore {
	
	static Hand testHand;
	static YahtzeeScoreBoard newTest;
	static HashMap<String, Integer> testHandValues;
	static HashMap<ScoreCategory, Integer> testScoreCategoryOptions;
	static HashMap<ScoreCategory, Integer> testScoreBoard;
	
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
		newTest.resetScoreBoard();
		YahtzeeScore.resetScoreCategoryOptions();
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
		YahtzeeScore.countHandValues(testHand);
		
		assertEquals(testHandValues.get("1"), YahtzeeScore.handValues.get("1"));
		assertEquals(testHandValues.get("2"), YahtzeeScore.handValues.get("2"));
		assertEquals(testHandValues.get("3"), YahtzeeScore.handValues.get("3"));
		assertEquals(testHandValues.get("4"), YahtzeeScore.handValues.get("4"));
		assertEquals(testHandValues.get("5"), YahtzeeScore.handValues.get("5"));
		assertEquals(testHandValues.get("6"), YahtzeeScore.handValues.get("6"));
	}
	
	@Test
	public void testCalcOnesTrue() {
		//Test that Upper Scores (Ones, Twos, Three, Fours, Fives, Sixes) will be scored 
		testScoreCategoryOptions.put(ScoreCategory.ONES, 1*5);
		
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
		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcUpperScores(ScoreCategory.ONES, 1);
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.ONES), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.ONES));
		
	}
	
	@Test
	public void testCalcTwosTrue() {
		testScoreCategoryOptions.put(ScoreCategory.TWOS, 2*5);
		while (testHand.diceInHand.get(0).readFaceUp() != 2){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 2){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 2){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 2){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 2){
			testHand.rollDie(4);
		}
		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcUpperScores(ScoreCategory.TWOS, 2);
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.TWOS), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.TWOS));
	}
	
	@Test 
	public void testCalcThreesTrue() {
		testScoreCategoryOptions.put(ScoreCategory.THREES, 3*5);
		while (testHand.diceInHand.get(0).readFaceUp() != 3){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 3){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 3){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 3){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 3){
			testHand.rollDie(4);
		}
		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcUpperScores(ScoreCategory.THREES, 3);
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.THREES), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.THREES));
	}
	
	@Test
	public void testCalcFoursTrue() {		
		testScoreCategoryOptions.put(ScoreCategory.FOURS, 4*5);

		while (testHand.diceInHand.get(0).readFaceUp() != 4){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 4){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 4){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 4){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 4){
			testHand.rollDie(4);
		}
		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcUpperScores(ScoreCategory.FOURS, 4);
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FOURS), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.FOURS));
	}
	
	@Test
	public void testCalcFivesTrue() {
		testScoreCategoryOptions.put(ScoreCategory.FIVES, 5*5);
		while (testHand.diceInHand.get(0).readFaceUp() != 5){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 5){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 5){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 5){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 5){
			testHand.rollDie(4);
		}
		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcUpperScores(ScoreCategory.FIVES, 5);
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FIVES), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.FIVES));
		
	}
	
	@Test
	public void testCalcSixesTrue() {		
		testScoreCategoryOptions.put(ScoreCategory.SIXES, 6*5);
		
		while (testHand.diceInHand.get(0).readFaceUp() != 6){
			testHand.rollDie(0);
		}
		while (testHand.diceInHand.get(1).readFaceUp() != 6){
			testHand.rollDie(1);
		}
		while (testHand.diceInHand.get(2).readFaceUp() != 6){
			testHand.rollDie(2);
		}
		while (testHand.diceInHand.get(3).readFaceUp() != 6){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 6){
			testHand.rollDie(4);
		}
		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcUpperScores(ScoreCategory.SIXES, 6);
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.SIXES), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.SIXES));

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

		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcThreeOfAKind();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND));
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

		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcThreeOfAKind();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND));
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

		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcFourOfAKind();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND));
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

		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcFourOfAKind();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND));
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

		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcFullHouse();
				
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FULL_HOUSE), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.FULL_HOUSE));
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

		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcFullHouse();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FULL_HOUSE), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.FULL_HOUSE));
	}
	
	@Test
	public void testCalcSmallStraightTrue() {
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
		while (testHand.diceInHand.get(3).readFaceUp() != 4){
			testHand.rollDie(3);
		}
		while (testHand.diceInHand.get(4).readFaceUp() != 3){
			testHand.rollDie(4);
		}

		testHand.sortItems();
		YahtzeeScore.countHandValues(testHand);
		
		
		System.out.println(testHandValues.get("2"));
//		System.out.println(testHandValues.get(""+2) + 1); 
		
		
		YahtzeeScore.calcSmallStraight();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT));
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

		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcSmallStraight();
						
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT));
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

		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcLargeStraight();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT));

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

		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcLargeStraight();
				
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT));
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

		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcChance();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.CHANCE), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.CHANCE));

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

		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcYahtzee(50);
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.YAHTZEE), 
	 	 	 	 YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.YAHTZEE));
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

		newTest.scoreBoard.put(ScoreCategory.YAHTZEE, 50);  //player already scored a Yahtzee
		testScoreCategoryOptions.put(ScoreCategory.YAHTZEE, 100);  //expect 100
		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcYahtzee(100);
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.YAHTZEE), 
	 	 	 	 YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.YAHTZEE));
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
		YahtzeeScore.countHandValues(testHand);
		assertEquals(maxValue, YahtzeeScore.findMaxValueCount());
	}

}
