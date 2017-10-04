import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	
	@Test
	public void testReadSolutionString() {
		
		SudokuVerifier verifier = new SudokuVerifier();
		
		verifier.readSolutionString("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		
		assertEquals("solution string and input string do not match", 
						verifier.solutionString, 
						"417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		
	}
	
	@Test
	public void testTooLongSolutionString() {
		
		SudokuVerifier verifier = new SudokuVerifier();
		
		verifier.readSolutionString("4173698256321589479587243168254371697915864323469127582896435715732916841648752931");
		
		assertFalse(verifier.checkSolutionLength());
	}
	
	@Test
	public void testTooShortSolutionString() {
		
		SudokuVerifier verifier = new SudokuVerifier();
		
		verifier.readSolutionString("41736982563215894795872431682543716979158643234691275828964357157329168416487529");
		
		assertFalse(verifier.checkSolutionLength());
	}
	
	@Test
	public void testCorrectLengthSolutionString() {
		
		SudokuVerifier verifier = new SudokuVerifier();
		
		verifier.readSolutionString("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		
		assertTrue(verifier.checkSolutionLength());
	}
	
	@Test
	public void testRowChecking_IncorrectEntry() {		
		SudokuVerifier verifier = new SudokuVerifier();
		
		verifier.rows.get(0).add('1');
		verifier.rowIndex = 0;
				
		assertFalse(verifier.checkRow('1'));
		
	}
	
	@Test
	public void testRowChecking_CorrectEntry() {
		SudokuVerifier verifier = new SudokuVerifier();
		
		verifier.rows.get(0).add('1');
		verifier.rowIndex = 0;
		
		assertTrue(verifier.checkRow('2'));
		assertTrue(verifier.rows.get(0).contains('2'));
	}
	
	@Test
	public void testColumnCheck_IncorrectEntry() {		
		SudokuVerifier verifier = new SudokuVerifier();
		
		verifier.columns.get(0).add('1');
		verifier.columnIndex = 0;
				
		assertFalse(verifier.checkColumn('1'));
		
	}
	
	@Test
	public void testColumnCheck_CorrectEntry() {
		SudokuVerifier verifier = new SudokuVerifier();
		
		verifier.columns.get(0).add('1');
		verifier.columnIndex = 0;
		
		assertTrue(verifier.checkColumn('2'));
		assertTrue(verifier.columns.get(0).contains('2'));
	}
	
	@Test
	public void testCheckSubGrid_IncorrectEntry() {		
		SudokuVerifier verifier = new SudokuVerifier();
		
		verifier.subGrids.get(0).add('1');
		verifier.subGridIndex = 0;
				
		assertFalse(verifier.checkSubGrid('1'));
		
	}
	
	@Test
	public void testCheckSubGrid_CorrectEntry() {
		SudokuVerifier verifier = new SudokuVerifier();
		
		verifier.subGrids.get(0).add('1');
		verifier.subGridIndex = 0;
		
		assertTrue(verifier.checkSubGrid('2'));
		assertTrue(verifier.subGrids.get(0).contains('2'));
	}
	
	
	@Test
	public void testEntryHasLetters() {
		
		SudokuVerifier verifier = new SudokuVerifier();
		
		assertEquals(-1, verifier.verify("A17369825632158947958724316825437169791586432346912758289643571573291684164875293"));
	}

	@Test
	public void testEntryHasSpecialCharacters() {
		SudokuVerifier verifier = new SudokuVerifier();
		
		assertEquals(-1, verifier.verify("-17369825632158947958724-16825437169791586432346912758289643571573291684164875293"));
	}
	
	
	@Test
	public void testRowDuplicate() {
		SudokuVerifier verifier = new SudokuVerifier();
		
		assertEquals(-3, verifier.verify("417469825632158947958724316825437169791586432346912758289643571573291684164875293"));
	}
	
	@Test
	public void testColumnDuplicate() {
		SudokuVerifier verifier = new SudokuVerifier();
		
		assertEquals(-4, verifier.verify("417369825632158947958724316825437169791586432346912758289643571573291684464875293"));
	}
	
	@Test
	public void testSubGridDuplicate() {
		SudokuVerifier verifier = new SudokuVerifier();
		
		assertEquals(-2, verifier.verify("417369825642158947958724316825437169791586432346912758289643571573291684164875293"));
	}
	
	@Test
	public void testValidEntry() {
		SudokuVerifier verifier = new SudokuVerifier();
		
		assertEquals(0, verifier.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293"));
	}

}
