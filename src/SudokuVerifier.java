import java.util.Random;

public class SudokuVerifier {
	
	int[][][][] sudoku = new int[3][3][3][3];
	int[][]  subSudoku = new int[3][3];
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		int[] arrayOfRanNum = new int[9];
		for(int l = 0; l < 3; l++) {
			
			for(int k = 0; k < 3; k++) {
				int random = getRandom();
				for (int i = 0; i < 3; i++) {
					
					for(int j = 0; j < 3; j++) {
						 
						subSudoku[i][j] = random;
						sudoku[l][k][i][j] = subSudoku[i][j];
						if(isInRow(random)) {
							random = getRandom();
						}
					}
				}
			
			}
		}
		
		String result = "";
		
		for(int k = 0; k < 3; k++) {
			for(int l = 0; l < 3; l++) {
				for (int i = 0; i < subSudoku.length; i++) {
					for(int j = 0; j < 3; j++) {
						result += sudoku[l][k][i][j];
						System.out.print("  " + sudoku[l][k][i][j]);
					}
					System.out.print("   ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		System.out.println(result);
		if(candidateSolution == result) {
			return 0;
		}else {
			return -1;
		}
		
		
	}
	
	public boolean isInRow(int cell) {
		boolean flag = false;
		for (int i = 0; i < subSudoku.length; i++) {
			for(int j = 0; j < 3; j++) {
				if(cell == subSudoku[i][j]);
				flag = true;
			}
		}
		
		return flag;
	}
	
	public int getRandom() {
		Random r = new Random();
		int rondomNumber = r.nextInt(9) + 1;
		return rondomNumber;
	}
	
	public static void main(String[] args) {
		SudokuVerifier sv = new SudokuVerifier();
		System.out.println(sv.verify(""));
	}
}
