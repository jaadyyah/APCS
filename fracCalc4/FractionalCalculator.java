
/**********************************************************
 * Assignment: FracCalc Checkpoint 4
 *
 * Author: Jaadyyah Shearrion 
 *
 * Description: Adds, multiplies, subtracts, and divides anything and simplifies it
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from (Emmanuel, Mari) in designing and debugging
 * my program.
 **********************************************************/
package fracCalc4;

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

	public static String reduce(String fraction)
	{
		int numerator = Integer.parseInt(fraction.substring(0, fraction.indexOf('/')));
		int denominator = Integer.parseInt(fraction.substring(fraction.indexOf('/') + 1, fraction.length()));

		String result = "";
		int simplifier = gcf(numerator, denominator);
		result = (numerator / simplifier) + "/" + (denominator / simplifier);

		return result;
	}

	public static int gcf(int numerator, int denominator)
	{
		numerator = Math.abs(numerator);
		denominator = Math.abs(denominator);
		int greatestSoFar = 1;

		for (int i = 1; i <= numerator; i++)
		{
			if (numerator % i == 0 && denominator % i == 0)
			{
				greatestSoFar = (i);
			}
		}
		return greatestSoFar;
	}

	public static String convertToMixed(String fraction)
	{
		int numerator = Integer.parseInt(fraction.substring(0, fraction.indexOf('/')));
		int denominator = Integer.parseInt(fraction.substring(fraction.indexOf('/') + 1, fraction.length()));
		int newNumerator = 0;
		int wholeNumber = 0;

		String mixedNumber = "";
		// whole number
		if (Math.abs(numerator) % denominator == 0 || numerator == 0)
		{
			mixedNumber = numerator + "";
		}

		// improper Fraction
		if (Math.abs(numerator) > denominator && numerator % denominator != 0)
		{
			wholeNumber = numerator / denominator; // this works properly
			newNumerator = numerator - (wholeNumber * denominator);
			mixedNumber = wholeNumber + "_" + Math.abs(newNumerator) + "/" + denominator;
		}

		// regular fraction
		if (Math.abs(numerator) < denominator)
		{
			mixedNumber = numerator + "/" + denominator;
		}

		if (numerator == 0)
		{
			return "0";
		}
		return mixedNumber;
	}

	public static String calculate(String leftOperand, String operator, String rightOperand)
	{
		int leftNumerator = Integer.parseInt(leftOperand.substring(0, leftOperand.indexOf('/')));
		int leftDenominator = Integer
				.parseInt(leftOperand.substring(leftOperand.indexOf('/') + 1, leftOperand.length()));
		int rightNumerator = Integer.parseInt(rightOperand.substring(0, rightOperand.indexOf('/')));
		int rightDenominator = Integer
				.parseInt(rightOperand.substring(rightOperand.indexOf('/') + 1, rightOperand.length()));

		String result = "";
		// adding first
		if (operator.equals("+"))
		{
			int newNumerator = (leftNumerator * rightDenominator) + (rightNumerator * leftDenominator);
			int newDenominator = leftDenominator * rightDenominator;

			result = newNumerator + "/" + newDenominator + "";
		}

		// subtraction
		if (operator.equals("-"))
		{
			int newNumerator = (leftNumerator * rightDenominator) - (rightNumerator * leftDenominator);
			int newDenominator = leftDenominator * rightDenominator;

			result = newNumerator + "/" + newDenominator + "";
		}

		// multiplication
		if (operator.equals("*"))
		{
			int newNumerator = leftNumerator * rightNumerator;
			int newDenominator = leftDenominator * rightDenominator;

			result = newNumerator + "/" + newDenominator + "";
		}

		// division
		if (operator.equals("/"))
		{
			int newNumerator = leftNumerator * rightDenominator;
			int newDenominator = rightNumerator * leftDenominator;

			result = newNumerator + "/" + newDenominator;
		}

		return result;
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
			String leftOperand = convertToFraction(input.substring(0, input.indexOf(" ")));
			String operator = input.substring(input.indexOf(" ") + 1, input.indexOf(" ") + 2);
			String rightOperand = convertToFraction(input.substring(input.indexOf(" ") + 3));
			System.out.println(convertToMixed(reduce(calculate(leftOperand, operator, rightOperand))));
			System.out.print("Enter an expression (or \"quit\"): ");
			input = console.nextLine();
		}
	}

	private static void welcomeMessage()
	{
		System.out.print("Welcome to the Fraction Calculator!");
	}

}
