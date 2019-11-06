import java.util.Scanner;

public class ReduceToLowestTerms
{

	public static void main(String[] args)
	{
		// the intial stuff that gets printed
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a numerator: ");
		int numerator = input.nextInt();
		System.out.print("Enter a denominator: ");
		int denominator = input.nextInt();

		// simple styling so things look neater for me
		System.out.println(" \n ");
		int reducedFraction = gcf(numerator, denominator);
		int new_numerator = numerator / reducedFraction; 
		int new_denominator = denominator / reducedFraction; 

		// NTS WEEK 4 SLIDES 60 AND 61
		System.out.println(numerator + "/" + denominator + " is reduced to " + new_numerator + "/" + new_denominator);

	}

	public static int gcf(int numerator, int denominator)
	{
		int greatestSoFar = 0;

		for (int i = 1; i <= numerator; i++)
		{
			if (numerator % i == 0 && denominator % i == 0)
			{
				greatestSoFar = (i);
			}
		}
		return greatestSoFar; 
	}
}
