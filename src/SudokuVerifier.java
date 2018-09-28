import java.util.*;

/* You should implement the functionality with a single API method */
public class SudokuVerifier {
	/**
	 * Verify that the input string is a valid sudoku solution or return an error code identifying the broken rule.
	 *  
	 * @param candidateSolution: String, a 81 char long string of single positive digits. Every 9 consecutive digits represent a row of the sudoku grid.
	 * @return : an int between 0 and -4 indicating that the solution is valid (0) or which rule is being broken (-1, -2, -3, -4)
	 */ 
	public int verify(String candidateSolution) throws IllegalArgumentException{
		// if the input String is not the correct length, return an exception.
		if (candidateSolution.length() != 81) {
			throw new IllegalArgumentException();
		}
		else {
			// create data structures to store data from a single rows, column or sub-grid.
			char[] data = new char[9];
			// an array of sorted char from 1 to 9.
			char[] sortedNumbers = {'1','2','3','4','5','6','7','8','9'};
			// check that rule 1 and 3 are valid in a single String browsing:
			for(int i=0; i<candidateSolution.length(); i++) {
				// check for rule n°1:
				
				// if the i-character in the input string isn't a digit:
				if ( !Character.isDigit( candidateSolution.charAt(i) ) ) {
					// returns -1, the candidate solution contains a number not in [1,9]
					return -1;
				}
				
				//check for rule n°3:
				// a row consists of 9 consecutive numbers. We keep track of a row in an array of 9 char.
				data[i%9] = candidateSolution.charAt(i) ;
				// when we encounter the 9th number of the string:
				if ( (i+1) % 9 == 0) {
					// sort the read row into 'data' and compare it to the desired result 'sorted numbers'
					Arrays.sort(data);
					if ( !Arrays.equals(data,sortedNumbers)) {
						// returns -3 if a digit appears multiple time in a row
						return -3;
					}
				}
			}
			
			//check for rule n°4:
			// a column consists of a number from each row with the same index in said row.
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					data[j] = candidateSolution.charAt(i+j*9);
				}
				Arrays.sort(data);
				if ( !Arrays.equals(data,sortedNumbers)) {
					// returns if a digit appears multiple time in a column
					return -4;
				}
			}
			
			//check for rule n°2:
			int temp=0;
			//a sub-grid consists of 3 consecutive numbers of 3 consecutive rows.
			for(int i=0; i<55; i+=27) { // i is in [0,27,54]
				for(int j=0; j<7; j+=3) { // j+i is in [0,3,6,27,30,33,54,57,60] the indexes [1,1] of every sub-grid
					for(int k=0; k<19; k+=9) { // j+i+k is in [0,9,18,3,12,21,6,14,23,27, ... ]
						for(int l=0; l<3; l++) { // i+j+k+l is in [0,1,2,9,10,11,18,19,20,3,4,5, ...]
							//for example [0,1,2,9,10,11,18,19,20] are the indexes of the first sub-grid in the input string.
							data[temp] = candidateSolution.charAt(i+j+k+l);
							temp++;
							if (temp == 9) {
								temp = 0;
								Arrays.sort(data);
								if ( !Arrays.equals(data,sortedNumbers)) {
									// returns -2 if a digit appears multiple time in a sub-grid
									return -2;
								}
							}
						}
					}
				}
			}
		}
		// returns 0 if the candidate solution is correct
		return 0;
	}
	
}
