import java.util.Arrays;

public class SudokuVerifier { 
	
	public int verify(String candidateSolution) {
		if (candidateSolution.matches("[1-9]+") == false) {
			return -1;
		}
		String[] split = candidateSolution.split("");
		int[] toIntArray = new int [split.length];
		for (int i = 0; i < split.length; i++) {
			toIntArray[i] = Integer.parseInt(split[i]);	
		}
		
		int chunk = 9;
		int[][] grid = new int[chunk][];
		
		for (int i=0; i < chunk; i++){
			int start = i * chunk;
			int length = Math.min(toIntArray.length - start, chunk);
			
			int[] temp = new int [length];
			System.arraycopy(toIntArray, start, temp, 0, length);
			grid[i] = temp;
			}
		
		for (int i = 0; i < 9; i++) {
			
			int[] row = new int [9];
			int[] square = new int[9];
			int[] column = grid[i].clone();
			
			for (int j = 0; j < 9; j++) {
				row[j] = grid[j][i];
				square[j] = grid [(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
			}
			if (!(validate(column))) {
				return -4;
			}else if (!(validate(row))) {
				return -3;
			}else if (!(validate(square))) {
				return -2;
			}
		}
		return 0;
	}
	
	private boolean validate(int[] check) {
	    Arrays.sort(check);
	    for(int i = 1; i <= 9; i++){
		    if(check[i-1] != i){
		       return false;
		       }
		    }
	    return true;
	    }
}