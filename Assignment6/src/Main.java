/* Name: Jeremiah Stephens
 * Project: Assignment 6
 * Course: Introduction to Computer Programming
 * Class: Comp Sci 201-203 Online Summer 2014
 * Professor: Jayson Rock
 * Date: August 3,2014
 * 
 * Overview: For Assignment 6 the goal:
 * 
 * In this assignment you will write a program that counts the frequency with which letters appear 
 * in a string of text. Character frequency is useful in deciphering simple encryption schemes 
 * (for example, as in The Gold Bug by Edgar Allen Poe). Prompt the user for an input string, 
 * then count the number of times each letter appears in the string, treating upper and 
 * lowercase letters the same. No-letters are ignored. It may be useful 
 * to know that if myChar is a variable containing a uppercase letter, myChar - 'A' will yield the position of that letter within the alphabet. 
 * For example, 'C' - 'A' is 2, while 'Z' - 'A' is 25. Of course, 'A' - 'A' is 0. 
 * An efficient solution to this problem will need to use an array to hold the frequency count for each letter.

Sample Run

Please enter a string: Hello world! Happy day!

A 2 B 0 C 0 D 1 E 1 F 0 G 0 H 2
I 0 J 0 K 0 L 3 M 0 N 0 O 2 P 2
Q 0 R 1 S 0 T 0 U 0 V 0 W 1 X 0
Y 2 Z 0 
 */

import java.util.Scanner;

public class Main {
	
	//Declares a new scanner object named input
	private static Scanner input;

	public static void main(String[] args) {

           
//Creates a array of integers named letterCounterArray 
//that can hold 27 elements 
           int[] letterCounterArray = new int[26];

           input = new Scanner(System.in);
           
//Prints the message "Enter String to console"
           System.out.print("Enter the String: ");

  //New String object that reads the next line of input
  //and stores it in the String object text
           String text = input.nextLine();

          
//declares a new character array and converts the String text object
 //into characters and stores it in an character array
           char[] array = text.toCharArray();

          
// for loop that grabs each character from the char array
           for(char x: array){
        	   
 //declares a new integer named character value
 //and sets the value to the value of the letter the variable 'x' represents
 //after it's converted to an integer

        	   int characterValue = (int)x;

                  int i, j;
                  
                //If condition to determine if character value is greater than 65
                //but less than 90. 
                  if(characterValue>=65 && characterValue<=90){
                	  
                	  
                	// If true then the j = characterValue - 97
                        i=characterValue-65;


                        //if true increment the value of element
                        //located the corresponding i value by 1
                        letterCounterArray[i]++;

                  }
//If condition to determine if character value is greater than 97
//but less than 122. 
                  if(characterValue>=97 && characterValue<=122){
                	 
                	  // If true then the j = characterValue - 97
                        j=characterValue-97;

                        //if true increment the value of element
                        //located the corresponding j value by 1
                        letterCounterArray[j]++;

                  }

           }

          
//for loop that sets i = to 65 and increments it 90
//this loops allows us to move through the array
           for(int i=65; i<=90; i++){

        	   //print on a new line
        	   //the value inside the value of the corresponding element held in i-65
                  System.out.println((char)i+": "+letterCounterArray[i-65]);

           }

          

    }

}


