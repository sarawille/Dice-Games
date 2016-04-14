package business;

import java.util.ArrayList;

public class Hand implements Sortable
{
	public ArrayList<Die> fiveDice = new ArrayList<>(5);
	
	public Hand(int numberOfDice, int sides) 
	{
		for (int i = 0; i < numberOfDice; i++)
		{
			fiveDice.add(new Die(sides));
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
	
	public int readDie(int dieNumber) 
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
	
	//TODO make a printer/eyes class to do this part?
	/**
	 * The Hand object is then used to compile a String of dice that display
	 *  side by side depending on how many dice are in the hand.
	 * @return
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
