import java.util.HashMap;
import java.util.regex.*;

public class SudokuVerifier {

  public int verify(String candidateSolution) {
    if (!isStringValid(candidateSolution)) {
      return -1;
    }
    // check
    int[][] grid = parseInput(candidateSolution);

    // check sub grids
    for (int i = 0; i < 9; i += 3) {
      for (int j = 0; j < 9; j += 3) {
        int[] cell = new int[] {
          grid[i][j],
          grid[i][j + 1],
          grid[i][j + 2],
          grid[i + 1][j],
          grid[i + 1][j + 1],
          grid[i + 1][j + 2],
          grid[i + 2][j],
          grid[i + 2][j + 1],
          grid[i + 2][j + 2],
        };
        if (!isSectionValid(cell)) {
          return -2;
        }
      }
    }

    // check rows
    for (int i = 0; i < grid.length; i++) {
      if (!isSectionValid(grid[i])) {
        return -3;
      }
    }

    // check columns
    for (int i = 0; i < grid.length; i++) {
      int[] column = new int[] {
        grid[0][i],
        grid[1][i],
        grid[2][i],
        grid[3][i],
        grid[4][i],
        grid[5][i],
        grid[6][i],
        grid[7][i],
        grid[8][i],
      };
      if (!isSectionValid(column)) {
        return -4;
      }
    }
    // returns 0 if the candidate solution is correct
    return 0;
  }

  public boolean isStringValid(String string) {
    // Check if the string is 81 chars long.
    if (string.length() != 81) {
      return false;
    }
    // Make sure it only has the characters 1, 2, ..., 9
    if (Pattern.compile("[^1-9]").matcher(string).find()) {
      return false;
    }
    return true;
  }

  public int[][] parseInput(String input) {
    int[][] result = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        result[i][j] = Integer.parseInt(Character.toString(input.charAt(i * 9 + j)));
      }
    }
    return result;
  }

  public boolean isSectionValid(int[] row) {
    HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
    for (int i : row) {
      int c = counts.getOrDefault(i, 0);
      c++;
      counts.put(i, c);
    }
    for (int c : counts.values()) {
      if (c > 1) {
        return false;
      }
    }
    return true;
  }

  public boolean isCellValid(int[][] cell) {
    HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
    for (int i = 0; i < cell.length; i++) {
      for (int j = 0; j < cell[i].length; j++) {
        int c = counts.getOrDefault(cell[i][j], 0);
        c++;
        counts.put(i, c);
      }
    }
    for (int c : counts.values()) {
      if (c > 1) {
        return false;
      }
    }
    return true;
  }
}
