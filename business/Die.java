package business;

import business.Readable;
import business.Rollable;

/**
 * @author Sara Wille
 * The Die object has a number of sides and a side that is face up.  
 * The number of sides must be set when the Die is instantiated.
 * The die can be rolled, the face up side can be read, and the face up side can be displayed.
 */

public class Die implements Readable, Rollable {
	
	protected int sides = 0;
	protected int faceUp = 0;
	
	public Die(int sides) {
		setSides(sides);
	}
	
	/**
	 * setSides() - setter for variable int sides
	 */
	public void setSides(int sides) {
		this.sides = sides;
	}
	
	/**
	 * roll() - Overrides the roll() method implemented from Rollable.
	 *  The Die is "rolled": the face up side is set to a random number,
	 *  assuming each side of the die is a number from 1 to the number of sides.
	 */
	public void roll() 
	{
		faceUp = (int) ((Math.random() * sides + 1)); 
	}
	
	/**
	 * readFaceUp() - Overrides the readFaceUp() method implemented from Readable.
	 *  The Die's face up side is returned as an integer.
	 *  @return faceUp
	 */
	@Override
	public int readFaceUp()
	{
		return faceUp;
	}

	/**
	 * readFaceUp(int i) - Overrides the readFaceUp() method implemented from Readable.
	 *  This is a method that I want to take out, but need to figure out how to do that with Readable interface.
	 *  @param i
	 *  @return 0
	 */
	@Override
	public int readFaceUp(int i) {
		return 0;
	}
	
	/** 
	 * dieVisual1() - Creates the first line of a three line visual
	 *  to display the number on the face up side of the die.
	 *  The Hand object is then used to compile a String of dice that display
	 *  side by side depending on how many dice are in the hand.
	 * @param faceUp
	 * @return row1
	 */
	public static String dieVisual1(int faceUp) 
	{
		String row1 = "";
		if (faceUp == 1) 
		{
			row1 = "     ";		
		} 
		else if (faceUp == 2 || faceUp == 3) 
		{
			row1 = "o    ";
		} 
		else if (faceUp == 4 || faceUp == 5) 
		{
			row1 = "o   o";
		}
		else if (faceUp == 6) 
		{
			row1 = "o o o";
		}
		return row1;
	}
	
	/** 
	 * dieVisual2() - Creates the second line of a three line visual
	 *  to display the number on the face up side of the die.
	 *  The Hand object is then used to compile a String of dice that display
	 *  side by side depending on how many dice are in the hand.
	 * @param faceUp
	 * @return row3
	 */
	public static String dieVisual2(int faceUp) 
	{
		String row2 = "";
		if (faceUp == 1 || faceUp == 3 || faceUp == 5) 
		{
			row2 = "  o  ";			
		} 
		else if (faceUp == 2 || faceUp == 4 || faceUp == 6) 
		{
			row2 = "     ";
		}
		return row2;
	}

	/** 
	 * dieVisual3() - Creates the third line of a three line visual
	 *  to display the number on the face up side of the die.
	 *  The Hand object is then used to compile a String of dice that display
	 *  side by side depending on how many dice are in the hand.
	 * @param faceUp
	 * @return row3
	 */
	public static String dieVisual3(int faceUp) 
	{
		String row3 = "";
		if (faceUp == 1) 
		{
			row3 = "     ";			
		} 
		else if (faceUp == 2 || faceUp == 3) 
		{
			row3 = "    o";
		}
		else if (faceUp == 4 || faceUp == 5) 
		{
			row3 = "o   o";
		}
		else if (faceUp == 6) 
		{
			row3 = "o o o";
		}
		return row3;
	}

	
}
