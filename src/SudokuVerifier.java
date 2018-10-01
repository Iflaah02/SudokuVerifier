import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class SudokuVerifier {
	
	private final int side = 9;
	
	public int verify(String candidateSolution) {
		
		if (candidateSolution.length() != side*side) {
			return -1; 
		}
		
		int index = 0;
		int row = 0;
		int column = 0;
	
		final List<List<Integer>> grid = new ArrayList<List<Integer>>();
				
		while (index < candidateSolution.length()) {
			
			char character = candidateSolution.charAt(index);
			row = index / side;
			column = index % side;
			
			if (column == 0) {
				grid.add(new ArrayList<Integer>());
			}
										
			if (Character.isDigit(character) == false) {
				return -1;
			} else {
				grid.get(row).add(Integer.parseInt(String.valueOf(character)));
			}
			
			index++;
		}
		
		if (checkDigitAppearOnlyOnceInSubGrids(grid) == -2) {
			return -2;
		}
		
		if (checkDigitAppearOnlyOnceInRows(grid) == -3) {
			return -3;
		}
		
		if (checkDigitAppearOnlyOnceInColumns(grid) == -4) {
			return -4;
		}
							
		return 0;
	}

	private int checkDigitAppearOnlyOnceInSubGrids(List<List<Integer>> grid) {
		
		List<List<Integer>> subGrids = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < side; i++) {
			subGrids.add(new ArrayList<Integer>());
		}
		
		for (int row = 0; row < side; ++row) {
			for (int column = 0; column < side; ++column) {
				if (column < 3 && row < 3) {
					subGrids.get(0).add(grid.get(row).get(column));
				}
				
				if (column > 2 && column < 6 && row < 3) {
					subGrids.get(1).add(grid.get(row).get(column));
				}
				
				if (column > 5 && column < side && row < 3) {
					subGrids.get(2).add(grid.get(row).get(column));
				}
				
				if (column < 3 && row > 2 && row < 6) {
					subGrids.get(3).add(grid.get(row).get(column));
				}
				
				if (column > 2 && column < 6 && row > 2 && row < 6) {
					subGrids.get(4).add(grid.get(row).get(column));
				}
				
				if (column > 5 && column < side && row > 2 && row < 6) {
					subGrids.get(5).add(grid.get(row).get(column));
				}
				
				if (column < 3 && row > 5 && row < side) {
					subGrids.get(6).add(grid.get(row).get(column));
				}
				
				if (column > 2 && column < 6 && row > 5 && row < side) {
					subGrids.get(7).add(grid.get(row).get(column));
				}
				
				if (column > 5 && column < 9 && row > 5 && row < 9) {
					subGrids.get(8).add(grid.get(row).get(column));
				}
			}
		}
		
		for (int i = 0; i < side; i++) {
			
			Collections.sort(subGrids.get(i));
			
			for (int j = 0; j < side; j++) {
				if (j < 8 && subGrids.get(i).get(j) 
						== subGrids.get(i).get(j + 1) ) {
					return -2;
				}
			}
		}
		
		return 0;
	}
 
	private int checkDigitAppearOnlyOnceInRows(List<List<Integer>> grid) {
		for (int row = 0; row < side; row++) {
			
			List<Integer> gridRow = new ArrayList<Integer>();
			
			for (int column = 0; column < side; column++) {
				gridRow.add(grid.get(row).get(column));
			}
			
			Collections.sort(gridRow);
			
			for (int column = 0; column < side; column++) {
			
				if (column < 8 && gridRow.get(column) 
						== gridRow.get(column + 1)) {
					return -3;
				}
			}
		}
		
		return 0;
	}
	
	private int checkDigitAppearOnlyOnceInColumns(List<List<Integer>> grid) {
		for (int column = 0; column < side; column++) {
			
			List<Integer> gridColumn = new ArrayList<Integer>();
			
			for (int row = 0; row < side; row++) {
				gridColumn.add(grid.get(row).get(column));
			}
			
			Collections.sort(gridColumn);
			
			for (int row = 0; row < side; row++) {
				if (row < 8 && gridColumn.get(row) == gridColumn.get(row + 1)) {
					return -4;
				}
			}
		}
		
		return 0;
	}
}
