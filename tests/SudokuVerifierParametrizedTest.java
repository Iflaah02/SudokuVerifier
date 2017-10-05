import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierParametrizedTest {
	
	//417 369 825
	//632 158 947
	//958 724 316
	//
	//825 437 169
	//791 586 432
	//346 912 758
	//
	//289 643 571
	//573 291 684
	//164 875 293

	@Test
	public void testVerify_validSolution() {
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		int value = ver.verify(solution);
		
		assertEquals("Correct solution is deemed incorrect", 0, value);
	}
	
	@Test
	public void testVerify_invalidSubgrids() {
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "123456789234567891345678912456789123567891234678912345789123456891234567912345678";
		
		int value = ver.verify(solution);
		
		assertEquals("Incorrect solution is deemed correct, problem with subgrids", -2, value);
	}
	
	@Test
	public void testVerify_invalidColumns() {
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "123456789456789123789123456123456789456789123789123456123456789456789123789123456";
		
		int value = ver.verify(solution);
		
		assertEquals("Incorrect solution is deemed correct, problem with columns", -4, value);
	}
	
	@Test
	public void testVerify_invalidRows() {
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "147147147258258258369369369147147147258258258369369369147147147258258258369369369";
		
		int value = ver.verify(solution);
		
		assertEquals("Incorrect solution is deemed correct, problem with rows", -3, value);
	}
	
	
	@Test
	public void testIsGridValid_validGrid() {
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		boolean value = ver.isGridValid(solution);
		
		assertEquals("Correct solution is deemed invalid", value, true);
	}
	
	@Test
	public void testIsGridValid_gridWithAlphas() {
		
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "41736982563215894795872431682543716979158643234691275828964357157329168a164875293";
		
		boolean value = ver.isGridValid(solution);
		
		assertEquals("Accepts alphas in grid", value, false);
		
	}

	@Test
	public void testIsGridValid_gridWithZeros() {
		
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "417369825632158947958724316825437169791586432346912758289643571573291680164875293";
		
		boolean value = ver.isGridValid(solution);
		
		assertEquals("Accepts zeroes in grid", value, false);
		
	}
	
	@Test
	public void testIsGridValid_gridWithSpecialCharacters() {
		
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "4173698256321589479587243168254371697915864323469127582896435715739168-164875293";
		
		boolean value = ver.isGridValid(solution);
		
		assertEquals("Accepts special characters in grid", value, false);
		
	}
	
	@Test
	public void testIsGridValid_invalidLength() {
		
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "41736982563";
		
		boolean value = ver.isGridValid(solution);
		
		assertEquals("Accepts invalid length of grid", value, false);
		
	}
	
	@Test
	public void testSubGrid_correct0IndexGrid() {
		
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		String subGrid = ver.subGrid(solution, 0);
		
		assertEquals("Subgrid 0 is invalid", "417632958", subGrid);
		
	}
	
	@Test
	public void testSubGrid_correct4IndexGrid() {
		
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		String subGrid = ver.subGrid(solution, 4);
		
		assertEquals("Subgrid 4 is invalid", "437586912", subGrid);
		
	}
	
	@Test
	public void testSubGrid_correct8IndexGrid() {
		
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		String subGrid = ver.subGrid(solution, 8);
		
		assertEquals("Subgrid 8 is invalid", "571684293", subGrid);
		
	}
	
	@Test
	public void testColumn_correct2IndexColumn() {
		
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		String subGrid = ver.column(solution, 2);
		
		assertEquals("Column 2 is invalid", "728516934", subGrid);
		
	}
	
	@Test
	public void testRow_correct2IndexRow() {
		
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		String subGrid = ver.row(solution, 2);
		
		assertEquals("Row 2 is invalid", "958724316", subGrid);
		
	}
	
	@Test
	public void testUniqueCharacters_validString() {
		
		SudokuVerifier ver = new SudokuVerifier();
		String str = "asd234fg7";
		
		boolean value = ver.onlyUniqueCharacters(str);
		
		assertEquals("String with unique characters dismissied", true, value);
		
	}
	
	@Test
	public void testUniqueCharacters_invalidString() {
		
		SudokuVerifier ver = new SudokuVerifier();
		String str = "asdg234fg7";
		
		boolean value = ver.onlyUniqueCharacters(str);
		
		assertEquals("Accepted string with repeating characters", false, value);
		
	}
	
	@Test
	public void testCheckSubgrids_validSubgrids() {
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		boolean value = ver.checkSubGrids(solution);
		
		assertEquals("Valid subgrids were not accepted", true, value);
		
	}
	
	@Test
	public void testCheckSubgrids_invalidSubgrids() {
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		
		boolean value = ver.checkSubGrids(solution);
		
		assertEquals("Invalid subgrids accepted", false, value);
	}
	
	@Test
	public void testCheckColumns_validColumns() {
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		boolean value = ver.checkColumns(solution);
		
		assertEquals("Valid columns were not accepted", true, value);
		
	}
	
	@Test
	public void testCheckColumns_invalidColumns() {
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "923456789912345678891234567789123456678912345567891234456789123345678912234567891";
		
		boolean value = ver.checkColumns(solution);
		
		assertEquals("Invalid columns accepted", false, value);
	}
	
	@Test
	public void testCheckRows_validRows() {
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		boolean value = ver.checkRows(solution);
		
		assertEquals("Valid rows were not accepted", true, value);
		
	}
	
	@Test
	public void testCheckRows_invalidRows() {
		SudokuVerifier ver = new SudokuVerifier();
		String solution = "123456789912345778891234567789123456678912345567891234456789123345678912234567891";
		
		boolean value = ver.checkRows(solution);
		
		assertEquals("Invalid rows accepted", false, value);
	}
	
}
