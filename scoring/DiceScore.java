package scoring;

import java.util.HashMap;

import business.Hand;

public abstract class DiceScore extends Score {
	
	protected static Hand scoringHand;
	public static HashMap<String, Integer> handValues = new HashMap<>();
		
	protected static void setScoringHand(Hand scoringHand) {
		DiceScore.scoringHand = scoringHand;
	}

	public static void countHandValues() {
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

	protected abstract void updateScore(Hand newHand);

	
}
