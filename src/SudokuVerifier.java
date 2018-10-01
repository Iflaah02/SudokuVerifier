
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		
		int result = 0;
		
		if(checkLength(candidateSolution) == 1) {
		
			if(positiveDigits(candidateSolution) == 1) {
				
				int valid = 1;
				
				String[] subGrid = new String[9];
				
				subGrid = cutSubGrid(candidateSolution);
				
				for(int i = 0; i < 9; i++) {
					
					for(int j = 0; j < 9; j++) {
						
						if(countNumbers(subGrid[i], j+1) != 1) {
							
							valid = 0;
							
						}
						
					}
					
				}
				
				if(valid == 0) {
				
					result = -2; 
					
				}		
			
				valid = 1;
				
				String[] rows = new String[9];
				
				rows = cutRow(candidateSolution);
				
				for(int i = 0; i < 9; i++) {
					
					for(int j = 0; j < 9; j++) {
						
						if(countNumbers(rows[i], j+1) != 1) {
							
							valid = 0;
							
						}
						
					}
					
				}
				
				if(valid == 0) {

					result = -3; 
				}
				
				valid = 1;
				
				String[] columns = new String[9];
				
				columns = cutColumns(candidateSolution);
				
				for(int i = 0; i < 9; i++) {
					
					for(int j = 0; j < 9; j++) {
						
						if(countNumbers(columns[i], j+1) != 1) {
							
							valid = 0;
							
						}
						
					}
					
				}
				
				if(valid == 0) {

					result = -4; 
				}
				
			}
			
			else {
				
				result = -1;
				
			}
			
		}
			
		else {
			
			result = -5;
		}
		
		return result;
	}

public int checkLength (String s) {
	
	if(s.length() == 81) {
		
		return 1;
		
	}
	
	else {
		
		return 0;
		
	}
	
}

public String[] cutRow(String s) {
	
	int k = 0;
	
	String[] rows = new String[9];
	
	for(int a = 0; a < 9; a++) {
		
		rows[a] = "";
		
	}
	
	for(int i = 0; i < 9; i++) {
	
		for(int j = 0; j < 9; j++) {
			
			rows[k] += s.charAt(j + 9 * i);
			
		}

	k++;
	
	}
	
	return rows;
}

public String[] cutColumns(String s) {
	
	int k = 0;
	
	String[] columns = new String[9];
	
for(int a = 0; a < 9; a++) {
		
		columns[a] = "";
		
	}
	
	for(int i = 0; i < 9; i++) {
		
		
		for(int j = 0; j < 81; j+=9) {
			
			columns[k] += s.charAt(j + i);
			
		}
		
		k++;
		
	}
	
	return columns;
	
}

public String[] cutSubGrid(String s) {
	
	int k = 0;
	int l = 0;
	
	String[] subGrid = new String[9];
	
	for(int a = 0; a < 9; a++) {
		
		subGrid[a] = "";
		
	}
	
	for(int i = 0; i < 81; i++) {
		
		k %= 3;
		
		subGrid[k + l] += s.charAt(i); 
		
		if((i + 1) % 3 == 0) {
			
			k++;
			
		}
		
		if((i + 1) % 27 == 0) {
			
			l += 3;
			
		}
		
	}
	
	return subGrid;
	
}

public int countNumbers(String s, int search){
	
	int nb = 0;
	
	for (int i=0; i < s.length(); i++){	
		
			if (s.charAt(i) == (char)(search + '0')){
				nb++;
			}
			
	}
	
	return nb;

}

public int positiveDigits(String s) {
	
	int valid = 1;
	
	for(int i = 0; i < 81; i++) {
		
		if(Character.getNumericValue(s.charAt(i)) < 1){
			
			valid = 0;
			
		}
		
	}
	
	return valid;
	
}

}
