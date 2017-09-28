
public class SudokuVerifier {
	
	private static int MAX_SIZE = 81;
	private static int SET_SIZE = 9;
	
	public int verify(String candidateSolution) {
		if(hasInvalidNumberOfCharacters(candidateSolution) || hasInvalidCharacters(candidateSolution)) {
			return -1;
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
}
