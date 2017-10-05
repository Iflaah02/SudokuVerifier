import java.util.LinkedList;
import java.util.List;

public class SudokuVerifier {
	
	private List<SudokuInputValidator> inputValidatorList;
	private List<SudokuBoardValidator> boardValidatorList;
	
	public SudokuVerifier() {
		inputValidatorList = new LinkedList<SudokuInputValidator>();
		inputValidatorList.add(new SudokuLengthValidator());
		inputValidatorList.add(new SudokuCharValidator());
		
		boardValidatorList = new LinkedList<SudokuBoardValidator>();
		boardValidatorList.add(new SudokuBoardValidator(new GridValidationStrategy()));
		boardValidatorList.add(new SudokuBoardValidator(new RowValidationStrategy()));
		boardValidatorList.add(new SudokuBoardValidator(new ColValidationStrategy()));
	}
	
	public int verify(String candidateSolution) throws Exception {
		SudokuState state = validateInputString(candidateSolution);
		
		//Create board and validate against Sudoku rules
		if(state == SudokuState.VALID) {
			SudokuBoard board = new SudokuBoard(candidateSolution);
			state = validateBoard(board);
		}
			
		return SudokuStateCodeGenerator.getStateCode(state);
	}
	
	private SudokuState validateInputString(String candidateSolution) {		
		SudokuState state = SudokuState.VALID;
	
		//Validate the input string to contain correct characters and be of right length
		for(int i = 0; i < inputValidatorList.size() && state == SudokuState.VALID; i++) {
			SudokuInputValidator validator = inputValidatorList.get(i);
			state = validator.validate(candidateSolution);
		}
		
		return state;
	}
	
	private SudokuState validateBoard(SudokuBoard board) {
		SudokuState state = SudokuState.VALID;
		
		for(int i = 0; i < boardValidatorList.size() && state == SudokuState.VALID; i++) {
			SudokuBoardValidator validator = boardValidatorList.get(i);
			state = validator.validate(board);
		}
		
		return state;
	}
}
