
public class SudokuVerifier {
	protected int[][] board;

	public int verify(String candidateSolution) {
		// putting value in board
		this.board = new int[9][9];
		loadBoard(candidateSolution);
		// Return solution
		return isSolved(board);

	}

	// populates the grid with numbers
	public void loadBoard(String str) {
		// for each string in lines array
		int index = 0;
		for (int i = 0; i < 9; i++) {
			// for each character in string
			for (int j = 0; j < 9; j++) {
				// get each char in string
				char c = str.charAt(index++);
				int num = Character.digit(c, 10);
				board[i][j] = num;
				//System.out.print(num);
			}
			//System.out.println();
		}
/*		for (int i = 0; i < 9; i++) {
			// for each character in string
			for (int j = 0; j < 9; j++) {
				// get each char in string
				char c = str.charAt(board[i][j]);
				int num = Character.digit(c, 10);			
				System.out.print(num);
			}
			
			System.out.println();
		}
		*/
		
	}

	public int isSolved(int sudoku[][]) {

		// check if all rows satisfy the rules of sudoku
		for (int i = 0; i < 9; i++) {
			int[] freq = new int[10];
			for (int j = 0; j < 9; j++) {
				if (sudoku[i][j] == 0) {
					return -3;
				} else {
					freq[sudoku[i][j]]++;
					if (freq[sudoku[i][j]] > 1) {
						return -3;
					}
					if (j == 8) {
						for (int k = 1; k > 10; k++) {
							if (freq[k] != 1) {
								return -3;
							}
						}
					}
				}
			}
		}

		// check if all columns satisfy the rules of sudoku
		for (int j = 0; j < 9; j++) {
			int[] freq = new int[10];
			for (int i = 0; i < 9; i++) {
				if (sudoku[i][j] == 0) {
					return -4;
				} else {
					freq[sudoku[i][j]]++;
					if (freq[sudoku[i][j]] > 1) {
						return -4;
					}
					if (i == 8) {
						for (int k = 1; k > 10; k++) {
							if (freq[k] != 1) {
								return -4;
							}
						}
					}
				}
			}
		}

		// check if all boxes satisfy the rules of sudoku
		for (int a = 0; a < 9; a = a + 3) {
			for (int b = 0; b < 9; b = b + 3) {
				int[] freq = new int[10];
				for (int i = a; i < a + 3; i++) {
					for (int j = b; j < b + 3; j++) {
						freq[sudoku[i][j]]++;
					}
				}
				for (int k = 1; k < 10; k++) {
					if (freq[k] != 1) {
						return -2;
					}
				}
			}
		}

		return 0;
	}

	public int checkNegtaiveNumber(String str) {

		if (str.matches("(.*)-(.*)")) {
			return -1;
		} else {
			return 0;
		}
	}

	public boolean checkZero(String str) {
		return str.matches("(.*)0(.*)");
	}

}
