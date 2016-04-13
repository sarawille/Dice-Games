package testYahtzee;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ui.Displayable;
import ui.IOFactory;
import ui.Validator;
import db.ScoreCalculations;
import db.ScoreCategory;

public class TestScoreCalculations {
	
	static ScoreCalculations scoreBoard;
	static Displayable screen = IOFactory.getDisplayable();
	static Validator theValidator = new Validator(screen);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		scoreBoard = new ScoreCalculations(screen, theValidator);
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
	public void testAssignScoreCategory() {
		System.out.println("Testing assign score category");
		//enter 7
		//enter 1
		System.out.println("Enter 7, then 1");
		assertEquals(ScoreCategory.ONES, scoreBoard.assignScoreCategory());
		//enter 3k
		System.out.println("Enter 3k");
		assertEquals(ScoreCategory.THREE_OF_A_KIND, scoreBoard.assignScoreCategory());
		//enter Y
		System.out.println("Enter Y");
		assertEquals(ScoreCategory.YAHTZEE, scoreBoard.assignScoreCategory());
	}
	
	@Test
	public void testCalcTotalScore() {
		ScoreCategory userChoice;
		int total;
		
		userChoice = ScoreCategory.ONES;
		scoreBoard.setOnesPossiblePoints(5);
		total = 5;
		scoreBoard.calcTotalScore(userChoice);
		assertEquals(total, scoreBoard.getTotalScore());
		
		userChoice = ScoreCategory.LARGE_STRAIGHT;
		scoreBoard.setLargeStraightPossiblePoints(40);
		total += 40;
		scoreBoard.calcTotalScore(userChoice);
		assertEquals(total, scoreBoard.getTotalScore());
			
	}

}
