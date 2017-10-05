import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierParametrizedTest {

	@Test
	public void testInputValidityMethod() {
		SudokuVerifier emptySoduku = new SudokuVerifier();
		assertTrue("Invalid inputValidity method", emptySoduku.checkInputValidity("417369825632158947958724316825437169791586432346912758289643571573291684164875293"));
	}
	
	@Test
	public void testInputValidityMethod2() {
		SudokuVerifier emptySoduku = new SudokuVerifier();
		assertFalse("Invalid inputValidity method", emptySoduku.checkInputValidity(" "));
	}

}
