package scoring;

import business.Hand;
import scoring.Scorable;
import scoring.ScoreCategory;
import scoring.ScoreEquations;
import ui.Displayable;
import ui.Validator;

public class ScoreCalculations extends ScoreEquations implements Scorable {

	Validator theValidator;
	Displayable screen;
	
	public ScoreCalculations(Displayable myDisplay, Validator theValidator) 
	{
		this.theValidator = theValidator;
		this.screen = myDisplay;
	}
	
	public void scoreHand(Hand newHand) {
		ScoreCategory scoreCategoryForThisHand = null;

		//determine which categories are eligible for scoring based on the hand
		screen.displayln(getScoreChoices(newHand));
		
		//ask the user to pick a category to score
		scoreCategoryForThisHand = assignScoreCategory();
		
		//incorporate the score for this hand into the total score
		calcTotalScore(scoreCategoryForThisHand);
	}
	
	public ScoreCategory assignScoreCategory() {
		String userInput = "";
		while (true) 
		{
			userInput = theValidator.getString("I want to score category: ");
			switch (userInput) 
			{
				case "1":
					return ScoreCategory.ONES;
				case "2":
					return ScoreCategory.TWOS;
				case "3":
					return ScoreCategory.THREES;
				case "4":
					return ScoreCategory.FOURS;
				case "5":
					return ScoreCategory.FIVES;
				case "6":
					return ScoreCategory.SIXES;
				case "3K":
				case "3k":
					return ScoreCategory.THREE_OF_A_KIND;
				case "4K":
				case "4k":
					return ScoreCategory.FOUR_OF_A_KIND;
				case "F":
				case "f":
					return ScoreCategory.FULL_HOUSE;
				case "S":
				case "s":
					return ScoreCategory.SMALL_STRAIGHT;
				case "L":
				case "l":
					return ScoreCategory.LARGE_STRAIGHT;
				case "C":
				case "c":
					return ScoreCategory.CHANCE;
				case "Y":
				case "y":
					return ScoreCategory.YAHTZEE;
				default:
					screen.display("Please choose a valid scoring option.\n");
			}
		}
	}

	@Override
	public void calcTotalScore(ScoreCategory userChoice) {
		switch(userChoice)
		{
		case ONES:
			setTotalScore(onesPossiblePoints);
			setOnesPoints(onesPossiblePoints);
			break;
		case TWOS:
			setTotalScore(twosPossiblePoints);
			setTwosPoints(twosPossiblePoints);
			break;
		case THREES:
			setTotalScore(threesPossiblePoints);
			setThreesPoints(threesPossiblePoints);
			break;
		case FOURS:
			setTotalScore(foursPossiblePoints);
			setFoursPoints(foursPossiblePoints);
			break;
		case FIVES:
			setTotalScore(fivesPossiblePoints);
			setFivesPoints(fivesPossiblePoints);
			break;
		case SIXES:
			setTotalScore(sixesPossiblePoints);
			setSixesPoints(sixesPossiblePoints);
			break;
		case THREE_OF_A_KIND:
			setTotalScore(threeOfAKindPossiblePoints);
			setThreeOfAKindPoints(threeOfAKindPossiblePoints);
			break;
		case FOUR_OF_A_KIND:
			setTotalScore(fourOfAKindPossiblePoints);
			setFourOfAKindPoints(fourOfAKindPossiblePoints);
			break;
		case FULL_HOUSE:
			setTotalScore(fullHousePossiblePoints);
			setFullHousePoints(fullHousePossiblePoints);
			break;
		case SMALL_STRAIGHT:
			setTotalScore(smallStraightPossiblePoints);
			setSmallStraightPoints(smallStraightPossiblePoints);
			break;
		case LARGE_STRAIGHT:
			setTotalScore(largeStraightPossiblePoints);
			setLargeStraightPoints(largeStraightPossiblePoints);
			break;
		case CHANCE:
			setTotalScore(chancePossiblePoints);
			setChancePoints(chancePossiblePoints);
			break;
		case YAHTZEE:
			setTotalScore(yahtzeePossiblePoints);
			setYahtzeePoints(yahtzeePossiblePoints);
			break;
		default:
			break;
		}	
	}

	@Override
	public void printTotalScore() {
		String total = "" + getTotalScore();
		screen.displayln(total);
	}

}
