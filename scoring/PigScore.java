package scoring;

import business.Hand;

public class PigScore extends DiceScore {

	@Override
	public void updateScore(Hand newHand) {}
	
	public int howManyOnes() {
		return handValues.get("1");
	}
	
	public int addDice() {
		return scoringHand.readDie(0) + scoringHand.readDie(1);
	}

}
