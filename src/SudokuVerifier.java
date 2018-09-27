import java.util.*;
public class SudokuVerifier
{
	int[][] sudokuArray= new int[9][9];
	public SudokuVerifier(){};
	public int verify(String candidateSolution)
	{
		int val = length_test(candidateSolution);
		if(val!=0)
			return(val);
		
		//positive
		val = positive_check(candidateSolution);
		if(val!=0)
			return(val);

		createSudokuArray(candidateSolution);

		val = once_per_row();
		if(val!=0)
			return(val);

		val = once_per_col();
		if(val!=0)
			return(val);

		val = once_per_square();
		if(val!=0)
			return(val);
		// returns 0 if the candidate solution is correct
		return 0;
	}

	public int length_test(String candidateSolution)
	{
		int size= candidateSolution.length();
		if(size==81)
			return(0);
		return(-6);
	}
	
	public int once_per_square()
	{
		ArrayList<Integer> intList=new ArrayList<Integer>();
		int i_start=0;
		int j_start=0;
		for (int grids = 1; grids <10;grids++)
		{
//            System.out.println("-----grids-----: "+grids);
            if(grids==1 || grids==2 || grids==3)
			{
				i_start=0;
			}
			else if(grids==4 || grids==5 || grids==6)
			{
				i_start=1*3;
			}
			else if(grids==7 || grids==8 || grids==9)
			{
//				System.out.println("grids: "+grids);		//for what ever reason eclipse says not all conditions are run.
															//if you enable the print it will print out all numbers: 7,8,9
				i_start=2*3;
			}

			if(grids==1 || grids==4 || grids==7)
			{
				j_start=0;
			}
			else if(grids==2 || grids==5 || grids==8)
			{
				j_start=1*3;
			}
			else if(grids==3 || grids==6 || grids==9)
			{
//				System.out.println("grids: "+grids);		//for what ever reason eclipse says not all conditions are run.
															//if you enable the print it will print out all numbers: 3,6,9
				j_start=2*3;
			}
//          System.out.println("i_start,j_start: "+i_start+","+j_start);
			for (int i=i_start; i<i_start+3; i++)
			{
	            for (int j=j_start; j<j_start+3; j++)
	            {
	            	int item = sudokuArray[i][j];
	        		if(intList.contains(item))
	        			return(-2);
	        		else
	        			intList.add(item);
	            }
	        }
            intList.clear();
		}
		return 0;
	}

	public int once_per_row()
	{
		ArrayList<Integer> intList=new ArrayList<Integer>();  
		for (int i=0; i<9; i++)
		{
            for (int j=0; j<9; j++)
            {
            	int integer = sudokuArray[i][j];
        		if(intList.contains(integer))
        			return(-3);
        		else
        			intList.add(integer);
            }
//            System.out.println(intList);
            intList.clear();
        }

		return 0;
	}
	
	public int once_per_col()
	{
		ArrayList<Integer> intList=new ArrayList<Integer>();  
        for (int j=0; j<9; j++)
		{
    		for (int i=0; i<9; i++)
            {
            	int integer = sudokuArray[i][j];
        		if(intList.contains(integer))
        			return(-4);
        		else
        			intList.add(integer);
            }
//System.out.println(intList);
            intList.clear();
        }

		return 0;
	}
	
	public int positive_check(String candidateSolution)
	{
		if(candidateSolution.toLowerCase().contains("-"))
			return(-1);
		return 0;
	}
	public void createSudokuArray(String candidateSolution)
	{
		int row=0;
		int col=0;
		for (int i = 0; i < candidateSolution.length(); i++)
		{
		    char c = candidateSolution.charAt(i);
		    int a=Character.getNumericValue(c);  
//			System.out.println(a);
		    sudokuArray[row][col]=a;
		    col++;
		    if(col>8)
		    {
	    		row++;
		    	col=0;
		    }
		}
//		System.out.println("Created array");
//		print();
	}
	public void print()
	{
		for (int i=0; i<9; i++)
		{
            for (int j=0; j<9; j++)
            {
            	int toPrint = sudokuArray[i][j];
            	if((j)%3==0)
            	{
                    System.out.print("|");
            	}
                System.out.print(toPrint);
            }
        	if((i-2)%3==0)
        	{
                System.out.print("\n------------");
        	}
			System.out.println("");
        }
	}
}
