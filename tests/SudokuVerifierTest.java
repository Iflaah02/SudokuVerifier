import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	
	@Test
	public void testrule1() {
		SudokuVerifier obj = new SudokuVerifier();
		int ret = obj.verify("4634-6346464363464343643433366446666");
		
		assertEquals(-1, ret);
		
	}
	
	@Test
	public void testrule3() {
		SudokuVerifier obj = new SudokuVerifier();
		int ret = obj.verify("4173698256321589479587243168254371697915864323469127582896435715732916841" + 
				"64875293");
		
		assertEquals(0, ret);
		
		ret = obj.verify("44444444444444444444444444444444444444444444444444444444444444444444444444444" + 
				"44444444");
		
		assertEquals(-3, ret);
		
		
	}
	
	

}
