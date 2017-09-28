public class SudokuVerifier {
	
	private static int MAX_SIZE = 81;
	private static int SET_SIZE = 9;
	
	public int verify(String candidateSolution) {
		if(hasInvalidNumberOfCharacters(candidateSolution) || hasInvalidCharacters(candidateSolution)) {
			return -1;
		}
		else if(hasInvalidRows(candidateSolution)) {
			return -3;
		}
		else if(hasInvalidCols(candidateSolution)) {
			return -4;
		}
		
		return 0;
	}
	
	private boolean hasInvalidNumberOfCharacters(String string) {
		if(string.length() != MAX_SIZE) {
			return true;
		}
		
		return false;
	}
	
	private boolean hasInvalidCharacters(String string) {
		char[] charArray = string.toCharArray();
		
		for(char x : charArray) {
			if( x < '1' || x > Character.forDigit(SET_SIZE, 10)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean hasInvalidRows(String string) {
		int startIndex = 0;
		int endIndex = SET_SIZE;
		
		while(endIndex <= string.length()) {
			String row = string.substring(startIndex, endIndex);
			if(isInvalidSet(row)) {
				return true;
			}
			
			startIndex = endIndex;
			endIndex = endIndex + SET_SIZE;
		}
		
		return false;
	}
	
	private boolean hasInvalidCols(String string) {
		for(int i=1; i <= SET_SIZE; i++) {
			String col = extractCol(string, i);
			if(isInvalidSet(col)) {
				return true;
			}
		}
		
		return false;
	}

	private boolean isInvalidSet(String string) {
		boolean[] frequenceVector = new boolean[SET_SIZE + 1];
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
