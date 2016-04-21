package ui;

import scoring.PigScoreBoard;
import scoring.Scorable;
import scoring.YahtzeeScoreBoard;
import business.Hand;

public class GameApp {
	static int turn = 1;
	static Displayable screen = IOFactory.getDisplayable();
	
	public static void main(String[] args) { 
		
		Playable game = new YahtzeeRules();
		Scorable myScore = new YahtzeeScoreBoard();
				
		//TODO major current bug: you can enter a score cateogry that exists but is not available for that turn - yahtzee
		
		game.play();
		
		screen.display("Your total score is ");
		screen.displayln(""+myScore.getTotalScore());
		screen.displayln("--------------------------------------------------\n");
		
		screen.displayln("GAME OVER!");
		screen.display("Your final score is ");
		screen.displayln(""+myScore.getTotalScore());
		
	}
}
