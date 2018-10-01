
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		
		boolean result = true;
		
		boolean sudokuFormat = true;
		sudokuFormat = correctFormat(candidateSolution);
		
		if(sudokuFormat == true) {
		
			result = positive(candidateSolution);
		
			if(result == false ) {
				return -1;
			}
		
			result = row(candidateSolution);
		
			if (result == false) {
				return -3;
			}
		
			result = column(candidateSolution);
		
			if (result == false) {
				return -4;
			}
		
			result = grid(candidateSolution);
		
			if(result == false ) {
				return -2;
			}
		}
		
		return 0;

	}
	
	public boolean positive(String candidateSolution) {
		
		for(int i = 0; i < candidateSolution.length(); i++) {
            if(candidateSolution.charAt(i) == '-') {
            	return false;
            }
		}
		
		return true;
	}
	
	public boolean grid(String candidateSolution) {
		
		int[] numbersInGrid = new int[9];
		
		for(int i = 0; i < 55; i = i + 27) {
			
			for (int j = i; j < i + 9; j = j + 3 ) {
				
				int n = 0;
				
				for (int k = j; k < j + 27; k = k + 9) {
					
					for (int l = k; l < k + 3; l++) {
						numbersInGrid[n] = Character.getNumericValue(candidateSolution.charAt(l));
						n = n + 1;
					}
				}
				
				for (int m = 0; m < 9; m++) {
					for (int o = m + 1; o < 9; o++) {
						if(numbersInGrid[m] == numbersInGrid[o]) {
							return false;
						}
					}
					
				}
				
				n = 0;
			}
		
		}
		
		return true;
	}
	
	
	public boolean row(String candidateSolution) {
		
		for(int i = 0; i < 9; i++) {
			
			int k = i * 9;
			for (int j = k; j < k + 9; j++) {
				for (int l = j + 1; l < k + 9; l++ ) {
					if(candidateSolution.charAt(j) == candidateSolution.charAt(l)) {
						return false;
					}
				}
			}
		
		}
		
		return true;
	}
	
	public boolean column(String candidateSolution) {
		
		for(int i = 0; i < 9; i++) {
			
			for (int j = i; j < 73 + i; j = j + 9) {
				for (int l = j + 9; l < 73 + i; l = l + 9 ) {
					if(candidateSolution.charAt(j) == candidateSolution.charAt(l)) {
						return false;
					}
				}
			}
		
		}
		
		return true;
	}
	
	public boolean correctFormat(String candidateSolution) {
		int stringLength = candidateSolution.length();
		
		if (stringLength == 81) {
			return true;
		}
		
		return false;
	}
}
