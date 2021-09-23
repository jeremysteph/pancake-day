import java.util.Scanner;
import java.util.ArrayList;

public class TTTBoardDriver {

	private static Scanner userInput = new Scanner(System.in);
	private static ArrayList<TTTBoard> boards = new ArrayList<TTTBoard>();
	private static TTTBoard[] generatedBoards;
	private static TTTBoard newBoard;
	public static void main(String args[]) {
		int size;
		int numOfBoards;

		System.out
				.print("Welcome to the Tic-Tac-Toe Board Generator" + '\n' + '\n');

		do {
			System.out.print("Enter board size (at least 2): ");
			size = userInput.nextInt();
			newBoard = new TTTBoard(size);
			if (size < 2) {
				System.out.println("ERROR: Board size must be at least " + "2"
						+ '\n');
			}

		} while (size < 2);

		do {
			
			System.out.print("Enter number of boards to generate: ");
			numOfBoards = userInput.nextInt();
			
			if (numOfBoards < 1) {
				System.out.print("ERROR: Must generate at least one board" + '\n');
			}
			newBoard.fillWithRandomXAndO();
			generatedBoards = new TTTBoard[numOfBoards];
			boards.add(newBoard);
			
		} while (numOfBoards < 1);
		newBoard = new TTTBoard(size);
		
	
	for (int i = 0; i < numOfBoards; i++) {

			newBoard = new TTTBoard(size);
 			newBoard.fillWithRandomXAndO();		
			
	generatedBoards[i] = newBoard;
	}
	for (int k=0;k<boards.size(); k++){
		if((boards.get(0).equals(generatedBoards[k])) ==false)
				{
			boards.add(0,generatedBoards[k]);
		}
	}
	/*

 			newBoard = new TTTBoard(size);
	 			newBoard.fillWithRandomXAndO();		
				//newBoard = new TTTBoard(size);

 }
 else{
	 boards.add(newBoard);
 	}
 }
		*/

	
			


		

		System.out.println("Number of unique boards generated: " + boards.size());

		System.out
				.print("Would you like to see all of the unique boards (y/n): ");

		String choice = userInput.next();
		if (choice.equals("y") || choice.equals("Y")) {

			displayBoard();

		}

		System.out.print('\n' + "Goodbye!");

	}

	public static void displayBoard() {
		for (int i = 0; i < boards.size(); i++) {
			System.out.printf("%n" + "Unique Board # " + i + '\n'
					+ boards.get(i).toString() + '\n');
		}
	}


}