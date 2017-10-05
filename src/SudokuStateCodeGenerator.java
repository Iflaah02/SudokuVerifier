
public class SudokuStateCodeGenerator {
	
	private static final int VALID_CODE = 0;
	private static final int MALFORMED_STRING_CODE = -1;
	private static final int INVALID_GRIDS_CODE = -2;
	private static final int INVALID_ROWS_CODE = -3;
	private static final int INVALID_COLS_CODE = -4;
	
	public static int getStateCode(SudokuState state) throws Exception {
		
		switch(state) {
			case VALID: return VALID_CODE;
			case INVALID_LENGHT: return MALFORMED_STRING_CODE;
			case INVALID_CHARACTERS: return MALFORMED_STRING_CODE;
			case DUPLICATE_CHAR_GRID: return INVALID_GRIDS_CODE;
			case DUPLICAT_CHAR_ROW: return INVALID_ROWS_CODE;
			case DUPICATE_CHAR_COL: return INVALID_COLS_CODE;
		}
		
		throw new Exception("Unreachable code");
	}
}
