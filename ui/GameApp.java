package ui;

import scoring.Scorable;
import scoring.PigScoreBoard;
import scoring.YahtzeeScoreBoard;

/**
 * 
 * @author Sara Wille
 * The GameApp runs a dice game and displays the final score when the game ends.
 *
 */
public class GameApp {
	
	static Displayable screen = IOFactory.getDisplayable();
	
	public static void main(String[] args) { 
		
		Playable game = new YahtzeeRules();
		Scorable myScore = new YahtzeeScoreBoard();	
		
//		Playable game = new PigRules();
//		Scorable myScore = new PigScoreBoard();
		
		game.play(myScore);
		
		screen.displayln("GAME OVER!");
		screen.display("Your final score is ");
		screen.displayln(""+myScore.getTotalScore());
		
	}
}
