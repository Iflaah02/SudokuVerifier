import java.util.Arrays;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		int[][] grid = new int[9][9];
		
		if (validateFormat(candidateSolution)) {
			grid = stringToGrid(candidateSolution);
		} else {
			return -1;
		} 
		
		if (!checkColumns(grid)) {
			return -4; 
		} else if (!checkRows(grid)) {
			return -3;
		} else if (!checkSubGrids(grid)) {
			return -2;
		}
		return 0;
	}
	
	public boolean validateFormat(String candidateSolution) {
		// R1: A cell in a Sudoku game can only store positive digits, i.e. 1...9.
		boolean stringIsValid = true;
		
		if (candidateSolution.length() != 81) {
			stringIsValid = false;
		} else if (candidateSolution.matches("[1-9]+") == false) {
			stringIsValid = false;
		} else if (candidateSolution.length() == 0) {
			stringIsValid = false;
		}
		
		return stringIsValid;
	}
	
	public boolean checkSubGrids(int[][] grid) {
		// R2: All digits appear only once in a sub-grid, i.e. they cannot repeat.
		for (int row = 0; row < 9; row += 3) {
			for (int col = 0; col < 9; col += 3) {
				for (int pos = 0; pos < 8; pos++) {
					for (int pos2 = pos + 1; pos2 < 9; pos2++) {
						if (grid[row + pos%3][col + pos/3]==grid[row + pos2%3][col + pos2/3]) {
			               return false;
			            }
			         }
			      }
			   }
			}
		return true;
	}
	
	
	public boolean checkRows(int[][] grid) {
		// R3: A digit can appear only once in the rows of the global grid.
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 8; col++) {
				for (int col2 = col + 1; col2 < 9; col2++) {
					if (grid[row][col] == grid[row][col2]) {
						return false;
					}
			    }
			}		
		}	
		return true;
	}
	
	public boolean checkColumns(int[][] grid) {
		// R4: A digit can appear only once in the columns of the global grid.
		for (int col = 0; col < 9; col++) {
			for (int row = 0; row < 8; row++) {
				for (int row2 = row + 1; row2 < 9; row2++) {
					if (grid[row][col] == grid[row2][col]) {
						return false;
			        }
				}
			}
	    }
	    return true;
	}
	
	public int[][] stringToGrid(String candidateSolution) {
		int[][] grid = new int[9][9];

		String[] splitCandidateSolution = candidateSolution.split("");
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				grid[i][j] = Integer.parseInt(splitCandidateSolution[j + i * 9]);
			}
		}
		return grid;
	}
}
