import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerify() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testLengthVerifierWithCorrectLenght() {
		SudokuVerifier sVer = new SudokuVerifier();
		String str = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		assertEquals(0, sVer.checkLenght(str));
	}
	
	@Test
	public void testLengthVerifierWithIncorrectLenght() {
		SudokuVerifier sVer = new SudokuVerifier();
		String str = "1234567899123456788912345677891234566789123455678912344567891233456789122345678911234";
		
		assertEquals(-5, sVer.checkLenght(str));
	}
	
	@Test
	public void testSliceStringCorrectString() {
		SudokuVerifier sVer = new SudokuVerifier();
		String str = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		String[] compareTo = {"417369825","632158947","958724316","825437169","791586432","346912758","289643571","573291684","164875293"};
		
		assertEquals(compareTo, sVer.sliceString(str));
	}

}
