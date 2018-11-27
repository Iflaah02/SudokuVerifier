import java.util.ArrayList;
import java.util.List;

public class SudokuColumnResolver implements SudokuAreaResolver {

	@Override
	public List<int[]> getAreas(Sudoku sudoku) {
		List<int[]> columns = new ArrayList<int[]>();
		
		for (int i = 0; i < 9; i++) {
			int[] column = new int[9];
			for (int j = 0; j < 9; j++) {
				column[j] = sudoku.getSudokuData()[i * 9 + j];
			}
			columns.add(column);
		}
		
		return columns;
	}

}
