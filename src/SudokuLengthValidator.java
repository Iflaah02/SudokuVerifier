
public class SudokuLengthValidator implements SudokuInputValidator{

	private static int ALLOWED_LENGTH = 81;
	
	/*public SudokuLengthValidator(int allowedLength) {
		this.allowedLength = allowedLength;
	}*/
	
	@Override
	public SudokuState validate(String sudokuRepresentation) {
		if(sudokuRepresentation.length() != ALLOWED_LENGTH) {
			return SudokuState.INVALID_LENGHT;
		}
		
		return SudokuState.VALID;
	}
	
}
