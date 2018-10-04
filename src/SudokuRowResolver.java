import java.util.ArrayList;
import java.util.List;

public class SudokuRowResolver implements SudokuAreaResolver {

	@Override
	public List<int[]> getAreas(Sudoku sudoku) {
		List<int[]> rows = new ArrayList<int[]>();
		
		for (int i = 0; i < 9; i++) {
			int[] row = new int[9];
			for (int j = 0; j < 9; j++) {
				row[j] = sudoku.getSudokuData()[i * 9 + j];
			}
			rows.add(row);
		}
		
		return rows;
	}

}
