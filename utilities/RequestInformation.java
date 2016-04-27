package utilities;

import java.util.Scanner;

/**
 * 
 * @author Sara Wille
 * The RequestInformation class is the only class in the program that contains a Scanner.
 * It is used to get input from the user.
 * 
 */
public class RequestInformation {

	static Scanner userInput = new Scanner(System.in);
	
	public static String getInfo() {
		return userInput.nextLine();
	}
}