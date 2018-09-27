import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test (expected = SudokuVerifierException.class)
	public void testVerify_incorrectlength() throws SudokuVerifierException{
		//Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		String input = "1254352345574355756352345563";
		//Act
		int res = verifier.verify(input);
		
		//Assert
	}
	
	@Test
	public void testVerify_not_digits() throws SudokuVerifierException{
		//Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		String input = "12345678991234567889123456778-123456678912345567891234456789123345678912234567891";
		//Act
		int res = verifier.verify(input);
		
		//Assert
		assertEquals(-1, res);
	}
	
	@Test
	public void testVerify_rows_duplicate() throws SudokuVerifierException{
		//Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		String input = "123123123456456456789789789234234234567567567891891891345345345678678678912912912";
		//Act
		int res = verifier.verify(input);
		
		//Assert
		assertEquals(-3, res);
	}

	@Test
	public void testVerify_columns_duplicate() throws SudokuVerifierException{
		//Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		String input = "369147258258369147147258369369147258258369147147258369369147258258369147147258369";
		//Act
		int res = verifier.verify(input);
		
		//Assert
		assertEquals(-4, res);
	}
	
	@Test
	public void testVerify_subgrid_duplicate() throws SudokuVerifierException{
		//Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		String input = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		//Act
		int res = verifier.verify(input);
		
		//Assert
		assertEquals(-2, res);
	}
	
	@Test
	public void testVerify_correct() throws SudokuVerifierException{
		//Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		String input = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		//Act
		int res = verifier.verify(input);
		
		//Assert
		assertEquals(0, res);
	}
}
