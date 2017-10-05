
public class Coordinates {
	public int x;
	public int y;
	
	public Coordinates(int px, int py) {
		x = px;
		y = py;
	}
	
	public int sudokuIndex() {
		return y * 9 + x;
	}
	
}
