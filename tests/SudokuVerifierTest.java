import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testrightVerify() {
		String fullSudoku = "417369825632158947958724316" +
				"825437169791586432346912758" +
				"289643571573291684164875293";

		SudokuVerifier sv = new SudokuVerifier();
		//assertTrue(sv.verify(fullcandidateSolution));
		assertEquals(0, sv.verify(fullSudoku));
	}
	
	@Test
	public void verifyInvalidSudoku() {
		String fullSudoku = "248397716571628349936741582" +
				"682539174359174628714862953" +
				"863417295195286437427953861";

		SudokuVerifier sv = new SudokuVerifier();
		//assertTrue(sv.verify(fullcandidateSolution));
		assertEquals(-3, sv.verify(fullSudoku));
	}
	
	@Test
	public void verifyInvalidlengthSudoku() {
		String fullSudoku = "248397716571628349936741582";

		SudokuVerifier sv = new SudokuVerifier();
		//assertTrue(sv.verify(fullcandidateSolution));
		assertEquals(-1, sv.verify(fullSudoku));
	}
	
	@Test
	public void verifyInvalidminusSudoku() {
		String fullSudoku = "24-8";

		SudokuVerifier sv = new SudokuVerifier();
		//assertTrue(sv.verify(fullcandidateSolution));
		assertEquals(-1, sv.verify(fullSudoku));
	}
	
	@Test
	public void testInvalidcVerify() {
		String fullSudoku = "417369825632158947958724316" +
				"825437169791586432346912758" +
				"289643571573291684164875299";

		SudokuVerifier sv = new SudokuVerifier();
		//assertTrue(sv.verify(fullcandidateSolution));
		assertEquals(-3, sv.verify(fullSudoku));
	}

}
