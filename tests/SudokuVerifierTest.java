import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

	@Test
	public void testWithViolationgRule1() {
		SudokuVerifier verifier = new SudokuVerifier();
		//Letter C is in second row
		String string = "417369825"
				      + "632158C47"
				      + "958724316"
				      + "825437169"
				      + "791586432"
				      + "346912758"
				      + "289643571"
				      + "573291684"
				      + "164875293";
		assertEquals(-1, verifier.verify(string));
	}
	
	@Test
	public void testWithViolationgRule1TooShortString() {
		SudokuVerifier verifier = new SudokuVerifier();
		//One row is missing
		String string = "417369825"
				      + "632158C47"
				      + "958724316"
				      + "825437169"
				      + "791586432"
				      + "346912758"
				      + "289643571"
				      + "573291684";
		assertEquals(-1, verifier.verify(string));
	}
	
	@Test
	public void testWithViolationgRule1TooLongString() {
		SudokuVerifier verifier = new SudokuVerifier();
		//One row too much
		String string = "417369825"
				      + "632158C47"
				      + "958724316"
				      + "825437169"
				      + "791586432"
				      + "346912758"
				      + "289643571"
				      + "289643571"
				      + "573291684";
		assertEquals(-1, verifier.verify(string));
	}
	
	@Test
	public void testWithViolationRule2() {
		SudokuVerifier verifier = new SudokuVerifier();
		//Number 1 is twice in first sub grid
		String string = "417369825"
					  + "631258947"
					  + "958724316"
					  + "825437169"
					  + "791586432"
					  + "346912758"
					  + "289643571"
					  + "573291684"
					  + "164875293";
		assertEquals(-2, verifier.verify(string));
	}
	
	@Test
	public void testWithViolationRule3() {
		SudokuVerifier verifier = new SudokuVerifier();
		//Number 8 is twice in first row
		String string = "418369825"
					  + "632158947"
					  + "957724316"
					  + "825437169"
					  + "791586432"
					  + "346912758"
					  + "289643571"
					  + "573291684"
					  + "164875293";
		assertEquals(-3, verifier.verify(string));
	}
	
	@Test
	public void testWithViolationRule4() {
		SudokuVerifier verifier = new SudokuVerifier();
		//Number 4 is twice in first column
		String string = "417369825"
					  + "632158947"
					  + "958724316"
					  + "825437169"
					  + "791586432"
					  + "346912758"
					  + "289643571"
					  + "573291684"
					  + "461875293";
		assertEquals(-4, verifier.verify(string));
	}
		
	@Test
	public void testWithValid() {
		SudokuVerifier verifier = new SudokuVerifier();
		//Valid sudoku grid
		String string = "417369825"
					  + "632158947"
					  + "958724316"
					  + "825437169"
					  + "791586432"
					  + "346912758"
					  + "289643571"
					  + "573291684"
					  + "164875293";
		assertEquals(0, verifier.verify(string));
	}
}
