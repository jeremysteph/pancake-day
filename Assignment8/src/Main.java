/* Name: Jeremiah Stephens
 * Project: Assignment 8
 * Course: Introduction to Computer Programming
 * Class: Comp Sci 201-203 Online Summer 2014
 * Professor: Jayson Rock
 * Date: August 11,2014
 * Functional requirements

The program should first prompt the user for a single string of integers. 
The program must read the entire line of input. 
All integers are assumed to be positive, 
so the integers within the string will each be a sequence of consecutive digits. 
Integers are separated by any non-digits characters. 
For example, the string "aa123 4p56-7890" contains the integers 123, 4, 56, and 7890.

Next the program should display each integer on its own line. For example:

123
4
56
7890

Finally, the program should prompt the user, asking if he or she wants to parse another string. 
If the user response begins with an uppercase or lowercase 'y' the program starts over from the beginning, 
otherwise the program ends.

Non-Functional requirements

You must write and use a method intParse to break the string into a list of integers. 

Its heading is public static int[] intParse(String s)

and it should return an array containing the integers extracted from the input string s. 
The method intParse should not have any side-effects. 
In particular, it should not print anything. 
The main method should use the array of integers returned by intParse to print the list of integers.

 * 
 * 
 * 
 */

	
import java.util.Scanner;

public class Main {

	 private static Scanner input;

	public static void main(String[] args)
	   {
		
		//input is initiated to accept user input		
	       input = new Scanner(System.in);
	       String character = "y";
	       
	       //do while loop to do instructions 
	       do
	       {
	           System.out.print("Please enter a string: ");
	           int[] j = intParse(input.nextLine());
	          
	           for(int i : j)
	               System.out.println(i);
	           System.out.println("Would you like to parse another string (y/n): ");
	           character=input.nextLine();
	       }
	       //while as long as the user enters y or Y
	       while(character.equalsIgnoreCase("y")||character.equals("Y"));
	      
	   }
	  
	   public static int[] intParse(String s)
	   {
	      
	       // This line splits the string whenever 
		   //non-digit characters are encountered
	       String[] split = s.split("[\\D]+");
	      
	       //declares a new variable type int to count the numbers
	       int countN = 0;
	       
	       //for loop that increments countN
	       //as long as the string's length is greater
	       //than zero
	       for(String str : split)
	           if(str.length() > 0)
	               countN++;
	       
	       // Variable outputStr which is declared as an array to hold
	       //the results from countN in elements
	       int[] outputStr = new int[countN];
	       //sets index to 0
	       int index = 0;
	       
	       //loop to parse for integers
	       for(String strg2 : split)
	           if(strg2.length() > 0)
	               outputStr[index++] = Integer.parseInt(strg2);
	       //returns the integers
	       return outputStr;
	   }

}