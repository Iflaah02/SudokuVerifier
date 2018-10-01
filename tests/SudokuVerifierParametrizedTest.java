import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierParametrizedTest {
	
	@Test
	public void testInCorrect_notEnoughCharacters() {
		SudokuVerifier test = new SudokuVerifier();
		int ans = test.verify("17369825632158947958724316825437169791586432346912758289643571573291684164875293");
		
		assertEquals(ans, 1, ans);
	}
	
	@Test
	public void testInCorrect_ZeroNumber() {
		SudokuVerifier test = new SudokuVerifier();
		int ans = test.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875290");
		
		assertEquals(ans, -1, ans);
	}
	
	@Test
	public void testInCorrect_NegativeNumber() {
		SudokuVerifier test = new SudokuVerifier();
		int ans = test.verify("1736982563215894795-6724316825437169791586432346912758289643571573291684164875293");
		
		assertEquals(ans, -1, ans);
	}
	
	@Test
	public void testInCorrect_RowsHaveTwoSameNumber() {
		SudokuVerifier test = new SudokuVerifier();
		int ans = test.verify("111111111222222222333333333444444444555555555666666666777777777888888888999999999");
		
		assertEquals(ans, -3, ans);
	}
	
	@Test
	public void testInCorrect_ColumnsHaveTwoSameNumber() {
		SudokuVerifier test = new SudokuVerifier();
		int ans = test.verify("123456789123456789123456789123456789123456789123456789123456789123456789123456789");
		
		assertEquals(ans, -4, ans);
	}
	
	@Test
	public void testInCorrect_ThreexThreeTwoSameNumber() {
		SudokuVerifier test = new SudokuVerifier();
		int ans = test.verify("123456789234567891345678912456789123567891234678912345789123456891234567912345678");
		
		assertEquals(ans, -2, ans);
	}

}
