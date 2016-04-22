package scoring;

import business.Hand;

/**
 * @author - Sara Wille
 * Scorable is implemented by DiceScore.
 */

public interface Scorable {

	int getTotalScore();

	void updateScore(Hand thisHand);

}
