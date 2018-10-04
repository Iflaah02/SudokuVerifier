
public class SudokuVerifier {
	
	public int verify(String userSolution) {
		//Check length is exactly 81 characters long or not
		if (userSolution == null || userSolution.length() != 81)
			return -1;
		
		
		//R1: A cell in a Sudoku game can only store positive digits, i.e. 1...9.
		//Return -1: means it is violating Rule #1
		if (!userSolution.matches("[1-9]+"))
			return -1;
		
		
		//R2: All digits appear only once in a sub-grid, i.e. they cannot repeat.
		//Return -2: means it is violating Rule #2
		String[][] subGrids = new String[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				subGrids[i][j] = "";
			}
		}
		
		int a, b;
		for (int i = 0; i < userSolution.length(); i++) {
			a = Math.floorDiv((i % 9), 3);
			b = Math.floorDiv(Math.floorDiv(i, 9), 3);
			
			subGrids[a][b] = subGrids[a][b].concat(String.valueOf(userSolution.charAt(i)));
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 1; k <= 9; k++)
					subGrids[i][j] = subGrids[i][j].replaceFirst(String.valueOf(k), "");
				
				if (subGrids[i][j].length() != 0)
					return -2;
			}
		}
		
		
		//R3: A digit can appear only once in the rows of the global grid.
		//Return -3: means it is violating Rule #3
		String[] splitRows = new String[9];
		for (int i = 0; i < 9; i++) {
			splitRows[i] = userSolution.substring(i * 9, (i + 1) * 9);
			
			for (int j = 1; j <= 9; j++)
				splitRows[i] = splitRows[i].replaceFirst(String.valueOf(j), "");

			if (splitRows[i].length() != 0)
				return -3;
		}
		
		
		//R4: A digit can appear only once in the columns of the global grid.
		//Return -4: means it is violating Rule #4
		String[] splitColumns = new String[9];
		for (int i = 0; i < splitColumns.length; i++)
			splitColumns[i] = "";
		
		for (int i = 0; i < 81; i++)
			splitColumns[i % 9] = splitColumns[i % 9].concat(String.valueOf(userSolution.charAt(i)));
		
		for (int i = 0; i < splitColumns.length; i++) {
			for (int j = 1; j <= 9; j++)
				splitColumns[i] = splitColumns[i].replaceFirst(String.valueOf(j), "");
			
			if (splitColumns[i].length() != 0)
				return -4;
		}
		
		//Return 0: means it is a valid Sudoku solution
		return 0;
	}
}
