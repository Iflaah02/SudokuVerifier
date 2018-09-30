import java.util.ArrayList;
import java.util.List;

public class SudokuVerifier 
{
	
	public static void main(String[] args)
	{
	int result = 1;//       417      632      958
	String correctSudoku = "4173698256321589479587243168254371697915864323469127582896435715732916841" + 
			"64875293";
	String wrongSudoku = "1234567899123456788912345677891234566789123455678912344567891233456789122" + 
			"34567891";

	result = verify(correctSudoku);
	
	switch(result)
	 {
	 case -5:
		System.out.println("Verify returned -5, not exactly 81 chars long.\n");
	 break;
	 case -4:
		System.out.println("Verify returned -4, duplicates/missing on y-axis.\n");
     break;
	 case -3:
		System.out.println("Verify returned -3, duplicates/missing on x-axis.\n");
     break;
	 case -2:
		System.out.println("Verify returned -2, duplicates/missing on 3x3s.\n");
	 break;
	 case -1:
		System.out.println("Verify returned -1, had negative numbers.\n");
	 break;
	 case 0:
		System.out.println("Verify returned 0, no errors detected.\n");
	 break;
	 default:
		System.out.println("Mysterious error.\n");
	 break;
	 }
	
	result = verify(wrongSudoku);
	
	switch(result)
	 {
	 case -5:
		System.out.println("Verify returned -5, not exactly 81 chars long.\n");
	 break;
	 case -4:
		System.out.println("Verify returned -4, duplicates/missing on y-axis.\n");
     break;
	 case -3:
		System.out.println("Verify returned -3, duplicates/missing on x-axis.\n");
     break;
	 case -2:
		System.out.println("Verify returned -2, duplicates/missing on 3x3s.\n");
	 break;
	 case -1:
		System.out.println("Verify returned -1, had negative numbers.\n");
	 break;
	 case 0:
		System.out.println("Verify returned 0, no errors detected.\n");
	 break;
	 default:
		System.out.println("Mysterious error.\n");
	 break;
	 }
	
	}
	
	public static int verify(String candidateSolution) 
	{
		if(candidateSolution.length() != 81)
		return -5;//naturally, the instructions did not specify what errorcase this should be
		
		//should create an ArrayList with substrings 9 chars long each
		List<String> parts = new ArrayList<String>();
		int index = 0;
		int counter = 0;
		int temp = 0;
		while (index < candidateSolution.length()) 
		{
		    parts.add(candidateSolution.substring(index, Math.min(index + 9,candidateSolution.length())));
		    index += 9;
		    //System.out.println("Debug: Indexing, index:"+index+" of 81.\n");
		}		
		
		//System.out.println("Debug: past indexing.\n");
		
		//master for-loop, goes through each of the 9-char substring in order
		//coincidentally, also checks for rule 3: x-axis
		for(int i = 0; i < 9; i++)
		{

		 if(parts.get(i).contains("-"))
		 return -1;
			
		 //System.out.println("Debug: past negativity.\n");
		 
		 char a = '1';
		 
		 //does substrings contain 1-9
		 temp = 0;
		 for(int k = 1; k <= 9; k++)
		 {	 	 
		  counter = 0;	 
		  if(parts.get(i).contains(""+k+""))
		  {		  	 
		  temp++;
		  //System.out.println("Debug: contains k: "+k+", a is "+a+".\n");
		  //count how many instances of 'k' in substring
			for(int j=0; j < 9; j++ ) 
			{			 	
				
			    if( parts.get(i).charAt(j) == a ) 
			    {
			        counter++;
			        //System.out.println("Debug: counter: "+counter+".\n");
			    }
			}
		    if(counter > 1) { System.out.println("Debug: c>1\n"); return -1; }//substring has multiples
		    if(counter == 0) { System.out.println("Debug: c=0.\n"); return -1; }//substring had none

		  }
		  //System.out.println("Debug: temp: "+temp+".\n");
		  a++;
		 }
		 if(temp < 9) { System.out.println("Debug: t<9\n"); return -2; }//not all 1..9 were found
		}//end of checking for rule 1 and 3
		
		
//start of rule 2		
		//to get the sub-grids, need to check three consecutive chars per substring, starting from
		//indices 0, 3, and 6 and count that the same number is there only once.
		
		counter = 0;
		temp = 0;
	    String subgrid1 = "";
        String subgrid2 = "";
        String subgrid3 = "";
	    
	    //form 9 3x3 subgrids from the given string, evaluates them for missing/duplicate numbers
	     for(int j = 0; j < 81; j += 9)
	     {
// 012345678911111111112222222222333333333344444444445555555555666666666677777777778
//	    	 01234567890123456789012345678901234567890123456789012345678901234567890
	    	 
//"417369825632158947958724316825437169791586432346912758289643571573291684164875293";	    	 
	     //should be: 417      632      958,

boolean spam = false;//change to true to see the formulated appearance
subgrid1 += candidateSolution.charAt(j); if(spam) System.out.print(candidateSolution.charAt(j)); 
subgrid1 += candidateSolution.charAt(j+1); if(spam) System.out.print(candidateSolution.charAt(j+1));
subgrid1 += candidateSolution.charAt(j+2); if(spam) System.out.print(candidateSolution.charAt(j+2));

if(spam) System.out.print("|");

subgrid2 += candidateSolution.charAt(j+3); if(spam) System.out.print(candidateSolution.charAt(j+3)); 
subgrid2 += candidateSolution.charAt(j+4); if(spam) System.out.print(candidateSolution.charAt(j+4));
subgrid2 += candidateSolution.charAt(j+5); if(spam) System.out.print(candidateSolution.charAt(j+5));

if(spam) System.out.print("|");

subgrid3 += candidateSolution.charAt(j+6); if(spam) System.out.print(candidateSolution.charAt(j+6)); 
subgrid3 += candidateSolution.charAt(j+7); if(spam) System.out.print(candidateSolution.charAt(j+7));
subgrid3 += candidateSolution.charAt(j+8); if(spam) System.out.print(candidateSolution.charAt(j+8));

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
		 if(counter != 9) return -2;//breaks rule 2, subgrid had a duplicate
		 
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
		 if(counter != 9) return -2;//breaks rule 2, subgrid had a duplicate

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
		 if(counter != 9) return -2;//breaks rule 2, subgrid had a duplicate
	     }
	     
		 //we know this because for each number it finds, counter increases by 1.
         //if it does not find something, counter does not increase
		 //if it finds something multiple times, counter increases only once
		 //thus, counter != 9, if duplicates or missing, counter remains < 9.
		 
//end of rule 2
//start of rule 4	     
	     
		//then to get the y-axis, need to check 0,3,6 1,4,7 and 2,5,8 chars in those substrings,
		//then count matches from all 9 substrings to make sure that each number is only once there

	     String yaxis = "";
	     
	     //let's get the nine y-axis columns
	     for(int j = 0; j < 9; j++)
	     {
		 yaxis += candidateSolution.charAt(j);
		 yaxis += candidateSolution.charAt(j+9);
		 yaxis += candidateSolution.charAt(j+18);
		 yaxis += candidateSolution.charAt(j+27);
		 yaxis += candidateSolution.charAt(j+36);
		 yaxis += candidateSolution.charAt(j+45);
		 yaxis += candidateSolution.charAt(j+54);
		 yaxis += candidateSolution.charAt(j+63);
		 yaxis += candidateSolution.charAt(j+72);//8+72=80 is final index
		 
		 counter = 0;
		 if(yaxis.contains("1")) counter++;
		 if(yaxis.contains("2")) counter++;
		 if(yaxis.contains("3")) counter++;
		 if(yaxis.contains("4")) counter++;
		 if(yaxis.contains("5")) counter++;
		 if(yaxis.contains("6")) counter++;
		 if(yaxis.contains("7")) counter++;
		 if(yaxis.contains("8")) counter++;
		 if(yaxis.contains("9")) counter++;
		 if(counter != 9) return -4;//breaks rule 4, yaxis had a duplicate or missing number		 
	     }
//end of rule 4
		 
		// returns 0 if the candidate solution is correct
		return 0;
		
		//check
	}
}
