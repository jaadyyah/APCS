/**********************************************************
 * Assignment: String reversal
 *
 * Author: Jaadyyah Shearrion
 *
 * Description: make string go backwards
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from (mari, 
 * I also used this site 
 * https://www.tutorialspoint.com/Java-program-to-reverse-a-string-using-recursion) 
 * in designing and debugging my program.
 **********************************************************/
public class ReverseString
{
    public static void main(String[] args)
    {
        String s = "Opportunity Diversity Respect";

        System.out.println(s);

        s = reverse(s);
        
        System.out.println(s);
    }

    //I understand how this works 
    // I slowly am getting how recursion works 
	private static String reverse(String s)
	{
		// Can probably change what's inside the if statement
		// might still work
		if (s.isEmpty())
		{
			return s;
		}
		else
		{
			return reverse(s.substring(1)) + s.charAt(0);
		}
	}
}