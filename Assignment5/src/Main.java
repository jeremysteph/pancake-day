/* Name: Jeremiah Stephens
 * Project: Assignment 5
 * Course: Introduction to Computer Programming
 * Class: Comp Sci 201-203 Online Summer 2014
 * Professor: Jayson Rock
 * Date: July 24,2014
 * 
 * Overview: For Assignment 5 the goal is to 
 * 
 * 1. Prompt the user for as valid last name, reprompting until a valid last name is entered. 
 * A last name is valid if it contains only letters and spaces, 
 * it begins and ends with a letter, 
 * and it does not contain 2 consecutive spaces.

   2. The program then prompts for a year of birth. 
   Valid birth years are integers between 1900 and 1999, 
   inclusive, but your program must reprompt on non-numeric input. 
   Implicitly, this means you must read the data as a string.

   3. Finally, the program prompts for a valid Wisconsin driver's license number. 
   It will have the format LDDD-DDDD-DDDD-DD, where L is a capital letter and each D is a digit. For example, 
   A123-4567-8901-23. The program reprompts until a valid number, including dashes, is entered.

   4. For these inputs to be consistent, the first letter of the last name 
   must match the first letter of the driver's license number. 
   Case is ignored, so a last name of “el Guapo” would match a driver's 
   license number beginning with “E”. Also, the last 2 digits of the 
   year of birth are encoded in the driver's license number 
   (denoted by Y): LDDD-DDDY-YDDD-DD. So A123-4567-8901-23 would 
   belong to a person born in 1978. If the last name, year of birth, 
   and driver's license number are consistent the program prints consistent; 
   otherwise, it prints fraudulent.
 * 
Sample Run

License Validator
Enter a last name: ab    bA
Enter a last name: ab bA
Enter year of birth: a12w
Enter year of birth: 1979
Enter driver's license number: A123-4567-9801-23
Consistent
 */

//Imports the scanner library	
import java.util.Scanner;

public class Main {
    private static Scanner userInput = new Scanner(System.in);
    private static String yearOB;
    private static String lastName;
    private static String driversLN;
    
    public static void main(String[] args) {
        enterDriverInfo();
    }  
     
    //This method prompts the user to enter last name, driver's license number, and year of birth
    //in addition it also checks for a valid input.
    	private static void enterDriverInfo(){
    		do {
            System.out.print("Enter last name: ");
            lastName = userInput.nextLine();
        } while (!isLastNameValid(lastName));
    	
        do {
            System.out.print("Enter year of birth: ");
            yearOB = userInput.nextLine();
        } while (!isYearOfBirthValid(yearOB));
      
        do {
            System.out.print("Enter driver's license number: ");
            driversLN = userInput.nextLine();
        } while (!isDriversLNValid(driversLN));
              
        if (isConsistentInformation(driversLN, lastName, yearOB))
            System.out.println("Consistent");
        else
            System.out.println("Fraudulent");
    }
  
        //This boolean condition checks to ensure if year of birth is between 1900 and 1999
        // converts it to a string with length = 4
        //  and formats date to 19DD
        private static boolean isYearOfBirthValid(String birthYearStr) {
          
            if (birthYearStr.length() != 4)
                return false;
            if (birthYearStr.charAt(0) != '1' || birthYearStr.charAt(1) != '9')
                return false;
            if (!Character.isDigit(birthYearStr.charAt(2))
                    || !Character.isDigit(birthYearStr.charAt(3)))
                return false;
            return true;
        }
      
   //Boolean condition that checks to see if last name has only characters and spaces,
    //begins with a letter,and does not contain 2 consecutive spaces
    private static boolean isLastNameValid(String lastName) {
       
    	//Checks and sees if the user last name begins with a letter
    	if (!Character.isLetter(lastName.charAt(0))	|| !Character.isLetter(lastName.charAt(lastName.length() - 1)))
            return false;
        for (int i = 1; i < lastName.length() - 1; i++) {
            if (!Character.isLetter(lastName.charAt(i))) {
                
            	//checks and see if name has only characters and spaces
            	if (lastName.charAt(i) != ' ') 
                    return false;
                else if (lastName.charAt(i + 1) == ' ') //3.
                    return false;
            }
        }
        return true;
    }
  

    //This boolean condition checks to see if license number entered is formatted as LDDD-DDDD-DDDD-DD
    //by ensuring the length of license number is 17 characters
    //there is a dash after the 4,9, and 14 characters,
    //the license number begins with a letter followed by digits

    private static boolean isDriversLNValid(String driversLN) {
       
    	//Condition to check if length is 17
    	if (driversLN.length() != 17)
            return false;
    	//Checks to see if license begins with letter
        if (!Character.isUpperCase(driversLN.charAt(0)))
            return false;
        //Loop to add dash after the 4th, 9th, and 14th characters
        for (int i = 1; i < driversLN.length(); i++) {
            if (i == 4 || i == 9 || i == 14) {
                if (driversLN.charAt(i) != '-') 
                    return false;
            }
            else {
            	//Checks to see if character after the first is a digit
                if (!Character.isDigit(driversLN.charAt(i)))
                    return false;
            }
        }
        return true;
    }
          
    //Boolean to ensure leading character of lastName matches 1st letter of driver's license number
    //and the format of license number is LDDD-DDDY-YDDD-DD
    //  such that YY is the last two digits of birth year
    private static boolean isConsistentInformation(
    		//ensure leading character of lastName matches 1st letter of driver's license number
            String driversLN, String lastName, String birthYear) {
        if (driversLN.charAt(0) != Character.toUpperCase(lastName.charAt(0)))
            return false;
       // if condition to see if the format of license number is LDDD-DDDY-YDDD-DD
        if (driversLN.charAt(8) != birthYear.charAt(2)
                || driversLN.charAt(10) != birthYear.charAt(3)) 
            return false;
        return true;
    }
}