import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testVerify() {
		fail("Not yet implemented");
	}

	@Test
	public void stringSize_too_small() {
		SudokuVerifier Sf = new SudokuVerifier();
		boolean test = Sf.sizeChecker("87987");
		//System.out.println("test:"+test);
		assertEquals("Should be false", false, test);
	}
	
	@Test
	public void stringSize_correct() {
		SudokuVerifier Sf = new SudokuVerifier();
		boolean test = Sf.sizeChecker("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		//System.out.println("test:"+test);
		assertEquals("Should be true", true, test);
	}	
	
	@Test
	public void stringSize_too_big() {
		SudokuVerifier Sf = new SudokuVerifier();
		boolean test = Sf.sizeChecker("1111417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		//System.out.println("test:"+test);
		assertEquals("Should be false", false, test);
	}	
	
	@Test
	public void intChecker_1(){
		SudokuVerifier Sf = new SudokuVerifier();
		boolean test = Sf.intChecker(5);
		assertEquals("Should be true", true, test);
	}

	@Test
	public void intChecker_2(){
		SudokuVerifier Sf = new SudokuVerifier();
		boolean test = Sf.intChecker(-1);
		assertEquals("Should be false", false, test);
	}

	@Test
	public void intChecker_3(){
		SudokuVerifier Sf = new SudokuVerifier();
		boolean test = Sf.intChecker(0);
		assertEquals("Should be false", false, test);
	}	
	
	@Test
	public void intChecker_4(){
		SudokuVerifier Sf = new SudokuVerifier();
		boolean test = Sf.intChecker(10);
		assertEquals("Should be false", false, test);
	}	
	
	@Test
	public void intChecker_5(){
		SudokuVerifier Sf = new SudokuVerifier();
		boolean test = Sf.intChecker(9);
		assertEquals("Should be True", true, test);
	}	
	
	@Test
	public void intChecker_6(){
		SudokuVerifier Sf = new SudokuVerifier();
		boolean test = Sf.intChecker(1);
		assertEquals("Should be True", true, test);
	}	
	
	@Test
	public void testing(){
		SudokuVerifier Sf = new SudokuVerifier();
		Sf.verify("12345");
	}	

	@Test
	public void char_to_int(){
		SudokuVerifier Sf = new SudokuVerifier();
		int x = Sf.charToInt('9');
		assertEquals("Should be 9", 9, x);
	}		
	
	@Test
	public void char_to_int_2(){
		SudokuVerifier Sf = new SudokuVerifier();
		int x = Sf.charToInt('5');
		assertEquals("Should be 5", 5, x);
	}		

	@Test
	public void verify_1() {
		SudokuVerifier Sf = new SudokuVerifier();
		int test = Sf.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		//System.out.println("test:"+test);
		assertEquals("Should be 0 as it does nothing", 0, test);
	}		
	
}

