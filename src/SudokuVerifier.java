import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		
		String[][] array = new String[9][9];
		String[] test = candidateSolution.split("");
		//417369825632158947958724316825437169791586432346912758289643571573291684164875293
		int i = 0;
		int x=0;
		int y=0;
		
		//RULE 1 CHECK
		if(Arrays.asList(test).contains("-")) {
			return -1;
		}
		
		//RULE 2 CHECK
		if(test.length > 81) {
			return -2;
		}
		
		//RULE 3 CHECK
		int l = 0;
		String[] upperLeft = new String[9];
		for(int p = 0; p < 9;p++) {
			upperLeft[p] = test[l];
			l++;
		}
	    Set<String> set1= new HashSet<>();
	    for(String k : upperLeft){
	        if(set1.contains(k)){
	            return -3;
	        } else {
	        set1.add(k);         
	        }
	    }
		String[] upperMiddle = new String[9];
		for(int p = 0; p < 9;p++) {
			upperMiddle[p] = test[l];
			l++;
		}
	    Set<String> set2= new HashSet<>();
	    for(String k : upperMiddle){
	        if(set2.contains(k)){
	            return -3;
	        } else {
	        set2.add(k);         
	        }
	    }
		String[] upperRight = new String[9];
		for(int p = 0; p < 9;p++) {
			upperRight[p] = test[l];
			l++;
		}
	    Set<String> set3= new HashSet<>();
	    for(String k : upperRight){
	        if(set3.contains(k)){
	            return -3;
	        } else {
	        set3.add(k);         
	        }
	    }
		String[] middleLeft = new String[9];
		for(int p = 0; p < 9;p++) {
			middleLeft[p] = test[l];
			l++;
		}
	    Set<String> set4= new HashSet<>();
	    for(String k : middleLeft){
	        if(set4.contains(k)){
	            return -3;
	        } else {
	        	set4.add(k);         
	        }
	    }
		String[] middleMiddle = new String[9];
		for(int p = 0; p < 9;p++) {
			middleMiddle[p] = test[l];
			l++;
		}
	    Set<String> set5= new HashSet<>();
	    for(String k : middleMiddle){
	        if(set5.contains(k)){
	            return -3;
	        } else {
	        	set5.add(k);         
	        }
	    }
		String[] middleRight = new String[9];
		for(int p = 0; p < 9;p++) {
			middleRight[p] = test[l];
			l++;
		}
	    Set<String> set6= new HashSet<>();
	    for(String k : middleRight){
	        if(set6.contains(k)){
	            return -3;
	        } else {
	        	set6.add(k);         
	        }
	    }
		String[] lowerLeft = new String[9];
		for(int p = 0; p < 9;p++) {
			lowerLeft[p] = test[l];
			l++;
		}
	    Set<String> set7= new HashSet<>();
	    for(String k : lowerLeft){
	        if(set7.contains(k)){
	            return -3;
	        } else {
	        	set7.add(k);         
	        }
	    }
		String[] lowerMiddle = new String[9];
		for(int p = 0; p < 9;p++) {
			lowerMiddle[p] = test[l];
			l++;
		}
	    Set<String> set8= new HashSet<>();
	    for(String k : lowerMiddle){
	        if(set8.contains(k)){
	            return -3;
	        } else {
	        	set8.add(k);         
	        }
	    }
		String[] lowerRight = new String[9];
		for(int p = 0; p < 9;p++) {
			lowerRight[p] = test[l];
			l++;
		}
	    Set<String> set9= new HashSet<>();
	    for(String k : lowerRight){
	        if(set9.contains(k)){
	            return -3;
	        } else {
	        	set9.add(k);         
	        }
	    }
	    
		//CHECK RULE 4
	    
	    
	    
		//CREATING THE SUDOKU TABLE
		//upper left
		while( i < 9 && x < 3) {
			array[x][y] = test[i];
			i++;
			x++;
			if(x==3) {
				y++;
				x=0;
			}
		}
		//upper middle
		y=0;
		x=3;		
		while( i < 18 && x < 6) {
			array[x][y] = test[i];
			i++;
			x++;
			if(x==6) {
				y++;
				x=3;
			}
		}
		//upper right
		y=0;
		x=6;
		while( i < 27 && x < 9) {
			array[x][y] = test[i];
			i++;
			x++;
			if(x==9) {
				y++;
				x=6;
			}
		}
		
		//middle left
		y=3;
		x=0;
		while( i < 36 && x < 3) {
			array[x][y] = test[i];
			i++;
			x++;
			if(x==3) {
				y++;
				x=0;
			}
		}
		//middle middle
		y=3;
		x=3;		
		while( i < 45 && x < 6) {
			array[x][y] = test[i];
			i++;
			x++;
			if(x==6) {
				y++;
				x=3;
			}
		}
		//middle right
		y=3;
		x=6;
		while( i < 54 && x < 9) {
			array[x][y] = test[i];
			i++;
			x++;
			if(x==9) {
				y++;
				x=6;
			}
		}
		//lower left
		y=6;
		x=0;
		while( i < 63 && x < 3) {
			array[x][y] = test[i];
			i++;
			x++;
			if(x==3) {
				y++;
				x=0;
			}
		}
		//lower middle
		y=6;
		x=3;		
		while( i < 72 && x < 6) {
			array[x][y] = test[i];
			i++;
			x++;
			if(x==6) {
				y++;
				x=3;
			}
		}
		//lower right
		y=6;
		x=6;
		while( i < 81 && x < 9) {
			array[x][y] = test[i];
			i++;
			x++;
			if(x==9) {
				y++;
				x=6;
			}
		}
			/*
            { 4, 1, 7,  6, 3, 2,  9, 5, 8 },
            { 3, 6, 9,  1, 5, 8,  7, 2, 4 },
            { 8, 2, 5,  9, 4, 7,  3, 1, 6 },
            { 8, 2, 5,  7, 9, 1,  3, 4, 6 },
            { 4, 3, 7,  5, 8, 6,  9, 1, 2 },
            { 1, 6, 9,  4, 3, 2,  7, 5, 8 },
            { 2, 8, 9,  5, 7, 3,  1, 6, 4 },
            { 6, 4, 3,  2, 9, 1,  8, 7, 5 },
            { 5, 7, 1,  6, 8, 4,  2, 9, 3 },
            */
		
		return 0;
		
		//check
	}
}
