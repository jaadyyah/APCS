package textExcel4;
/**********************************************************
 * Assignment: FORM CELL
 *
 * Author: Jaadyyah Shearrion
 *
 * Description: FORMULA
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from (nate) in designing and debugging my program.
 **********************************************************/

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;

public class FormulaCell extends Cell
{
	private Spreadsheet sheet;

	public FormulaCell(String value, Spreadsheet s)
	{
		super(value);
		sheet = s;

		if (!value.startsWith("(") || !value.endsWith(")"))
			throw new IllegalArgumentException(
					"Number values need to start and end with parenthesis. '" + value + "' did not.");
	}

	// somehow turn cell references into into number values
	// don't change much

	public static double simplify(String expression, Spreadsheet sheet)
	{
		ArrayList<String> tokens = convertToList(expression);
		tokens = sheet.replacingCellReference(tokens);
		replacingSumAndAverage(tokens, sheet);
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

	public static void replacingSumAndAverage(ArrayList<String> tokens, Spreadsheet sheet)
	{
		for (int i = 0; i < tokens.size(); i++)
		{
			if (tokens.get(i).equals("sum"))
			{
				tokens.set(i + 1, findSum(tokens.get(i + 1), tokens, sheet) + "");
				tokens.remove(i);
			}
			else if (tokens.get(i).equals("avg"))
			{
				tokens.set(i + 1, findAverage(tokens.get(i + 1), tokens, sheet));
				tokens.remove(i);
			}
		}
	}

	private static String findAverage(String cells, ArrayList<String> tokens, Spreadsheet sheet)
	{
		int counter = 0;
		double total = 0;
		int firstCol = (int) (cells.charAt(0)) - 65;
		int lastCol = (int) (cells.charAt(cells.indexOf(':') + 1)) - 65;

		int firstRow = Integer.parseInt(cells.substring(1, cells.indexOf(':')));
		int lastRow = Integer.parseInt(cells.substring(cells.indexOf(':') + 2));

		for (int i = firstCol; i <= lastCol; i++)
		{
			for (int j = firstRow; j <= lastRow; j++)
			{
				String ref = (char) (i + 65) + "" + j;
				total += simplify(sheet.gettingNumValueOfCell(ref), sheet);
				counter++;
			}
		}
		return total / counter + "";
	}

	private static String findSum(String cells, ArrayList<String> tokens, Spreadsheet sheet)
	{
		int total = 0;

		int firstCol = (int) (cells.charAt(0)) - 65;
		int lastCol = (int) (cells.charAt(cells.indexOf(':') + 1)) - 65;

		int firstRow = Integer.parseInt(cells.substring(1, cells.indexOf(':')));
		int lastRow = Integer.parseInt(cells.substring(cells.indexOf(':') + 2));

		for (int i = firstCol; i <= lastCol; i++)
		{
			for (int j = firstRow; j <= lastRow; j++)
			{
				String ref = (char) (i + 65) + "" + j;
				total += simplify(sheet.gettingNumValueOfCell(ref), sheet);
			}
		}

		return total + "";
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
		} else if (op.equals("/"))
		{
			return leftNum / rightNum + "";
		} else if (op.equals("+"))
		{
			return leftNum + rightNum + "";
		} else if (op.equals("-"))
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

	@Override
	public String getDisplayValue()
	{
		String result = getOriginalValue().substring(1, getOriginalValue().length() - 1);
		return simplify(result, sheet) + "";
	}

}
