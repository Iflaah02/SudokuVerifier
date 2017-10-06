

import java.util.Set;
import java.util.HashSet;

public class SudokuVerifierVerifyHelpers {
	public boolean duplicatesInArray(final int[] input_array) {
		Set<Integer> lump = new HashSet<Integer>();
		for (int i : input_array) {
			if (lump.contains(i))
				return true;
			lump.add(i);
		}
		return false;
	}

	public void verify_rows(int[][] sudokuGrid) throws IncorrectRowException {
		for (int i = 0; i < sudokuGrid.length; i++) {
			if (duplicatesInArray(sudokuGrid[i])) {
				throw new IncorrectRowException();
			}
		}
	}

	public void verify_cols(int[][] sudokuGrid) throws IncorrectColException {
		for (int k = 0; k < sudokuGrid.length; k++) {
			int[] tmp_array = new int[sudokuGrid[k].length];
			for (int j = 0; j < sudokuGrid[k].length; j++) {
				tmp_array[j] = sudokuGrid[k][j];
			}
			if (duplicatesInArray(tmp_array)) {
				throw new IncorrectColException();
			}
		}
	}

	public void verify_sub_grid(int[][] sudokuGrid, int start_point_row, int start_point_col)
			throws IncorrectSubGridException {
		int[] temp_array = new int[9];
		start_point_row = start_point_row - 1;
		start_point_col = start_point_col - 1;
		int end_point_row = start_point_row + 3;
		int end_point_col = start_point_col + 3;
		for (int i = start_point_row, j = 0; i < end_point_row; i++) {
			for (int k = start_point_col; k < end_point_col; k++, j++) {
				temp_array[j] = sudokuGrid[i][k];
			}
		}
		if (duplicatesInArray(temp_array)) {
			throw new IncorrectSubGridException();
		}
	}
}