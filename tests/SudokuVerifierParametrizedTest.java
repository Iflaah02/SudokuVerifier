import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierParametrizedTest {

	@Test
	public void testVerifyNumber_number() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.verifyNumber("1234567891234567812345678");
		assertEquals(-1,ans);
	}
	
	@Test
	public void testVerifyNumber_positive() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.verifyNumber("-417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(-1,ans);
	}
	
	@Test
	public void testVerifyNumber_True() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.verifyNumber("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(0,ans);
	}
	
	@Test
	public void testConvertToArray() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans[][] = sudo.convertToArray("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(9,ans.length);
		assertEquals(9,ans[0].length);
	}
	
	@Test
	public void testCheckGlobalRow_1() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.checkGlobalRow("417364825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(-3,ans);
	}
	
	@Test
	public void testCheckGlobalRow_9() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.checkGlobalRow("417369825632158947958724316825437169791586432346912758289643571573291684164885293");
		assertEquals(-3,ans);
	}
	
	@Test
	public void testCheckGlobalRow_True() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.checkGlobalRow("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(0,ans);
	}
	
	@Test
	public void testCheckGlobalColumn_1() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.checkGlobalColumn("417369825432158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(-4,ans);
	}
	
	@Test
	public void testCheckGlobalColumn_True() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.checkGlobalColumn("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(0,ans);
	}
	
	@Test
	public void testCheckSubGrid_1() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.checkSubGrid("417369825442158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(-2,ans);
	}
	
	@Test
	public void testCheckSubGrid_9() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.checkSubGrid("417369825632158947958724316825437169791586432346912758289643571573291634164875293");
		assertEquals(-2,ans);
	}
	
	@Test
	public void testCheckSubGrid_True() {
		//Arrange
		SudokuVerifier sudo = new SudokuVerifier();
		//Act
		int ans = sudo.checkSubGrid("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(0,ans);
	}
	

}
