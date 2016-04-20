package scoring;

import java.util.HashMap;

import business.Hand;
import ui.Displayable;
import ui.IOFactory;
import ui.Validator;

public class YahtzeeScore extends DiceScore{
	
	public HashMap<ScoreCategory, Integer> scoreCategoryOptions = new HashMap<>();
	public HashMap<ScoreCategory, Integer> scoreBoard = new HashMap<>();
	public StringBuilder scoreMenu = new StringBuilder();
	
	public YahtzeeScore() {
		resetScoreBoard();		
	}
	
	@Override
	public void updateScore(Hand newHand) {
		int newScore = 0;
		Displayable screen = IOFactory.getDisplayable();
		calculateScoreOptions(newHand);
		screen.display(createScoreMenu());
		newScore = getTotalScore() + getUserChoice();
		setTotalScore(newScore);
	}

	public void calculateScoreOptions(Hand newHand) {
		 resetScoreCategoryOptions();
		 countHandValues(newHand);
		 calcUpperScores();
		 calcThreeOfAKind();
		 calcFourOfAKind();
		 calcFullHouse();
		 calcSmallStraight();
		 calcLargeStraight();
		 calcChance();
		 calcYahtzee();
	}

	private int getUserChoice() {
		Validator validator = IOFactory.getValidator();
		String userInput = "";
		int points;
		while (true) 
		{
			userInput = validator.getString("I want to score category: ");
			switch (userInput) 
			{
				case "1":
					points = scoreCategoryOptions.get(ScoreCategory.ONES);
					scoreBoard.put(ScoreCategory.ONES, points);
					return scoreBoard.get(ScoreCategory.ONES);
				case "2":
					points = scoreCategoryOptions.get(ScoreCategory.TWOS);
					scoreBoard.put(ScoreCategory.TWOS, points);
					return scoreBoard.get(ScoreCategory.TWOS);
				case "3":
					points = scoreCategoryOptions.get(ScoreCategory.THREES);
					scoreBoard.put(ScoreCategory.THREES, points);
					return scoreBoard.get(ScoreCategory.THREES);
				case "4":
					points = scoreCategoryOptions.get(ScoreCategory.FOURS);
					scoreBoard.put(ScoreCategory.FOURS, points);
					return scoreBoard.get(ScoreCategory.FOURS);
				case "5":
					points = scoreCategoryOptions.get(ScoreCategory.FIVES);
					scoreBoard.put(ScoreCategory.FIVES, points);
					return scoreBoard.get(ScoreCategory.FIVES);
				case "6":
					points = scoreCategoryOptions.get(ScoreCategory.SIXES);
					scoreBoard.put(ScoreCategory.SIXES, points);
					return scoreBoard.get(ScoreCategory.SIXES);
				case "3K":
				case "3k":
					points = scoreCategoryOptions.get(ScoreCategory.THREE_OF_A_KIND);
					scoreBoard.put(ScoreCategory.THREE_OF_A_KIND, points);
					return scoreBoard.get(ScoreCategory.THREE_OF_A_KIND);
				case "4K":
				case "4k":
					points = scoreCategoryOptions.get(ScoreCategory.FOUR_OF_A_KIND);
					scoreBoard.put(ScoreCategory.FOUR_OF_A_KIND, points);
					return scoreBoard.get(ScoreCategory.FOUR_OF_A_KIND);
				case "F":
				case "f":
					points = scoreCategoryOptions.get(ScoreCategory.FULL_HOUSE);
					scoreBoard.put(ScoreCategory.FULL_HOUSE, points);
					return scoreBoard.get(ScoreCategory.FULL_HOUSE);
				case "S":
				case "s":
					points = scoreCategoryOptions.get(ScoreCategory.SMALL_STRAIGHT);
					scoreBoard.put(ScoreCategory.SMALL_STRAIGHT, points);
					return scoreBoard.get(ScoreCategory.SMALL_STRAIGHT);
				case "L":
				case "l":
					points = scoreCategoryOptions.get(ScoreCategory.LARGE_STRAIGHT);
					scoreBoard.put(ScoreCategory.LARGE_STRAIGHT, points);
					return scoreBoard.get(ScoreCategory.LARGE_STRAIGHT);
				case "C":
				case "c":
					points = scoreCategoryOptions.get(ScoreCategory.CHANCE);
					scoreBoard.put(ScoreCategory.CHANCE, points);
					return scoreBoard.get(ScoreCategory.CHANCE);
				case "Y":
				case "y":
					points = scoreCategoryOptions.get(ScoreCategory.YAHTZEE);
					scoreBoard.put(ScoreCategory.YAHTZEE, points);
					return scoreBoard.get(ScoreCategory.YAHTZEE);
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
			stringOfScoreChoices += scoreZero();
		}
		return stringOfScoreChoices;
		
	}
	
	public void listScoringOptions() 
	{
		if (scoreCategoryOptions.get(ScoreCategory.ONES) > 0) 
		{
			scoreMenu.append("1 \t Ones \t\t\t" + scoreCategoryOptions.get(ScoreCategory.ONES) + " points\n");
		}
		if (scoreCategoryOptions.get(ScoreCategory.TWOS) > 0) 
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
		if (scoreCategoryOptions.get(ScoreCategory.FULL_HOUSE) > 0)
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
		if (scoreCategoryOptions.get(ScoreCategory.YAHTZEE) > 0 && scoreCategoryOptions.get(ScoreCategory.YAHTZEE) < 50)
		{
			scoreMenu.append("Y \t YAHTZEE! \t\t" + scoreCategoryOptions.get(ScoreCategory.YAHTZEE) + " points\n");
		}
		if (scoreCategoryOptions.get(ScoreCategory.YAHTZEE) >= 50)
		{
			scoreMenu.append("Y \t ANOTHER YAHTZEE! \t" + scoreCategoryOptions.get(ScoreCategory.YAHTZEE) + " points\n");
		}

	}
	
	public String scoreZero() {
		StringBuilder addZerosToScoreChoices = new StringBuilder();
		addZerosToScoreChoices.append("Sorry, no score categories are available!  ");
		addZerosToScoreChoices.append("You must choose a category to score with 0 points.\n");
		if (scoreBoard.get(ScoreCategory.ONES) < 0){
		addZerosToScoreChoices.append("1 \t Ones \t\t\t 0 points\n");
		}
		if (scoreBoard.get(ScoreCategory.TWOS) < 0){
			addZerosToScoreChoices.append("2 \t Twos \t\t\t 0 points\n");
		}
		if (scoreBoard.get(ScoreCategory.THREES) < 0){
			addZerosToScoreChoices.append("3 \t Threes \t\t 0  points\n");
		}
		if (scoreBoard.get(ScoreCategory.FOURS) < 0){
			addZerosToScoreChoices.append("4 \t Fours \t\t\t 0  points\n");
		}
		if (scoreBoard.get(ScoreCategory.FIVES) < 0){
			addZerosToScoreChoices.append("5 \t Fives \t\t\t 0  points\n");
		}
		if (scoreBoard.get(ScoreCategory.SIXES) < 0){
			addZerosToScoreChoices.append("6 \t Sixes \t\t\t 0  points\n");
		}
		if (scoreBoard.get(ScoreCategory.THREE_OF_A_KIND) < 0){
			addZerosToScoreChoices.append("3K \t 3 of a Kind \t\t 0  points\n");
		}
		if (scoreBoard.get(ScoreCategory.FOUR_OF_A_KIND) < 0){
			addZerosToScoreChoices.append("4K \t 4 of a Kind \t\t 0  points\n");
		}
		if (scoreBoard.get(ScoreCategory.FULL_HOUSE) < 0){
			addZerosToScoreChoices.append("F \t Full House \t\t 0  points\n");
		}
		if (scoreBoard.get(ScoreCategory.SMALL_STRAIGHT) < 0){
			addZerosToScoreChoices.append("S \t Small Straight \t\t 0  points\n");
		}
		if (scoreBoard.get(ScoreCategory.LARGE_STRAIGHT) < 0){
			addZerosToScoreChoices.append("L \t Large Straight \t\t 0  points\n");
		}
		if (scoreBoard.get(ScoreCategory.CHANCE) < 0){
			addZerosToScoreChoices.append("C \t Chance \t\t 0  points\n");
		}
		if (scoreBoard.get(ScoreCategory.YAHTZEE) < 0){
			addZerosToScoreChoices.append("Y \t Yahtzee \t\t 0  points\n");
		}
		return addZerosToScoreChoices.toString();
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
	}
	
	public void calcLargeStraight() {
		if (scoreBoard.get(ScoreCategory.LARGE_STRAIGHT)==-1) {
			if (findMaxValueCount() == 1)
			{
				if (handValues.get("1") == 0 || handValues.get("6") == 0) 
				{
					scoreCategoryOptions.put(ScoreCategory.LARGE_STRAIGHT, 40);
				}
			}
		}
	}
	
	public void calcChance() {
		if (scoreBoard.get(ScoreCategory.CHANCE)==-1) {
			int sum = 0;
			for (int counter = 1; counter <= 6; counter++)
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
