/* 
 * Name: Jeremiah Stephens
 * Project: Assignment 1
 * Course: Introduction to Computer Programming
 * Class: Comp Sci 201-203 Online Summer 2014
 * Professor: Jayson Rock
 * Date: June 27,2014
 * 
 * Overview: For Assignment 1 the goal is to print a text based image
 * in java like the one below:
 * 
 		  * 
 		 ***
        *****
      *       *
      *       *       
      *       *       
      *       *       
      *       *       
      *       *       
      	  * 
 		 ***
        *****
  
  */


//Class called Main
public class Main {

	//Main method that calls the other two methods
	//PrintRocketTop and PrintRocketSides
	
	public static void main(String[] args) {
		printRocketTop();
		printRocketSides();
	}

	//Prints the top & bottom of the Rocket
public static void printRocketTop(){
	
	System.out.println("   *");
	System.out.println("  ***");
	System.out.println(" *****");

}

// Prints the sides of the Rocket
public static void printRocketSides(){
	for(int i=0; i<6;i++){
	System.out.println("*     *");
	}
	
	//Called this method here to prevent calling it again in Main	
	printRocketTop();
}
}