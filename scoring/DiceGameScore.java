package scoring;

import java.util.HashMap;

import business.Hand;

public abstract class DiceGameScore {
	
	protected Hand theHand;
	public HashMap<String, Integer> handValues = new HashMap<>();
	public int totalScore = 0;
	
	public DiceGameScore() {}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	

	
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

	public abstract void calculateScore();
	
}
