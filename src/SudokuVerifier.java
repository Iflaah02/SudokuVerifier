import java.util.*;
public class SudokuVerifier {
	int[][] sudoku = new int [9][9];
	int number =0;
	
	public int compter(String candidateSolution) {
			int length = candidateSolution.length();
			return length;
		}
	
	
	public void matrice(String candidateSolution){
	int k=0;
	int nb=0;
	 
	 for(int i=0;i<9;i++) {
	      for(int j=0;j<9;j++) {
	      sudoku[i][j]=Integer.parseInt(String.valueOf(candidateSolution.charAt(k)));
	      nb=Integer.parseInt(String.valueOf(candidateSolution.charAt(k)));
	      if(nb != 1 && nb != 2 && nb != 3 && nb != 4 && nb != 5 && nb != 6 && nb != 7 && nb != 8 && nb != 9 ) {
	    	  number=number +1;
	      }
	      k=k+1;
	      }
	 }
	}
	public int checkrow() {
		int check=0;
	
		for(int row = 0; row < 9; row++) {
			   for(int col = 0; col < 8; col++) {
			      for(int col2 = col + 1; col2 < 9; col2++) {
			         if(sudoku[row][col]==sudoku[row][col2]) {
			        	 check=check +1;
			         }
			         
			            
			      }
			   }
		}
		if(check > 0) {
			return -3;
		}
		else {
			return 0;
		}
	}
	
	public int checkgril(){
	int check3=0;
	for(int row = 0; row < 9; row += 3) {
		for(int col = 0; col < 9; col += 3) {
		     
		     for(int pos = 0; pos < 8; pos++) {
		         for(int pos2 = pos + 1; pos2 < 9; pos2++) {
		            if(sudoku[row + pos%3][col + pos/3]==sudoku[row + pos2%3][col + pos2/3])
		            	check3=check3 +1;
		         }
		     }     
		}
	}
	
	if(check3 > 0) {
		return -2;
	}
	else {
		return 0;
	}
	}
	
	public int checkcol() {
		int check2=0;
	
		for(int col = 0; col < 9; col++) {
			   for(int row = 0; row < 8; row++) {
			      for(int row2 = row + 1; row2 < 9; row2++) {
			         if(sudoku[row][col]==sudoku[row2][col]) {
			        	 check2=check2 +1;
			         }
			         
			            
			      }
			   }
		}
		if(check2 > 0) {
			return -4;
		}
		else {
			return 0;
		}
	}
	
	
	public int verify(String candidateSolution) {
	// returns 0 if the candidate solution is correct
		int nb =compter(candidateSolution);
		if (nb != 81 || number !=0) {
			return -1;
		}
		else {
			matrice(candidateSolution);
			int ccol = checkcol();
			if (ccol == -4) {
				return -4;
			
			}
			else {
				int crow = checkrow();
				if (crow == -3) {
					return -3;
				}
				else {	
					int cgril = checkgril();
					if (cgril == -2) {
						return -2;
					}
					else {	
						return 0;
					}
				}
			}
		}
	}
}
	//char[] tc = new char [81];
	//int verifrow =0;
	//int verifgril =0;
	
	//public int compter(String candidateSolution) {
	//	int length = candidateSolution.length();
	//	return length;
//	}
//	public void tableau(String candidateSolution) {
//		for(int i=0; i<=80;i++) {
//		tc [i] = candidateSolution.charAt(i);
//		}
//	}
//	public int verifynb(String candidateSolution) {
//		tableau(candidateSolution);
	//	int mist =0;
	//	for(int i=0;i<=80;i++) {
	//		if(tc[i]!= 1 && tc[i]!= 2 && tc[i]!= 3 && tc[i]!= 4 && tc[i]!= 5 && tc[i]!= 6 && tc[i]!= 7 && tc[i]!= 8 && tc[i]!= 9 ) {
	//			mist=1;
	//		}
	//	}
	//	if(mist==0) {
	//		return 0;
	//	}
	//	else {
	//		return -1;
	//	}
//	}
	
//	public void comprow() {
	//	int compt = 0;
	//	for (int l=1;l<=9;l++) {
	//		for (int j=0; j<=7;j++) {
	//			for(int i=j+1;i<=8;i++) {
	//				if (tc[i+compt]==tc[j+compt]) {
	//					verifrow =1;
		//			}
		//		}
	//		}
	//		compt=compt+9;
	//	}
		
//	}
//	public void compgril() {
//		int compt = 0;
	//		for (int j=0; j<=2;j++) {
	///		for(int i=j+9;i<=9;) {
	//				if (tc[i+compt]==tc[j+compt]) {
	//					verifgril =1;
	//				}
	//			}
	//		}
	//	
		
//	}
	
	//public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		
	//	return 0;
	
		//check
//	}
//
