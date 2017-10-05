import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierParametrizedTest {

	@Test
	public void testInputValidityMethod() {
		SudokuVerifier emptySoduku = new SudokuVerifier();
		assertEquals("Wrong input validity check", -1 , emptySoduku.verify("049723681203418579187956243628579314914382765735164892892631457456297138371845926"));
	}
	
	@Test
	public void testInputValidityMethod2() {
		SudokuVerifier emptySoduku = new SudokuVerifier();
		assertEquals("Wrong input validity check", -1 ,emptySoduku.verify(" "));
	}
	
	@Test
	public void testInputValidityMethod3() {
		SudokuVerifier emptySoduku = new SudokuVerifier();
		assertEquals("Wrong input validity check", -1 ,emptySoduku.verify("Not a numeric input"));
	}
	
	@Test
	public void testCorrectSoduku() {
		SudokuVerifier emptySoduku = new SudokuVerifier();
		assertEquals("Wrong verifier for correctness", 0 , emptySoduku.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293"));
	}
	
	@Test
	public void testCorrectSoduku2() {
		SudokuVerifier emptySoduku = new SudokuVerifier();
		assertEquals("Wrong verifier for correctness", 0 , emptySoduku.verify("549723681263418579187956243628579314914382765735164892892631457456297138371845926"));
	}
	
	@Test
	public void testWrongSoduku_SubGird() {
		SudokuVerifier emptySoduku = new SudokuVerifier();
		assertEquals("Wrong verifier for sub Grid", -2 , emptySoduku.verify("123456789912345678891234567789123456678912345567891234456789123345678912234567891"));
	}
	
	@Test
	public void testWrongSoduku_SubGrid2() {
		SudokuVerifier emptySoduku = new SudokuVerifier();
		assertEquals("Wrong verifier for sub Grid", -2 , emptySoduku.verify("149723681243418579187956243628579314914382765735164892892631457456297138371845926"));
	}
	
	@Test
	public void testWrongSoduku_Column() {
		SudokuVerifier emptySoduku = new SudokuVerifier();
		assertEquals("Wrong verifier for Columns", -4 , emptySoduku.verify("324598167579216384168347295982751643745963821316482579693875412857124936421639758"));
	}
	
	@Test
	public void testWrongSoduku_Row() {
		SudokuVerifier emptySoduku = new SudokuVerifier();
		assertEquals("Wrong verifier for Rows", -3 , emptySoduku.verify("184154739392687652756932418861275391527396824943841567279513286615728943438469175"));
	}
}
