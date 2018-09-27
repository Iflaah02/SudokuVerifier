import java.util.Scanner;

public class SudokuVerifier {
	
	
	public int verify(String candidateSolution) {
		Scanner sc = new Scanner(candidateSolution).useDelimiter("");
		int [][] sol = new int [9][9];
		for (int i = 0; i < 9; i++) 
			for (int j=0;j<9;j++) 
				sol[i][j] = sc.nextInt();
		sc.close();
	
	for(int row = 0; row < 9; row++)
		for(int col = 0; col < 8; col++)
			for(int col2 = col + 1; col2 < 9; col2++)
				if(sol[row][col]==sol[row][col2])
					return -3;
	
	for(int col = 0; col < 9; col++)
		for(int row = 0; row < 8; row++)
			for(int row2 = row + 1; row2 < 9; row2++)
				if(sol[row][col]==sol[row2][col])
					return -4;

	for(int row = 0; row < 9; row += 3)
		for(int col = 0; col < 9; col += 3)
			for(int pos = 0; pos < 8; pos++)
				for(int pos2 = pos + 1; pos2 < 9; pos2++)
					if(sol[row + pos%3][col + pos/3]==sol[row + pos2%3][col + pos2/3])
						return -2;
	return 0;
	}
		
	public int checkPositive(String candidateSolution) {
		int [] sol = new int [candidateSolution.length()];
		for (int i= 0; i < candidateSolution.length(); i++) 
			if(Character.getNumericValue(candidateSolution.charAt(i)) < 0)
				return -1;	
	return 0;
	}
	

		

}

