import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	
	@Test
	public void testVerifyWithCorrectSudoku() {
		SudokuVerifier obj = new SudokuVerifier();
		int ret = obj.verify("4173698256321589479587243168254371697915864323469127582896435715732916841" + 
				"64875293");
		
		assertEquals(0, ret);
		
	}
	
	@Test
	public void testrule1() {
		SudokuVerifier obj = new SudokuVerifier();
		int ret = obj.verify("4173698256320");
		
		assertEquals(-1, ret);
		
	}
	
	@Test
	public void testRule2WithCorrectSudoku() {
		SudokuVerifier obj = new SudokuVerifier();
		
		String solution = "4173698256321589479587243168254371697915864323469127582896435715732916841" + 
				"64875293";
		char[] testSolution = solution.toCharArray();
		obj.initGrid(testSolution);
		int ret = obj.checkSubGridViolation();
		assertEquals(0, ret);
	} 
	
	@Test
	public void testRule2WithIncorrectSudoku() {
		SudokuVerifier obj = new SudokuVerifier();
		
		String solution = "4173698256421589479587243168254371697915864323469127582896435715732916841" + 
				"64875293";
		char[] testSolution = solution.toCharArray();
		obj.initGrid(testSolution);
		int ret = obj.checkSubGridViolation();
		assertEquals(-2, ret);
	}
	
	@Test
	public void testRule3WithIncorrectSudoku() {
		SudokuVerifier obj = new SudokuVerifier();
		String solution = "4173698286321589479587243168254371697915864323469127582896435715732916841" + 
				"64875293";
		char[] testSolution = solution.toCharArray();
		obj.initGrid(testSolution);		
		int ret = obj.checkRowViolation(obj.getTable());
		
		assertEquals(-3, ret);
	}
	
	@Test
	public void testrule3WithCorrectSudoku() {
		SudokuVerifier obj = new SudokuVerifier();
		String solution = "4173698256321589479587243168254371697915864323469127582896435715732916841" + 
				"64875293";
		char[] testSolution = solution.toCharArray();		
		obj.initGrid(testSolution);		
		int ret = obj.checkRowViolation(obj.getTable());		
		assertEquals(0, ret);
					
	}
	
	@Test
	public void testRule4WithCorrectSudoku() {
		SudokuVerifier obj = new SudokuVerifier();
		
		String solution = "4173698256321589479587243168254371697915864323469127582896435715732916841" + 
				"64875293";
		char[] testSolution = solution.toCharArray();
		obj.initGrid(testSolution);
		int ret = obj.checkColumnViolation(obj.getTable());
		assertEquals(0, ret);
	}
	
	@Test
	public void testRule4WithIncorrectSudoku() {
		SudokuVerifier obj = new SudokuVerifier();		
				
		String solution = "4173698254321589479587243168254371697915864323469127582896435715732916841" + 
				"64875293";
		char[] testSolution = solution.toCharArray();
		obj.initGrid(testSolution);	
		int ret = obj.checkColumnViolation(obj.getTable());
		
		assertEquals(-4, ret);
	}
	
	

}
