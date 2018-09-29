import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SudokuVerifierParametrizedTest {
	private String inputString; 
	private int expectedResult; 
	private SudokuVerifier sudokuVerifier; 
	
	@Before 
	public void initialize() {
		sudokuVerifier = new SudokuVerifier(); 
	}
	
	public SudokuVerifierParametrizedTest(String inputString, int expectedResult) {
		this.inputString = inputString; 
		this.expectedResult = expectedResult; 
	}
	
	@Parameterized.Parameters
	public static Collection inputStrings() {
		return Arrays.asList(new Object[][] {
			{"417369825632158947958724316825437169791586432346912758289643571573291684164875293", 0},
			{"41736a825632158947958724316825437169791586432346912758289643571573291684164875293", -1},
			{"517369825632158947958724316825437169791586432346912758289643571573291684164875293", -2},
			{"617369825432158947958724316825437169791586432346912758289643571573291684164875293", -3},
			{"471369825632158947958724316825437169791586432346912758289643571573291684164875293", -4}
		});
	}
	
	@Test
	public void testVerify() {
	      assertEquals(expectedResult, 
	      sudokuVerifier.verify(inputString));
	}
}
