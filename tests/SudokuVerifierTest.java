import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerify_twoShortString_returnMinusOne() {
		//init
		SudokuVerifier verifier = new SudokuVerifier(9, 9, 3);
		String incorectString = "4173698256321589479587243168254371697915864323469127582896435715732916841648752";
		
		//Act
		int result = verifier.verify(incorectString);
		
		//Assert
		int expected = -1;
		assertEquals(expected, result);
	}
	
	@Test
	public void testVerify_twoLongString_returnMinusOne() {
		//init
		SudokuVerifier verifier = new SudokuVerifier(9, 9, 3);
		String incorectString = "41736982563215894795872431682543716979158643234691275828964357157329168416487529313458";
		
		//Act
		int result = verifier.verify(incorectString);
		
		//Assert
		int expected = -1;
		assertEquals(expected, result);
	}
	
	@Test
	public void testVerify_correctString_zero() {
		//init
		SudokuVerifier verifier = new SudokuVerifier(9, 9, 3);
		String incorectString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		//Act
		int result = verifier.verify(incorectString);
		
		//Assert
		int expected = 0;
		assertEquals(expected, result);
	}

}
