import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SudokuBoard {

	private static Integer SET_SIZE = 9;
	private Integer[][] board;
	
	public SudokuBoard(String boardConfig) throws Exception {
		board = new Integer[SET_SIZE][SET_SIZE];
		int pos = 0;
		
		for(int i = 0; i < SET_SIZE; i++) {
			for(int j = 0; j < SET_SIZE; j++) {
				board[i][j] = boardConfig.charAt(pos) - '0';
				pos++;
			}
		}
	}
	
	public List<List<Integer>> getRows(){
		List<List<Integer>> rowList = new LinkedList<List<Integer>>(); 
		
		for(int i = 0; i < SET_SIZE; i++) {
				rowList.add(Arrays.asList(board[i]));
		}
		
		return rowList;
	}
	
	public List<List<Integer>> getCols(){
		List<List<Integer>> colList = new LinkedList<List<Integer>>(); 
		
		for(int i = 0; i < SET_SIZE; i++) {
			List<Integer> col = new LinkedList<Integer>();
			
			for(int j = 0; j < SET_SIZE; j++) {
				col.add(board[j][i]);
			}
			
			colList.add(col);
		}
		
		return colList;
	}
	
	public List<List<Integer>> getGrids(){
		List<List<Integer>> gridList = new LinkedList<List<Integer>>(); 
		
		for(int xIndex = 1; xIndex < SET_SIZE; xIndex+=3) {
			for(int yIndex = 1; yIndex < SET_SIZE; yIndex+=3) {
				
				List<Integer> grid = extractGrid(xIndex, yIndex);
				gridList.add(grid);
			}
		}
		
		return gridList;
	}
	
	private List<Integer> extractGrid(int centerX, int centerY) {
		List<Integer> grid = new LinkedList<Integer>();
		
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j<= 1; j++) {
				int x = centerX + i;
				int y = centerY + j;
				grid.add(board[x][y]);
			}
		}
		
		return grid;
	}
}
