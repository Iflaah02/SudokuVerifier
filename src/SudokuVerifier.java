
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		boolean check_invalid_sub_content = false;
		boolean check_valid_string = checkValidString(candidateSolution);
		
		if (check_valid_string == true){
			
			String[] candidateArray = splitByNumber(candidateSolution);
			
			check_invalid_sub_content = checkInvalidSubContent(candidateArray);
			
			if (check_invalid_sub_content == false) {
				return 0;
			}else {
				return 2;
			}
		}else {
			return 1;
		}
	}
	private String[] splitByNumber(String s){
	    int counter = (s.length() / 9) + (s.length() % 9 == 0 ? 0 : 1);
	    String[] candidateArray = new String[counter];
	  
	    for(int i=0;i<counter;i++){
	        candidateArray[i] = s.substring(i*9, Math.min((i+1)*9-1, s.length()));
	    }
	    return candidateArray;
	}
	public boolean checkValidString(String candidateString) {
		String regex = "[0-9]+";
		boolean check = candidateString.matches(regex);
		return check;
	}
	public boolean checkInvalidSubContent(String[] candidateArray) {
		boolean duplicate = false;
		for (int i=0;i<candidateArray.length;i++) {
			for(int a=0; a < candidateArray[i].length(); a++) {
				char[] candidateChar = candidateArray[i].toCharArray();
				for(int x=0; x < candidateChar.length; x++) {
					for (int j = x + 1 ; j < candidateChar.length; j++) {
						if (candidateChar[x] == (candidateChar[j])) {
			                   duplicate = true;
			          	}
					}
				}
			}
		}
		return duplicate;
	}
//	public boolean checkInvalidRowContent(String[] candidateArray) {
//		boolean duplicate = false;
//		for (int i=0;i<candidateArray.length;i++) {
//			
//			for(int a=0; a < candidateArray[i].length(); a++) {
//				char[] candidateChar = candidateArray[i].toCharArray();
//				for (int j = a + 1 ; j < candidateChar.length; j++) {
//			          if (candidateChar[a] == (candidateChar[j])) {
////			                   duplicate = true;
//			          }
//			     }
//			}
//		}
//		return duplicate;
//	}
}
