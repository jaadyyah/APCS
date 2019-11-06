public class StringTools
{
	/**
	 * This method centers a String in a field of given width
	 * 
	 * @param s     - the String to be centered
	 * @param width - the length of the returned string
	 * @return the String s centered in a field of spaces width chars wide If the
	 *         length of s > width, then '>' is placed at the end of the returned
	 *         String
	 */
	public static String center(String s, int width)
	{
		int totalSpaces = width - s.length();
		int leftSpaces = totalSpaces / 2;
		int rightSpaces = totalSpaces - leftSpaces;
		return repeatedChar(' ', leftSpaces) + s + repeatedChar(' ', rightSpaces);
	}

	/**
	 * This method builds a String of repeated characters
	 * 
	 * @param ch      - the character to be repeated
	 * @param howMany - the number of times to repeat the character
	 * @return the String made by repeating the character ch howMany times
	 */
	public static String repeatedChar(char ch, int howMany)
	{
		String result = "";
		for (int i = 0; i < howMany; i++)
		{
			result = result + ch;
		}
		return result;
	}

	public static void main(String[] args)
	{
		for (char ch = 'A'; ch < 'A' + 8; ch++)
			System.out.println("|" + center(ch + "", 12) + "|");
		System.out.println("|" + center("Hello", 10) + "|");
		System.out.println("|" + center("Goodbye!", 15) + "|");
		System.out.println("|" + center("Oops, what about a long string?", 12) + "|");
	}

}