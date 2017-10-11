
public class SudokuVerifier {
	
	private int[][] table = new int[9][9];
	
	
	public int[][] getTable() {
		return table;
	}
	
	
	public void setTable(int[][] par) {
		table = par;
	}
	
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		//check for rule 1 
		char[] charSolution = candidateSolution.toCharArray();
		for (int i = 0; i < charSolution.length; i++)
		{
			if (Character.getNumericValue(charSolution[i]) < 1) 
			{
				return -1;
			}
			
		}
		
		//fill the sudoku grid
		initGrid(charSolution);
		
		
		int rule4 = checkColumnViolation(table);
		if (rule4 == -4)
		{
			return -4;
		}
		

		int rule3 = checkRowViolation(table);
		if (rule3 == -3)
		{
			return -3;
		}
		
		
		int rule2 = checkSubGridViolation();
		if (rule2 == -2) 
		{
			return -2;
		}
		
		return 0;
		
	}
	
	
	public int checkSubGridViolation() {
		//rule 2, not ready
		int[] subGrid = new int[9];
		int currentCol = 0; //factor goes through columns after three iterations
		
		//go through each subGridColum
		for (int subCol = 0; subCol < 3; subCol++) 
		{
			int currentRow = 3 * subCol;
			
			//go through each subgridRow
			for (int subRow = 0; subRow < 3; subRow++) 
			{	
				subGrid[subRow * 3] =  table[currentCol][currentRow];
				subGrid[(subRow * 3) + 1] = table[currentCol][currentRow + 1];
				subGrid[(subRow * 3) + 2] = table[currentCol][currentRow + 2];
				currentCol++;
			}
			
			int test = compareSubGrid(subGrid);
			
			if (test == -2) {
				return -2;
			}
		}
		
		return 0;
	}
	
	
	public int compareSubGrid(int[] grid) {
		
		//function is responsible for going through a subgrid to check if it violates rule number 2
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = 0; j < grid.length; j++) {
			
				if (i != j) {
				
					if (grid[i] == grid[j]) {
					
						return -2;
					}
				
				}
			
			}
		
		}
		
		return 0;
	}
	
	
	
	public void initGrid(char[] charSolution){
		//create 9x9 table
		int[][] tableSolution = new int[9][9];
		
		int currentNumber = 0;
		
		for (int col = 0; col < 9; col++) 
		{
			for (int row = 0; row < 9; row++) 
			{
				tableSolution[col][row] = Character.getNumericValue(charSolution[currentNumber]);						
				
				currentNumber++;
				
			}
		}
		
		setTable(tableSolution);
	}
	
	
	
	public int checkRowViolation(int[][] table) {
		//rule 3
		for (int col = 0; col < 9; col++) 
		{
			for (int rowItem = 0; rowItem < 9; rowItem++) 
			{
				for (int compItem = 0; compItem < 9; compItem++) 
				{
					if (table[col][rowItem] == table[col][compItem] && rowItem != compItem) 
					{
						return -3;
					}
				}
			}
		}
		
		return 0;
	}
	
	
	public int checkColumnViolation(int[][] table) {
		//rule4
		for (int row = 0; row < 9; row++) 
		{
			for (int colItem = 0; colItem < 9; colItem++) 
			{
				for (int compItem = 0; compItem < 9; compItem++) 
				{
					if (table[colItem][row] == table[compItem][row] && colItem != compItem) 
					{
						return -4;
					}
				}
			}
		}
		
		return 0;
	}
}
