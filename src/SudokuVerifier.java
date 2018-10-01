import com.sun.xml.internal.ws.util.StringUtils;


public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		int result;
		result = checkLength(candidateSolution);
		result = checkDigits(candidateSolution);
		result = checkRows(candidateSolution);
		result = checkColumns(candidateSolution);
		// returns 0 if the candidate solution is correct
		return result;
		
		//check
	}
	
	
	public int checkLength(String x)
		{
		if (x.length() != 81) 
			{
			// System.out.println("Feed has incorrect number of digits");
			return 1;
			}
		else return 0;
		}
	
	public int checkDigits(String x)
		{
		int result=0;
		// char c;
		for (int i=0; i<x.length(); i++)
			{
			if (Character.isDigit(x.charAt(i)) != true || x.charAt(i) == '0')
				{
				result = -1;
				}
									
			}
		return result;
		}
	
	public int checkNine(String x)
		{
		int result = 0; 
		int i, j;
		char c;
		int counter=0;
		for (i=0; i<9; i++)
			{
			c = x.charAt(i);
			for (j=0; j<9; j++)
				{
				if (c == x.charAt(j)) counter++;
				}
			if (counter > 1) result = 1;
			counter=0;
			}
		return result;
		}
	
	public int checkRows(String x)
		{
		int result = 0;
		int i, j;
		int start;
		int end;
		String [] row = new String[10];
		for (i=0; i<9; i++) row[i]="";
		for (i=0; i<9; i++)
			{
			for (j=0; j<9; j++)
				{
				row[i]=row[i]+x.charAt(i*9+j);
				}
			
			result=checkNine(row[i]);
			// System.out.println(row[i] + " " + result);
			}
		if (result == 1) result =-3;
		return result;
		
		}
	
	public int checkColumns(String x)
	
	{
	int result = 0;
	int i,j;
	int character_wanted=0; 
	
	String [] column = new String[10];
	for (i=0; i<10; i++) column[i]="";
	for (i=0; i<9; i++)
		{
		for (j=0; j<9; j++)
			{
			character_wanted = i+j*9;
			// System.out.println("cw = " + character_wanted + " number " + x.charAt(character_wanted));
			column[i]=column[i] + x.charAt(character_wanted);
			}
			result=checkNine(column[i]);
			// System.out.println(column[i] + " " + result);
		}
	if (result == 1) result =-4;
	return result;
	
	}
	
	// completely useless after finding out about split - command for strings
		public String separate (String a, int x, int y) //
		{
		return a.substring(x, y);	
		}	
	// an attempt to solve the problem by counting 1-9 together on each row / column. 
	// gets you into problem with any checks that have multiples with 45 in total.
		public int toInt (char c)
		{
		int result = Character.getNumericValue(c); 
		return result;	
		}
	
}
