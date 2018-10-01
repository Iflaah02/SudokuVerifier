import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SudokuVerifierParametrizedTest {

	private SudokuVerifier sudokuVerifier;

	@Before
	public void initializeSudoku() {
		sudokuVerifier = new SudokuVerifier();
	}

	@Test(expected = SudokuVerifierException.class)
	public void testSudoku_NullString() throws SudokuVerifierException {
		//Arrange
		String nullString = null;
		//Act
		int returnCode = sudokuVerifier.verify(nullString);
	}

	@Test(expected = SudokuVerifierException.class)
	public void testSudoku_EmptyString() throws SudokuVerifierException {
		//Arrange
		String emptyString = "";
		//Act
		int returnCode = sudokuVerifier.verify(emptyString);
	}

	@Test(expected = SudokuVerifierException.class)
	public void testSudoku_RegexNoMatch() throws SudokuVerifierException {
		//Arrange
		String invalidRegexMatchString = "asd";
		//Act
		int returnCode = sudokuVerifier.verify(invalidRegexMatchString);
	}

	@Test(expected = SudokuVerifierException.class)
	public void testSudoku_StringTooShort() throws SudokuVerifierException {
		//Arrange
		String shortString = "1";
		//Act
		int returnCode = sudokuVerifier.verify(shortString);
	}

	@Test(expected = SudokuVerifierException.class)
	public void testSudoku_StringTooLong() throws SudokuVerifierException {
		//Arrange
		String longString = "4173698256321589479587243168254371697915864323469127582896435715732916841648752931";
		//Act
		int returnCode = sudokuVerifier.verify(longString);
	}

	@Test
	public void testSudoku_NegativeDigit() throws SudokuVerifierException {
		//Arrange
		String negativeString = "1234567899123456788912345677891234566789123455678912344567891233456789122345678-1";
		//Act
		int returnCode = sudokuVerifier.verify(negativeString);
		//Assert
		assertEquals("The string should contain only positive digits.", -1, returnCode);
	}

	@Test
	public void testSudoku_numberRepeatsInSubGridFirstSet() throws SudokuVerifierException {
		//Arrange
		String repeatingString = "447369825632158947958724316825437169791586432346912758289643571573291684164875293";
		//Act
		int returnCode = sudokuVerifier.verify(repeatingString);
		//Assert
		assertEquals("The string should not have duplicate digits in a subgrid.", -2, returnCode);

		//Arrange
		repeatingString = "417369825632158947958724316885437169791586432346912758289643571573291684164875293";
		//Act
		returnCode = sudokuVerifier.verify(repeatingString);
		//Assert
		assertEquals("The string should not have duplicate digits in a subgrid.", -2, returnCode);

		//Arrange
		repeatingString = "417369825632158947958724316825437169791586432346912758289643571573291684164875233";
		//Act
		returnCode = sudokuVerifier.verify(repeatingString);
		//Assert
		assertEquals("The string should not have duplicate digits in a subgrid.", -2, returnCode);
	}




	@Test
	public void testSudoku_numberRepeatsInGlobalRow() throws SudokuVerifierException {
		//Arrange
		String globalRowString = "417469825632158947958723316825437169791586432346912758289643571573291684164875293";
		//Act
		int returnCode = sudokuVerifier.verify(globalRowString);
		//Assert
		assertEquals("The string should not have duplicate digits in rows.", -3, returnCode);
	}

	@Test
	public void testSudoku_numberRepeatsInGlobalColumn() throws SudokuVerifierException {
		//Arrange
		String globalRowString = "123456789456789123789123456123456789456789123789123456123456789456789123789123456";
		//Act
		int returnCode = sudokuVerifier.verify(globalRowString);
		//Assert
		assertEquals("The string should not have duplicate digits in columns.", -4, returnCode);
	}

	@Test
	public void testSudoku_validString() throws SudokuVerifierException {
		//Arrange
		String validString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		//Act
		int returnCode = sudokuVerifier.verify(validString);
		//Assert
		assertEquals("The string should be a valid solution.", 0, returnCode);
	}
}
