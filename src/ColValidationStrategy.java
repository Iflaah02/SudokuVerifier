import java.util.List;

public class ColValidationStrategy implements BoardValidationStrategy {

	public List<List<Integer>> getSetList(SudokuBoard board) {
		return board.getCols();
	}

	public SudokuState getErrorState() {
		return SudokuState.DUPICATE_CHAR_COL;
	}
}
