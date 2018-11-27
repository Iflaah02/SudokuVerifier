import static org.junit.Assert.*;

import org.junit.Test;

public class ArgumentPasserTest {

	@Test
	public void testGetSudokuString() {
		String str = "a string";
		ArgumentPasser args = new ArgumentPasser(str);
		
		assertEquals(str, args.getSudokuString());
	}
	
	@Test
	public void testGetdata() {
		String str = "a string";
		ArgumentPasser args = new ArgumentPasser(str);
		
		assertArrayEquals(new char[9], args.getdata());
	}
	
	@Test
	public void testGetsortedNumbers() {
		String str = "a string";
		char[] sortedNumbers = new char[] {'1','2','3','4','5','6','7','8','9'};
		ArgumentPasser args = new ArgumentPasser(str);
		
		assertArrayEquals(sortedNumbers, args.getsortedNumbers());
	}

}
