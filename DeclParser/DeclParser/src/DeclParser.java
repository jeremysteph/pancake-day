import java.util.Scanner;

public class DeclParser {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Pascal declaration parser!\n");

		System.out.println("Enter one line of Pascal-style declarations:");
		String inputLine = sc.nextLine().trim();
		catchRuntimeError(inputLine);
		//if (inputLine.isEmpty()) {
		//	System.out.println("ERROR: Input line is empty");
		//}
		//else {
			String[] statements = inputLine.split(";", -1);
			for (int i=0; i < statements.length - 1; i++) {
				System.out.println("\nDeclaration Statement " + (i+1) + ":");
				parseAndDescribeDeclStatement(statements[i]);
			}	
			if (!statements[statements.length-1].isEmpty()) {
				System.out.println("\nDeclaration Statement " + statements.length + ":");
				System.out.println("ERROR: Missing semicolon");
				parseAndDescribeDeclStatement(statements[statements.length-1]);
			}
	//	}
		System.out.println("\nGoodbye!");
	}

	public static void parseAndDescribeDeclStatement(String decl) {
		int colonPosition = decl.indexOf(":");
		if (colonPosition == -1) {
			System.out.println("ERROR: Missing colon");
			return;
		}
		String variableList = decl.substring(0,colonPosition);
		String typeName = decl.substring(colonPosition+1).trim();
		String validatedTypeName = validateTypeName(typeName);
		String[] rawVariableNames = variableList.split(",");
		for (int i = 0; i < rawVariableNames.length; i++) {
			String varName = rawVariableNames[i].trim();
			if (!isValidVariableName(varName)) {
				System.out.println("ERROR: Invalid variable name \"" + varName +"\"");
			}
			System.out.println("Variable " + (i+1) + ": " + varName + " (" +
					validatedTypeName + ")" );
		}
	}

	public static String validateTypeName (String typeName) {
		if (typeName.equals("integer") || typeName.equals("real") || typeName.equals("boolean"))
			return typeName;
		else {
			System.out.println("ERROR: \"" + typeName +"\" is not a valid type name");
			return "<invalid type name>";
		}
	}

	public static boolean isValidVariableName(String varName) {
		if (varName.isEmpty())
			return false;
		char firstChar = varName.charAt(0);
		if (! (Character.isLetter(firstChar) || firstChar == '_'))
			return false;
		for (int i = 1; i < varName.length(); i++) {
			char currentChar = varName.charAt(i);
			if (! (Character.isLetter(currentChar) || Character.isDigit(currentChar) || currentChar == '_'))
				return false;
		}
		return true;
	}
	
	public static void catchRuntimeError(String decl){
		boolean notEmptyStatment=false;
		boolean validIdentifier;
		boolean missingColon;
		try{
			
			notEmptyStatment = decl.isEmpty();
			parseAndDescribeDeclStatement(decl);
		}
		catch(InvalidTypeNameException e){
			decl.isEmpty();
				
			System.out.println("ERROR: Input line is empty");
		}
			
			
		catch(MissingColonException e){
			
			String[] statements = decl.split(";", -1);
			if (!statements[statements.length-1].isEmpty()) {
				System.out.println("\nDeclaration Statement " + statements.length + ":");
				throw new MissingColonException("ERROR: Missing semicolon");
			//	parseAndDescribeDeclStatement(statements[statements.length-1]);
			}
	}
		}}