
//Sudoku verifier done while utilizing refactoring methods
//JDoedorant still finds several long methods due to for loops in the column, row and subgrid checks. Refactoring them did not seem like
//it would help the readability of the code so I left them as is. 
public class SudokuVerifier {
	public int return_code=0;
	public int verify(String candidateSolution) {

			
		if(valid_size(candidateSolution)==1 || contain_int(candidateSolution) == 1) {
		return -1;	
		}
		
		return_code=check_rows(candidateSolution);
		if(return_code!=0) {
			return return_code;
		}
		return_code=check_columns(candidateSolution);
		if(return_code!=0) {
			return return_code;
		}
		return_code=check_subgrids(candidateSolution);
		if(return_code!=0) {
			return return_code;
		}
		return 0;
		
	
	}
	
	public int valid_size(String s) {
		if (s.length()!=(9*9)){
			return 1;
		}
		return 0;
	}
	
	public int contain_int(String s) {
		int range=s.length();		
		for(int i=0;i<range;i++) {
			if(!Character.isDigit(s.charAt(i))){
			return 1;
			}
		}
		
		return 0;
	}
	
	public int check_rows(String s) {
		char[] row = new char[9];
		for(int y=0;y<81;y=y+9) {
			for(int x=0;x<9;x++) {
				row[x]=s.charAt(x+y);
				}
			if(validate(row)==1) {
				return -3;
			}
		}
		
		return 0;
	}
	
	public int check_columns(String s) {
		char[] row = new char[10];
		int counter=1;
		for(int y=0;y<9;y=y+1) {
			for(int x=y;x<81;x=x+9) {
				row[counter]=s.charAt(x);
				counter++;
				}
			counter=1;
			if(validate(row)==1) {
				return -4;
			}
		}
		
		return 0;
	}
	
	public int check_subgrids(String s) {
		int counter=1;
		char[] row = new char[10];
		for(int sty=0;sty<80;sty=sty+27) {
			for(int stx=0;stx<9;stx=stx+3) {
				for(int i=0;i<24;i=i+9) {
					for(int j=0;j<3;j++) {
						row[counter]=s.charAt(sty+stx+i+j);
						counter++;
					}
					}
			
			if(validate(row)==1) {
				return -2;
			}
			
			counter=1;
		}
		}
		
		return 0;
	}
	//refactoring extract method
	public int validate(char[] c) {
		char[] values = values(c);
		for(char s : values) {
			if(s!='1') {
				return 1;
			}
			
		}
		return 0;
	}
//refactoring extract method
	private char[] values(char[] c) {
		char[] values = { '1', '0', '0', '0', '0', '0', '0', '0', '0', '0' };
		for (char s : c) {
			if (s == '1') {
				values[1] = '1';
			}
			if (s == '2') {
				values[2] = '1';
			}
			if (s == '3') {
				values[3] = '1';
			}
			if (s == '4') {
				values[4] = '1';
			}
			if (s == '5') {
				values[5] = '1';
			}
			if (s == '6') {
				values[6] = '1';
			}
			if (s == '7') {
				values[7] = '1';
			}
			if (s == '8') {
				values[8] = '1';
			}
			if (s == '9') {
				values[9] = '1';
			}
		}
		return values;
	}
	
}


