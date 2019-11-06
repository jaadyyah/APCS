package fracCalc2;

import java.util.Scanner;

public class FractionalCalculator
{

	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		welcomeMessage();
		enteringExpressionAndPrintingTheParts(console);
		goodbye();

	}

	public static String convertToFraction(String input)
	{
		String output = "";
		// whole number part of this
		if (input.indexOf('/') < 0)
		{
			output = input + "/1";
		}

		// mixed number the denominator and multiply it by the whole number then add the
		// numerator
		// need to slice it up with substrings then turn it into an int then back to a
		// string
		if (input.indexOf('_') > -1)
		{
			int wholeNum = Integer.parseInt(input.substring(0, input.indexOf('_')));
			int newNumerator = Integer.parseInt(input.substring(input.indexOf('_') + 1, input.indexOf('/')));
			int newDenominator = Integer.parseInt(input.substring(input.indexOf('/') + 1, input.length()));

			int result = wholeNum * newDenominator + newNumerator;

			if (wholeNum < 0)
			{
				result = wholeNum * newDenominator - newNumerator;
			}
			output = result + "/" + newDenominator + "";
		}

		// for a regular fraction
		if (input.indexOf('/') > -1 && input.indexOf('_') == -1)
		{
			output = input;
		}
		return output;
	}

	private static void goodbye()
	{
		System.out.println("Goodbye!");
	}

	private static void enteringExpressionAndPrintingTheParts(Scanner console)
	{
		System.out.println();
		System.out.print("Enter an expression (or \"quit\"): ");
		String input = console.nextLine();
		while (!input.equals("quit"))
		{
			String leftOperand = input.substring(0, input.indexOf(" "));
			String operator = input.substring(input.indexOf(" ") + 1, input.indexOf(" ") + 2);
			String rightOperand = input.substring(input.indexOf(" ") + 3);

			System.out.println("Left operand: " + convertToFraction(leftOperand));
			System.out.println("Operator: " + operator);
			System.out.println("Right operand: " + convertToFraction(rightOperand));
			System.out.print("Enter an expression (or \"quit\"): ");
			input = console.nextLine();
		}
	}

	private static void welcomeMessage()
	{
		System.out.print("Welcome to the Fraction Calculator!");
	}

}
