import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SudokuVerifierParametrizedTest {
	SudokuVerifier verifier;
	private String candidateSolution;
	private int expected;

	public SudokuVerifierParametrizedTest(String candidateSolution, int expected) {
		this.candidateSolution = candidateSolution;
		this.expected = expected;
	}

	@Parameterized.Parameters
	public static Object[][] primeNumbers() {
		return new Object[][] {
				{ "417369825632158947958724316825437169791586432346912758289643571573291684164875293", 0 },
				{ "123456789912345678891234567789123456678912345567891234456789123345678912234567891", -2},
				{ "417367825632158947958924316825437169791586432346912758289643571573291684164875293", -3},
				{ "-17367825632158947958924316825437169791586432346912758289643571573291684164875293", -1},
				{ "4173678256321589479589243168254371697915864323469127", -5},
				{ "714369825632158947958724316825437169791586432346912758289643571573291684164875293", -4}
		};
	}

	@Before
	public void init() {
		verifier = new SudokuVerifier();
	}
	
	@Test
	public void test() {
		assertThat(verifier.verify(candidateSolution), is(expected));
	}

}
