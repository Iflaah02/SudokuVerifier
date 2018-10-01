
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		
		checkLenght(candidateSolution);//if 9 rows and 9 colums, length is 81, if not, throw exception
		int form=checkDigits(candidateSolution);	//checks that string has only positive digits between 1 and 9	
		int[][] board=createBoard(candidateSolution);//creates 9x9 sudoku board with given numbers
		System.out.println("Sudoku board\n");
		for(int i = 0; i<9; i++)
		{
		    for(int j = 0; j<9; j++)
		    {
		        System.out.print(board[i][j]);
		    }
		    System.out.println();
		}
		
		int rows= checkRows(candidateSolution);
		int columns=checkColumns(candidateSolution);
		int subgrids=checkSubgrids(candidateSolution);
		
		int error=FindError(form, rows, columns, subgrids);//checks if any rules are violated
		return error;
		
	}
	

	/*picks only 1 error type because of the assignment,
	 * in reality invalid string could violate several rules at the same time*/
	public int FindError(int form, int rows, int columns, int subgrids) {
		if (form!=0) {
			return form;
		}else if (rows!=0)
		{
			return rows;
		}else if (columns!=0) {
			return columns;
		}
		else if(subgrids!=0)
		{
			return subgrids;
		}else {
		return 0;
		}
	}

	public int checkSubgrids(String candidateSolution) {//not working properly
		int[][] board=createBoard(candidateSolution);
		
        int count=0;
        int number=1;
        int loop=0;
        int i=0;
        int j=0;
        
        while(loop<9) {
        	int boxRow = i - i % 3;
        	int boxColumn = j - j % 3;            
		        for (int ii = 0; ii<3; ii++) {
		            for (int jj = 0; jj<3; jj++) {
		                if (board[boxRow + ii][boxColumn + jj] == number) {
		                    count++;
		                    if (count>1) {
		                    	loop=100;
		                    }  
		                }		                
		            }  
		            
		        }
		        		        
		        count=0;
		        number++;
		        loop++;
		        
        
        if(number==10) {
        	loop=10;
        }
        }
        
        if (loop<100) {
        	return 0;
        }
        else {
        	return -2;
        }
        
	}

	public int checkColumns(String candidateSolution) {
		int board[][]=createBoard(candidateSolution);
		int number=1;
		int loop=0;
		int count=0;
		int j=0;
		
		while(loop<9) {
		
        for (int ii = 0; ii < 9; ii++) {
            if (board[ii][j] == number) {
                count++;
                if (count>1) {
                	loop=100;
                }
            }
         }
            
        j++;
        count=0;
        loop++;
            if (j==8)
            {
            	loop=0;
            	number++;
            	count=0;
            	j=0;            	
            }            
            
           if (number==10)
           {
        	   loop=10;
           }
		}
           		
   		if (loop<100)
   		{
   			return 0;
   		}
   		else 
   		{
   			return -4;
   		}
	}


	public int checkRows(String candidateSolution) {
		int[][]board=createBoard(candidateSolution);
		int number=1;
		int loop=0;
		int count=0;
		int i=0;
		 
		while(loop<9) {
		
        for (int jj = 0; jj < 9; jj++) {
            if (board[i][jj] == number) {
                count++;
                if (count>1) {
                	loop=100;
                }
            }
         }            
            count=0;
            loop++;
            i++;
            
            if (i==9 && loop<10)
            {
            	loop=0;
            	number++;
            	count=0;
            	i=0;
            }
            
           if (number==10)
           {
        	   loop=10;
           }
		}
        
		if (loop<100)
		{
			return 0;
		}
		else {
			return -3;
		}
	}
		
	public int checkDigits(String candidateSolution) {
		String input=candidateSolution;
		char []array= input.toCharArray();
		int[] num = new int[array.length];
		int form=0;

	    for (int i = 0; i < array.length; i++){
	        num[i] = array[i] - '0';
	    }
	    
	    for (int i=0; i<num.length; i++) {
	    	if(num[i]>10 || num[i]<0) {
	    		form--;
	    	}
	    }
	    if (form==0) {
		return 0;
	    }
	    else {
	    	return -1;
	    }
	}


	public void checkLenght(String candidateSolution) {
		int i=candidateSolution.length();
		if (i!=81)
		{
			throw new IllegalArgumentException();
		}	
		
	}

	public int[][] createBoard(String candidateSolution) {
		String input=candidateSolution;
		char []array= input.toCharArray();
		int[] num = new int[array.length];

	    for (int i = 0; i < array.length; i++){
	        num[i] = array[i] - '0';
	    }
		
		int[][] board = new int[9][9];
				
		for(int i=0; i<9; i++) {
			
			for(int j=1; j<10; j++) {
				System.arraycopy(num, i*j, board[i], 0, j);				
				}
			}
		return board;
	}
}
