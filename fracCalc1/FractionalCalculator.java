package fracCalc1;

import java.util.Scanner;

public class FractionalCalculator
{

	public static void main(String[] args)
	{
		welcomeMessage();
		enteringExpressionAndPrintingTheParts();
		goodbye();
		

	}

	private static void goodbye()
	{
		System.out.println("Goodbye!");
	}

	private static void enteringExpressionAndPrintingTheParts()
	{
		Scanner console = new Scanner(System.in);
		System.out.println();
		System.out.print("Enter an expression (or \"quit\"): ");
		String input = console.nextLine(); 
		System.out.println("Left operand: " + input.substring(0, input.indexOf(" ")));
		System.out.println("Operator: " + input.substring(input.indexOf(" ") + 1, input.indexOf(" ") + 2));
		System.out.println("Right operand: " + input.substring(input.indexOf(" ") + 3));
		
	}

	private static void welcomeMessage()
	{
		System.out.print("Welcome to the Fraction Calculator!");
	}

}
