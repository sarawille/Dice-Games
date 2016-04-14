package scoring;

public abstract class ScoreVariables 
{
	//TODO make total score into an array?
	//Upper Section Scoring Variables
	protected int onesPoints = -1;
	protected int twosPoints = -1;
	protected int threesPoints = -1;
	protected int foursPoints = -1;
	protected int fivesPoints = -1;
	protected int sixesPoints = -1;

	protected int onesPossiblePoints = 0;
	protected int twosPossiblePoints = 0;
	protected int threesPossiblePoints = 0;
	protected int foursPossiblePoints = 0;
	protected int fivesPossiblePoints = 0;
	protected int sixesPossiblePoints = 0;

	//Lower Section Scoring Variables
	protected int threeOfAKindPoints = -1;
	protected int fourOfAKindPoints = -1; 
	protected int smallStraightPoints = -1;
	protected int largeStraightPoints= -1; 
	protected int fullHousePoints = -1;
	protected int yahtzeePoints = -1;
	protected int chancePoints = -1;

	protected int threeOfAKindPossiblePoints = 0;
	protected int fourOfAKindPossiblePoints = 0;
	protected int largeStraightPossiblePoints = 0;
	protected int smallStraightPossiblePoints = 0;
	protected int fullHousePossiblePoints = 0;
	protected int yahtzeePossiblePoints = 0;
	protected int chancePossiblePoints = 0;

	protected int totalScore = 0;
	
	protected StringBuilder scoreChoices = new StringBuilder();
	
	public int getOnesPoints() {
		return onesPoints;
	}

	public int getTwosPoints() {
		return twosPoints;
	}

	public int getThreesPoints() {
		return threesPoints;
	}

	public int getFoursPoints() {
		return foursPoints;
	}

	public int getFivesPoints() {
		return fivesPoints;
	}

	public int getSixesPoints() {
		return sixesPoints;
	}

	public int getThreeOfAKindPoints() {
		return threeOfAKindPoints;
	}

	public int getFourOfAKindPoints() {
		return fourOfAKindPoints;
	}

	public int getSmallStraightPoints() {
		return smallStraightPoints;
	}

	public int getLargeStraightPoints() {
		return largeStraightPoints;
	}

	public int getFullHousePoints() {
		return fullHousePoints;
	}

	public int getYahtzeePoints() {
		return yahtzeePoints;
	}

	public int getChancePoints() {
		return chancePoints;
	}
	
	public int getOnesPossiblePoints() {
		return onesPossiblePoints;
	}

	public int getTwosPossiblePoints() {
		return twosPossiblePoints;
	}

	public int getThreesPossiblePoints() {
		return threesPossiblePoints;
	}

	public int getFoursPossiblePoints() {
		return foursPossiblePoints;
	}

	public int getFivesPossiblePoints() {
		return fivesPossiblePoints;
	}

	public int getSixesPossiblePoints() {
		return sixesPossiblePoints;
	}

	public int getThreeOfAKindPossiblePoints() {
		return threeOfAKindPossiblePoints;
	}

	public int getFourOfAKindPossiblePoints() {
		return fourOfAKindPossiblePoints;
	}

	public int getLargeStraightPossiblePoints() {
		return largeStraightPossiblePoints;
	}

	public int getSmallStraightPossiblePoints() {
		return smallStraightPossiblePoints;
	}

	public int getFullHousePossiblePoints() {
		return fullHousePossiblePoints;
	}

	public int getYahtzeePossiblePoints() {
		return yahtzeePossiblePoints;
	}

	public int getChancePossiblePoints() {
		return chancePossiblePoints;
	}

	public void setOnesPoints(int onesPoints) {
		this.onesPoints = onesPoints;
	}

	public void setTwosPoints(int twosPoints) {
		this.twosPoints = twosPoints;
	}

	public void setThreesPoints(int threesPoints) {
		this.threesPoints = threesPoints;
	}

	public void setFoursPoints(int foursPoints) {
		this.foursPoints = foursPoints;
	}

	public void setFivesPoints(int fivesPoints) {
		this.fivesPoints = fivesPoints;
	}

	public void setSixesPoints(int sixesPoints) {
		this.sixesPoints = sixesPoints;
	}

	public void setThreeOfAKindPoints(int threeOfAKindPoints) {
		this.threeOfAKindPoints = threeOfAKindPoints;
	}

	public void setFourOfAKindPoints(int fourOfAKindPoints) {
		this.fourOfAKindPoints = fourOfAKindPoints;
	}

	public void setSmallStraightPoints(int smallStraightPoints) {
		this.smallStraightPoints = smallStraightPoints;
	}

	public void setLargeStraightPoints(int largeStraightPoints) {
		this.largeStraightPoints = largeStraightPoints;
	}

	public void setFullHousePoints(int fullHousePoints) {
		this.fullHousePoints = fullHousePoints;
	}

	public void setYahtzeePoints(int yahtzeePoints) {
		this.yahtzeePoints = yahtzeePoints;
	}

	public void setChancePoints(int chancePoints) {
		this.chancePoints = chancePoints;
	}

	public void setOnesPossiblePoints(int onesPossiblePoints) {
		this.onesPossiblePoints = onesPossiblePoints;
	}

	public void setTwosPossiblePoints(int twosPossiblePoints) {
		this.twosPossiblePoints = twosPossiblePoints;
	}

	public void setThreesPossiblePoints(int threesPossiblePoints) {
		this.threesPossiblePoints = threesPossiblePoints;
	}

	public void setFoursPossiblePoints(int foursPossiblePoints) {
		this.foursPossiblePoints = foursPossiblePoints;
	}

	public void setFivesPossiblePoints(int fivesPossiblePoints) {
		this.fivesPossiblePoints = fivesPossiblePoints;
	}

	public void setSixesPossiblePoints(int sixesPossiblePoints) {
		this.sixesPossiblePoints = sixesPossiblePoints;
	}

	public void setThreeOfAKindPossiblePoints(int threeOfAKindPossiblePoints) {
		this.threeOfAKindPossiblePoints = threeOfAKindPossiblePoints;
	}

	public void setFourOfAKindPossiblePoints(int fourOfAKindPossiblePoints) {
		this.fourOfAKindPossiblePoints = fourOfAKindPossiblePoints;
	}

	public void setLargeStraightPossiblePoints(int largeStraightPossiblePoints) {
		this.largeStraightPossiblePoints = largeStraightPossiblePoints;
	}

	public void setSmallStraightPossiblePoints(int smallStraightPossiblePoints) {
		this.smallStraightPossiblePoints = smallStraightPossiblePoints;
	}

	public void setFullHousePossiblePoints(int fullHousePossiblePoints) {
		this.fullHousePossiblePoints = fullHousePossiblePoints;
	}

	public void setYahtzeePossiblePoints(int yahtzeePossiblePoints) {
		this.yahtzeePossiblePoints = yahtzeePossiblePoints;
	}

	public void setChancePossiblePoints(int chancePossiblePoints) {
		this.chancePossiblePoints = chancePossiblePoints;
	}
	
	public int getTotalScore() {
		return totalScore;
	}

	public void addToTotalScore(int newScore) {
		totalScore += newScore;
	}

}
