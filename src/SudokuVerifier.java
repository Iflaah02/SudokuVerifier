public class SudokuVerifier {
	
	public boolean checkInputValidity (String candidateSolution) {
		return candidateSolution.length() == 81 && candidateSolution.matches("\\d+");
	}
	
	private boolean checkUniqueInRange (checkRange range, String str) {
		boolean noRepeat = true;
		for (int i= range.start; i< range.end; i++) { // try with pattern
			if (i != range.pos && str.charAt(i) == str.charAt(range.pos)) {
				noRepeat = false;
				break;
			}
		}
		return noRepeat;
	}
	
	private boolean checkRule2 (String candidateSolution) {
		boolean pass = true;
		while (pass) {
			for (int i=0; i<candidateSolution.length();i++) { // make use of checkUniqueInRange
				
			}
			
		}
		return pass;
	}
	
	private boolean checkRule3 (String candidateSolution) {
		return 1==2;
	}
	
	private boolean checkRule4 (String candidateSolution) {
		return 1==2;
	}
	
	public int verify(String candidateSolution) {
		if (!checkInputValidity(candidateSolution)) { // Invalid input
			return -1;
		}else if (!checkRule2(candidateSolution)){ // check for rule#2
			return -2;
		}else if (!checkRule3(candidateSolution)){
			return -3;
		}else if (!checkRule4(candidateSolution)){
			return -4;
		}
		return 0;
	}
}
