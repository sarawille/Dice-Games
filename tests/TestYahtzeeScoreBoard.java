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

public class TestYahtzeeScoreBoard {
	
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
	public void test() {
		fail("Not yet implemented");
	}

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
		YahtzeeScore.countHandValues(testHand);
		
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
		
		YahtzeeScore.calcUpperScores(ScoreCategory.ONES, 1);	//calcaulte for the testHand
		YahtzeeScore.calcUpperScores(ScoreCategory.TWOS, 2);
		YahtzeeScore.calcUpperScores(ScoreCategory.THREES, 3);
		YahtzeeScore.calcUpperScores(ScoreCategory.THREES, 4);
		YahtzeeScore.calcUpperScores(ScoreCategory.FOURS, 5);
		YahtzeeScore.calcUpperScores(ScoreCategory.SIXES, 6);
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.ONES), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.ONES));
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.TWOS), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.TWOS));
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.THREES), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.THREES));
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FOURS), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.FOURS));
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FIVES), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.FIVES));
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.SIXES), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.SIXES));
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

		newTest.scoreBoard.put(ScoreCategory.THREE_OF_A_KIND, 10);  //player already scored 3K
		testScoreCategoryOptions.put(ScoreCategory.THREE_OF_A_KIND ,0);  //expect 0
		
		YahtzeeScore.calcThreeOfAKind();		//calculate
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND));
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

		newTest.scoreBoard.put(ScoreCategory.FOUR_OF_A_KIND, 10);  //player already scored 4K
		testScoreCategoryOptions.put(ScoreCategory.FOUR_OF_A_KIND ,0);  //expect 0

		YahtzeeScore.calcFourOfAKind();
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND));
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

		newTest.scoreBoard.put(ScoreCategory.FULL_HOUSE, 25);  //player already scored FH
		testScoreCategoryOptions.put(ScoreCategory.FULL_HOUSE ,0);  //expect 0
		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcFullHouse();
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.FULL_HOUSE), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.FULL_HOUSE));
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

		newTest.scoreBoard.put(ScoreCategory.SMALL_STRAIGHT, 30);  //player already scored SS
		testScoreCategoryOptions.put(ScoreCategory.SMALL_STRAIGHT ,0);  //expect 0
		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcSmallStraight();
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT));
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

		newTest.scoreBoard.put(ScoreCategory.LARGE_STRAIGHT, 40);  //player already scored LS
		testScoreCategoryOptions.put(ScoreCategory.LARGE_STRAIGHT ,0);  //expect 0
		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcLargeStraight();
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT));
	}
	
	@Test
	public void testCalcChanceOnlyOnce() {
		//Test that Chance cannot be scored more than once

		newTest.scoreBoard.put(ScoreCategory.CHANCE, 40);  //player already scored Chance
		testScoreCategoryOptions.put(ScoreCategory.CHANCE,0);  //expect 0
		YahtzeeScore.calcChance();
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.CHANCE), 
				YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.CHANCE));
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

		newTest.scoreBoard.put(ScoreCategory.YAHTZEE, 0);  //player already scored Yahtzee as 0
		testScoreCategoryOptions.put(ScoreCategory.YAHTZEE, 0);  //expect 0
		
		YahtzeeScore.countHandValues(testHand);
		YahtzeeScore.calcYahtzee(0);
		
		assertEquals(testScoreCategoryOptions.get(ScoreCategory.YAHTZEE), 
	 	 	 	 YahtzeeScore.scoreCategoryOptions.get(ScoreCategory.YAHTZEE));
	}
	
	@Test
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
		YahtzeeScore.countHandValues(testHand);
		newTest.calculateScoreOptions();
		newTest.listScoringOptions();
		
		String expected = "1 \t Ones \t\t\t" + testScoreCategoryOptions.get(ScoreCategory.ONES) + " points\n" +
				"2 \t Twos \t\t\t" + testScoreCategoryOptions.get(ScoreCategory.TWOS) + " points\n" +
				"5 \t Fives \t\t\t" + testScoreCategoryOptions.get(ScoreCategory.FIVES) + " points\n" +
				"3K \t 3 of a Kind  \t\t" + testScoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND) + " points\n" +
				"C \t Chance \t\t" +testScoreCategoryOptions.get(ScoreCategory.CHANCE) + " points\n";
		
		assertTrue(expected.equals(newTest.scoreMenu.toString()));
	}
}
