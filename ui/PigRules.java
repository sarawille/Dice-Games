package ui;

import scoring.Scorable;
import utilities.Displayable;
import utilities.Validator;
import business.Hand;

/**
 * 
 * @author Sara Wille
 * The PigRules class manages play for a modified game of Pig.
 * 
 * The player rolls the Hand, then chooses whether or not to roll again as many times as wanted.
 * The score is a running sum of the dice values.
 * If one of the die is a 1, the game ends immediately and the score for that turn is 0.
 * If both dice are 1, the game ends immediately an the player loses all points for final score of 0.
 */

public class PigRules implements Playable {
	
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
		screen.displayln("GAME OVER!");
		screen.display("Your final score is ");
		screen.displayln(""+myScore.getTotalScore());
	}

}
