
import java.util.regex.Pattern;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		
		int [][] sudokuGrid = new int[9][9]; 
		
		int length = candidateSolution.length();
		
		if (isEmptyChain(candidateSolution) || !isValidChain(candidateSolution))
			return -1;
		else if (candidateSolution.length()!=81)
			return -1;
		else {
			for(int i=0;i<9;i++)
				for(int j=0;j<9;j++)
				{
					sudokuGrid[i][j] = Character.getNumericValue(candidateSolution.charAt(i*9+j));
				}
			
			
			if (!checkRows(sudokuGrid))
			{
				return -3;
			}
			
			if (!checkColumns(sudokuGrid))
			{
				return -4;
			}
			
			if(!checkSquares(sudokuGrid))
			{
				return -2;
			}
		}
		return 0;

	}
	
	
		
	private boolean checkRows(int[][] sudokuGrid) {
		boolean correctChain = false;
		for (int i = 0; i < sudokuGrid.length; i++){
			StringBuilder chainRow = new StringBuilder();
			for (int j = 0; j < sudokuGrid.length; j++) {
				chainRow.append(sudokuGrid[i][j]);
			}
			correctChain = isChainCorrect(chainRow.toString());
			if (!correctChain)
				return false;
		}
		
		return correctChain;
	}
	
	private boolean checkColumns(int[][] sudokuGrid) {
		boolean correctChain = false;
		for (int i = 0; i < sudokuGrid.length; i++){
			StringBuilder chainColumn = new StringBuilder();
			for (int j = 0; j < sudokuGrid.length; j++) {
				chainColumn.append(sudokuGrid[j][i]);
			}
			correctChain = isChainCorrect(chainColumn.toString());
			if (!correctChain)
				return false;
		}
		
		return correctChain;
	}
	
	
	private boolean checkSquares(int[][] sudokuGrid) {
		boolean correctChain = false;
		for (int i = 0; i < sudokuGrid.length; i+=3){
			StringBuilder chainSquare = createSquare(sudokuGrid, i, 0);
			correctChain = isChainCorrect(chainSquare.toString());
			if (!correctChain)
				return false;
			
			chainSquare = createSquare(sudokuGrid, i, 3);
			correctChain = isChainCorrect(chainSquare.toString());
			if (!correctChain)
				return false;
			
			chainSquare = createSquare(sudokuGrid, i, 6);
			correctChain = isChainCorrect(chainSquare.toString());
			if (!correctChain)
				return false;
		}
		return correctChain;
	}
	
	
	private StringBuilder createSquare(int[][] sudokuGrid, int startPointX, int startPointY){
		StringBuilder chainSquare = new StringBuilder();
		for (int i = startPointX; i < startPointX + 3; i++){
			
			for (int j = startPointY; j < startPointY + 3; j++) {
				chainSquare.append(sudokuGrid[i][j]);
			}
		}
		return chainSquare;
	}

	
	public boolean isChainCorrect(String chain) {

		if (isEmptyChain(chain) || !isValidChain(chain))
			return false;
		
		boolean isCorrect = true;
		
		//Search for repetition in the chain
		for (int i = 0; i < chain.length(); i++) {
			int counterMatches = countMatches(chain, chain.charAt(i)+"");
			if (counterMatches > 1){
				isCorrect = false;
				System.out.println("The number " + chain.charAt(i) + " appears " 
						+ counterMatches + " times in the chain: " + chain );
				break;
			}
		}		
		return isCorrect;
	}
	
	
	private boolean isValidChain(String chain) {
		
		Pattern pattern = Pattern.compile("[0-9]*");  
		return pattern.matcher(chain).matches();     
		    
//		return chain.matches("[1-9]{9}");
	}
	
	
	private int countMatches(String chain, String subChain) {
		if (isEmptyChain(chain) || isEmptyChain(subChain)) {
			return 0;
		}
		int count = 0;
		int idx = 0;
		while ((idx = chain.indexOf(subChain, idx)) != -1) {
			count++;
			idx += subChain.length();
		}
		return count;
	}

	
	private boolean isEmptyChain(String chain) {
		return chain == null || chain.length() == 0;
	}
}
