
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		// Check that candidateSolution is as long as needed and contains only numbers 1-9
        if (!verifySolutionString(candidateSolution)) {
            return -1;
        }
        // Verify sudoku
        for (int i = 1; i <= 9; i++) {
            // If subgrid fails return -2
            if (!verifySubstring(getSubgrid(i,candidateSolution))) {
                return -2;
            } else if (!verifySubstring(getLine(i,candidateSolution))) {
                return -3;
            } else if (!verifySubstring((getColumn(i,candidateSolution)))) {
                return -4;
            }
        }

		return 0;
	}

    /**
     * Verify that given solution string is 81 chars long and contains only numbers from 1-9
     * @param candidateSolution
     * @return
     */
	public boolean verifySolutionString(String candidateSolution) {
	    // Check that string is right length
        if (candidateSolution != null && candidateSolution.matches("[1-9]{81}")) {
            return true;
        }
        return false;
    }

    /**
     * Verify that partial solution (9 mark substring) does only contains one of each number 1-9.
     * @param partialSolution
     * @return
     */
    public boolean verifySubstring(String partialSolution) {
        char[] chars = partialSolution.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for(int j = i+1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return false;
                }
            }
        }
	    return true;
    }

    /**
     * Return one line using line number
     * @param lineNumber number of line (1-9)
     * @param candidateSolution
     * @return
     */
    public String getLine(int lineNumber, String candidateSolution) {
        return candidateSolution.substring((lineNumber - 1) * 9,(lineNumber - 1) * 9 + 9);
    }

    /**
     * Return one row using row number
     * @param rowNumber number of row (1-9)
     * @param candidateSolution
     * @return
     */
    public String getColumn(int rowNumber, String candidateSolution) {
        String row = "";
        for(int i = 0; i < 9; i++) {
            row += candidateSolution.charAt((rowNumber - 1) + (i*9));
        }
        return row;
    }

    /**
     * Returns subgrid string
     * @param gridNumber (1-9), 1 = topmost left, 9 = bottommost right
     * @param candidateSolution
     * @return
     */
    public String getSubgrid(int gridNumber, String candidateSolution) {
        String grid = "";
        int startRow = 0;
        if (gridNumber > 3) {
            startRow = 1;
        } if (gridNumber > 6) {
            startRow = 2;
        }
        int index = ((gridNumber -1) * 3) + startRow*18;

        for (int i = 0; i< 3; i++) {
            grid += candidateSolution.substring( index + (i*9), index + (i*9) + 3);
        }
        System.out.print(grid);
        return grid;
    }
}
