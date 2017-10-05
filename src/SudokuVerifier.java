import java.util.Arrays;

public class SudokuVerifier {
	
	private boolean checkInputValidity (String candidateSolution) {
		return candidateSolution.length() == 81 && candidateSolution.matches("[1-9]+");
	}
	
	private int [][] stringTo2DArray (String candidateSolution){
		int size = (int) Math.sqrt(candidateSolution.length());
		int [][] sodukuBoard = new int [size][size];
		for (int i=0; i<candidateSolution.length(); i++){
			sodukuBoard[i%9][i/9] = Character.getNumericValue(candidateSolution.charAt(i));
		}
		return sodukuBoard;
	}
	
	private boolean checkUniqueInSubSoduku (int[] subSoduku) {
	    int i = 0;
	    Arrays.sort(subSoduku);
	    for (int num : subSoduku) {
	        if (num != ++i)
	            return false;
	    }
	    return true;
	}
	
	private int verifyBoard (int [][] SodukuBoard ) {
		
		for (int i = 0; i < 9; i++) {
			
	        int[] subGrid = new int[9];
	        int[] horizental = new int[9];
	        int[] vertical = SodukuBoard[i].clone();
	        
	        for (int j = 0; j < 9; j ++) {
	        	horizental[j] = SodukuBoard[j][i];
	        	subGrid[j] = SodukuBoard[j/3 + (i/3)*3][j%3 + i*3%9];
	        }	        
	        if (!checkUniqueInSubSoduku(subGrid)){ // check for rule#2
				return -2;
			}else if (!checkUniqueInSubSoduku(horizental)){
				return -3;
			}else if (!checkUniqueInSubSoduku(vertical)){
				return -4;
			}
	        
	    }

		return 0;
	}
	
	public int verify(String candidateSolution) {
		
		if (!checkInputValidity(candidateSolution)) {
			return -1;
		} else {
			return verifyBoard(stringTo2DArray(candidateSolution));
		}
	}
	    
}
