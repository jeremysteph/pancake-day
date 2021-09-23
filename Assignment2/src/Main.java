/* 
 * Name: Jeremiah Stephens
 * Project: Assignment 2
 * Course: Introduction to Computer Programming
 * Class: Comp Sci 201-203 Online Summer 2014
 * Professor: Jayson Rock
 * Date: June 30,2014
 * 
 * Overview: For Assignment 2 the goal is to print a text based image
 * in java like the one below:
 * 
 * 1   2   3   4   5   6   7   8   9

   2   4   6   8   10  12  14  16  18

   3   6   9   12  15  18  21  24  27

   4   8   12  16  20  24  28  32  36

   5   10  15  20  25  30  35  40  45

   6   12  18  24  30  36  42  48  54

   7   14  21  28  35  42  49  56  63

   8   16  24  32  40  48  56  64  72

   9   18  27  36  45  54  63  72  81
 * 
 * 
 	*/

public class Main {


	//Main method that calls multiplication table method
	public static void main(String[] args){
	multiplicationTable();
	}
	
	//method where the multiplication table is created
	public static void multiplicationTable(){
		
		//int that holds the factor value
		int factor;
		
		//int that holds the result value
		int result;
		
		
		//For loop that increments by 1 the result variable which is initially set to 1
		
			for (result =1; result<=9; result++){
			
		/*For loop that increments by 1 the factor variable which is initially set to 1
			 * this is what prints the top row.	*/
			 for (factor =1; factor <=9; factor++){
				 
				 /*In order to get the correct value in each column, the factor is multiplied by the result 
				  * and a space is added between each result printed.
				  */				 
				 	System.out.print(factor *result + "\t" );
				
	}
	         
//Prints the results on the next line	       
			 System.out.println();

	}
		
	
}}