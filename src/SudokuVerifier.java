import java.util.regex.Pattern;

public class SudokuVerifier {
	
	public static int verify(String candidateSolution) {

		if(candidateSolution.length() != 81) {
			return -5;
		} else if(!candidateSolution.matches("[0-9]+")) {
			return -1;
		} else {
			String[] rows = candidateSolution.split("(?<=\\G.{9})");
			String[] columns = new String[9];
			String[][] board = new String[9][9];

			for (int i=0; i<rows.length; i++) {                // getting sudoku board
				board[i] = rows[i].split("(?<=\\G.{1})");
			}
			for (int i=0; i<columns.length; i++) {            // getting columns
				columns[i] = board[0][i]+board[1][i]+board[2][i]+board[3][i]+board[4][i]+
						board[5][i]+board[6][i]+board[7][i]+board[8][i];
			}

			if (!checkGrids(board)) {
				return -2;
			} else if (!checkRows(rows)) {
				return -3;
			} else if (!checkRows(columns)) {
				return -4;
			}
		}

		return 0;
	}

	private static boolean checkRows(String[] rows) {
		for(String row : rows) {
			for(int i=1;i<=9;i++) {
				if(row.indexOf(String.valueOf(i)) != row.lastIndexOf(String.valueOf(i))) {
					// means that the digit was in the string more than once
					return false;
				}
			}
		}
		return true;
	}

	private static boolean checkGrids(String[][] board) {
		for(int i = 0; i<7; i+=3) {
			for(int j=0; j<7; j+=3) {
				String gridStr = board[i][j]+board[i][j+1]+board[i][j+2]+
						board[i+1][j]+board[i+1][j+1]+board[i+1][j+2]+
						board[i+2][j]+board[i+2][j+1]+board[i+2][j+2];
				for(int k=1;k<=9;k++) {
					if(gridStr.indexOf(String.valueOf(k)) != gridStr.lastIndexOf(String.valueOf(k))) {
						// means that the digit was in the string more than once
						return false;
					}
				}
			}
		}
		return true;
	}
}
