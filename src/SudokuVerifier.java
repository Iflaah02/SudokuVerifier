import java.util.HashSet;
import java.util.Set;

public class SudokuVerifier {
	
	int solution;
	int boardSize = 9;
	int correctLength;
	int[] subGrid = new int[9];
	Set<Integer> set = new HashSet<Integer>();
	int[][] matrix;
	
	
	public SudokuVerifier() {
		this.solution = 0;
		this.correctLength = (this.boardSize*this.boardSize);
		this.matrix= new int[this.boardSize][this.boardSize];
	}
	
	public int checkUniqueInSubGrid() {
		for (int i = 0; i < boardSize; i++) {
			set.clear();
			fillSubGrid(i);
			if  (set.size() != 9) {
				return -1;
			}
		}
		return 0;
	}
	
	public int checkUniqueInRows() {
		for (int i = 0; i < boardSize; i++) {
			set.clear();
			fillRows(i);
			if  (set.size() != 9) {
				return -1;
			}
		}
		return 0;
	}
	
	public int checkUniqueInColumns() {
		for (int i = 0; i < boardSize; i++) {
			set.clear();
			fillColumns(i);
			if  (set.size() != 9) {
				return -1;
			}
		}
		return 0;
	}
	
	

	public void fillSubGrid(int index) {
		int basei,basej;
	    basei = ((index)/3)*3;
	    basej = ((index)%3)*3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int temp = matrix[(basei)+i][(basej)+j];
				set.add(temp);
			}
		}					
	}
	public void fillRows(int index) {
		for (int j = 0; j < matrix.length; j++) {
			int temp = matrix[index][j];
			set.add(temp);
		}
	}
	
	public void fillColumns(int index) {
		for (int j = 0; j < matrix.length; j++) {
			int temp = matrix[j][index];
			set.add(temp);
		}
	}
	
	public int checkAllPositive() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (!(matrix[i][j] >= 1 && matrix[i][j] <= 9)) {
					return -1;
				}
			}
		}
		return 0;
	}

	
	public void strToRowsCols(String str) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = Character.getNumericValue(str.charAt((i*this.boardSize)+j));
			}
		}
	}
	
	public boolean isCorrectLength(String str) {
		return str.length() == this.correctLength;
	}
	
	public int verify(String candidateSolution) {
		
		if (!isCorrectLength(candidateSolution)) {
			return -5;
		}
		strToRowsCols(candidateSolution);
		
		if (checkAllPositive() == -1) {
			return -1;
		}
		
		if (checkUniqueInSubGrid() == -1) {
			return -2;
		}
		
		if (checkUniqueInRows() == -1) {
			return -3;
		}
		
		if (checkUniqueInColumns() == -1) {
			return -4;
		}
		
		return 0;
	}
}
