import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testCheckLength81() {
		SudokuVerifier sv = new SudokuVerifier();
		String SudokuString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	
		assertEquals(1, sv.checkLength(SudokuString));
	}
	
	@Test
	public void testCheckLength80() {
		SudokuVerifier sv = new SudokuVerifier();
		String SudokuString = "17369825632158947958724316825437169791586432346912758289643571573291684164875293";
	
		assertEquals(0, sv.checkLength(SudokuString));
	}
	
	@Test
	public void testCutRow1() {
		SudokuVerifier sv = new SudokuVerifier();
		String SudokuString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		String[] rows = sv.cutRow(SudokuString);
		
		assertEquals("417369825", rows[0]);
	}
	
	@Test
	public void testCutRow2() {
		SudokuVerifier sv = new SudokuVerifier();
		String SudokuString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		String[] rows = sv.cutRow(SudokuString);
		
		assertEquals("632158947", rows[1]);
	}
	
	@Test
	public void testCutColums1() {
		SudokuVerifier sv = new SudokuVerifier();
		String SudokuString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		String[] columns = sv.cutColumns(SudokuString);
		
		assertEquals("469873251", columns[0]);
	}
	
	@Test
	public void testCutColums2() {
		SudokuVerifier sv = new SudokuVerifier();
		String SudokuString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		String[] columns = sv.cutColumns(SudokuString);
		
		assertEquals("135294876", columns[1]);
	}
	
	@Test
	public void testCutSubGrid1() {
		SudokuVerifier sv = new SudokuVerifier();
		String SudokuString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		String[] subGrid = sv.cutSubGrid(SudokuString);
		
		assertEquals("417632958", subGrid[0]);
	}
	
	@Test
	public void testCutSubGrid2() {
		SudokuVerifier sv = new SudokuVerifier();
		String SudokuString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		String[] subGrid = sv.cutSubGrid(SudokuString);
		
		assertEquals("369158724", subGrid[1]);
	}
	
	@Test
	public void testCutSubGrid3() {
		SudokuVerifier sv = new SudokuVerifier();
		String SudokuString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		String[] subGrid = sv.cutSubGrid(SudokuString);
		
		assertEquals("825947316", subGrid[2]);
	}
	
	@Test
	public void testCutSubGrid4() {
		SudokuVerifier sv = new SudokuVerifier();
		String SudokuString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		String[] subGrid = sv.cutSubGrid(SudokuString);
		
		assertEquals("825791346", subGrid[3]);
	}
	
	@Test
	public void testCountNumbers1() {
		SudokuVerifier sv = new SudokuVerifier();
		String SudokuString = "123456789";
		
		assertEquals(1, sv.countNumbers(SudokuString, 1));
	}
	
	@Test
	public void testCountNumbers3() {
		SudokuVerifier sv = new SudokuVerifier();
		String SudokuString = "123451719";
		
		assertEquals(3, sv.countNumbers(SudokuString, 1));
	}
	
	@Test
	public void testPositiveDigits0() {
		SudokuVerifier sv = new SudokuVerifier();
		String SudokuString = "417369825632158947-58724316825437169791586432346912758289643571573291684164875293";
		
		assertEquals(0, sv.positiveDigits(SudokuString));
	}
	
	@Test
	public void testPositiveDigits1() {
		SudokuVerifier sv = new SudokuVerifier();
		String SudokuString = "417369825632158947758724316825437169791586432346912758289643571573291684164875293";
		
		assertEquals(1, sv.positiveDigits(SudokuString));
	}
	
	@Test
	public void testSudokuVerifier0() {
		SudokuVerifier sv = new SudokuVerifier();
		String SudokuString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		assertEquals(0, sv.verify(SudokuString));
	}
	
	@Test
	public void testSudokuVerifier_minus_2() {
		SudokuVerifier sv = new SudokuVerifier();
		String SudokuString = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		
		assertEquals(-2, sv.verify(SudokuString));
	}

}
