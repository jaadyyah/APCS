/**********************************************************
 * Assignment: Spread
 *
 * Author: Jaadyyah Shearrion
 *
 * Description: print spread
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from (nate helped me a lot during this whole project) in designing and debugging
 * my program.
 **********************************************************/
package textExcel5;

import java.util.ArrayList;

/* Spreadsheet stores a 2d array of Cell objects and is able to 
 * modify the array and display it by printing to System.out.
 */
public class Spreadsheet
{
	private final static int COLS = 7;
	private final static int ROWS = 10;
	private final static int CELL_WIDTH = 12;

	// store the cells in a 2D array
	private Cell[][] data;

	// construct a new spreadsheet. each cell in 'data' will be
	// null initially, representing an empty cell.
	public Spreadsheet()
	{
		data = new Cell[ROWS][COLS];
	}

	// print the spreadsheet to system.out
	public void print()
	{
		printHorizontalLine();
		printColumnHeaders();
		printHorizontalLine();

		for (int r = 0; r < ROWS; r++)
		{
			printRow(r);
			printHorizontalLine();
		}
	}

	// check to see if 'ref' is a valid cell reference, like A3 or G10. if
	// ref can't be parsed as a column and row, or if it is not in the
	// appropriate range for this spreadsheet, return false.
	public boolean isCellReference(String ref)
	{
		if (ref == null || ref.length() < 2 || ref.length() > 3)
			return false;

		if (ref.charAt(0) < 'A' || ref.charAt(0) > 'A' + COLS)
			return false;

		int row = Integer.parseInt(ref.substring(1));
		if (row < 1 || row > ROWS)
			return false;

		return true;
	}

	// trying to find a cell reference
	// its calling to when the tokens were already made
	public ArrayList<String> replacingCellReference(ArrayList<String> tokens)
	{
		for (int i = 0; i < tokens.size(); i++)
		{
			if (isCellReference(tokens.get(i)))
			{
				Cell c = data[getRow(tokens.get(i))][getCol(tokens.get(i))];
				tokens.set(i, c.getDisplayValue());
			}
		}
		return tokens;
	}

	public String gettingNumValueOfCell(String ref)
	{
		Cell c = data[getRow(ref)][getCol(ref)];
		return c.getDisplayValue();
	}

	// display the value of a single cell, represented by ref, by printing
	// it to system.out.
	public void displayCell(String ref)
	{
		Cell c = data[getRow(ref)][getCol(ref)];
		String value = (c == null) ? "<empty>" : c.getOriginalValue(); // "ternary operator" - bing it :)

		System.out.println(ref + " = " + value);
	}

	// store a cell at the specified location in the grid, replacing whatever
	// might be there already.
	public void setCell(String ref, Cell cell)
	{
		data[getRow(ref)][getCol(ref)] = cell;
	}

	// given a string that is supposed to be a reference to a cell, parse the
	// row index from it (i.e. F4 will return 3 because 3 is the index of the
	// 4th row in 'data').
	private int getRow(String ref)
	{
		if (!isCellReference(ref))
			throw new IllegalArgumentException(ref + " is not a valid cell reference");

		return Integer.parseInt(ref.substring(1)) - 1;
	}

	// given a string that is supposed to be a reference to a column, parse
	// the column index from it (e.g. C7 will return 2, since C is the 3rd column
	// and its zero-based index in data would therefore be 2).
	private int getCol(String ref)
	{
		if (!isCellReference(ref))
			new IllegalArgumentException(ref + " is not a valid cell reference");

		return ref.charAt(0) - 'A';
	}

	// print one line of +------------+--- etc.
	private void printHorizontalLine()
	{
		for (int col = 0; col < COLS + 1; col++)
		{
			System.out.print("+");
			for (int ch = 0; ch < CELL_WIDTH; ch++)
				System.out.print("-");
		}
		System.out.println("+");
	}

	// print the column header row
	private void printColumnHeaders()
	{
		System.out.print("|" + center("", CELL_WIDTH)); // blank cell at top left

		for (int col = 0; col < COLS; col++)
		{
			System.out.print("|");
			System.out.print(center((char) (col + 'A') + "", CELL_WIDTH));
		}
		System.out.println("|");
	}

	// print the specified row of cells, including their left and right borders
	private void printRow(int row)
	{
		System.out.print("|" + center(row + 1 + "", CELL_WIDTH)); // the header column

		for (int col = 0; col < COLS; col++)
		{
			String value = (data[row][col] == null) ? "" : data[row][col].getDisplayValue();
			System.out.print("|" + center(value, CELL_WIDTH));
		}

		System.out.println("|");
	}

	// given a string 'text', truncate or pad it to make it fit exactly in
	// 'width' characters
	private String center(String text, int width)
	{
		if (text.length() > width)
			return text.substring(0, width - 1) + ">";

		String centered = "";
		int leftSpaces = (width - text.length()) / 2;
		for (int c = 0; c < leftSpaces; c++)
			centered += " ";
		centered += text;
		for (int c = centered.length(); c < width; c++)
			centered += " ";
		return centered;
	}

	public void clear()
	{
		// somehow go through the entire spreadsheet to clear everything in the sheet
		for (int i = 0; i < ROWS; i++)
		{
			for (int k = 0; k < COLS; k++)
			{
				data[i][k] = null;
			}
		}

	}

	public void clear(String ref)
	{
		int col = getCol(ref);
		int row = getRow(ref);
		data[col][row] = null;
	}

	// have it going down in numerical value
	public void sortDescending(String command)
	{
		String firstRef = command.substring(6, command.indexOf(':'));
		String secondRef = command.substring(command.indexOf(':') + 1, command.length());
		int firstRow = getRow(firstRef);
		int lastRow = getRow(secondRef);
		int rows = lastRow - firstRow + 1;

		int firstCol = getCol(firstRef);
		int lastCol = getCol(secondRef);
		int cols = lastCol - firstCol + 1;

		int counter = 0;
		Cell[] cells = new Cell[rows * cols];

		for (int i = firstRow; i <= lastRow; i++)
		{
			for (int k = firstCol; k <= lastCol; k++)
			{
				cells[counter] = data[i][k];
				counter++;
			}
		}
		// Actually sorting
		selectionSortD(cells);
		// makes it back into an array
		counter = 0;
		for (int i = firstRow; i <= lastRow; i++)
		{
			for (int k = firstCol; k <= lastCol; k++)
			{
				data[i][k] = cells[counter];
				counter++;
			}
		}

	}
	
	// big to small
	private void selectionSortD(Cell[] nums)
	{
		for (int i = 0; i < nums.length - 1; i++)
		{
			Cell temp;
			int max = i;
			for (int k = i; k < nums.length; k++)
			{
				if(Double.parseDouble(nums[k].getDisplayValue()) > Double.parseDouble(nums[max].getDisplayValue()))
					{
						max = k;
					}
			}
			temp = nums[i];
			nums[i] = nums[max];
			nums[max] = temp;
		}
	}

	// going up in numerical value
	public void sortAscending(String command)
	{
		String firstRef = command.substring(6, command.indexOf(':'));
		String secondRef = command.substring(command.indexOf(':') + 1, command.length());
		int firstRow = getRow(firstRef);
		int lastRow = getRow(secondRef);
		int rows = lastRow - firstRow + 1;

		int firstCol = getCol(firstRef);
		int lastCol = getCol(secondRef);
		int cols = lastCol - firstCol + 1;

		int counter = 0;
		Cell[] cells = new Cell[rows * cols];

		for (int i = firstRow; i <= lastRow; i++)
		{
			for (int k = firstCol; k <= lastCol; k++)
			{
				cells[counter] = data[i][k];
				counter++;
			}
		}
		// Actually sorting
		selectionSortA(cells);
		// makes it back into an array
		counter = 0;
		for (int i = firstRow; i <= lastRow; i++)
		{
			for (int k = firstCol; k <= lastCol; k++)
			{
				data[i][k] = cells[counter];
				counter++;
			}
		}
	}
	
	// small to big
	private void selectionSortA(Cell[] nums)
	{
		for (int i = 0; i < nums.length - 1; i++)
		{
			Cell temp;
			int max = i;
			for (int k = i; k < nums.length; k++)
			{
				if(Double.parseDouble(nums[k].getDisplayValue()) < Double.parseDouble(nums[max].getDisplayValue()))
					{
						max = k;
					}
			}
			temp = nums[i];
			nums[i] = nums[max];
			nums[max] = temp;
		}
	}
}
