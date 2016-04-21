package scoring;

import business.Hand;

public interface Scorable {

	int getTotalScore();

	void updateScore(Hand thisHand);

}
