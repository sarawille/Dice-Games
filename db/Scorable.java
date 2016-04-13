package db;

public interface Scorable {
	
	void calcTotalScore(ScoreCategory userChoice);
	void printTotalScore();

}
