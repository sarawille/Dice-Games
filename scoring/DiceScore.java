package scoring;

import java.util.HashMap;

import business.Hand;

public abstract class DiceScore extends Score {
	
	protected Hand scoringHand;
	public HashMap<String, Integer> handValues = new HashMap<>();
		
	public void countHandValues(Hand newHand) {
		scoringHand = newHand;
		int instances = 0;
		for (int faceUp = 1; faceUp <= scoringHand.diceInHand.get(0).getSides(); faceUp++) {
			instances = 0;
			for (int dieNumber = 0; dieNumber < scoringHand.diceInHand.size(); dieNumber++)
			{
				if (scoringHand.readDie(dieNumber) == faceUp){
					instances++;
				}
			}
			handValues.put("" + faceUp, instances);
		}
	}

	public abstract void updateScore(Hand newHand);

	
}
