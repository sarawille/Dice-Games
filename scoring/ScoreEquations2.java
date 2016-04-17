package scoring;

import java.util.HashMap;

import business.Hand;

public class ScoreEquations2 {
	
	protected Hand theHand;
	public HashMap<String, Integer> handValues = new HashMap<>();
	protected HashMap<ScoreCategory, Integer> scoreCategoryOptions = new HashMap<>();
	public HashMap<ScoreCategory, Integer> scoreBoard = new HashMap<>();
	protected StringBuilder scoreChoices = new StringBuilder();
	
	public ScoreEquations2(Hand newHand) {
		theHand = newHand;
	}
	
	public void countHandValues(Hand newHand) {
		int instances = 0;
		for (int faceUp = 1; faceUp <= newHand.diceInHand.size(); faceUp++) {
			instances = 0;
			for (int dieNumber = 0; dieNumber < newHand.diceInHand.size(); dieNumber++)
			{
				if (newHand.readDie(dieNumber) == faceUp){
					instances++;
				}
			}
			handValues.put("" + faceUp, instances);
		}
	}
}
