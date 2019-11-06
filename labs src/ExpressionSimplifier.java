
/**********************************************************
 * Assignment: Expression simplifier
 *
 * Author: Jaadyyah Shearrion
 *
 * Description: simplifies expressions
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from (nate) in designing and debugging
 * my program.
 **********************************************************/
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;

public class ExpressionSimplifier
{
	public static double simplify(String expression)
	{
		ArrayList<String> tokens = convertToList(expression);
		while (tokens.size() > 1)
		{
			int operatorIndex = findIndexOfNextOperator(tokens);

			String leftOperand = tokens.get(operatorIndex - 1);
			String operator = tokens.get(operatorIndex);
			String rightOperand = tokens.get(operatorIndex + 1);
			String result = calculate(leftOperand, operator, rightOperand);

			replaceInList(tokens, operatorIndex - 1, 3, result);
		}
		return Double.parseDouble(tokens.get(0));
	}

	private static ArrayList<String> convertToList(String str)
	{
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(str.split(" ")));
		return list;
	}

	private static int findIndexOfNextOperator(ArrayList<String> tokens)
	{
		for (int i = 0; i < tokens.size(); i++)
		{
			if (tokens.get(i).equals("*"))
			{
				return i;
			}
			if (tokens.get(i).equals("/"))
			{
				return i;
			}
		}
		for (int i = 0; i < tokens.size(); i++)
		{
			if (tokens.get(i).equals("+"))
			{
				return i;
			}
			if (tokens.get(i).equals("-"))
			{
				return i;
			}
		}
		throw new InvalidParameterException("No operator found in token list");
	}

	private static String calculate(String left, String op, String right)
	{
		double leftNum = Double.parseDouble(left);
		double rightNum = Double.parseDouble(right);
		
		if (op.equals("*"))
		{
			return leftNum * rightNum + "";
		}
		else if (op.equals("/"))
		{
			return leftNum / rightNum + "";
		}
		else if (op.equals("+"))
		{
			return leftNum + rightNum + "";
		}
		else if (op.equals("-"))
		{
			return leftNum - rightNum + "";
		}
		throw new InvalidParameterException("'" + op + "' is not a valid operator");
	}

	private static void replaceInList(ArrayList<String> items, int firstIndex, int howManyItems, String newValue)
	{
		for (int i = 0; i < howManyItems; i++)
		{
			items.remove(firstIndex);
		}
		items.add(firstIndex, newValue);
	}

	public static void main(String[] args)
	{
		System.out.println("1 == " + simplify("1"));
		System.out.println("3 + 5 == " + simplify("3 + 5"));
		System.out.println("4 - 7 == " + simplify("4 - 7"));
		System.out.println("5 * 4 + 3 * 2 == " + simplify("5 * 4 + 3 * 2"));
		System.out.println("10 - 9 / 3 == " + simplify("10 - 9 / 3"));
	}
}