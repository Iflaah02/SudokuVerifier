import static org.junit.Assert.*;

import org.junit.Test;



public class SudokuVerifierParametrizedTest {
	//valid=417369825632158947958724316825437169791586432346912758289643571573291684164875293
	String valid="417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	String invalid="123456789912345678891234567789123456678912345567891234456789123345678912234567891";
	String LenghtError="12345678991234567889123456778912345667891234556789123445678912334567891223456789144";
	String FormError="-17369825632158947958724316825437169791586432346912758289643571573291684164875293";
	String RowError="417369825632158947958724316825437169791586432346912758289643571573291684164875299";
	String ColumnError="417369825632158947958724316825437169791586432346912758289643571573291684564875293";
	String SubgridError="447369825632158947958724316825437169791586432346912758289643571573291684164875993";

	@Test (expected=IllegalArgumentException.class)
	public void TestSudokuVerifier_LenghtElseThan81ThrowsException() {
		SudokuVerifier sudoku = new SudokuVerifier();		
		sudoku.checkLenght(LenghtError);		
	}
	@Test
	public void TestSudokuVerifier_NegativeDigitReturnsNeg1() {
		SudokuVerifier sudoku = new SudokuVerifier();		
		assertEquals("Fail",-1,sudoku.checkDigits(FormError));
	}
	@Test
	public void TestSudokuVerifier_RowErrorReturnsNeg3() {
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals("Fail",-3,sudoku.checkRows(RowError));		
	}
	@Test
	public void TestSudokuVerifier_CorrectRowReturns0() {
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals("Fail",0,sudoku.checkRows(valid));		
	}
	@Test
	public void TestSudokuVerifier_ColumnErrorReturnsNeg4() {
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals("Fail",-4,sudoku.checkColumns(ColumnError));	
	}
	@Test
	public void TestSudokuVerifier_CorrectColumnReturns0() {
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals("Fail",0,sudoku.checkColumns(valid));
	}
	@Test
	public void TestSudokuVerifier_SubgridErrorReturnsNeg2() {
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals("Fail",-2,sudoku.checkSubgrids(SubgridError));		
	}
	@Test
	public void TestSudokuVerifier_CorrectSubgridReturns0() {
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals("Fail",0,sudoku.checkSubgrids(valid));		
	}
	@Test
	public void TestSudokuVerifier_CorrectSolutionReturnsZero() {
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals("Fail",0,sudoku.verify(valid));		
	}
	@Test
	public void TestSudokuVerifier_IncorrectSolutionReturnsNegative() {//apparently -2 in given incorrect string
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals("Fail",-2,sudoku.verify(invalid));		
	}
	

}
