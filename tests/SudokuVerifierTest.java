import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	SudokuVerifier verifier;
	
	@Before
	public void initialize() {
		verifier = new SudokuVerifier();
	}
	
	@Test
	public void testVerify_correctSudoku() {
		int result = verifier.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
	    assertEquals(0, result);
	}
	
	@Test
	public void testVerify_incorrectSudoku() {
		int result = verifier.verify("123456789912345678891234567789123456678912345567891234456789123345678912234567891");
		assertEquals(false, result == 0);
	}

	@Test
	public void testVerify_tooShortSudokuString() {
		int result = verifier.verify("41736982912758289643571573291684164875293");
		assertEquals(-1, result);
	}
	
	@Test
	public void testVerify_tooLongSudokuString() {
		int result = verifier.verify("417369829127582896435715732916841648752934173698291275828964357157329168416487529341736982912758289643571573291684164875293");
		assertEquals(-1, result);
	}
	
	@Test
	public void testVerify_invalidSymbolsInSudokuString() {
		int result = verifier.verify("417E698256321589XYZL8724316825437169791586432346912758289643571573291684164875293");
	    assertEquals(-1, result);
	}
	
	@Test
	public void testAllDifferent_emptyArrayReturnsTrue() {
		int[] values = new int[0];
		boolean result = verifier.allDifferent(values);
	    assertTrue(result);
	}
	
	@Test
	public void testAllDifferent_allDifferentArrayReturnsTrue_simple() {
		int[] values = { 1, 2, 3 };
		boolean result = verifier.allDifferent(values);
	    assertTrue(result);
	}
	
	@Test
	public void testAllDifferent_allDifferentArrayReturnsTrue() {
		int[] values = { 1, 5, 3, 8, 9, 2, 4, 6, 7 };
		boolean result = verifier.allDifferent(values);
	    assertTrue(result);
	}
	
	@Test
	public void testAllDifferent_arrayWithDuplicateValuesReturnsFalse_simple() {
		int[] values = { 1, 1, 1 };
		boolean result = verifier.allDifferent(values);
	    assertFalse(result);
	}
	
	@Test
	public void testAllDifferent_arrayWithDuplicateValuesReturnsFalse() {
		int[] values = { 1, 5, 3, 8, 5, 2, 4, 6, 7 };
		boolean result = verifier.allDifferent(values);
	    assertFalse(result);
	}
}
