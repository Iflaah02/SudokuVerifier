import java.util.HashSet;

public class SudokuVerifier {
	private String[] globalRows = new String[9];
	private String[] globalCols = new String[9];
	private String[] subGrids = new String[9];
	
	public int verify(String candidateSolution) {
		globalRows = extractGlobalRows(candidateSolution);
		int verifiedResult = 0;
		//slice 1: A cell in a Sudoku game can only store positive digits, i.e. 1...9.
		if(!containsOnlyPositiveDigits(candidateSolution)) {
			return verifiedResult = -1;
		}
		//slice 2:  All digits appear only once in a global row, i.e. they cannot repeat
		if(digitRepeatedInGlobalRow(globalRows)) {
			return verifiedResult = -3;
		}
//		//slice 3: All digits appear only once in a global column, i.e. they cannot repeat
//		if(digitRepeatedInGlobalCol(candidateSolution)) {
//			return verifiedResult = -4;
//		}
		return verifiedResult;
	}
	private String[] extractGlobalRows(String sudokuSolution) {
		String[] rows = new String[9];
		int range = 9;
		int start, end;
		for(int i = 0; i < 9; i++) {
			start = range * i;
			end = start + 9;
			rows[i] = sudokuSolution.substring(start, end);
			System.out.println(rows[i]);
		}
		return rows;
	}
	//slice 1: implement containsOnlyPositiveDigits method
	private boolean containsOnlyPositiveDigits(String sudokuSolution) {
		boolean hasPositiveDigitsOnly = true;
		for(int i = 0; i < sudokuSolution.length(); i++) {
			String aStrChar = Character.toString(sudokuSolution.charAt(i));
			try {
				Integer.parseInt(aStrChar);
			}catch(NumberFormatException e) {
				hasPositiveDigitsOnly = false;
			}
		}
		return hasPositiveDigitsOnly;
	}
	//slice 2: implement digitRepeatedInGlobalRow method
	private boolean digitRepeatedInGlobalRow(String[] sudokuSolution) {
		boolean isRepeated = false;
		for(int i = 0; i < sudokuSolution.length; i++) {
			char[] row = sudokuSolution[i].toCharArray();
			HashSet<Character> h = new HashSet<>();
			nestedLoop:
			for(int j = 0; j < row.length; j++) {
				char c = row[j];
				if(h.contains(c)) {
					isRepeated = true;
					break nestedLoop;
				} else {
					h.add(c);
				}
			}
			if(isRepeated == true)
				break;
		}
		
//		int rowLength = 9;
//		int startIndex,endIndex;
//		topLoop:
//		for(int i = 0; i < 9; i++) {
//			startIndex = rowLength * i;
//			endIndex = startIndex + 9;
//			char[] sudokuRow = sudokuSolution.substring(startIndex, endIndex).toCharArray();
//			HashSet<Character> h = new HashSet<>();
//			nestedLoop:
//			for(int j = 0; j < sudokuRow.length; j++) {
//				char c = sudokuRow[j];
//				if(h.contains(c)) {
//					isRepeated = true;
//					break nestedLoop;
//				} else {
//					h.add(c);
//				}
//			}
//			if(isRepeated == true)
//				break topLoop;
//		}
		return isRepeated;
	}
	//slice 3: implement digitRepeatedInGlobalCol method
	private boolean digitRepeatedInGlobalCol(String sudokuSolution) {
		boolean isRepeated = false;
		topLoop:
		for(int i = 0; i < 9; i++) {
			char[] sudokuCol = new char[9];
			int beginningColIndex = i;
			for(int j = 0; j < 9; j++) {
				sudokuCol[j] = sudokuSolution.charAt(beginningColIndex);
				beginningColIndex = beginningColIndex + 9;
			}
			HashSet<Character> h = new HashSet<>();
			nestedLoop:
			for(int k = 0; k < sudokuCol.length; k++) {
				char c = sudokuCol[k];
				if(h.contains(c)) {
					isRepeated = true;
					break nestedLoop;
				} else {
					h.add(c);
				}
			}
			if(isRepeated == true)
				break topLoop;
		}
		return isRepeated;
	}
}
