import java.util.Arrays;

public class SudokuVerifier {
	
	// public method to be implemented and tested
	public int verify(String candidateSolution) {
		if (candidateSolution.matches("[1-9]{81}")) {  // Check for Rule 1 (81 digits) - Ok
			// Check for Rule 2 - sub-grids (all digits different in subgrid)
			// Cutting input string into array of subgrid's strings (private method called)
			String[] subgrids = cutSubGrids(candidateSolution);
			// digitCount private method counts occurrences of each digit in the string,
			// returns an array and we compare it with predefined "mask" array
			for (int i = 0; i < 9; i++)
				if (!Arrays.equals(digitCount(subgrids[i]), digitmask))
					return -2; // Rule 2 failed
			// Check for Rule 3 - all digits different in a row
			// Cutting input string into array of row's strings (private method called)
			String[] rows = cutRows(candidateSolution);
			// Compare digit counts with predefined "mask" array
			for (int i = 0; i < 9; i++)
				if (!Arrays.equals(digitCount(rows[i]), digitmask))
					return -3; // Rule 3 failed
			// Check for Rule 4 - all digits different in a column
			// Cutting input string into array of column's strings (private method called)
			String[] columns = cutColumns(candidateSolution);
			// Compare digit counts with predefined "mask" array
			for (int i = 0; i < 9; i++)
				if (!Arrays.equals(digitCount(columns[i]), digitmask))
					return -4; // Rule 4 failed
			// Everything OK - valid string
			return 0;
		} else // Rule 1 failed
			return -1;
	}
	
	// digitmask to compare with digit distribution - each should be occurred once 
	private final int[] digitmask =
		{1,1,1,1,1,1,1,1,1};
	
	// How many occurrences of each digit has in the string - private method
	private int[] digitCount(String strg) {
		int[] res = new int[9];  // result array
		for (int i = 0; i < 9; i++) // count
			res[Character.getNumericValue(strg.charAt(i)-1)]++; 
		return res;
	}
	
	// Cutting 3x3 subgrids from input row into array of strings - private method
	private String[] cutSubGrids(String strg) {
		String[] res = new String[9];
		for (int i = 0; i < 3; i++) {
			res[3*i] = strg.substring(27*i, 27*i+3)
					+ strg.substring(27*i+9, 27*i+12)
					+ strg.substring(27*i+18, 27*i+21);
			res[3*i+1] = strg.substring(27*i+3, 27*i+6)
					+ strg.substring(27*i+12, 27*i+15)
					+ strg.substring(27*i+21, 27*i+24);
			res[3*i+2] = strg.substring(27*i+6, 27*i+9)
					+ strg.substring(27*i+15, 27*i+18)
					+ strg.substring(27*i+24, 27*i+27);
		}
		return res;
	}
	
	// Cutting rows from input row into array of strings - private method
	private String[] cutRows(String strg) {
		String[] res = new String[9];
		for (int i = 0; i < 9; i++)
			res[i] = strg.substring(9*i, 9*(i+1));
		return res;
	}
	
	// Cutting columns from input row into array of strings - private method
	private String[] cutColumns(String strg) {
		String[] res = new String[9];
		for (int i = 0; i < 9; i++)
			res[i] = String.valueOf(strg.charAt(i))
					+ String.valueOf(strg.charAt(i+9))
					+ String.valueOf(strg.charAt(i+18))
					+ String.valueOf(strg.charAt(i+27))
					+ String.valueOf(strg.charAt(i+36))
					+ String.valueOf(strg.charAt(i+45))
					+ String.valueOf(strg.charAt(i+54))
					+ String.valueOf(strg.charAt(i+63))
					+ String.valueOf(strg.charAt(i+72));
		return res;
	}
	

}