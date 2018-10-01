import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891


	
	@Test
	public void testPositeNumbersVerify() {
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		
		String candidateSolution = "1-3456789912345678891234567789123456678912345567891234456789123345678912234567891";
		assertEquals(-1, sudokuVerifier.verify(candidateSolution));
	}
	
	@Test
	public void testGridVerify() {
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		
		String candidateSolution = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		assertEquals(-2, sudokuVerifier.verify(candidateSolution));
	}
	
	@Test
	public void testRowsVerify() {
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		
		String candidateSolution = "123456789912345678891234567789123456678912345567891234456789123345678912234567899";
		assertEquals(-3, sudokuVerifier.verify(candidateSolution));
	}
	
	@Test
	public void testColumnsVerify() {
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		
		String candidateSolution = "123456789123456789123456789123456789123456789123456789123456789123456789123456789";
		assertEquals(-4, sudokuVerifier.verify(candidateSolution));
	}
	
	@Test
	public void testVerify() {
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		
		String candidateSolution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertEquals(0, sudokuVerifier.verify(candidateSolution));
	}
	

}
