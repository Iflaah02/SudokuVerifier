import java.util.*;

public class SudokuVerifier {	
	/*
	 * Code before refactoring:
	 * 		I misunderstood the assignment: "You should implement the functionality with a single API method" 
	 * 		and coded a single, overly complicated method called "verify": 
	 *
	 * Refactoring performed:
	 * 		- step 1: "Extract Method" refactoring. Split the verify method into multiple method with explicit names
	 * 				- rewrote SudokuVerifierParametrizedTest.class accordingly
	 * 				- all tests passed successfully !
	 * 		- step 2: "Introduce parameter object" refactoring. Simplify argument passing for the rule checking methods.
 	 * 				- before refactoring: call to rule checking methods looks like: "checkRuleN_SampleText (candidateSolution, data, sortedNumbers);"
	 * 				- after refactoring: "checkRuleN_SampleText (argumentPasser);"
	 * 					- wrote ArgumentPasser class
	 * 					- wrote ArgumentPasserTest class
	 * 					- rewrote SudokuVerifierParametrizedTest.class accordingly
	 * 					- all tests passed successfully !
	 * 		- step 3: "Consolidate conditionals" refactroring. replaced 3 consecutive if-statements by the checkAllRules(ArgumentPasser) method
	 * 				- all tests passed successfully !
	 * */	
	
	/**
	 * Verify that the input string is a valid sudoku solution or return an error code identifying the broken rule.
	 *  
	 * @param candidateSolution: String, a 81 char long string of single positive digits. Every 9 consecutive digits represent a row of the sudoku grid.
	 * @return : an int between 0 and -4 indicating that the solution is valid (0) or which rule is being broken (-1, -2, -3, -4)
	 */ 
	public int verify(String candidateSolution) throws IllegalArgumentException{
		// if the input String is not the correct length, throw an exception.
		if ( !candidateSolutionIs81CharsLong(candidateSolution) ) {
			throw new IllegalArgumentException();
		}
		else {
			// call the ArgumentPasser object, which stores the candidateSolution and the data structures necessary to do comparisons.
			ArgumentPasser args = new ArgumentPasser(candidateSolution);
			
			return checkAllRules(args);
		}
	}
	
	/**
	 * Verify that the input string is 81 characters long, the length of a sudoku solution
	 *  
	 * @param candidateSolution: String, a 81 char long string of single positive digits. Every 9 consecutive digits represent a row of the sudoku grid.
	 * @return : an boolean, false if candidateSolution isn't 81 characters long, true otherwise.
	 */ 
	public boolean candidateSolutionIs81CharsLong (String candidateSolution) {
		return candidateSolution.length() == 81;
	}
	
	/**
	 * Verify that the input string contains only numbers, satisfying the first rule for valid sudoku solutions
	 *  
	 * @param candidateSolution: String, a 81 char long string of single positive digits. Every 9 consecutive digits represent a row of the sudoku grid.
	 * @return : an boolean, false if candidateSolution contains at least one non-numeric, true otherwise.
	 */ 
	public boolean checkRule1_AllCharsAreNumerical (String candidateSolution) {
		for(int i=0; i<candidateSolution.length(); i++) {
			// if the i-character in the input string isn't a digit:
			if ( !Character.isDigit( candidateSolution.charAt(i) ) ) {
				// returns -1, the candidate solution contains a number not in [1,9]
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Verify that all the sub-grids are valid, satisfying the second rule for valid sudoku solutions
	 *  
	 * @param args: ArgumentPasser, an object containing a 81 char long string of single positive digits, an empty array or chars of size 9 and a a sorted array of size 9 containing the numbers from 1 to 9
	 * @return : an boolean, false at least one sub-string is invalid, true otherwise.
	 */ 
	public boolean checkRule2_AllSubgridsAreValid (ArgumentPasser args) {
		// Initialize useful data structures and iterators
		char[] data = args.getdata();
		int temp=0;
		//a sub-grid consists of 3 consecutive numbers of 3 consecutive rows.
		for(int i=0; i<55; i+=27) { // i is in [0,27,54]
			for(int j=0; j<7; j+=3) { // j+i is in [0,3,6,27,30,33,54,57,60] the indexes [1,1] of every sub-grid
				for(int k=0; k<19; k+=9) { // j+i+k is in [0,9,18,3,12,21,6,14,23,27, ... ]
					for(int l=0; l<3; l++) { // i+j+k+l is in [0,1,2,9,10,11,18,19,20,3,4,5, ...]
						//for example [0,1,2,9,10,11,18,19,20] are the indexes of the first sub-grid in the input string.
						data[temp] = args.getSudokuString().charAt(i+j+k+l);
						temp++;
						if (temp == 9) {
							temp = 0;
							Arrays.sort(data);
							if ( !Arrays.equals(data,args.getsortedNumbers())) {
								// returns -2 if a digit appears multiple time in a sub-grid
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Verify that all the rows are valid, satisfying the third rule for valid sudoku solutions
	 *  
	 * @param args: ArgumentPasser, an object containing a 81 char long string of single positive digits, an empty array or chars of size 9 and a a sorted array of size 9 containing the numbers from 1 to 9
	 * @return : an boolean, false if candidateSolution isn't 81 characters long, true otherwise.
	 */ 
	public boolean checkRule3_AllrowsAreValid (ArgumentPasser args) {
		// Initialize useful data structures and iterators
		char[] data = args.getdata();
		// a row consists of 9 consecutive numbers. We keep track of a row in an array of 9 char.
		for(int i=0; i<80; i++) {	
			data[i%9] = args.getSudokuString().charAt(i) ;
			// when we encounter the 9th number of the string:
			if ( (i+1) % 9 == 0) {
				// sort the read row into 'data' and compare it to the desired result 'sorted numbers'
				Arrays.sort(data);
				if ( !Arrays.equals(data,args.getsortedNumbers())) {
					// returns -3 if a digit appears multiple time in a row
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Verify that all the columns are valid, satisfying the forth rule for valid sudoku solutions
	 * 
	 * @param args: ArgumentPasser, an object containing a 81 char long string of single positive digits, an empty array or chars of size 9 and a a sorted array of size 9 containing the numbers from 1 to 9
	 * @return : an boolean, false if candidateSolution isn't 81 characters long, true otherwise.
	 */ 
	public boolean checkRule4_AllcolumnsAreValid (ArgumentPasser args) {
		// Initialize useful data structures and iterators
		char[] data = args.getdata();
		// a column consists of a number from each row with the same index in said row.
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				data[j] = args.getSudokuString().charAt(i+j*9);
			}
			Arrays.sort(data);
			if ( !Arrays.equals(data,args.getsortedNumbers())) {
				// returns if a digit appears multiple time in a column
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Verify all sudoku rules
	 * 
	 * @param args: ArgumentPasser, an object containing a 81 char long string of single positive digits, an empty array or chars of size 9 and a a sorted array of size 9 containing the numbers from 1 to 9
	 * @return : an int between 0 and -4 indicating that the solution is valid (0) or which rule is being broken (-1, -2, -3, -4)
	 */ 
	public int checkAllRules(ArgumentPasser args) {
		// check for rule n°1:
		if (!checkRule1_AllCharsAreNumerical (args.getSudokuString())) {
			return -1;
		}
		
		//check for rule n°2:
		if (!checkRule2_AllSubgridsAreValid (args)) {
			return -2;
		}
		
		//check for rule n°3:
		if (!checkRule3_AllrowsAreValid (args)) {
			return -2;
		}
					
		//check for rule n°4:
		if (!checkRule4_AllcolumnsAreValid (args)) {
			return -2;
		}
		//all rules are respected: return 0.
		return 0;
	}
	
}
