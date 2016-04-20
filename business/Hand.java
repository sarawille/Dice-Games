package business;

import java.util.ArrayList;

/**
 * @author Sara Wille
 * The Hand object is a collection of dice.  It implements Sortable to arrange dice sequentially.
 * The number of dice and number of sides on the dice must be set when the Hand is instantiated.
 * All dice in the hand will have the same number of sides.
 * Through the hand, the user can roll a single die, roll all dice, 
 * read the face up side on an individual die, and display the visuals of face up dice side by side.
 */

public class Hand implements Sortable
{
	public ArrayList<Die> diceInHand;
	
	public Hand(int numberOfDice, int sides) 
	{
		diceInHand = new ArrayList<>(numberOfDice);
		for (int i = 0; i < numberOfDice; i++)
		{
			diceInHand.add(new Die(sides));
		}
	}

	/**
	 * roll() - Rolls one die in the hand by calling the Die.roll() method.
	 *  The die rolled is determined by the die number passed in.
	 *  The die number is equal to the die index + 1. 
	 * @param dieNumber
	 */
	public void rollDie(int dieNumber) 
	{
		diceInHand.get(dieNumber).roll();
	}

	/**
	 * rollAll() - Rolls all die in the Hand by calling the Die.roll() method.
	 */
	public void rollAll() 
	{
		for (int i = 0; i < diceInHand.size(); i++)
		{
			rollDie(i);
		}
	}
	
	/**
	 * readDie() - Returns the number of the face up side of any give die by calling Die.readFaceUp().
	 *  The die read is determined by the die number passed in.
	 *  The die number is equal to the die index + 1. 
	 * @param dieNumber
	 * @return fiveDice[i].readFaceUp()
	 */
	public int readDie(int dieNumber) 
	{
		return diceInHand.get(dieNumber).readFaceUp();
	}
	
	/**
	 * sortItems() - Overrides the sortItems() method of the Sortable interface.
	 *  Using a bubble sort, the method arranges all Die in the Hand from the 
	 *  lowest face up value to the highest.  
	 */
	@Override
	public void sortItems() 
	{
		for (int m = diceInHand.size(); m >= 0; m--) {
            for (int i = 0; i < diceInHand.size() - 1; i++) {
				if (diceInHand.get(i).readFaceUp() > diceInHand.get(i+1).readFaceUp())
				{
					Die temp = diceInHand.get(i+1);
					diceInHand.remove(i+1);
					diceInHand.add(i, temp);
				}
			}
		}
	}
	
	/**
	 * printHand() - Creates a String that is a visual, side-by-side representation of 
	 *  the face up side of all dice in the Hand.  
	 * @return diceVisual
	 */
	public String printHand() 
	{
		StringBuilder diceVisual = new StringBuilder();
		for (int i = 0; i < diceInHand.size(); i++)
		{
			diceVisual.append("\t  Die " + (i+1) + "\t");
		}
		diceVisual.append("\n\n");
		for (int i = 0; i < diceInHand.size(); i++)
		{
				diceVisual.append("\t  " + Die.dieVisual1(readDie(i)) + "   ");
		}
		diceVisual.append("\n");
		for (int i = 0; i < diceInHand.size(); i++)
		{
			diceVisual.append("\t  " + Die.dieVisual2(readDie(i)) + "   ");
		}
		diceVisual.append("\n");
		for (int i = 0; i < diceInHand.size(); i++)
		{
			diceVisual.append("\t  " + Die.dieVisual3(readDie(i)) + "   ");
		}
		diceVisual.append("\n");
		
		return diceVisual.toString();
	}
}
