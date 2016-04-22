package scoring;

import java.util.HashMap;

import business.Hand;

/**
 * @author Sara Wille
 * The DiceScore class is designed to fascilitate scoring a generic dice game
 * by counting the number of instances for each side of the Dice in the Hand.  
 * The instance variable scoringHand is a Hand object that can be set by calling the method
 * countHandValues, which sets the Hand before running the calculation.
 * The class must be inherited by a more specific GameScore class, which will include the equations
 * for calculating the score of that specific game.
 */

public abstract class DiceScore extends Score {
	
	protected static Hand scoringHand;
	public static HashMap<String, Integer> handValues = new HashMap<>();
		
	/**
	 * setScoringHand() - sets the instance variable scoringHand
	 * @param scoringHand
	 */
	protected static void setScoringHand(Hand scoringHand) {
		DiceScore.scoringHand = scoringHand;
	}

	/**
	 * countHandValues() - After setting the scoringHand instance variable to the current Hand, 
	 * the method loops through the Hand to count the number of times each value appears.  
	 * The die face values and number of times each occurs are stored in the HashMap handValues.
	 * @param thisHand
	 */
	public static void countHandValues(Hand thisHand) {
		setScoringHand(thisHand);
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
