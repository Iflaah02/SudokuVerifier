
public class SudokuVerifier {
	String[] subgrids = new String[9];
	String[] rows = new String[9];
	String[] columns = new String[9];
	
	
	public int verify(String candidateSolution) {
		for(int i = 0; i < candidateSolution.length(); i++) {
			if(Character.getNumericValue(candidateSolution.charAt(i)) > 9 || Character.getNumericValue(candidateSolution.charAt(i)) < 1 ) {
				return -1;
			}
		}
		
		int h = 0;
		for(int i = 0; i < 9; i++) {
			rows[i] = new String(candidateSolution.substring(h, h+9));
			h = h + 9;
		}

		
		StringBuffer temp = new StringBuffer();
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				temp.append(rows[j].charAt(i));
			}
			columns[i] = new String(temp.toString());
			temp = new StringBuffer();
		}
		
		subgrids[0] = new String(rows[0].substring(0,3) + rows[1].substring(0,3) + rows[2].substring(0,3));
		subgrids[1] = new String(rows[0].substring(3,6) + rows[1].substring(3,6) + rows[2].substring(3,6));
		subgrids[2] = new String(rows[0].substring(6,9) + rows[1].substring(6,9) + rows[2].substring(6,9));
		subgrids[3] = new String(rows[3].substring(0,3) + rows[4].substring(0,3) + rows[5].substring(0,3));
		subgrids[4] = new String(rows[3].substring(3,6) + rows[4].substring(3,6) + rows[5].substring(3,6));
		subgrids[5] = new String(rows[3].substring(6,9) + rows[4].substring(6,9) + rows[5].substring(6,9));
		subgrids[6] = new String(rows[6].substring(0,3) + rows[7].substring(0,3) + rows[8].substring(0,3));
		subgrids[7] = new String(rows[6].substring(3,6) + rows[7].substring(3,6) + rows[8].substring(3,6));
		subgrids[8] = new String(rows[6].substring(6,9) + rows[7].substring(6,9) + rows[8].substring(6,9));
	
		//Check for duplicates in subgrids
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				for(int k = 0; k < 9; k++) {
					if(j != k) {
						if(subgrids[i].charAt(j) == subgrids[i].charAt(k)) {
							return -2;
						}
					}
				}
			}
		}
		
		//Check for duplicates in rows
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				for(int k = 0; k < 9; k++) {
					if(j != k) {
						if(rows[i].charAt(j) == rows[i].charAt(k)) {
							return -3;
						}
					}
				}
			}
		}
		
		//Check for duplicates in columns
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				for(int k = 0; k < 9; k++) {
					if(j != k) {
						if(columns[i].charAt(j) == columns[i].charAt(k)) {
							return -4;
						}
					}
				}
			}
		}
		
		return 0;
		
		//check
	}
}
