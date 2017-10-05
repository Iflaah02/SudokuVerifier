
public class SudokuRowValidator extends SudokuSetValidator {

	private static int SET_SIZE = 9;
	
	@Override
	public SudokuState validate(String sudokuRepresentation) {
		int startIndex = 0;
		int endIndex = SET_SIZE;
		
		while(endIndex <= sudokuRepresentation.length()) {
			String row = sudokuRepresentation.substring(startIndex, endIndex);
			if(isInvalidSet(row, SET_SIZE)) {
				return SudokuState.DUPLICAT_CHAR_ROW;
			}
			
			startIndex = endIndex;
			endIndex = endIndex + SET_SIZE;
		}
		
		return SudokuState.VALID;
	}

}
