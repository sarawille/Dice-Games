package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ui.Displayable;
import ui.IOFactory;
import ui.Validator;

public class TestValidator {
	
	static Displayable screen;
	static Validator validator;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		screen = IOFactory.getDisplayable();
		validator = IOFactory.getValidator();
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
		assertEquals(5, validator.getInt("Enter integer "));
	}
	
	@Test
	public void testGetIntInRange() {
		System.out.println("\nTesting getInt() IN RANGE");
		//type in a
		//type in 0
		//type in 11
		//type in 5
		assertEquals(5, validator.getInt("Enter integer between 1 and 10 ", 1, 10));
	}
	
	@Test
	public void testGetDouble() {
		System.out.println("\nTesting getDouble()");
		//type in a
		//type in 5
		assertEquals(5, validator.getDouble("Enter double "), .0005);
	}
	
	@Test
	public void testGetDoubleInRange() {
		System.out.println("\nTesting getDouble() IN RANGE");
		//type in a
		//type in 0
		//type in 11
		//type in 5
		assertEquals(5, validator.getDouble("Enter double between 1 and 10 ", 1, 10), .0005);
	}
	
	@Test 
	public void testGetString() {
		System.out.println("\nTesting getString()");
		//hit enter
		//type "string"
		assertEquals("string", validator.getString("Enter some words "));
	}
	
	@Test
	public void testGetStringOfLength() {
		System.out.println("\nTesting getString() OF LENGTH");
		//hit enter
		//type "tree"
		//type "dog"
		assertEquals("dog", validator.getString("Enter 3 letters ", 3));
	}
	
	@Test
	public void testGetStringOptions() {
		System.out.println("\nTesting getString() FOR TWO INPUT OPTIONS");
		//type "z"
		//type "X"
		assertEquals("X", validator.getString("Enter x or y ", "x", "y"));
	}

}
