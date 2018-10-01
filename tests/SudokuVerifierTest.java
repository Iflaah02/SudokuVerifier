import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
	private String correct = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	private String incorrect = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
	
	@Test
	public void testVerify_Lenght() {
		SudokuVerifier Sf = new SudokuVerifier();	
		assertEquals(99,Sf.verify("234234234234"));
	}
	
	@Test
	public void testStringSplitterRows() {
		SudokuVerifier Sf = new SudokuVerifier();	
		String[] rows = Sf.StringSplitterRows(correct);
		Sf.PrintRows(rows);
	}
	
	@Test
	public void testStringSplitterColums() {
		SudokuVerifier Sf = new SudokuVerifier();	
		
		Sf.PrintRows(Sf.StringSplitterColums(correct));
	}
	
	
	@Test
	public void testStringToIntArray() {
		SudokuVerifier Sf = new SudokuVerifier();
		String testing = "2222526623";
		int[] ints = Sf.StringToIntArray(testing) ;
		assertEquals(5,ints[4]);
		assertEquals(2,ints[5]);
		assertEquals(6,ints[6]);
		assertEquals(6,ints[7]);
	}
	
	@Test
	public void testSortSudokuRow() {
		SudokuVerifier Sf = new SudokuVerifier();	
		int[] row = new int[] {4,5,6,9,8,7,1,2,3};
		row = Sf.SortSudokuRow(row);
		assertEquals(5,row[4]);
		assertEquals(6,row[5]);
		assertEquals(7,row[6]);		
	}
	
	@Test
	public void testRowHasNoMinusFalse() {
		SudokuVerifier Sf = new SudokuVerifier();	
		int[] row = new int[] {1,-6,3,4,5,6,7,8,9};
		assertFalse(Sf.RowHasNoMinus(row));
	}
	
	@Test
	public void testRowHasNoMinusTrue() {
		SudokuVerifier Sf = new SudokuVerifier();	
		
		int[] row = new int[] {1,2,3,4,3,5,7,8,9};
		assertTrue(Sf.RowHasNoMinus(row));
	}
	
	@Test
	public void testChecktSudokuRowOnlyOnce() {
		// Test to see, that every number is just once.
		SudokuVerifier Sf = new SudokuVerifier();	
		
		int[] row = new int[] {1,2,3,4,5,6,7,8,9};
		assertTrue(Sf.NumberOnlyOnce(row));
	}
	
	@Test
	public void testCheckRows() {
		SudokuVerifier Sf = new SudokuVerifier();	
		String[] rows = new String[] {"RowTest 1","RowTest 2","RowTest 3","RowTest 4"};
		assertEquals(0,Sf.CheckRows(incorrect));
	}
	
	@Test
	public void testPrintRows() {
		SudokuVerifier Sf = new SudokuVerifier();	
		String[] rows = new String[] {"RowTest 1","RowTest 2","RowTest 3","RowTest 4"};
		Sf.PrintRows(rows);
	}
	
	

	


}
