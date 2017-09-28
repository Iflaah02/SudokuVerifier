import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	public String sudoku_valid = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";	
	
	@Test
	public void test_verify_set_valid() {
		SudokuVerifier sv = new SudokuVerifier();
		assertEquals(
			"Verification wasn't true",
			sv.verify_set("987654321"),
			0
		);
	}
	
	@Test
	public void test_verify_set_invalidchar() {
		SudokuVerifier sv = new SudokuVerifier();
		assertEquals(
			"Verification wasn't false",
			sv.verify_set("907654321"),
			-1
		);
	}
	
	@Test
	public void test_verify_set_notin() {
		SudokuVerifier sv = new SudokuVerifier();
		assertEquals(
			"Verification wasn't false",
			sv.verify_set("997654321"),
			-2
		);
	}
	
	@Test
	public void test_verify_grid_valid() {
		SudokuVerifier sv = new SudokuVerifier();
		assertEquals(
			"Verification wasn't 0",
			sv.verify_grid(this.sudoku_valid, 5),
			0
		);
	}
	
	@Test
	public void test_verify_grid_invalid() {
		SudokuVerifier sv = new SudokuVerifier();
		assertEquals(
			"Verification wasn't -2",
			sv.verify_grid(
				"123456789912345678891234567789123456678912345567891234456789123345678912234567891",
				5
			),
			-2
		);
	}
	
	@Test
	public void test_verify_row_valid() {
		SudokuVerifier sv = new SudokuVerifier();
		assertEquals(
			"Verification wasn't 0",
			sv.verify_row(this.sudoku_valid, 5),
			0
		);
	}
	
	@Test
	public void test_verify_row_invalid() {
		SudokuVerifier sv = new SudokuVerifier();
		assertEquals(
			"Verification wasn't -3",
			sv.verify_row(
				"123456789912345678881234567789123456678912345567891234456789123345678912234567891",
				2
			),
			-3
		);
	}
	
	@Test
	public void test_verify_column_valid() {
		SudokuVerifier sv = new SudokuVerifier();
		assertEquals(
			"Verification wasn't 0",
			sv.verify_column(this.sudoku_valid, 5),
			0
		);
	}
	
	@Test
	public void test_verify_column_invalid() {
		SudokuVerifier sv = new SudokuVerifier();
		assertEquals(
			"Verification wasn't -4",
			sv.verify_column(
				"223456789912345678881234567789123456678912345567891234456789123345678912234567891",
				0
			),
			-4
		);
	}
	
	@Test
	public void test_verify_valid() {
		SudokuVerifier sv = new SudokuVerifier();
		assertEquals(
			"Verification wasn't 0",
			sv.verify(this.sudoku_valid),
			0
		);
	}
	
	@Test
	public void test_verify_invalid() {
		SudokuVerifier sv = new SudokuVerifier();
		assertEquals(
			"Verification wasn't -2",
			sv.verify("123456789912345678891234567789123456678912345567891234456789123345678912234567891"),
			-2
		);
	}
	
	@Test
	public void test_verify_invalidchar() {
		SudokuVerifier sv = new SudokuVerifier();
		assertEquals(
			"Verification wasn't -1",
			sv.verify("-23456789912345678891234567789123456678912345567891234456789123345678912234567891"),
			-1
		);
	}
}
