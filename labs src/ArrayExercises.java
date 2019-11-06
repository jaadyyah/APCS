import java.util.Arrays;
import java.util.Scanner;

public class ArrayExercises
{
	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		System.out.print("Enter the first number: ");
		int start = console.nextInt();
		int finish = start;
		while (finish <= start)
		{
			System.out.print("Enter the last number (must be after first number): ");
			finish = console.nextInt();
		}

		int[] numbers = buildArray(start, finish);
		printArrayContents("Initial array:", numbers);
		printSumAndAverage(numbers);
		addOneToOddNumbers(numbers);
		printArrayContents("Array without odds:", numbers);
	}

	public static int[] buildArray(int start, int finish)
	{
		int lengthOfArray = finish - start;
		int[] nums = new int[lengthOfArray + 1];
		int counter = 0;
		for (int i = start; i < finish + 1; i++)
		{
			nums[counter] = i;
			counter++;
		}
		return nums;

	}

	public static void printArrayContents(String sentance, int[] numbers)
	{
		System.out.println(sentance);
		System.out.println(Arrays.toString(numbers));
	}

	public static int printSumAndAverage(int[] numbers)
	{
		int sum = 0;
		for (int i = 0; i < numbers.length; i++)
		{
			sum += numbers[i];
		}
		int result = sum / numbers.length;
		return result;
	}

	public static void addOneToOddNumbers(int[] numbers)
	{
		for (int i = 0; i < numbers.length; i++)
		{
			if (numbers[i] % 2 != 0)
			{
				numbers[i] += 1;
			}
		}
	}
}