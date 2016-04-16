package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import scoring.ScoreCategory;
import scoring.ScoreEquations;
import scoring.ScoreVariables;
import business.Hand;
import business.Rollable;

public class TestScoreEquations {
	
	static ScoreEquations test;
	static Hand myHand;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test = new ScoreEquations();
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
	public void testCalcOnes() {
		int testPoints = 0;
		myHand.rollAll();
		while (myHand.fiveDice.get(0).readFaceUp() != 1){
			myHand.rollDie(0);
		}
		for (int i = 0; i < myHand.fiveDice.size(); i++)
		{
			if (myHand.readDie(i) == 1)
			{
				testPoints++;
			}
		}
		assertEquals(testPoints, test.calcOnes(myHand));
	}
	
	@Test
	public void testCalcTwos() {
		int testPoints = 0;
		myHand.rollAll();
		while (myHand.fiveDice.get(0).readFaceUp() != 2){
			myHand.rollDie(0);
		}
		for (int i = 0; i < myHand.fiveDice.size(); i++)
		{
			if (myHand.readDie(i) == 2)
			{
				testPoints+=2;
			}
		}
		assertEquals(testPoints, test.calcTwos(myHand));
	}
	
	@Test
	public void testCalcThrees() {
		int testPoints = 0;
		myHand.rollAll();
		while (myHand.fiveDice.get(0).readFaceUp() != 3){
			myHand.rollDie(0);
		}
		for (int i = 0; i < myHand.fiveDice.size(); i++)
		{
			if (myHand.readDie(i) == 3)
			{
				testPoints+=3;
			}
		}
		assertEquals(testPoints, test.calcThrees(myHand));
	}
	
	@Test
	public void testCalcFours() {
		int testPoints = 0;
		myHand.rollAll();
		while (myHand.fiveDice.get(0).readFaceUp() != 4){
			myHand.rollDie(0);
		}
		for (int i = 0; i < myHand.fiveDice.size(); i++)
		{
			if (myHand.readDie(i) == 4)
			{
				testPoints+=4;
			}
		}
		assertEquals(testPoints, test.calcFours(myHand));
	}
	
	@Test
	public void testCalcFives() {
		int testPoints = 0;
		myHand.rollAll();
		while (myHand.fiveDice.get(0).readFaceUp() != 5){
			myHand.rollDie(0);
		}
		for (int i = 0; i < myHand.fiveDice.size(); i++)
		{
			if (myHand.readDie(i) == 5)
			{
				testPoints+=5;
			}
		}
		assertEquals(testPoints, test.calcFives(myHand));
	}
	
	@Test
	public void testCalcSixes() {
		int testPoints = 0;
		myHand.rollAll();
		while (myHand.fiveDice.get(0).readFaceUp() != 6){
			myHand.rollDie(0);
		}
		for (int i = 0; i < myHand.fiveDice.size(); i++)
		{
			if (myHand.readDie(i) == 6)
			{
				testPoints+=6;
			}
		}
		assertEquals(testPoints, test.calcSixes(myHand));
	}
	
	@Test
	public void testCalcThreeOfAKind() {
		myHand.rollAll();
		
		//first force to get three of a kind
		int points = 0;
		
		while (myHand.fiveDice.get(0).readFaceUp() != 1){
			myHand.rollDie(0);
		}
		while (myHand.fiveDice.get(1).readFaceUp() != 1){
			myHand.rollDie(1);
		}
		while (myHand.fiveDice.get(2).readFaceUp() != 1){
			myHand.rollDie(2);
		}
		int die1 = myHand.readDie(0);
		int die2 = myHand.readDie(1);
		int die3 = myHand.readDie(2);
		int die4 = myHand.readDie(3);
		int die5 = myHand.readDie(4);
		
		if (die1 == die2 && die2 == die3)
		{
			points = die1 + die2 + die3 + die4 + die5;
		}
		assertEquals(points, test.calcThreeOfAKind(myHand));
		
		//second force to get three of a kind
		points = 0;
		while (myHand.fiveDice.get(3).readFaceUp() != 1){
			myHand.rollDie(3);
		}
		die4 = myHand.readDie(3);
		
		
		if (die2 == die3 && die3 == die4)
		{
			points = die1 + die2 + die3 + die4 + die5;
		}
		assertEquals(points, test.calcThreeOfAKind(myHand));
		
		//third force to get three of a kind
		points = 0;
		while (myHand.fiveDice.get(4).readFaceUp() != 1){
			myHand.rollDie(4);
		}
		die5 = myHand.readDie(4);
		
		if (die3 == die4 && die4 == die5)
		{
			points = die1 + die2 + die3 + die4 + die5;
		}
		assertEquals(points, test.calcThreeOfAKind(myHand));
		
		//force to NOT get three of a kind
		points = 0;
		while (myHand.fiveDice.get(0).readFaceUp() != 1){
			myHand.rollDie(0);
		}
		while (myHand.fiveDice.get(1).readFaceUp() != 2){
			myHand.rollDie(1);
		}
		while (myHand.fiveDice.get(2).readFaceUp() != 3){
			myHand.rollDie(2);
		}
		while (myHand.fiveDice.get(3).readFaceUp() != 4){
			myHand.rollDie(3);
		}
		while (myHand.fiveDice.get(4).readFaceUp() != 5){
			myHand.rollDie(4);
		}
		die1 = myHand.readDie(0);
		die2 = myHand.readDie(1);
		die3 = myHand.readDie(2);
		die4 = myHand.readDie(3);
		die5 = myHand.readDie(4);
		
		if (die1 == die2 && die2 == die3)
		{
			points = die1 + die2 + die3 + die4 + die5;
		}
		assertEquals(points, test.calcThreeOfAKind(myHand));
	}
	
	@Test
	public void testCalcFourOfAKind() {
		myHand.rollAll();
		
		//first force to be 4 of a kind
		int points = 0;
		
		while (myHand.fiveDice.get(0).readFaceUp() != 1){
			myHand.rollDie(0);
		}
		while (myHand.fiveDice.get(1).readFaceUp() != 1){
			myHand.rollDie(1);
		}
		while (myHand.fiveDice.get(2).readFaceUp() != 1){
			myHand.rollDie(2);
		}
		while (myHand.fiveDice.get(3).readFaceUp() != 1){
			myHand.rollDie(3);
		}
		int die1 = myHand.readDie(0);
		int die2 = myHand.readDie(1);
		int die3 = myHand.readDie(2);
		int die4 = myHand.readDie(3);
		int die5 = myHand.readDie(4);
		
		if (die1 == die2 && die2 == die3 && die3 == die4)
		{
			points = die1 + die2 + die3 + die4 + die5;
		}
		assertEquals(points, test.calcFourOfAKind(myHand));
		
		//second force to be 4 of a kind
		points = 0;
		while (myHand.fiveDice.get(4).readFaceUp() != 1){
			myHand.rollDie(4);
		}
		die5 = myHand.readDie(4);
		
		if (die2 == die3 && die3 == die4 && die4 == die5)
		{
			points = die1 + die2 + die3 + die4 + die5;
		}
		assertEquals(points, test.calcFourOfAKind(myHand));
		
		//force to NOT get four of a kind
		points = 0;
		while (myHand.fiveDice.get(0).readFaceUp() != 1){
			myHand.rollDie(0);
		}
		while (myHand.fiveDice.get(1).readFaceUp() != 2){
			myHand.rollDie(1);
		}
		while (myHand.fiveDice.get(2).readFaceUp() != 3){
			myHand.rollDie(2);
		}
		while (myHand.fiveDice.get(3).readFaceUp() != 4){
			myHand.rollDie(3);
		}
		while (myHand.fiveDice.get(4).readFaceUp() != 5){
			myHand.rollDie(4);
		}
		die1 = myHand.readDie(0);
		die2 = myHand.readDie(1);
		die3 = myHand.readDie(2);
		die4 = myHand.readDie(3);
		die5 = myHand.readDie(4);
		
		if (die1 == die2 && die2 == die3 && die3 == die4)
		{
			points = die1 + die2 + die3 + die4 + die5;
		}
		assertEquals(points, test.calcFourOfAKind(myHand));
	}
	
	@Test
	public void testCalcFullHouse() {
		
		//first force to full house
		while (myHand.fiveDice.get(0).readFaceUp() != 1){
			myHand.rollDie(0);
		}
		while (myHand.fiveDice.get(1).readFaceUp() != 1){
			myHand.rollDie(1);
		}
		while (myHand.fiveDice.get(2).readFaceUp() != 1){
			myHand.rollDie(2);
		}
		while (myHand.fiveDice.get(3).readFaceUp() != 2){
			myHand.rollDie(3);
		}
		while (myHand.fiveDice.get(4).readFaceUp() != 2){
			myHand.rollDie(4);
		}
		assertEquals(25, test.calcFullHouse(myHand));
		
		//second force to full house
		while (myHand.fiveDice.get(2).readFaceUp() != 2){
			myHand.rollDie(2);
		}
		assertEquals(25, test.calcFullHouse(myHand));
		
		//force NOT to full house
		while (myHand.fiveDice.get(1).readFaceUp() != 2){
			myHand.rollDie(1);
		}
		assertEquals(0, test.calcFullHouse(myHand));
	}
	
	@Test
	public void testCalcSmallStraight() {
		//force to small straight
		while (myHand.fiveDice.get(0).readFaceUp() != 1){
			myHand.rollDie(0);
		}
		while (myHand.fiveDice.get(1).readFaceUp() != 2){
			myHand.rollDie(1);
		}
		while (myHand.fiveDice.get(2).readFaceUp() != 3){
			myHand.rollDie(2);
		}
		while (myHand.fiveDice.get(3).readFaceUp() != 4){
			myHand.rollDie(3);
		}
		while (myHand.fiveDice.get(4).readFaceUp() != 4){
			myHand.rollDie(4);
		}
		assertEquals(30, test.calcSmallStraight(myHand));
		
		//second force to small straight
		while (myHand.fiveDice.get(0).readFaceUp() != 2){
			myHand.rollDie(0);
		}
		while (myHand.fiveDice.get(4).readFaceUp() != 5){
			myHand.rollDie(4);
		}
		assertEquals(30, test.calcSmallStraight(myHand));
		
		//force not to small straight
		while (myHand.fiveDice.get(4).readFaceUp() != 4){
			myHand.rollDie(4);
		}
		assertEquals(0, test.calcSmallStraight(myHand));
	}
	
	@Test
	public void testCalcLargeStraight() {
		
		//force to large straight
		while (myHand.fiveDice.get(0).readFaceUp() != 1){
			myHand.rollDie(0);
		}
		while (myHand.fiveDice.get(1).readFaceUp() != 2){
			myHand.rollDie(1);
		}
		while (myHand.fiveDice.get(2).readFaceUp() != 3){
			myHand.rollDie(2);
		}
		while (myHand.fiveDice.get(3).readFaceUp() != 4){
			myHand.rollDie(3);
		}
		while (myHand.fiveDice.get(4).readFaceUp() != 5){
			myHand.rollDie(4);
		}
		assertEquals(40, test.calcLargeStraight(myHand));
		
		//force NOT to large straight
		while (myHand.fiveDice.get(4).readFaceUp() != 5){
			myHand.rollDie(4);
		}
		assertEquals(40, test.calcLargeStraight(myHand));
	}

	@Test
	public void testCalcChance() {
		myHand.rollAll();
		
		int die1 = myHand.readDie(0);
		int die2 = myHand.readDie(1);
		int die3 = myHand.readDie(2);
		int die4 = myHand.readDie(3);
		int die5 = myHand.readDie(4);
		
		int points = die1 + die2 + die3 + die4 + die5;
		assertEquals(points, test.calcChance(myHand));
	}
	
	@Test
	public void testYahtzee() {
		//force to yahtzee
		while (myHand.fiveDice.get(0).readFaceUp() != 1){
			myHand.rollDie(0);
		}
		while (myHand.fiveDice.get(1).readFaceUp() != 1){
			myHand.rollDie(1);
		}
		while (myHand.fiveDice.get(2).readFaceUp() != 1){
			myHand.rollDie(2);
		}
		while (myHand.fiveDice.get(3).readFaceUp() != 1){
			myHand.rollDie(3);
		}
		while (myHand.fiveDice.get(4).readFaceUp() != 1){
			myHand.rollDie(4);
		}
		assertEquals(50, test.calcYahtzee(myHand));
		
		//force to NOT yahtzee
		while (myHand.fiveDice.get(4).readFaceUp() != 2){
			myHand.rollDie(4);
		}
		assertEquals(0, test.calcYahtzee(myHand));
	}
	
	@Test
	public void testAnotherYahtzee() {
		//set dice to be a yahtzee
		while (myHand.fiveDice.get(0).readFaceUp() != 1){
			myHand.rollDie(0);
		}
		while (myHand.fiveDice.get(1).readFaceUp() != 1){
			myHand.rollDie(1);
		}
		while (myHand.fiveDice.get(2).readFaceUp() != 1){
			myHand.rollDie(2);
		}
		while (myHand.fiveDice.get(3).readFaceUp() != 1){
			myHand.rollDie(3);
		}
		while (myHand.fiveDice.get(4).readFaceUp() != 1){
			myHand.rollDie(4);
		}
		
		//test points for first yahtzee
		test.setYahtzeePoints(-1);
		assertEquals(50, test.calcYahtzee(myHand));
		
		//test points second yahtzee
		test.setYahtzeePoints(50);
		assertEquals(100, test.calcYahtzee(myHand));
		
		//test points for third yahtzee
		test.setYahtzeePoints(150);
		assertEquals(100, test.calcYahtzee(myHand));
		
		//make sure no points are given if yahtzee category has already been scored as 0
		test.setYahtzeePoints(0);
		assertEquals(0, test.calcYahtzee(myHand));
		
		//force to NOT yahtzee
		while (myHand.fiveDice.get(0).readFaceUp() != 5){
			myHand.rollDie(0);
		}
		assertEquals(0, test.calcYahtzee(myHand));
	}
	
	@Test
	public void testGetZeros() {
		test.setOnesPoints(5);
		test.setTwosPoints(10);
		test.setThreesPoints(10);
		test.setFoursPoints(10);
		test.setThreeOfAKindPoints(9);
		test.setFourOfAKindPoints(0);
		test.setFullHousePoints(25);
		test.setSmallStraightPoints(30);
		test.setChancePoints(10);
		test.setYahtzeePoints(50);
		
		myHand.rollAll();
		while (myHand.fiveDice.get(0).readFaceUp() != 2){
			myHand.rollDie(0);
		}
		while (myHand.fiveDice.get(1).readFaceUp() != 2){
			myHand.rollDie(1);
		}
		while (myHand.fiveDice.get(2).readFaceUp() != 2){
			myHand.rollDie(2);
		}
		while (myHand.fiveDice.get(3).readFaceUp() != 1){
			myHand.rollDie(3);
		}
		while (myHand.fiveDice.get(4).readFaceUp() != 1){
			myHand.rollDie(4);
		}
		String expectedString = "Which category do you want to score? \n" +
								"Sorry, no score categories are available!\n" +
								"You must choose a category to score with 0 points.\n" +
								"5 \t Fives \t\t\t 0  points\n" +
								"6 \t Sixes \t\t\t 0  points\n" +
								"L \t Large Straight \t 0  points\n";
		assertEquals(expectedString, test.getScoreChoices(myHand));
		
		test.setOnesPoints(-1);
		test.setTwosPoints(-1);
		test.setThreesPoints(-1);
		test.setFoursPoints(-1);
		test.setThreeOfAKindPoints(-1);
		test.setFourOfAKindPoints(-1);
		test.setFullHousePoints(-1);
		test.setSmallStraightPoints(-1);
		test.setChancePoints(-1);
		test.setYahtzeePoints(-1);
		
	}
}