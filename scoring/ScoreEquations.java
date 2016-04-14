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
				possiblePoints += (newHand.readFaceUp(counter) == numberChecking) ? numberChecking : 0;
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
		if (threeOfAKindPoints < 0) 
		{
			if (
					(newHand.readFaceUp(0) == newHand.readFaceUp(1) &&
					newHand.readFaceUp(1) == newHand.readFaceUp(2)) ||

					(newHand.readFaceUp(1) == newHand.readFaceUp(2) &&
					newHand.readFaceUp(2) == newHand.readFaceUp(3)) ||

					(newHand.readFaceUp(2) == newHand.readFaceUp(3)  &&
					newHand.readFaceUp(3) == newHand.readFaceUp(4)) )
			{
				setThreeOfAKindPossiblePoints(newHand.readFaceUp(0) +
											  newHand.readFaceUp(1) +
											  newHand.readFaceUp(2) +
											  newHand.readFaceUp(3) +
											  newHand.readFaceUp(4));
				scoreChoices.append("3K \t 3 of a Kind \t\t" + getThreeOfAKindPossiblePoints() + " points\n"); 
			}
		}
		return getThreeOfAKindPossiblePoints();
	}

	public int calcFourOfAKind(Hand newHand) 
	{
		fourOfAKindPossiblePoints = 0;
		if (fourOfAKindPoints < 0) 
		{
			if ((newHand.readFaceUp(0) == newHand.readFaceUp(1) &&
					newHand.readFaceUp(1) == newHand.readFaceUp(2) &&
					newHand.readFaceUp(2) == newHand.readFaceUp(3)) ||

					(newHand.readFaceUp(1) == newHand.readFaceUp(2) &&
					newHand.readFaceUp(2) == newHand.readFaceUp(3) &&
					newHand.readFaceUp(3) == newHand.readFaceUp(4)) )
			{
				fourOfAKindPossiblePoints = newHand.readFaceUp(0) +
											newHand.readFaceUp(1) +
											newHand.readFaceUp(2) +
											newHand.readFaceUp(3) +
											newHand.readFaceUp(4);
				scoreChoices.append("4K \t 4 of a Kind \t\t" + fourOfAKindPossiblePoints +" points\n");
			} 
		}
		return fourOfAKindPossiblePoints;
	}

	public int calcFullHouse(Hand newHand) 
	{
		fullHousePossiblePoints = 0;
		if (fullHousePoints < 0) 
		{
			if ((newHand.readFaceUp(0) == newHand.readFaceUp(1) &&
					newHand.readFaceUp(1) == newHand.readFaceUp(2) &&
					newHand.readFaceUp(3) == newHand.readFaceUp(4) &&
					newHand.readFaceUp(2) != newHand.readFaceUp(3)) ||

					(newHand.readFaceUp(0) == newHand.readFaceUp(1) &&
					newHand.readFaceUp(2) == newHand.readFaceUp(3) &&
					newHand.readFaceUp(3) == newHand.readFaceUp(4) &&
					newHand.readFaceUp(1) != newHand.readFaceUp(2)) )
			{
				fullHousePossiblePoints = 25;
				scoreChoices.append("F \t Full House \t\t" + fullHousePossiblePoints + " points\n");
			}
		}
		return fullHousePossiblePoints;
	}

	public int calcSmallStraight(Hand newHand) 
	{
		smallStraightPossiblePoints = 0;
		if (smallStraightPoints < 0) 
		{
			if ((newHand.readFaceUp(1) == newHand.readFaceUp(0) + 1 &&	
				 newHand.readFaceUp(2) == newHand.readFaceUp(1) + 1 &&
				 newHand.readFaceUp(3) == newHand.readFaceUp(2) + 1) ||

				(newHand.readFaceUp(2) == newHand.readFaceUp(1) + 1 &&
				 newHand.readFaceUp(3) == newHand.readFaceUp(2) + 1 &&
				 newHand.readFaceUp(4) == newHand.readFaceUp(3) + 1) )
			{
				smallStraightPossiblePoints = 30;
				scoreChoices.append("S \t Small Straight \t" + smallStraightPossiblePoints + " points\n");
			}
		}
		return smallStraightPossiblePoints;
	}

	public int calcLargeStraight(Hand newHand) 
	{
		largeStraightPossiblePoints = 0;
		if (largeStraightPoints <0) 
		{
			if (newHand.readFaceUp(1) == newHand.readFaceUp(0) + 1 &&	
				newHand.readFaceUp(2) == newHand.readFaceUp(1) + 1 &&
				newHand.readFaceUp(3) == newHand.readFaceUp(2) + 1 &&
				newHand.readFaceUp(4) == newHand.readFaceUp(3) + 1)
			{
				largeStraightPossiblePoints = 40;
				scoreChoices.append("L \t Large Straight \t" + largeStraightPossiblePoints + " points\n");
			}
		}
		return largeStraightPossiblePoints;
	}

	public int calcChance(Hand newHand) 
	{
		chancePossiblePoints = 0;
		if (chancePoints < 0)
		{
			chancePossiblePoints = newHand.readFaceUp(0) + newHand.readFaceUp(1) + newHand.readFaceUp(2) + 
					newHand.readFaceUp(3) + newHand.readFaceUp(4);	
			scoreChoices.append("C \t Chance \t\t" + chancePossiblePoints + " points\n");
		} 
		return chancePossiblePoints;
	}

	public int calcYahtzee(Hand newHand) 
	{
		yahtzeePossiblePoints = 0;
		if (yahtzeePoints < 0) {
			if (newHand.readFaceUp(0) == newHand.readFaceUp(1) && newHand.readFaceUp(1) == newHand.readFaceUp(2) && 
					newHand.readFaceUp(2) == newHand.readFaceUp(3) && newHand.readFaceUp(3) == newHand.readFaceUp(4)) 
			{	
				if (yahtzeePoints >= 50) {
					yahtzeePossiblePoints = 100;
					scoreChoices.append("Y \t Another YAHTZEE! \t\t" + yahtzeePossiblePoints + " points\n");
				}
				else {
					yahtzeePossiblePoints = 50;
					scoreChoices.append("Y \t YAHTZEE! \t\t" + yahtzeePossiblePoints + " points\n");
				}
			} 
		}
		return yahtzeePossiblePoints;
	}

}
