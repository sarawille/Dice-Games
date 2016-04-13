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

	//TODO best practices for testing when method requires user input
	@Test
	public void testGetInt() {
		System.out.println("\nTesting getInt()");
		//type in a
		//type in 5
		assertEquals(5, checker.getInt("Enter integer "));
	}
	
	@Test
	public void testGetIntInRange() {
		System.out.println("\nTesting getInt() IN RANGE");
		//type in a
		//type in 0
		//type in 11
		//type in 5
		assertEquals(5, checker.getInt("Enter integer between 1 and 10 ", 1, 10));
	}
	
	@Test
	public void testGetDouble() {
		System.out.println("\nTesting getDouble()");
		//type in a
		//type in 5
		assertEquals(5, checker.getDouble("Enter double "), .0005);
	}
	
	@Test
	public void testGetDoubleInRange() {
		System.out.println("\nTesting getDouble() IN RANGE");
		//type in a
		//type in 0
		//type in 11
		//type in 5
		assertEquals(5, checker.getDouble("Enter double between 1 and 10 ", 1, 10), .0005);
	}

}
