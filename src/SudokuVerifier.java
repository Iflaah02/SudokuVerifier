
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		//check for rule 1 
		char[] charSolution = candidateSolution.toCharArray();
		for (int i = 0; i < charSolution.length; i++) {
			if (Character.getNumericValue(charSolution[i]) < 1) {
				return -1;
			}
		}
		//create 9x9 table
		int[][] table = new int[9][9];
		int currentNumber = 0;
		for (int col = 0; col < 9; col++) {
			
			for (int row = 0; row < 9; row++) {
				table[col][row] = Character.getNumericValue(charSolution[currentNumber]);
				currentNumber++;
			}
		}
		
		//check for rule 3 (rows):
		checkRowViolation(table);
		
		return 0;
		
		//check
	}
	
	public int checkRowViolation(int[][] table) {
		//rule 3
		for (int col = 0; col < 9; col++) {
			for (int rowItem = 0; rowItem < 9; rowItem++) {
				for (int compItem = 0; compItem < 9; compItem++) {
					if (table[col][rowItem] == table[col][compItem] && rowItem != compItem) {
						return -3;
					}
				}
			}
		}
		return 0;
	}
	
}
