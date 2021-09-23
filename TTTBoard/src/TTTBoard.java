import java.util.ArrayList;
import java.util.Random;

public class TTTBoard {
	private char board[][];
	private int size = 2;

	public TTTBoard(int boardSize) {
		this.size = boardSize;
		board = new char[size][size];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = '-';
			}

		}

	}

	public void fillWithRandomXAndO() {
		Random random = new Random();
		int randomNum, countX = 0, countY = 0;
		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[0].length; j++) {
				randomNum = random.nextInt((1 - 0) + 1);
				if ((randomNum == 1) && (countX < (board.length * 2) / 2)
						|| (randomNum == 0 && (countY >= board.length * 2 / 2))) {

					board[i][j] = 'X';
					countX++;
				} else if ((randomNum == 0)
						&& ((countY < (board.length * 2) / 2))
						|| (randomNum == 1 && (countX >= board.length * 2 / 2))) {
					board[i][j] = 'O';
					countY++;
				}

			}

		}
	}

	public char getCellChar(int rowNum, int columnNum) {

		return board[rowNum][columnNum];
	}

	public void setCellChar(int rowNum, int columnNum, char xo) {
		this.board[rowNum][columnNum] = xo;
	}

	public boolean equals(TTTBoard board) {
				if(this.size==board.size){
				
					for (int i = 0; i < this.size;i++)
					{
						for(int j = 0; j < this.size; j++)
						{
							if (this.getCellChar(i, j) != board.getCellChar(i, j))
			 
							{
								return false;
							}
						}
					}
					}
			
					
		
			
		return true;
	}

	public String toString() {

		String s = new String();

		for (int i = 0; i < this.size; i++) {

			for (int j = 0; j < this.size; j++) {
				
				s += "" + board[i][j] ;
				
			}

		}

		return s;

	
}
	}
