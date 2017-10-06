import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuVerifier {
	
	private SudokuVerifierVerifyHelpers sudokuVerifierVerifyHelpers = new SudokuVerifierVerifyHelpers();
	private static int INPUT_LENGTH = 81;
	private int[][] sudoku;
	
	protected void validate_input_length(String input_string) throws IncorrectLengthException {
		if(input_string.length() != INPUT_LENGTH) {
			throw new IncorrectLengthException();
		}
	}
	
	protected void validate_input_contains_positive_integers(String input_string) throws NotOnlyIntegersException {
		if(!input_string.matches("[0-9]+")) {
			throw new NotOnlyIntegersException();
		}
	}
	
	protected int[] string_array_to_int_array(String input_string) throws NotOnlyIntegersException, IncorrectLengthException {
		validate_input_length(input_string);
		validate_input_contains_positive_integers(input_string);
		
		String[] stringInputArray = input_string.split("");
		int[] intInputArray = Arrays.asList(stringInputArray).stream().mapToInt(Integer::parseInt).toArray();
		
		return intInputArray;
	}
	
	protected int[][] make_sudoku_grid(String input_string) throws IncorrectLengthException, NotOnlyIntegersException {
		
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
	
	protected boolean duplicatesInArray(final int[] input_array) {
		return sudokuVerifierVerifyHelpers.duplicatesInArray(input_array);
	}
	
	protected void verify_rows(int[][] sudokuGrid) throws IncorrectRowException {
		sudokuVerifierVerifyHelpers.verify_rows(sudokuGrid);
	}
	
	protected void verify_cols(int[][] sudokuGrid) throws IncorrectColException {
		sudokuVerifierVerifyHelpers.verify_cols(sudokuGrid);
	}
	
	protected void verify_sub_grid(int[][] sudokuGrid, int start_point_row, int start_point_col) throws IncorrectSubGridException {
		sudokuVerifierVerifyHelpers.verify_sub_grid(sudokuGrid, start_point_row, start_point_col);
	}
	
	public int verify(String candidateSolution) {
		
		try {
			sudoku = make_sudoku_grid(candidateSolution);
		} catch (IncorrectLengthException | NotOnlyIntegersException e) {
			return -1;
		}
		
		try {
			sudokuVerifierVerifyHelpers.verify_rows(sudoku);
		} catch (IncorrectRowException e) {
			return -3;
		}
		
		try {
			sudokuVerifierVerifyHelpers.verify_cols(sudoku);
		} catch (IncorrectColException e) {
			return -4;
		}
		
		try {
			sudokuVerifierVerifyHelpers.verify_sub_grid(sudoku, 1, 1);
			sudokuVerifierVerifyHelpers.verify_sub_grid(sudoku, 1, 4);
			sudokuVerifierVerifyHelpers.verify_sub_grid(sudoku, 1, 7);
			sudokuVerifierVerifyHelpers.verify_sub_grid(sudoku, 4, 1);
			sudokuVerifierVerifyHelpers.verify_sub_grid(sudoku, 4, 4);
			sudokuVerifierVerifyHelpers.verify_sub_grid(sudoku, 4, 7);
			sudokuVerifierVerifyHelpers.verify_sub_grid(sudoku, 7, 1);
			sudokuVerifierVerifyHelpers.verify_sub_grid(sudoku, 7, 4);
			sudokuVerifierVerifyHelpers.verify_sub_grid(sudoku, 7, 7);
		} catch (IncorrectSubGridException e) {
			return -2;
		}

		// returns 0 if the candidate solution is correct
		return 0;
	}
}
