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
		//enter 1
		assertEquals(ScoreCategory.ONES, scoreBoard.assignScoreCategory());
	}

}
