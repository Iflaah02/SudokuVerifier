import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

//	@Test
//	public void testVerify() {
//		fail("Not yet implemented");
//	}
	
	private SudokuVerifierTestRowsAndNumbers sudokuVerifierTestRowsAndNumbers = new SudokuVerifierTestRowsAndNumbers();

	private String wrongRowsString = "417469825632158947958723316825437169791586432346912758289643571573291684164875293";
	
	private String wrongColumnsString = "417369825632158947958724316528437169791586432346912758289643571573291684164875293";
	
	@Test
	public void testVerify_StringLength() {
		
		
		//Act
		
		sudokuVerifierTestRowsAndNumbers.testVerify_StringLength();
	}
	
	@Test
	public void testVerify_NumberFormat0_9() {
		sudokuVerifierTestRowsAndNumbers.testVerify_NumberFormat0_9();

		
	}
	
	@Test
	public void testVerify_subGrid0_9() {
		sudokuVerifierTestRowsAndNumbers.testVerify_subGrid0_9();
	}
	
	@Test
	public void testVerify_Rows0_9() {
		//Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		
		//Assert
		assertEquals("Each row can only contain one of each number", -3, verifier.verify(wrongRowsString));
	}
	
	@Test
	public void testVerify_Columns0_9() {
		//Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		
		//Assert
		assertEquals("Each column can only contain one of each number", -4, verifier.verify(wrongColumnsString));
	}
	

}
