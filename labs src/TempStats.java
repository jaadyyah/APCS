import java.util.Scanner;

public class TempStats
{

	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		System.out.print("How many tempuratutres will you enter? ");
		int input = console.nextInt();
		int max = Integer.MIN_VALUE;
		int min = 9999999;
		int total = 0;
		int counter = 1;
		for (int i = 1; i <= input; i++)
		{
			System.out.println("Enter a temperature #" + counter + ": ");
			int temp = console.nextInt();
			total = temp + total;
			counter = counter + 1;
			if (temp > max)
			{
				max = temp;
			}
			if (temp < min)
			{
				min = temp;
			}
		}
		int average = total / input;
		System.out.println("The highest temperature was: " + max);
		System.out.println("The lowest temperture was: " + min);
		System.out.println("The average temperatrue was: " + average);
	}

}
