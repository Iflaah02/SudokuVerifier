import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
	
	@Test
	public void testVerifyTrue() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(0,ans);
	}
		
	@Test
	public void testVerifyNumber_number() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.verify("1234567891234567812345678");
		assertEquals(-1,ans);
	}
	
	@Test
	public void testVerifyNumber_positive() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.verify("-417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(-1,ans);
	}
	
	@Test
	public void testCheckGlobalRow_1() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.verify("417364825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(-3,ans);
	}
	
	@Test
	public void testCheckGlobalRow_9() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.verify("417369825632158947958724316825437169791586432346912758289643571573291684164885293");
		assertEquals(-3,ans);
	}
	
	@Test
	public void testCheckGlobalColumn_1() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.verify("417369825432158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(-4,ans);
	}
	
	@Test
	public void testCheckSubGrid_1() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.verify("417369825442158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(-2,ans);
	}
	
	@Test
	public void testverify() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.verify("417369825632158947958724316825437169791586432346912758289643571573291634164875293");
		assertEquals(-2,ans);
	}
	
	@Test
	public void testverify_False() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.verify("123456789912345678891234567789123456678912345567891234456789123345678912234567891");
		assertEquals(-2,ans);
	}
	
	

}
