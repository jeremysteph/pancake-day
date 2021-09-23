/* 
 * Name: Jeremiah Stephens
 * Project: Assignment 3
 * Course: Introduction to Computer Programming
 * Class: Comp Sci 201-203 Online Summer 2014
 * Professor: Jayson Rock
 * Date: July 14,2014
 * 
 * Overview: For Assignment 3:
 * * A local retailer has hired you to write a program to calculate the total cost of a customer's purchase. The customer may purchase Snaps, Red Hots, or Mike-N-Ikes. Snaps are sold for $1.60 a box, Red Hots for $1.20 a box, and Mike-N-Ikes for $1.80 a box. A sales tax of 5% is added to the total cost of the candy.

Write a Java program that satisfies the above description.

Requirements:

    The number of Snaps, Red Hots, and Mike-N-Ikes must each be obtained from the user and stored in an appropriately typed local variable.
    The correct pre-tax subtotal must be calculated and returned by a static method and stored in an appropriately typed local variable in main.
    The correct tax must be calculated and returned by a static method and stored in an appropriately typed local variable in main.
    The pretax subtotal, tax, and total cost must be displayed to the user in a reasonable report format by a static void method.

  
 */

import java.util.Scanner;

public class Main {

	// Variable to hold input of user
	static Scanner input = new Scanner(System.in);

	// Variable to hold cost of Snaps per box
	private static double costOfSnaps = 1.60;
	// Variable to hold cost of RedHots per box
	private static double costOfRedHots = 1.20;
	// Variable to hold cost of Mike-N-Ikes per box
	private static double costOfMikenIkes = 1.80;
	// Variable to hold rate of sales tax of 5%
	private static double salesTaxRate = .05;
	// Variable to hold rate of subTotal
	private static double subTotal;
	// Variable to hold rate of sales tax
	private static double tax;
	// Variable to hold rate of sales total%
	private static double total;

	public static void main(String[] args) {
		// Call to method that allows user to input boxes of candy for each
		// brand
		boxesOfCandy(0, 0, 0);
		// Declaration of local variable Sub_Total which will hold value of
		// preTaxTotal Method
		double Sub_Total = preTaxTotal();
		// Sets field subTotal to the value of local variable Sub_Total
		subTotal = Sub_Total;
		// Declaration of local variable Sales_Total which will hold value of
		// salesTax Method
		double Sales_Tax = salesTax();
		// Sets field tax to the value of local variable Sales_Tax
		tax = Sales_Tax;
		double Final_Total = finalTotal();
		// Sets field total to the value of local variable Final_Total
		total = Final_Total;
		// A call to displayTotal method which prints results
		displayTotal();

	}

	// Method that allows users to input the number of boxes for each brand of
	// candy
	public static void boxesOfCandy(int numSnaps, int numRedHots,
			int numMikenIkes) {

		// Prompts user to enter number of boxes for Snaps candy
		System.out.print("Enter the number of Snaps to Purchase: ");
		numSnaps = input.nextInt();
		costOfSnaps = costOfSnaps * numSnaps;

		// Prompts user to enter number of boxes for Red Hots candy
		System.out.print("Enter the number of Red Hots to Purchase: ");
		numRedHots = input.nextInt();
		costOfRedHots = costOfRedHots * numRedHots;

		// Prompts user to enter number of boxes for Mike-N-Ikes candy
		System.out.print("Enter the number of Mike-N-Ikes to Purchase: ");
		numMikenIkes = input.nextInt();
		costOfMikenIkes = costOfMikenIkes * numMikenIkes;

	}

	// Method that calculates and returns the value of preTax total
	public static double preTaxTotal() {
		double preTax = (costOfSnaps + costOfRedHots + costOfMikenIkes);
		return preTax;
	}

	// Method that calculates and returns the value of salesTax total
	public static double salesTax() {

		double salesTax = subTotal * salesTaxRate;
		// Rounds sales tax to 1 decimal place
		salesTax = (salesTax * 100) / 100;
		return salesTax;
	}

	// Method that calculates and returns the value of final total
	public static double finalTotal() {
		double finalTotal = subTotal + tax;
		return finalTotal;
	}

	// Method that prints out final results
	public static void displayTotal() {

		System.out.println("Subtotal: " + "$" + subTotal);

		System.out.println("Tax: " + "$" + tax);

		System.out.println("Total: " + "$" + total);

	}

}
