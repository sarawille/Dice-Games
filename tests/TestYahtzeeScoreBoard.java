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
import scoring.YahtzeeScoreBoard;

public class TestYahtzeeScoreBoard {
	
	static Hand testHand;
	static YahtzeeScoreBoard newTest;
	static HashMap<String, Integer> testHandValues;
	static HashMap<YahtzeeScoreCategory, Integer> testScoreBoard;
	static HashMap<YahtzeeScoreCategory, Integer> testScoreCategoryOptions;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testHand = new Hand(5, 6);
		newTest = new YahtzeeScoreBoard();
		testHandValues = new HashMap<>();
		testScoreBoard = new HashMap<>();
		testScoreCategoryOptions = new HashMap<>();
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
	public void testCalcOnesOnlyOnce() {
		newTest.scoreBoard.put(YahtzeeScoreCategory.ONES, 500);  //player already scored Ones
		testScoreCategoryOptions.put(YahtzeeScoreCategory.ONES,0);  //expect 0
		
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
		}											//simulate updateScore() without display menu
		testHand.sortItems();						//sort the order of dice as ascending values
		YahtzeeScore.countHandValues(testHand);		//count the instances of each face up value
		newTest.calculateScoreOptions();			//add possible points to scoreCategoryOptions if scoreBoard for that value is empty
		
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.ONES), 
	 	 	 	 YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.ONES));
	}
	
	@Test
	public void testCalcTwosOnlyOnce() {
		newTest.scoreBoard.put(YahtzeeScoreCategory.TWOS, 500);  //player already scored this category
		testScoreCategoryOptions.put(YahtzeeScoreCategory.TWOS,0);  //expect 0
		
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
		}											//simulate updateScore() without display menu
		testHand.sortItems();						//sort the order of dice as ascending values
		YahtzeeScore.countHandValues(testHand);		//count the instances of each face up value
		newTest.calculateScoreOptions();			//add possible points to scoreCategoryOptions if scoreBoard for that value is empty
		
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.TWOS), 
	 	 	 	 YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.TWOS));
	}
	
	@Test 
	public void testCalcThreesOnlyOnce() {
		newTest.scoreBoard.put(YahtzeeScoreCategory.THREES, 500);  //player already scored this category
		testScoreCategoryOptions.put(YahtzeeScoreCategory.THREES,0);  //expect 0
		
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
		}											//simulate updateScore() without display menu
		testHand.sortItems();						//sort the order of dice as ascending values
		YahtzeeScore.countHandValues(testHand);		//count the instances of each face up value
		newTest.calculateScoreOptions();			//add possible points to scoreCategoryOptions if scoreBoard for that value is empty
		
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.THREES), 
	 	 	 	 YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.THREES));
	}
	
	@Test
	public void testCalcFoursOnlyOnce() {		
		newTest.scoreBoard.put(YahtzeeScoreCategory.FOURS, 500);  //player already scored this category
		testScoreCategoryOptions.put(YahtzeeScoreCategory.FOURS,0);  //expect 0
		
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
		}											//simulate updateScore() without display menu
		testHand.sortItems();						//sort the order of dice as ascending values
		YahtzeeScore.countHandValues(testHand);		//count the instances of each face up value
		newTest.calculateScoreOptions();			//add possible points to scoreCategoryOptions if scoreBoard for that value is empty
		
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.FOURS), 
	 	 	 	 YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.FOURS));
	}
	
	@Test
	public void testCalcFivesOnlyOnce() {
		newTest.scoreBoard.put(YahtzeeScoreCategory.FIVES, 500);  //player already scored this category
		testScoreCategoryOptions.put(YahtzeeScoreCategory.FIVES,0);  //expect 0
		
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
		}											//simulate updateScore() without display menu
		testHand.sortItems();						//sort the order of dice as ascending values
		YahtzeeScore.countHandValues(testHand);		//count the instances of each face up value
		newTest.calculateScoreOptions();			//add possible points to scoreCategoryOptions if scoreBoard for that value is empty
		
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.FIVES), 
	 	 	 	 YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.FIVES));
		
	}
	
	@Test
	public void testCalcSixesOnlyOnce() {		
		newTest.scoreBoard.put(YahtzeeScoreCategory.SIXES, 500);  //player already scored this category
		testScoreCategoryOptions.put(YahtzeeScoreCategory.SIXES,0);  //expect 0
		
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
		}											//simulate updateScore() without display menu
		testHand.sortItems();						//sort the order of dice as ascending values
		YahtzeeScore.countHandValues(testHand);		//count the instances of each face up value
		newTest.calculateScoreOptions();			//add possible points to scoreCategoryOptions if scoreBoard for that value is empty
		
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.SIXES), 
	 	 	 	 YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.SIXES));	}
	
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

		newTest.scoreBoard.put(YahtzeeScoreCategory.THREE_OF_A_KIND, 10);  //player already scored 3K
		testScoreCategoryOptions.put(YahtzeeScoreCategory.THREE_OF_A_KIND ,0);  //expect 0
		
		testHand.sortItems();						//sort the order of dice as ascending values
		YahtzeeScore.countHandValues(testHand);		//count the instances of each face up value
		newTest.calculateScoreOptions();			//add possible points to scoreCategoryOptions if scoreBoard for that value is empty
		
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.THREE_OF_A_KIND), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.THREE_OF_A_KIND));
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

		newTest.scoreBoard.put(YahtzeeScoreCategory.FOUR_OF_A_KIND, 10);  //player already scored 4K
		testScoreCategoryOptions.put(YahtzeeScoreCategory.FOUR_OF_A_KIND ,0);  //expect 0

		testHand.sortItems();						//sort the order of dice as ascending values
		YahtzeeScore.countHandValues(testHand);		//count the instances of each face up value
		newTest.calculateScoreOptions();			//add possible points to scoreCategoryOptions if scoreBoard for that value is empty
				
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.FOUR_OF_A_KIND), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.FOUR_OF_A_KIND));
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

		newTest.scoreBoard.put(YahtzeeScoreCategory.FULL_HOUSE, 25);  //player already scored FH
		testScoreCategoryOptions.put(YahtzeeScoreCategory.FULL_HOUSE ,0);  //expect 0

		testHand.sortItems();						//sort the order of dice as ascending values
		YahtzeeScore.countHandValues(testHand);		//count the instances of each face up value
		newTest.calculateScoreOptions();			//add possible points to scoreCategoryOptions if scoreBoard for that value is empty
				
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.FULL_HOUSE), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.FULL_HOUSE));
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

		newTest.scoreBoard.put(YahtzeeScoreCategory.SMALL_STRAIGHT, 30);  //player already scored SS
		testScoreCategoryOptions.put(YahtzeeScoreCategory.SMALL_STRAIGHT ,0);  //expect 0
		
		testHand.sortItems();						//sort the order of dice as ascending values
		YahtzeeScore.countHandValues(testHand);		//count the instances of each face up value
		newTest.calculateScoreOptions();			//add possible points to scoreCategoryOptions if scoreBoard for that value is empty
				
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.SMALL_STRAIGHT), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.SMALL_STRAIGHT));
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

		newTest.scoreBoard.put(YahtzeeScoreCategory.LARGE_STRAIGHT, 40);  //player already scored LS
		testScoreCategoryOptions.put(YahtzeeScoreCategory.LARGE_STRAIGHT ,0);  //expect 0
		
		testHand.sortItems();						//sort the order of dice as ascending values
		YahtzeeScore.countHandValues(testHand);		//count the instances of each face up value
		newTest.calculateScoreOptions();			//add possible points to scoreCategoryOptions if scoreBoard for that value is empty
				
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.LARGE_STRAIGHT), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.LARGE_STRAIGHT));
	}
	
	@Test
	public void testCalcChanceOnlyOnce() {
		//Test that Chance cannot be scored more than once

		newTest.scoreBoard.put(YahtzeeScoreCategory.CHANCE, 40);  //player already scored Chance
		testScoreCategoryOptions.put(YahtzeeScoreCategory.CHANCE,0);  //expect 0

		testHand.sortItems();						//sort the order of dice as ascending values
		YahtzeeScore.countHandValues(testHand);		//count the instances of each face up value
		newTest.calculateScoreOptions();			//add possible points to scoreCategoryOptions if scoreBoard for that value is empty
				
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.CHANCE), 
				YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.CHANCE));
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

		newTest.scoreBoard.put(YahtzeeScoreCategory.YAHTZEE, 50);  //player already scored a Yahtzee
		testScoreCategoryOptions.put(YahtzeeScoreCategory.YAHTZEE, 100);  //expect 100
		
		testHand.sortItems();						//sort the order of dice as ascending values
		YahtzeeScore.countHandValues(testHand);		//count the instances of each face up value
		newTest.calculateScoreOptions();			//add possible points to scoreCategoryOptions if scoreBoard for that value is empty
		
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.YAHTZEE), 
	 	 	 	 YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.YAHTZEE));
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

		newTest.scoreBoard.put(YahtzeeScoreCategory.YAHTZEE, 0);  //player already scored Yahtzee as 0
		testScoreCategoryOptions.put(YahtzeeScoreCategory.YAHTZEE, 0);  //expect 0
		
		testHand.sortItems();						//sort the order of dice as ascending values
		YahtzeeScore.countHandValues(testHand);		//count the instances of each face up value
		newTest.calculateScoreOptions();			//add possible points to scoreCategoryOptions if scoreBoard for that value is empty
				
		assertEquals(testScoreCategoryOptions.get(YahtzeeScoreCategory.YAHTZEE), 
	 	 	 	 YahtzeeScore.scoreCategoryOptions.get(YahtzeeScoreCategory.YAHTZEE));
	}
	
	@Test
	public void testListScoringOptions() {	
		testScoreCategoryOptions.put(YahtzeeScoreCategory.ONES, 1*3);
		testScoreCategoryOptions.put(YahtzeeScoreCategory.TWOS, 2*1);
		testScoreCategoryOptions.put(YahtzeeScoreCategory.FIVES, 5*1);
		testScoreCategoryOptions.put(YahtzeeScoreCategory.THREE_OF_A_KIND, 1*3);
		testScoreCategoryOptions.put(YahtzeeScoreCategory.CHANCE, 1*3+2+5);
		
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
		YahtzeeScore.countHandValues(testHand);
		newTest.calculateScoreOptions();
		newTest.listScoringOptions();
		
		String expected = "1 \t Ones \t\t\t" + testScoreCategoryOptions.get(YahtzeeScoreCategory.ONES) + " points\n" +
				"2 \t Twos \t\t\t" + testScoreCategoryOptions.get(YahtzeeScoreCategory.TWOS) + " points\n" +
				"5 \t Fives \t\t\t" + testScoreCategoryOptions.get(YahtzeeScoreCategory.FIVES) + " points\n" +
				"3K \t 3 of a Kind  \t\t" + testScoreCategoryOptions.get(YahtzeeScoreCategory.THREE_OF_A_KIND) + " points\n" +
				"C \t Chance \t\t" +testScoreCategoryOptions.get(YahtzeeScoreCategory.CHANCE) + " points\n";
		
		assertTrue(expected.equals(newTest.scoreMenu.toString()));
	}
}
