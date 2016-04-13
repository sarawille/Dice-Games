package testYahtzee;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ui.Displayable;
import ui.IOFactory;
import ui.SimpleDisplay;
import ui.Validator;

public class TestValidator {
	
	static Displayable screen;
	static Validator checker;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		screen = IOFactory.getDisplayable();
		checker = new Validator(screen);
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
	public void testGetInt() {
		assertEquals(5, checker.getInt("Enter integer "));
	}
	
	@Test
	public void testGetIntInRange() {
		assertEquals(5, checker.getInt("Enter integer ", 1, 10));
	}

}
