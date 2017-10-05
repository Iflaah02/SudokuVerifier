import java.util.List;

public class RowValidationStrategy implements BoardValidationStrategy {

	public List<List<Integer>> getSetList(SudokuBoard board) {
		return board.getRows();
	}

	public SudokuState getErrorState() {
		return SudokuState.DUPLICAT_CHAR_ROW;
	}
}
