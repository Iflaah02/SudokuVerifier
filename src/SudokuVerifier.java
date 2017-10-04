import java.util.ArrayList;
public class SudokuVerifier {

	String sudokuString;
	
	public SudokuVerifier() {
		this.sudokuString = null;
	}
	
//1. Add method (checkOnlyPositiveDigits) to check if only positive digits exist
//2. Refactor method checkOnlyPositiveDigits with Extraxt Method Refactoring type -> new Method countWrongChars
//3. Add method to split input in rows
//4. Refactor -> nothing found for 
//5. Add method to verify that digits only appear once in a string
//6. Refactor -> nothing found
//7. Add method to split input in columns
//8. Refactor -> nothing found
//9. 7. Add method to split input in sub grid
//10. Refactor:
//Methods splitSudokuStringColumn and splitSudokuStringSubGrid are very similar, but there is a little bit more
//logic in splitSudokuStringSubGrid. Maybe we could use the Parametrize Method to make one method of these two
//and use parameter for the values how to split the Sodokusolution-String. However, I could not manage this in time.
//11. Add method to validate whole Sudoku field for digits only once
//12. Add logic for verify method
	
	public int verify(String candidateSolution) {
		
		
		if(!checkOnlyPositiveDigits(candidateSolution)){
			return -1;
		}
		else if (!verifyDigitsOnceAll(splitSudokuStringSubgrid(candidateSolution))){
			return -2;
		}
		else if (!verifyDigitsOnceAll(splitSudokuStringRow(candidateSolution))){
			return -3;
		}
		else if (!verifyDigitsOnceAll(splitSudokuStringColumn(candidateSolution))){
			return -4;
		}
		else {
			// returns 0 if the candidate solution is correct
			return 0;		
		}
	}
	
	public boolean verifyDigitsOnceAll(ArrayList<String> sudokuInput){
		for(int i = 0; i<sudokuInput.size(); i++){
			if(!verifyDigitsOnce(sudokuInput.get(i))){
				return false;
			}
		}
		return true;
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
	public ArrayList<String> splitSudokuStringColumn (String candidateSolution){
		ArrayList<String> sudokuColumns = new ArrayList<String>();
		int global_index = 0;
		for(int i = 0;i<9;i++){
			StringBuilder temp = new StringBuilder();
			int internal_index = global_index;
			for(int j = 0;j<9;j++){
				temp.append(candidateSolution.substring(internal_index,internal_index+1));
				internal_index += 9;
			}
			sudokuColumns.add(temp.toString());
			global_index++;
		}
		
		return sudokuColumns;
	}
	
	public ArrayList<String> splitSudokuStringSubgrid (String candidateSolution){
		ArrayList<String> sudokSubgrid = new ArrayList<String>();
		int global_index = 0;
		int roundcounter = 0;
		for(int i = 0;i<9;i++){
			StringBuilder temp = new StringBuilder();
			int internal_index = global_index;
			for(int j = 0;j<3;j++){
				temp.append(candidateSolution.substring(internal_index,internal_index+3));
				internal_index += 9;
			}
			sudokSubgrid.add(temp.toString());
			roundcounter++;
			if(roundcounter%3==0){
				global_index+=21;
			}
			else global_index+=3;
		}
		return sudokSubgrid;
	}
	
	public boolean verifyDigitsOnce(String sudokuNumbers) {
		if(sudokuNumbers.length() != 9) {
			return false;
		}
		else {
			ArrayList<String> seenChars = new ArrayList<String>();
			for(int i = 0; i < sudokuNumbers.length(); i++) {
				String oneChar = String.valueOf(sudokuNumbers.charAt(i));
				if(!seenChars.contains(oneChar)) {
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
