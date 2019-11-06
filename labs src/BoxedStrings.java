import java.util.Scanner;

public class BoxedStrings
{
	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Enter a string (or \"quit\"): ");
		String input = console.nextLine();
		while (!input.equals("quit"))
		{
			for (int a = 0; a <= input.length() * 2; a++) // this is for how long the top line is going to be
			{
				System.out.print("-");
			}
			System.out.println(); // had to add some blank lines it looked really ugly otherwise
			System.out.print("|");
			for (int b = 0; b <= input.length() - 1; b++)
			{
				System.out.print(input.charAt(b) + "|");
			}
			System.out.println();
			for (int a = 0; a <= input.length() * 2; a++) // this is for how long the bottom line is going to be
			{
				System.out.print("-");
			}
			System.out.println();
			System.out.print("Enter a string (or \"quit\"): ");
			input = console.nextLine();
		}
		if (input.equals("quit"))
		{
			System.out.println("Thanks for using me!!!");
		}
	}

}
