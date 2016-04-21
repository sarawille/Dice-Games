package ui;

import scoring.Scorable;
import business.Hand;

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
