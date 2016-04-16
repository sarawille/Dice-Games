package scoring;

public interface Scorable {
	
	void calcTotalScore(ScoreCategory userChoice);
	String printTotalScore();

}
