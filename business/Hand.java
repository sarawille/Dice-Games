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
	public ArrayList<Die> fiveDice;
	
	public Hand(int numberOfDice, int sides) 
	{
		fiveDice = new ArrayList<>(numberOfDice);
		for (int i = 0; i < numberOfDice; i++)
		{
			fiveDice.add(new Die(sides));
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
		fiveDice.get(dieNumber).roll();
	}

	/**
	 * rollAll() - Rolls all die in the Hand by calling the Die.roll() method.
	 */
	public void rollAll() 
	{
		for (int i = 0; i < fiveDice.size(); i++)
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
		return fiveDice.get(dieNumber).readFaceUp();
	}
	
	/**
	 * sortItems() - Overrides the sortItems() method of the Sortable interface.
	 *  Using a bubble sort, the method arranges all Die in the Hand from the 
	 *  lowest face up value to the highest.  
	 */
	@Override
	public void sortItems() 
	{
		for (int m = fiveDice.size(); m >= 0; m--) {
            for (int i = 0; i < fiveDice.size() - 1; i++) {
				if (fiveDice.get(i).readFaceUp() > fiveDice.get(i+1).readFaceUp())
				{
					Die temp = fiveDice.get(i+1);
					fiveDice.remove(i+1);
					fiveDice.add(i, temp);
				}
			}
		}
	}
	
	/**
	 * printHand() - Creates a String that is a visual, side-by-side representation of 
	 *  the face up side of all dice in the Hand.  
	 * @return header + printRow1 + printRow2 + printRow3
	 */
	public String printHand() 
	{
		String header = "\t  Die 1\t\t  Die 2\t\t  Die 3\t\t  Die 4\t\t  Die 5\n";
		String printRow1 =
				"\t  " + Die.dieVisual1(readDie(0)) + "   " +
				"\t  " + Die.dieVisual1(readDie(1)) + "   " +
				"\t  " + Die.dieVisual1(readDie(2)) + "   " +
				"\t  " + Die.dieVisual1(readDie(3)) + "   " +
				"\t  " + Die.dieVisual1(readDie(4)) + "   ";
		String printRow2 =
				"\t  " + Die.dieVisual2(readDie(0)) + "   " +
				"\t  " + Die.dieVisual2(readDie(1)) + "   " +
				"\t  " + Die.dieVisual2(readDie(2)) + "   " +
				"\t  " + Die.dieVisual2(readDie(3)) + "   " +
				"\t  " + Die.dieVisual2(readDie(4)) + "   ";
		String printRow3 =
				"\t  " + Die.dieVisual3(readDie(0)) + "   " +
				"\t  " + Die.dieVisual3(readDie(1)) + "   " +
				"\t  " + Die.dieVisual3(readDie(2)) + "   " +
				"\t  " + Die.dieVisual3(readDie(3)) + "   " +
				"\t  " + Die.dieVisual3(readDie(4)) + "   ";
		return("\n" + header + "\n" + printRow1 + "\n" + printRow2 + "\n" + printRow3 + "\n");
	}
}
