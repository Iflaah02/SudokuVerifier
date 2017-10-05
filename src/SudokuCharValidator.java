
public class SudokuCharValidator implements SudokuValidator {

	private static char MIN_CHAR = '1';
	private static char MAX_CHAR = '9';
	
	@Override
	public SudokuState validate(String sudokuRepresentation) {
		char[] charArray = sudokuRepresentation.toCharArray();
		
		for(char x : charArray) {
			if( x < MIN_CHAR || x > MAX_CHAR) {
				return SudokuState.INVALID_CHARACTERS;
			}
		}
		
		return SudokuState.VALID;
	}

}
