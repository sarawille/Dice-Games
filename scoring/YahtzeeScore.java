package scoring;

import java.util.HashMap;

import business.Hand;
import ui.Displayable;
import ui.IOFactory;
import ui.Validator;

public class YahtzeeScore extends DiceScore{
	
	public static HashMap<ScoreCategory, Integer> scoreCategoryOptions = new HashMap<>();
	
	@Override
	public void updateScore(Hand newHand) {}

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

	
	public static void calcUpperScores(ScoreCategory category, int numberToScore) {		
		scoreCategoryOptions.put(category, handValues.get(""+numberToScore) * numberToScore);
	}

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
	
	public static void calcFullHouse() {
		if (handValues.containsValue(2) && handValues.containsValue(3)) 
		{
			scoreCategoryOptions.put(ScoreCategory.FULL_HOUSE, 25);
		}
	}
	
	public static void calcSmallStraight() {
		if (findMaxValueCount() == 1) {
			if (handValues.get("1") == 0 ||
					handValues.get("2") == 0 ||
					handValues.get("5") == 0 ||
					handValues.get("6") == 0 ) 
			{
				scoreCategoryOptions.put(ScoreCategory.SMALL_STRAIGHT, 30);
			}
		}
		else if (findMaxValueCount() == 2) {
			if ((handValues.get("1") == 0 && handValues.get("2") == 0) ||
					(handValues.get("5") == 0 && handValues.get("6") == 0)) 
			{
				scoreCategoryOptions.put(ScoreCategory.SMALL_STRAIGHT, 30);
			}
		}
	}
	
	public static void calcLargeStraight() {
		if (findMaxValueCount() == 1)
		{
			if (handValues.get("1") == 0 || handValues.get("6") == 0) 
			{
				scoreCategoryOptions.put(ScoreCategory.LARGE_STRAIGHT, 40);
			}
		}
	}
	
	public static void calcChance() {
		int sum = 0;
		for (int counter = 1; counter <= 6; counter++)
		{
			String value = ""+counter;
			sum += handValues.get(value)*counter;
		}
		scoreCategoryOptions.put(ScoreCategory.CHANCE, sum);
	}
	
	public static void calcYahtzee(int points) {
		if (findMaxValueCount() == 5)
		{
			scoreCategoryOptions.put(ScoreCategory.YAHTZEE, points);
		}
	}
	
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
