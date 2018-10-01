import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerify_ValidString() {
		// Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		int result = 0;
				
		// Act
		result = verifier.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
				
		// Assert
		assertEquals(0, result);
	}
	
	@Test
	public void testVerify_NotEnoughCharacters() {
		// Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		int result = 0;
				
		// Act
		result = verifier.verify("3124");
				
		// Assert
		assertEquals(-1, result);
	}

	@Test
	public void testVerify_TooManyCharacters() {
		// Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		int result = 0;
				
		// Act
		result = verifier.verify("4173698256321589479587243168254371697915864323469127582896435715732916841648752932");
				
		// Assert
		assertEquals(-1, result);
	}
	
	@Test
	public void testVerify_NegativeNumbers() {
		// Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		int result = 0;
				
		// Act
		result = verifier.verify("4173698256321589479587243168254371697915864323469127582896435715732916841648752-9");
				
		// Assert
		assertEquals(-1, result);
	}
	
	@Test
	public void testVerify_IllegalCharacters() {
		// Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		int result = 0;
				
		// Act
		result = verifier.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875c93");
				
		// Assert
		assertEquals(-1, result);
	}
	
	@Test
	public void testGetRows_2ndRow() {
		// Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		String result = "0";
				
		// Act
		List<String> rows = verifier.getRows("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		result = rows.get(1);
		
		// Assert
		assertEquals("632158947", result);
	}
	
	@Test
	public void testGetColumns_2ndColumn() {
		// Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		String result = "0";
				
		// Act
		List<String> columns = verifier.getColumns("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		result = columns.get(1);
		
		// Assert
		assertEquals("135294876", result);
	}
	
	@Test
	public void testGetSubGrids_2ndSubGrid() {
		// Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		String result = "0";
				
		// Act
		List<String> subGrids = verifier.getSubGrids("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		result = subGrids.get(1);
		
		// Assert
		assertEquals("369158724", result);
	}
	
	@Test
	public void testGetSubGrids_4thSubGrid() {
		// Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		String result = "0";
				
		// Act
		List<String> subGrids = verifier.getSubGrids("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		result = subGrids.get(3);
		
		// Assert
		assertEquals("825791346", result);
	}
	
	@Test
	public void testVerifyList_ValidList() {
		// Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		boolean result = true;
				
		// Act
		List<String> subGrids = verifier.getSubGrids("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		result = verifier.verifyList(subGrids);
		
		// Assert
		assertEquals(true, result);
	}
	
	@Test
	public void testVerifyList_InvalidList() {
		// Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		boolean result = true;
				
		// Act
		List<String> subGrids = verifier.getSubGrids("123456789912345678891234567789123456678912345567891234456789123345678912234567891");
		result = verifier.verifyList(subGrids);
		
		// Assert
		assertEquals(false, result);
	}
	
	@Test
	public void testVerify_InvalidString() {
		// Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		int result = 0;
				
		// Act
		result = verifier.verify("123456789912345678891234567789123456678912345567891234456789123345678912234567891");
				
		// Assert
		assertEquals(-2, result);
	}
}
