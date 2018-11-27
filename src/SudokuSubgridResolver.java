import java.util.ArrayList;
import java.util.List;

public class SudokuSubgridResolver implements SudokuAreaResolver {

	@Override
	public List<int[]> getAreas(Sudoku sudoku) {
		List<int[]> subgrids = new ArrayList<int[]>();
		
		for (int i1 = 0; i1 < 3; i1++)
		for (int i2 = 0; i2 < 3; i2++) {
			int[] subgrid = new int[9];
			
			for (int j1 = 0; j1 < 3; j1++)
			for (int j2 = 0; j2 < 3; j2++) {
				subgrid[j1 * 3 + j2] = sudoku.getSudokuData()[i1 * 27 + i2 * 3 + j1 * 9 + j2];
			}
			
			subgrids.add(subgrid);
		}
		
		return subgrids;
	}

}
