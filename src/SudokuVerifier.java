import com.sun.xml.internal.ws.util.StringUtils;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		
		String[][] sudokuArray = new String[9][3]; 
		
		/*
		//what should be returned if String is too short? 
		if(!checkLength(candidateSolution))
			return -1;
		*/
		
		int ret = checkPositiveDigits(candidateSolution); 
	
		if(ret != 0)
			return ret; 
		
		sudokuArray = getSubRows(candidateSolution); 
		
		ret = checkSubGrid(sudokuArray); 
		if(ret != 0)
			return ret;
		
		ret = checkGlobalRow(sudokuArray); 
		if(ret != 0)
			return ret;
		
		ret = checkGlobalColumn(sudokuArray);
		if(ret != 0)
			return ret;
		
		return 0;
		
		//check
	}
	
public int checkGlobalColumn(String[][] sudokuArray) {
	
	for(int column = 0; column < 3; column++) {
		
		for(int i = 0; i < 3; i++) {
			StringBuilder stringBuilder = new StringBuilder();
			
			for(int row = 0; row < 9; row++) {
				stringBuilder.append((sudokuArray[row][column]).charAt(i));
			}
			
			String subGridString = stringBuilder.toString();
			
			for(int number = 1; number <= 9; number++) {
				int digit = number; 
				int count = (int)subGridString.chars().filter(ch -> ch == (Character.forDigit(digit, 10))).count();
				if(count != 1) 
					return -4; 
			}
			
		}
	}
	
	return 0; 
}
	
public int checkGlobalRow(String[][] sudokuArray) {
	
	for(int row = 0; row < 9; row++) {
		StringBuilder stringBuilder = new StringBuilder();
		
		for(int column = 0; column < 3; column++) {
			stringBuilder.append(sudokuArray[row][column]);
		}
		
		String subGridString = stringBuilder.toString();
		
		for(int number = 1; number <= 9; number++) {
			int digit = number; 
			int count = (int)subGridString.chars().filter(ch -> ch == (Character.forDigit(digit, 10))).count();
			if(count != 1) 
				return -3; 
		}
		
	}
	
	return 0; 
}
	
public int checkSubGrid(String[][] sudokuArray) {
		int beginIndex = 0; 
		
		for(int column = 0; column < 3; column++) {
			
			for(int i = 0; i < 3; i++) {
				StringBuilder stringBuilder = new StringBuilder();
				int endIndex = beginIndex + 2; 
				
				for(int row = beginIndex; row <= endIndex; row++) {
					stringBuilder.append(sudokuArray[row][column]); 
				}
				
				String subGridString = stringBuilder.toString();
				
				for(int number = 1; number <= 9; number++) {
					int digit = number; 
					int count = (int)subGridString.chars().filter(ch -> ch == (Character.forDigit(digit, 10))).count();
					if(count != 1) 
						return -2; 
				}
				
				beginIndex += 3; 
			}
			beginIndex = 0; 
		}
		
		return 0; 
	}
	
	public String[][] getSubRows(String candidateSolution) {
		String[][] sudokuArray = new String[9][3];
		int beginIndex = 0; 
		
		for(int i = 0; i < 9; i++) {
			
			for(int j = 0; j < 3; j++) {
				sudokuArray[i][j] = candidateSolution.substring(beginIndex, (beginIndex + 3)); 
				beginIndex += 3; 
			}
		}
		
		return sudokuArray; 
	}
	
	public int checkPositiveDigits(String candidateSolution) {
		
		for(char chr : candidateSolution.toCharArray()) {
			int number; 
			try {
				number = Integer.parseInt(String.valueOf(chr));
			}catch(Exception e) {
				return -1; 
			}
		}
		
		return 0; 
	}
	
	public boolean checkLength(String candidateSolution) {
		
		boolean isCorrect = true;
		if(candidateSolution.length() != 81)
			isCorrect = false; 
		
		return isCorrect;  
	}
	
}
