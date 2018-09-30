
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		int flagError = 0;
		if(candidateSolution.length() == 81) {
			if(checkDigits(candidateSolution)) {
				if(checkSubGrid(candidateSolution)) {
					if(checkRowsGrid(candidateSolution)) {
						if(checkColumnsGrid(candidateSolution)) {
						}
						else
							flagError = -4;
					}
					else
						flagError = -3;
				}
				else
					flagError = -2;
			}
			else
			 flagError = -1;
			
		}
		else
			flagError = -5;
			
		// returns 0 if the candidate solution is correct
		return flagError;
		
		//check
	}
	
	public boolean checkDigits(String candidateSolution) {
		boolean flag = true;
		for(int i=0; i < candidateSolution.length(); i++) {
			if((!(Character.isDigit(candidateSolution.charAt(i)))) || (Character.getNumericValue(candidateSolution.charAt(i)) == 0))
			{
				flag = false;
			}
		}
		return flag;
	}

	public boolean checkRowsGrid(String candidateSolution) {
		boolean flag = true;
		for (int k = 0; k < candidateSolution.length(); k+=9) {
			for (int i = k; i < k+9; i++) { 
				for (int j = i + 1; j < k+9; j++) {
					 if (candidateSolution.charAt(i) == candidateSolution.charAt(j)) 
			                flag = false; 
				}
			}
		}
		return flag;
	}
	
	public boolean checkSubGrid(String candidateSolution) {
		boolean flag = true;
		
		for(int x=0; x < candidateSolution.length(); x+=27) {
			for(int j=x; j < x+8; j+=3) {
				String currentSubGrid = "";
				for(int k=j; k < j+26; k= k+9) {
					for (int i=k; i < k+3; i++) {
						currentSubGrid += candidateSolution.charAt(i);
					}
				}
				//System.out.println(currentSubGrid);
				if(!checkRowsGrid(currentSubGrid))
					flag = false;
			}
		}	
		return flag;
	}
	
	public boolean checkColumnsGrid(String candidateSolution) {
		boolean flag = true;
		for(int x=0; x < 9; x++) {
			for(int y=x; y < candidateSolution.length(); y+=9) {
				for(int j = y+9; j < candidateSolution.length(); j+=9) {
					if (candidateSolution.charAt(y) == candidateSolution.charAt(j)) 
		                flag = false; 
				}
			}
		}
		return flag;
	}
	
}
