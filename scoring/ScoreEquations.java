package scoring;

import business.Hand;

/**
 * @author Sara Wille
 * The ScoreEquations class contains all methods required to calculate the scoring options
 * for the game Yahtzee.  As the calculations are run, the scoreChoices StringBuilder
 * updates to contain available score categories which can be displayed to the player.
 * 
 * In the case that no score categories are available based on the dice in the Hand, 
 * the class also contains a method to determine which score categories can be set to 0, 
 * giving the player the choice of which category to score as 0 points.
 */
public class ScoreEquations extends ScoreVariables
{
	
	protected StringBuilder scoreChoices = new StringBuilder();
	int diceSum;
	
	/**
	 * getScoreChoices() - This is the primary method called from ScoreCalculations
	 *  because it runs all other methods contained in this ScoreEquations class.
	 *  This method builds out the scoreChoices StringBuilder to include a list of 
	 *  all available scoring categories.  If no categories qualify for scoring based
	 *  on the value of the dice in the current Hand, the score choices menu will include
	 *  a list of categories that the user can set to 0 points. The scoreChoice StringBuilder 
	 *  menu is converted to a String before being returned.
	 * @param newHand
	 * @return stringOfScoreChoices
	 */
	public String getScoreChoices(Hand newHand) {
		String stringOfScoreChoices = "";
		scoreChoices.setLength(0);
		scoreChoices.append("Which category do you want to score? \n");
		executeScoreEquations(newHand);
		createScoreMenu();
		stringOfScoreChoices = scoreChoices.toString();
		if (stringOfScoreChoices.endsWith("Which category do you want to score? \n"))
		{
			stringOfScoreChoices += getZeros();
		}
		return stringOfScoreChoices;
	}
	
	/**
	 * getZeros() - If no categories qualify for scoring based on the value of the 
	 *  dice in the current Hand, this method will be run by getScoreChoices(). 
	 *  This method returns a String that lists the categories the user can choose
	 *  to score as 0 points. Any category that has not yet been score will be included
	 *  in the returned list.
	 * @return addZerosToScoreChoices
	 */
	private String getZeros() {
		StringBuilder addZerosToScoreChoices = new StringBuilder();
		addZerosToScoreChoices.append("Sorry, no score categories are available!\n");
		addZerosToScoreChoices.append("You must choose a category to score with 0 points.\n");
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
			addZerosToScoreChoices.append("S \t Small Straight \t 0  points\n");
		}
		if (largeStraightPoints <0 ){
			addZerosToScoreChoices.append("L \t Large Straight \t 0  points\n");
		}
		if (chancePoints <0 ){
			addZerosToScoreChoices.append("C \t Chance \t\t 0  points\n");
		}
		if (yahtzeePoints <0 ){
			addZerosToScoreChoices.append("Y \t Yahtzee \t\t 0  points\n");
		}
		return addZerosToScoreChoices.toString();
	}

	/**
	 * executeScoreEquations() - This method is called by getScoreChoices(). It
	 *  sorts the Die from lowest to highest value (necessary for determining whether
	 *  categories of Full House, Small Straight and Large straight are applicable). Then 
	 *  it runs all methods in the ScoreEquations class whose purpose is to calculate
	 *  possible points for a scoring category.
	 * @param newHand
	 */
	private void executeScoreEquations(Hand newHand) {
		diceSum = newHand.readDie(0) +
			 	newHand.readDie(1) +
			 	newHand.readDie(2) +
			 	newHand.readDie(3) +
			 	newHand.readDie(4);
		newHand.sortItems();
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
	
	/**
	 * 
	 * @param number
	 * @return instance
	 */
	private int countInstances(int number, Hand newHand) {
		int instance = 0;
		for (int counter = 0; counter < 5; counter++)
		{
			if (newHand.readDie(counter) == number)
			{
				instance++;
			}
		}
		return instance;
	}
	
	/**
	 * calcOnes() - If the Ones category has not yet been scored, the calcOnes method 
	 *  checks whether the Hand includes dice with a 1 facing up.  If the Hand 
	 *  includes 1s, the method determines the points that could be scored for the Ones category.  
	 *  Then, it returns the possible points to be scored in the Ones category.
	 *    
	 *  The Ones category is scored by adding up the value of all dice with 1 facing up.
	 *  
	 * @param newHand
	 * @return onesPossiblePoints
	 */
	public int calcOnes(Hand newHand) 
	{
		onesPossiblePoints = 0;
		if (onesPoints < 0) 
		{
			setOnesPossiblePoints(countInstances(1, newHand) * 1);
		}
		return onesPossiblePoints;
	}

	/**
	 * calcTwos() - If the Twos category has not yet been scored, the calcTwos method 
	 *  checks whether the Hand includes dice with a 2 facing up.  If the Hand 
	 *  includes 2s, the method determines the points that could be scored for the Twos category.  
	 *  Then, it returns the possible points to be scored in the Twos category.
	 *    
	 *  The Twos category is scored by adding up the value of all dice with 2 facing up.
	 *  
	 * @param newHand
	 * @return twosPossiblePoints
	 */
	public int calcTwos(Hand newHand) 
	{
		twosPossiblePoints = 0;
		if (twosPoints < 0) 
		{
			setTwosPossiblePoints(countInstances(2, newHand) * 2);
		}
		return twosPossiblePoints;
	}
	
	/**
	 * calcThrees() - If the Threes category has not yet been scored, the calcThrees method 
	 *  checks whether the Hand includes dice with a 3 facing up.  If the Hand 
	 *  includes 3s, the method determines the points that could be scored for the Threes category.  
	 *  Then, it returns the possible points to be scored in the Threes category.
	 *    
	 *  The Threes category is scored by adding up the value of all dice with 3 facing up.
	 *  
	 * @param newHand
	 * @return threesPossiblePoints
	 */
	public int calcThrees(Hand newHand) 
	{
		threesPossiblePoints = 0;
		if (threesPoints < 0) 
		{
			setThreesPossiblePoints(countInstances(3, newHand) * 3);
		}
		return threesPossiblePoints;
	}
	
	/**
	 * calcFours() - If the Fours category has not yet been scored, the calcFours method 
	 *  checks whether the Hand includes dice with a 4 facing up.  If the Hand 
	 *  includes 4s, the method determines the points that could be scored for the Fours category.  
	 *  Then, it returns the possible points to be scored in the Fours category.
	 *    
	 *  The Fours category is scored by adding up the value of all dice with 4 facing up.
	 *  
	 * @param newHand
	 * @return foursPossiblePoints
	 */
	public int calcFours(Hand newHand) 
	{
		foursPossiblePoints = 0;
		if (foursPoints < 0) 
		{
			setFoursPossiblePoints(countInstances(4, newHand) * 4);
		}
		return foursPossiblePoints;
	}
	
	/**
	 * calcFives() - If the Fives category has not yet been scored, the calcFives method 
	 *  checks whether the Hand includes dice with a 5 facing up.  If the Hand 
	 *  includes 5s, the method determines the points that could be scored for the Fives category.  
	 *  Then, it returns the possible points to be scored in the Fives category.
	 *    
	 *  The Fives category is scored by adding up the value of all dice with 5 facing up.
	 *  
	 * @param newHand
	 * @return fivesPossiblePoints
	 */
	public int calcFives(Hand newHand) 
	{
		fivesPossiblePoints = 0;
		if (fivesPoints < 0) 
		{
			setFivesPossiblePoints(countInstances(5, newHand) * 5);
		}
		return fivesPossiblePoints;
	}
	
	/**
	 * calcSixes() - If the Sixes category has not yet been scored, the calcSixes method 
	 *  checks whether the Hand includes dice with a 6 facing up.  If the Hand 
	 *  includes 6s, the method determines the points that could be scored for the Sixes category.  
	 *  Then, it returns the possible points to be scored in the Sixes category.
	 *    
	 *  The Sixes category is scored by adding up the value of all dice with 6 facing up.
	 *  
	 * @param newHand
	 * @return sixesPossiblePoints
	 */
	public int calcSixes(Hand newHand) 
	{
		sixesPossiblePoints = 0;
		if (sixesPoints < 0) 
		{
			setSixesPossiblePoints(countInstances(6, newHand) * 6);
		}
		return sixesPossiblePoints;
	}

	/**
	 * calcThreeOfAKind() - If the Three of a Kind category has not yet been scored, the method 
	 *  checks whether the Hand qualifies to be scored as Three of a Kind.  If the Hand qualifies,
	 *  the method determines the possible points that could be scored for the Three of a Kind category.  
	 *  Then, it returns the possible points to be scored in the Three of a Kind category.
	 *    
	 *  The Three of a Kind category is scored by adding up the value of all dice in the Hand
	 *  if at least 3 dice have the same face up value.
	 *  
	 * @param newHand
	 * @return threeOfAKindPossiblePoints
	 */
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
				setThreeOfAKindPossiblePoints(diceSum);
			}
		}
		return getThreeOfAKindPossiblePoints();
	}

	/**
	 * calcFourOfAKind() - If the Four of a Kind category has not yet been scored, the method 
	 *  checks whether the Hand qualifies to be scored as Four of a Kind.  If the Hand qualifies,
	 *  the method determines the possible points that could be scored for the Four of a Kind category.  
	 *  Then, it returns the possible points to be scored in the Four of a Kind category.
	 *    
	 *  The Four of a Kind category is scored by adding up the value of all dice in the Hand
	 *  if at least 4 dice have the same face up value.
	 *  
	 * @param newHand
	 * @return fourOfAKindPossiblePoints
	 */
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
				setFourOfAKindPossiblePoints(diceSum);
			} 
		}
		return getFourOfAKindPossiblePoints();
	}

	/**
	 * calcFullHouse() - If the Full House category has not yet been scored, the method 
	 *  checks whether the Hand qualifies to be scored as a Full House.  If the Hand qualifies,
	 *  the method sets the possible points to be scored for Full House to 25.  Then, it  
	 *  returns the possible points to be scored in the Full House category.
	 *    
	 *  The Full House category is worth 25 points when the Hand contains a matching pair and 
	 *  Three of a Kind (2 dice of matching face up values with 3 dice of matching face up values).
	 *  
	 * @param newHand
	 * @return fullHousePossiblePoints
	 */
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
			}
		}
		return getFullHousePossiblePoints();
	}

	/**
	 * calcSmallStraight() - If the Small Straight category has not yet been scored, the method 
	 *  checks whether the Hand qualifies to be scored as a Small Straight.  If the Hand qualifies,
	 *  the method sets the possible points to be scored for Small Straight to 30.  Then, it  
	 *  returns the possible points to be scored in the Small Straight category.
	 *    
	 *  The Small Straight category is worth 30 points when the Hand contains a run of at least 
	 *  4 dice with consecutive face up values.
	 *  
	 * @param newHand
	 * @return smallStraightPossiblePoints
	 */
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
			}
		}
		return getSmallStraightPossiblePoints();
	}

	/**
	 * calcLargeStraight() - If the Large Straight category has not yet been scored, the method 
	 *  checks whether the Hand qualifies to be scored as a Large Straight.  If the Hand qualifies,
	 *  the method sets the possible points to be scored for Large Straight to 40.  Then, it 
	 *  returns the possible points to be scored in the Large Straight category.
	 *    
	 *  The Large Straight category is worth 40 points when the Hand contains a run of all 5 dice 
	 *  with consecutive face up values.
	 *  
	 * @param newHand
	 * @return largeStraightPossiblePoints
	 */
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
			}
		}
		return getLargeStraightPossiblePoints();
	}
	
	/**
	 * calcChance() - If the Chance category has not yet been scored, the method sets the 
	 *  possible points to be scored for Chance equal to the sum of all 5 face up values.
	 *  Then, it returns the possible points to be scored in the Chance category.
	 *    
	 *  The Chance category is scored by adding up the face up values of all dice in the Hand. It
	 *  can be scored on any turn regardless of what the face up values are, but like other categories
	 *  it can only be scored once.
	 *  
	 * @param newHand
	 * @return chancePossiblePoints
	 */
	public int calcChance(Hand newHand) 
	{
		setChancePossiblePoints(0);
		if (getChancePoints() < 0)
		{
			setChancePossiblePoints(diceSum);	
		} 
		return getChancePossiblePoints();
	}

	/**
	 * calcYahtzee() - If the Yahtzee category has not yet been scored, the method 
	 *  checks whether the Hand qualifies to be scored as a Yahtzee.  If the Hand qualifies,
	 *  the method sets the possible points to be scored for the Yahtzee category.
	 *  Then, it returns the possible points to be scored in the Yahtzee category.
	 *  
	 *  The Yahtzee category is worth 50 points when the Hand contains all 5 dice with the same
	 *  face up value. Any additional Yahtzee after the first is worth 100 points each.
	 *  However, if the player scored the Yahtzee category as 0 points on a previous turn,
	 *  no additional Yahtzee points can be earned.
	 *  
	 * @param newHand
	 * @return yahtzeePossiblePoints
	 */
	public int calcYahtzee(Hand newHand) 
	{
		setYahtzeePossiblePoints(0);
		if (newHand.readDie(0) == newHand.readDie(1) && newHand.readDie(1) == newHand.readDie(2) && 
				newHand.readDie(2) == newHand.readDie(3) && newHand.readDie(3) == newHand.readDie(4)) 
		{	
			if (getYahtzeePoints() >= 50) 
			{
				setYahtzeePossiblePoints(100);
			}
			else if (getYahtzeePoints() < 0)	//does not allow yahtzee score if category already scored as a 0
			{	
				setYahtzeePossiblePoints(50);
			}
		} 
		return getYahtzeePossiblePoints();
	}

	private void createScoreMenu() 
	{
		if (onesPossiblePoints > 0) 
		{
			scoreChoices.append("1 \t Ones \t\t\t" + onesPossiblePoints + " points\n");
		}
		if (twosPossiblePoints > 0) 
		{
			scoreChoices.append("2 \t Twos \t\t\t" + twosPossiblePoints + " points\n");
		}
		if (threesPossiblePoints > 0) 
		{
			scoreChoices.append("3 \t Threes \t\t" + threesPossiblePoints + " points\n");
		}
		if (foursPossiblePoints > 0) 
		{
			scoreChoices.append("4 \t Fours \t\t\t" + foursPossiblePoints + " points\n");
		}
		if (fivesPossiblePoints > 0) 
		{
			scoreChoices.append("5 \t Fives \t\t\t" + fivesPossiblePoints + " points\n");
		}
		if (sixesPossiblePoints > 0) 
		{
			scoreChoices.append("6 \t Sixes \t\t\t" + sixesPossiblePoints + " points\n");
		}
		if (threeOfAKindPossiblePoints > 0)
		{
			scoreChoices.append("3K \t 3 of a Kind  \t\t" + getThreeOfAKindPossiblePoints() + " points\n");
		}
		if (fourOfAKindPossiblePoints > 0)
		{
			scoreChoices.append("4K \t 4 of a Kind \t\t" + getFourOfAKindPossiblePoints() +" points\n");
		}
		if (fullHousePossiblePoints > 0)
		{
			scoreChoices.append("F \t Full House \t\t" + getFullHousePossiblePoints() + " points\n");
		}
		if (smallStraightPossiblePoints > 0)
		{
			scoreChoices.append("S \t Small Straight \t" + getSmallStraightPossiblePoints() + " points\n");
		}
		if (largeStraightPossiblePoints > 0)
		{
			scoreChoices.append("L \t Large Straight \t" + getLargeStraightPossiblePoints() + " points\n");
		}
		if (chancePossiblePoints > 0)
		{
			scoreChoices.append("C \t Chance \t\t" + getChancePossiblePoints() + " points\n");
		}
		if (yahtzeePossiblePoints == 50)
		{
			scoreChoices.append("Y \t YAHTZEE! \t\t" + getYahtzeePossiblePoints() + " points\n");
		}
		else if (yahtzeePossiblePoints == 100) 
		{
			scoreChoices.append("Y \t Another YAHTZEE! \t\t" + getYahtzeePossiblePoints() + " points\n");
		}
	}
}
