/* 
 * Name: Jeremiah Stephens
 * Project: Assignment 4
 * Course: Introduction to Computer Programming
 * Class: Comp Sci 201-203 Online Summer 2014
 * Professor: Jayson Rock
 * Date: July 20,2014
 * 
 * Overview: For Assignment 4 the goal is to use loops and nested loops to 
 * create program capable of displaying all the prime numbers equal to 
 * or less than the input of the user.
 * 
Sample Run                                                                                                                         

Welcome to the prime number program!
########################################################
Please enter a positive integer: 6
Number    Is Prime  Counterexample
2         Yes       -
3         Yes       -
4         No        4 % 2 = 0
5         Yes       -
6         No        6 % 2 = 0
3 of the first 6 integers are prime; prime ratio = 0.5
  
 */

//Imports the scanner library	
import java.util.Scanner;

public class Main {

	/*
	 * Creates a scanner object named 'input' which is used to store the number
	 * entered in by the user
	 */
	private static Scanner input;

	// Main Method
	public static void main(String args[]) throws invalidInputError

	{
		// Sets the value of input to a System input
		input = new Scanner(System.in);

		// Declares the variable numbers as data type int
		int number;

		// creates a new instance of Main as a object named 'obj'
		Main obj = new Main();

		// Prints out initial line
		System.out.println("Welcome to the prime number program!");

		// Prints out the number symbol
		System.out
				.println("########################################################");

		/*
		 * Prints out the line asking for user to enter a positive integer and
		 * reads in user inputed integer
		 */
		System.out.print("Please enter a positive integer: ");
		number = input.nextInt();

		// Prints the headers for the program
		System.out.println("Number" + '\t' + "Is Prime" + "\t"
				+ "Counter Example");

		/*
		 * While loop that tests that runs the program as long as user enters a
		 * integer greater than 0
		 */
		while (number >= 0)

		{
			obj.dispalyPrimeNum(number);
			System.out.print("\n");
			System.out.print("Please enter a positive integer: ");
			number = input.nextInt();

		}
		// If statement loop that throws a customized error message asking for
		// an integer greater than 0
		if (number < 0) {

			// Constructor is defined in another class I created called
			// invalidInputError
			throw new invalidInputError(
					"Input error, please enter a positive integer greater than 0");

		}

	}

	/*
	 * Method that displays a list of prime displaying all the prime numbers
	 * equal to or less than the input of the user.
	 */

	public void dispalyPrimeNum(int number)

	{

		// isNumPrime (true or false)boolean
		boolean isNumPrime;

		// Sets int count to 0
		int count = 0;

		// If statement that ensures which test cases are divisible by 1 and
		// itself
		if (number >= 2)

		{

			// Number 2 is divisible only by itself and 1
			System.out.println("2 " + "\t" + " Yes");
			// Moves to next number
			count++;

		}

		for (int i = 3; i <= number; i++)

		{

			isNumPrime = true;

			for (int j = 2; j <= i / 2; j++)

			{
				// If number is not prime print no plus counter example
				if (i % j == 0)

				{

					System.out.println(i + "\t" + " NO " + "\t" + "\t" + i
							+ " % " + j + " =0");

					isNumPrime = false;

					break;

				}

			}
			// If number is prime print yes and increase count
			if (isNumPrime == true)

			{

				System.out.println(i + "\t" + " Yes");

				count++;

			}

		}

		System.out.print(count + " of the first " + number
				+ " integers are prime; prime ratio= ");

		/*
		 * Cast count to type double, divide by initial number entered by user
		 * then prints ratio
		 */
		System.out.println((double) count / number);

	}

}
