package db;

import business.Hand;
import db.ScoreCategory;
import ui.Displayable;
import ui.Validator;
import db.Scorable;
import db.ScoreEquations;

public class ScoreCalculations extends ScoreEquations implements Scorable {

	Validator theValidator;
	Displayable screen;
	
	public ScoreCalculations(Displayable myDisplay, Validator theValidator) 
	{
		this.theValidator = theValidator;
		this.screen = myDisplay;
	}
	
//	public void scoreHand(Hand newHand) {
//		ScoreCategory scoreCategoryForThisHand = null;
//
//		//determine which categories are eligible for scoring based on the hand
//		execute(newHand);
//		
//		//print the eligible score categories and ask the user to pick one
//		screen.displayln("\n" + scoreChoices);
//		scoreCategoryForThisHand = assignScoreCategory();
//		
//		//incorporate the score for this hand into the total score
//		calcTotalScore(scoreCategoryForThisHand);
//	}
	
	private ScoreCategory assignScoreCategory() {
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
					screen.display("\nPlease choose a valid scoring option.");
			}
		}
	}

	@Override
	public void calcTotalScore(ScoreCategory userChoice) {
//		switch(userChoice)
//		{
//		case ONES:
//			totalScore += onesPossiblePoints;
//			onesPoints = onesPossiblePoints;
//			break;
//		case TWOS:
//			totalScore += twosPossiblePoints;
//			twosPoints = twosPossiblePoints;
//			break;
//		case THREES:
//			totalScore += threesPossiblePoints;
//			threesPoints = threesPossiblePoints;
//			break;
//		case FOURS:
//			totalScore += foursPossiblePoints;
//			foursPoints = foursPossiblePoints;
//			break;
//		case FIVES:
//			totalScore += fivesPossiblePoints;
//			fivesPoints = fivesPossiblePoints;
//			break;
//		case SIXES:
//			totalScore += sixesPossiblePoints;
//			sixesPoints = sixesPossiblePoints;
//			break;
//		case THREE_OF_A_KIND:
//			totalScore += threeOfAKindPossiblePoints;
//			threeOfAKindPoints = threeOfAKindPossiblePoints;
//			break;
//		case FOUR_OF_A_KIND:
//			totalScore += fourOfAKindPossiblePoints;
//			fourOfAKindPoints = fourOfAKindPossiblePoints;
//			break;
//		case FULL_HOUSE:
//			totalScore += fullHousePossiblePoints;
//			fullHousePoints = fullHousePossiblePoints;
//			break;
//		case SMALL_STRAIGHT:
//			totalScore += smallStraightPossiblePoints;
//			smallStraightPoints = smallStraightPossiblePoints;
//			break;
//		case LARGE_STRAIGHT:
//			totalScore += largeStraightPossiblePoints;
//			largeStraightPoints = largeStraightPossiblePoints;
//			break;
//		case CHANCE:
//			totalScore += chancePossiblePoints;
//			chancePoints = chancePossiblePoints;
//			break;
//		case YAHTZEE:
//			totalScore += yahtzeePossiblePoints;
//			yahtzeePoints += yahtzeePossiblePoints;
//			break;
//		default:
//			break;
//		}	
	}

	@Override
	public void printTotalScore() {
//		screen.displayln("Your total score is " + totalScore);
	}

}
