
public class SudokuVerifier {
	private int[] col = new int[9];
	private int[][] sudoku = new int[9][9];
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		
		//table for sudoku solution, should make it easier to go through rows and columns
		
		if (sizeChecker(candidateSolution)) {
			int x = 0;
			int y = 0;
			int z = 0;
			
			//here we fill the sudoku table with numbers from candidateSolution
			while (y < 9) {
				while (x < 9) {
					char qwer = candidateSolution.charAt(x);
					z = charToInt(qwer);
					sudoku[y][x] = z;
					x++;				
				}
				y++;
			}
		}
		else {
			System.out.println("Wrong sized solution.");
		}
		return 0;
		
		//check
	}

	public boolean sizeChecker(String solution) {
		//System.out.println("length:"+ solution.length());
		
		if (solution.length() == 81)
			return true;
		else
			return false;
	}

	public int charToInt(char abc){	
		return Character.getNumericValue(abc);
	}
	
	public boolean intChecker(int number) {
		//here we check, if the int is between 1,2,3,4,5,6,7,8 or 9
		if (number > 0 && number < 10)
			return true;
		else
			return false;
	}
	
	public boolean columnChecker(int[][] sudoku) {
		
		return true;
	}
}
