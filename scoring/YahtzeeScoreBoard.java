package scoring;

import java.util.HashMap;

import business.Hand;
import ui.Displayable;
import ui.IOFactory;
import ui.Validator;

/**
 * 
 * @author Sara Wille
 * The YahtzeeScoreBoard class contains all the methods required to manage the scoring menu display
 * and get input from the user to score the current Hand for a Yahtzee game.
 * 
 * The HashMap scoreBoard contains the ScoreCategory enumerators and the points awarded to the player
 * for this game (of 13 turns).  
 * 
 * The scoreMenu StringBuilder is stored with the scoring options for each hand, and is displayed to the player.
 *
 */
public class YahtzeeScoreBoard extends YahtzeeScore implements Scorable {
	
	public HashMap<ScoreCategory, Integer> scoreBoard = new HashMap<>();
	public StringBuilder scoreMenu = new StringBuilder();

	public YahtzeeScoreBoard() {
		resetScoreBoard();		
	}
	
	/**
	 * updateScore() - This is the main method to be run; it executes all required methods within the class.
	 * It fills the array handValues by running countHandValues(), calculates potential points
	 * for each score category with calcualteScoreOptions(), displays a menu of available score categories
	 * to the user with createScoreMenu(), then adds the points for the user-chosen category to totalScore (in Score class);
	 * @param newHand
	 */
	@Override
	public void updateScore(Hand newHand) {
		int newScore = 0;
		Displayable screen = IOFactory.getDisplayable();
		newHand.sortItems();
		YahtzeeScore.countHandValues(newHand);
		calculateScoreOptions();
		screen.display(createScoreMenu());
		newScore = getTotalScore() + getPlayerChoice();
		setTotalScore(newScore);
	}

	/**
	 * calculateScoreOptions() - The method checks to see whether the category has already been scored.
	 * If not, it adds the category and possible points to the HashMap scoreBoard.
	 */
	public void calculateScoreOptions() {
		ScoreCategory category;
		YahtzeeScore.resetScoreCategoryOptions();
		
		category = ScoreCategory.ONES;
		if (scoreBoard.get(category)==-1) {
			YahtzeeScore.calcUpperScores(category, 1);
		}
		category = ScoreCategory.TWOS;
		if (scoreBoard.get(category)==-1) {
			YahtzeeScore.calcUpperScores(category, 2);
		}
		category = ScoreCategory.THREES;
		if (scoreBoard.get(category)==-1) {
			YahtzeeScore.calcUpperScores(category, 3);
		}
		category = ScoreCategory.FOURS;
		if (scoreBoard.get(category)==-1) {
			YahtzeeScore.calcUpperScores(category, 4);
		}
		category = ScoreCategory.FIVES;
		if (scoreBoard.get(category)==-1) {
			YahtzeeScore.calcUpperScores(category, 5);
		}
		category = ScoreCategory.SIXES;
		if (scoreBoard.get(category)==-1) {
			YahtzeeScore.calcUpperScores(category, 6);
		 }
		 if (scoreBoard.get(ScoreCategory.THREE_OF_A_KIND)==-1) {
			 YahtzeeScore.calcThreeOfAKind();
		 }
		 if (scoreBoard.get(ScoreCategory.FOUR_OF_A_KIND)==-1) {
			 YahtzeeScore.calcFourOfAKind();
		 }
		 if (scoreBoard.get(ScoreCategory.FULL_HOUSE)==-1) {
			 YahtzeeScore.calcFullHouse();
		 }
		 if (scoreBoard.get(ScoreCategory.SMALL_STRAIGHT)==-1) {
			 YahtzeeScore.calcSmallStraight();
		 }
		 if (scoreBoard.get(ScoreCategory.LARGE_STRAIGHT)==-1) {
			 YahtzeeScore.calcLargeStraight();
		 }
		 if (scoreBoard.get(ScoreCategory.CHANCE)==-1) {
			 YahtzeeScore.calcChance();
		 }
		 if (scoreBoard.get(ScoreCategory.YAHTZEE)==-1){
			 YahtzeeScore.calcYahtzee(50);
		}
		else if (scoreBoard.get(ScoreCategory.YAHTZEE)>=50) {
			YahtzeeScore.calcYahtzee(100);
		}
	}
	
	/**
	 * getPlayerChoice() - The method asks the user which category they want to score for the
	 * current Hand.  
	 * 
	 * CURRENT BUG: The player can choose to score any valid category on any turn, even if that 
	 * category is not displayed on the menu (which means it is not available for the current Hand
	 * or that is has already been scored for this game).
	 * @return scoreBoard.get(ScoreCategory x)
	 */
	private int getPlayerChoice() {
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

	/**
	 * createScoreMenu() - The method first clears out the scoreMenu StringBuilder so that 
	 * it starts with an empty menu for each Hand.  Then, it builds the menu String by 
	 * calling listScoringOptions().  If listScoringOptions() does not add anything to the 
	 * menu, it is a signal that no categories are available to be scored.  According to the 
	 * Yahtzee rules, when this happens, an unscored category must be scored as 0.  The method
	 * calls scoreZero() to get a list of available categories to score as 0 and appends that to 
	 * the returned String stringOfScoreChoices.
	 * @return stringOfScoreChoices
	 */
	private String createScoreMenu() {
		String stringOfScoreChoices = "";
		scoreMenu.setLength(0);
		scoreMenu.append("Which category do you want to score? \n");
		listScoringOptions();
		stringOfScoreChoices = scoreMenu.toString();			//convert to String to be able to use .endsWith()
		if (stringOfScoreChoices.endsWith("Which category do you want to score? \n"))
		{
			stringOfScoreChoices += scoreZero();
		}
		return stringOfScoreChoices;
	}
	
	/**
	 * listScoringOptions() - The method checks each category; if it has not been scored yet,
	 * the scoreMenu is appended with a line including the category name and possible points.
	 */
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
		if (scoreCategoryOptions.get(ScoreCategory.YAHTZEE) > 0 && scoreCategoryOptions.get(ScoreCategory.YAHTZEE) <= 50)
		{
			scoreMenu.append("Y \t YAHTZEE! \t\t" + scoreCategoryOptions.get(ScoreCategory.YAHTZEE) + " points\n");
		}
		if (scoreCategoryOptions.get(ScoreCategory.YAHTZEE) > 50)
		{
			scoreMenu.append("Y \t ANOTHER YAHTZEE! \t" + scoreCategoryOptions.get(ScoreCategory.YAHTZEE) + " points\n");
		}
	}
	
	/**
	 * scoreZero() - The method creates a list (via StringBuilder addZerosToScoreChoices) of available 
	 * categories to score as 0.  This method is called by createScoreMenu when no categories are available 
	 * to be scored.  According to the Yahtzee rules, when this happens, an unscored category must be scored as 0.  
	 * @return addZerosToScoreChoices
	 */
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
	
	/**
	 * This method resets the HashMap of scores for all categories to -1, signaling that
	 * no points have been scored for that category.  It should be called at the beginning of each new game.
	 */
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
	
}
