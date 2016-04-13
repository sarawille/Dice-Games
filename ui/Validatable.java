package ui;

import ui.Displayable;
import ui.IOFactory;

/**
 * @author Sara Wille
 * The Validatable interface confirms whether user input
 * is a valid int, double or String.  It can also check whether
 * the int or double is within a certain range, and whether
 * the String is a given length.
 *
 */
public interface Validatable {
	Displayable screen = IOFactory.getDisplayable();
	
	default int isValidInt(String s) {
		return Integer.parseInt(s);
	}
	
	default boolean isInRange(int userInt, int min, int max)
	{
		if (userInt < min) {
			return false;
		} else if (userInt > max) {
			return false;
		} 
		return true;
	}
	
	default double isValidDouble(String s) {
		return Double.parseDouble(s);
	}
	
	default boolean isInRange(double userDouble, double min, double max)
	{
		if (userDouble < min) {
			screen.displayln("Error! Number must be greater than "
							+ min);
			return false;
		} else if (userDouble > max) {
			screen.displayln("Error! Number must be less than "
					+ max);
			return false;
		} 
		return true;
	}
	
	default String isValidString(String s) {
		while (true) {
			if (s.length() > 0) {
				return s;
			} else {
				screen.displayln("Error! This entry is required. Try again.");
			}
		}
	}

	default String isValidString(String s, int len) {
		while (true) {
			if (s.length() == len) {
				return s;
			} else {
				screen.displayln("Error! This entry is required to be length "
								+ len + ". Try again.");
			}
		}
	}

	default String isValidString(String s, String option1, String option2) {
		while (true) {
			if (s.equalsIgnoreCase(option1) || s.equalsIgnoreCase(option2)) {
				return s;
			} else {
				screen.displayln("Error! Please enter " + option1 + " or " + option2 + ". Try again.");
			}
		}
	}


}
