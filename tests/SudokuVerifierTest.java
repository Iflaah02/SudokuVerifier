import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerifyCode0() {
		SudokuVerifier sudoku = new SudokuVerifier();
		
		int returnCode = sudoku.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		
		assertEquals(returnCode, 0);
	}
	
	@Test
	public void testVerifyCodeMinus1() {
		SudokuVerifier sudoku = new SudokuVerifier();
		
		int returnCode = sudoku.verify("41736982563a2158947958724316825437169791586432346912758289643571573291684164875293");
		
		assertEquals(returnCode, -1);
	}
	
	@Test
	public void testVerifyCodeMinus2() {
		SudokuVerifier sudoku = new SudokuVerifier();
		
		int returnCode = sudoku.verify("123456789912345678891234567789123456678912345567891234456789123345678912234567891");
		
		assertEquals(returnCode, -2);
	}
	
	@Test
	public void testVerifyCodeMinus3() {
		SudokuVerifier sudoku = new SudokuVerifier();
		
		int returnCode = sudoku.verify("417369825632158946958724317825437169791586432346912758289643571573291684164875293");
		assertEquals(returnCode, -3);
	}
	
	@Test
	public void testVerifyCodeMinus4() {

		SudokuVerifier sudoku = new SudokuVerifier();
		
		int returnCode = sudoku.verify("417369825632158947958724316825437196791586432346912758289643571573291684164875293");
		assertEquals(returnCode, -4);
	}
	
	@Test
	public void testOnlyNumbers() {
		SudokuVerifier sudoku = new SudokuVerifier();
		
		boolean onlyNumbers = sudoku.OnlyNumbers("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(onlyNumbers, true);
		
		onlyNumbers = sudoku.OnlyNumbers("417369825632158947958a724316825437169791586432346912758289643571573291684164875293");
		assertEquals(onlyNumbers, false);
		
		onlyNumbers = sudoku.OnlyNumbers("417369825632158947958724316825437169791586432346912758289643571573291684164875293a");
		assertEquals(onlyNumbers, false);
	}
}
