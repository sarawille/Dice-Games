package scoring;

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
