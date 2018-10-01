
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		if(!checkIfValuesArePositive(candidateSolution)) return -1;
		else if(!subGridCheck(candidateSolution)) return -2;
		else if(!rowCheck(candidateSolution)) return -3;
		else if(!columnCheck(candidateSolution)) return -4;
		else return 0;
	}
	
	public boolean checkIfValuesArePositive(String str){
		for(int i = 0; i < str.length(); i++){
	        if(!Character.isDigit(str.charAt(i))){
	            return false;
	        }
	        else if(Character.getNumericValue(str.charAt(i)) < 1 || Character.getNumericValue(str.charAt(i)) > 9){
	        	return false;
	        }
	    }
		return true;
	}
	
	public boolean subGridCheck(String str){
		if(str.length() != 81) return false;
		int k = 1;
		for(int i = 0; i < 81; i = i + 3){
			int val = Character.getNumericValue(str.charAt(i));
			if(val == Character.getNumericValue(str.charAt(i+1))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+2))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+9))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+10))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+11))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+18))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+19))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+20))) return false;
			k++;
			if(k == 4){
				i = i + 18;
				k = 1;
			}
		}
		return true;
	}
	
	public boolean rowCheck(String str){
		if(str.length() != 81) return false;
		for(int i = 0; i < 81; i = i + 9){
			int val = Character.getNumericValue(str.charAt(i));
			if(val == Character.getNumericValue(str.charAt(i+1))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+2))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+3))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+4))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+5))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+6))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+7))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+8))) return false;
		}
		return true;
	}
	
	public boolean columnCheck(String str){
		if(str.length() != 81) return false;
		for(int i = 0; i < 9; i++){
			int val = Character.getNumericValue(str.charAt(i));
			if(val == Character.getNumericValue(str.charAt(i+9))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+18))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+27))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+36))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+45))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+54))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+63))) return false;
			else if(val == Character.getNumericValue(str.charAt(i+72))) return false;
		}
		return true;
	}
	
}
