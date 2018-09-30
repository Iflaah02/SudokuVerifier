import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SudokuVerifier {
	
	public int verify(String str){
		if(verifyNumber(str) == -1){
			return -1;
		}
		if(checkSubGrid(str) == -2){
			return -2;
		}
		if(checkGlobalRow(str) == -3){
			return -3;
		}
		if(checkGlobalColumn(str) == -4){
			return -4;
		}
		return 0;
	}

	
	public int verifyNumber(String candidateSolution){
		char[] charSolution = candidateSolution.toCharArray();
		int[] numbers = new int[charSolution.length];
		
		if(charSolution.length != 81){
			return -1;
		}
		
		for(int i=0; i< charSolution.length; i++){
			numbers[i] = Integer.parseInt(String.valueOf(candidateSolution.charAt(i)));
			if(numbers[i] <=0 || numbers[i] > 9){
				return -1;
			}
		}				
		return 0;				
	}
	
	
	public int[][] convertToArray(String str){
		int[] numbers = new int[str.length()];	
		int[][] subGrid = new int[9][9];
		
		for(int m=0; m< str.length(); m++){
			numbers[m] = Integer.parseInt(String.valueOf(str.charAt(m)));
			}
		
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				subGrid[i][j] = numbers[9*i+j];
			}
		}
		
		return subGrid;
	}
	
	
	public int checkGlobalRow(String str){
		int[][] subGrid = convertToArray(str);
		for(int i=0; i<subGrid.length; i++){
			Set<Integer> set = new TreeSet<>();
			for(int j=0; j<subGrid.length; j++){
				set.add(subGrid[i][j]);
			}			
			if(set.size() != subGrid.length ){
				return -3;
			}
		}
		return 0;
	}
	
	public int checkGlobalColumn(String str){
		int[][] subGrid = convertToArray(str);
		for(int i=0; i<subGrid.length; i++){
			Set<Integer> set = new TreeSet<>();
			for(int j=0; j<subGrid.length; j++){
				set.add(subGrid[j][i]);
			}			
			if(set.size() != subGrid.length ){
				return -4;
			}
		}
		return 0;
	}
	
	public int checkSubGrid(String str){
		String[] str1 = new String[str.length()/3];
		String[] str2 = new String[str.length()/9];
		String temp = "";
		int k=0;
		int[] numbers = new int[str.length()/9];	

		for(int i=0; i<27; i++){
			str1[i] = str.substring(3*i, 3*i+3);
		}
		
		while(k<9){		
			for(int j=0; j<3; j++){
				for(int i=0; i<3; i++){
						temp = temp + str1[i+j*9]+str1[i+3+j*9]+str1[i+6+j*9];
						str2[k] = temp;
						k++;
						temp = "";
				}									
			}		
			}

		for(int i=0; i<str2.length; i++){
			Set<Integer> set = new TreeSet<>();
			for(int m=0; m<str2[i].length(); m++){			
				int a = Integer.parseInt(String.valueOf(str2[i].charAt(m)));
				set.add(a);
			}
			if(set.size() != str2[i].length()){
				return -2;
			}
		}		
		
		return 0;
	}
}
