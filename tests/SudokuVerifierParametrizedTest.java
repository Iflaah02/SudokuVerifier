import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierParametrizedTest {

	
	@Test
	public void testPositeNumbers() {
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		
		String candidateSolution = "1-23456789912345678891234567789123456678912345567891234456789123345678912234567891";
		assertEquals(false, sudokuVerifier.positive(candidateSolution));
	}
	
	@Test
	public void testRowFalse() {
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		
		String candidateSolution = "123456789912345678891234567789123456678912345567891234456789123345678912234567899";
		assertEquals(false, sudokuVerifier.row(candidateSolution));
	}
	
	@Test
	public void testRowTrue() {
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		
		String candidateSolution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertEquals(true, sudokuVerifier.row(candidateSolution));
	}
	
	@Test
	public void testColumnFalse() {
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		
		String candidateSolution = "123456789912345678891234567789123456678912345567891234456789123345678912234567899";
		assertEquals(false, sudokuVerifier.column(candidateSolution));
	}
	
	@Test
	public void testColumnTrue() {
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		
		String candidateSolution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertEquals(true, sudokuVerifier.row(candidateSolution));
	}
	
	@Test
	public void testGridFalse() {
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		
		String candidateSolution = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		assertEquals(false, sudokuVerifier.grid(candidateSolution));
	}
	
	@Test
	public void testGridTrue() {
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		
		String candidateSolution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertEquals(true, sudokuVerifier.grid(candidateSolution));
	}
	
	@Test
	public void testFormatFalse() {
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		
		String candidateSolution = "17369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertEquals(false, sudokuVerifier.correctFormat(candidateSolution));
	}
	
	@Test
	public void testFormatTrue() {
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		
		String candidateSolution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertEquals(true, sudokuVerifier.correctFormat(candidateSolution));
	}
}
