package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import scoring.ScoreCategory;

public class TestScoreCategory {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void testToString() {
		ScoreCategory threes = ScoreCategory.THREES;
		String threesToString = "Threes";
		assertEquals(threesToString, threes.toString());
		
		ScoreCategory fullHouse = ScoreCategory.FULL_HOUSE;
		String fullHouseToString = "Full House ";
		assertEquals(fullHouseToString, fullHouse.toString());
		
		ScoreCategory threeOfAKind = ScoreCategory.THREE_OF_A_KIND;
		String threeOfAKindToString = "Three Of A Kind ";
		assertEquals(threeOfAKindToString, threeOfAKind.toString());
	}

}
