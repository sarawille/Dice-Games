package ui;

import scoring.Scorable;
import utilities.Displayable;
import utilities.Validator;
import business.Hand;

/**
 * @author Sara Wille
 * The YahtzeeRules class manages play for a game of Yahtzee.
 * 
 * The player rolls the Hand, then can choose to re-roll any combination of dice up to two more times
 * on each turn.  The game lasts for 13 turns.
 * The score is calculated depending on the face up values of each Hand and the user's choice of
 * which scoring category to use at the end of each turn.
 */

public class YahtzeeRules implements Playable {
	
	Displayable screen;
	Validator theValidator;
	Scorable myScore;
	Hand thisHand;
	
	public Displayable getScreen() {
		return screen;
	}
	public void setScreen(Displayable screen) {
		this.screen = screen;
	}
	public Validator getTheValidator() {
		return theValidator;
	}
	public void setTheValidator(Validator theValidator) {
		this.theValidator = theValidator;
	}
	public Scorable getMyScore() {
		return myScore;
	}
	public void setMyScore(Scorable myScore) {
		this.myScore = myScore;
	}

	@Override
	public void play() {
		String userInput;
		int turn = 1;
		
		while (turn <= 13) 
		{
			thisHand = new Hand(5, 6);
			int numberOfRolls = 1;
			
			screen.displayln("TURN " + turn);
			thisHand.rollAll();
			screen.displayln(thisHand.printHand());
			while (numberOfRolls < 3) {
				userInput= theValidator.getString("\nWould you like to roll again? (y/n) ", "y", "n");
				if (userInput.equalsIgnoreCase("y")) {
					rollAgain(thisHand);
					numberOfRolls++;
					screen.displayln(thisHand.printHand());
				} else {
					screen.displayln(thisHand.printHand());
					break;
				}
			}
			myScore.updateScore(thisHand);
			screen.display("Your total score is ");
			screen.displayln(""+myScore.getTotalScore());
			screen.displayln("--------------------------------------------------\n");
			turn++;
		}
		screen.displayln("GAME OVER!");
		screen.display("Your final score is ");
		screen.displayln(""+myScore.getTotalScore());
	}
	
	/**
	 * rollAgain() - Method asks the user which dice they want to re-roll and confirms valid input.
	 * @param newHand
	 */
	public void rollAgain(Hand newHand) 
	{
		String prompt = "\nWhich die do you want to re-roll? (Type die numbers without spaces) ";
		int testInteger;
		String userInput = "";
		int counter = 0;
		
		while (true) {
			//make sure the user input is only numbers
			testInteger = theValidator.getInt(prompt);
			//convert user input to a string, then confirm it contains only numbers 1-5
			userInput = "" + testInteger;
			if (userInput.length() > 5)
			{
				screen.display("Please do not enter more than 5 numbers.\n");
				continue;
			}
			else if (userInput.contains("6") || userInput.contains("7")
					|| userInput.contains("8") || userInput.contains("9")
					|| userInput.contains("0")) {
				screen.display("Please enter numbers 1-5, corresponding to the dice you want to roll.\n");
				continue;
			} else {
				break;
			}
		}
		//cycle through the user-entered string, looking at each character as a die number
		while (counter < userInput.length()) {
			switch (userInput.charAt(counter)) {
				case '1':
					newHand.rollDie(0);
					break;
				case '2':
					newHand.rollDie(1);
					break;
				case '3':
					newHand.rollDie(2);
					break;
				case '4':
					newHand.rollDie(3);
					break;
				case '5':
					newHand.rollDie(4);
					break;
				default:
					break;
			}
			counter++;
		}
	}
	
	

}
