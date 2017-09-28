
public class SudokuVerifier {
	
	private int rows;
	private int cols;
	private int squareDim;
	
	public SudokuVerifier(int rows, int cols, int squareDim) {
		this.rows = rows;
		this.cols = cols;
		this.squareDim = squareDim;
	}
	
	public int verify(String candidateSolution) {
		if(hasInvalidNumberOfCharacters(candidateSolution) || hasInvalidCharacters(candidateSolution)) {
			return -1;
		}
		
		return 0;
	}
	
	private boolean hasInvalidNumberOfCharacters(String string) {
		int expectedStringLength = rows * cols;
		
		if(string.length() != expectedStringLength) {
			return true;
		}
		
		return false;
	}
	
	private boolean hasInvalidCharacters(String string) {
		char[] charArray = string.toCharArray();
		
		for(char x : charArray) {
			if( x < '0' || x > '9') {
				return true;
			}
		}
		
		return false;
	}
}
