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
	static int die1;
	static int die2;
	static int die3;
	static int die4;
	static int die5;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test = new ScoreEquations();
		myHand = new Hand();
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
		int onesPossiblePoints = test.getOnesPossiblePoints();
		int onesPoints = test.getOnesPoints();
		int testPoints = 0;
		myHand.rollAll();
		for (int i = 0; i < myHand.fiveDice.size(); i++)
		{
			if (myHand.readFaceUp(i) == 1)
			{
				testPoints++;
			}
		}
		assertEquals(testPoints, test.calcSingleNumbers(myHand, onesPossiblePoints, onesPoints, 1, "Ones"));
	}
	
	@Test
	public void testCalcTwos() {
		int twosPossiblePoints = test.getTwosPossiblePoints();
		int twosPoints = test.getTwosPoints();
		int testPoints = 0;
		myHand.rollAll();
		for (int i = 0; i < myHand.fiveDice.size(); i++)
		{
			if (myHand.readFaceUp(i) == 2)
			{
				testPoints+=2;
			}
		}
		assertEquals(testPoints, test.calcSingleNumbers(myHand, twosPossiblePoints, twosPoints, 2, "Twos"));
	}
	
	@Test
	public void testCalcThrees() {
		int threesPossiblePoints = test.getThreesPossiblePoints();
		int threesPoints = test.getThreesPoints();
		int testPoints = 0;
		myHand.rollAll();
		for (int i = 0; i < myHand.fiveDice.size(); i++)
		{
			if (myHand.readFaceUp(i) == 3)
			{
				testPoints+=3;
			}
		}
		assertEquals(testPoints, test.calcSingleNumbers(myHand, threesPossiblePoints, threesPoints, 3, "Threes"));
	}
	
	@Test
	public void testCalcFours() {
		int foursPossiblePoints = test.getFoursPossiblePoints();
		int foursPoints = test.getFoursPoints();
		int testPoints = 0;
		myHand.rollAll();
		for (int i = 0; i < myHand.fiveDice.size(); i++)
		{
			if (myHand.readFaceUp(i) == 4)
			{
				testPoints+=4;
			}
		}
		assertEquals(testPoints, test.calcSingleNumbers(myHand, foursPossiblePoints, foursPoints, 4, "Fours"));
	}
	
	@Test
	public void testCalcFives() {
		int fivesPossiblePoints = test.getFivesPossiblePoints();
		int fivesPoints = test.getFivesPoints();
		int testPoints = 0;
		myHand.rollAll();
		for (int i = 0; i < myHand.fiveDice.size(); i++)
		{
			if (myHand.readFaceUp(i) == 5)
			{
				testPoints+=5;
			}
		}
		assertEquals(testPoints, test.calcSingleNumbers(myHand, fivesPossiblePoints, fivesPoints, 5, "Fives"));
	}
	
	@Test
	public void testCalcSixes() {
		int sixesPossiblePoints = test.getSixesPossiblePoints();
		int sixesPoints = test.getSixesPoints();
		int testPoints = 0;
		myHand.rollAll();
		for (int i = 0; i < myHand.fiveDice.size(); i++)
		{
			if (myHand.readFaceUp(i) == 6)
			{
				testPoints+=6;
			}
		}
		assertEquals(testPoints, test.calcSingleNumbers(myHand, sixesPossiblePoints, sixesPoints, 6, "Sixes"));
	}
	
	@Test
	public void testCalcThreeOfAKind() {
		myHand.rollAll();
		
		//first force to get three of a kind
		int points = 0;
		
		while (myHand.fiveDice.get(0).readFaceUp() != 1){
			myHand.roll(0);
		}
		while (myHand.fiveDice.get(1).readFaceUp() != 1){
			myHand.roll(1);
		}
		while (myHand.fiveDice.get(2).readFaceUp() != 1){
			myHand.roll(2);
		}
		die1 = myHand.readFaceUp(0);
		die2 = myHand.readFaceUp(1);
		die3 = myHand.readFaceUp(2);
		die4 = myHand.readFaceUp(3);
		die5 = myHand.readFaceUp(4);
		
		if (die1 == die2 && die2 == die3)
		{
			points = die1 + die2 + die3 + die4 + die5;
		}
		assertEquals(points, test.calcThreeOfAKind(myHand));
		
		//second force to get three of a kind
		points = 0;
		while (myHand.fiveDice.get(3).readFaceUp() != 1){
			myHand.roll(3);
		}
		die4 = myHand.readFaceUp(3);
		
		
		if (die2 == die3 && die3 == die4)
		{
			points = die1 + die2 + die3 + die4 + die5;
		}
		assertEquals(points, test.calcThreeOfAKind(myHand));
		
		//third force to get three of a kind
		points = 0;
		while (myHand.fiveDice.get(4).readFaceUp() != 1){
			myHand.roll(4);
		}
		die5 = myHand.readFaceUp(4);
		
		if (die3 == die4 && die4 == die5)
		{
			points = die1 + die2 + die3 + die4 + die5;
		}
		assertEquals(points, test.calcThreeOfAKind(myHand));
		
		//force to NOT get three of a kind
		points = 0;
		while (myHand.fiveDice.get(0).readFaceUp() != 1){
			myHand.roll(0);
		}
		while (myHand.fiveDice.get(1).readFaceUp() != 2){
			myHand.roll(1);
		}
		while (myHand.fiveDice.get(2).readFaceUp() != 3){
			myHand.roll(2);
		}
		while (myHand.fiveDice.get(3).readFaceUp() != 4){
			myHand.roll(3);
		}
		while (myHand.fiveDice.get(4).readFaceUp() != 5){
			myHand.roll(4);
		}
		die1 = myHand.readFaceUp(0);
		die2 = myHand.readFaceUp(1);
		die3 = myHand.readFaceUp(2);
		die4 = myHand.readFaceUp(3);
		die5 = myHand.readFaceUp(4);
		
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
			myHand.roll(0);
		}
		while (myHand.fiveDice.get(1).readFaceUp() != 1){
			myHand.roll(1);
		}
		while (myHand.fiveDice.get(2).readFaceUp() != 1){
			myHand.roll(2);
		}
		while (myHand.fiveDice.get(3).readFaceUp() != 1){
			myHand.roll(3);
		}
		die1 = myHand.readFaceUp(0);
		die2 = myHand.readFaceUp(1);
		die3 = myHand.readFaceUp(2);
		die4 = myHand.readFaceUp(3);
		die5 = myHand.readFaceUp(4);
		
		if (die1 == die2 && die2 == die3 && die3 == die4)
		{
			points = die1 + die2 + die3 + die4 + die5;
		}
		assertEquals(points, test.calcFourOfAKind(myHand));
		
		//second force to be 4 of a kind
		points = 0;
		while (myHand.fiveDice.get(4).readFaceUp() != 1){
			myHand.roll(4);
		}
		die5 = myHand.readFaceUp(4);
		
		if (die2 == die3 && die3 == die4 && die4 == die5)
		{
			points = die1 + die2 + die3 + die4 + die5;
		}
		assertEquals(points, test.calcFourOfAKind(myHand));
		
		//force to NOT get four of a kind
		points = 0;
		while (myHand.fiveDice.get(0).readFaceUp() != 1){
			myHand.roll(0);
		}
		while (myHand.fiveDice.get(1).readFaceUp() != 2){
			myHand.roll(1);
		}
		while (myHand.fiveDice.get(2).readFaceUp() != 3){
			myHand.roll(2);
		}
		while (myHand.fiveDice.get(3).readFaceUp() != 4){
			myHand.roll(3);
		}
		while (myHand.fiveDice.get(4).readFaceUp() != 5){
			myHand.roll(4);
		}
		die1 = myHand.readFaceUp(0);
		die2 = myHand.readFaceUp(1);
		die3 = myHand.readFaceUp(2);
		die4 = myHand.readFaceUp(3);
		die5 = myHand.readFaceUp(4);
		
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
			myHand.roll(0);
		}
		while (myHand.fiveDice.get(1).readFaceUp() != 1){
			myHand.roll(1);
		}
		while (myHand.fiveDice.get(2).readFaceUp() != 1){
			myHand.roll(2);
		}
		while (myHand.fiveDice.get(3).readFaceUp() != 2){
			myHand.roll(3);
		}
		while (myHand.fiveDice.get(4).readFaceUp() != 2){
			myHand.roll(4);
		}
		assertEquals(25, test.calcFullHouse(myHand));
		
		//second force to full house
		while (myHand.fiveDice.get(2).readFaceUp() != 2){
			myHand.roll(2);
		}
		assertEquals(25, test.calcFullHouse(myHand));
		
		//force NOT to full house
		while (myHand.fiveDice.get(1).readFaceUp() != 2){
			myHand.roll(1);
		}
		assertEquals(0, test.calcFullHouse(myHand));
	}
	
	@Test
	public void testCalcSmallStraight() {
		//force to small straight
		while (myHand.fiveDice.get(0).readFaceUp() != 1){
			myHand.roll(0);
		}
		while (myHand.fiveDice.get(1).readFaceUp() != 2){
			myHand.roll(1);
		}
		while (myHand.fiveDice.get(2).readFaceUp() != 3){
			myHand.roll(2);
		}
		while (myHand.fiveDice.get(3).readFaceUp() != 4){
			myHand.roll(3);
		}
		while (myHand.fiveDice.get(4).readFaceUp() != 4){
			myHand.roll(4);
		}
		assertEquals(30, test.calcSmallStraight(myHand));
		
		//second force to small straight
		while (myHand.fiveDice.get(0).readFaceUp() != 2){
			myHand.roll(0);
		}
		while (myHand.fiveDice.get(4).readFaceUp() != 5){
			myHand.roll(4);
		}
		assertEquals(30, test.calcSmallStraight(myHand));
		
		//force not to small straight
		while (myHand.fiveDice.get(4).readFaceUp() != 4){
			myHand.roll(4);
		}
		assertEquals(0, test.calcSmallStraight(myHand));
	}
	
	@Test
	public void testCalcLargeStraight() {
		
		//force to large straight
		while (myHand.fiveDice.get(0).readFaceUp() != 1){
			myHand.roll(0);
		}
		while (myHand.fiveDice.get(1).readFaceUp() != 2){
			myHand.roll(1);
		}
		while (myHand.fiveDice.get(2).readFaceUp() != 3){
			myHand.roll(2);
		}
		while (myHand.fiveDice.get(3).readFaceUp() != 4){
			myHand.roll(3);
		}
		while (myHand.fiveDice.get(4).readFaceUp() != 5){
			myHand.roll(4);
		}
		assertEquals(40, test.calcLargeStraight(myHand));
		
		//force NOT to large straight
		while (myHand.fiveDice.get(4).readFaceUp() != 5){
			myHand.roll(4);
		}
		assertEquals(40, test.calcLargeStraight(myHand));
	}

	@Test
	public void testCalcChance() {
		myHand.rollAll();
		
		die1 = myHand.readFaceUp(0);
		die2 = myHand.readFaceUp(1);
		die3 = myHand.readFaceUp(2);
		die4 = myHand.readFaceUp(3);
		die5 = myHand.readFaceUp(4);
		
		int points = die1 + die2 + die3 + die4 + die5;
		assertEquals(points, test.calcChance(myHand));
	}
	
	@Test
	public void testYahtzee() {
		//force to yahtzee
		while (myHand.fiveDice.get(0).readFaceUp() != 1){
			myHand.roll(0);
		}
		while (myHand.fiveDice.get(1).readFaceUp() != 1){
			myHand.roll(1);
		}
		while (myHand.fiveDice.get(2).readFaceUp() != 1){
			myHand.roll(2);
		}
		while (myHand.fiveDice.get(3).readFaceUp() != 1){
			myHand.roll(3);
		}
		while (myHand.fiveDice.get(4).readFaceUp() != 1){
			myHand.roll(4);
		}
		assertEquals(50, test.calcYahtzee(myHand));
	}
	
	@Test
	public void testAnotherYahtzee() {
		//force to yahtzee
		test.setYahtzeePoints(50);
		//force to another yahtzee
		while (myHand.fiveDice.get(0).readFaceUp() != 1){
			myHand.roll(0);
		}
		while (myHand.fiveDice.get(1).readFaceUp() != 1){
			myHand.roll(1);
		}
		while (myHand.fiveDice.get(2).readFaceUp() != 1){
			myHand.roll(2);
		}
		while (myHand.fiveDice.get(3).readFaceUp() != 1){
			myHand.roll(3);
		}
		while (myHand.fiveDice.get(4).readFaceUp() != 1){
			myHand.roll(4);
		}
		assertEquals(100, test.calcYahtzee(myHand));
	}
}
