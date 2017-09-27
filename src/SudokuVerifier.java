
public class SudokuVerifier {
	int[][] sudokuMatrix = new int[9][9];
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		if (!verifyString(candidateSolution)) {
			return -1;
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
	
	public void buildMatrix(String sudoku) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.sudokuMatrix[j][i] = sudoku.charAt(0);
				sudoku = sudoku.substring(1);
			}
		}
	}
	
	public int[][] getSudokuMatrix() {
		return this.sudokuMatrix;
	}
	
	
}
