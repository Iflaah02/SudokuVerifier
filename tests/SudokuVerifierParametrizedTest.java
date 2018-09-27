import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierParametrizedTest {

	@Test
	public void testcheckNegative_negative() {
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(-1,(sudoku.checkPositive("-1")));
	}
	
	@Test
	public void testcheckPoisitive_positive() {
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(0,(sudoku.checkPositive("1")));
	}

}
