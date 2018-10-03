import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierParametrizedTest {
	
	@Test
	public void testCheckRule1_AllCharsAreNumerical_pass() {
		SudokuVerifier verif = new SudokuVerifier();
		String sudokuString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		assertTrue(verif.checkRule1_AllCharsAreNumerical(sudokuString));
	}
	
	@Test
	public void testCheckRule1_AllCharsAreNumerical_fail() {
		SudokuVerifier verif = new SudokuVerifier();
		String sudokuString = "41736a82563215894795872431682543716979158643234691275828964W571573291684164875293";
		
		assertFalse(verif.checkRule1_AllCharsAreNumerical(sudokuString));
	}
	
	//checkRule2_AllSubgridsAreValid
	@Test
	public void testCheckRule2_AllSubgridsAreValid_pass() {
		SudokuVerifier verif = new SudokuVerifier();
		String sudokuString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		ArgumentPasser args = new ArgumentPasser(sudokuString);
		
		assertTrue(verif.checkRule2_AllSubgridsAreValid(args));
	}
	
	@Test
	public void testCheckRule2_AllSubgridsAreValid_fail() {
		SudokuVerifier verif = new SudokuVerifier();
		String sudokuString = "41736a82563215894795872431682543716979158643234691275828964W571573291684164875293";
		ArgumentPasser args = new ArgumentPasser(sudokuString);
		
		assertFalse(verif.checkRule2_AllSubgridsAreValid(args));
	}
	
	
	
	
	@Test
	public void testCheckRule3_AllrowsAreValid_pass() {
		SudokuVerifier verif = new SudokuVerifier();
		String sudokuString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		ArgumentPasser args = new ArgumentPasser(sudokuString);
		
		assertTrue(verif.checkRule3_AllrowsAreValid(args));
	}
	
	@Test
	public void testCheckRule3_AllrowsAreValid_fail() {
		SudokuVerifier verif = new SudokuVerifier();
		String sudokuString = "417369825632258947958724316825437169791586432346912758289643571573291684164875293";
		ArgumentPasser args = new ArgumentPasser(sudokuString);
		//                                 * changed from 1 to 2
		assertFalse(verif.checkRule3_AllrowsAreValid(args));
		}
	
	@Test
	public void testCheckRule4_AllcolumnsAreValid_fail() {
		SudokuVerifier verif = new SudokuVerifier();
		String sudokuString = "417369825432158947958724316825437169791586432346912758289643571573291684164875293";
		//                              * changed from 6 to 4
		ArgumentPasser args = new ArgumentPasser(sudokuString);
		
		assertFalse(verif.checkRule4_AllcolumnsAreValid(args));
		}
	
	@Test
	public void testCheckRule4_AllcolumnsAreValid_pass() {
		SudokuVerifier verif = new SudokuVerifier();
		String sudokuString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		ArgumentPasser args = new ArgumentPasser(sudokuString);
		
		assertTrue(verif.checkRule4_AllcolumnsAreValid(args));
		}
	
	@Test 
	public void testCandidateSolutionIs81CharsLong_fail() {
		SudokuVerifier verif = new SudokuVerifier();
		String incorrect = "4173698256321589479587243168237169791586432346912758289643571573291684164875293"; //79 characters long
		
		assertFalse( verif.candidateSolutionIs81CharsLong(incorrect) );
	}
	
	@Test
	public void testCandidateSolutionIs81CharsLong_success() {
		SudokuVerifier verif = new SudokuVerifier();
		String correct = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		assertTrue( verif.candidateSolutionIs81CharsLong(correct) );
	}
}
