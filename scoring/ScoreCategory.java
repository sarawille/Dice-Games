package scoring;

public enum ScoreCategory {
	ONES, TWOS, THREES, FOURS, FIVES, SIXES, 
	THREE_OF_A_KIND, FOUR_OF_A_KIND, FULL_HOUSE, SMALL_STRAIGHT, LARGE_STRAIGHT, CHANCE, YAHTZEE;
	
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
