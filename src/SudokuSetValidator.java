
public abstract class SudokuSetValidator implements SudokuValidator {

	@Override
	public abstract SudokuState validate(String sudokuRepresentation);
	
	protected boolean isInvalidSet(String string, int setSize) {
		boolean[] frequenceVector = new boolean[setSize + 1];
		char[] charArray = string.toCharArray();
		
		for(char x : charArray) {
			int pos = (x - '0');
			
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
