package scoring;

import java.util.HashMap;

import business.Hand;

//TODO many nested ifs : better to hard code the scoring?

/**
 * @author Sata Wille
 * The YahtzeeScore abstract class includes all equations required to calculate the score of a Yahtzee game.
 * The class must be inherited by a ScoreBoard class, which will manage the scoring menu display
 * and get input from the player to score the current Hand.
 * 
 * The HashMap scoreCategoryOptions contains the ScoreCategory enumerators and the points available
 * for each category given the face up dice in the current Hand (calculated via handValues in DiceScore).
 */

public abstract class YahtzeeScore extends DiceScore{
	
	public static HashMap<ScoreCategory, Integer> scoreCategoryOptions = new HashMap<>();
	
	/**
	 * updateScore() - This abstract method is empty and will be implemented by the ScoreBoard class
	 * that inherits YahtzeeScore.
	 */
	@Override
	public abstract void updateScore(Hand newHand);

	/**
	 * resetScoreCategoryOptions() - This method resets the HashMap of possible points available
	 * for each category.  It should be called before each new Hand of dice is scored.
	 */
	public static void resetScoreCategoryOptions() {
		scoreCategoryOptions.put(ScoreCategory.ONES, 0);
		scoreCategoryOptions.put(ScoreCategory.TWOS, 0);
		scoreCategoryOptions.put(ScoreCategory.THREES, 0);
		scoreCategoryOptions.put(ScoreCategory.FOURS, 0);
		scoreCategoryOptions.put(ScoreCategory.FIVES, 0);
		scoreCategoryOptions.put(ScoreCategory.SIXES, 0);
		scoreCategoryOptions.put(ScoreCategory.THREE_OF_A_KIND, 0);
		scoreCategoryOptions.put(ScoreCategory.FOUR_OF_A_KIND, 0);
		scoreCategoryOptions.put(ScoreCategory.FULL_HOUSE, 0);
		scoreCategoryOptions.put(ScoreCategory.SMALL_STRAIGHT, 0);
		scoreCategoryOptions.put(ScoreCategory.LARGE_STRAIGHT, 0);
		scoreCategoryOptions.put(ScoreCategory.CHANCE, 0);
		scoreCategoryOptions.put(ScoreCategory.YAHTZEE, 0);
	}

	/**
	 * calcUpperScores() - This method calculates possible points for the following categories:
	 * ONES, TWOS, THREES, FOURS, FIVES, SIXES.  The ScoreCateogry and corresponding points 
	 * are stored in the HashMap scoreCategryOptions, overriding the default 0 value for points.
	 * Points = face value * number of instances.
	 * @param category
	 * @param numberToScore
	 */
	public static void calcUpperScores(ScoreCategory category, int numberToScore) {		
		scoreCategoryOptions.put(category, handValues.get(""+numberToScore) * numberToScore);
	}

	/**
	 * calcThreeOfAKind() - This method calculates possible points for the THREE_OF_A_KIND category.
	 * If a single face value appears 3 or more times in the Hand, THREE_OF_A_KIND can be scored.
	 * The ScoreCateogry and corresponding points are stored in the HashMap scoreCategryOptions, 
	 * overriding the default 0 value for points.
	 * Points = face value * number of instances.
	 */
	public static void calcThreeOfAKind() {
		for (int counter = 1; counter <= 6; counter++)
		{
			String value = ""+counter;
			if (handValues.get(value)==5)
			{
				scoreCategoryOptions.put(ScoreCategory.THREE_OF_A_KIND, counter*5);
			}
			else if (handValues.get(value)==4)
			{
				scoreCategoryOptions.put(ScoreCategory.THREE_OF_A_KIND, counter*4);
			}
			else if (handValues.get(value)==3)
			{
				scoreCategoryOptions.put(ScoreCategory.THREE_OF_A_KIND, counter*3);
			}
		}

	}

	/**
	 * calcFourOfAKind() - This method calculates possible points for the FOUR_OF_A_KIND category.
	 * If a single face value appears 4 or more times in the Hand, FOUR_OF_A_KIND can be scored.
	 * The ScoreCateogry and corresponding points are stored in the HashMap scoreCategryOptions, 
	 * overriding the default 0 value for points.
	 * Points = face value * number of instances.
	 */
	public static void calcFourOfAKind() {
		for (int counter = 1; counter <= 6; counter++)
		{
			String value = ""+counter;
			if (handValues.get(value)==5)
			{
				scoreCategoryOptions.put(ScoreCategory.FOUR_OF_A_KIND, counter*5);
			}
			else if (handValues.get(value)==4)
			{
				scoreCategoryOptions.put(ScoreCategory.FOUR_OF_A_KIND, counter*4);
			}
		}
	}
	
	/**
	 * calcFullHouse() - This method calculates possible points for the FULL_HOUSE category.
	 * If a single face value appears 2 times and another face values appears 3 times in the Hand, 
	 * FULL_HOUSE can be scored. The ScoreCateogry and corresponding points are stored in the 
	 * HashMap scoreCategryOptions, overriding the default 0 value for points.
	 * Points = 25.
	 */
	public static void calcFullHouse() {
		if (handValues.containsValue(2) && handValues.containsValue(3)) 
		{
			scoreCategoryOptions.put(ScoreCategory.FULL_HOUSE, 25);
		}
	}
	
	/**
	 * calcSmallStraight() - This method calculates possible points for the SMALL_STRAIGHT category.
	 * If the Hand contains a run of at least 4 consecutive face values, SMALL_STRAIGHT can be scored. 
	 * The ScoreCateogry and corresponding points are stored in the HashMap scoreCategryOptions, 
	 * overriding the default 0 value for points.
	 * Points = 30.
	 */
	public static void calcSmallStraight() {
		int product = 1;
		for (int start = 1; start <= 3; start++) {
			for (int die = 1; die <= 4; die++) {
				product *= handValues.get(""+die);
			}
			if (product != 0) {
				scoreCategoryOptions.put(ScoreCategory.SMALL_STRAIGHT, 30);
			}
		}
	}
	
	/**
	 * calcLargeStraight() - This method calculates possible points for the LARGE_STRAIGHT category.
	 * If the Hand contains a run of 5 consecutive face values (all 5 dice are consecutive), 
	 * LARGE_STRAIGHT can be scored. The ScoreCateogry and corresponding points are stored in the 
	 * HashMap scoreCategryOptions, overriding the default 0 value for points.
	 * Points = 40.
	 */
	public static void calcLargeStraight() {
		if (findMaxValueCount() == 1)
		{
			if (handValues.get("1") == 0 || handValues.get("6") == 0) 
			{
				scoreCategoryOptions.put(ScoreCategory.LARGE_STRAIGHT, 40);
			}
		}
	}
	
	/**
	 * calcChance() - This method calculates possible points for the CHANCE category.
	 * CHANCE is a free category that can be scored on any Hand, containing any combo of face values. 
	 * The ScoreCateogry and corresponding points are stored in the HashMap scoreCategryOptions, 
	 * overriding the default 0 value for points.
	 * Points = sum of all 5 dice.
	 */
	public static void calcChance() {
		int sum = 0;
		for (int counter = 1; counter <= 6; counter++)
		{
			String value = ""+counter;
			sum += handValues.get(value)*counter;
		}
		scoreCategoryOptions.put(ScoreCategory.CHANCE, sum);
	}
	
	//TODO is there a better way to handle Yahtzee points being passed in from the ScoreBoard class?
	/**
	 * calcYahtzee() - This method calculates possible points for the YAHTZEE category.
	 * If the Hand contains 5 dice of equal face up values (all 5 dice are the same value), 
	 * YAHTZEE can be scored. The ScoreCateogry and corresponding points are stored in the 
	 * HashMap scoreCategryOptions, overriding the default 0 value for points.
	 * 
	 * Yahtzee is scored differently depending on whether or not it is the first Yahtzee in the Hand.
	 * The YahtzeeScoreBoard class handles how many times Yahtzee has been scored and passes in 
	 * the correct number of points to be scored accordingly.
	 * Points = 50 for first Yahtzee, 100 for each subsequent Yahtzee.
	 */
	public static void calcYahtzee(int points) {
		if (findMaxValueCount() == 5)
		{
			scoreCategoryOptions.put(ScoreCategory.YAHTZEE, points);
		}
	}
	
	/**
	 * findMaxValueCount() - This method cycles through the values in the HashMap handValues
	 * and returns the maximum number of times a single value appears.
	 * For example, the first handValues below would return 1, and the second would return 3.
	 * handValues1: 1-0, 2-1, 3-1, 4-1, 5-1, 6-1
	 * handValues2: 1-3, 2-0, 3-0, 4-0, 5-2, 6-0 
	 * @return maxValue
	 */
	public static int findMaxValueCount() {
		int maxValue = 0;
		for (int counter = 1; counter <= 6; counter++)
		{
			String value = ""+counter;
			if (handValues.get(value) > maxValue)
			{
				maxValue = handValues.get(value);
			}
		}
		return maxValue;
	}


}
