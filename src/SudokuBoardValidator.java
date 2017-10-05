import java.util.List;

public class SudokuBoardValidator {

	private BoardValidationStrategy strategy;
	
	public SudokuBoardValidator(BoardValidationStrategy strategy) {
		this.strategy = strategy;
	}
	
	public SudokuState validate(SudokuBoard sudokuBoard) {
		List<List<Integer>> setList = strategy.getSetList(sudokuBoard);
		
		for(List<Integer> x : setList) {
			if(isInvalidSet(x)) {
				return strategy.getErrorState();
			}
		}
		
		return SudokuState.VALID;
	}

	
	protected boolean isInvalidSet(List<Integer> set) {
		boolean[] frequenceVector = new boolean[set.size() + 1];
		
		for(Integer x : set) {
			int pos = x;
			
			if(frequenceVector[pos] == true) {
				return true;
			}
			else {
				frequenceVector[pos] = true;
			}
		}
		
		return false;
	}
	}
