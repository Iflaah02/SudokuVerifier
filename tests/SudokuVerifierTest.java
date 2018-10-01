import static org.junit.Assert.*;

import org.junit.Test;

//A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
//An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

public class SudokuVerifierTest {

	@Test
	public void testWithValid() {
		SudokuVerifier verifier = new SudokuVerifier();
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
	
	@Test
	public void testWithViolationRule1Short() {
		SudokuVerifier verifier = new SudokuVerifier();
		String string = "417369825"
				      + "632158C47"
				      + "958724316"
				      + "825437169"
				      + "791586432"
				      + "346912758"
				      + "289643571"
				      + "573291684"; // one line missing
		assertEquals(-1, verifier.verify(string));
	}
	
	@Test
	public void testWithViolationRule1Long() {
		SudokuVerifier verifier = new SudokuVerifier();
		String string = "417369825"
				      + "632158C47"
				      + "958724316"
				      + "825437169"
				      + "791586432"
				      + "346912758"
				      + "289643571"
				      + "573291684"
				      + "573291684"; //  twice same row
		assertEquals(-1, verifier.verify(string));
	}
	
	@Test
	public void testWithViolationRule1() {
		SudokuVerifier verifier = new SudokuVerifier();
		String string = "417369825"
				      + "632158947"
				      + "958724316"
				      + "825437169"
				      + "791586432"
				      + "346912758"
				      + "2TOMMI571" // TOMMI
				      + "573291684"
				      + "164875293";
		assertEquals(-1, verifier.verify(string));
	}
	
	
	@Test
	public void testWithViolationRule2() {
		SudokuVerifier verifier = new SudokuVerifier();
		String string = "417369825"
					  + "632158947"
					  + "958724316"
					  + "825437169"
					  + "781596432" // Number 8 twice in sub-row
					  + "746912758"
					  + "289643571"
					  + "173291684"
					  + "564875293";
		assertEquals(-2, verifier.verify(string));
	}
	
	@Test
	public void testWithViolationRule3() {
		SudokuVerifier verifier = new SudokuVerifier();
		String string = "127369825" //2 twice in same row
				      + "634158947" // 4 twice in same row
				      + "958724316"
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
		String string = "147369825" // 1 twice in the first column
				      + "632158947"
				      + "958724316"
				      + "825437169"
				      + "791586432"
				      + "346912758"
				      + "289643571"
				      + "573291684"
				      + "164875293"; // 1 twice in the first column
		assertEquals(-4, verifier.verify(string));
	}
}	

