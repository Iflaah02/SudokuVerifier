import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SudokuVerifierParametrizedTest {
	
	private String sudokuString;
	private int expectedResult;
	private SudokuVerifier sv;
	
	@Before
	public void init() {
		sv = new SudokuVerifier();
	}
	
	public SudokuVerifierParametrizedTest(String ss, int er) {
		this.sudokuString = ss;
		this.expectedResult = er;
	}
	
	@Parameterized.Parameters(name = "Test #{index}")
	public static Collection<Object[]> sudokuStrings() {
		return Arrays.asList(new Object[][] {
			// Valid string
			{"417369825632158947958724316825437169791586432346912758289643571573291684164875293", 0},
			// Less or more characters
			{"41736982563215894795872431682543716979158643234691275828964357157329168416487529", -1},
			{"4173698256321589479587243168254371697915864323469127582896435715732916841648752931", -1},
			// Failing rule #2 (sub-grid)
			{"123456789912345678891234567789123456678912345567891234456789123345678912234567891", -2},
			// Failing rule #3 (rows)
			{"123123123456456456789789789231231231564564564897897897312312312645645645978978978", -3},
			// Failing rule #4 (columns)
			{"123456789456789123789123456123456789456789123789123456123456789456789123789123456", -4}
		});
	}
	
	@Test
	public void test() {
		assertEquals(expectedResult, sv.verify(sudokuString));
	}

}
