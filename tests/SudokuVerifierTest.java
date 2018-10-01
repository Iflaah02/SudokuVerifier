import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SudokuVerifierTest {

	private SudokuVerifier sudokuVerifier;

	@Before
	public void initializeSudoku() {
		sudokuVerifier = new SudokuVerifier();
	}

	@Test
	public void testVerify() throws SudokuVerifierException {
		//Arrange
		String correctString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		String incorrectString = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		//Act
		int returnCode = sudokuVerifier.verify(correctString);
		//Assert
		assertEquals("Correct string should return 0.", 0, returnCode);

		//Act
		returnCode = sudokuVerifier.verify(incorrectString);
		//Assert
		assertNotEquals("Incorrect string should not return 0.", 0, returnCode);
	}
}
