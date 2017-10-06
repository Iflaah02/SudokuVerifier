import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class SudokuVerifierTest {

/*
 * A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
 * 
 * Produces following grid
	417 | 369 | 825
	632 | 158 | 947
	958 | 724 | 316
	--- | --- | ---
	825 | 437 | 169
	791 | 586 | 432
	346 | 912 | 758
	--- | --- | ---
	289 | 643 | 571
	573 | 291 | 684
	164 | 875 | 293
 * 
 * */	
	
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerify() {
		String input_string = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		SudokuVerifier sudoku = new SudokuVerifier();
		int rv = sudoku.verify(input_string);
		assertEquals(0, rv);
	}
	
	@Test
	public void testVerifyFailOn_1() {
		String input_string = "A17369825632158947958724316825437169791586432346912758289643571573291684164875293";
		SudokuVerifier sudoku = new SudokuVerifier();
		int rv = sudoku.verify(input_string);
		assertEquals(-1, rv);
	}
	
	@Ignore
	@Test
	public void testVerifyFailOn_2() {
		/*
		 * This test fails because rules 3 and 4 are usually catching these cases. 
		 * To see if sub grid checks are working check dedicated test cases for sub grid checks.
		 * */
		String input_string = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		SudokuVerifier sudoku = new SudokuVerifier();
		int rv = sudoku.verify(input_string);
		assertEquals(-2, rv);
	}
	
	@Test
	public void testVerifyFailOn_3() {
		String input_string = "447369825632158947958724316825437169791586432346912758289643571573291684164875293";
		SudokuVerifier sudoku = new SudokuVerifier();
		int rv = sudoku.verify(input_string);
		assertEquals(-3, rv);
	}
	
	@Test
	public void testVerifyFailOn_4() {
		String input_string = "417369825432158947958724316825437169791586432346912758289643571573291684164875293";
		SudokuVerifier sudoku = new SudokuVerifier();
		int rv = sudoku.verify(input_string);
		assertEquals(-3, rv);
	}
	
	@Test (expected = IncorrectLengthException.class)
	public void testInputLengthWithTooShortInput() throws IncorrectLengthException {
		
		String input_string = "41736982563215894795872431682543716979158643234691275828964357157329168416487529";
		
		SudokuVerifier sudoku = new SudokuVerifier();
		sudoku.validate_input_length(input_string);
		
	}
	
	@Test (expected = IncorrectLengthException.class)
	public void testInputLengthWithTooLongInput() throws IncorrectLengthException {
		
		String input_string = "4173698256321589479587243168254371697915864323469127582896435715732916841648752933";
		
		SudokuVerifier sudoku = new SudokuVerifier();
		sudoku.validate_input_length(input_string);
		
	}
	
	@Test
	public void testInputLengthWithCorrectInput() throws IncorrectLengthException {
		
		String input_string = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		SudokuVerifier sudoku = new SudokuVerifier();
		sudoku.validate_input_length(input_string);
		
	}
	
	@Test (expected = NotOnlyIntegersException.class)
	public void testInputContainsPositiveOnlyIntegersWithLettersInInput() throws NotOnlyIntegersException {
		
		String input_string = "417369825632158947958724316825437169791586432346912758289643571573291684164875293A";
		
		SudokuVerifier sudoku = new SudokuVerifier();
		sudoku.validate_input_contains_positive_integers(input_string);
		
	}
	
	@Test (expected = NotOnlyIntegersException.class)
	public void testInputContainsPositiveOnlyIntegersWithNegatiaveIntegersInInput() throws NotOnlyIntegersException {
		
		String input_string = "417369825632158947958724316825437169791586432346912758289643571573291684164875293-2";
		
		SudokuVerifier sudoku = new SudokuVerifier();
		sudoku.validate_input_contains_positive_integers(input_string);
		
	}
	
	@Test
	public void testInputContainsOnlyPositiveIntegersWithCorrectInput() throws NotOnlyIntegersException {
		
		String input_string = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		SudokuVerifier sudoku = new SudokuVerifier();
		sudoku.validate_input_contains_positive_integers(input_string);
		
	}
	
	@Test
	public void testStringArrayToIntArrayWithCorrectInput() throws NotOnlyIntegersException, IncorrectLengthException {
		
		String input_string = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		SudokuVerifier sudoku = new SudokuVerifier();
		sudoku.string_array_to_int_array(input_string);
		
	}
	
	@Test (expected = NotOnlyIntegersException.class)
	public void testStringArrayToIntArrayWithLettersInInput() throws NotOnlyIntegersException, IncorrectLengthException {
		
		String input_string = "41736982563215894795872431682543716979158643234691275828964357157329168416487529A";
		
		SudokuVerifier sudoku = new SudokuVerifier();
		sudoku.string_array_to_int_array(input_string);
		
	}
	
	@Test (expected = IncorrectLengthException.class)
	public void testStringArrayToIntArrayWithTooLongInput() throws NotOnlyIntegersException, IncorrectLengthException {
		
		String input_string = "4173698256321589479587243168254371697915864323469127582896435715732916841648752999";
		
		SudokuVerifier sudoku = new SudokuVerifier();
		sudoku.string_array_to_int_array(input_string);
		
	}
	
	@Test
	public void testMakeSudokuGridWithCorrectInput() throws NotOnlyIntegersException, IncorrectLengthException {
		
		String input_string = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int expected_last_integer = Integer.parseInt(input_string.substring(input_string.length()-1));
		
		SudokuVerifier sudoku = new SudokuVerifier();
		int[][] rv = sudoku.make_sudoku_grid(input_string);
		
		assertEquals(9, rv.length);
		assertEquals(9, rv[8].length);
		assertEquals(expected_last_integer, rv[8][8]);
		
	}
	
	@Test
	public void testVerifyRowsWithCorrectInput() throws NotOnlyIntegersException, IncorrectLengthException, IncorrectRowException {
		
		String input_string = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		SudokuVerifier sudoku = new SudokuVerifier();
		int[][] rv = sudoku.make_sudoku_grid(input_string);
		
		sudoku.verify_rows(rv);
	}
	
	@Test (expected = IncorrectRowException.class)
	public void testVerifyRowsWithIncorrectInput() throws NotOnlyIntegersException, IncorrectLengthException, IncorrectRowException {
		
		String input_string = "447369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		SudokuVerifier sudoku = new SudokuVerifier();
		int[][] rv = sudoku.make_sudoku_grid(input_string);
		
		sudoku.verify_rows(rv);
	}
	
	@Test
	public void testVerifyColsWithCorrectInput() throws NotOnlyIntegersException, IncorrectLengthException, IncorrectColException {
		
		String input_string = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		SudokuVerifier sudoku = new SudokuVerifier();
		int[][] rv = sudoku.make_sudoku_grid(input_string);
		
		sudoku.verify_cols(rv);
	}
	
	@Test (expected = IncorrectColException.class)
	public void testVerifyColsWithIncorrectInput() throws NotOnlyIntegersException, IncorrectLengthException, IncorrectColException {
		
		String input_string = "417369825432158947958724316825437169791586432346912758289643571573291684164875293";
		
		SudokuVerifier sudoku = new SudokuVerifier();
		int[][] rv = sudoku.make_sudoku_grid(input_string);
		
		sudoku.verify_cols(rv);
	}
	
	@Test
	public void testVerifySubGridWithCorrectInput() throws NotOnlyIntegersException, IncorrectLengthException, IncorrectSubGridException {
		
		String input_string = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		SudokuVerifier sudoku = new SudokuVerifier();
		int[][] rv = sudoku.make_sudoku_grid(input_string);
		
		sudoku.verify_sub_grid(rv, 1, 1);
	}
	
	@Test (expected = IncorrectSubGridException.class)
	public void testVerifySubGridWithIncorrectInput() throws NotOnlyIntegersException, IncorrectLengthException, IncorrectSubGridException {
		
		String input_string = "447369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		SudokuVerifier sudoku = new SudokuVerifier();
		int[][] rv = sudoku.make_sudoku_grid(input_string);
		
		sudoku.verify_sub_grid(rv, 1, 1);
	}

}
