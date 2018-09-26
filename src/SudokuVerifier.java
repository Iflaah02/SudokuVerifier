import java.util.Arrays;

public class SudokuVerifier {
	
	// Expected appearance of digits
	private final int[] expected =
		{1,1,1,1,1,1,1,1,1};
	
	// How many times each digit appears
	private int[] times(String part) {
		assert(part.length() == 9);
		int[] res = new int[9];
		for (int i = 0; i < 9; i++)
			res[i] = 0;
		for (int i = 0; i < 9; i++)
			res[Character.getNumericValue(part.charAt(i)-1)]++;
		return res; // TODO: Check
	}
	
	private String[] getRows(String board) {
		String[] res = new String[9];
		for (int i = 0; i < 9; i++) {
			res[i] = board.substring(9*i, 9*(i+1));
		}
		return res; // TODO: check
	}
	
	private String[] getColums(String board) {
		// TODO: Implement
		return null;
	}
	
	private String[] getGrids(String board) {
		// TODO: Implement
		return null;
	}
	
	public int verify(String candidateSolution) {
		if (candidateSolution.matches("[1-9]{81}")) {
			// Check rows
			String[] rows = getRows(candidateSolution);
			for (int i = 0; i < 9; i++)
				if (!Arrays.equals(times(rows[i]), expected))
					return -2;
			// TODO: Implement
			return 0;
		} else
			return -1;
	}
}
