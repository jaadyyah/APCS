/**********************************************************
 * Assignment: Curving Grades
 *
 * Author: Jaadyyah Shearrion 
 *
 * Description: curves grades 
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from (emnanuel) in designing and debugging
 * my program.
 **********************************************************/
import java.util.Scanner;

public class CurvingGrades
{

	public static void main(String[] args)
	{
		curving();
	}

	private static void curving()
	{
		Scanner console = new Scanner(System.in);
		System.out.print("How many grades will you enter? ");

		int input = console.nextInt();
		int max = Integer.MIN_VALUE;
		int[] listOfGrades = new int[input];

		for (int i = 0; i < input; i++) // the thing that stores the user inputs in the list
		{
			System.out.print("Enter grade " + (i + 1) + ": ");
			listOfGrades[i] = console.nextInt();
		}

		for (int i = 0; i < input; i++) // for maximum value
		{
			if (listOfGrades[i] > max)
			{
				max = listOfGrades[i];
			}
		}

		int curvedValue = 100 - max; // the number away from 100 the max is
		for (int i = 0; i < input; i++)
		{
			// the old grades with the curved value added to them
			int curvedGrade = listOfGrades[i] + curvedValue;
			System.out.println("Orginal: " + listOfGrades[i] + " With curve: " + curvedGrade);
		}

	}

}
