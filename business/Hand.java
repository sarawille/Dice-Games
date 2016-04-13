package business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Hand implements Readable, Sortable
{
	public ArrayList<Die> fiveDice = new ArrayList<>(5);
	
	public Hand() 
	{
		for (int i = 0; i < 5; i++)
		{
			fiveDice.add(new Die());
		}
	}
 	
	public void roll(int dieNumber) 
	{
		fiveDice.get(dieNumber).roll();
	}

	public void rollAll() 
	{
		roll(0);
		roll(1);
		roll(2);
		roll(3);
		roll(4);	
		printHand();
	}
	
	@Override
	public int readFaceUp() 
	{
		return 0;
	}
	
	@Override
	public int readFaceUp(int dieNumber) 
	{
		return fiveDice.get(dieNumber).readFaceUp();
	}
	
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
	
	public String printHand() 
	{
		String header = "\t  Die 1\t\t  Die 2\t\t  Die 3\t\t  Die 4\t\t  Die 5\n";
		String printRow1 =
				"\t  " + Die.dieVisual1(readFaceUp(0)) + "   " +
				"\t  " + Die.dieVisual1(readFaceUp(1)) + "   " +
				"\t  " + Die.dieVisual1(readFaceUp(2)) + "   " +
				"\t  " + Die.dieVisual1(readFaceUp(3)) + "   " +
				"\t  " + Die.dieVisual1(readFaceUp(4)) + "   ";
		String printRow2 =
				"\t  " + Die.dieVisual2(readFaceUp(0)) + "   " +
				"\t  " + Die.dieVisual2(readFaceUp(1)) + "   " +
				"\t  " + Die.dieVisual2(readFaceUp(2)) + "   " +
				"\t  " + Die.dieVisual2(readFaceUp(3)) + "   " +
				"\t  " + Die.dieVisual2(readFaceUp(4)) + "   ";
		String printRow3 =
				"\t  " + Die.dieVisual3(readFaceUp(0)) + "   " +
				"\t  " + Die.dieVisual3(readFaceUp(1)) + "   " +
				"\t  " + Die.dieVisual3(readFaceUp(2)) + "   " +
				"\t  " + Die.dieVisual3(readFaceUp(3)) + "   " +
				"\t  " + Die.dieVisual3(readFaceUp(4)) + "   ";
		return("\n" + header + "\n" + printRow1 + "\n" + printRow2 + "\n" + printRow3 + "\n");
	}
}
