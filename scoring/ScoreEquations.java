package scoring;

import business.Hand;

public class ScoreEquations extends ScoreVariables
{
	
	public String getScoreChoices(Hand newHand) {
		String stringOfScoreChoices = "";
		scoreChoices.setLength(0);
		scoreChoices.append("Which category do you want to score? \n");
		executeCalculations(newHand);
		stringOfScoreChoices = scoreChoices.toString();
		if (stringOfScoreChoices.endsWith("Which category do you want to score? \n"))
		{
			stringOfScoreChoices += getZeros();
		}
		return stringOfScoreChoices;
	}
	
	private String getZeros() {
		StringBuilder addZerosToScoreChoices = new StringBuilder();
		addZerosToScoreChoices.append("Sorry, no score categories are available!");
		addZerosToScoreChoices.append("You must choose a category to score with 0 points.");
		if (onesPoints <0 ){
			addZerosToScoreChoices.append("1 \t Ones \t\t\t 0 points\n");
		}
		if (twosPoints <0 ){
			addZerosToScoreChoices.append("2 \t Twos \t\t\t 0 points\n");
		}
		if (threesPoints <0 ){
			addZerosToScoreChoices.append("3 \t Threes \t\t 0  points\n");
		}
		if (foursPoints <0 ){
			addZerosToScoreChoices.append("4 \t Fours \t\t\t 0  points\n");
		}
		if (fivesPoints <0 ){
			addZerosToScoreChoices.append("5 \t Fives \t\t\t 0  points\n");
		}
		if (sixesPoints <0 ){
			addZerosToScoreChoices.append("6 \t Sixes \t\t\t 0  points\n");
		}
		if (threeOfAKindPoints <0 ){
			addZerosToScoreChoices.append("3K \t 3 of a Kind \t\t 0  points\n");
		}
		if (fourOfAKindPoints <0 ){
			addZerosToScoreChoices.append("4K \t 4 of a Kind \t\t 0  points\n");
		}
		if (fullHousePoints <0 ){
			addZerosToScoreChoices.append("F \t Full House \t\t 0  points\n");
		}
		if (smallStraightPoints <0 ){
			addZerosToScoreChoices.append("S \t Small Straight \t\t 0  points\n");
		}
		if (largeStraightPoints <0 ){
			addZerosToScoreChoices.append("L \t Large Straight \t\t 0  points\n");
		}
		if (chancePoints <0 ){
			addZerosToScoreChoices.append("C \t Chance \t\t 0  points\n");
		}
		return addZerosToScoreChoices.toString();
	}

	private void executeCalculations(Hand newHand) {
		calcOnes(newHand);
		calcTwos(newHand);
		calcThrees(newHand);
		calcFours(newHand);
		calcFives(newHand);
		calcSixes(newHand);
		calcThreeOfAKind(newHand);
		calcFourOfAKind(newHand);
		calcFullHouse(newHand);
		calcSmallStraight(newHand);
		calcLargeStraight(newHand);
		calcChance(newHand);
		calcYahtzee(newHand);
	}
	
	public int calcOnes(Hand newHand) 
	{
		onesPossiblePoints = 0;
		if (onesPoints < 0) 
		{
			for (int counter = 0; counter < 5; counter++)
			{
				onesPossiblePoints += (newHand.readDie(counter) == 1) ? 1 : 0;
			}
		}
		if (onesPossiblePoints > 0) 
		{
			scoreChoices.append("1 \t Ones \t\t\t" + onesPossiblePoints + " points\n");
		}
		return onesPossiblePoints;
	}
	
	public int calcTwos(Hand newHand) 
	{
		twosPossiblePoints = 0;
		if (twosPoints < 0) 
		{
			for (int counter = 0; counter < 5; counter++)
			{
				twosPossiblePoints += (newHand.readDie(counter) == 2) ? 2 : 0;
			}
		}
		if (twosPossiblePoints > 0) 
		{
			scoreChoices.append("2 \t Twos \t\t\t" + twosPossiblePoints + " points\n");
		}
		return twosPossiblePoints;
	}
	
	public int calcThrees(Hand newHand) 
	{
		threesPossiblePoints = 0;
		if (threesPoints < 0) 
		{
			for (int counter = 0; counter < 5; counter++)
			{
				threesPossiblePoints += (newHand.readDie(counter) == 3) ? 3 : 0;
			}
		}
		if (threesPossiblePoints > 0) 
		{
			scoreChoices.append("3 \t Threes \t\t" + threesPossiblePoints + " points\n");
		}
		return threesPossiblePoints;
	}
	
	public int calcFours(Hand newHand) 
	{
		foursPossiblePoints = 0;
		if (foursPoints < 0) 
		{
			for (int counter = 0; counter < 5; counter++)
			{
				foursPossiblePoints += (newHand.readDie(counter) == 4) ? 4 : 0;
			}
		}
		if (foursPossiblePoints > 0) 
		{
			scoreChoices.append("4 \t Fours \t\t\t" + foursPossiblePoints + " points\n");
		}
		return foursPossiblePoints;
	}
	
	public int calcFives(Hand newHand) 
	{
		fivesPossiblePoints = 0;
		if (fivesPoints < 0) 
		{
			for (int counter = 0; counter < 5; counter++)
			{
				fivesPossiblePoints += (newHand.readDie(counter) == 5) ? 5 : 0;
			}
		}
		if (fivesPossiblePoints > 0) 
		{
			scoreChoices.append("5 \t Fives \t\t\t" + fivesPossiblePoints + " points\n");
		}
		return fivesPossiblePoints;
	}
	
	public int calcSixes(Hand newHand) 
	{
		sixesPossiblePoints = 0;
		if (sixesPoints < 0) 
		{
			for (int counter = 0; counter < 5; counter++)
			{
				sixesPossiblePoints += (newHand.readDie(counter) == 6) ? 6 : 0;
			}
		}
		if (sixesPossiblePoints > 0) 
		{
			scoreChoices.append("6 \t Sixes \t\t\t" + sixesPossiblePoints + " points\n");
		}
		return sixesPossiblePoints;
	}

	public int calcThreeOfAKind(Hand newHand) 
	{
		setThreeOfAKindPossiblePoints(0);
		if (getThreeOfAKindPoints() < 0) 
		{
			if (
					(newHand.readDie(0) == newHand.readDie(1) &&
					newHand.readDie(1) == newHand.readDie(2)) ||

					(newHand.readDie(1) == newHand.readDie(2) &&
					newHand.readDie(2) == newHand.readDie(3)) ||

					(newHand.readDie(2) == newHand.readDie(3)  &&
					newHand.readDie(3) == newHand.readDie(4)) )
			{
				setThreeOfAKindPossiblePoints(newHand.readDie(0) +
											  newHand.readDie(1) +
											  newHand.readDie(2) +
											  newHand.readDie(3) +
											  newHand.readDie(4));
				scoreChoices.append("3K \t 3 of a Kind  \t\t" + getThreeOfAKindPossiblePoints() + " points\n"); 
			}
		}
		return getThreeOfAKindPossiblePoints();
	}

	public int calcFourOfAKind(Hand newHand) 
	{
		setFourOfAKindPossiblePoints(0);
		if (getFourOfAKindPoints() < 0) 
		{
			if ((newHand.readDie(0) == newHand.readDie(1) &&
					newHand.readDie(1) == newHand.readDie(2) &&
					newHand.readDie(2) == newHand.readDie(3)) ||

					(newHand.readDie(1) == newHand.readDie(2) &&
					newHand.readDie(2) == newHand.readDie(3) &&
					newHand.readDie(3) == newHand.readDie(4)) )
			{
				setFourOfAKindPossiblePoints(newHand.readDie(0) +
											 newHand.readDie(1) +
											 newHand.readDie(2) +
											 newHand.readDie(3) +
											 newHand.readDie(4));
				scoreChoices.append("4K \t 4 of a Kind \t\t" + getFourOfAKindPossiblePoints() +" points\n");
			} 
		}
		return getFourOfAKindPossiblePoints();
	}

	public int calcFullHouse(Hand newHand) 
	{
		setFullHousePossiblePoints(0);
		if (getFullHousePoints() < 0) 
		{
			if ((newHand.readDie(0) == newHand.readDie(1) &&
					newHand.readDie(1) == newHand.readDie(2) &&
					newHand.readDie(3) == newHand.readDie(4) &&
					newHand.readDie(2) != newHand.readDie(3)) ||

					(newHand.readDie(0) == newHand.readDie(1) &&
					newHand.readDie(2) == newHand.readDie(3) &&
					newHand.readDie(3) == newHand.readDie(4) &&
					newHand.readDie(1) != newHand.readDie(2)) )
			{
				setFullHousePossiblePoints(25);
				scoreChoices.append("F \t Full House \t\t" + getFullHousePossiblePoints() + " points\n");
			}
		}
		return getFullHousePossiblePoints();
	}

	public int calcSmallStraight(Hand newHand) 
	{
		setSmallStraightPossiblePoints(0);
		if (getSmallStraightPoints() < 0) 
		{
			if ((newHand.readDie(1) == newHand.readDie(0) + 1 &&	
				 newHand.readDie(2) == newHand.readDie(1) + 1 &&
				 newHand.readDie(3) == newHand.readDie(2) + 1) ||

				(newHand.readDie(2) == newHand.readDie(1) + 1 &&
				 newHand.readDie(3) == newHand.readDie(2) + 1 &&
				 newHand.readDie(4) == newHand.readDie(3) + 1) )
			{
				setSmallStraightPossiblePoints(30);
				scoreChoices.append("S \t Small Straight \t" + getSmallStraightPossiblePoints() + " points\n");
			}
		}
		return getSmallStraightPossiblePoints();
	}

	public int calcLargeStraight(Hand newHand) 
	{
		setLargeStraightPossiblePoints(0);
		if (getLargeStraightPoints() <0) 
		{
			if (newHand.readDie(1) == newHand.readDie(0) + 1 &&	
				newHand.readDie(2) == newHand.readDie(1) + 1 &&
				newHand.readDie(3) == newHand.readDie(2) + 1 &&
				newHand.readDie(4) == newHand.readDie(3) + 1)
			{
				setLargeStraightPossiblePoints(40);
				scoreChoices.append("L \t Large Straight \t" + getLargeStraightPossiblePoints() + " points\n");
			}
		}
		return getLargeStraightPossiblePoints();
	}

	public int calcChance(Hand newHand) 
	{
		setChancePossiblePoints(0);
		if (getChancePoints() < 0)
		{
			setChancePossiblePoints(newHand.readDie(0) + newHand.readDie(1) + newHand.readDie(2) + 
					newHand.readDie(3) + newHand.readDie(4));	
			scoreChoices.append("C \t Chance \t\t" + getChancePossiblePoints() + " points\n");
		} 
		return getChancePossiblePoints();
	}

	public int calcYahtzee(Hand newHand) 
	{
		setYahtzeePossiblePoints(0);
		if (newHand.readDie(0) == newHand.readDie(1) && newHand.readDie(1) == newHand.readDie(2) && 
				newHand.readDie(2) == newHand.readDie(3) && newHand.readDie(3) == newHand.readDie(4)) 
		{	
			if (getYahtzeePoints() >= 50) {
				setYahtzeePossiblePoints(100);
				scoreChoices.append("Y \t Another YAHTZEE! \t\t" + getYahtzeePossiblePoints() + " points\n");
			}
			else {
				setYahtzeePossiblePoints(50);
				scoreChoices.append("Y \t YAHTZEE! \t\t" + getYahtzeePossiblePoints() + " points\n");
			}
		} 
		
		return getYahtzeePossiblePoints();
	}

}
