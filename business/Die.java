package business;

import business.Readable;
import business.Rollable;

public class Die implements Readable, Rollable {
	
	final int SIDES = 6;
	int faceUp = 0;
	
	public void roll() 
	{
		faceUp = (int) ((Math.random() * SIDES + 1)); 
	}
	
	@Override
	public int readFaceUp()
	{
		return faceUp;
	}

	@Override
	public int readFaceUp(int i) {
		return 0;
	}
	
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
