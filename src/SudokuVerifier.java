
public class SudokuVerifier {
	public int return_code;
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		return_code=valid_size(candidateSolution);
		return 0;
		
		//check
	}
	
	public int valid_size(String s) {
		if (s.length()!=(9*9)){
			return 1;
		}
		return 0;
	}
}


