import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierParametrizedTest {

    @Test
    public void verifySolutionString_valid_returns_true() {
        // Arrange
        SudokuVerifier sv = new SudokuVerifier();
        // Act
        boolean result = sv.verifySolutionString("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
        // Act
        assertTrue(result);
    }

    @Test
    public void verifySolutionString_short_returns_false() {
        // Arrange
        SudokuVerifier sv = new SudokuVerifier();
        // Act
        boolean result = sv.verifySolutionString("4173698256321589479587243168254371697915864323469127582896435715732916841675293");
        // Act
        assertFalse(result);
    }

    @Test
    public void verifySolutionString_long_returns_false() {
        // Arrange
        SudokuVerifier sv = new SudokuVerifier();
        // Act
        boolean result = sv.verifySolutionString("4173698256321589479587243168254371697915864323469127582812396435715732916841675293");
        // Act
        assertFalse(result);
    }

    @Test
    public void verifySolutionString_invalid_character_returns_false() {
        // Arrange
        SudokuVerifier sv = new SudokuVerifier();
        // Act
        boolean result = sv.verifySolutionString("41736982563215894795872a3168254371697915864323469127582812396435715732916841675293");
        // Act
        assertFalse(result);
    }

    @Test
    public void verifySubstring_valid_returns_true() {
        // Arrange
        SudokuVerifier sv = new SudokuVerifier();
        // Act
        boolean result = sv.verifySubstring("123456789");
        // Act
        assertTrue(result);
    }

    @Test
    public void verifySubstring_invalid_returns_false() {
        // Arrange
        SudokuVerifier sv = new SudokuVerifier();
        // Act
        boolean result = sv.verifySubstring("123156789");
        // Act
        assertFalse(result);
    }

    @Test
    public void getLine_line_1_returns_line1() {
        // Arrange
        SudokuVerifier sv = new SudokuVerifier();
        // Act
        String result = sv.getLine(1,"417369825632158947958724316825437169791586432346912758289643571573291684164875293");
        // Act
        assertEquals("417369825", result);
    }
    @Test
    public void getLine_line_9_returns_line9() {
        // Arrange
        SudokuVerifier sv = new SudokuVerifier();
        // Act
        String result = sv.getLine(9,"417369825632158947958724316825437169791586432346912758289643571573291684164875293");
        // Act
        assertEquals("164875293", result);
    }

    @Test
    public void getColumn_column_1_returns_column1() {
        // Arrange
        SudokuVerifier sv = new SudokuVerifier();
        // Act
        String result = sv.getColumn(1,"417369825632158947958724316825437169791586432346912758289643571573291684164875293");
        // Act
        assertEquals("469873251", result);
    }
    @Test
    public void getColumn_column_9_returns_column9() {
        // Arrange
        SudokuVerifier sv = new SudokuVerifier();
        // Act
        String result = sv.getColumn(9,"417369825632158947958724316825437169791586432346912758289643571573291684164875293");
        // Act
        assertEquals("576928143", result);
    }

    @Test
    public void getGrid_subgrid_1_rerurns_subgrid1() {
        // Arrange
        SudokuVerifier sv = new SudokuVerifier();
        // Act
        String result = sv.getSubgrid(1,"417369825632158947958724316825437169791586432346912758289643571573291684164875293");
        // Act
        assertEquals("417632958", result);
    }

    @Test
    public void getGrid_subgrid_5_rerurns_subgrid5() {
        // Arrange
        SudokuVerifier sv = new SudokuVerifier();
        // Act
        String result = sv.getSubgrid(5,"417369825632158947958724316825437169791586432346912758289643571573291684164875293");
        // Act
        assertEquals("437586912", result);
    }

    @Test
    public void getGrid_subgrid_9_rerurns_subgrid9() {
        // Arrange
        SudokuVerifier sv = new SudokuVerifier();
        // Act
        String result = sv.getSubgrid(9,"417369825632158947958724316825437169791586432346912758289643571573291684164875293");
        // Act
        assertEquals("571684293", result);
    }
}
