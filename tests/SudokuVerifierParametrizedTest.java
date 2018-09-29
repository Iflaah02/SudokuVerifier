import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class SudokuVerifierParametrizedTest {
	
	/*Some tests have to be run so that every other test is ignored.
	 */
	
	@Test
	public void test_length() {
		String solution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		SudokuVerifier sudo = new SudokuVerifier();
		int result = sudo.verify(solution);
		assertEquals(0, result);
		solution = "4173698256321589479587243168254371697915864323469127582896435715732916841648752931";
		result = sudo.verify(solution);
		assertEquals(-1, result);
		solution = "41736982563215894795872431682543716979158643234691275828964357157329168416487529";
		result = sudo.verify(solution);
		assertEquals(-1, result);
	}
	
	@Test
	public void test_R1() {
		String solution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		SudokuVerifier sudo  = new SudokuVerifier();
		int result = sudo.verify(solution);
		assertEquals(0, result);
		solution = "017369825632158947958724316825437169791586432346912758289643571503291684164875293";
		result = sudo.verify(solution);
		assertEquals(-1, result);
		solution = "4173698256321589479587243168254371697915864323469127582896-43571573291684164875293";
		result = sudo.verify(solution);
		assertEquals(-1, result);
	}
	
	@Test
	public void test_R2() {
		String solution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		SudokuVerifier sudo = new SudokuVerifier();
		int result = sudo.verify(solution);
		assertEquals(0, result);
		solution = "123456789123456789123456789123456789123456789123456789123456789123456789123456789";
		result = sudo.verify(solution);
		assertEquals(-2, result);
	}
	
	@Test
	public void test_R3() {
		String solution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		SudokuVerifier sudo = new SudokuVerifier();
		int result = sudo.verify(solution);
		assertEquals(0, result);
		solution = "417369825632158947958224316825437169791586432346912758289643571573291684164875293";
		result = sudo.verify(solution);
		assertEquals(-3, result);
		solution = "417369825632158947958224316825437169791586432346912758299643571573291684164875293";
		result = sudo.verify(solution);
		assertEquals(-3, result);
		solution = "417369825632158947958724316825437169791586432346912758289643571573291684164875993";
		result = sudo.verify(solution);
		assertEquals(-3, result);
	}
	
	@Test
	public void test_R4() {
		String solution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		SudokuVerifier sudo = new SudokuVerifier();
		int result = sudo.verify(solution);
		assertEquals(0, result);
		solution = "4173698256321589479587243164";
		result = sudo.verify(solution);
		assertEquals(-4, result);
	}

}
