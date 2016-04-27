package scoring;

import java.util.HashMap;

import business.Hand;
import utilities.Displayable;
import utilities.Validator;

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
	
	public HashMap<YahtzeeScoreCategory, Integer> scoreBoard = new HashMap<>();
	public StringBuilder scoreMenu = new StringBuilder();
	Displayable screen;
	Validator validator;
	
	public Displayable getScreen() {
		return screen;
	}
	public void setScreen(Displayable screen) {
		this.screen = screen;
	}
	public Validator getValidator() {
		return validator;
	}
	public void setValidator(Validator validator) {
		this.validator = validator;
	}

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
		YahtzeeScoreCategory category;
		YahtzeeScore.resetScoreCategoryOptions();
		
		category = YahtzeeScoreCategory.ONES;
		if (scoreBoard.get(category)==-1) {
			YahtzeeScore.calcUpperScores(category, 1);
		}
		category = YahtzeeScoreCategory.TWOS;
		if (scoreBoard.get(category)==-1) {
			YahtzeeScore.calcUpperScores(category, 2);
		}
		category = YahtzeeScoreCategory.THREES;
		if (scoreBoard.get(category)==-1) {
			YahtzeeScore.calcUpperScores(category, 3);
		}
		category = YahtzeeScoreCategory.FOURS;
		if (scoreBoard.get(category)==-1) {
			YahtzeeScore.calcUpperScores(category, 4);
		}
		category = YahtzeeScoreCategory.FIVES;
		if (scoreBoard.get(category)==-1) {
			YahtzeeScore.calcUpperScores(category, 5);
		}
		category = YahtzeeScoreCategory.SIXES;
		if (scoreBoard.get(category)==-1) {
			YahtzeeScore.calcUpperScores(category, 6);
		 }
		 if (scoreBoard.get(YahtzeeScoreCategory.THREE_OF_A_KIND)==-1) {
			 YahtzeeScore.calcThreeOfAKind();
		 }
		 if (scoreBoard.get(YahtzeeScoreCategory.FOUR_OF_A_KIND)==-1) {
			 YahtzeeScore.calcFourOfAKind();
		 }
		 if (scoreBoard.get(YahtzeeScoreCategory.FULL_HOUSE)==-1) {
			 YahtzeeScore.calcFullHouse();
		 }
		 if (scoreBoard.get(YahtzeeScoreCategory.SMALL_STRAIGHT)==-1) {
			 YahtzeeScore.calcSmallStraight();
		 }
		 if (scoreBoard.get(YahtzeeScoreCategory.LARGE_STRAIGHT)==-1) {
			 YahtzeeScore.calcLargeStraight();
		 }
		 if (scoreBoard.get(YahtzeeScoreCategory.CHANCE)==-1) {
			 YahtzeeScore.calcChance();
		 }
		 if (scoreBoard.get(YahtzeeScoreCategory.YAHTZEE)==-1){
			 YahtzeeScore.calcYahtzee(50);
		}
		else if (scoreBoard.get(YahtzeeScoreCategory.YAHTZEE)>=50) {
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
		String userInput = "";
		int points;
		while (true) 
		{
			userInput = validator.getString("I want to score category: ");
			switch (userInput) 
			{
				case "1":
					points = scoreCategoryOptions.get(YahtzeeScoreCategory.ONES);
					scoreBoard.put(YahtzeeScoreCategory.ONES, points);
					return scoreBoard.get(YahtzeeScoreCategory.ONES);
				case "2":
					points = scoreCategoryOptions.get(YahtzeeScoreCategory.TWOS);
					scoreBoard.put(YahtzeeScoreCategory.TWOS, points);
					return scoreBoard.get(YahtzeeScoreCategory.TWOS);
				case "3":
					points = scoreCategoryOptions.get(YahtzeeScoreCategory.THREES);
					scoreBoard.put(YahtzeeScoreCategory.THREES, points);
					return scoreBoard.get(YahtzeeScoreCategory.THREES);
				case "4":
					points = scoreCategoryOptions.get(YahtzeeScoreCategory.FOURS);
					scoreBoard.put(YahtzeeScoreCategory.FOURS, points);
					return scoreBoard.get(YahtzeeScoreCategory.FOURS);
				case "5":
					points = scoreCategoryOptions.get(YahtzeeScoreCategory.FIVES);
					scoreBoard.put(YahtzeeScoreCategory.FIVES, points);
					return scoreBoard.get(YahtzeeScoreCategory.FIVES);
				case "6":
					points = scoreCategoryOptions.get(YahtzeeScoreCategory.SIXES);
					scoreBoard.put(YahtzeeScoreCategory.SIXES, points);
					return scoreBoard.get(YahtzeeScoreCategory.SIXES);
				case "3K":
				case "3k":
					points = scoreCategoryOptions.get(YahtzeeScoreCategory.THREE_OF_A_KIND);
					scoreBoard.put(YahtzeeScoreCategory.THREE_OF_A_KIND, points);
					return scoreBoard.get(YahtzeeScoreCategory.THREE_OF_A_KIND);
				case "4K":
				case "4k":
					points = scoreCategoryOptions.get(YahtzeeScoreCategory.FOUR_OF_A_KIND);
					scoreBoard.put(YahtzeeScoreCategory.FOUR_OF_A_KIND, points);
					return scoreBoard.get(YahtzeeScoreCategory.FOUR_OF_A_KIND);
				case "F":
				case "f":
					points = scoreCategoryOptions.get(YahtzeeScoreCategory.FULL_HOUSE);
					scoreBoard.put(YahtzeeScoreCategory.FULL_HOUSE, points);
					return scoreBoard.get(YahtzeeScoreCategory.FULL_HOUSE);
				case "S":
				case "s":
					points = scoreCategoryOptions.get(YahtzeeScoreCategory.SMALL_STRAIGHT);
					scoreBoard.put(YahtzeeScoreCategory.SMALL_STRAIGHT, points);
					return scoreBoard.get(YahtzeeScoreCategory.SMALL_STRAIGHT);
				case "L":
				case "l":
					points = scoreCategoryOptions.get(YahtzeeScoreCategory.LARGE_STRAIGHT);
					scoreBoard.put(YahtzeeScoreCategory.LARGE_STRAIGHT, points);
					return scoreBoard.get(YahtzeeScoreCategory.LARGE_STRAIGHT);
				case "C":
				case "c":
					points = scoreCategoryOptions.get(YahtzeeScoreCategory.CHANCE);
					scoreBoard.put(YahtzeeScoreCategory.CHANCE, points);
					return scoreBoard.get(YahtzeeScoreCategory.CHANCE);
				case "Y":
				case "y":
					points = scoreCategoryOptions.get(YahtzeeScoreCategory.YAHTZEE);
					scoreBoard.put(YahtzeeScoreCategory.YAHTZEE, points);
					return scoreBoard.get(YahtzeeScoreCategory.YAHTZEE);
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
		if (scoreCategoryOptions.get(YahtzeeScoreCategory.ONES) > 0) 
		{
			scoreMenu.append("1 \t Ones \t\t\t" + scoreCategoryOptions.get(YahtzeeScoreCategory.ONES) + " points\n");
		}
		if (scoreCategoryOptions.get(YahtzeeScoreCategory.TWOS) > 0) 
		{
			scoreMenu.append("2 \t Twos \t\t\t" + scoreCategoryOptions.get(YahtzeeScoreCategory.TWOS) + " points\n");
		}
		if (scoreCategoryOptions.get(YahtzeeScoreCategory.THREES) > 0) 
		{
			scoreMenu.append("3 \t Threes \t\t" + scoreCategoryOptions.get(YahtzeeScoreCategory.THREES) + " points\n");
		}
		if (scoreCategoryOptions.get(YahtzeeScoreCategory.FOURS) > 0) 
		{
			scoreMenu.append("4 \t Fours \t\t\t" + scoreCategoryOptions.get(YahtzeeScoreCategory.FOURS) + " points\n");
		}
		if (scoreCategoryOptions.get(YahtzeeScoreCategory.FIVES) > 0) 
		{
			scoreMenu.append("5 \t Fives \t\t\t" + scoreCategoryOptions.get(YahtzeeScoreCategory.FIVES) + " points\n");
		}
		if (scoreCategoryOptions.get(YahtzeeScoreCategory.SIXES) > 0) 
		{
			scoreMenu.append("6 \t Sixes \t\t\t" + scoreCategoryOptions.get(YahtzeeScoreCategory.SIXES) + " points\n");
		}
		if (scoreCategoryOptions.get(YahtzeeScoreCategory.THREE_OF_A_KIND) > 0)
		{
			scoreMenu.append("3K \t 3 of a Kind  \t\t" + scoreCategoryOptions.get(YahtzeeScoreCategory.THREE_OF_A_KIND) + " points\n");
		}
		if (scoreCategoryOptions.get(YahtzeeScoreCategory.FOUR_OF_A_KIND) > 0)
		{
			scoreMenu.append("4K \t 4 of a Kind \t\t" + scoreCategoryOptions.get(YahtzeeScoreCategory.FOUR_OF_A_KIND) +" points\n");
		}
		if (scoreCategoryOptions.get(YahtzeeScoreCategory.FULL_HOUSE) > 0)
		{
			scoreMenu.append("F \t Full House \t\t" + scoreCategoryOptions.get(YahtzeeScoreCategory.FULL_HOUSE) + " points\n");
		}
		if (scoreCategoryOptions.get(YahtzeeScoreCategory.SMALL_STRAIGHT)  > 0)
		{
			scoreMenu.append("S \t Small Straight \t" + scoreCategoryOptions.get(YahtzeeScoreCategory.SMALL_STRAIGHT) + " points\n");
		}
		if (scoreCategoryOptions.get(YahtzeeScoreCategory.LARGE_STRAIGHT)  > 0)
		{
			scoreMenu.append("L \t Large Straight \t" + scoreCategoryOptions.get(YahtzeeScoreCategory.LARGE_STRAIGHT) + " points\n");
		}
		if (scoreCategoryOptions.get(YahtzeeScoreCategory.CHANCE) > 0)
		{
			scoreMenu.append("C \t Chance \t\t" +scoreCategoryOptions.get(YahtzeeScoreCategory.CHANCE) + " points\n");
		}
		if (scoreCategoryOptions.get(YahtzeeScoreCategory.YAHTZEE) > 0 && scoreCategoryOptions.get(YahtzeeScoreCategory.YAHTZEE) <= 50)
		{
			scoreMenu.append("Y \t YAHTZEE! \t\t" + scoreCategoryOptions.get(YahtzeeScoreCategory.YAHTZEE) + " points\n");
		}
		if (scoreCategoryOptions.get(YahtzeeScoreCategory.YAHTZEE) > 50)
		{
			scoreMenu.append("Y \t ANOTHER YAHTZEE! \t" + scoreCategoryOptions.get(YahtzeeScoreCategory.YAHTZEE) + " points\n");
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
		if (scoreBoard.get(YahtzeeScoreCategory.ONES) < 0){
		addZerosToScoreChoices.append("1 \t Ones \t\t\t 0 points\n");
		}
		if (scoreBoard.get(YahtzeeScoreCategory.TWOS) < 0){
			addZerosToScoreChoices.append("2 \t Twos \t\t\t 0 points\n");
		}
		if (scoreBoard.get(YahtzeeScoreCategory.THREES) < 0){
			addZerosToScoreChoices.append("3 \t Threes \t\t 0  points\n");
		}
		if (scoreBoard.get(YahtzeeScoreCategory.FOURS) < 0){
			addZerosToScoreChoices.append("4 \t Fours \t\t\t 0  points\n");
		}
		if (scoreBoard.get(YahtzeeScoreCategory.FIVES) < 0){
			addZerosToScoreChoices.append("5 \t Fives \t\t\t 0  points\n");
		}
		if (scoreBoard.get(YahtzeeScoreCategory.SIXES) < 0){
			addZerosToScoreChoices.append("6 \t Sixes \t\t\t 0  points\n");
		}
		if (scoreBoard.get(YahtzeeScoreCategory.THREE_OF_A_KIND) < 0){
			addZerosToScoreChoices.append("3K \t 3 of a Kind \t\t 0  points\n");
		}
		if (scoreBoard.get(YahtzeeScoreCategory.FOUR_OF_A_KIND) < 0){
			addZerosToScoreChoices.append("4K \t 4 of a Kind \t\t 0  points\n");
		}
		if (scoreBoard.get(YahtzeeScoreCategory.FULL_HOUSE) < 0){
			addZerosToScoreChoices.append("F \t Full House \t\t 0  points\n");
		}
		if (scoreBoard.get(YahtzeeScoreCategory.SMALL_STRAIGHT) < 0){
			addZerosToScoreChoices.append("S \t Small Straight \t\t 0  points\n");
		}
		if (scoreBoard.get(YahtzeeScoreCategory.LARGE_STRAIGHT) < 0){
			addZerosToScoreChoices.append("L \t Large Straight \t\t 0  points\n");
		}
		if (scoreBoard.get(YahtzeeScoreCategory.CHANCE) < 0){
			addZerosToScoreChoices.append("C \t Chance \t\t 0  points\n");
		}
		if (scoreBoard.get(YahtzeeScoreCategory.YAHTZEE) < 0){
			addZerosToScoreChoices.append("Y \t Yahtzee \t\t 0  points\n");
		}
		return addZerosToScoreChoices.toString();
	}
	
	/**
	 * This method resets the HashMap of scores for all categories to -1, signaling that
	 * no points have been scored for that category.  It should be called at the beginning of each new game.
	 */
	public void resetScoreBoard() {
		scoreBoard.put(YahtzeeScoreCategory.ONES, -1);
		scoreBoard.put(YahtzeeScoreCategory.TWOS, -1);
		scoreBoard.put(YahtzeeScoreCategory.THREES, -1);
		scoreBoard.put(YahtzeeScoreCategory.FOURS, -1);
		scoreBoard.put(YahtzeeScoreCategory.FIVES, -1);
		scoreBoard.put(YahtzeeScoreCategory.SIXES, -1);
		scoreBoard.put(YahtzeeScoreCategory.THREE_OF_A_KIND, -1);
		scoreBoard.put(YahtzeeScoreCategory.FOUR_OF_A_KIND, -1);
		scoreBoard.put(YahtzeeScoreCategory.FULL_HOUSE, -1);
		scoreBoard.put(YahtzeeScoreCategory.SMALL_STRAIGHT, -1);
		scoreBoard.put(YahtzeeScoreCategory.LARGE_STRAIGHT, -1);
		scoreBoard.put(YahtzeeScoreCategory.CHANCE, -1);
		scoreBoard.put(YahtzeeScoreCategory.YAHTZEE, -1);
	}
	
}
