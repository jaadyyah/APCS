
// Jaadyyah & EMMANUEL
import java.util.Scanner;

//A program that asks the user to think of a number, then tries
//to guess what it was.
public class GuessYourNumber
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int[] numbersToGuess = initializeNumbers(10);

		System.out.println("Think of a number between 1 and 10 and I'll try to guess it.");

		int indexOfGuess = (int) (Math.random() * 11);

		System.out.print("Was it " + numbersToGuess[indexOfGuess] + "? ");
		String answer = input.nextLine();

		if (answer.equals("yes"))
		{
			System.out.println("Woohoo!");
		} else
		{
			while (!answer.equals("yes"))
			{				
				numbersToGuess = removeNumberFromList(numbersToGuess, indexOfGuess);
				if (numbersToGuess.length == 0)
				{
					System.out.println("What?!? That was all the numbers!");
					return;
				}

				indexOfGuess = (int) (Math.random() * numbersToGuess.length);
				System.out.print("Okay, then was it " + numbersToGuess[indexOfGuess] + "? ");
				answer = input.nextLine();

				if (answer.equals("yes"))
				{
					System.out.println("Woohoo!");
				}
			}
		}
	}

	public static int[] initializeNumbers(int howMany)
	{
		int[] numbers = new int[10];
		for (int i = 0; i < howMany; i++)
		{
			numbers[i] = i + 1;
		}
		return numbers;
	}

	public static int[] removeNumberFromList(int[] list, int index)
 {
     int[] newList = new int[list.length - 1];
     for (int i = 0; i < index; i++)
     {
         newList[i] = list[i];
     }
     
     for (int j = index; j < newList.length; j++)
     {
         newList[j] =  list[j]+1 ;
     }
	 return newList;
 }
}