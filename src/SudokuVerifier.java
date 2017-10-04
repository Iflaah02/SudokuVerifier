import java.util.ArrayList;
public class SudokuVerifier {

	String sudokuString;
	
	public SudokuVerifier() {
		this.sudokuString = null;
	}
	
//1. Add method (checkOnlyPositiveDigits) to check if only positive digits exist
//2. Refactor method checkOnlyPositiveDigits with (Refactoring Type) -> new Method countWrongChars
//3. Add method to split input in rows
//4. Add method to verify that digits only appear once in a string
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		return 0;
		
		//check
	}
	
	public boolean checkOnlyPositiveDigits(String candidateSolution) {
		Integer counter = 0;
		if(candidateSolution == null || candidateSolution == "") {
			return false;
		}
		else {
			counter = countWrongChars(candidateSolution, counter);
		}
		if(counter > 0) {
				return false;
			}else {
				return true;
		}
		
	}

	private Integer countWrongChars(String candidateSolution, Integer counter) {
		for (int i = 0; i < candidateSolution.length(); i++) {
			String oneChar = String.valueOf(candidateSolution.charAt(i));
			if (!oneChar.matches("^[1-9]\\d*$")) {
				counter++;
			}
		}
		return counter;
	}
	
	public ArrayList<String> splitSudokuStringRow(String candidateSolution){
		ArrayList<String> sudokuRows = new ArrayList<String>();
		int index = 0;
		while (index < candidateSolution.length()) {
			sudokuRows.add(candidateSolution.substring(index, Math.min(index + 9,candidateSolution.length())));
		    index += 9;
		}
		return sudokuRows;
	}
	
	public boolean verifyDigitsOnce(String sudokuNumbers) {
		if(sudokuNumbers.length() != 9) {
			return false;
		}
		else {
			ArrayList<String> seenChars = new ArrayList<String>();
			for(int i = 0; i < sudokuNumbers.length(); i++) {
				String oneChar = String.valueOf(sudokuNumbers.charAt(i));
				if(!sudokuNumbers.contains(oneChar)) {
					seenChars.add(oneChar);
				}
				else {
					return false;
				}
			}
			return true;
		}
		
	}

}
