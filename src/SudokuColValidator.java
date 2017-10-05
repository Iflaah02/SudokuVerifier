
public class SudokuColValidator extends SudokuSetValidator{
	private static int SET_SIZE = 9;
	private static int MAX_SIZE = 81;
	
	@Override
	public SudokuState validate(String sudokuRepresentation) {
		for(int i=1; i <= SET_SIZE; i++) {
			String col = extractCol(sudokuRepresentation, i);
			if(isInvalidSet(col, SET_SIZE)) {
				return SudokuState.DUPICATE_CHAR_COL;
			}
		}
		
		return SudokuState.VALID;
	}
	
	private String extractCol(String string, int colIndex) {
		int pos = colIndex - 1;
		StringBuilder builder = new StringBuilder();
		
		while(pos < MAX_SIZE) {
			builder.append(string.charAt(pos));
			pos += SET_SIZE;
		}
		
		return builder.toString();
	}
}
