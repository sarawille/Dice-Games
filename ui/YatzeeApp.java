package ui;

import scoring.ScoreCalculations;
import business.Hand;

/*
 * @author - Sara Wille
 * 
 */

public class YatzeeApp {
	
	//TODO add comments and javaDoc notes
	//TODO use same code to make another dice game
	//TODO try making this into a GUI or using pre-written GUI code to drop into IOFactory
	//TODO ask chuck - automatically generate a webpage that is text based - like a blog - use a database?
	
	static int turn = 1;
	static Displayable screen = IOFactory.getDisplayable();
	static Validator theValidator = new Validator(screen);
	
	public static void main(String[] args) { 
		
		ScoreCalculations myScore = new ScoreCalculations(screen, theValidator);
		Hand thisHand; 
		
		while (turn <= 1) {
			screen.displayln("TURN " + turn);
			thisHand = new Hand(5, 6);
			rollHand(thisHand);
			//TODO why doesnt total score keep adding over multiple turns?
			myScore.scoreHand(thisHand);
			screen.display("Your total score is ");
			screen.displayln(myScore.printTotalScore());
			screen.displayln("--------------------------------------------------\n");
			turn++;
		}
		screen.displayln("GAME OVER!");
		screen.display("Your final score is ");
		screen.displayln(myScore.printTotalScore());
		
	}

	private static void rollHand(Hand myHand) {
		String userInput;
		int numberOfRolls = 1;
		myHand.rollAll();
		screen.displayln(myHand.printHand());
		while (numberOfRolls < 3) {
			userInput= theValidator.getString("\nWould you like to roll again? (y/n) ", "y", "n");
			if (userInput.equalsIgnoreCase("y")) {
				rollAgain(myHand);
				numberOfRolls++;
				screen.displayln(myHand.printHand());
			} else {
				screen.displayln(myHand.printHand());
				break;
			}
		}
	}
	
	private static void rollAgain(Hand newHand) 
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
		//cycle through the user-entered string, looking at each character as an individual input
		while (counter < userInput.length()) {
			switch (userInput.charAt(counter)) {
				case '1':
					newHand.roll(0);
					break;
				case '2':
					newHand.roll(1);
					break;
				case '3':
					newHand.roll(2);
					break;
				case '4':
					newHand.roll(3);
					break;
				case '5':
					newHand.roll(4);
					break;
				default:
					break;
			}
			counter++;
		}
	}
	
	

}
