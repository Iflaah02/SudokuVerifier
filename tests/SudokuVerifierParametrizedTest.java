import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SudokuVerifierParametrizedTest {

	private String inputString;
	private int errorCode;
	
	
	public SudokuVerifierParametrizedTest(String inputString, int errorCode) {
	      this.inputString = inputString;
	      this.errorCode = errorCode;
	   }
	
	@Parameters
	public static Collection <Object[]> sudokuStrings() {
		return Arrays.asList(new Object[][] {
         { "417369825632158947958724316825437169791586432346912758289643571573291684164875293", 0 },
         { "41736982563215894795872431682543716979158643234691275828964357157329168416487529", -1 },
         { "41736982563215894795872431682543716979158643234691275828964357157329168416487529F", -1 },
         { "417369825632158947958724316825437169791586432346912758289643571573291684164875291234", -1 },
         { "4173698256321589479587243168254371697915864323469127582896435715732916841648752930", -1 },
         { "0417369825632158947958724316825437169791586432346912758289643571573291684164875293", -1 },
         { "417369825132158947958724316825437169791586432346912758289643571573291684164875293", -2 },
         { "417469825632158947958723316825437169791586432346912758289643571573291684164875293", -3 },
         { "417369825632158947958724316528437169791586432346912758289643571573291684164875293", -4 }
      });
	}

	@Test
	public void testVerify_StringLength() {
		//Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		
		//Act
		
		//Assert
		System.out.println("inputString: " + inputString);
		assertEquals("Correct String returns 0",errorCode, verifier.verify(inputString));

	}
	
	@Test
	public void testVerify_NumberFormat0_9() {
		//Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		
		//Assert
		System.out.println("inputString: " + inputString);
		assertEquals("Only numbers 1-9 should be allowed", errorCode, verifier.verify(inputString));


	}
	
	@Test
	public void testVerify_subGrid0_9() {
		//Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		
		//Assert
		System.out.println("inputString: " + inputString);
		assertEquals("Each subgrid can only contain one of each number", errorCode, verifier.verify(inputString));
		
	}
	
	@Test
	public void testVerify_Rows0_9() {
		//Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		
		//Assert
		System.out.println("inputString: " + inputString);
		assertEquals("Each row can only contain one of each number", errorCode, verifier.verify(inputString));
	}
	
	@Test
	public void testVerify_Columns0_9() {
		//Arrange
		SudokuVerifier verifier = new SudokuVerifier();
		
		//Assert
		System.out.println("inputString: " + inputString);
		assertEquals("Each column can only contain one of each number", errorCode, verifier.verify(inputString));
	}

}
