
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		boolean check_valid_string = checkValidString(candidateSolution);
		
		if (check_valid_string == true){
			List<String> candidateArray = convertToArray(candidateSolution);
			
			boolean check_invalid_sub_content = checkInvalidSubContent(candidateArray);
		//	boolean check_invalid_row_content = checkInvalidRowContent(candidateArray);
			if (check_invalid_sub_content == false) {
				
				//if (check_invalid_row_content == false){
				//	return 0;
				//}
				//else{
					//return 3;
					return 0;
				//}
			}else {
				return 2;
			}
		}else {
			return 1;
		}
	}
	public List<String> convertToArray(String candidateSolution){
		List<String> candidateArray = new ArrayList<String>();
		int index = 0;
		while (index < candidateSolution.length()) {
			candidateArray.add(candidateSolution.substring(index, Math.min(index + 9,candidateSolution.length())));
		    index += 9;
		}
		return candidateArray;
	}

	public boolean checkValidString(String candidateString) {
		String regex = "[0-9]+";
		boolean check = candidateString.matches(regex);
		return check;
	}
	public boolean checkInvalidSubContent(List<String> candidateArray) {
		boolean duplicate = false;
		for (int i=0;i<candidateArray.size();i++) {
				char[] candidateChar = candidateArray.get(i).toCharArray();
				for(int x=0; x < candidateChar.length; x++) {
					for (int j = 0 ; j < candidateChar.length; j++) {
						 if (j!=x && candidateChar[j] == candidateChar[x]){
						      duplicate=true;
			          	}
					}
				}
				candidateChar = null;
		}
		return duplicate;
	}
	//public boolean checkInvalidRowContent(List<String> candidateArray) {
	//	boolean duplicate = false;
	//	int i=0;
	//	int subContentCounter  = 3;
	//	List<String> rowArray = new ArrayList<String>();
	//	while(i<subContentCounter) {
			
	//		char[] candidateChar = candidateArray.get(subContentCounter).toCharArray();
			//String temp = candidateArray.get(i);
	//		for(int x=0; x < 3; x++) {
	//			rowArray.add(String.valueOf(candidateChar[x]));
	//		}
			
			//	
		//			for (int j = 0 ; j < candidateChar.length; j++) {
		//				 if (j!=x && candidateChar[j] == candidateChar[x]){
		//					 System.out.println("true");
		///				      duplicate=true;
		//	          	}
		//			}
		//		}
			//	candidateChar = null;
		//	i++;
		//	subContentCounter +=3;
		//}
		//return duplicate;
	//}
}
