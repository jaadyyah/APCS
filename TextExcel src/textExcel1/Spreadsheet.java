
/**********************************************************
 * Assignment: TextExcel checkpoint 1
 *
 * Author: Jaadyyah Shearrion
 *
 * Description: should print a spreadsheet and add some stuff on it 
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from NATE SMALL in designing and debugging
 * my program.
 **********************************************************/
package textExcel1;

public class Spreadsheet
{
	private final static int ROWS = 10;
	private final static int COLS = 7;

	private final static int CELL_WIDTH = 12;

	// the 2D array of cells
	private Cell[][] data;

	// constructor
	public Spreadsheet()
	{
		data = new Cell[ROWS][COLS];
	}

	public void print()
	{
		header();
		for (int i = 0; i < ROWS; i++)
		{
			printRow(i);
		}
	}

	private void header()
	{
		dashesAndPluses();
		System.out.print("|");
		System.out.print(repeatedChar(' ', CELL_WIDTH));
		for (char i = 'A'; i < 'A' + COLS; i++)
		{
			System.out.print("|");
			System.out.print(repeatedChar(' ', (CELL_WIDTH - (i + "").length()) / 2));
			System.out.print(i);
			System.out.print(repeatedChar(' ', (CELL_WIDTH - (i + "").length() + 1) / 2));
		}
		System.out.print("|");
		System.out.println();
		dashesAndPluses();

	}

	private void printRow(int row)
	{
		System.out.print("|");
		System.out.print(repeatedChar(' ', (CELL_WIDTH - (row + 1 + "").length()) / 2));
		System.out.print(row + 1);
		System.out.print(repeatedChar(' ', (CELL_WIDTH - (row + 1 + "").length() + 1) / 2));
		System.out.print("|");

		for (int i = 0; i < COLS; i++)
		{
			printCell(row, i);
		}
		System.out.println();
		dashesAndPluses();
	}

	private void dashesAndPluses()
	{
		System.out.print("+");
		for (int i = 0; i < COLS + 1; i++)
		{
			System.out.print(repeatedChar('-', CELL_WIDTH) + "+");
		}
		System.out.println();
	}

	private void printCell(int row, int col)
	{
		if (data[row][col] == null)
		{
			System.out.print(repeatedChar(' ', CELL_WIDTH) + "|");
		} else
		{
			String value = data[row][col].getValue();
			System.out.print(repeatedChar(' ', (CELL_WIDTH - value.length()) / 2));
			System.out.print(value);
			System.out.print(repeatedChar(' ', (CELL_WIDTH - value.length() + 1) / 2) + "|");
		}
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

	public static void main(String[] args)
	{
		Spreadsheet sheet = new Spreadsheet();
		sheet.data[0][0] = new Cell("hi");
		sheet.data[3][6] = new Cell("text");
		sheet.data[7][4] = new Cell("excel");
		sheet.print();
	}

}