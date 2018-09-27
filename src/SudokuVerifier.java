import java.util.Arrays;

public class SudokuVerifier {
	
	// Expected appearance of digit distribution
	private final int[] expected =
		{1,1,1,1,1,1,1,1,1};
	
	// How many times each digit appears
	private int[] times(String part) {
		int[] res = new int[9];
		for (int i = 0; i < 9; i++)
			res[Character.getNumericValue(part.charAt(i)-1)]++;
		return res;
	}
	
	private String[] getSubGrids(String board) {
		String[] res = new String[9];
		for (int i = 0; i < 3; i++) {
			res[3*i] = board.substring(27*i, 27*i+3)
					+ board.substring(27*i+9, 27*i+12)
					+ board.substring(27*i+18, 27*i+21);
			res[3*i+1] = board.substring(27*i+3, 27*i+6)
					+ board.substring(27*i+12, 27*i+15)
					+ board.substring(27*i+21, 27*i+24);
			res[3*i+2] = board.substring(27*i+6, 27*i+9)
					+ board.substring(27*i+15, 27*i+18)
					+ board.substring(27*i+24, 27*i+27);
		}
		return res;
	}
	
	private String[] getRows(String board) {
		String[] res = new String[9];
		for (int i = 0; i < 9; i++)
			res[i] = board.substring(9*i, 9*(i+1));
		return res;
	}
	
	private String[] getColums(String board) {
		String[] res = new String[9];
		for (int i = 0; i < 9; i++)
			res[i] = String.valueOf(board.charAt(i))
					+ String.valueOf(board.charAt(i+9))
					+ String.valueOf(board.charAt(i+18))
					+ String.valueOf(board.charAt(i+27))
					+ String.valueOf(board.charAt(i+36))
					+ String.valueOf(board.charAt(i+45))
					+ String.valueOf(board.charAt(i+54))
					+ String.valueOf(board.charAt(i+63))
					+ String.valueOf(board.charAt(i+72));
		return res;
	}
	
	public int verify(String candidateSolution) {
		if (candidateSolution.matches("[1-9]{81}")) {
			// Check sub-grids
			String[] subgrids = getSubGrids(candidateSolution);
			for (int i = 0; i < 9; i++)
				if (!Arrays.equals(times(subgrids[i]), expected))
					return -2;
			// Check rows
			String[] rows = getRows(candidateSolution);
			for (int i = 0; i < 9; i++)
				if (!Arrays.equals(times(rows[i]), expected))
					return -3;
			// Check columns
			String[] columns = getColums(candidateSolution);
			for (int i = 0; i < 9; i++)
				if (!Arrays.equals(times(columns[i]), expected))
					return -4;
			// Everything OK - valid string
			return 0;
		} else
			return -1;
	}
}
