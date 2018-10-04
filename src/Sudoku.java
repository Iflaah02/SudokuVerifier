
// Extract Class
public class Sudoku {
	private int[] sudokuData;

	private Sudoku() {
		sudokuData = new int[81];
	}
	
	public static Sudoku create(String sudokuString) {
		if (!isValidSudokuString(sudokuString)) {
			return null;
		}

		Sudoku sudoku = new Sudoku();
		for (int i = 0; i < sudokuString.length(); i++) {
			String str = sudokuString.substring(i, i + 1);
			sudoku.sudokuData[i] = Integer.parseInt(str);
		}
		
		return sudoku;
	}

	private static boolean isValidSudokuString(String candidateSolution) {
		if (candidateSolution.length() != 81) return false;
		
		for (int i = 0; i < candidateSolution.length(); i++) {
			char c = candidateSolution.charAt(i);
			
			if (!Character.isDigit(c)) return false;
		}
		
		return true;
	}

	public int[] getSudokuData() {
		return sudokuData;
	}
}