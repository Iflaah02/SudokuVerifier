
public class SudokuVerifier {
	int[][] sudokuMatrix = new int[9][9];
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		if (!verifyString(candidateSolution)) {
			return -1;
		}
		buildMatrix(candidateSolution);
		
		return verifyMatrix();
	}
	
	public int verifyMatrix() {
		if ( !checkGrids() )	 {
			return -2;
		}
		if ( !checkRows() )	{
			return -3;
		}
		if ( !checkColumns() )	{
			return -4;
		}
		
		return 0;
	}
	
	public boolean verifyString(String str) {
		if (str.length() != 81) return false;
		
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c) || c == '0') return false;
		}
		return true;
	}
	
	//Takes the first chracter in the string and puts its numeric value to the array
	public void buildMatrix(String sudoku) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.sudokuMatrix[j][i] = Character.getNumericValue(sudoku.charAt(0));
				sudoku = sudoku.substring(1);
			}
		}
	}
	
	public int[][] getSudokuMatrix() {
		return this.sudokuMatrix;
	}
	
	public boolean checkRows() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				for (int k = j + 1; k < 9; k++) {
					if (this.sudokuMatrix[j][i] == this.sudokuMatrix[k][i]) return false;
				}		
			}	
		}
		return true;
	}
	
	public boolean checkColumns() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				for (int k = j + 1; k < 9; k++) {
					if (this.sudokuMatrix[i][j] == this.sudokuMatrix[i][k]) return false;
				}		
			}	
		}
		return true;
	}
	
	public boolean checkGrids() {
		for ( int i = 0; i < 9; i += 3) {
			for ( int j = 0; j < 9; j += 3) {
				for ( int pos = 0; pos < 9; pos++) {
					for ( int pos2 = pos + 1; pos2 < 9; pos2++) {
						if( this.sudokuMatrix[i + pos%3][j + pos/3] == this.sudokuMatrix[i + pos2%3][j + pos2/3]) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}
