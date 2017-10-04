import java.util.ArrayList;

public class SudokuVerifier {
	
	protected String solutionString;
	
	protected int rowIndex;
	protected int columnIndex;
	protected int subGridIndex;
	
	protected ArrayList<ArrayList<Character>> rows;
	protected ArrayList<ArrayList<Character>> columns;
	protected ArrayList<ArrayList<Character>> subGrids;
	
	public SudokuVerifier(){
		
		rowIndex = 0;
		columnIndex = 0;
		
		rows = new ArrayList<ArrayList<Character>>();
		columns = new ArrayList<ArrayList<Character>>();
		subGrids = new ArrayList<ArrayList<Character>>();
		
		for(int i = 0; i < 9; i++) {
			ArrayList<Character> row = new ArrayList<Character>();
			rows.add(row);
			
			ArrayList<Character> column = new ArrayList<Character>();
			columns.add(column);
			
			ArrayList<Character> subGrid = new ArrayList<Character>();
			subGrids.add(subGrid);
			
		}
	}
	
	protected void readSolutionString(String aSolutionString) {
		solutionString = aSolutionString;
	}
	
	protected boolean checkSolutionLength() {
		if(solutionString.length() == 81) {
			return true;
		}
		else {
			return false;
		}
	}
	
	protected boolean checkRow(Character aEntry) {
		if(rows.get(rowIndex).contains(aEntry)) {
			return false;
		}
		else {
			rows.get(rowIndex).add(aEntry);
			return true;
		}
	}
	
	protected boolean checkColumn(Character aEntry) {
		if(columns.get(columnIndex).contains(aEntry)) {
			return false;
		}
		else {
			columns.get(columnIndex).add(aEntry);
			return true;
		}
	}
	
	protected boolean checkSubGrid(Character aEntry) {
		if(subGrids.get(subGridIndex).contains(aEntry)) {
			return false;
		}
		else {
			subGrids.get(subGridIndex).add(aEntry);
			return true;
		}
	}
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		//return 0;
		
		readSolutionString(candidateSolution);
		
		if(!checkSolutionLength()) {
			return -5;
		}
		
		rowIndex = 0;
		columnIndex = 0;
		subGridIndex = 0;
		
		
		for(int i = 0; i < solutionString.length(); i++) {
			Character entry = solutionString.charAt(i);
			boolean rowIndexIncremented = false;
			
			if(!Character.isDigit(entry)) {
				return -1;
			}
			
			if(!checkSubGrid(entry)) {
				return -2;
			}
			
			if(!checkRow(entry)) {
				return -3;
			}
			
			if(!checkColumn(entry)) {
				return -4;
			}
			
			if(columnIndex == 8) {
				columnIndex = 0;
			}
			else {
				columnIndex++;
			}
			
			if(columnIndex == 0) {
				
				rowIndex++;
				rowIndexIncremented = true;
			}
			
			if(columnIndex == 3 || columnIndex == 6 || 
					(rowIndexIncremented && (rowIndex == 3 || rowIndex == 6))) {
				subGridIndex++;
			}
			else if(rowIndexIncremented) {
				subGridIndex -= 2;
			}
			
		}
		
		//check
		return 0;
	}
	
}
