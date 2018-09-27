
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		
		if (!isValidInputString(candidateSolution)) return -1;
		
		int[] sudokuData = parseData(candidateSolution);
		
		if (!checkSubGrids(sudokuData)) return -2;
		if (!checkRows(sudokuData)) return -3;
		if (!checkColumns(sudokuData)) return -4;
		
		return 0;
	}
	
	private int[] parseData(String candidateSolution) {
		int[] sudokuData = new int[81];
		
		for (int i = 0; i < candidateSolution.length(); i++) {
			String str = candidateSolution.substring(i, i + 1);
			sudokuData[i] = Integer.parseInt(str);
		}
		
		return sudokuData;
	}

	public boolean isValidInputString(String candidateSolution) {
		if (candidateSolution.length() != 81) return false;
		
		for (int i = 0; i < candidateSolution.length(); i++) {
			char c = candidateSolution.charAt(i);
			
			if (!Character.isDigit(c)) return false;
		}
		
		return true;
	}
	
	public boolean checkSubGrids(int[] sudokuData) {
		int[] subgrid = new int[9];
		
		for (int i1 = 0; i1 < 3; i1++)
		for (int i2 = 0; i2 < 3; i2++) {			
			for (int j1 = 0; j1 < 3; j1++)
			for (int j2 = 0; j2 < 3; j2++) {
				subgrid[j1 * 3 + j2] = sudokuData[i1 * 27 + i2 * 3 + j1 * 9 + j2];
			}
			
			if (!allDifferent(subgrid)) return false;
		}
				
		return true;
	}
	
	public boolean checkRows(int[] sudokuData) {
		int[] row = new int[9];
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				row[j] = sudokuData[i * 9 + j];
			}
			
			if (!allDifferent(row)) return false;
		}
		
		return true;
	}
	
	public boolean checkColumns(int[] sudokuData) {
		int[] column = new int[9];
		
		for (int i = 0; i < 9; i++) {	
			for (int j = 0; j < 9; j++) {
				column[j] = sudokuData[i + j * 9];
			}
			
			if (!allDifferent(column)) return false;
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
}
