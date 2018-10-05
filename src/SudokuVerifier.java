import java.util.ArrayList;
import java.util.List;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		int r = -1;
		
		if (checkInput(candidateSolution)) {
			if (!checkRuleOne(candidateSolution)) r = -1;
			else if (!checkRuleTwo(candidateSolution)) r = -2;
			else if (!checkRuleThree(candidateSolution)) r = -3;
			else if (!checkRuleFour(candidateSolution)) r = -4;
			else r = 0;
		}
		
		// returns 0 if the candidate solution is correct
		return r;

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
		char c; String sg = "";
		String[] rows = getRows(candidateSolution);
		List<String> sgList = new ArrayList<>();

		for (int r = 0; r < 9; r++) {
			for (int i = 0; i < 3; i+=3) {
				sgList.add(rows[r].substring(i, Math.min(9, i + 3)));
			}	
		}
	
		for (int r = 0; r < 9; r++) {
			for (int i = 3; i < 6; i+=3) {
				sgList.add(rows[r].substring(i, Math.min(9, i + 3)));
			}
		}
		
		for (int r = 0; r < 9; r++) {
			for (int i = 6; i < 9; i+=3) {
				sgList.add(rows[r].substring(i, Math.min(9, i + 3)));
			}
		}
		
		List<String> cleanList = new ArrayList<>();
		for (int j = 0; j < 27; j+=3) {
			String temp = sgList.get(j) + sgList.get(j+1) + sgList.get(j+2);
			temp.replaceAll(", ", "");
			cleanList.add(temp);
		}
		for (int i = 0; i < 9; i++) {
			String x = cleanList.get(i);
			if (!uniqueCharacters(x)) return false;
		}

		return true;
	}
	
		public String[] getRows(String candidateSolution){
			List<String> rowList = new ArrayList<>();
			
			for (int i = 0; i < 81; i += 9) {
	            rowList.add(candidateSolution.substring(i, Math.min(81, i + 9)));
	        }
			
			return rowList.toArray(new String[0]);
		}
		
		public boolean uniqueCharacters(String str) 
	    {
	        for (int i = 0; i < str.length(); i++) 
	            for (int j = i + 1; j < str.length(); j++) 
	                if (str.charAt(i) == str.charAt(j)) 
	                    return false; 
	  
	        return true; 
	    } 
	public Boolean checkRuleThree(String candidateSolution) {
		//"A digit can appear only once in the rows of the global grid."
		String[] rows = getRows(candidateSolution);
		
		for (int i = 0; i < 9; i++) {
			if (!uniqueCharacters(rows[i])) return false;
		}
		return true;
	}
	
		public String[] getCols(String candidateSolution) {
			String[] rows = getRows(candidateSolution);
			List<String> colList = new ArrayList<>();
			String col = "";
			char c;
			
			for(int r = 0; r < 9; r++) {
				for (int i = 0; i < 9; i++) {
					c = rows[i].charAt(r);
					col += c;
				}
				colList.add(col);
				col = "";
			}
			return colList.toArray(new String[0]);
		}
	public Boolean checkRuleFour(String candidateSolution) {
		//"A digit can appear only once in the columns of the global grid."
		String[] cols = getCols(candidateSolution);
		
		for (int i = 0; i < 9; i++) {
			if (!uniqueCharacters(cols[i])) return false;
		}
		
		return true;
	}
}
