package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * The GameApp runs the one-player dice games.
 * 
 * To play Yahtzee, pass in "YahtzeeApplicationContext.xml" on line 18.
 * To play modified version of Pig, pass in "PigApplicationContext.xml" on line 18.
 *
 * @author Sara Wille
 */
public class GameApp {
		
	public static void main(String[] args) { 
		
		ApplicationContext contextXML = new ClassPathXmlApplicationContext("PigApplicationContext.xml");
		Playable game = (Playable) contextXML.getBean("game");
		
		game.play();
		
	}
}
