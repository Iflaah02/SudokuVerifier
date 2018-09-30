import static org.junit.Assert.*;
import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerify() {
		int verify;
		String[] stringSudoku = new String[2];
		stringSudoku[0] = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		stringSudoku[1] = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		
		SudokuVerifier sudoku = new SudokuVerifier();
		for(int i=0; i<2; i++){
			System.out.println("Sudoku string: " + stringSudoku[i]);
			verify = sudoku.verify(stringSudoku[i]);
			switch (verify) {
				case 0:  System.out.println("it is a valid Sudoku solution");
					break;
				case -1:  System.out.println("it is violating Rule #1");
					break;
				case -2:  System.out.println("it is violating Rule #2");
					break;
				case -3:  System.out.println("it is violating Rule #3");
					break;
				case -4:  System.out.println("it is violating Rule #4");
					break;
				default:  System.out.println("Something is wrong.");
					break;		
					}
		}
	}
}
