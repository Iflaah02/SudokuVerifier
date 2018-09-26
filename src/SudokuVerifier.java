import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SudokuVerifier {

	public static void main(String[] args) {
		SudokuVerifier sud = new SudokuVerifier();
		sud.checkColumns("123456789912345678891234567789123456678912345567891234456789123345678912234567891");
	}

	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		if (!checkStringValid(candidateSolution))
			return -1;
		if (!checkStringLength(candidateSolution))
			return -1;
		if (!checkSubGrid(candidateSolution))
			return -2;
		if (!checkRows(candidateSolution))
			return -3;
		if (!checkColumns(candidateSolution))
			return -4;
		return 0;

	}

	public boolean checkColumns(String candidateSolution) {
		// Assuming the length is 81
		int[] sums = new int[9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int power = Integer.valueOf(String.valueOf(candidateSolution.charAt(j * 9 + i)));
				sums[i] += Math.pow(2, power);
			}
		}
		return checkValidSums(sums);
	}

	public boolean checkRows(String candidateSolution) {
		// Assuming the length is 81
		int[] sums = new int[9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int power = Integer.valueOf(String.valueOf(candidateSolution.charAt(i * 9 + j)));
				sums[i] += Math.pow(2, power);
			}
		}
		return checkValidSums(sums);
	}

	public boolean checkSubGrid(String candidateSolution) {
		// Assuming the length is 81
		int[] sums = new int[9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int index = (i / 3 * 3) + j / 3;
				int power = Integer.valueOf(String.valueOf(candidateSolution.charAt(i * 9 + j)));
				sums[index] += Math.pow(2, power);
			}
		}
		return checkValidSums(sums);
	}

	private boolean checkValidSums(int[] sums) {
		for (int sum : sums) {
			//System.out.println(sum);
			if (sum != 1022)
				return false;
		}
		return true;
	}

	public boolean checkStringLength(String candidateSolution) {
		return candidateSolution.length() == 81;
	}

	public boolean checkStringValid(String candidateSolution) {
		Pattern regex = Pattern.compile("\\D|0");
		Matcher m = regex.matcher(candidateSolution);
		if (m.find()) {
			return false;
		}
		return true;
	}
}
