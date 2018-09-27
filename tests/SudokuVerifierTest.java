import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest
{

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void test_printing_correct_Sudoku()
	{
		SudokuVerifier test = new SudokuVerifier();
		String testStr = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		test.verify(testStr);
		test.print();
//		assertEquals(0,result);
	}
	
	@Test
	public void test_positive_values()
	{
		SudokuVerifier test = new SudokuVerifier();
		String testStr = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int result = test.verify(testStr);
		assertEquals(0,result);
	}
	@Test
	public void test_negative_values()
	{
		SudokuVerifier test = new SudokuVerifier();
		String testStr = "417369825632158947958724316825437169791586432346912758289643515732916841648752-93";
		int result = test.verify(testStr);
		assertEquals(-1,result);
	}

	@Test
	public void once_per_row_ok()
	{
		SudokuVerifier test = new SudokuVerifier();
		String testStr = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int result = test.verify(testStr);
		assertEquals(0,result);
	}

	@Test
	public void once_per_row_NOTok()
	{
		SudokuVerifier test = new SudokuVerifier();
		String testStr = "999999999999999999999999999999999999999999999999999999999999999999999999999999999";
		int result = test.verify(testStr);
		assertEquals(-3,result);
	}

	@Test
	public void once_per_Square_ok()
	{
		SudokuVerifier test = new SudokuVerifier();
		String testStr = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int result = test.verify(testStr);
		assertEquals(0,result);
	}
	@Test
	public void once_per_Square_NOT_ok()
	{
		SudokuVerifier test = new SudokuVerifier();
		String testStr = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		int result = test.verify(testStr);
		assertEquals(-2,result);
	}

	@Test
	public void once_per_col_NOT_ok()
	{
		SudokuVerifier test = new SudokuVerifier();
		String testStr = "234567891234567891234567891234567891234567891234567891234567891234567891234567891";
		test.createSudokuArray(testStr);
		int val = test.once_per_col();
		assertEquals(-4,val);
	}
	
	@Test
	public void once_per_col_NOT_ok2()
	{
		SudokuVerifier test = new SudokuVerifier();
		String testStr = "123456789123456789123456789123456789123456789123456789123456789123456789123456789";
		int val = test.verify(testStr);
		assertEquals(-4,val);
	}

	@Test
	public void test_Length_OK()
	{
		SudokuVerifier test = new SudokuVerifier();
		String testStr = "123456789123456789123456789123456789123456789123456789123456789123456789123456789";
		test.createSudokuArray(testStr);
		int val = test.length_test(testStr);
		assertEquals(0,val);
	}

	@Test
	public void test_Length_NOT_OK_too_long()
	{
		SudokuVerifier test = new SudokuVerifier();
		String testStr = "1234567891234567912345678912345655789123456789123456744444489123456789123456789123456789";
		int val = test.length_test(testStr);
		assertEquals(-6,val);	//No code was given for when the string is not the correct length. Returning -6
	}

	@Test
	public void test_Length_NOT_OK_too_short()
	{
		SudokuVerifier test = new SudokuVerifier();
		String testStr = "1234567891234567916789123456789123456789";
		int val = test.verify(testStr);
		assertEquals(-6,val);	//No code was given for when the string is not the correct length. Returning -6
	}
}
