import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
	private static String correct = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	private static String inCorrect = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
	private static String inCorrectString = "1234567899123456788912a4567789123456678912345567891234456789123345678912234567891";
	private static String inCorrectRows = "184154739392687652756932418861275391527396824943841567279513286615728943438469175";
	private static String inCorrectColumns = "324598167579216384168347295982751643745963821316482579693875412857124936421639758";

	@Test
	public void testCheckStringValid_Valid(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(true, sudoku.checkStringValid(correct));
	}
	@Test
	public void testCheckStringValid_InValid(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(false, sudoku.checkStringValid("654345a6789"));
	}
	@Test
	public void testCheckStringValid_CheckForZero(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(false, sudoku.checkStringValid("65434506789"));
	}

	@Test
	public void testCheckStringLength_81(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(true, sudoku.checkStringLength(correct));
	}

	@Test
	public void testCheckStringLength_Shorter(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(false, sudoku.checkStringLength("65434506789"));
	}

	@Test
	public void testCheckStringLength_Longer(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(false, sudoku.checkStringLength(correct+"65434506789"));
	}

	@Test
	public void testCheckSubGrid_CorrectInput(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(true, sudoku.checkSubGrid(correct));
	}

	@Test
	public void testCheckSubGrid_WrongInput(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(false, sudoku.checkSubGrid(inCorrect));
	}
	@Test
	public void testCheckRows_CorrectInput(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(true, sudoku.checkRows(correct));
	}

	@Test
	public void testCheckRows_WrongInput(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(false, sudoku.checkRows(inCorrectRows));
	}
	@Test
	public void testCheckColumns_CorrectInput(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(true, sudoku.checkColumns(correct));
	}

	@Test
	public void testCheckColumns_WrongInput(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(false, sudoku.checkColumns(inCorrectColumns));
	}

	@Test
	public void testVerify_OK(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(0, sudoku.verify(correct));
	}

	@Test
	public void testVerify_R1(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(-1, sudoku.verify(inCorrectString));
	}
	@Test
	public void testVerify_R1_TooLong(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(-1, sudoku.verify(inCorrectString+"43456"));
	}
	@Test
	public void testVerify_R2(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(-2, sudoku.verify(inCorrect));
	}
	@Test
	public void testVerify_R3(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(-3, sudoku.verify(inCorrectRows));
	}
	@Test
	public void testVerify_R4(){
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(-4, sudoku.verify(inCorrectColumns));
	}
}
