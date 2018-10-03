import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerify_correct() {
		SudokuVerifier verif = new SudokuVerifier();
		String correct = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		assertEquals(0, verif.verify(correct));
	}
	
	@Test
	public void testVerify_incorrect() {
		SudokuVerifier verif = new SudokuVerifier();
		String incorrect = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		
		assertFalse(0 == verif.verify(incorrect));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testVerify_incorrectInput() {
		SudokuVerifier verif = new SudokuVerifier();
		String incorrect = "12345678991234567889123456778912345667891234556789123445678912334567891223456789"; // 80 characters long
		verif.verify(incorrect);
	}
}
