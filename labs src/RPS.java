
/**********************************************************
 * Assignment: Rock Paper Scissors
 *
 * Author: Jaadyyah Shearrion 
 *
 * Description: the computer and a user is playing rock paper scissors together how cute
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from (my tablemates all helped me at one point or another, one of the TEALS people, and Sakib) in designing and debugging
 * my program.
 **********************************************************/

import java.util.Scanner;

public class RPS
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Rock, Paper, or Scissors: ");
		String playerChoice = input.nextLine();
		String computerChoice = computer();

		whoWon(playerChoice, computerChoice);

		System.out.println("You chose " + playerChoice);
		System.out.println("The computer chose " + computerChoice);
	}

	private static void whoWon(String playerChoice, String computerChoice)
	{

		if (playerChoice.equals("rock"))
		{
			if (computerChoice.equals("rock"))
			{
				System.out.println("It was a tie.");
			} else
			{
				if (computerChoice.equals("paper"))
				{
					System.out.println("The computer wins!");
				} else
				{
					System.out.println("You win!");
				}
				if (computerChoice.equals("scissors"))
				{
					System.out.println("The computer loses!");
				} else
				{
					System.out.println("You win!");
				}
			}

		}

		if (playerChoice.equals("paper"))
		{
			if (computerChoice.equals("paper"))
			{
				System.out.println("It was a tie.");
			} else
			{
				if (computerChoice.equals("scissors"))
				{
					System.out.println("The computer wins!");
				} else
				{
					System.out.println("You win!");
				}

				if (computerChoice.equals("rock"))
				{
					System.out.println("The computer loses!");
				} else
				{
					System.out.println("You win!");
				}
			}
		}

		if (playerChoice.equals("scissors"))
		{
			if (computerChoice.equals("scissors"))
			{
				System.out.println("It was a tie.");
			} else
			{
				if (computerChoice.equals("rock"))
				{
					System.out.println("The computer wins!");
				} else
				{
					System.out.println("You win!");
				}
				if (computerChoice.equals("paper"))
				{
					System.out.println("The computer loses!");
				} else
				{
					System.out.println("You win!");
				}
			}

		}
	}

	private static String computer()
	{
		String computerChoice = null;
		int randomNumber = (int) (Math.random() * 3 + 1);

		if (randomNumber == 1)
		{
			computerChoice = "rock";
		}
		if (randomNumber == 2)
		{
			computerChoice = "paper";
		}
		if (randomNumber == 3)
		{
			computerChoice = "scissors";
		}
		return computerChoice;
	}
}