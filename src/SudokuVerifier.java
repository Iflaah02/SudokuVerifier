public class SudokuVerifier {
	public int verify(String candidateSolution) {
		int ret = 0;
		for (int i = 0; i < 9; i++) {
			if((ret = verify_all(candidateSolution, i)) < 0) {
				break;
			}
		}
		return ret;
	}
	
	public int verify_set(String set) {
		for (int i = 0; i < 9; i++) {
			char c = set.charAt(i);
			if (c < '1' || c > '9') {
				return -1;
			}
			else if (!set.contains(Integer.toString(i+1))) {
				return -2;
			}
		}
		return 0;
	}
	
	public int verify_grid(String candidateSolution, int grid) {
		String set = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				set += candidateSolution.charAt(
						grid/3*27 + grid%3*3 + i*9 + j
				);
			}
		}
		int ret = verify_set(set);
		return ret;
	}
	
	public int verify_row(String candidateSolution, int row) {
		String set = "";
		for (int i = 0; i < 9; i++) {
			set += candidateSolution.charAt(
					row*9 + i
			);
		}
		int ret = verify_set(set);
		return ret == -2 ? -3 : ret;
	}
	
	public int verify_column(String candidateSolution, int column) {
		String set = "";
		for (int i = 0; i < 9; i++) {
			set += candidateSolution.charAt(
					i*9 + column
			);
		}
		int ret = verify_set(set);
		return ret == -2 ? -4 : ret;
	}
	
	public int verify_all(String candidateSolution, int location) {
		int ret;
		if(
				(ret = verify_grid(candidateSolution, location)) < 0 ||
				(ret = verify_row(candidateSolution, location)) < 0 ||
				(ret = verify_column(candidateSolution, location)) < 0
		) {
				return ret;
		}
		return 0;
	}
}
