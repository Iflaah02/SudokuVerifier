
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SudokuVerifier {

	/**
	 * public int verify
	 * A method for verifying sudoku solutions
	 *
	 * @param candidateSolution - The Sudoku string
	 * @return
	 * 0: Valid sudoku solution
	 * -1: A cell had a negative digit
	 * -2: A digit repeated in a sub-grid
	 * -3: A digit appeared more than once in a global grid row
	 * -4: A digit appeared more than once in a global grid column
	 * @throws SudokuVerifierException - For other errors, such as null or empty string
	 */
	public int verify(String candidateSolution) throws SudokuVerifierException {

		//Check if the string has negative digits
		if (!isCandidateValid(candidateSolution)) {
			throw new SudokuVerifierException();
		} else if (hasNegativeDigits(candidateSolution)) {
			return -1;
		}

		List<Integer> candidateSolutionNumbers = convertToNumberArray(candidateSolution);
		if (doesAnySubGridHaveDuplicates(candidateSolutionNumbers)) {
			return -2;
		} else if (hasGlobalRowDuplicates(candidateSolutionNumbers)) {
			return -3;
		} else if (hasGlobalColumnDuplicates(candidateSolutionNumbers)) {
			return -4;
		} else {
			return 0;
		}
	}

	/**
	 * private boolean isCandidateValid
	 * Checks if the candidateSolution is invalid (doesn't match regex, is null, is empty etc.)
	 *
	 * @param candidateSolution - The string to be tested.
	 * @return true/false depending on if errors need to be thrown or not
	 */
	private boolean isCandidateValid(String candidateSolution) {
		String regex = "[1-9, /-]+";
		if (candidateSolution != null && !candidateSolution.isEmpty()) {
			if(!candidateSolution.matches(regex)) {
				return false;
			} else return candidateSolution.length() == 81;
		} else {
			return false;
		}
	}

	/**
	 * private boolean hasNegativeDigits
	 * Checks if the candidateSolution has negative digits.
	 *
	 * @param candidateSolution - The string to be tested
	 * @return true/false depending on if the string had negative digits or not
	 */
	private boolean hasNegativeDigits(String candidateSolution) {
		return candidateSolution.contains("-");
	}

	/**
	 * private boolean doesAnySubGridHaveDuplicates
	 * Verify if the subgrid of the sudoku solution was valid or not
	 *
	 * @param candidateSolution - The solution to be tested
	 * @return true/false depending on if the subgrid was valid or not
	 */
	private boolean doesAnySubGridHaveDuplicates(List<Integer> candidateSolution) {
		int i = 0;
		while (i < 7) {
			if (doesSubGridHaveDuplicates(candidateSolution, i)) {
				return true;
			}
			i = i + 3;
		}
		i = 27;
		while (i < 34) {
			if (doesSubGridHaveDuplicates(candidateSolution, i)) {
				return true;
			}
			i = i + 3;
		}
		i = 54;
		while (i < 61) {
			if (doesSubGridHaveDuplicates(candidateSolution, i)) {
				return true;
			}
			i = i + 3;
		}
		return false;
	}

	/**
	 * private boolean doesSubGridHaveDuplicates
	 * Checks if subgrid has any duplicates
	 * @param candidateSolution - The solution to be checked
	 * @param firstIndex - The first row
	 * @return true/false, depending if a duplicate was found or not
	 */
	private boolean doesSubGridHaveDuplicates(List<Integer> candidateSolution, int firstIndex) {
		ArrayList<Integer> subGrid = new ArrayList<>();
		subGrid.addAll(candidateSolution.subList(firstIndex, firstIndex + 3));
		subGrid.addAll(candidateSolution.subList(firstIndex + 9, firstIndex + 12));
		subGrid.addAll(candidateSolution.subList(firstIndex + 18, firstIndex + 21));
		List<Integer> subGridWithoutDuplicates = subGrid.stream().distinct().collect(Collectors.toList());
		return subGridWithoutDuplicates.size() != 9;
	}

	/**
	 * private boolean hasGlobalRowDuplicates
	 * Verifies that the global rows don't have digits repeating
	 *
	 * @param candidateSolution - The solution to be tested
	 * @return true/false depending on if the row was valid or not
	 */
	private boolean hasGlobalRowDuplicates(List<Integer> candidateSolution) {
		int i = 0;
		while (i < candidateSolution.size()) {
			ArrayList<Integer> currentRow = new ArrayList<>(candidateSolution.subList(i, i + 9));
			List<Integer> rowWithoutDuplicates = currentRow.stream().distinct().collect(Collectors.toList());
			if (rowWithoutDuplicates.size() != 9) {
				return true;
			}
			i = i + 9;
		}
		return false;
	}

	/**
	 * private boolean hasGlobalColumnDuplicates
	 * Verifies that the global columns don't have digits repeating
	 *
	 * @param candidateSolution - The solution to be tested
	 * @return true/false depending on if the column was valid or not
	 */
	private boolean hasGlobalColumnDuplicates(List<Integer> candidateSolution) {
		ArrayList<Integer> firstRow = new ArrayList<>(candidateSolution.subList(0, 9));
		ArrayList<Integer> secondRow = new ArrayList<>(candidateSolution.subList(9, 18));
		ArrayList<Integer> thirdRow = new ArrayList<>(candidateSolution.subList(18, 27));

		ArrayList<Integer> fourthRow = new ArrayList<>(candidateSolution.subList(27, 36));
		ArrayList<Integer> fifthRow = new ArrayList<>(candidateSolution.subList(36, 45));
		ArrayList<Integer> sixthRow = new ArrayList<>(candidateSolution.subList(45, 54));

		ArrayList<Integer> seventhRow = new ArrayList<>(candidateSolution.subList(54, 63));
		ArrayList<Integer> eighthRow = new ArrayList<>(candidateSolution.subList(63, 72));
		ArrayList<Integer> ninthRow = new ArrayList<>(candidateSolution.subList(72, 81));

		for (int i = 1; i < 9; i++) {
			ArrayList<Integer> tmpList = new ArrayList<>();
			tmpList.add(firstRow.get(i));
			tmpList.add(secondRow.get(i));
			tmpList.add(thirdRow.get(i));

			tmpList.add(fourthRow.get(i));
			tmpList.add(fifthRow.get(i));
			tmpList.add(sixthRow.get(i));

			tmpList.add(seventhRow.get(i));
			tmpList.add(eighthRow.get(i));
			tmpList.add(ninthRow.get(i));

			List<Integer> rowWithoutDuplicates = tmpList.stream().distinct().collect(Collectors.toList());
			if (rowWithoutDuplicates.size() != 9) {
				return true;
			}
		}
		return false;
	}

	/**
	 * private List<Integer> convertToNumberArray
	 * Converts the solution into a list of numbers
	 *
	 * @param candidateSolution - The solution to be tested
	 * @return candidateAsNumbers - The solution as list of numbers
	 */
	private List<Integer> convertToNumberArray(String candidateSolution) {
		List<Integer> candidateAsNumbers = new ArrayList<>();
		List<Character> characters = candidateSolution.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

		characters.forEach(c -> candidateAsNumbers.add(Integer.valueOf(c)));

		return candidateAsNumbers;
	}
}
