import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
	String correctSudoku, incorrectSudoku;
	SudokuVerifier sVerifier;
	@Before
	public void setUp() {
		correctSudoku = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		//incorrectSudoku = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		sVerifier = new SudokuVerifier();
	}
	

//	//Slice 1: test containsOnlyPositiveDigits method
	@Test
	public void test_containsLetter_a() {
		incorrectSudoku = "a23456789912345678891234567789123456678912345567891234456789123345678912234567891";
		assertEquals("-1 is returned if rule one is broken", -1, sVerifier.verify(incorrectSudoku));
	}
	//Slice 2: test digitRepeatedInGlobalRow method
	@Test
	public void test_digit_repeated_in_a_global_row() {
		incorrectSudoku = "447369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertEquals("-3 is returned if rule three is broken", -3, sVerifier.verify(incorrectSudoku));
	}
	//Slice 3: test digitRepeatedInGlobalCol method
//	@Test
//	public void test_digit_repeated_in_a_global_column() {
//		incorrectSudoku = "417369825632158947958724316825437169791586432346912758289643571573291684164875295";
//		assertEquals("-4 is returned if rule four is broken", -4, sVerifier.verify(incorrectSudoku));
//	}

}
