import java.util.ArrayList;
import java.util.List;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		if (!checkSolutionContainsOnlyPositiveDigits(candidateSolution))
			return -1;
		else if (!checkSolutionContainsEachDigitOnlyOnceInASubGrid(candidateSolution))
			return -2;
		else if (!checkSolutionContainsEachDigitOnlyOnceInAGlobalRow(candidateSolution))
			return -3;
		else if (!checkSolutionContainsEachDigitOnlyOnceInAGlobalColumn(candidateSolution))
			return -4;
		
		
		return 0;
	}
	
	// Check that a String contains only digits 1-9
	private boolean checkSolutionContainsOnlyPositiveDigits(String candidateSolution) {
		return candidateSolution.matches("[1-9]+");
	}
	
	private boolean checkSolutionContainsEachDigitOnlyOnceInASubGrid(String candidateSolution) {
		List<String> rows = getRows(candidateSolution);
		List<String> subgrids = new ArrayList<String>();
		
		for (int i = 0; i < rows.size(); ++i) {
			StringBuilder subgrid1 = new StringBuilder();
			StringBuilder subgrid2 = new StringBuilder();
			StringBuilder subgrid3 = new StringBuilder();
			StringBuilder subgrid4 = new StringBuilder();
			StringBuilder subgrid5 = new StringBuilder();
			StringBuilder subgrid6 = new StringBuilder();
			StringBuilder subgrid7 = new StringBuilder();
			StringBuilder subgrid8 = new StringBuilder();
			StringBuilder subgrid9 = new StringBuilder();
			
			for (int j = 0; j < 9; ++j) {
				if (i < 3) {
					if (j < 3)
						subgrid1.append(candidateSolution.charAt((i*8)*j));
					else if (j < 6)
						subgrid2.append(candidateSolution.charAt((i*8)*j));
					else
						subgrid3.append(candidateSolution.charAt((i*8)*j));
				}
				else if (i < 6) {
					if (j < 3)
						subgrid4.append(candidateSolution.charAt((i*8)*j));
					else if (j < 6)
						subgrid5.append(candidateSolution.charAt((i*8)*j));
					else
						subgrid6.append(candidateSolution.charAt((i*8)*j));
				}
				else {
					if (j < 3)
						subgrid7.append(candidateSolution.charAt((i*8)*j));
					else if (j < 6)
						subgrid8.append(candidateSolution.charAt((i*8)*j));
					else
						subgrid9.append(candidateSolution.charAt((i*8)*j));
				}
			}
			
			subgrids.add(new String(subgrid1));
			subgrids.add(new String(subgrid2));
			subgrids.add(new String(subgrid3));
			subgrids.add(new String(subgrid4));
			subgrids.add(new String(subgrid5));
			subgrids.add(new String(subgrid6));
			subgrids.add(new String(subgrid7));
			subgrids.add(new String(subgrid8));
			subgrids.add(new String(subgrid9));
		}
		
		for (String subgrid : subgrids) {
			if (!checkEachDigitOccursOnce(subgrid))
				return false;
		}
		
		return true;
	}
	
	private boolean checkSolutionContainsEachDigitOnlyOnceInAGlobalRow(String candidateSolution) {
		List<String> rows = getRows(candidateSolution);
		
		for (String row : rows) {
			if (!checkEachDigitOccursOnce(row))
				return false;
		}
		
		return true;
	}
	
	private boolean checkSolutionContainsEachDigitOnlyOnceInAGlobalColumn(String candidateSolution) {
		List<String> rows = getRows(candidateSolution);
		List<String> columns = new ArrayList<String>();
		
		for (int i = 0; i < 9; ++i) {
			StringBuilder temp = new StringBuilder();
			
			for (String row : rows) {
				temp.append(row.charAt(i));
			}
			
			columns.add(new String(temp));
		}
		
		for (String column : columns) {
			if (!checkEachDigitOccursOnce(column))
				return false;
		}
		
		return true;
	}
	
	private List<String> getRows(String candidateSolution) {
		List<String> rows = new ArrayList<String>();
		int i = 0;
		
		while (i < candidateSolution.length()) {
			rows.add(candidateSolution.substring(i, i+9));
			i += 9;
		}
		
		return rows;
	}
	
	private boolean checkEachDigitOccursOnce(String line) {
		String[] digits = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		for (int i = 0; i < digits.length; ++i) {
			int occurences = line.length() - line.replace(digits[i], "").length();
			
			if (occurences != 1)
				return false;
		}
		
		return true;
	}
}
