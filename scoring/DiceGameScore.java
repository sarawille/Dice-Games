package scoring;

import java.util.HashMap;

import business.Hand;

public abstract class DiceGameScore extends Score {
	
	protected Hand theHand;
	public HashMap<String, Integer> handValues = new HashMap<>();
	
	public DiceGameScore() {}
	
	public void countHandValues(Hand newHand) {
		theHand = newHand;
		int instances = 0;
		for (int faceUp = 1; faceUp <= theHand.getSides(); faceUp++) {
			instances = 0;
			for (int dieNumber = 0; dieNumber < theHand.diceInHand.size(); dieNumber++)
			{
				if (theHand.readDie(dieNumber) == faceUp){
					instances++;
				}
			}
			handValues.put("" + faceUp, instances);
		}
	}

	public abstract void updateScore(Hand newHand);

	
}
