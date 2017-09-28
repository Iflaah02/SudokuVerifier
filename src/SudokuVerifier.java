
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		
		return 0;
		
		//check
	}
	
	public int checkLenght(String candidateSolution) {
		int solutionLenght = candidateSolution.length();
		
		if (solutionLenght > 81) {
			return -5;
		} else {
			return 0;
		}
	}
	
	public String[] sliceString(String candidateSolution) {
		String[] rows = {};
		for (int i = 0; i < candidateSolution.length(); i += 10) {
			rows[i] = candidateSolution.substring(i, Math.min(i + 10, candidateSolution.length()));
			}
		return rows;
	}
 }
