
public class SudokuVerifier {
	public int return_code;
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		
		char[] char_array = candidateSolution.toCharArray();
		
		
		if(valid_size(candidateSolution)==1 || contain_int(candidateSolution) == 1) {
		return 1;	
		}
		
		check_rows(candidateSolution);
		check_columns(candidateSolution);
		return 0;
		
		//check
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
		char[] row = new char[9];
		for(int y=0;y<9;y=y+1) {
			for(int x=0+y;x<9+y;x=x+9) {
				row[x]=s.charAt(x+y);
				}
			if(validate(row)==1) {
				return -3;
			}
		}
		
		return 0;
	}
	
	public int validate(char[] c) {
		char[] values = {'1','0','0','0','0','0','0','0','0','0'};
		
		for(char s : c) {
			if(s=='1') {
				values[1]='1';
			}
			if(s=='2') {
				values[2]='1';
			}
			if(s=='3') {
				values[3]='1';
			}
			if(s=='4') {
				values[4]='1';
			}
			if(s=='5') {
				values[5]='1';
			}
			if(s=='6') {
				values[6]='1';
			}
			if(s=='7') {
				values[7]='1';
			}
			if(s=='8') {
				values[8]='1';
			}
			if(s=='9') {
				values[9]='1';
			}

			}
		for(char s : values) {
			if(s!='1') {
				return 1;
			}
			
		}
		return 0;
	}
	
}


