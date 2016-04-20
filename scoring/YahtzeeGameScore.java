package scoring;

import java.util.HashMap;

import ui.Displayable;
import ui.IOFactory;
import ui.Validator;

public class YahtzeeGameScore extends DiceGameScore{
	
	public HashMap<ScoreCategory, Integer> scoreCategoryOptions = new HashMap<>();
	public HashMap<ScoreCategory, Integer> scoreBoard = new HashMap<>();
	public StringBuilder scoreMenu = new StringBuilder();
	int newScore = 0;
	
	public YahtzeeGameScore() {
		resetScoreBoard();		
	}
	
	@Override
	public void calculateScore() {
		 Displayable screen = IOFactory.getDisplayable();
		 resetScoreCategoryOptions();
		 calcUpperScores();
		 calcThreeOfAKind();
		 calcFourOfAKind();
		 calcFullHouse();
		 calcSmallStraight();
		 calcLargeStraight();
		 calcChance();
		 calcYahtzee();
		 screen.display(createScoreMenu());				
		 newScore = getTotalScore() + getUserChoice();
		 setTotalScore(newScore);
	}


	private int getUserChoice() {
		Validator validator = IOFactory.getValidator();
		String userInput = "";
		int points;
		userInput = validator.getString("I want to score category: ");
		while (true) 
		{
			userInput = validator.getString("Please choose a valid category.\nI want to score category: ");
			switch (userInput) 
			{
				case "1":
					points = scoreCategoryOptions.get(ScoreCategory.ONES);
					return scoreBoard.put(ScoreCategory.ONES, points);
				case "2":
					points = scoreCategoryOptions.get(ScoreCategory.TWOS);
					return scoreBoard.put(ScoreCategory.TWOS, points);
				case "3":
					points = scoreCategoryOptions.get(ScoreCategory.THREES);
					return scoreBoard.put(ScoreCategory.THREES, points);
				case "4":
					points = scoreCategoryOptions.get(ScoreCategory.FOURS);
					return scoreBoard.put(ScoreCategory.FOURS, points);
				case "5":
					points = scoreCategoryOptions.get(ScoreCategory.FIVES);
					return scoreBoard.put(ScoreCategory.FIVES, points);
				case "6":
					points = scoreCategoryOptions.get(ScoreCategory.SIXES);
					return scoreBoard.put(ScoreCategory.SIXES, points);
				case "3K":
				case "3k":
					points = scoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND);
					return scoreBoard.put(ScoreCategory.THREE_OF_A_KIND, points);
				case "4K":
				case "4k":
					points = scoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND);
					return scoreBoard.put(ScoreCategory.FOUR_OF_A_KIND, points);
				case "F":
				case "f":
					points = scoreCategoryOptions.get(ScoreCategory.FULL_HOUSE);
					return scoreBoard.put(ScoreCategory.FULL_HOUSE, points);
				case "S":
				case "s":
					points = scoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT);
					return scoreBoard.put(ScoreCategory.SMALL_STRAIGHT, points);
				case "L":
				case "l":
					points = scoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT);
					return scoreBoard.put(ScoreCategory.LARGE_STRAIGHT, points);
				case "C":
				case "c":
					points = scoreCategoryOptions.get(ScoreCategory.CHANCE);
					return scoreBoard.put(ScoreCategory.CHANCE, points);
				case "Y":
				case "y":
					points = scoreCategoryOptions.get(ScoreCategory.YAHTZEE);
					return scoreBoard.put(ScoreCategory.YAHTZEE, points);
				default:
					break;
			}
		}
		
	}

	private String createScoreMenu() {
		String stringOfScoreChoices = "";
		scoreMenu.setLength(0);
		scoreMenu.append("Which category do you want to score? \n");
		listScoringOptions();
		stringOfScoreChoices = scoreMenu.toString();
		if (stringOfScoreChoices.endsWith("Which category do you want to score? \n"))
		{
//			stringOfScoreChoices += getZeros();
		}
		return stringOfScoreChoices;
		
	}
	
	public void listScoringOptions() //TODO start here
	{
		if (scoreCategoryOptions.get(ScoreCategory.ONES) >= 0) 
		{
			scoreMenu.append("1 \t Ones \t\t\t" + scoreCategoryOptions.get(ScoreCategory.ONES) + " points\n");
		}
		if (scoreCategoryOptions.get(ScoreCategory.TWOS) >= 0) 
		{
			scoreMenu.append("2 \t Twos \t\t\t" + scoreCategoryOptions.get(ScoreCategory.TWOS) + " points\n");
		}
		if (scoreCategoryOptions.get(ScoreCategory.THREES) > 0) 
		{
			scoreMenu.append("3 \t Threes \t\t" + scoreCategoryOptions.get(ScoreCategory.THREES) + " points\n");
		}
		if (scoreCategoryOptions.get(ScoreCategory.FOURS) > 0) 
		{
			scoreMenu.append("4 \t Fours \t\t\t" + scoreCategoryOptions.get(ScoreCategory.FOURS) + " points\n");
		}
		if (scoreCategoryOptions.get(ScoreCategory.FIVES) > 0) 
		{
			scoreMenu.append("5 \t Fives \t\t\t" + scoreCategoryOptions.get(ScoreCategory.FIVES) + " points\n");
		}
		if (scoreCategoryOptions.get(ScoreCategory.SIXES) > 0) 
		{
			scoreMenu.append("6 \t Sixes \t\t\t" + scoreCategoryOptions.get(ScoreCategory.SIXES) + " points\n");
		}
		if (scoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND) > 0)
		{
			scoreMenu.append("3K \t 3 of a Kind  \t\t" + scoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND) + " points\n");
		}
		if (scoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND) > 0)
		{
			scoreMenu.append("4K \t 4 of a Kind \t\t" + scoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND) +" points\n");
		}
		if (scoreCategoryOptions.get(ScoreCategory.SIXES) > 0)
		{
			scoreMenu.append("F \t Full House \t\t" + scoreCategoryOptions.get(ScoreCategory.FULL_HOUSE) + " points\n");
		}
		if (scoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT)  > 0)
		{
			scoreMenu.append("S \t Small Straight \t" + scoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT) + " points\n");
		}
		if (scoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT)  > 0)
		{
			scoreMenu.append("L \t Large Straight \t" + scoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT) + " points\n");
		}
		if (scoreCategoryOptions.get(ScoreCategory.CHANCE) > 0)
		{
			scoreMenu.append("C \t Chance \t\t" +scoreCategoryOptions.get(ScoreCategory.CHANCE) + " points\n");
		}
		if (scoreCategoryOptions.get(ScoreCategory.YAHTZEE) > 0)
		{
			scoreMenu.append("Y \t YAHTZEE! \t\t" + scoreCategoryOptions.get(ScoreCategory.YAHTZEE) + " points\n");
		}

	}

	public void resetScoreCategoryOptions() {
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
			if (calcLargeStraight())
			{
				scoreCategoryOptions.put(ScoreCategory.SMALL_STRAIGHT, 30);
			}
			else if (findMaxValueCount() == 2)
			{
				if ((handValues.get("1") == 0 && handValues.get("2") == 0) ||
					(handValues.get("5") == 0 && handValues.get("6") == 0)) 
				{
					scoreCategoryOptions.put(ScoreCategory.SMALL_STRAIGHT, 30);
				}
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
					return true;
				}
			}
		}
		return false;
		
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

}
