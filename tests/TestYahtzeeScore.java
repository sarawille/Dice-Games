package tests;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.Hand;
import scoring.YahtzeeScoreCategory;
import scoring.YahtzeeScore;

public class TestYahtzeeScore {
	
	static Hand testHand;
	static HashMap<String, Integer> testHandValues;
	static HashMap<YahtzeeScoreCategory, Integer> testScoreCategoryOptions;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testHand = new Hand(5, 6);
		testHandValues = new HashMap<>();
		testScoreCategoryOptions = new HashMap<>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
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
		testScoreCategoryOptions.put(YahtzeeScoreCategory.ONES, 1*5);
		
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
		YahtzeeScore.calcUpperScores(YahtzeeScoreCategory.ONES, 1);
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.ONES), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.ONES));
		
	}
	
	@Test
	public void testCalcTwosTrue() {
		testScoreCategoryOptions.put(YahtzeeScoreCategory.TWOS, 2*5);
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
		YahtzeeScore.calcUpperScores(YahtzeeScoreCategory.TWOS, 2);
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.TWOS), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.TWOS));
	}
	
	@Test 
	public void testCalcThreesTrue() {
		testScoreCategoryOptions.put(YahtzeeScoreCategory.THREES, 3*5);
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
		YahtzeeScore.calcUpperScores(YahtzeeScoreCategory.THREES, 3);
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.THREES), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.THREES));
	}
	
	@Test
	public void testCalcFoursTrue() {		
		testScoreCategoryOptions.put(YahtzeeScoreCategory.FOURS, 4*5);

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
		YahtzeeScore.calcUpperScores(YahtzeeScoreCategory.FOURS, 4);
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.FOURS), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.FOURS));
	}
	
	@Test
	public void testCalcFivesTrue() {
		testScoreCategoryOptions.put(YahtzeeScoreCategory.FIVES, 5*5);
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
		YahtzeeScore.calcUpperScores(YahtzeeScoreCategory.FIVES, 5);
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.FIVES), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.FIVES));
		
	}
	
	@Test
	public void testCalcSixesTrue() {		
		testScoreCategoryOptions.put(YahtzeeScoreCategory.SIXES, 6*5);
		
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
		YahtzeeScore.calcUpperScores(YahtzeeScoreCategory.SIXES, 6);
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.SIXES), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.SIXES));

	}
	

	@Test
	public void testCalcThreeOfAKindTrue() {
		//Test that Three of a Kind will be scored 
		testScoreCategoryOptions.put(YahtzeeScoreCategory.THREE_OF_A_KIND, 12);
		
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
		
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.THREE_OF_A_KIND), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.THREE_OF_A_KIND));
	}
	
	@Test
	public void testCalcThreeOfAKindFalse() {
		//Test that Three of a Kind will NOT be scored 
		testScoreCategoryOptions.put(YahtzeeScoreCategory.THREE_OF_A_KIND, 0);
		
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
		
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.THREE_OF_A_KIND), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.THREE_OF_A_KIND));
	}
	
	@Test
	public void testCalcFourOfAKindTrue() {
		//Test that Four of a Kind will be scored 
		testScoreCategoryOptions.put(YahtzeeScoreCategory.FOUR_OF_A_KIND, 20);
		
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
		
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.FOUR_OF_A_KIND), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.FOUR_OF_A_KIND));
	}
	
	@Test
	public void testCalcFourOfAKindFalse() {
		//Test that Four of a Kind will NOT be scored 
		testScoreCategoryOptions.put(YahtzeeScoreCategory.FOUR_OF_A_KIND, 0);
		
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
		
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.FOUR_OF_A_KIND), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.FOUR_OF_A_KIND));
	}

	
	
	@Test
	public void testCalcFullHouseTrue() {
		//Test that Full House will be scored 
		testScoreCategoryOptions.put(YahtzeeScoreCategory.FULL_HOUSE, 25);
		
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
				
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.FULL_HOUSE), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.FULL_HOUSE));
	}
	
	@Test
	public void testCalcFullHouseFalse() {
		//Test that Full House will NOT be scored 
		testScoreCategoryOptions.put(YahtzeeScoreCategory.FULL_HOUSE, 0);
		
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
		
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.FULL_HOUSE), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.FULL_HOUSE));
	}
	
	@Test
	public void testCalcSmallStraightTrue() {
		//Test that Small Straight will be scored 
		
		testScoreCategoryOptions.put(YahtzeeScoreCategory.SMALL_STRAIGHT, 30);
		
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
		
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.SMALL_STRAIGHT), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.SMALL_STRAIGHT));
}
	
	@Test 
	public void testCalcSmallStraightFalse() {
		//Test that Small Straight will NOT be scored if it doesn't happen
		testScoreCategoryOptions.put(YahtzeeScoreCategory.SMALL_STRAIGHT, 0);
		
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
						
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.SMALL_STRAIGHT), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.SMALL_STRAIGHT));
	}
		
	@Test
	public void testCalcLargeStraightTrue() {
		//Test that Large Straight will be scored 
		testScoreCategoryOptions.put(YahtzeeScoreCategory.LARGE_STRAIGHT, 40);
		
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
		
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.LARGE_STRAIGHT), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.LARGE_STRAIGHT));

	}
	
	@Test 
	public void testCalcLargeStraightFalse() {
		//Test that Small Straight will NOT be scored if it doesn't happen
		testScoreCategoryOptions.put(YahtzeeScoreCategory.LARGE_STRAIGHT, 0);
		
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
				
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.LARGE_STRAIGHT), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.LARGE_STRAIGHT));
	}
		
	@Test
	public void testCalcChance() {
		//Test that Chance will be scored 
		testScoreCategoryOptions.put(YahtzeeScoreCategory.CHANCE, 19);
		
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
		
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.CHANCE), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.CHANCE));

	}
	
	@Test
	public void testCalcYahtzee() {
		//Test that Yahtzee will be scored 
		testScoreCategoryOptions.put(YahtzeeScoreCategory.YAHTZEE, 50);
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
		
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.YAHTZEE), 
	 	 	 	 YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.YAHTZEE));
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
