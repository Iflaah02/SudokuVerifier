
public class SudokuVerifier {
	
	public int verify(String solution) {
		
		if (!isGridValid(solution))   return -1;
		if (!checkSubGrids(solution)) return -2;
		if (!checkRows(solution))     return -3;
		if (!checkColumns(solution))  return -4;
		
		return 0;
		
	}
	
	public boolean isGridValid(String solution) {
		
		if (solution.length() != 9*9) return false;
		
		for (int i=0; i<solution.length(); ++i) {
			if (isCharacterValid(solution.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isCharacterValid(char c) {
		if (Character.isDigit(c) == false) {
			return false;
		} else if (c == '0') {
			return false;
		}
		return true;
	}
	
	public boolean checkColumns(String solution) {
		
		for (int columnIndex=0; columnIndex<9; ++columnIndex) {
			String column = column(solution, columnIndex);
			
			if (onlyUniqueCharacters(column) == false) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean checkRows(String solution) {
		
		for (int rowIndex=0; rowIndex<9; ++rowIndex) {
			String row = row(solution, rowIndex);
			
			if (onlyUniqueCharacters(row) == false) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean checkSubGrids(String solution) {
		
		for (int subGridIndex=0; subGridIndex<9; ++subGridIndex) {
			String subGrid = subGrid(solution, subGridIndex);
			
			if (onlyUniqueCharacters(subGrid) == false) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public boolean onlyUniqueCharacters(String str) {
		
		String usedCharacters = new String();
		
		for (int i=0; i<str.length(); ++i) {
			String c = str.substring(i, i+1);
			if (usedCharacters.contains(c)) {
				return false;
			}
			usedCharacters += c;
		}
		
		return true;
		
	}
	
	public String subGrid(String solution, int subgridIndex) {
		

		Coordinates gridCoord = new Coordinates((subgridIndex % 3) * 3, (subgridIndex / 3) * 3);
		int startIndex = gridCoord.sudokuIndex();
		
		String subGrid = new String();
		
		for (int i=0; i<9; ++i) {
			Coordinates subCoord = new Coordinates(i % 3, i / 3);
			
			int charIndex = startIndex + subCoord.sudokuIndex();
			
			subGrid += solution.charAt(charIndex);
		}
		
		return subGrid;
		
	}
	
	public String row(String solution, int rowIndex) {
		
		int startIndex = rowIndex * 9;
		int endIndex = startIndex + 9;
		
		return solution.substring(startIndex, endIndex);
		
	}
	
	public String column(String solution, int columnIndex) {
		
		String column = new String();
		
		for (int row=0; row<9; ++row) {
			Coordinates coords = new Coordinates(columnIndex, row);
			int charIndex = coords.sudokuIndex();
			column += solution.charAt(charIndex);
		}
		
		return column;
		
	}
}

