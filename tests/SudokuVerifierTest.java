import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// Given correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 111111122222222223333333334444444445555555555666666666777777777788888888899999999

	
	//Verification with correct Sudoku string
	@Test
	public void verifyIfCorrect() {
		SudokuVerifier verifier = new SudokuVerifier();
		int returnCode = verifier.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(0, returnCode);
	}
	
	//Verification with incorrect Sudoku string
	@Test
	public void verifyIfIncorrect() {
		SudokuVerifier verifier = new SudokuVerifier();
		int returnCode = verifier.verify("111111122222222223333333334444444445555555555666666666777777777788888888899999999");
		assertEquals(-2, returnCode);
	}
	
	//R1: A cell in a Sudoku game can only store positive digits, i.e. 1...9.
	@Test
	public void verify_R1_Incorrect() {
		SudokuVerifier verifier = new SudokuVerifier();
		int returnCode = verifier.verify(""
				+ "417369825"
				+ "632158947"
				+ "958724316"
				+ "825437169"
				+ "79158asd2" //Non numbers added here
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "164875293");
		assertEquals(-1, returnCode); 
	}
	
	//R2: All digits appear only once in a sub-grid, i.e. they cannot repeat.
	@Test
	public void verify_R2_Incorrect() {
		SudokuVerifier verifier = new SudokuVerifier();
		int returnCode = verifier.verify(""
				+ "417369825"
				+ "632158947"
				+ "958724316"
				+ "825437169"
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "573291685" //Rule 2 violates here
				+ "164875293");
		assertEquals(-2, returnCode); 
	}
	
	//R3: A digit can appear only once in the rows of the global grid.
	@Test
	public void verify_R3_Incorrect() {
		SudokuVerifier verifier = new SudokuVerifier();
		int returnCode = verifier.verify(""
				+ "417369825"
				+ "632158917" //Number 1 repeats in this raw
				+ "958724346"
				+ "825437169"
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "164875293");
		assertEquals(-3, returnCode); 
	}
	
	//R4: A digit can appear only once in the columns of the global grid.
	@Test
	public void verify_R4_Incorrect() {
		SudokuVerifier verifier = new SudokuVerifier();
		int returnCode = verifier.verify(""
				+ "417369825"
				+ "632158947"
				+ "958724316"
				+ "825437169"
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "537291684" //Number 3 repeats in 2nd column
				+ "164875293");
		assertEquals(-4, returnCode);
	}
}
