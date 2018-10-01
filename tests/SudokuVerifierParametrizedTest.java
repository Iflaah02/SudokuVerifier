import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierParametrizedTest {

	@Test
	public void test() {
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(-2, sudoku.verify("123456789912345678891234567789123456678912345567891234456789123345678912234567891"));
		assertEquals(0, sudoku.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293"));
	}
	
	@Test
	public void test_checkIfValuesArePositive_1(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertFalse(sudoku.checkIfValuesArePositive("-1234"));
		assertFalse(sudoku.checkIfValuesArePositive("1-234"));
		assertTrue(sudoku.checkIfValuesArePositive("1234"));
		assertFalse(sudoku.checkIfValuesArePositive("a123"));
	}
	
	@Test
	public void test_subGridCheck_1(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertFalse(sudoku.subGridCheck("123456789912345678891234567789123456678912345567891234456789123345678912234567891"));
		assertTrue(sudoku.subGridCheck("417369825632158947958724316825437169791586432346912758289643571573291684164875293"));
	}
	
	@Test
	public void test_rowCheck_1(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertFalse(sudoku.rowCheck("113456789912345678891234567789123456678912345567891234456789123345678912234567891"));
		assertTrue(sudoku.rowCheck("417369825632158947958724316825437169791586432346912758289643571573291684164875293"));
	}
	
	@Test
	public void test_columnCheck_1(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertFalse(sudoku.columnCheck("123456789112345678891234567789123456678912345567891234456789123345678912234567891"));
		assertTrue(sudoku.columnCheck("417369825632158947958724316825437169791586432346912758289643571573291684164875293"));
	}

}
