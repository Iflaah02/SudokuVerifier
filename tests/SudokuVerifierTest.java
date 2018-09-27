import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuVerifierTest{

	@Test
	public void testVerifyCorrectString() {

	    assertEquals(0, SudokuVerifier.verify(
                // A correct Sudoku string:
	            "417369825632158947958724316825437169791586432346912758289643571573291684164875293"));
	}

    @Test
    public void testVerifyInvalidString() {

        assertNotEquals(0, SudokuVerifier.verify(
                // An incorrect Sudoku string:
                "123456789912345678891234567789123456678912345567891234456789123345678912234567891"));
    }


    @Test
    public void testVerifyInvalidCharactersAreDetected() {

        assertEquals(-1, SudokuVerifier.verify(
                "a17369825632158947958724316825437169791586432346912758289643571573291684164875293"));
    }

    @Test
    public void testVerifyInvalidLengthThrows() {

        assertThrows(InvalidParameterException.class,
                () -> {
                    SudokuVerifier.verify(
                            "1117369825632158947958724316825437169791586432346912758289643571573291684164875293");
                });
    }


    @Test
    public void testVerifyRule3IsCorrectlyDetecting() {

        assertEquals(false, SudokuVerifier.verifyMatchesRule3(
                "417366825632158947958724316825437169791586432346912758289643571573291684164875293"));
    }

    @Test
    public void testVerifyRule4IsCorrectlyDetecting() {

        assertEquals(false, SudokuVerifier.verifyMatchesRule3(
                "417369825432158947958724316825437169791586432346912758289643571573291684164875293"));
    }

    @Test
    public void testVerifyRule2IsCorrectlyDetectingSuccess() {

        assertEquals(true, SudokuVerifier.verifyMatchesRule2(
                "417369825632158947958724316825437169791586432346912758289643571573291684164875293"));
    }

    @Test
    public void testVerifyRule2IsCorrectlyDetectingFail() {

        assertEquals(false, SudokuVerifier.verifyMatchesRule2(
                "123456789912345678891234567789123456678912345567891234456789123345678912234567891"));
    }

    @Test
    public void testVerifyRule2IsCorrectlyDetectingFailWithSecondInput() {

        assertEquals(false, SudokuVerifier.verifyMatchesRule2(
                "417369825642158947958724316825437169791586432346912758289643571573291684164875293"));
    }
}
