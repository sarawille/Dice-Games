package ui;

import scoring.Scorable;
import business.Hand;

/**
 * 
 * @author Sara Wille
 * The PigRules class manages play for a modified game of Pig.
 * 
 * The player rolls the Hand, then chooses whether or not to roll again.
 * The score is a running sum of the dice values.
 * If one of the die is a 1, the game ends immediately and the score for that turn is 0.
 * If both dice are 1, the game ends immediately an the player loses all points for final score of 0.
 */

public class PigRules implements Playable {
	
	static Displayable screen = IOFactory.getDisplayable();
	Validator theValidator = IOFactory.getValidator();
	Hand thisHand;

	public void rollHand(Hand myHand) {
			
	}

	@Override
	public void play(Scorable myScore) {
		String userInput = "y";
		int turn = 1;
		int score = 0;
		
		thisHand = new Hand(2, 6);
		while (userInput.equalsIgnoreCase("y")) 
		{
			screen.displayln("TURN " + turn);
			thisHand.rollAll();
			screen.displayln(thisHand.printHand());
			myScore.updateScore(thisHand);
			screen.display("Your total score is ");
			boolean ones = (score == myScore.getTotalScore());
			score = myScore.getTotalScore();
			screen.displayln(""+score);
			if (ones) {
				userInput = "n";
			}
			else {
				userInput= theValidator.getString("\nWould you like to roll again? (y/n) ", "y", "n");
			}
			screen.displayln("--------------------------------------------------\n");
			turn++;
		}
	}

}
