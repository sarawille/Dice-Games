package scoring;

/**
 * @author Sara Wille
 * The ScoreCategory enumerators represent each of the available score categories for the game Yahtzee.
 */
public enum ScoreCategory {
	ONES, TWOS, THREES, FOURS, FIVES, SIXES, 
	THREE_OF_A_KIND, FOUR_OF_A_KIND, FULL_HOUSE, SMALL_STRAIGHT, LARGE_STRAIGHT, CHANCE, YAHTZEE;
	
	/**
	 * toString() - Overrides toString() so that enums are displayed 
	 *  as separate words (space vs. underscore) with the first letter of each word capitalized.
	 *  @return s
	 */
	@Override
	public String toString() 
	{
		String s = name().toLowerCase();
		if (s.contains("_"))
		{
			String[] categoryName = s.split("_");
			String capitalized = "";
			for (String word : categoryName)
			{
				capitalized	+= Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
			}
			s = capitalized;
		}
		else
		{
			s = Character.toUpperCase(s.charAt(0)) + s.substring(1);
		}
		return s;
	}
}
