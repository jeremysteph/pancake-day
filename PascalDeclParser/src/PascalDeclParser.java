/* Name: Jeremiah Stephens
 * Project: PascalDeclParser
 * Course: Intermediate Computer Programming
 * Class: Comp Sci 251 Fall 2014
 * Professor: Ethan Munson
 * Date: September 19,2014
 * Functional requirements

Pascal-style variable declarations

Your program will parse a line of variable 
declarations that are in the style of the Pascal
programming language, which uses a slightly different 
syntax than Java. Here is a sample input

line that you will have to handle:

a ,b, c: integer; d,e :real ;

It contains two declaration statements that declare a total of 5 variables. 
Notice that the type of the variables appears after the names 
and is separated from the names by a colon. Notice also
that space characters can appear in lots of places.

Requirements

• Your program must read a single line that may contain many Pascal 
variable declaration statements and output a description of the declarations. 
The Sample Output below gives an example of what your program should produce.

• Your program must give error messages in the following cases:
	o A missing semi-colon on the last declaration statement
	o An empty statement (no text at all)
	o A statement without a colon separator
	o A statement whose type name is not a valid type. The valid types are “integer”,
		“real”, and “boolean”.
	o A variable name that is not valid. Valid variable names follow the same rules as
		Java: any combination of letters, digits, and underscores that does not start with a
		digit.
• Don’t worry about giving error messages that recognize complex errors. 
For example, the string “a,b:c : integer;” looks as if the user 
accidently replaced a comma with a colon.
Your program can just say that “c : integer” is not a valid type 
or say that the statement has too many colons.

Suggestions
• Our solution uses all of the following methods. 
There are alternate solutions that might
use a different mix, but for us, this was the easiest path

	o From the String class: charAt, substring, trim, split, and indexOf

	o From the Character class: isDigit, and isLetter

• Our solution has several methods:
	o public static void parseAndDescribeDeclStatement(String decl)
	This method is called by main() and handles a single declaration statement. It
	assumes that its argument has had the semicolon removed and then been trimmed

	o public static String validateTypeName (String typeName)
	This method takes typeName and checks to see if it is a valid type name. If it is,
	it returns the same string. Otherwise, it returns the String “<invalid type name>”

	o public static boolean isValidVariableName(String varName)
	This method returns true if its argument is a valid variable name and returns false
	otherwise.
• The sample output doesn’t show it, but we have a 
special check for an empty input line and print an error message when that happens.

• When a declaration statement is empty, we print the “missing colon” error.

• When no variables are declared or the type name is missing, 
we print error messages that say that the String “” is not 
a valid variable or type name. 
This shouldn’t require a special case in your code 
	… it just follows from checking whether the empty string is a
	valid name.
 */
import java.util.*;

public class PascalDeclParser {
	private static Scanner userInput = new Scanner(System.in);
	private static String variableName;
	private static String variableType, newDecl;
	private static int numOfVariables;
	private static int startIndex = 0;
	private static int colonIndex;
	private static int k = 0;
	private static int semiColonIndex;
	private static int numDeclStatements = 0;
	private static int lastIndex;
	private static boolean validType = false, newStatement = false;
	private static String error;

	public static void main(String[] args) {
		String pascalDeclStatement;
		System.out.println("Welcome to the Pascal declaration parser!");
		System.out.println("Enter one line of Pascal-style declarations: ");
		pascalDeclStatement = userInput.nextLine().trim();
		parseAndDescribeDeclStatement(pascalDeclStatement);

	}

	public static String validateTypeName(String typeName) {
		if ((typeName.equalsIgnoreCase("integer"))
				|| (typeName.equalsIgnoreCase("boolean"))
				|| (typeName.equalsIgnoreCase("real"))) {

		} else {
			System.out.println("ERROR: " + "\"" + typeName + "\""
					+ " is not a valid type name");
			variableType = "<invalid type name>";
			typeName = variableType;
		}
		return typeName;
	}

	public static void parseAndDescribeDeclStatement(String decl) {

		colonIndex = decl.indexOf(":");
		semiColonIndex = decl.indexOf(";");
		newDecl = decl.substring(startIndex, semiColonIndex + 1).trim();
		lastIndex = decl.length();

		for (int i = 0; i < decl.length(); i++) {

			if ((decl.charAt(i) == ';')
					|| (decl.charAt(i) == ' ' && (i == lastIndex))) {
				numDeclStatements++;
				newStatement = true;
				if (newStatement == true) {
					newStatement = false;
					for (int j = 0; j < newDecl.length(); j++) {

						if (newDecl.charAt(j) == ',') {
							numOfVariables++;

						}
					}
				}

				int arrayIndex = 0;

				if (k < numDeclStatements) {

					variableName = decl.substring(startIndex, colonIndex)
							.trim();
					if (variableName.startsWith(";")) {
						variableName = decl.substring(startIndex + 1,
								colonIndex);
					}
					if(semiColonIndex==lastIndex-1){
						variableType = decl.substring(colonIndex, lastIndex);
					}
					else{
					variableType = decl.substring(colonIndex + 1,
						semiColonIndex).trim();
					}
					
					String[] variables = variableName.split(",");

					System.out.println("Declaration Statement "
							+ numDeclStatements + ": ");
					validateTypeName(variableType);
					do {

						if (isValidVariableName(variables[arrayIndex]) == true) {
							printToConsole(variables, arrayIndex);

						} else {

							System.out.println(error + "\""
									+ variables[arrayIndex].trim() + "\"");
							printToConsole(variables, arrayIndex);
							// break;
						}
						arrayIndex++;
					} while (arrayIndex <= numOfVariables);
					if(semiColonIndex != lastIndex -1){
					updateStartIndex(decl, startIndex, semiColonIndex);
					updateColonIndex(decl, ":", startIndex);
					updateSemiColonIndex(decl, ";", startIndex);
					}
					numOfVariables = 0;
				}
				System.out.println();
			}
			if (startIndex < decl.length()) {

				updateNewDeclIndexi(decl, startIndex, semiColonIndex + 1);
			} else
				break;
		}

		System.out.println("GoodBye!");

	}

	private static void updateNewDeclIndexi(String decl, int startIndex2,
			int semiColonIndex2) {
		newDecl = decl.substring(startIndex2, semiColonIndex2);
	}

	private static int updateStartIndex(String decl, int startindex,
			int semiColonIndex) {
		startIndex = semiColonIndex + 1;
		if (decl.charAt(startIndex) == ';') {
			numDeclStatements++;
			System.out.println();
			System.out.println("Declaration Statement " + numDeclStatements);
			System.out.println("ERROR: Missing colon");

		}

		do {
			startIndex++;
		} while (decl.charAt(startIndex) == ';');

		return startIndex;
	}

	private static int updateColonIndex(String decl, String character,
			int startIndex) {
		colonIndex = decl.indexOf(":", startIndex);
		return colonIndex;
	}

	private static int updateSemiColonIndex(String decl, String character,
			int startIndex) {
		if (semiColonIndex == decl.lastIndexOf(";")) {

			semiColonIndex = lastIndex - 1;
		} else {
			semiColonIndex = decl.indexOf(character, startIndex);

		}

		return semiColonIndex;
	}

	public static boolean isValidVariableName(String varName) {
		varName = variableName;
		boolean isValidVariableName = false;
		if (Character.isDigit(varName.charAt(0))) {
			isValidVariableName = false;
			error = "ERROR: Invalid variable name ";
		} else if (variableName.startsWith(";")) {
			variableName.split(";");
			variableName.trim();
			isValidVariableName = true;
		} else {
			isValidVariableName = true;
		}
		return isValidVariableName;
	}

	private static void printToConsole(String[] variables, int arrayIndex) {
		System.out.println("Variable " + (arrayIndex + 1) + ": "
				+ variables[arrayIndex].trim() + " (" + variableType.trim()
				+ ")");
		arrayIndex++;
	}
}
