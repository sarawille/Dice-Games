package scoring;

/**
 * @author Sara Wille
 * The abstract class Score stores a total score variable, with its getter and setter, for a generic game.
 */

public abstract class Score implements Scorable{
	
	public int totalScore = 0;

	@Override
	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

}
