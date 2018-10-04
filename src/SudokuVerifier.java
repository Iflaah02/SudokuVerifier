import java.util.ArrayList;
import java.util.List;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		int r = 1;
		
		if (checkInput(candidateSolution)) {
			if (!checkRuleOne(candidateSolution)) r = -1;
			else if (!checkRuleTwo(candidateSolution)) r = -2;
			else if (!checkRuleThree(candidateSolution)) r = -3;
			else if (!checkRuleFour(candidateSolution)) r = -4;
			else r = 0;
		}
		
		// returns 0 if the candidate solution is correct
		return r;
		
		//check
	}
	
	public Boolean checkInput(String candidateSolution) {
		Boolean result;
		
		if (!candidateSolution.matches("^[1-9]+$")) result = false;
		else if (candidateSolution.length() != 81) result = false;
		else result = true;
		
		return result;
	}
	
	public Boolean checkRuleOne(String candidateSolution) {
		//"A cell in a Sudoku game can only store positive digits"
		if (candidateSolution.contains("-")) return false;
		else return true;
	}
	
	public Boolean checkRuleTwo(String candidateSolution) {
		//"All digits appear only once in a sub-grid, i.e. they cannot repeat"
		
		return true;
	}
	
	public String[] extractRows(String candidateSolution){
		List<String> rowList = new ArrayList<>();
		
		for (int i = 0; i < 81; i += 9) {
            rowList.add(candidateSolution.substring(i, Math.min(81, i + 9)));
        }
		
		return rowList.toArray(new String[0]);
	}
	public boolean uniqueCharacters(String str) 
    { 
        // If at any time we encounter 2 same 
        // characters, return false 
        for (int i = 0; i < str.length(); i++) 
            for (int j = i + 1; j < str.length(); j++) 
                if (str.charAt(i) == str.charAt(j)) 
                    return false; 
  
        // If no duplicate characters encountered, 
        // return true 
        return true; 
    } 
	public Boolean checkRuleThree(String candidateSolution) {
		//"A digit can appear only once in the rows of the global grid."
		String[] rows = extractRows(candidateSolution);
		
		for (int i = 0; i < 9; i++) {
			if (!uniqueCharacters(rows[i])) return false;
		}
		return true;
	}
	
	public Boolean checkRuleFour(String candidateSolution) {
		//"A digit can appear only once in the columns of the global grid."
		
		return true;
	}
}
