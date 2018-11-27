import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SudokuVerifier {
	
	private static final int GRID_SIDE = 9;
	private static final int SUB_GRID_SIDE = GRID_SIDE / 3;
	
	public int verify(String sudokuNumbers) {
		
		if (sudokuNumbers.length() != GRID_SIDE*GRID_SIDE) {
			return -1; 
		}
		
		int index = 0;
		int row = 0;
		int column = 0;
	
		final List<List<Integer>> grid = new ArrayList<List<Integer>>();
				
		while (index < sudokuNumbers.length()) {
			
			char character = sudokuNumbers.charAt(index);
			row = index / GRID_SIDE;
			column = index % GRID_SIDE;
			
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
		
		if (checkDigitAppearOnlyOnceInSubGrids(grid) != 0) {
			return -2;
		}

		if (checkDigitAppearOnlyOnceInLine(grid, true) != 0) {
			return -3;
		}

		if (checkDigitAppearOnlyOnceInLine(grid, false) != 0) {
			return -4;
		}
							
		return 0;
	}
	
	private int checkDigitAppearOnlyOnceInSubGrids(List<List<Integer>> grid) {
		
		List<List<Integer>> subGrids = fillSubGrids(grid);
		
		for (int i = 0; i < GRID_SIDE; ++i) {
			if (containSameNumbers(subGrids.get(0)) != 0) {
				return -2;
			}
		}
		
		return 0;
	}

	private int containSameNumbers(List<Integer> list) {
					
		Collections.sort(list);
		
		for (int i = 0; i < GRID_SIDE; ++i) {
			if (i < GRID_SIDE - 1 && list.get(i) 
					== list.get(i + 1)) {
				return -1;
			}
		}
			
		return 0;
	}
	
	private List<List<Integer>> fillSubGrids(List<List<Integer>> grid) {
		
		List<List<Integer>> subGrids = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < GRID_SIDE; i++) {
			subGrids.add(new ArrayList<Integer>());
		}
		
		for (int row = 0; row < GRID_SIDE; ++row) {
			for (int column = 0; column < GRID_SIDE; ++column) {
				if (column < SUB_GRID_SIDE && row < SUB_GRID_SIDE) {
					subGrids.get(0).add(grid.get(row).get(column));
				} else if (column > SUB_GRID_SIDE - 1 && column < (SUB_GRID_SIDE * 2) && row < SUB_GRID_SIDE) {
					subGrids.get(1).add(grid.get(row).get(column));
				} else if (column > (SUB_GRID_SIDE * 2) - 1 && column < GRID_SIDE && row < SUB_GRID_SIDE) {
					subGrids.get(2).add(grid.get(row).get(column));
				} else if (column < SUB_GRID_SIDE && row > SUB_GRID_SIDE - 1 && row < (SUB_GRID_SIDE * 2)) {
					subGrids.get(3).add(grid.get(row).get(column));
				} else if (column > SUB_GRID_SIDE - 1 && column < (SUB_GRID_SIDE * 2) && row > SUB_GRID_SIDE - 1 && row < (SUB_GRID_SIDE * 2)) {
					subGrids.get(4).add(grid.get(row).get(column));
				} else if (column > (SUB_GRID_SIDE * 2) - 1 && column < GRID_SIDE && row > SUB_GRID_SIDE - 1 && row < (SUB_GRID_SIDE * 2)) {
					subGrids.get(5).add(grid.get(row).get(column));
				} else if (column < SUB_GRID_SIDE && row > (SUB_GRID_SIDE * 2) - 1 && row < GRID_SIDE) {
					subGrids.get(6).add(grid.get(row).get(column));
				} else if (column > SUB_GRID_SIDE - 1 && column < (SUB_GRID_SIDE * 2) && row > (SUB_GRID_SIDE * 2) - 1 && row < GRID_SIDE) {
					subGrids.get(7).add(grid.get(row).get(column));
				} else if (column > (SUB_GRID_SIDE * 2) - 1 && column < GRID_SIDE && row > (SUB_GRID_SIDE * 2) - 1 && row < GRID_SIDE) {
					subGrids.get(8).add(grid.get(row).get(column));
				}
			}
		}
		
		return subGrids;
	}
	
	private int checkDigitAppearOnlyOnceInLine(List<List<Integer>> grid, boolean lineIsRow) {
		
		List<Integer> line = new ArrayList<Integer>();
		
		for (int i = 0; i < GRID_SIDE; ++i) {
			for (int j = 0; j < GRID_SIDE; ++j) {
				if (lineIsRow) {
					line.add(grid.get(i).get(j));
				} else {
					line.add(grid.get(j).get(i));
				}
			}
			
			if (containSameNumbers(line) != 0) {
				if (lineIsRow) {
					return -3;
				} else {
					return -4;
				}
			}
			
			line.clear();
		}
		
		return 0;
	}
}
