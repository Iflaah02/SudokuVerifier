import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Before;

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
	public static Collection SudokuSolutions() {
		return Arrays.asList(new Object[][] {
				{ "417369825632158947958724316825437169791586432346912758289643571573291684164875293", 0 },
				{ "123456789912345678891234567789123456678912345567891234456789123345678912234567891", -2 },
				{ "417369825432158947958724316825437169791586432346912758289643571573291684164875293", -2 } });
	}

	@Test
	public void testSudokuVerifier() {
		System.out.println("Parameterized String is : " + inputString);
		assertEquals(expectedResult, sudokuVerifier.verify(inputString));
	}

}
