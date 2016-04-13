package ui;

/**
 * @author Sara Wille
 * The Validatable interface confirms whether user input
 * is a valid int, double or String.  It can also check whether
 * the int or double is within a certain range, and whether
 * the String is a given length.
 *
 */
public interface Validatable {
	
	default int isValidInt(String s) {
		return Integer.parseInt(s);
	}
	
	default boolean isInRange(int userInt, int min, int max)
	{
		if (userInt < min) 
		{
			return false;
		} 
		else if (userInt > max) 
		{
			return false;
		} 
		return true;
	}
	
	default double isValidDouble(String s) {
		return Double.parseDouble(s); 
	}
	
	default boolean isInRange(double userDouble, double min, double max)
	{
		if (userDouble < min)
		{
			return false;
		} 
		else if (userDouble > max) 
		{
			return false;
		} 
		return true;
	}
	
	default boolean isValidString(String s) {
		if (s.length() > 0) 
		{
			return true;
		} 
		else
		{
			return false;
		}
	}

	default boolean isValidString(String s, int len) {
		if (s.length() == len) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
		
	}

	default boolean isValidString(String s, String option1, String option2) {
		if (s.equalsIgnoreCase(option1) || s.equalsIgnoreCase(option2)) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}


}
