import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {
	
	String correctSudokuString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	String incorrectSudokuString = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
	
	String shouldFailTestOne = "123456789123456789123456789a23456789123456789123456789123456789123456789123456789";
	String shouldFailTestTwo = "417369825612538947958724316825437169791586432346912758289643571573291684164875293";
	String shouldFailTestThree = "417369521632158947958724386825437169791586432346912758289643571573291684164875293";
	String shouldFailTestFour = "417369521632158947958724386825437169791586432346912758289643571573291684164875293";

	@Test
	public void testLength() {
		SudokuVerifier sv = new SudokuVerifier();
		sv.setSolution("81");
		assertFalse(sv.isRightLength());
		sv.setSolution(String.format("%0" + 80 + "d", 1));
		assertFalse(sv.isRightLength());
		sv.setSolution(String.format("%0" + 81 + "d", 1));
		assertTrue(sv.isRightLength());
		sv.setSolution(String.format("%0" + 82 + "d", 1));
		assertFalse(sv.isRightLength());
	}
	
	@Test
	public void testSetDetection() {
		SudokuVerifier sv = new SudokuVerifier();
		int[] setNumbers = {1,2,3,4,5};
		int[] nonSetNumbers = {1,2,3,3,5};
		assertTrue(sv.isASet(setNumbers));
		assertFalse(sv.isASet(nonSetNumbers));
	}
	
	@Test
	public void testRuleOne() {
		SudokuVerifier sv = new SudokuVerifier();
		sv.setSolution(shouldFailTestOne);
		assertFalse(sv.isRuleOneOk());
	}
	
	@Test
	public void testRuleTwo() {
		SudokuVerifier sv = new SudokuVerifier();
		
		sv.setSolution(correctSudokuString);
		sv.stringToRowsAndColumns();
		assertTrue(sv.isRuleTwoOk());
		sv.setSolution(shouldFailTestTwo);
		sv.stringToRowsAndColumns();
		assertFalse(sv.isRuleTwoOk());
	}
	
	@Test
	public void testRuleThree() {
		SudokuVerifier sv = new SudokuVerifier();
		sv.setSolution(correctSudokuString);
		sv.stringToRowsAndColumns();
		assertTrue(sv.isRuleThreeOk());
		sv.setSolution(shouldFailTestThree);
		sv.stringToRowsAndColumns();
		assertFalse(sv.isRuleThreeOk());
	}
	
	@Test
	public void testRuleFour() {
		SudokuVerifier sv = new SudokuVerifier();
		sv.setSolution(correctSudokuString);
		sv.stringToRowsAndColumns();
		assertTrue(sv.isRuleFourOk());
		sv.setSolution(shouldFailTestFour);
		sv.stringToRowsAndColumns();
		assertFalse(sv.isRuleFourOk());
	}
	
	@Test
	public void testVerify() {
		SudokuVerifier sv = new SudokuVerifier();
		assertNotEquals(0, sv.verify(""));
		assertEquals(-1, sv.verify(shouldFailTestOne));
		assertEquals(-2, sv.verify(shouldFailTestTwo));
		assertEquals(-3, sv.verify(shouldFailTestThree));
		assertNotEquals(0, sv.verify(shouldFailTestFour)); // (!R2, !R3) ent. !R4
		assertNotEquals(0, sv.verify(incorrectSudokuString));
		assertEquals(0, sv.verify(correctSudokuString));
	}

}
