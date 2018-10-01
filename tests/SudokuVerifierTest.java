import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

  // A correct Sudoku string:
  // 417369825632158947958724316825437169791586432346912758289643571573291684164875293
  // An incorrect Sudoku string:
  // 123456789912345678891234567789123456678912345567891234456789123345678912234567891

  @Test
  public void isStringValid_ReturnsTrueIfLength81() {
    SudokuVerifier verifier = new SudokuVerifier();
    boolean result = verifier.isStringValid("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
    assertTrue(result);
  }

  @Test
  public void isStringValid_ReturnsFalseIfLengthNot81() {
    SudokuVerifier verifier = new SudokuVerifier();
    boolean result = verifier.isStringValid("417369825632158947958724316");
    assertFalse(result);
  }

  @Test
  public void isStringValid_ReturnsFalseIfContainsBadNumbers() {
    SudokuVerifier verifier = new SudokuVerifier();
    boolean result = verifier.isStringValid("417369825632108947958724316825437169791586432346912758289643571573291684164875293");
    assertFalse(result);
  }

  @Test
  public void isStringValid_ReturnsFalseIfContainsBadChars() {
    SudokuVerifier verifier = new SudokuVerifier();
    boolean result = verifier.isStringValid("41736982563210894795872431682543716979158643234691275828A643571573291684164875293");
    assertFalse(result);
  }

  @Test
  public void parseInput_ReturnsCorrectResult() {
    int[][] expected = {
      { 4, 1, 7, 3, 6, 9, 8, 2, 5 },
      { 6, 3, 2, 1, 5, 8, 9, 4, 7 },
      { 9, 5, 8, 7, 2, 4, 3, 1, 6 },
      { 8, 2, 5, 4, 3, 7, 1, 6, 9 },
      { 7, 9, 1, 5, 8, 6, 4, 3, 2 },
      { 3, 4, 6, 9, 1, 2, 7, 5, 8 },
      { 2, 8, 9, 6, 4, 3, 5, 7, 1 },
      { 5, 7, 3, 2, 9, 1, 6, 8, 4 },
      { 1, 6, 4, 8, 7, 5, 2, 9, 3 }
    };
    SudokuVerifier verifier = new SudokuVerifier();
    int[][] actual = verifier.parseInput("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
    for (int i = 0; i < expected.length; i++) {
      assertArrayEquals(expected[i], actual[i]);
    }
  }

  @Test
  public void isSectionValid_ReturnsTrueForValidSection() {
    int[] valid = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    SudokuVerifier verifier = new SudokuVerifier();
    boolean result = verifier.isSectionValid(valid);
    assertTrue(result);
  }

  @Test
  public void isSectionValid_ReturnsFalseForInvalidSection() {
    int[] invalid = { 1, 2, 3, 3, 5, 6, 7, 8, 9 };
    SudokuVerifier verifier = new SudokuVerifier();
    boolean result = verifier.isSectionValid(invalid);
    assertFalse(result);
  }

  @Test
  public void verify_Returns0ForValidString() {
    SudokuVerifier verifier = new SudokuVerifier();
    int result = verifier.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
    assertEquals(0, result);
  }
  @Test
  public void verify_ReturnsMinus1ForInvalidInput() {
    SudokuVerifier verifier = new SudokuVerifier();
    int result = verifier.verify("417369825632158944");
    assertEquals(-1, result);
  }
  @Test
  public void verify_ReturnsMinus2ForInvalidSubGrid() {
    SudokuVerifier verifier = new SudokuVerifier();
    int result = verifier.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875291");
    assertEquals(-2, result);
  }
  @Test
  public void verify_ReturnsMinus3ForInvalidRow() {
    SudokuVerifier verifier = new SudokuVerifier();
    int result = verifier.verify("417169825632358947958724316825437169791586432346912758289643571573291684164875293");
    assertEquals(-3, result);
  }
  @Test
  public void verify_ReturnsMinus4ForInvalidColumn() {
    SudokuVerifier verifier = new SudokuVerifier();
    int result = verifier.verify("417369825632185947958724316825437169791568432346912758289643571573291684164875293");
    assertEquals(-4, result);
  }
}
