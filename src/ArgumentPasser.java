
public class ArgumentPasser {
	
	// arguments:
	String sudokuString;
	char[] data;
	char[] sortedNumbers;
	
	// custom constructor;
	public ArgumentPasser(String candidateSolution) {
		sudokuString = candidateSolution;
		data = new char[9];
		sortedNumbers = new char[] {'1','2','3','4','5','6','7','8','9'};
	}
	
	public String getSudokuString(){
		return this.sudokuString;
	}
	
	public char[] getdata(){
		return this.data;
	}
	
	public char[] getsortedNumbers(){
		return this.sortedNumbers;
	}
	
}
