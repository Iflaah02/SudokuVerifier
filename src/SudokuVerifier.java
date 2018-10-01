import java.util.ArrayList;
import java.util.List;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		if((candidateSolution.length() != 81) || (!candidateSolution.matches("[1-9]+"))) {
			return -1;
		}
		
		List<String> rows = getRows(candidateSolution);
		List<String> columns = getRows(candidateSolution);
		List<String> subGrids = getSubGrids(candidateSolution);
		
		if(!verifyList(subGrids)) {
			return -2;
		}
		
		if(!verifyList(rows)) {
			return -3;
		}
		
		if(!verifyList(columns)) {
			return -4;
		}
		
		return 0;
	}
	
	List<String> getRows(String candidateSolution){
		List<String> rows = new ArrayList<String>();
		
		for(int i=0; i<candidateSolution.length(); i+=9) {
			rows.add(candidateSolution.substring(i, Math.min(candidateSolution.length(), i + 9)));
		}
		
		return rows;
	}
	
	List<String> getColumns(String candidateSolution){
		String column;
		List<String> columns = new ArrayList<String>();
		
		for(int i=0; i<9; i++) {
			column = "";
			for(int j=i; j<candidateSolution.length();j+=9) {
				column = column + candidateSolution.substring(j, j+1);
			}
			columns.add(column);
		}
		
		return columns;
	}
	
	List<String> getSubGrids(String candidateSolution){
		String subGrid1 = "";
		String subGrid2 = "";
		String subGrid3 = "";
		List<String> subGrids = new ArrayList<String>();
		List<String> rows = getRows(candidateSolution);
		
		for(int i=0; i<9; i++) {
			String row = rows.get(i);
			subGrid1 = subGrid1 + row.substring(0, 3);
			subGrid2 = subGrid2 + row.substring(3, 6);
			subGrid3 = subGrid3 + row.substring(6, 9);
			//add finished grids and reset the strings every third loop
			if((i==2) || (i==5) || (i==8)) {
				subGrids.add(subGrid1);
				subGrids.add(subGrid2);
				subGrids.add(subGrid3);
				subGrid1 = "";
				subGrid2 = "";
				subGrid3 = "";
			}
		}
		
		return subGrids;
	}
	
	boolean verifyList(List<String> listToVerify) {
		for(int i=0; i<listToVerify.size(); i++) {
			if(listToVerify.get(i).contains("1") &&
			listToVerify.get(i).contains("2") &&
			listToVerify.get(i).contains("3") &&
			listToVerify.get(i).contains("4") && 
			listToVerify.get(i).contains("5") && 
			listToVerify.get(i).contains("6") && 
			listToVerify.get(i).contains("7") && 
			listToVerify.get(i).contains("8") && 
			listToVerify.get(i).contains("9")) {
				//list is fine
			}
			else {
				return false;
			}
		}
		
		return true;
	}
	
}
