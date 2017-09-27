import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierParametrizedTest {

	@Test
	public void test_valid_size_fail() {
		SudokuVerifier sudoku = new SudokuVerifier();
		
		int code = sudoku.valid_size("12345678910");
		assertEquals(1,code);
		
	}

	@Test
	public void test_valid_size_pass() {
		SudokuVerifier sudoku = new SudokuVerifier();
		StringBuilder stringBuilder = new StringBuilder();

		


		
		for(int i =0;i<81;i++) {
			
			stringBuilder.append("1");
		}
		String finalString = stringBuilder.toString();
		int code = sudoku.valid_size(finalString);
		assertEquals(0,code);
		
	}
}
