import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) throws SudokuVerifierException{
		//check length of string
		if (!validateLength(candidateSolution)) {
			throw new SudokuVerifierException();
		}
		
		List<Integer> candidateArray = convertToNumbers(candidateSolution);
		// check that string can be parsed to exactly 81 positive digits
		if (candidateArray.size() != 81) {
			return -1;
		}
		// check subgrid
		if (!checkSubGrid(candidateArray)) {
			return -2;
		}
		// check rows
		if (!checkRows(candidateArray)) {
			return -3;
		}
		// check columns
		if (!checkColumns(candidateArray)) {
			return -4;
		}
		// returns 0 if the candidate solution is correct
		return 0;
		
	}
	
	private boolean validateLength(String str) {
		if (str.length() != 81) {
			return false;
		}
		return true;
	}
	
	private ArrayList<Integer> convertToNumbers(String str) {
		int temp;
		ArrayList<Integer> resultArray = new ArrayList<Integer>();
		for (int i=0; i<str.length(); i++) {
			try {
				temp = Integer.parseInt(String.valueOf(str.charAt(i)));
			} catch (NumberFormatException e) {
				return resultArray;
			}
			resultArray.add(temp);
		}
		return resultArray;
	}
	
	private boolean checkSubGrid(List<Integer> candidate) {
		List<Integer> grid;
		int grid_row, grid_col;
		Integer[] all = new Integer[] {1,2,3,4,5,6,7,8,9};
		List<Integer> alldigits = new ArrayList<Integer>(Arrays.asList(all));
		//Get grids
		for(int i=0; i<9; i++) {
			grid = new ArrayList<Integer>();
			grid_row = i/3;
			grid_col = i%3;
			for(int k=0; k<3; k++) {
				int start = 27*grid_row + 3*grid_col + 9*k;
				grid.addAll(candidate.subList(start, start+3));
			}
			if (!grid.containsAll(alldigits)) {
				return false;
			}		
		}
		return true;
	}
	
	private boolean checkRows(List<Integer> candidate) {
		List<Integer> row;
		Integer[] all = new Integer[] {1,2,3,4,5,6,7,8,9};
		List<Integer> alldigits = new ArrayList<Integer>(Arrays.asList(all));
		//Iterate rows
		for(int i=0; i<9; i++) {
			row = candidate.subList(9*i, 9*i+9); //use +9 because exclusive at upper bound
			//each rows have 9 digits, if it contains all 1-9 it means there is no duplicate.
			if (!row.containsAll(alldigits)) {
				return false;
			}	
		}
		return true;
	}
	
	private boolean checkColumns(List<Integer> candidate) {
		List<Integer> column;
		Integer[] all = new Integer[] {1,2,3,4,5,6,7,8,9};
		List<Integer> alldigits = new ArrayList<Integer>(Arrays.asList(all));
		//get columns
		for(int i=0; i<9; i++) {
			column = new ArrayList<Integer>();
			for(int j=0; j<9; j++) {
				column.add(candidate.get(i+ j*9));
			}
			if (!column.containsAll(alldigits)) {
				return false;
			}
		}
		return true;
	}
}
