import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

//I seem to have made the sudoku verifier in a manner that incorporates the tests as part of its
//verify() function. Seemed like the obvious approach, since I had to be the one coding it.
//Then again, it is already 2 in the morning on Monday, so this might not even get graded
//any longer.
	
//To be honest, this seems like a bit of a backwards approach to me: To code a software and somehow
//while it is still not working, incorporate test cases for it. The first order of business
//and thus, the first 'slice' would be to get it working. I mean, testing something that fails to
//run is a bit strange thing to do as there isn't anything there to test, right? 
	
//The coder knows it is not working, and the tester knows it is not working yet. :/
	
	@Test
	public void testVerifyStr1() 
	{
	String teststring1 = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	if(teststring1.length() != 81)
	fail("Length of string illegal. Expected: 81, received: "+teststring1.length()+".");
	}

	@Test
	public void testVerifyStr2() 
	{
	String teststring2 = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
	if(teststring2.length() != 81)
	fail("Length of string illegal. Expected: 81, received: "+teststring2.length()+".");
	}

	@Test
	public void testNegativity() 
	{
	String teststring1 = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	if(teststring1.contains("-"))
	fail("Illegal string, contained '-'.");
	}
	
	@Test
	public void testR1R3() 
	{
	String teststring1 = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";

	List<String> parts = new ArrayList<String>();
	int index = 0;
	int counter = 0;
	int temp = 0;
	while (index < teststring1.length()) 
	 {
	    parts.add(teststring1.substring(index, Math.min(index + 9,teststring1.length())));
	    index += 9;
	 }		
	
	//master for-loop, goes through each of the 9-char substring in order
	//coincidentally, also checks for rule 3: x-axis, which means that this test case
	//is bad practice by checking more than one thing at a time, but can't really help it when
	//it gets solved alongside another verification.
	for(int i = 0; i < 9; i++)
	 {	 
	 char a = '1';
	 
	 //does substrings contain 1-9
	 temp = 0;
	 for(int k = 1; k <= 9; k++)
	  {	 	 
	  counter = 0;	 
	  if(parts.get(i).contains(""+k+""))
	   {		  	 
	  temp++;
	  //count how many instances of 'k' in substring
		for(int j=0; j < 9; j++ ) 
	    {			 	
		if( parts.get(i).charAt(j) == a ) 
		 {
		        counter++;
		 }
	    }
	    if(counter > 1) fail("Substring has multiples of the same number.");
	    if(counter == 0) fail("Substring had none of one number");

	   }
	  a++;
	  }
	 if(temp < 9) fail("Didn't find all 1..9 numbers.");
	 }
    }

	@Test
	public void testR2() 
	{
	String teststring1 = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	
	//start of rule 2		
			//to get the sub-grids, need to check three consecutive chars per substring, starting from
			//indices 0, 3, and 6 and count that the same number is there only once.
			
			int counter = 0;
			int temp = 0;
		    String subgrid1 = "";
	        String subgrid2 = "";
	        String subgrid3 = "";
		    
		    //form 9 3x3 subgrids from the given string, evaluates them for missing/duplicate numbers
		     for(int j = 0; j < 81; j += 9)
		     {
	// 012345678911111111112222222222333333333344444444445555555555666666666677777777778
//		    	 01234567890123456789012345678901234567890123456789012345678901234567890
		    	 
	//"417369825632158947958724316825437169791586432346912758289643571573291684164875293";	    	 
		     //should be: 417      632      958,

	boolean spam = false;//change to true to see the formulated appearance
	subgrid1 += teststring1.charAt(j); if(spam) System.out.print(teststring1.charAt(j)); 
	subgrid1 += teststring1.charAt(j+1); if(spam) System.out.print(teststring1.charAt(j+1));
	subgrid1 += teststring1.charAt(j+2); if(spam) System.out.print(teststring1.charAt(j+2));

	if(spam) System.out.print("|");

	subgrid2 += teststring1.charAt(j+3); if(spam) System.out.print(teststring1.charAt(j+3)); 
	subgrid2 += teststring1.charAt(j+4); if(spam) System.out.print(teststring1.charAt(j+4));
	subgrid2 += teststring1.charAt(j+5); if(spam) System.out.print(teststring1.charAt(j+5));

	if(spam) System.out.print("|");

	subgrid3 += teststring1.charAt(j+6); if(spam) System.out.print(teststring1.charAt(j+6)); 
	subgrid3 += teststring1.charAt(j+7); if(spam) System.out.print(teststring1.charAt(j+7));
	subgrid3 += teststring1.charAt(j+8); if(spam) System.out.print(teststring1.charAt(j+8));

	if(spam && (j != 18 || j != 45))
	System.out.print("\n");	
	if(spam && (j == 18 || j == 45))
	System.out.print("---+---+---\n");

		     }
			 //check that each number is only one time in the subgrid
		     
		     List<String> subgridtemp1 = new ArrayList<String>();
		     List<String> subgridtemp2 = new ArrayList<String>();
		     List<String> subgridtemp3 = new ArrayList<String>();
		     int subindex = 0;
		     while (subindex < subgrid1.length()) 
		     {
		         subgridtemp1.add(subgrid1.substring(subindex, Math.min(subindex + 9,subgrid1.length())));
		         subindex += 9;
		     }
		     
		     subindex = 0;
		     while (subindex < subgrid2.length()) 
		     {
		         subgridtemp2.add(subgrid2.substring(subindex, Math.min(subindex + 9,subgrid2.length())));
		         subindex += 9;
		     }
		     
		     subindex = 0;
		     while (subindex < subgrid3.length()) 
		     {
		         subgridtemp3.add(subgrid3.substring(subindex, Math.min(subindex + 9,subgrid3.length())));
		         subindex += 9;
		     }
		     
		     //System.out.println("\nDebug: subgridtemp1:"+subgridtemp1+"\n");
		     //System.out.println("\nDebug: subgridtemp2:"+subgridtemp2+"\n");
		     //System.out.println("\nDebug: subgridtemp3:"+subgridtemp3+"\n");
		     
		     for(int i = 0; i < 3; i++)
		     {
			 counter = 0;
			 if(subgridtemp1.get(i).contains("1")) counter++;
			 if(subgridtemp1.get(i).contains("2")) counter++;
			 if(subgridtemp1.get(i).contains("3")) counter++;
			 if(subgridtemp1.get(i).contains("4")) counter++;
			 if(subgridtemp1.get(i).contains("5")) counter++;
			 if(subgridtemp1.get(i).contains("6")) counter++;
			 if(subgridtemp1.get(i).contains("7")) counter++;
			 if(subgridtemp1.get(i).contains("8")) counter++;
			 if(subgridtemp1.get(i).contains("9")) counter++;
			 //System.out.println("\nDebug: subgridtemp1 counter:"+counter+"\n"); 
			 if(counter != 9) fail("Breaks rule 2, 3x3 grid has duplicates");//breaks rule 2, subgrid had a duplicate
			 
			 //check that each number is only one time in the subgrid
			 counter = 0;
			 if(subgridtemp2.get(i).contains("1")) counter++;
			 if(subgridtemp2.get(i).contains("2")) counter++;
			 if(subgridtemp2.get(i).contains("3")) counter++;
			 if(subgridtemp2.get(i).contains("4")) counter++;
			 if(subgridtemp2.get(i).contains("5")) counter++;
			 if(subgridtemp2.get(i).contains("6")) counter++;
			 if(subgridtemp2.get(i).contains("7")) counter++;
			 if(subgridtemp2.get(i).contains("8")) counter++;
			 if(subgridtemp2.get(i).contains("9")) counter++;
			 //System.out.println("Debug: subgridtemp2 counter:"+counter+"\n"); 
			 if(counter != 9) fail("Breaks rule 2, 3x3 grid has duplicates");//breaks rule 2, subgrid had a duplicate

			 //check that each number is only one time in the subgrid
			 counter = 0;
			 if(subgridtemp3.get(i).contains("1")) counter++;
			 if(subgridtemp3.get(i).contains("2")) counter++;
			 if(subgridtemp3.get(i).contains("3")) counter++;
			 if(subgridtemp3.get(i).contains("4")) counter++;
			 if(subgridtemp3.get(i).contains("5")) counter++;
			 if(subgridtemp3.get(i).contains("6")) counter++;
			 if(subgridtemp3.get(i).contains("7")) counter++;
			 if(subgridtemp3.get(i).contains("8")) counter++;
			 if(subgridtemp3.get(i).contains("9")) counter++;
			 //System.out.println("Debug: subgridtemp3 counter:"+counter+"\n"); 
			 if(counter != 9) fail("Breaks rule 2, 3x3 grid has duplicates");//breaks rule 2, subgrid had a duplicate
		     }
		     
			 //we know this because for each number it finds, counter increases by 1.
	         //if it does not find something, counter does not increase
			 //if it finds something multiple times, counter increases only once
			 //thus, counter != 9, if duplicates or missing, counter remains < 9.
			 
	//end of rule 2	
	}
	
	@Test
	public void testR4() 
	{
	String teststring1 = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
    
	//to get the y-axis, need to check 0,3,6 1,4,7 and 2,5,8 chars in the substrings,
	//then count matches from all 9 substrings to make sure that each number is only once there

     String yaxis = "";
		     
     //let's get the nine y-axis columns
     for(int j = 0; j < 9; j++)
     {
	 yaxis += teststring1.charAt(j);
	 yaxis += teststring1.charAt(j+9);
	 yaxis += teststring1.charAt(j+18);
	 yaxis += teststring1.charAt(j+27);
	 yaxis += teststring1.charAt(j+36);
	 yaxis += teststring1.charAt(j+45);
	 yaxis += teststring1.charAt(j+54);
	 yaxis += teststring1.charAt(j+63);
	 yaxis += teststring1.charAt(j+72);//8+72=80 is final index
			 
	 int counter = 0;
	 if(yaxis.contains("1")) counter++;
	 if(yaxis.contains("2")) counter++;
	 if(yaxis.contains("3")) counter++;
	 if(yaxis.contains("4")) counter++;
	 if(yaxis.contains("5")) counter++;
	 if(yaxis.contains("6")) counter++;
	 if(yaxis.contains("7")) counter++;
	 if(yaxis.contains("8")) counter++;
	 if(yaxis.contains("9")) counter++;
	 if(counter != 9) fail("Broke rule 4, y-axis had duplicates and/(or) missing numbers.");		 
		     }
			 
		}
	
}
