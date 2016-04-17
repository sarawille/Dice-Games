package scoring;

import java.util.HashMap;

import business.Hand;

public class ScoreEquations2 {
	
	protected Hand theHand;
	public HashMap<String, Integer> handValues = new HashMap<>();
	public HashMap<ScoreCategory, Integer> scoreCategoryOptions = new HashMap<>();
	public HashMap<ScoreCategory, Integer> scoreBoard = new HashMap<>();
	protected StringBuilder scoreChoices = new StringBuilder();
	
	public ScoreEquations2(Hand newHand) {
		theHand = newHand;
		setScoreCategoryOptions();
		setScoreBoard();
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
	
	private void setScoreBoard() {
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
	
	public void countHandValues(Hand newHand) {
		int instances = 0;
		for (int faceUp = 1; faceUp <= newHand.getSides(); faceUp++) {
			instances = 0;
			for (int dieNumber = 0; dieNumber < newHand.diceInHand.size(); dieNumber++)
			{
				if (newHand.readDie(dieNumber) == faceUp){
					instances++;
				}
			}
			handValues.put("" + faceUp, instances);
		}
	}

	public void calcUpperScores(Hand testHand) {
		
		
	}
}
