import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	/*
	@Test
	public void testCheckLength() {
		fail("Not yet implemented");
	}
	*/

	@Test
	public void testCheckLength_Correct() {
		//Arrange
		String candidateSolution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293"; 
		SudokuVerifier sudoku = new SudokuVerifier(); 
		boolean result; 
		
		//Act 
		result = sudoku.checkLength(candidateSolution);
		
		//Assertion
		assertTrue(result);
	}
	
	@Test
	public void testCheckLength_Incorrect() {
		//Arrange
		String candidateSolution = "17369825632158947958724316825437169791586432346912758289643571573291684164875293"; 
		SudokuVerifier sudoku = new SudokuVerifier(); 
		boolean result; 
		
		//Act 
		result = sudoku.checkLength(candidateSolution);
		
		//Assertion
		assertFalse(result);
	}
	
	@Test
	public void testCheckPositiveDigits_Correct() {
		//Arrange
		String candidateSolution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293"; 
		SudokuVerifier sudoku = new SudokuVerifier(); 
		int expectedResult = 0; 
		int result; 
		
		//Act 
		result = sudoku.checkPositiveDigits(candidateSolution);
		
		//Assertion
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testCheckPositiveDigits_Incorrect() {
		//Arrange
		String candidateSolution = "41736a825632158947958724316825437169791586432346912758289643571573291684164875293"; 
		SudokuVerifier sudoku = new SudokuVerifier(); 
		int expectedResult = -1; 
		int result; 
		
		//Act 
		result = sudoku.checkPositiveDigits(candidateSolution);
		
		//Assertion
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testGetSubRows() {
		//Arrange
		String candidateSolution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293"; 
		SudokuVerifier sudoku = new SudokuVerifier(); 
		String[][] sudokuArray = new String[9][3]; 
		String[][] expectedOutput = new String[][] {{"417","369","825"},
													{"632","158","947"},
													{"958","724","316"},
													{"825","437","169"},
													{"791","586","432"},
													{"346","912","758"},
													{"289","643","571"},
													{"573","291","684"},
													{"164","875","293"},
													}; 
		//Act 
		sudokuArray = sudoku.getSubRows(candidateSolution);
		
		//Assertion
		assertArrayEquals(expectedOutput, sudokuArray);
	}
	
	
	@Test
	public void testCheckSubGrid_Correct() {
		//Arrange
		SudokuVerifier sudoku = new SudokuVerifier(); 
		String[][] sudokuArray = new String[][] {{"417","369","825"},
												{"632","158","947"},
												{"958","724","316"},
												{"825","437","169"},
												{"791","586","432"},
												{"346","912","758"},
												{"289","643","571"},
												{"573","291","684"},
												{"164","875","293"},
												}; 
		int result; 
		int expectedResult = 0; 
		
		//Act 
		result = sudoku.checkSubGrid(sudokuArray);
		
		//Assertion
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testCheckSubGrid_Incorrect() {
		//Arrange
		SudokuVerifier sudoku = new SudokuVerifier(); 
		String[][] sudokuArray = new String[][] {{"447","369","825"},
												{"632","158","947"},
												{"958","724","316"},
												{"825","437","169"},
												{"791","586","432"},
												{"346","912","758"},
												{"289","643","571"},
												{"573","291","684"},
												{"164","875","293"},
												}; 
		int result; 
		int expectedResult = -2; 
		
		//Act 
		result = sudoku.checkSubGrid(sudokuArray);
		
		//Assertion
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testCheckGlobalRow_Correct() {
		//Arrange
		SudokuVerifier sudoku = new SudokuVerifier(); 
		String[][] sudokuArray = new String[][] {{"417","369","825"},
												{"632","158","947"},
												{"958","724","316"},
												{"825","437","169"},
												{"791","586","432"},
												{"346","912","758"},
												{"289","643","571"},
												{"573","291","684"},
												{"164","875","293"},
												}; 
		int result; 
		int expectedResult = 0; 
		
		//Act 
		result = sudoku.checkGlobalRow(sudokuArray);
		
		//Assertion
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testCheckGlobalRow_Incorrect() {
		//Arrange
		SudokuVerifier sudoku = new SudokuVerifier(); 
		String[][] sudokuArray = new String[][] {{"417","369","825"},
												{"632","158","947"},
												{"958","724","316"},
												{"825","437","169"},
												{"791","586","432"},
												{"346","912","758"},
												{"289","643","571"},
												{"573","291","684"},
												{"164","875","493"},
												}; 
		int result; 
		int expectedResult = -3; 
		
		//Act 
		result = sudoku.checkGlobalRow(sudokuArray);
		
		//Assertion
		assertEquals(expectedResult, result);
	}

	@Test
	public void testCheckGlobalColumn_Correct() {
		//Arrange
		SudokuVerifier sudoku = new SudokuVerifier(); 
		String[][] sudokuArray = new String[][] {{"417","369","825"},
												{"632","158","947"},
												{"958","724","316"},
												{"825","437","169"},
												{"791","586","432"},
												{"346","912","758"},
												{"289","643","571"},
												{"573","291","684"},
												{"164","875","293"},
												}; 
		int result; 
		int expectedResult = 0; 
		
		//Act 
		result = sudoku.checkGlobalColumn(sudokuArray);
		
		//Assertion
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testCheckGlobalColumn_Incorrect() {
		//Arrange
		SudokuVerifier sudoku = new SudokuVerifier(); 
		String[][] sudokuArray = new String[][] {{"417","369","825"},
												{"632","158","947"},
												{"958","724","316"},
												{"125","437","169"},
												{"791","586","432"},
												{"346","912","758"},
												{"289","643","571"},
												{"573","291","684"},
												{"164","875","293"},
												}; 
		int result; 
		int expectedResult = -4; 
		
		//Act 
		result = sudoku.checkGlobalColumn(sudokuArray);
		
		//Assertion
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testVerify_Correct() {
		//Arrange
		String candidateSolution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293"; 
		SudokuVerifier sudoku = new SudokuVerifier(); 
		int result; 
		int expectedResult = 0; 
		
		//Act 
		result = sudoku.verify(candidateSolution);
		
		//Assertion
		assertEquals(expectedResult, result); 
	}
	
	@Test
	public void testVerify_Incorrect_Rule1() {
		//Arrange
		String candidateSolution = "41736a825632158947958724316825437169791586432346912758289643571573291684164875293"; 
		SudokuVerifier sudoku = new SudokuVerifier(); 
		int result; 
		int expectedResult = -1; 
		
		//Act 
		result = sudoku.verify(candidateSolution);
		
		//Assertion
		assertEquals(expectedResult, result); 
	}
	
	
	@Test
	public void testVerify_Incorrect_Rule2() {
		//Arrange
		String candidateSolution = "517369825632158947958724316825437169791586432346912758289643571573291684164875293"; 
		SudokuVerifier sudoku = new SudokuVerifier(); 
		int result; 
		int expectedResult = -2; 
		
		//Act 
		result = sudoku.verify(candidateSolution);
		
		//Assertion
		assertEquals(expectedResult, result); 
	}
	
	@Test
	public void testVerify_Incorrect_Rule3() {
		//Arrange
		String candidateSolution = "617369825432158947958724316825437169791586432346912758289643571573291684164875293"; 
		SudokuVerifier sudoku = new SudokuVerifier(); 
		int result; 
		int expectedResult = -3; 
		
		//Act 
		result = sudoku.verify(candidateSolution);
		
		//Assertion
		assertEquals(expectedResult, result); 
	}
	
	@Test
	public void testVerify_Incorrect_Rule4() {
		//Arrange
		String candidateSolution = "471369825632158947958724316825437169791586432346912758289643571573291684164875293"; 
		SudokuVerifier sudoku = new SudokuVerifier(); 
		int result; 
		int expectedResult = -4; 
		
		//Act 
		result = sudoku.verify(candidateSolution);
		
		//Assertion
		assertEquals(expectedResult, result); 
	}
}
