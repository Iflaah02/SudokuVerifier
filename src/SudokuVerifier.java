import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SudokuVerifier {
	
	private final int side = 9;
	int row = 0;
	int column = 0;
	int registery = 0;
	
	public int verify(String candidateSolution) {
			
		final List<List<Integer>> grid = new ArrayList<List<Integer>>();

		while (registery < candidateSolution.length()) {
			
			char character = candidateSolution.charAt(registery);
			row = registery / side;
			column = registery % side;
			
			if (column == 0) {grid.add(new ArrayList<Integer>());}
										
			if (Character.isDigit(character) == false) {return -1;}
			
			else {grid.get(row).add(Integer.parseInt(String.valueOf(character)));}
			registery++;
		}
		
		if (candidateSolution.length() != side*side) {return -1;}
		
		if (checkAppearGrids(grid) == -2) {return -2;}
		
		if (checkAppearRows(grid) == -3) {return -3;}
		
		if (checkAppearColumns(grid) == -4) {return -4;}						
		return 0;
	}
 
	private int checkAppearRows(List<List<Integer>> grid) {
		for (int row = 0; row < side; row++) {
			
			List<Integer> Rows = new ArrayList<Integer>();
			
			for (int column = 0; column < side; column++) {
			Rows.add(grid.get(row).get(column));
			}
			
			Collections.sort(Rows);
			
			for (int column = 0; column < side; column++) {
			
				if (column < 8 && Rows.get(column) == Rows.get(column + 1)) {
				return -3;
				}
			}
		}
		
		return 0;
	}
	
	private int checkAppearColumns(List<List<Integer>> grid) {
		for (int column = 0; column < side; column++) {
			
			List<Integer> Columns = new ArrayList<Integer>();
			
			for (int row = 0; row < side; row++) {
			Columns.add(grid.get(row).get(column));
			}
			
			Collections.sort(Columns);
			
			for (int row = 0; row < side; row++) {
				if (row < 8 && Columns.get(row) == Columns.get(row + 1)) {
				return -4;
				}
			}
		}
		
		return 0;
	}
	private int checkAppearGrids(List<List<Integer>> grid) {
		
		List<List<Integer>> Grids = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < side; i++) {
			Grids.add(new ArrayList<Integer>());
		}
		
		for (int row = 0; row < side; ++row) {
			for (int column = 0; column < side; ++column) {
				if (column < 3 && row < 3) {
				Grids.get(0).add(grid.get(row).get(column));
				}
				
				if (column > 2 && column < 6 && row < 3) {
				Grids.get(1).add(grid.get(row).get(column));
				}
				
				if (column > 5 && column < side && row < 3) {
				Grids.get(2).add(grid.get(row).get(column));
				}
				
				if (column < 3 && row > 2 && row < 6) {
				Grids.get(3).add(grid.get(row).get(column));
				}
				
				if (column > 2 && column < 6 && row > 2 && row < 6) {
				Grids.get(4).add(grid.get(row).get(column));
				}
				
				if (column > 5 && column < side && row > 2 && row < 6) {
				Grids.get(5).add(grid.get(row).get(column));
				}
				
				if (column < 3 && row > 5 && row < side) {
				Grids.get(6).add(grid.get(row).get(column));
				}
				
				if (column > 2 && column < 6 && row > 5 && row < side) {
				Grids.get(7).add(grid.get(row).get(column));
				}
				
				if (column > 5 && column < 9 && row > 5 && row < 9) {
				Grids.get(8).add(grid.get(row).get(column));
				}
			}
		}
		
		for (int x = 0; x < side; x++) {
			
			Collections.sort(Grids.get(x));
			
			for (int y = 0; y < side; y++) {
				if (y < 8 && Grids.get(x).get(y) == Grids.get(x).get(y + 1) ) {
				return -2;
				}
			}
		}
		return 0;
	}
}