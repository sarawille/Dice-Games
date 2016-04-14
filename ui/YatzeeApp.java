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
	//try making this into a GUI or using pre-written GUI code to drop into IOFactory
	
	static int turn = 1;
	static Displayable screen = IOFactory.getDisplayable();
	static Validator theValidator = new Validator(screen);
	
	public static void main(String[] args) { 
		
		ScoreCalculations myScore = new ScoreCalculations(screen, theValidator);
		Hand thisHand; 
		
		while (turn <= 5) {
			screen.displayln("TURN " + turn);
			thisHand = new Hand(5, 6);
			rollHand(thisHand);
			//TODO why doesnt total score keep adding over multiple turns?
			myScore.scoreHand(thisHand);
			myScore.printTotalScore();
			turn++;
			screen.displayln("--------------------------------------------------");
		}
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
		String userInput = theValidator.getString(prompt);
		int counter = 0;
		
		//ycles through the user-entered string, looking at each character as an individual input
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
