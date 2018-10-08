import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

private SudokuVerifier sv; // Define an object
	
	@Before
	public void init() {
		sv = new SudokuVerifier(); // and create it
	}
	
	
	// Set of test cases below
	@Test
	public void testVerify_Valid() {
		assertEquals(0, sv.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293"));;
	}

	@Test
	// Checking an incorrect string from comments - it violates Rule 2
	public void testVerify_IncorrectFromComment() {
		assertEquals(-2, sv.verify("123456789912345678891234567789123456678912345567891234456789123345678912234567891"));;
	}
	
	@Test
	// Checking Rule 1 - shorter string
	public void testVerify_Shorter() {
		assertEquals(-1, sv.verify("41736982563215894795872431682543716979158643234691275828964357157329168416487529"));;
	}

	@Test
	// Checking Rule 1 - longer string
	public void testVerify_Longer() {
		assertEquals(-1, sv.verify("4173698256321589479587243168254371697915864323469127582896435715732916841648752931"));;
	}
	
	@Test
	// Checking Rule 1 - not all numbers
	public void testVerify_ABC() {
		assertEquals(-1, sv.verify("4173698256321589ABC58724316825437169791586432346912758289643571573291684164875293"));;
	}
	
	@Test
	// Checking Rule 3 - rows
	public void testVerify_Rows() {
		assertEquals(-3, sv.verify("123123123456456456789789789231231231564564564897897897312312312645645645978978978"));;
	}
	
	@Test
	// Checking Rule 4 - columns
	public void testVerify_Columns() {
		assertEquals(-4, sv.verify("123456789456789123789123456123456789456789123789123456123456789456789123789123456"));;
	}
	
}