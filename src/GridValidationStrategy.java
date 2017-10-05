import java.util.List;

public class GridValidationStrategy implements BoardValidationStrategy {
	
	public List<List<Integer>> getSetList(SudokuBoard board) {
		return board.getGrids();
	}

	public SudokuState getErrorState() {
		return SudokuState.DUPLICATE_CHAR_GRID;
	}
}
