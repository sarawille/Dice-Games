package scoring;

import business.Hand;

public class ScoreEquations extends ScoreVariables
{
	
	public void execute(Hand newHand) {
		scoreChoices.setLength(0);
		scoreChoices.append("Which category do you want to score? \n");
		calcSingleNumbers(newHand, onesPossiblePoints, onesPoints, 1, "Ones");
		calcSingleNumbers(newHand, twosPossiblePoints, twosPoints, 2, "Twos");
		calcSingleNumbers(newHand, threesPossiblePoints, threesPoints, 3, "Threes");
		calcSingleNumbers(newHand, foursPossiblePoints, foursPoints, 4, "Fours");
		calcSingleNumbers(newHand, fivesPossiblePoints, fivesPoints, 5, "Fives");
		calcSingleNumbers(newHand, sixesPossiblePoints, sixesPoints, 6, "Sixes");
		calcThreeOfAKind(newHand);
		calcFourOfAKind(newHand);
		calcFullHouse(newHand);
		calcSmallStraight(newHand);
		calcLargeStraight(newHand);
		calcChance(newHand);
		calcYahtzee(newHand);
	}
	
	public int calcSingleNumbers(Hand newHand, int possiblePoints, int points, int numberChecking, String name) 
	{
		possiblePoints = 0;
		if (points < 0) 
		{
			for (int counter = 0; counter < 5; counter++)
			{
				possiblePoints += (newHand.readDie(counter) == numberChecking) ? numberChecking : 0;
			}
		}
		if (possiblePoints > 0) 
		{
			scoreChoices.append(numberChecking + " \t " + name + "\t\t\t" + possiblePoints + " points\n");
		}
		return possiblePoints;
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
				scoreChoices.append("3K \t 3 of a Kind \t\t" + getThreeOfAKindPossiblePoints() + " points\n"); 
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
