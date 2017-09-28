import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerify_correctString_returnZero() {
		//init
		SudokuVerifier verifier = new SudokuVerifier();
		String incorectString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		//Act
		int result = verifier.verify(incorectString);
		
		//Assert
		int expected = 0;
		assertEquals(expected, result);
	}
	
	@Test
	public void testVerify_twoShortString_returnMinusOne() {
		//init
		SudokuVerifier verifier = new SudokuVerifier();
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
		SudokuVerifier verifier = new SudokuVerifier();
		String incorectString = "41736982563215894795872431682543716979158643234691275828964357157329168416487529313458";
		
		//Act
		int result = verifier.verify(incorectString);
		
		//Assert
		int expected = -1;
		assertEquals(expected, result);
	}
	
	@Test
	public void testVerify_invalidCharactersString_returnMinusOne() {
		//init
		SudokuVerifier verifier = new SudokuVerifier();
		String incorectString = "41736982563215894795asd4316825437169791586432346912758289643571573291684164875293";
		
		//Act
		int result = verifier.verify(incorectString);
		
		//Assert
		int expected = -1;
		assertEquals(expected, result);
	}
	
	@Test
	public void testVerify_duplicateCharactersInRowString_returnMinusThree() {
		//init
		SudokuVerifier verifier = new SudokuVerifier();
		String incorectString = "123123123456456456789789789231231231564564564897897897312312312645645645978978978";
		
		//Act
		int result = verifier.verify(incorectString);
		
		//Assert
		int expected = -3;
		assertEquals(expected, result);
	}
	
	@Test
	public void testVerify_duplicateCharactersInColString_returnMinusFour() {
		//init
		SudokuVerifier verifier = new SudokuVerifier();
		String incorectString = "123456789456789123789123456123456789456789123789123456123456789456789123789123456";
		
		//Act
		int result = verifier.verify(incorectString);
		
		//Assert
		int expected = -4;
		assertEquals(expected, result);
	}
	
	@Test
	public void testVerify_duplicateCharactersInGridString_returnMinusTwo() {
		//init
		SudokuVerifier verifier = new SudokuVerifier();
		String incorectString = "123456789234567891345678912456789123567891234678912345789123456891234567912345678";
		
		//Act
		int result = verifier.verify(incorectString);
		
		//Assert
		int expected = -2;
		assertEquals(expected, result);
	}

}
