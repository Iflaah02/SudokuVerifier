import java.util.ArrayList;
import java.util.List;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		if((candidateSolution.length() != 81) || (candidateSolution.contains("-"))) {
			return -1;
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
		String subGrid;
		List<String> subGrids = new ArrayList<String>();
		
		for(int i=0; i<candidateSolution.length(); i+=27) {
			for(int j=i; j<9; j+=3) {
				subGrid = "";
				for(int k=j; k<k+18;k+=9) {
					for(int l=k; l<l+3;l++) {
						subGrid = subGrid + candidateSolution.substring(l, l+1);
					}
				}
				subGrids.add(subGrid);
			}
		}
		
		return subGrids;
	}
	
}
