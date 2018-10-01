import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerify() {
		SudokuVerifier s = new SudokuVerifier();
		String str="123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		int result = s.verify(str);
		if (result == -1) fail("Sudoku had invalid characters");
	}
	
	@Test
	public void testcheckLength_with_valid_length() 
		{
		SudokuVerifier s = new SudokuVerifier();
		String str="123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		int result = s.checkLength(str);
		if (result != 0) fail("Size fails");
		}
	
	@Test
	public void testcheckLength_with_invalid_length() 
		{
		SudokuVerifier s = new SudokuVerifier();
		String str="12345678991234567812345677823456678912345567891234456789123345678912234567891";
		int result = s.checkLength(str);
		if (result != 0) fail("Size fails");
		}
	
	
	@Test
	public void testcheckDigits_with_valid_input() 
		{
		SudokuVerifier s = new SudokuVerifier();
		String str="123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		int result = s.checkDigits(str);
		if (result != 0) fail("Invalid characters in feed");
		}
	
	@Test
	public void testcheckDigits_with_invalid_input() // one zero inserted to feed
		{
		SudokuVerifier s = new SudokuVerifier();
		String str="123456789912345678891230567789123456678912345567891234456789123345678912234567891";
		int result = s.checkDigits(str);
		if (result != 0) fail("Invalid characters in feed");
		}
	
	@Test
	public void testMethod_checkNine_with_invalid_input() // double 3s
		{
		SudokuVerifier s = new SudokuVerifier();
		String str="123345678";
		int result = s.checkNine(str);
		if (result != 0) fail("One or more numbers appear twice");
		}
	
	@Test
	public void testMethod_checkNine_with_valid_input() 
		{
		SudokuVerifier s = new SudokuVerifier();
		String str="123456789";
		int result = s.checkNine(str);
		if (result != 0) fail("One or more numbers appear twice");
		}
	
	
	@Ignore
	public void test_checkRows_with_valid_input() 
		{
		SudokuVerifier s = new SudokuVerifier();
		String str="417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int result = s.checkRows(str);
		if (result == -3) fail("One or more rows had more than one of the same number");
		}
	
	@Test
	public void test_checkRows_with_invalid_input() // inserted double 3s on the 1st row
		{
		SudokuVerifier s = new SudokuVerifier();
		String str="417339825632158947958724316825437169791586432346912758289643571573291684164875293";
		int result = s.checkRows(str);
		if (result == -3) fail("One or more rows had more than one of the same number");
		}
	
	@Test
	public void test_checkColumns_with_valid_input() 
		{
		SudokuVerifier s = new SudokuVerifier();
		String str="417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int result = s.checkColumns(str);
		if (result == -4) fail("One or more rows had more than one of the same number");
		}
	

}
