import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test
	public void testCheckInput() {
		SudokuVerifier suVe = new SudokuVerifier();
		
		String testStr1 = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		//negative (non-digit)
		String testStr2 = "-41736982563215894795872431682543716979158643234691275828964357157329168416487529";
		//too long
		String testStr3 = "4173698256321589479587243168254371697915864323469127582896435715732916841648752931";
		//too short
		String testStr4 = "41736982563215894795872431682543716979158643234691275828964357157329168416487529";
		//contains a character
		String testStr5 = "41736982563215894795872431682543716979158643234691275828964357157329168416487529a";
		
		assertTrue(suVe.checkInput(testStr1));
		assertFalse(suVe.checkInput(testStr2));
		assertFalse(suVe.checkInput(testStr3));
		assertFalse(suVe.checkInput(testStr4));
		assertFalse(suVe.checkInput(testStr5));
	}
	
	@Test
	public void testGetRows() {
		SudokuVerifier suVe = new SudokuVerifier();
		
		String testStr1 = "111111111222222222333333333444444444555555555666666666777777777888888888999999999";
	
		assertEquals(Arrays.toString(suVe.getRows(testStr1)), "[111111111, 222222222, 333333333, 444444444, 555555555, 666666666, "
																+ "777777777, 888888888, 999999999]");
	}
	
	@Test
	public void testGetCols() {
		SudokuVerifier suVe = new SudokuVerifier();
		String testStr1 = "111111111222222222333333333444444444555555555666666666777777777888888888999999999";
		
		assertEquals(Arrays.toString(suVe.getCols(testStr1)), "[123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789]");
	}
	
	@Test
	public void testCheckRuleOne() {
		SudokuVerifier suVe = new SudokuVerifier();
		
		String testStr1 = "417-369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertFalse(suVe.checkRuleOne(testStr1));
		//too short
		String testStr2 = "417369825632158947958724316825437169791586432346912758289643571573291684";
		assertTrue(suVe.checkRuleOne(testStr2));
		//too long
		String testStr3 = "4173698256321589479587243168254371697915864323469127582896435715732916841648752931111";
		assertTrue(suVe.checkRuleOne(testStr3));
		//contains a character
		String testStr4 = "a17369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertTrue(suVe.checkRuleOne(testStr4));
	}
	
	@Test
	public void testCheckRuleTwo() {
		SudokuVerifier suVe = new SudokuVerifier();
		
		String testStr1 = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertTrue(suVe.checkRuleTwo(testStr1));
		
		String testStr2 = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		assertFalse(suVe.checkRuleTwo(testStr2));
		
	}
	
	@Test
	public void testCheckRuleThree() {
		SudokuVerifier suVe = new SudokuVerifier();
		
		String testStr1 = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertTrue(suVe.checkRuleThree(testStr1));
		
		String testStr2 = "123456789123456789123456789123456789123456789123456789123456789123456789123456789";
		assertTrue(suVe.checkRuleThree(testStr2));
		//last row has 2 ones
		String testStr3 = "123456789123456789123456789123456789123456789123456789123456789123456789123456781";
		assertFalse(suVe.checkRuleThree(testStr3));
	}
	
	@Test
	public void testCheckRuleFour() {
		SudokuVerifier suVe = new SudokuVerifier();
		
		String testStr1 = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertTrue(suVe.checkRuleFour(testStr1));
		
		String testStr2 = "123456789123456789123456789123456789123456789123456789123456789123456789123456789";
		assertFalse(suVe.checkRuleFour(testStr2));
		
		String testStr3 = "111111111222222222333333333444444444555555555666666666777777777888888888999999999";
		assertTrue(suVe.checkRuleFour(testStr3));
	}
	
	@Test
	public void testVerify() {
		SudokuVerifier suVe = new SudokuVerifier();
		
		String testStr0 = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		assertEquals(suVe.verify(testStr0), 0);
		
		String testStr1 = "417-36982563215894795872431682543716979158643234691275828964357157329168416487529";
		assertEquals(suVe.verify(testStr1), -1);
		
		String testStr2 = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		assertEquals(suVe.verify(testStr2), -2);
		
		/*Can't come up with a string that would break only rule 3 but not rule 2*/
		
		String testStr4 = "123456789456789123789123456123456789456789123789123456123456789456789123789123456";
		assertEquals(suVe.verify(testStr4), -4);
	}
}
