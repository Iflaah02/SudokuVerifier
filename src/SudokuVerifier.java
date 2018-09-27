import java.util.Arrays;

public class SudokuVerifier {

	private String solution;

	private int[][] rows;
	private int[][] columns;
	
	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}
	
	public SudokuVerifier() {
		this.solution = "";
		this.rows = new int[9][9];
		this.columns = new int[9][9];
	}
	
	public void stringToRowsAndColumns() {
		int offset = 0;
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.rows[i][j] = solution.charAt(offset) - '0';
				this.columns[j][i] = solution.charAt(offset) - '0';
				offset++;
			}
		}
	}
	
	public boolean isASet(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (i != j && numbers[i] == numbers[j]) {
					return false;
				}
			}
		}
		
	    return true;
	}

	public boolean isRightLength() {
		return solution.length() == 81;
	}
	
	public boolean isRuleOneOk() {
		// A cell in a Sudoku game can only store positive digits
		char[] chars = solution.toCharArray();
		
		for (char ch: chars) {
			if (ch < '1' || ch > '9') {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isRuleTwoOk() {
		// All digits appear only once in a sub-grid
		// horribly inefficient but it works
		for (int i = 0; i < 9; i+=3) {
			for (int j = 0; j < 9; j += 3) {
				int[] subGrid = new int[9];
				
				System.arraycopy(rows[j], i, subGrid, 0, 3);
				System.arraycopy(rows[j+1], i, subGrid, 3, 3);
				System.arraycopy(rows[j+2], i, subGrid, 6, 3);
				
				if (!isASet(subGrid)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isRuleThreeOk() {
		// A digit can appear only once in the rows of the global grid
		for (int i = 0; i < rows.length; i++) {
			if (!this.isASet(rows[i])) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isRuleFourOk() {
		// A digit can appear only once in the columns of the global grid
		for (int i = 0; i < columns.length; i++) {
			if (!isASet(columns[i])) {
				return false;
			}
		}
		
		return true;
	}
		
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		
		setSolution(candidateSolution);
		
		if (!isRightLength()) {
			return 1;
		}
		if (!isRuleOneOk()) {
			return -1;
		}
		
		stringToRowsAndColumns();
		
		if (!isRuleTwoOk()) {
			return -2;
		}
		if (!isRuleThreeOk()) {
			return -3;
		}
		if (!isRuleFourOk()) {
			return -4;
		}
				
		return 0;
	}
	
}