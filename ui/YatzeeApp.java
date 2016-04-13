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
		
		while (turn <= 5) {
			int numberOfRolls = 1;
			screen.displayln("TURN " + turn);
			Hand newHand = new Hand();
			screen.displayln(newHand.printHand());
			newHand.rollAll();
			numberOfRolls = rerollHand(numberOfRolls, newHand);
			myScore.scoreHand(newHand);
			turn++;
		}
		screen.displayln("--------------------------------------------------");
		
	}

	private static int rerollHand(int numberOfRolls, Hand newHand) {
		String userInput;
		while (numberOfRolls < 3) {
			userInput = theValidator.getString("\nWould you like to roll again? (y/n) ", "y", "n");

			if (userInput.equalsIgnoreCase("y")) {
				rollAgain(newHand);
				newHand.printHand();
				numberOfRolls++;
			} else {
				newHand.printHand();
				break;
			}
		}
		return numberOfRolls;
	}
	
	private static void rollAgain(Hand newHand) 
	{
		String userInput = "";
		int counter = 0;
		
		theValidator.getString("\nWhich die do you want to re-roll? (Type die numbers without spaces) ");
		
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
