/* Name: Jeremiah Stephens
 * Project: Assignment 9
 * Course: Introduction to Computer Programming
 * Class: Comp Sci 201-203 Online Summer 2014
 * Professor: Jayson Rock
 * Date: August 14,2014
 * Functional requirements

1. The program will prompt the user for the number of cards in the deck. 
In this version of in-between the deck consists of N cards, 
each labeled with a distinct integer from 1 to N. 
For smooth solo game play, the size of the deck must be a multiple of 3. 
Reprompt if the user enters a value that is NOT a positive 
integer divisible by 3. (Use the % operator for this.)

2. Create a deck of N cards, implemented an array of integers.

3. Shuffle the deck. This entails randomly selecting 2 
positions in the deck, swapping the cards (ints) 
located at those positions, and repeating this process N times.

4. Deal 2 cards from the deck, displaying their values to the player 
and updating the effective size of the deck.

5. Display the player's account balance and prompt the player to bet. 
The player begins the game with 10 points. 
Each round he must bet exactly 1 point, 
either on between (b), or outside (o). 
If the player enters a value other than b or o, the program reprompts.

6. Deal a card from the deck. 
If the player was correct his score goes up 1, 
if not it goes down 1.

7. If the player has 0 points, the game is over. 
Otherwise, prompt the player to see if he wants to continue. 
If no, the game is over. If yes, continue.

8. If the deck is empty, back to step 2. 
Otherwise, go back to step 4.

Non-Functional requirements:

You program must implement and use the following methods:

public static void initDeck(int[] deck)

//takes an array and initializes its values to 1, 2, …

public static void swap(int[] deck, int p1, int p2)

//swaps the values in deck at positions p1 and p2

public static void shuffle(int[] deck)

//repeat deck.length times: pick 2 random positions in deck and swap
 * 
 * 
 */

import java.util.Random;
import java.util.Scanner;

public class Main {
	
		//declares variable input as a Scanner
	    private static Scanner input;

		public static void main(String[] args) {

				  //sets initial input balance to 10
				  int balance = 10;
	              //initializes input as a new instance of Scanner
				  input = new Scanner(System.in);
	              //boolean contGame is set to true
				  boolean contGame = true;

				  //while loop contGame is true (flow control)
	              while(contGame) {

	            	  //initializes deck array 
	                     int deck[];

	                     //Prints to console prompting user to enter number of cards in deck
	                     System.out.print("Enter the number of cards in the deck: ");

	                   // declares variable length as int and sets it to value of next entered int
	                     int length = input.nextInt();
	                     
	                     //while loop that runs as long as user enters an integer number not divisible by 3
	                     while(length % 3 != 0) {

	                    	 //Prints an error message that integer entered was not divisible by 3
	                           System.out.println("Number of cards is not a multiple of 3. Please enter a number divisible by 3");
	                         //Prompts user to enter number of cards in deck
	                           System.out.print("Enter the number of cards in the deck: ");
	                           //length becomes the value of the next integer input
	                           length = input.nextInt();

	                     }

	                     //element in deck becomes the value current of length
	                     deck = new int[length];

	                     //call to method that initializes deck to value of length
	                     initializeDeck(deck);
	                     //call to method that shuffles deck
	                     shuffleDeck(deck);

	                     // while balance is greater than 0 and length of deck greater than 0
	                     while(balance > 0 && length > 0) {

	                    	 //card one is set to value of element in to the length -1 place
	                           int card1 = deck[length-1];
	                      	 //card two is set to value of element in to the length -2 place
	                           int card2 = deck[length-2];

	                           length -= 2;

	                           //Series of print statements updating user on current game standing
	                           System.out.println("The first card: " + card1);

	                           System.out.println("The second card: " + card2);

	                           System.out.println("Current account balance: " + balance + " points");

	                           System.out.print("Bet on either between(b) or outside(o): ");

	                           
	                           char bet = input.next().toLowerCase().charAt(0);

	                           //while bet is not equal to 'b' or 'o' print not a valid bet then re-prompt user to enter bet
	                           while(bet != 'b' && bet != 'o') {

	                                  System.out.println("Not a valid bet");

	                                  System.out.print("Bet on either between(b) or outside(o): ");

	                                  bet = input.next().toLowerCase().charAt(0);

	                           }
	                           	//sets the value of card 3 to element in deck to the length -1 place
	                           int card3 = deck[length-1];

	                           length--;

	                           System.out.println("The third card: " + card3);

	                           char result = 'o';

	                           //If card 3 is less than card 2 but bigger than card 2 or if card 3 is bigger than card 2 but less than card 1
	                           if((card3 > card1 && card3 < card2) || (card3 > card2 && card3 < card1)) {

	                        	   //sets result equal to b
	                                  result = 'b';

	                           }
	                           //if bet == result
	                           if(bet == result) {

	                        	   //Inform user of their correct choice
	                                  System.out.println("Correct! You gain 1 point.");

	                                  //increase user balance by 1
	                                  balance++;

	                           }

	                           else {

	                        	   //if bet is not equal to result inform user they lose 1 point
	                                  System.out.println("Incorrect, you lose 1 point");

	                                  //decrease balance by 1
	                                  balance--;

	                           }

	                           //Is balance is greater than 0
	                           if(balance > 0) {

	                        	   //prompt user to continue
	                                  System.out.print("Would you like to continue(yes/no)? ");

	                                  //declares string answer to be next input
	                                  String answer = input.next().toLowerCase();

	                                  //if answers equals 'no'
	                                  if(answer.equals("no")) {
	                                	  
	                                	  //set contGame to false, which should while loop
	                                         contGame = false;
	                                         //sets value of length to 0	
	                                         length = 0;

	                                  }

	                           }

	                        //else if player is out of points
	                           else {

	                        	   //inform player they are out of points
	                                  System.out.println("Sorry! You are out of points! Game over!");

	                                  //set continue game to false
	                                  contGame = false;

	                           }

	                     }
	                     	//if deck length is equal to 0
	                     if(length == 0) {

	                    	 //Informs user the deck is empty
	                           System.out.println("The deck is empty! New deck made");
	                           initializeDeck(deck);
	                     }

	              }

	              System.out.println("Game Over!");

	              System.out.println("Your final total is " + balance + " points.");

	       }

		//initializes deck
	       public static void initializeDeck(int[] deck) {

	              for(int i = 0; i < deck.length; ++i) {

	                     deck[i] = i+1;

	              }

	       }

//method to shuffle deck
	       public static void shuffleDeck(int[] deck) {

	              Random random = new Random();

	              for(int i = 0; i < deck.length; ++i) {
	            	  
	            	  //call to method swapDeck passing in two random positive integers divisible deck length for a, b
	                     swapCard(deck,Math.abs(random.nextInt() % deck.length),Math.abs(random.nextInt() % deck.length));                   

	              }

	       }


	     //method to swap deck
	       public static void swapCard(int[] deck, int a, int b) {

	    	    int temp = deck[a];

	              deck[a] = deck[b];

	              deck[b] = temp;

	       }
	
}
