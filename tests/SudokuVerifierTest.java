import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void Verify_valid_return_0() {
		// Arrange
		SudokuVerifier sv = new SudokuVerifier();
		// Act
		int result = sv.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		// Act
		assertEquals(0, result);
	}

	@Test
	public void Verify_invalid_return_less_than_zero() {
		// Arrange
		SudokuVerifier sv = new SudokuVerifier();
		// Act
		int result = sv.verify("123456789912345678891234567789123456678912345567891234456789123345678912234567891");
		// Act
		assertTrue(result < 0 );
	}
}
