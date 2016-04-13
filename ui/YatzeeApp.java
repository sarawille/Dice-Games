package ui;

import scoring.ScoreCalculations;
import business.Hand;

/*
 * @author - Sara Wille
 * 
 */

public class YatzeeApp {
	
	static int turn = 1;
	static Displayable screen = IOFactory.getDisplayable();
	static Validator theValidator = new Validator(screen);
	
	public static void main(String[] args) { 
		
		ScoreCalculations myScore = new ScoreCalculations(screen, theValidator);
		Hand thisHand; 
		
		while (turn <= 5) {
			screen.displayln("TURN " + turn);
			thisHand = new Hand();
			thisHand.rollAll();
			screen.displayln(thisHand.printHand());
			rerollHand(thisHand);
			myScore.scoreHand(thisHand);
			myScore.printTotalScore();
			turn++;
			screen.displayln("--------------------------------------------------");
		}
	}

	private static void rerollHand(Hand myHand) {
		String userInput;
		while (myHand.getNumberOfRolls() < 3) {
			userInput = theValidator.getString("\nWould you like to roll again? (y/n) ", "y", "n");
			if (userInput.equalsIgnoreCase("y")) {
				rollAgain(myHand);
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
		int userInput = theValidator.getInt(prompt, 1, 5);
		
		switch (userInput) {
			case 1:
				newHand.roll(0);
				break;
			case 2:
				newHand.roll(1);
				break;
			case 3:
				newHand.roll(2);
				break;
			case 4:
				newHand.roll(3);
				break;
			case 5:
				newHand.roll(4);
				break;
			default:
				break;
		}
	}
	
	

}
