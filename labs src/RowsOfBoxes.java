/**********************************************************
 * Assignment: RowOfBoxes
 *
 * Author: Jaadyyah Shearrion
 *
 * Description: prints out a row of boxes and it stops when there the box input is 0 
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from (Emmanuel) in designing and debugging
 * my program.
 **********************************************************/

import java.util.Scanner;

public class RowsOfBoxes
{

	public static void main(String[] args)
	{
		RowOfBoxes();
	}

	private static void RowOfBoxes()
	{
		Scanner console = new Scanner(System.in);
		
		System.out.println("How many boxes? ");
		int boxNumber = console.nextInt();
		
		while (boxNumber != 0)
		{	
			System.out.println("What size? ");
			int size = console.nextInt();
			
			for (int i = 0; i < boxNumber; i++)
			{
			System.out.print("0" + repeatedChar('=', size) + "0");
			}
			System.out.println();
			for (int j = 0; j < boxNumber; j++)
			{
				System.out.print("|" + repeatedChar(' ', size) + "|");
			}
			System.out.println();
			for (int a = 0; a < boxNumber; a++)
			{
				System.out.print("0" + repeatedChar('=', size) + "0");
			}
			System.out.println();
			
			System.out.println("How many boxes? ");
			boxNumber = console.nextInt();
		}
		System.out.println("All done!");
	}

	private static String repeatedChar(char c, int length)
	{
		String result = "";
		for (int i = 0; i < length; i++)
		{
			result = result + c;
		}
		return result;
	}
}
