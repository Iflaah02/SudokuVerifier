import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

	// A correct Sudoku string:
	// 417369825632158947958724316825437169791586432346912758289643571573291684164875293
	// An incorrect Sudoku string:
	// 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerify() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsSolutionValid() {
		
		SudokuVerifier sdk = new SudokuVerifier();
		int res = sdk.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		// int res =
		// sdk.verify("123456789912345678891234567789123456678912345567891234456789123345678912234567891");
		assertEquals("String is correct", 0, res);
	}

	@Test
	public void testRule_1() {

		SudokuVerifier sdk = new SudokuVerifier();
		int res = sdk.checkNegtaiveNumber(
				"-417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals("Violating Rule #1",-1, res);
	}
	@Test
	public void testRule_2() {

		SudokuVerifier sdk = new SudokuVerifier();
		int res = sdk.verify(
				"123456789912345678891234567789123456678912345567891234456789123345678912234567891");
		assertEquals("Violating Rule #2",-2, res);
	}

	@Test
	public void testRule_3() {

		SudokuVerifier sdk = new SudokuVerifier();
		int res = sdk.verify(
				"417349825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals("Violating Rule #3",-3, res);
	}
	@Test
	public void testRule_4() {

		SudokuVerifier sdk = new SudokuVerifier();
		int res = sdk.verify(
				"417369825612158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals("Violating Rule #4",-4, res);
	}
	@Test
	public void testSolutionWithZeroValue() {

		SudokuVerifier sdk = new SudokuVerifier();
		boolean res = sdk
				.checkZero("017369825632158947958724316825437169791586432346912758289643571573291684164875293");

		assertTrue("String is Invalid", res);
	}

}
