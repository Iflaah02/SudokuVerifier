import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierParametrizedTest {

	@Test (expected = IllegalArgumentException.class)
	public void testVerify_inputIsLessThan81() {
		SudokuVerifier verif = new SudokuVerifier();
		String sudokuString = "41736982563215894795872431682543716979158643234691275828964357157329168416487529"; //80 letters long
		
		verif.verify(sudokuString);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testVerify_inputIsMoreThan81() {
		SudokuVerifier verif = new SudokuVerifier();
		String sudokuString = "4173698256321589479587243168254371697915864323469127582896435715732916841648752932"; //80 letters long
		
		verif.verify(sudokuString);
	}
	
	@Test
	public void testVerify_inputWithNonNumeric_1() {
		SudokuVerifier verif = new SudokuVerifier();
		String sudokuString = "4173698256a2158947958724316825437169791586432346912758289643571573291684164875293"; //80 letters long
		
		assertEquals(-1, verif.verify(sudokuString));
	}
	
	@Test
	public void testVerify_inputWithNonNumeric_2() {
		SudokuVerifier verif = new SudokuVerifier();
		String sudokuString = "4173698256/2158947958724316825437169791586432346912758289643571573291684164875293"; //80 letters long
		
		assertEquals(-1, verif.verify(sudokuString));
	}
	
	@Test
	public void testVerify_sameNumberOnARow() {
		SudokuVerifier verif = new SudokuVerifier();
		String sudokuString = "447369825632158947958724316825437169791586432346912758289643571573291684164875293"; //80 letters long
		
		assertEquals(-3, verif.verify(sudokuString));
	}
	
	@Test
	public void testVerify_sameNumberOnAColumn() {
		SudokuVerifier verif = new SudokuVerifier();
		String sudokuString = "417369825432158947958724316825437169791586432346912758289643571573291684164875293"; //80 letters long
		
		fail("I cannot make this work, I don't know any input respecting all the rules except n°4");
		//assertEquals(-4, verif.verify(sudokuString));
	}
	
	@Test
	public void testVerify_sameNumberOnASubgrid() {
		SudokuVerifier verif = new SudokuVerifier();
		String sudokuString = "417369825642158947958724316825437169791586432346912758289643571573291684164875293"; //80 letters long
		
		fail("I cannot make this work, I don't know any input respecting all the rules except n°2");
		//assertEquals(-2, verif.verify(sudokuString));
	}
}
