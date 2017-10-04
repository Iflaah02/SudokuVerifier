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
	//3. Test case for method to verify that digits only appear once in a string
	@Test
	public void checkVerifyCorrectSequence() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		ArrayList<String> sudokuRows = new ArrayList<String>();
		String input = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertTrue(sudoku.checkOnlyPositiveDigits(input));
		sudokuRows = sudoku.splitSudokuStringRow(input);
		// Assert
		assertTrue(sudoku.verifyDigitsOnce(sudokuRows.get(0)));
	}
	@Test
	public void checkVerifyWrongSequence() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		ArrayList<String> sudokuRows = new ArrayList<String>();
		String input = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertTrue(sudoku.checkOnlyPositiveDigits(input));
		sudokuRows = sudoku.splitSudokuStringRow(input);
		// Assert
		assertTrue(sudoku.verifyDigitsOnce(sudokuRows.get(0)));
	}
	//4. Test case for method to split input in columns
	@Test
	public void checkSplitColumnNumbers() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		ArrayList<String> sudokuColumns = new ArrayList<String>();
		String input = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertTrue(sudoku.checkOnlyPositiveDigits(input));
		sudokuColumns = sudoku.splitSudokuStringColumn(input);
		
		// Assert
		assertEquals(9,sudokuColumns.size());
	}
	@Test
	public void checkSplitFirstColumn() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		ArrayList<String> sudokuColumns = new ArrayList<String>();
		String input = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertTrue(sudoku.checkOnlyPositiveDigits(input));
		sudokuColumns = sudoku.splitSudokuStringColumn(input);
		
		// Assert
		assertEquals("469873251",sudokuColumns.get(0));
	}
	@Test
	public void checkSplitLastColumn() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		ArrayList<String> sudokuColumns = new ArrayList<String>();
		String input = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertTrue(sudoku.checkOnlyPositiveDigits(input));
		sudokuColumns = sudoku.splitSudokuStringColumn(input);
		
		// Assert
		assertEquals("576928143",sudokuColumns.get(8));
	}
	//5. Test cases for method to split input in sub grid
	@Test
	public void checkSplitSubGridNumbers() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		ArrayList<String> sudokuSubGrid = new ArrayList<String>();
		String input = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertTrue(sudoku.checkOnlyPositiveDigits(input));
		sudokuSubGrid = sudoku.splitSudokuStringSubgrid(input);
		
		// Assert
		assertEquals(9,sudokuSubGrid.size());
	}
	@Test
	public void checkSplitFirstSubGrid() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		ArrayList<String> sudokuSubGrid = new ArrayList<String>();
		String input = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertTrue(sudoku.checkOnlyPositiveDigits(input));
		sudokuSubGrid = sudoku.splitSudokuStringSubgrid(input);
		
		// Assert
		assertEquals("417632958",sudokuSubGrid.get(0));
	}
	@Test
	public void checkSplitLastSubGrid() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		ArrayList<String> sudokuSubGrid = new ArrayList<String>();
		String input = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertTrue(sudoku.checkOnlyPositiveDigits(input));
		sudokuSubGrid = sudoku.splitSudokuStringSubgrid(input);
		
		// Assert
		assertEquals("571684293",sudokuSubGrid.get(8));
	}
	//11. Add test cases for method to validate whole Sudoku field for digits only once
	@Test
	public void checkVerifyCorrectSequenceTotal() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		ArrayList<String> sudokuRows = new ArrayList<String>();
		String input = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertTrue(sudoku.checkOnlyPositiveDigits(input));
		sudokuRows = sudoku.splitSudokuStringRow(input);
		// Assert
		assertTrue(sudoku.verifyDigitsOnceAll(sudokuRows));
	}
	@Test
	public void checkVerifyWrongSequenceTotal() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		ArrayList<String> sudokuRows = new ArrayList<String>();
		String input = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertTrue(sudoku.checkOnlyPositiveDigits(input));
		sudokuRows = sudoku.splitSudokuStringRow(input);
		// Assert
		assertTrue(sudoku.verifyDigitsOnceAll(sudokuRows));
	}
	//12. Add test cases to check logic for verify method
	@Test
	public void checkVerifyCorrect() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		String input = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		// Assert
		assertEquals(0,sudoku.verify(input));
	}
	@Test
	public void checkVerifyNotOnlyDigits() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		String input = "41736982563215894A958724316825437169791586432346912758289643571573291684164875293";
		// Assert
		assertEquals(-1,sudoku.verify(input));
	}
	@Test
	public void checkVerifyIncorrect() {
		// Arrange
		SudokuVerifier sudoku = new SudokuVerifier();
		String input = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		// Assert
		assertEquals(-2,sudoku.verify(input));
	}
}
