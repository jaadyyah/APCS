/**********************************************************
 * Assignment: POWERS
 *
 * Author: Jaadyyah Shearrion
 *
 * Description: DOES THE POWS USING RECURSION!  
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from (nate, mari) in designing and debugging my program.
 **********************************************************/
public class Powers 
{
	private static double powerUsingIteration(int base, int exp)
	{
		double result = 1;
		for (int rep = 0; rep < exp; rep++)
		{
			result *= base;
		}
		
		return result;
	}

	private static double powerUsingRecursion(int base, int exp)
	{
		double half;
		if (exp == 1)
		{
			return base;
		}
		else if (exp%2 == 0)
		{
			half = powerUsingRecursion(base, exp/2);
			return half * half;
		}
		else if (exp%2 == 1)
		{
			half = powerUsingRecursion(base, (exp - 1) / 2);
			double extra = powerUsingRecursion(base, 1);
			return half * half * extra; 
		}
		return 1.0;
	}
	
	// test using each power function so we can confirm we get the 
	// same result.
	public static void main(String[] args) 
	{
		for (int i = 10; i <= 100; i += 10)
		{
			System.out.println("2^" + i + " is " + powerUsingIteration(2, i) + " using iteration");
			System.out.println("2^" + i + " is " + powerUsingRecursion(2, i) + " using recursion");
			System.out.println();
		}
	}
}