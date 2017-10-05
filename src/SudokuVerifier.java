import java.util.LinkedList;
import java.util.List;

public class SudokuVerifier {
	
	private List<SudokuValidator> validatorList;
	
	public SudokuVerifier() {
		validatorList = new LinkedList<SudokuValidator>();
		
		validatorList.add(new SudokuLengthValidator());
		validatorList.add(new SudokuCharValidator());
		validatorList.add(new SudokuGridValidator());
		validatorList.add(new SudokuRowValidator());
		validatorList.add(new SudokuColValidator());
	}
	
	public int verify(String candidateSolution) throws Exception {
		SudokuState state = SudokuState.VALID;
		
		for(int i = 0; i < validatorList.size() && state == SudokuState.VALID; i++) {
			SudokuValidator validator = validatorList.get(i);
			state = validator.validate(candidateSolution);
		}
		
		return SudokuStateCodeGenerator.getStateCode(state);
	}
}
