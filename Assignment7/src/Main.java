/* Name: Jeremiah Stephens
 * Project: Assignment 7
 * Course: Introduction to Computer Programming
 * Class: Comp Sci 201-203 Online Summer 2014
 * Professor: Jayson Rock
 * Date: August 09,2014
 * 
 *Write a spell checking program which uses a dictionary of words 
(input by the user as a string) to find misspelled words in a second string, 
the test string. Your program should prompt the user for the input string 
and the dictionary string. A valid dictionary string contains an alphabetized list of words.

	Functional requirements:

    For each word in the input string, your program should search the dictionary string for the given word. 
    If the word is not in the dictionary, you program should print 
    the message "Unknown word <word> found" to standard output.
    After traversing the entire input string, your program should print 
    a message describing the total number of misspelled words in the string.
    A dictionary string may contain words in uppercase, lowercase, or a mixture of both. 
    The test string may also combine upper and lower case letters. 
    You program should recognize words regardless of case. 
    So if "dog" is in the dictionary string, the word "dOG" should be recognized as a valid word. 
    Similarly, if "CaT" is in the dictionary string, the word "cat" she be recognized as a valid word.
    Within a string, a word is a white-space delimited string of characters. 
    So the last word in "Hello world!" is "world!". 

 * 
 * 
 * 
 * 
 */

import java.util.Scanner;

public class Main {


	//Declares new Scanner object named input
	private static Scanner input;
	//Static string to hold dictionarystring
	private static	String dictionaryString = "";
	//Static string to hold inputstring
	private static String inputString = "";
	//Static string to hold dictionaryWords
	private static String[] dictonaryWords = dictionaryString.split(" ");
	//Static string to hold inputWords
	private static String[] inputWords = inputString.split(" ");

	public static void main(String[] args) {
	
	//initiates input
	input = new Scanner(System.in);
//Prints to console a message prompting user to enter in dictionary string
	System.out.println("Enter the dictionary string: ");
//sets the next line to be the value of dictionaryString
	dictionaryString = input.nextLine();

	//Prompts user to enter input string
	System.out.println("Enter the input string: ");
	//Sets inputString to next line value
	inputString = input.nextLine();
	
	//call to checkForMisspelledWordsMethod
	checkForMisspelledWords();
	
	}
	
	private static void checkForMisspelledWords(){
	
		//initial count set to 0
	int count = 0;
	
	for(int i=0; i < inputWords.length; i++){
	
		//Sets value of misspelled words to false
	
		boolean misspelledWords = false;
	for(int j=0; j < dictonaryWords.length; j++){
	
//compares both arrays if they are equal ignores case
		
		if(inputWords[i].equalsIgnoreCase(dictonaryWords[j])) {

			
			misspelledWords = true;
	break;
	}
	}
	//If misspelled words are found
	if(!misspelledWords) {
		
		//print to console the misspelled word
	System.out.println("Unknown word: " + inputWords[i] + "found");
	//increase count
	count++;
	}
	}
	System.out.println("Total number of mispelled words: " + count);

	}

	}

