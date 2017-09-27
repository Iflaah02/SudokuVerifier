import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

//	@Test
//	public void testVerify() {
//		fail("Not yet implemented");
//	}
	
	private String correctString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	
	private String wrongGridString = "417369825132158947958724316825437169791586432346912758289643571573291684164875293";
	
	private String wrongRowsString = "417469825632158947958723316825437169791586432346912758289643571573291684164875293";
	
	private String wrongColumnsString = "417369825632158947958724316528437169791586432346912758289643571573291684164875293";
	
	private String shortString = "41736982563215894795872431682543716979158643234691275828964357157329168416487529";
	

	
	@Test
	public void testVerify_StringLength() {
		//Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		
		//Act
		
		//Assert
		assertEquals("Correct String returns 0",0, verifier.verify(correctString));
		assertEquals("Too long string returns -1",-1, verifier.verify(correctString +"6"));
		assertEquals("Too short string returns -1", -1, verifier.verify(shortString));
	}
	
	@Test
	public void testVerify_NumberFormat0_9() {
		//Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		
		//Assert
		assertEquals("Only numbers 1-9 should be allowed", -1, verifier.verify(shortString + "k"));
		assertEquals("Only numbers 1-9 should be allowed", -1, verifier.verify(shortString + "0"));
		assertEquals("Only numbers 1-9 should be allowed", -1, verifier.verify(shortString + "10"));

		
	}
	
	@Test
	public void testVerify_subGrid0_9() {
		//Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		
		//Assert
		assertEquals("Each subgrid can only contain one of each number", -2, verifier.verify(shortString + "1"));
		assertEquals("Each subgrid can only contain one of each number", 0, verifier.verify(correctString));
		assertEquals("Each subgrid can only contain one of each number", -2, verifier.verify(wrongGridString));
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
