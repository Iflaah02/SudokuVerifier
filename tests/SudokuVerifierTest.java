import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891


	@Test
	public void verify_3or_4() {
		SudokuVerifier sc = new SudokuVerifier();
		assertEquals(-4, sc.verify("123456789912345678691234567789123456478912365567891234456789123345678912234567891"));
	}
	@Test
	public void verify_0() {
		SudokuVerifier sc = new SudokuVerifier();
		assertEquals(0, sc.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293"));
	}
	@Test
	public void verify_2() {
		SudokuVerifier sc = new SudokuVerifier();
		assertEquals(-2, sc.verify("123456789912345678891234567789123456678912345567891234456789123345678912234567891"));
	}
	@Test
	public void verify_1() {
		SudokuVerifier sc = new SudokuVerifier();
		assertEquals(-1, sc.verify("12345678991234567889123456778912345667891234556789123445678912334567891"));
	}
	@Test
	public void verify_1_charactere() {
		SudokuVerifier sc = new SudokuVerifier();
		assertEquals(-1, sc.verify("123456789912345678891234567789123k5667891234556789123445678912334567891"));
	}
	
}
