
public class SudokuGridValidator extends SudokuSetValidator{
	private static int SET_SIZE = 9;
	
	@Override
	public SudokuState validate(String sudokuRepresentation) {
		for(int xIndex = 2; xIndex <= SET_SIZE; xIndex+=3) {
			for(int yIndex = 2; yIndex <= SET_SIZE; yIndex+=3) {
				String grid = extractGrid(sudokuRepresentation, xIndex, yIndex);
				if(isInvalidSet(grid, SET_SIZE)) {
					return SudokuState.DUPLICATE_CHAR_GRID;
				}
			}
		}
		
		return SudokuState.VALID;
	}
	
	private String extractGrid(String string, int centerX, int centerY) {
		StringBuilder builder = new StringBuilder();
		
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j<= 1; j++) {
				int x = centerX + i;
				int y = centerY + j;
				int pos = (y - 1) * SET_SIZE + (x-1);
				
				builder.append(string.charAt(pos));
			}
		}
		
		return builder.toString();
	}

}
