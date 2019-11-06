import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**********************************************************
 * Assignment: What is it?
 *
 * Author: Jaadyyah Shearrion
 *
 * Description: takes an input and tells of its a string a number or a date
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from (my table) in designing and debugging
 * my program.
 **********************************************************/

public class WhatIsIt 
{
    private static void printWhatThisIs(String text)
    {
        if (text.indexOf('"')!= -1)
        {
            System.out.println("It's a string!");
            return;
        }
        try
        {
            double test = Double.parseDouble(text);
            System.out.println("It's a number!");
            return;
        }
        catch (Exception ex)
        {
          
        }

        try
        {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            Date test = format.parse(text);
            System.out.println("It's a date!");
            return;
        }
        catch (Exception ex)
        {
        
        }
        
        System.out.println("I don't know what that is.");
    }

    public static void main(String[] args) 
    {
        Scanner console = new Scanner(System.in);
        
        System.out.print("Type something: ");
        String input = console.nextLine();
        
        printWhatThisIs(input);
    }
}