
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		String [] split;
		int [][] sudoku = new int[9][9];
		int[]copysudoku= new int[9];
		int x = 0;
		int y = 0;
		int help = 0;
		int copy = 0;
		//check is length right
		
		if(candidateSolution.length() < 81) {
			return 1;
		}
		
		else {
			//check is there 0 or negative number
			if(candidateSolution.contains("-")) {
				return -1;
			}
			else if(candidateSolution.contains("0")) {
				return -1;
			}
			
			else {
				split = candidateSolution.split("");
				
				
				for(; x < sudoku.length; x++) {
					for(y=0; y < 9; y++) {
						
						sudoku[x][y] = Integer.parseInt(split[help]);
						help++;
					}
				}
				
			
		}
			//Check have columns two same numbers
			help=0;
			while(help < 9) {
				for (x=0; x < 9; x++) {
					copy = sudoku[x][help];
					copysudoku[x] = copy;
				}
				
				for (x = 0; x < copysudoku.length; x++) {
					for (y= x+1; y < copysudoku.length; y++) {
						if(copysudoku[x] == (copysudoku[y])) {
							return -4;
							
						}
					}
				}
				help++;
			}
			
			
			//Check have rows two same numbers
		help=0;
		copysudoku = new int [9];
		while(help < 9) {
			for (y=0; y < 9; y++) {
				copy = sudoku[help][y];
				copysudoku[y] = copy;
			}
			
			for (x = 0; x < copysudoku.length; x++) {
				for (y= x+1; y < copysudoku.length; y++) {
					if(copysudoku[x] == (copysudoku[y])) {
						return -3;
					}
				}
			}
			help++;
		}
			
		//Check have 3x3 two same numbers
		copysudoku = new int[9];
		help = 0;
		int jatkox = 3;
		int laskin = 0;
		
		//check 1/3
		while (help < 3) {
			for(x = 0; x < jatkox; x++) {
				for(y = 0; y < 3; y++) {
					copy = sudoku[x][y];
					copysudoku[laskin] = copy;
					laskin++;
					
					if(laskin == 9) {
						for (int i = 0; i < copysudoku.length; i++) {
							for (int j= i+1; j < copysudoku.length; j++) {
								if(copysudoku[i] == copysudoku[j]) {
									return -2;
								}
							}
						}
						copysudoku = new int[9];
						help++;
						laskin = 0;
					}
				}
				
				y= 0;
			}
			jatkox = jatkox+3;
		}
		//check 2/3
		help = 0;
		jatkox = 0;
		while (help < 3) {
			for(x=0; x < jatkox; x++) {
				for(y=3; y < 6; y++) {
					
					 copy = sudoku[x][y];
					copysudoku[laskin] = copy;
					laskin++;
					
					if(laskin == 9) {
						for (int i = 0; i < copysudoku.length; i++) {
							for (int j= i+1; j < copysudoku.length; j++) {
								if(copysudoku[i] == copysudoku[j]) {
									return -2;
								}
							}
						}
						copysudoku = new int[9];
						help++;
						laskin = 0;
					}
				}
				
				y= 0;
			}
			jatkox = jatkox+3;
		}
		//check 3/3
		help = 0;
		jatkox = 0;
		while (help < 3) {
			for(x=0; x < jatkox; x++) {
				for(y=6; y < 9; y++) {
					
					copy = sudoku[x][y];
					copysudoku[laskin] = copy;
					laskin++;
					
					if(laskin == 9) {
						for (int i = 0; i < copysudoku.length; i++) {
							for (int j= i+1; j < copysudoku.length; j++) {
								if(copysudoku[i] == copysudoku[j]) {
									System.out.println("Virhe löytyi");
									return -2;
								}
							}
						}
						copysudoku = new int[9];
						help++;
						laskin = 0;
					}
				}
				
				y= 0;
			}
			jatkox = jatkox+3;
		}
		
		
		
	}
		// returns 0 if the candidate solution is correct
		return 0;
	}
}
