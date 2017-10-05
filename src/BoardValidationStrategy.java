import java.util.List;

public interface BoardValidationStrategy {
	public List<List<Integer>> getSetList(SudokuBoard board);

	public SudokuState getErrorState();
}
