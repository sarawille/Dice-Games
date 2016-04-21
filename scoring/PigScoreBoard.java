package scoring;

import java.util.HashMap;

import ui.Displayable;
import ui.IOFactory;
import business.Hand;

public class PigScoreBoard extends PigScore {
	
	public HashMap<ScoreCategory, Integer> scoreBoard = new HashMap<>();
	public StringBuilder scoreMenu = new StringBuilder();
	
	public void updateScore(Hand thisHand) {
		int newScore = 0;
		Displayable screen = IOFactory.getDisplayable();
		PigScore.countHandValues(thisHand);		
		screen.displayln(createScoreMenu());
		if (howManyOnes() == 2) {					//potential bug if using howManyOnes before countHandValues is run.
			newScore = 0;
		}
		else if (howManyOnes() == 1){
			newScore = getTotalScore();
		}
		else {
			newScore = getTotalScore() + addDice();
		}
		setTotalScore(newScore);
	}

	private String createScoreMenu() {
		scoreMenu.setLength(0);
		if (howManyOnes() == 2) {
			scoreMenu.append("OH NO! You rolled all ones! You lost all of your points!");
		}
		else if (howManyOnes() == 1) {
			scoreMenu.append("Sorry! You rolled one! You get 0 points!");
		}
		else {
			scoreMenu.append("You rolled " + addDice() + ".");
		}
		return scoreMenu.toString();
	}
}
