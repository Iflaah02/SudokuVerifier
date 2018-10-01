import java.util.Arrays;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		if(candidateSolution.length() != 81)
		{
			return 99;
		}
		
		//Check Rows
		
		
		// returns 0 if the candidate solution is correct
		return 0;
		
		//check
	}
	
	public int CheckRows(String str) {
		//Get rows
		String[] ar = StringSplitterRows(str);
		for(int i=0;i<8;i++) {
			int[] ints = StringToIntArray(ar[i]);
			ints = SortSudokuRow(ints);
			if(!RowHasNoMinus(ints)) return -2;
			if(!NumberOnlyOnce(ints)) return -3;
		}
		return 0;
	}
		
	
	public String[] StringSplitterRows(String str) {
		
		String[] rows = new String[9];
		int pointer = 0;
		for(int i=0;i<8;i++) {
			rows[i] = str.substring(pointer,pointer+9);
			pointer += 9;
		}
		return rows;
	}
	
public String[] StringSplitterColums(String str) {
		
		String[] rows = new String[9];
		int pointer = 0;
		for(int i=0;i<9;i++) {
			rows[i] = Character.toString( str.charAt(pointer));
			for(int c = 1; c < 9 ; c++) {
				rows[i] += str.charAt(pointer+(c*9));
			}
			pointer += 1;
		}
		return rows;
	}
	
	public int[] StringToIntArray(String str) {
		String[] ar = str.split("",9);
		int[] ints = new int[9]; 
		for(int i = 0; i < 9 ;i++) {
			ints[i]= Integer.parseInt(ar[i]);
		}
		return ints;
	}
	
	public void PrintRows(String[] rows) {
		for(int i=0;i<rows.length;i++) {
			System.out.println("Row["+i+"] : "+rows[i]);
		}
	}
	
	public int[] SortSudokuRow(int[] row) {
		//sorts array to order 1,2,3..
		Arrays.sort(row);
		return row;
	}
	
	public boolean RowHasNoMinus(int[] row) {
		
		//No -1 etc. numbers
		for(int i=0; i<8 ;i++) {
			if(row[i]<1) return false;	
		}
		return true;
	}
	
	public boolean NumberOnlyOnce(int[] row) {
		for(int i=0;i<8;i++) {
			if(row[i]!=i+1) return false;
		}
		return true;
	}
	
	
}
	
