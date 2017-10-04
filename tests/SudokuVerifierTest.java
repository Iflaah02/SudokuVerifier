import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	
	//1. Test case for method to check if only positive digits exist 
	@Test
	public void testOnlyPositiveDigitsCorrectGame() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		String input = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		// Assert
		assertTrue(sudoku.checkOnlyPositiveDigits(input));
	}
	@Test
	public void testOnlyPositiveDigitsFalseGame() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		String input = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		
		// Assert
		assertTrue(sudoku.checkOnlyPositiveDigits(input));
	}
	
	@Test
	public void testNegativeDigits() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		String input = "41736982563215894795872431682543716-7591586432346912758289643571573291684164875293";
		
		// Assert
		assertFalse(sudoku.checkOnlyPositiveDigits(input));
	}
	@Test
	public void testDigitsAndLetters() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		String input = "4173698256321589D79587243168254c7169791586432346912758289643571573291684164875293";
		
		// Assert
		assertFalse(sudoku.checkOnlyPositiveDigits(input));
	}
	//2. Test case for method to split input in rows
	@Test
	public void checkSplitRowNumbers() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		ArrayList<String> sudokuRows = new ArrayList<String>();
		String input = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertTrue(sudoku.checkOnlyPositiveDigits(input));
		sudokuRows = sudoku.splitSudokuStringRow(input);
		
		// Assert
		assertEquals(9,sudokuRows.size());
	}
	@Test
	public void checkSplitFirstRow() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		ArrayList<String> sudokuRows = new ArrayList<String>();
		String input = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertTrue(sudoku.checkOnlyPositiveDigits(input));
		sudokuRows = sudoku.splitSudokuStringRow(input);
		
		// Assert
		assertEquals("417369825",sudokuRows.get(0));
	}
	@Test
	public void checkSplitLastRow() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		ArrayList<String> sudokuRows = new ArrayList<String>();
		String input = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertTrue(sudoku.checkOnlyPositiveDigits(input));
		sudokuRows = sudoku.splitSudokuStringRow(input);
		
		// Assert
		assertEquals("164875293",sudokuRows.get(8));
	}
	@Test
	public void checkVerifyWrongSequence() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		ArrayList<String> sudokuRows = new ArrayList<String>();
		String input = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertTrue(sudoku.checkOnlyPositiveDigits(input));
		sudokuRows = sudoku.splitSudokuStringRow(input);
		System.out.println(sudokuRows.get(0));
		System.out.println(sudokuRows.get(0).length());
		// Assert
		assertTrue(sudoku.verifyDigitsOnce(sudokuRows.get(0)));
	}

}
