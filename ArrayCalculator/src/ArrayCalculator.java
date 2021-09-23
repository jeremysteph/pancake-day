import java.util.Scanner;

/* Name: Jeremiah Stephens
 * Project: Lab 1
 * Course: Intermediate Computer Programming
 * Class: Comp Sci 251 Fall 2014
 * Professor: Ethan Munson
 * Date: September 9,2014
 * Functional requirements

 Write	a	program	that	repeatedly	lets	the	user enter	an	array	of	values.		Once	the	array	is	entered,	
 the	program	asks	the	user	whether	the	values	should	be	summed	or	multiplied.		Here	are	some	
 details:	
 • Call	your	class	“ArrayCalculator”.		
 • Your	program	should	let	the	user	choose	any	valid	array	size.		That	is,	any	positive	number	
 can	be	the	size.		While	the	prompt	in	the	Sample	Runs	says	that	a	size	of	-1	will	quit	the	
 program,	you	should	assume	any	non-positive	size	means	the	user	wants	to	quit.
 • You	don’t	have	handle	invalid	input	in	an	elegant	way.		In	particular,	if	the	user	enters	
 letters	when	you	are	expecting	numbers,	it’s	acceptable	for	your	program	to	crash.
 */

public class ArrayCalculator {

	// Declares a Scanner object named userInput
	private static Scanner userInput;

	// Main method
	public static void main(String args[]) {
		// Initiates scanner object
		userInput = new Scanner(System.in);

		// start is set to one in order for while loop to run
		int start = 1;

		while (start != 0) {
			// Prints welcome message
			System.out.println("Welcome to the Array Calculator Program");

			// Prompts user to enter= size of the array and to enter -1 to
			// terminate program
			System.out.print("Enter the size of the array (-1 to quit): ");

			// Declares a new int named arraySize and sets the value equal to
			// the next integer entered in by user
			int arraySize = userInput.nextInt();

			// If condition, if user enters in -1 then terminate program and
			// display program terminated message
			if (arraySize == -1) {
				System.out.print("Goodbye!");
				System.exit(-1);
				start = 0;
			}
			// Prompts user to enter in array size
			System.out.println("Enter " + arraySize + " integers: ");

			// Array of type double to hold numbers inputed by user
			int[] numbers;

			// numbers array becomes initiated and the size is set to the size
			// (value of arraySize) entered in by user
			numbers = new int[arraySize];

			// for as long as i< length of array
			for (int i = 0; i < numbers.length; i++) {
				// stores a new double inputed by user into the numbers array
				numbers[i] = userInput.nextInt();
			}

			// Prompts user asking to multiply or add function
			System.out.println("Multiply or add (*, +)?: ");
			// creates new char object mathFunction and sets it to the next char
			// input
			char mathFunction = userInput.next().charAt(0);
			// if the inputed char is "*"
			if (mathFunction == '*') {
				// product equal to value of element 0
				int product = numbers[0];
				for (int j = 1; j < numbers.length; j++) {
					// product equal to current product plus next element
					product = product * numbers[j];
				}

				// prints out results of product
				System.out.println("The product of the numbers is " + product);
			}
			// if the inputed char is equal to "+"
			else if (mathFunction == '+') {
				// the first sum is set to value of first element in array
				int sum = numbers[0];
				// as long as i is less than length of numbers array
				for (int i = 1; i < numbers.length; i++) {
					// sum is equal to the the current sum plus next element in
					// array
					sum = sum + numbers[i];
				}
				// prints out a message indicating the sum
				System.out.println("The sum of the numbers is " + sum);
			}

		}
	}

}
