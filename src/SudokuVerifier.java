
public class SudokuVerifier {
	int[][] matrix = new int[9][9];
	
	public int verify(String candidateSolution) {
		
		if(!OnlyNumbers(candidateSolution) || candidateSolution.length() != 81)
			return -1;
		
		matrix = fillMatrix(candidateSolution);
		
		if(CheckGrids(matrix))
			return -2;
		
		if(CheckRows(matrix))
			return -3;
		
		if(CheckColumns(matrix))
			return -4;
		
		
		// returns 0 if the candidate solution is correct
		return 0;
		
		//check
	}
	
	private int[][] fillMatrix(String candidateSolution) {
		String[] splitCandidateSolution = candidateSolution.split("");
		int[][] tempMatrix = new int[9][9];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				tempMatrix[i][j] = Integer.parseInt(splitCandidateSolution[j + i * 9]);
			}
		}
		return tempMatrix;
	}

	public boolean OnlyNumbers(String string)
	{
	    if (string != null && !string.isEmpty()) {
	        for (char c : string.toCharArray()) {
	            if (!Character.isDigit(c)) {
	                return false;
	            }
	        }
	    }

	    return true;		
	}
	
	public boolean CheckRows(int[][] testMatrix)
	{
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9 ; j++) {
			    for (int k = j + 1; k < 9 ; k++) {
			        if (testMatrix[i][k] == testMatrix[i][j]){
			        	return true;
			        }
			    }
			}
		}		
		return false;
	}
	
	public boolean CheckColumns(int[][] testMatrix)
	{
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9 ; j++) {
			    for (int k = j + 1; k < 9 ; k++) {
			        if (testMatrix[k][i] == testMatrix[j][i]){
			            return true;
			        }
			    }
			}
		}		
		return false;
	}
	
	public boolean CheckGrids(int[][] testMatrix)
	{
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						if ((i != k || j != l) && testMatrix[i][j] == testMatrix[k][l]) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
