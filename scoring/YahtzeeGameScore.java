package scoring;

import java.util.HashMap;

public class YahtzeeGameScore extends DiceGameScore{
	
	public HashMap<ScoreCategory, Integer> scoreCategoryOptions = new HashMap<>();
	public HashMap<ScoreCategory, Integer> scoreBoard = new HashMap<>();
	protected StringBuilder scoreChoices = new StringBuilder();
	
	public YahtzeeGameScore() {
		setScoreCategoryOptions();
		resetScoreBoard();
	}

	private void setScoreCategoryOptions() {
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
	
	public void resetScoreBoard() {
		scoreBoard.put(ScoreCategory.ONES, -1);
		scoreBoard.put(ScoreCategory.TWOS, -1);
		scoreBoard.put(ScoreCategory.THREES, -1);
		scoreBoard.put(ScoreCategory.FOURS, -1);
		scoreBoard.put(ScoreCategory.FIVES, -1);
		scoreBoard.put(ScoreCategory.SIXES, -1);
		scoreBoard.put(ScoreCategory.THREE_OF_A_KIND, -1);
		scoreBoard.put(ScoreCategory.FOUR_OF_A_KIND, -1);
		scoreBoard.put(ScoreCategory.FULL_HOUSE, -1);
		scoreBoard.put(ScoreCategory.SMALL_STRAIGHT, -1);
		scoreBoard.put(ScoreCategory.LARGE_STRAIGHT, -1);
		scoreBoard.put(ScoreCategory.CHANCE, -1);
		scoreBoard.put(ScoreCategory.YAHTZEE, -1);
	}
	
	public void calcUpperScores() {
		if (scoreBoard.get(ScoreCategory.ONES)==-1) {
			scoreCategoryOptions.put(ScoreCategory.ONES, handValues.get("1") * 1);
		}
		if (scoreBoard.get(ScoreCategory.TWOS)==-1) {
			scoreCategoryOptions.put(ScoreCategory.TWOS,  handValues.get("2") * 2);
		}
		if (scoreBoard.get(ScoreCategory.THREES)==-1) {
			scoreCategoryOptions.put(ScoreCategory.THREES,  handValues.get("3") * 3);
		}
		if (scoreBoard.get(ScoreCategory.FOURS)==-1) {
			scoreCategoryOptions.put(ScoreCategory.FOURS,  handValues.get("4") * 4);
		}
		if (scoreBoard.get(ScoreCategory.FIVES)==-1) {
			scoreCategoryOptions.put(ScoreCategory.FIVES,  handValues.get("5") * 5);
		}
		if (scoreBoard.get(ScoreCategory.SIXES)==-1) {
			scoreCategoryOptions.put(ScoreCategory.SIXES,  handValues.get("6") * 6);
		}
	}

	public void calcThreeOfAKind() {
		if (scoreBoard.get(ScoreCategory.THREE_OF_A_KIND)==-1) 
		{
			for (int counter = 1; counter <= 5; counter++)
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
	}

	public void calcFourOfAKind() {
		if (scoreBoard.get(ScoreCategory.FOUR_OF_A_KIND)==-1) 
		{
			for (int counter = 1; counter <= 5; counter++)
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
	}
	
	public void calcFullHouse() {
		if (scoreBoard.get(ScoreCategory.FULL_HOUSE)==-1) {
			if (handValues.containsValue(2) && handValues.containsValue(3)) 
			{
				scoreCategoryOptions.put(ScoreCategory.FULL_HOUSE, 25);
			}
		}
	}
	

	public void calcSmallStraight() {
		if (scoreBoard.get(ScoreCategory.SMALL_STRAIGHT)==-1) {
			if (findMaxValueCount() == 2)
			{
				if ((handValues.get("1") == 0 && handValues.get("2") == 0) ||
					(handValues.get("5") == 0 && handValues.get("6") == 0)) 
				{
					scoreCategoryOptions.put(ScoreCategory.SMALL_STRAIGHT, 30);
				}
			}
			if (calcLargeStraight())
			{
				scoreCategoryOptions.put(ScoreCategory.SMALL_STRAIGHT, 30);
			}
		}
	}
	
	public boolean calcLargeStraight() {
		if (scoreBoard.get(ScoreCategory.LARGE_STRAIGHT)==-1) {
			if (findMaxValueCount() == 1)
			{
				if (handValues.get("1") == 0 || handValues.get("6") == 0) 
				{
					scoreCategoryOptions.put(ScoreCategory.LARGE_STRAIGHT, 40);
				}
			}
		}
		return true;
		
	}
	
	public void calcChance() {
		if (scoreBoard.get(ScoreCategory.CHANCE)==-1) {
			int sum = 0;
			for (int counter = 1; counter <= 5; counter++)
			{
				String value = ""+counter;
				sum += handValues.get(value)*counter;
			}
			scoreCategoryOptions.put(ScoreCategory.CHANCE, sum);
		}
	}
	
	public void calcYahtzee() {
		if (findMaxValueCount() == 5)
		{
			if (scoreBoard.get(ScoreCategory.YAHTZEE)==-1) 
			{
				scoreCategoryOptions.put(ScoreCategory.YAHTZEE, 50);
			} 
			else if (scoreBoard.get(ScoreCategory.YAHTZEE)>=50)
			{
				scoreCategoryOptions.put(ScoreCategory.YAHTZEE, 100);
			}
		}
	}
	
	public int findMaxValueCount() {
		int maxValue = 0;
		for (int counter = 1; counter <= 5; counter++)
		{
			String value = ""+counter;
			if (handValues.get(value) > maxValue)
			{
				maxValue = handValues.get(value);
			}
		}
		return maxValue;
	}
	
	@Override
	public void calculateScore() {
		
	}

}
