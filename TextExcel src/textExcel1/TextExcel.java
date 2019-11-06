package textExcel1;

import java.util.Scanner;

public class TextExcel
{

	public static void main(String[] args)
	{
		Spreadsheet sheet = new Spreadsheet();
		System.out.println("Welcome to TextExcel!");
		Scanner console = new Scanner(System.in);

		String command = getCommand(console);
		while (!command.equals("quit"))
		{
			commandFunctions(command, sheet);
			command = getCommand(console);
		}

		System.out.println("Farewell!");
		console.close();
	}

	private static String getCommand(Scanner console)
	{
		System.out.println("Enter a command: ");
		String input = console.nextLine();
		return input;
	}

	public static void commandFunctions(String command, Spreadsheet sheet)
	{
		if (command.equals("print"))
		{
			sheet.print();
		}
	}

}