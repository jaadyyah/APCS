
public class ForLoopPractice
{

	public static void main(String[] args)
	{
		fibonacci_series();
		Triangle(4);

	}

	private static void Triangle(int size)
	{
		System.out.print(" \n ");
		System.out.print("Triangle: ");
		System.out.print(" \n ");
		for (int line = 1; line <= size; line++)
		{
			System.out.println();
			String stars = "*"; 
			for(int i = 0; i < size * 2 - 1; i++)
			{
				for(int j = 1; j <= size; j++)
				{
					System.out.print(stars);
				}
			}
		}
	}

	private static void fibonacci_series()
	{
		System.out.print("Fibonacci series: ");
		System.out.println(" \n ");
		int firstnumber = 1;
		int secondnumber = 2;
		System.out.print(firstnumber + " " + firstnumber + " " + secondnumber);
		
		for (int i = 2; i < 11; i++)
		{
			int thirdnumber = firstnumber + secondnumber;
			System.out.print(" " + thirdnumber);
			firstnumber = secondnumber;
			secondnumber = thirdnumber;
			
			
		}
	}

}
