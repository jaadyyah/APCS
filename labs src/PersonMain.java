
/**********************************************************
 * Assignment: Person Version 1 
 *
 * Author: Jaadyyah Shearrion 
 *
 * Description: stores inputs into a class then it prints them out
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from (no one) in designing and debugging
 * my program.
 **********************************************************/

import java.util.Scanner;

public class PersonMain
{

	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);

		System.out.print("Enter the person's name: ");
		String name = console.nextLine();

		System.out.print("Enter the person's age: ");
		int age = console.nextInt();

		Person human = new Person(name, age);
		System.out.println(human);

		System.out.println(
				"There are " + human.difference() + " years until " + human.getName() + " is eligible for Medicare.");

	}

}
