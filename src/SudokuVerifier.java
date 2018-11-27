import java.util.List;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		// returns null if the candidate solution is not valid Sudoku
		Sudoku sudoku = Sudoku.create(candidateSolution);
		int result = 0;
		
		if (sudoku == null) return -1;
		
		// Consolidate conditionals
		if ((result = checkSudoku(sudoku)) != 0) return result;
		
		return result;
	}
	
	// Introduce Parameter Object
	// Parameterize Method
	public boolean checkSudokuAreas(Sudoku sudoku, SudokuAreaResolver resolver) {
		List<int[]> sudokuAreas = resolver.getAreas(sudoku);
		
		for (int[] area : sudokuAreas) {
			if (!allDifferent(area)) return false;
		}
		
		return true;
	}

	public boolean allDifferent(int[] values) {
		for (int i = 0; i < values.length; i++) {
			for (int j = i + 1; j < values.length; j++) {
				if (values[i] == values[j]) return false;
			}
		}
		
		return true;
	}
	
	// Consolidate conditionals
	private int checkSudoku(Sudoku sudoku) {
		if (!checkSudokuAreas(sudoku, new SudokuSubgridResolver())) return -2;
		if (!checkSudokuAreas(sudoku, new SudokuRowResolver())) return -3;
		if (!checkSudokuAreas(sudoku, new SudokuColumnResolver())) return -4;
		
		return 0;
	}
}
