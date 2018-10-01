import java.util.HashSet;
import java.util.Set;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		
		if(!testOfBothNumbersAndLength(candidateSolution)) return -1;
		if(!testOfSubgrids(candidateSolution)) return -2;
		if(!testOfRows(candidateSolution)) return -3;
		if(!testOfColumns(candidateSolution)) return -4;

		//returns 0 if the candidate solution is correct
		return 0;
		
		
	}


	//Testing both numbers and length
	private boolean testOfBothNumbersAndLength(String candidateSolution) {
		if(!testOfNumbers(candidateSolution)) return false;
		else if(!testOfLength(candidateSolution)) return false;
		else return true;
	}
	
	// Numbers are between 1 and 9
	private boolean testOfNumbers(String testString){
		boolean test = true;
		for(int i = 0; i < testString.length(); i++){
			if(!Character.isDigit(testString.charAt(i))){
				test = false;
			} else {
				if(Character.getNumericValue(testString.charAt(i)) < 1 || Character.getNumericValue(testString.charAt(i)) > 9){
					test = false;
				}
			}
		}
		return test;
	}
	
	//Length is supposed to be 81
	private boolean testOfLength(String testable){
		boolean test;
		if(testable.length() == 81) test = true;
		else test = false;
		return test;
	}
	
	//Sub-grids should have one of each value between 1-9
	private boolean testOfSubgrids(String testString){
		
		Set<Character> numberSet1 = new HashSet<Character>();
		Set<Character> numberSet2 = new HashSet<Character>();
		Set<Character> numberSet3 = new HashSet<Character>();
		
		for(int i = 0; i < testString.length();i+=9){
			if(i % (testString.length() / 3) == 0){
				numberSet1.clear();
				numberSet2.clear();
				numberSet3.clear();
			}
			
			for(int j = 0; j < 9;j++){
				if(j < 3){
					if ( numberSet1.contains(testString.charAt(i+j))) {
						return false;
					} else {numberSet1.add(testString.charAt(i+j));}
			        
		        } else if(j < 6){
		        	if ( numberSet2.contains(testString.charAt(i+j))) {
						return false;
		        	} else {numberSet2.add(testString.charAt(i+j));}
		        	
		        } else {
		        	if ( numberSet3.contains(testString.charAt(i+j))) {
		        		return false;
		        	} else {numberSet3.add(testString.charAt(i+j));}
	        	} 
		        
			}
		}
		return true;
	}
	
	//Rows should have one of each value between 1-9
	private boolean testOfRows(String testString) {
		Set<Character> numberSet = new HashSet<Character>();
			for(int i = 0; i < testString.length();i++){
				if(i % 9 == 0){
					numberSet.clear();
				} 
				if(numberSet.contains(testString.charAt(i))){
					return false;
				} else {
					numberSet.add(testString.charAt(i));
				}
				
			}
		return true;
	}
	
	// Columns should have one of each value between 1-9
	private boolean testOfColumns(String testString) {
		Set<Character> numberSet = new HashSet<Character>();
		for(int i = 0; i < 9;i++){
			numberSet.clear();
			for(int j = 0; j < testString.length();j+=9){
				if(numberSet.contains(testString.charAt(j))){
					return false;
				} else {
					numberSet.add(testString.charAt(j));
				}
			}
			
		}
	return true;
	}
}