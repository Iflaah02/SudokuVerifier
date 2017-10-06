import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierParametrizedTest {

	@Test
	public void test_valid_size_fail() {
		SudokuVerifier sudoku = new SudokuVerifier();
		
		int code = sudoku.valid_size("12345");
		assertEquals(1,code);
		
	}

	@Test
	public void test_valid_size_pass() {
		SudokuVerifier sudoku = new SudokuVerifier();
		String finalString = build_string_with("1");
		int code = sudoku.valid_size(finalString);
		assertEquals(0,code);
		
	}
	
	@Test
	public void test_contain_int() {
		SudokuVerifier sudoku = new SudokuVerifier();
		String finalString = build_string_with("1");
		
		int code = sudoku.contain_int(finalString);
		assertEquals(0,code);

		String finalString2 = build_string_with("A");
		code = sudoku.contain_int(finalString2);
		assertEquals(1,code);
	}
	
	@Test
	public void test_validate() {
		SudokuVerifier sudoku = new SudokuVerifier();

		char[] c = {'3','2','1','4','5','9','7','8','6'};
		int score =sudoku.validate(c);
		assertEquals(0,score);
		
		char[] c2 = {'2','2','1','4','5','9','7','8','6'};
		score =sudoku.validate(c2);
		assertEquals(1,score);
	}
	
	@Test
	public void test_check_rows() {
		SudokuVerifier sudoku = new SudokuVerifier();
		String correct_s = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	    String incorrect_s = "123456789912345678891234567789123456618912345567891234456789123345678912234567891";
		
		int score =sudoku.check_rows(correct_s);
		assertEquals(0,score);
		
		score =sudoku.check_rows(incorrect_s);
		assertEquals(-3,score);
	}
	
	@Test
	public void test_check_columns() {
		SudokuVerifier sudoku = new SudokuVerifier();
		String correct_s = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	    String incorrect_s = "123456789912345678891234567789123456618912345567891234456789123345678912234567891";
		
		int score =sudoku.check_columns(correct_s);
		assertEquals(0,score);
		
		score =sudoku.check_columns(incorrect_s);
		assertEquals(-4,score);
	}
	
	@Test
	public void test_check_subgrids() {
		SudokuVerifier sudoku = new SudokuVerifier();
		String correct_s = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	    String incorrect_s = "123456789912345678891234567789123456618912345567891234456789123345678912234567891";
		
		int score =sudoku.check_subgrids(correct_s);
		assertEquals(0,score);
		
		score =sudoku.check_subgrids(incorrect_s);
		assertEquals(-2,score);
	}
	
	
	@Test
	public void test_verify() {
		SudokuVerifier sudoku = new SudokuVerifier();
		String correct_s = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	    String incorrect_s = "123456789912345678891234567789123456618912345567891234456789123345678912234567891";
		
		int score =sudoku.verify(correct_s);
		assertEquals(0,score);
		
		score =sudoku.verify(incorrect_s);
		assertEquals(-3,score);
	}

//Refactoring Extract methods
public String build_string_with(String s) {
	StringBuilder stringBuilder = new StringBuilder();
	
	for(int i =0;i<81;i++) {
		
		stringBuilder.append(s);
	}
	String finalString = stringBuilder.toString();
	return finalString;
}


}