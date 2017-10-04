import java.util.HashSet;
import java.util.Set;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		
		if(!testOfLengthAndNumbers(candidateSolution)) return -1;
		if(!testOfSubgrids(candidateSolution)) return -2;
		if(!testOfRows(candidateSolution)) return -3;
		if(!testOfColumns(candidateSolution)) return -4;

		//returns 0 if the candidate solution is correct
		return 0;
		
		
	}


	//Refactored Consolidate Conditionals for testOfLength and testOfNumbers
	private boolean testOfLengthAndNumbers(String candidateSolution) {
		if(!testOfLength(candidateSolution)) return false;
		else if(!testOfNumbers(candidateSolution)) return false;
		else return true;
	}


	
	private boolean testOfLength(String testable){
		boolean test;
		if(testable.length() == 81) test = true;
		else test = false;
		return test;
	}
	
	private boolean testOfNumbers(String testable){
		boolean test = true;
		for(int i = 0; i < testable.length(); i++){
			if(!Character.isDigit(testable.charAt(i))){
				test = false;
			} else {
				if(Character.getNumericValue(testable.charAt(i)) < 1 || Character.getNumericValue(testable.charAt(i)) > 9){
					test = false;
				}
			}
		}
		return test;
	}
	
	private boolean testOfSubgrids(String testable){
		
		Set<Character> numberSet1 = new HashSet<Character>();
		Set<Character> numberSet2 = new HashSet<Character>();
		Set<Character> numberSet3 = new HashSet<Character>();
		
		for(int i = 0; i < testable.length();i+=9){
			if(i % (testable.length() / 3) == 0){
				numberSet1.clear();
				numberSet2.clear();
				numberSet3.clear();
			}
			for(int j = 0; j < 9;j++){
				if(j < 3){
					if ( numberSet1.contains(testable.charAt(i+j))) {
						return false;
					} else {numberSet1.add(testable.charAt(i+j));}
			        
		        } else if(j < 6){
		        	if ( numberSet2.contains(testable.charAt(i+j))) {
						return false;
		        	} else {numberSet2.add(testable.charAt(i+j));}
		        	
		        } else {
		        	if ( numberSet3.contains(testable.charAt(i+j))) {
		        		return false;
		        	} else {numberSet3.add(testable.charAt(i+j));}
	        	} 
		        
			}
		}
		return true;
	}
	
	private boolean testOfRows(String testable) {
		Set<Character> numberSet = new HashSet<Character>();
			for(int i = 0; i < testable.length();i++){
				if(i % 9 == 0){
					numberSet.clear();
				} 
				if(numberSet.contains(testable.charAt(i))){
					return false;
				} else {
					numberSet.add(testable.charAt(i));
				}
				
			}
		return true;
	}
	
	private boolean testOfColumns(String testable) {
		Set<Character> numberSet = new HashSet<Character>();
		for(int i = 0; i < 9;i++){
			numberSet.clear();
			for(int j = 0; j < testable.length();j+=9){
				if(numberSet.contains(testable.charAt(j))){
					return false;
				} else {
					numberSet.add(testable.charAt(j));
				}
			}
			
		}
	return true;
	}
}
