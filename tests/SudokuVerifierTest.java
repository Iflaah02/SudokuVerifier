import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
	
	private static final String correctSolution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	private static final String incorrectSolution = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";

	@Test
	public void testVerify_returns0ForCorrectSolution() {
		SudokuVerifier sv = new SudokuVerifier();
		assertEquals(0, sv.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293"));
	}
	
	@Test
	public void testVerify_returnsMinus1IfSolutionContainsSomethingOtherThanPositiveDigits() {
		SudokuVerifier sv = new SudokuVerifier();
		assertEquals(-1, sv.verify("023456789912345678891234567789123456678912345567891234456789123345678912234567891"));
	}
	
	@Test
	public void testVerify_returnsMinus2IfSolutionContainsTwoOfTheSameDigitInASubGrid() {
		SudokuVerifier sv = new SudokuVerifier();
		assertEquals(-2, sv.verify("414369825632158947958724316825437169791586432346912758289643571573291684164875293"));
	}
	
	@Test
	public void testVerify_returnsMinus3IfSolutionContainsTwoOfTheSameDigitInAGlobalRow() {
		SudokuVerifier sv = new SudokuVerifier();
		assertEquals(-3, sv.verify("417469825632158947958724316825437169791586432346912758289643571573291684164875293"));
	}

	@Test
	public void testVerify_returnsMinus4IfSolutionContainsTwoOfTheSameDigitInAGlobalColumn() {
		SudokuVerifier sv = new SudokuVerifier();
		assertEquals(-4, sv.verify("417369825432158947958724316825437169791586432346912758289643571573291684164875293"));
	}
}
