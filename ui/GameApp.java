package ui;

import scoring.Scorable;
import scoring.PigScoreBoard;
import scoring.YahtzeeScoreBoard;

public class GameApp {
	
	static Displayable screen = IOFactory.getDisplayable();
	
	public static void main(String[] args) { 
		
		Playable game = new YahtzeeRules();
		Scorable myScore = new YahtzeeScoreBoard();	
		
		game.play(myScore);
		
		screen.displayln("GAME OVER!");
		screen.display("Your final score is ");
		screen.displayln(""+myScore.getTotalScore());
		
	}
}
