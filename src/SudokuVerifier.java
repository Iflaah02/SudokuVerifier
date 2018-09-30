
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		int i,j,k;
		int intnum, count;
		
		String stringArr[] = candidateSolution.split("");
		if (stringArr.length != 81) {
			return -1;
		}
		
		String stringRow[] = new String[9];
		for(i=0; i<9; i++){
			stringRow[i] = "";
			for( j=0; j<9; j++){
				stringRow[i] = stringRow[i] + stringArr[i*9+j];
			}
			try {  
				  intnum = Integer.parseInt(stringRow[i]);   //check if all are numbers 
			} catch (NumberFormatException e) {
				return -1;
			}
			for(k=1; k<10; k++){  //check if 1-9 occur only once
				count = stringRow[i].length() - stringRow[i].replaceAll(String.valueOf(k),"").length();
				if (count != 1) {
					return -3;
				}				
			}
		}	
		
		String stringColumn[] = new String[9];
		for(i=0; i<9; i++){
			stringColumn[i] = "";
			for(j=0; j<9; j++){
				stringColumn[i] = stringColumn[i] + stringArr[i+j*9];
			}
			for(k=1; k<10; k++){  //check if 1-9 occur only once
				count = stringColumn[i].length() - stringColumn[i].replaceAll(String.valueOf(k),"").length();
				if (count != 1) {
					return -4;
				}				
			}
		}

		String stringGrid[] = new String[9];
		stringGrid[0] = stringRow[0].substring(0,3) + stringRow[1].substring(0,3)+ stringRow[2].substring(0,3);
		stringGrid[1] = stringRow[0].substring(3,6) + stringRow[1].substring(3,6)+ stringRow[2].substring(3,6);
		stringGrid[2] = stringRow[0].substring(6,9) + stringRow[1].substring(6,9)+ stringRow[2].substring(6,9);
		stringGrid[3] = stringRow[3].substring(0,3) + stringRow[4].substring(0,3)+ stringRow[5].substring(0,3);
		stringGrid[4] = stringRow[3].substring(3,6) + stringRow[4].substring(3,6)+ stringRow[5].substring(3,6);
		stringGrid[5] = stringRow[3].substring(6,9) + stringRow[4].substring(6,9)+ stringRow[5].substring(6,9);		
		stringGrid[6] = stringRow[6].substring(0,3) + stringRow[7].substring(0,3)+ stringRow[8].substring(0,3);
		stringGrid[7] = stringRow[6].substring(3,6) + stringRow[7].substring(3,6)+ stringRow[8].substring(3,6);
		stringGrid[8] = stringRow[6].substring(6,9) + stringRow[7].substring(6,9)+ stringRow[8].substring(6,9);		
		for(i=0; i<9; i++){
			for(k=1; k<10; k++){  //check if 1-9 occur only once
				count = stringGrid[i].length() - stringGrid[i].replaceAll(String.valueOf(k),"").length();
				if (count != 1) {
					return -2;
				}				
			}
		}
		
		return 0;
	}
}
