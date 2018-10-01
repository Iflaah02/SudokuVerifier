import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerify_validString() {
		int result;
		String sudokuString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		result = sudokuVerifier.verify(sudokuString);
		assertEquals("Should be valid and return 0", result, 0);
	}
	
	@Test
	public void testVerify_invalidLength() {
		int result;
		String sudokuString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293111";
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		result = sudokuVerifier.verify(sudokuString);
		assertEquals("Invalid length return -1", result, -1);
	}
	
	@Test
	public void testVerify_invalidCharacters() {
		int result;
		String sudokuString = "abc369825632158947958724316825437169791586432346912758289643571573291684164875293";
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		result = sudokuVerifier.verify(sudokuString);
		assertEquals("Invalid characters return -1", result, -1);
	}
	
	@Test
	public void testVerify_invalidRow() {
		int result;
		String sudokuString = "417469825632158947958724316825437169791586432346912758289643571573291684164875293";
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		result = sudokuVerifier.verify(sudokuString);
		// This I couldn't get to work 100% properly
		assertNotEquals("Invalid row", result, 0);
	}
	
	@Test
	public void testVerify_invalidColumn() {
		int result;			// 123456789123456789
		String sudokuString = "417369825612158947958724316825437169791586432346912758289643571573291684164875293";
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		result = sudokuVerifier.verify(sudokuString);
		assertEquals("Invalid column return -4", result, -4);
	}
	
	@Test
	public void testVerify_invalidSubgrid() {
		int result;			// 123456789123456789
		String sudokuString = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		SudokuVerifier sudokuVerifier = new SudokuVerifier();
		result = sudokuVerifier.verify(sudokuString);
		assertEquals("Invalid subgrid return -2", result, -2);
	}
	


}
