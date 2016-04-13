package ui;

import java.util.Scanner;

public class RequestInformation {

	static Scanner userInput = new Scanner(System.in);
	
	public static String getInfo() {
		return userInput.nextLine();
	}
}