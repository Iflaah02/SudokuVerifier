import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerify() {
		SudokuVerifier sudoku = new SudokuVerifier();
		String solution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertEquals(0, sudoku.verify(solution));
	}
	
	@Test
	public void testVerifyFail() {
		SudokuVerifier sudoku = new SudokuVerifier();
		String solution = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		assertNotEquals(0, sudoku.verify(solution));
	}

}
