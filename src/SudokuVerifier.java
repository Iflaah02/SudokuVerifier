import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuVerifier {
	
	private static int INPUT_LENGTH = 81;
	
	public void validate_input_length(String input_string) throws IncorrectLengthException {
		if(input_string.length() != INPUT_LENGTH) {
			throw new IncorrectLengthException();
		}
	}
	
	public void validate_input_contains_positive_integers(String input_string) throws NotOnlyIntegersException {
		if(!input_string.matches("[0-9]+")) {
			throw new NotOnlyIntegersException();
		}
	}
	
	public int[] string_array_to_int_array(String input_string) throws NotOnlyIntegersException, IncorrectLengthException {
		validate_input_length(input_string);
		validate_input_contains_positive_integers(input_string);
		
		String[] stringInputArray = input_string.split("");
		int[] intInputArray = Arrays.asList(stringInputArray).stream().mapToInt(Integer::parseInt).toArray();
		
		return intInputArray;
	}
	
	public int[][] make_sudoku_grid(String input_string) throws IncorrectLengthException, NotOnlyIntegersException {
		
		int[] intArray = string_array_to_int_array(input_string);
		int[][] sudokuArray = new int[9][9];
		
		for(int j=0, i=0; j < 9; j++) {
			for(int k=0; k < 9; k++, i++) {
				//System.out.println("sudokuArray[" + j + "][" + k + "] = intArray[" + i + "]");
				sudokuArray[j][k] = intArray[i];
			}
		}
		return sudokuArray;
	}
	
	public boolean duplicatesInArray(final int[] input_array) {
		// https://stackoverflow.com/questions/3951547/java-array-finding-duplicates
		
		Set<Integer> lump = new HashSet<Integer>();
		for (int i : input_array)
		{
			if (lump.contains(i)) return true;
			lump.add(i);
		}
		return false;
	}
	
	public void verify_rows(int[][] sudokuGrid) throws IncorrectRowException {
		for(int i=0; i < sudokuGrid.length; i++) {
			if(duplicatesInArray(sudokuGrid[i])) {
				throw new IncorrectRowException();
			}
		}
	}
	
	public void verify_cols(int[][] sudokuGrid) throws IncorrectColException {
		for(int k=0; k < sudokuGrid.length; k++) {
			int[] tmp_array = new int[sudokuGrid[k].length];
			for(int j=0; j < sudokuGrid[k].length; j++) {
				tmp_array[j] = sudokuGrid[k][j];
			}
			if(duplicatesInArray(tmp_array)) {
				throw new IncorrectColException();
			}
		}
	}
	
	public void verify_sub_grid(int[][] sudokuGrid, int start_point_row, int start_point_col) throws IncorrectSubGridException {
		int[] temp_array = new int[9];
		start_point_row = start_point_row -1;
		start_point_col = start_point_col -1;
		int end_point_row = start_point_row + 3;
		int end_point_col = start_point_col + 3;
		
		for(int i = start_point_row, j = 0; i < end_point_row; i++) {
			for(int k = start_point_col; k < end_point_col; k++, j++) {
				temp_array[j] = sudokuGrid[i][k];
				//System.out.println("temp_array[" + j + "] = sudokuGrid[" + i + "][" + k + "]");
			}
		}
		if(duplicatesInArray(temp_array)) {
			throw new IncorrectSubGridException();
		}
	}
	
	public int verify(String candidateSolution) {
		
		int[][] sudoku;
		
		try {
			sudoku = make_sudoku_grid(candidateSolution);
		} catch (IncorrectLengthException | NotOnlyIntegersException e) {
			return -1;
		}
		
		try {
			verify_rows(sudoku);
		} catch (IncorrectRowException e) {
			return -3;
		}
		
		try {
			verify_cols(sudoku);
		} catch (IncorrectColException e) {
			return -4;
		}
		
		try {
			verify_sub_grid(sudoku, 1, 1);
			verify_sub_grid(sudoku, 1, 4);
			verify_sub_grid(sudoku, 1, 7);
			verify_sub_grid(sudoku, 4, 1);
			verify_sub_grid(sudoku, 4, 4);
			verify_sub_grid(sudoku, 4, 7);
			verify_sub_grid(sudoku, 7, 1);
			verify_sub_grid(sudoku, 7, 4);
			verify_sub_grid(sudoku, 7, 7);
		} catch (IncorrectSubGridException e) {
			return -2;
		}

		// returns 0 if the candidate solution is correct
		return 0;
	}
}
