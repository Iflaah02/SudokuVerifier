import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerifyStringShort() {
		SudokuVerifier verifier = new SudokuVerifier();
		
		boolean result = verifier.verifyString("1");
		
		assertEquals("String should've been wrong", false, result);
	}
	
	@Test
	public void testVerifyStringNotDigit() {
		SudokuVerifier verifier = new SudokuVerifier();
		
		boolean result = verifier.verifyString("asd");
		
		assertEquals("String should've been wrong", false, result);
	}
	
	@Test
	public void testVerifyStringTooLong() {
		SudokuVerifier verifier = new SudokuVerifier();
		
		boolean result = verifier.verifyString("4173698256321589479587243168254371697915864323469127582896435715732916841648752931");
		
		assertEquals("String should've been wrong", false, result);
	
	}
	
	@Test
	public void testVerifyStringSucceed() {
		SudokuVerifier verifier = new SudokuVerifier();
		
		boolean result = verifier.verifyString("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		
		assertEquals("String should've been right", true, result);
	
	}
	
	@Test
	public void testVerifyStringZero() {
		SudokuVerifier verifier = new SudokuVerifier();
		
		boolean result = verifier.verifyString("417369825632158947950724316825437169791586432346912758289643571573291684164875293");
		
		assertEquals("String should've been wrong", false, result);
	}
	
	@Test
	public void testSudokuMatrix() {
		SudokuVerifier verifier = new SudokuVerifier();
		
		verifier.buildMatrix("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		
		int[][] matrix = verifier.getSudokuMatrix();
		
		assertEquals("Matrix wrong size", 9, matrix.length);
		assertEquals("Matrix wrong size", 9, matrix[0].length);
		assertEquals("Matrix wrong size", 9, matrix[8].length);
	
	}
	
	@Test
	public void testSudokuRows() {
		SudokuVerifier verifier = new SudokuVerifier();
		
		verifier.buildMatrix("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		
		boolean result = verifier.checkRows();
		
		assertEquals("Failed to verify row integrity", true, result);	
	}
	
	@Test
	public void testSudokuRowsFail() {
		SudokuVerifier verifier = new SudokuVerifier();
		
		verifier.buildMatrix("411369825632158947958724316825437169791586432346912758289643571573291684164875293");
		
		boolean result = verifier.checkRows();
		
		assertEquals("Should've been invalid row", false, result);	
	}
	
	@Test
	public void testSudokuColumns() {
		SudokuVerifier verifier = new SudokuVerifier();
		
		verifier.buildMatrix("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		
		boolean result = verifier.checkColumns();
		
		assertEquals("Failed to verify column integrity", true, result);	
	}
	
	@Test
	public void testSudokuColumnFail() {
		SudokuVerifier verifier = new SudokuVerifier();
		
		verifier.buildMatrix(
				  "417369825"
				+ "432158947"
				+ "958724316"
				+ "825437169"
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "164875293");
		
		boolean result = verifier.checkColumns();
		
		assertEquals("Should've been invalid column", false, result);	
	}
	
	

}
