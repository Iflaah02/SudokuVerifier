
public class SudokuVerifier {
	//boolean variables
	private boolean ints_ok = true;
	private boolean ints_flag = false;
	private boolean columns_ok = true;
	private boolean columns_flag = false;
	private boolean rows_ok = true;
	private boolean rows_flag = false;
	private boolean groups_ok = true;
	private boolean groups_flag = false;
	
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		
		
		//we do nothing unless the solution has correct size of 81 
		//if (sizeChecker(candidateSolution)) {
		
		//check the ints
		int ints = intTest(candidateSolution);
		if (ints != 0)
			return ints;
			
		//check the groups
		int groups = groupTest(candidateSolution);
		if (groups != 0)
			return groups;
			
		//check the rows
		int rows = rowTest(candidateSolution);
		if (rows != 0)
			return rows;
			
		//check the columns
		int colls = colTest(candidateSolution);
		if (colls != 0)
			return colls;
			
		//if no errors, return 0
		return 0;	

	}

	public int intTest(String candidateSolution) {
		int i = 0;
		int z = 0;
	
		//we go through letter by letter, transform those to integers and check the integers
		while (i < 81) {
			char qwer = candidateSolution.charAt(i);
			z = charToInt(qwer);
			ints_ok = intChecker(z);
			if (ints_ok == false)
				this.ints_flag = true;
			i++;
		}
		
		if (this.ints_flag)
			return -1;
		else
			return 0;
	}	
	
	public int rowTest(String candidateSolution) {
		int y = 0;
		String sudorow = "";
		while (y < 9) {
			sudorow = rowDivider(candidateSolution,y+1);
			rows_ok = rowChecker(sudorow);
			if (rows_ok == false)
				this.rows_flag = true;
			y++;
		}
		
		if (this.rows_flag)
			return -3;
		else
			return 0;
	}
	
	public int colTest(String candidateSolution) {
		//here we check the columns
		int x = 0;
		String column = "";
		while (x < 9) {
			column = colDivider(candidateSolution, x+1);
			columns_ok = rowChecker(column);
			if (columns_ok == false)
				columns_flag = true;
			x++;
		}
		
		if(columns_flag)
			return -4;
		else
			return 0;
	}
	
	public int groupTest(String candidateSolution) {
		//here we check 3x3 groups
		int g = 0;
		String group = "";
		while (g < 9) {
			group = colDivider(candidateSolution, g+1);
			groups_ok = rowChecker(group);
			if (columns_ok == false)
				groups_flag = true;
			g++;
		}
		
		if(groups_flag)
			return -2;
		else
			return 0;
	}	
	
	
	public boolean sizeChecker(String solution) {
		//System.out.println("length:"+ solution.length());
		
		if (solution.length() == 81)
			return true;
		else
			return false;
	}

	public int charToInt(char abc){	
		return Character.getNumericValue(abc);
	}
	
	public boolean intChecker(int number) {
		//here we check, if the int is between 1,2,3,4,5,6,7,8 or 9
		if (number > 0 && number < 10)
			return true;
		else
			return false;
	}
	
	//actually this works for columns and groups of 3x3 as well. no need for colChecker and groupChecker
	//maybe should have changed the name to something more universal but didn't want to write the test cases again.
	//flaws of writing code and cases side by side.
	public boolean rowChecker(String numstring) {
		//array for column
		int[] row = new int[9];
		int i = 0;
		int num = 0;
		//boolean variable for flagging the situation there are certain number(s) appearing multiple times
		boolean flag = true;
		//boolean variable for checking if every int is between 1 and 9
		boolean numbersok = true;
		
		while (i < 9) {
			num = charToInt(numstring.charAt(i));
			numbersok = intChecker(num);
			//numbers go from 1 to 9, array from 0 to 8, so -1 is required
			row[num-1]++;
			if (row[num-1] > 1)
				flag = false;
			i++;
		}
		if (flag && numbersok)
			return true;
		else
			return false;
	}
	
	//we need the string with 81 numbers and the row number for returning the right row
	public String rowDivider(String numstring, int row) {
		
		//string to rows
		String[] rowstring = numstring.split("(?<=\\G.{9})");

		String dividedrow = "";
		
		//correct row is returned with switch-case
		switch (row) {
			case 1: dividedrow = rowstring[0];
					break;
			
			case 2: dividedrow = rowstring[1];
					break;
			
			case 3: dividedrow = rowstring[2];
					break;
			
			case 4: dividedrow = rowstring[3];
					break;
			
			case 5: dividedrow = rowstring[4];
					break;
			
			case 6: dividedrow = rowstring[5];
					break;
			
			case 7: dividedrow = rowstring[6];
					break;
			
			case 8: dividedrow = rowstring[7];
					break;
			
			case 9: dividedrow = rowstring[8];
					break;
		}
		
		return dividedrow;
	}
	
	public String groupDivider(String numstring, int group) {
		//first we have 27 groups of 3 numbers
		String[] groupstring = numstring.split("(?<=\\G.{3})");
		String wanted_group = "";
				
		//here we construct groups of 9. works like my charm. 
		switch (group) {
			case 1: wanted_group = groupstring[0]+groupstring[3]+groupstring[6];
				break;
		
			case 2: wanted_group = groupstring[1]+groupstring[4]+groupstring[7];
				break;
		
			case 3: wanted_group = groupstring[2]+groupstring[5]+groupstring[8];
				break;
		
			case 4: wanted_group = groupstring[9]+groupstring[12]+groupstring[15];
				break;
		
			case 5: wanted_group = groupstring[10]+groupstring[13]+groupstring[16];
				break;
		
			case 6: wanted_group = groupstring[11]+groupstring[14]+groupstring[17];
				break;
		
			case 7: wanted_group = groupstring[18]+groupstring[21]+groupstring[24];
				break;
		
			case 8: wanted_group = groupstring[19]+groupstring[22]+groupstring[25];
				break;
		
			case 9: wanted_group = groupstring[20]+groupstring[23]+groupstring[26];
				break;
		}
		return wanted_group;
	}
	
	public String colDivider(String numstring, int col) {
		//we get an array of 81 strings
		String[] colstrings = numstring.split("(?<=\\G.{1})");
		String column = "";
		
		//9 columns are built here. I'm sure there are easier and prettier ways, but I don't care.
		switch(col) {
			case 1: column = colstrings[0]+colstrings[9]+colstrings[18]+
					colstrings[27]+colstrings[36]+colstrings[45]+
					colstrings[54]+colstrings[63]+colstrings[72];
				break;

			case 2: column = colstrings[1]+colstrings[10]+colstrings[19]+
					colstrings[28]+colstrings[37]+colstrings[46]+
					colstrings[55]+colstrings[64]+colstrings[73];
				break;

			case 3: column = colstrings[2]+colstrings[11]+colstrings[20]+
					colstrings[29]+colstrings[38]+colstrings[47]+
					colstrings[56]+colstrings[65]+colstrings[74];
				break;

			case 4: column = colstrings[3]+colstrings[12]+colstrings[21]+
					colstrings[30]+colstrings[39]+colstrings[48]+
					colstrings[57]+colstrings[66]+colstrings[75];
				break;

			case 5: column = colstrings[4]+colstrings[13]+colstrings[22]+
					colstrings[31]+colstrings[40]+colstrings[49]+
					colstrings[58]+colstrings[67]+colstrings[76];
				break;

			case 6: column = colstrings[5]+colstrings[14]+colstrings[23]+
					colstrings[32]+colstrings[41]+colstrings[50]+
					colstrings[59]+colstrings[68]+colstrings[77];
				break;

			case 7: column = colstrings[6]+colstrings[15]+colstrings[24]+
					colstrings[33]+colstrings[42]+colstrings[51]+
					colstrings[60]+colstrings[69]+colstrings[78];
				break;

			case 8: column = colstrings[7]+colstrings[16]+colstrings[25]+
					colstrings[34]+colstrings[43]+colstrings[52]+
					colstrings[61]+colstrings[70]+colstrings[79];
				break;

			case 9: column = colstrings[8]+colstrings[17]+colstrings[26]+
					colstrings[35]+colstrings[44]+colstrings[53]+
					colstrings[62]+colstrings[71]+colstrings[80];
				break;
		}
		
		return column;
	}
	
	//these are probably unnecessary 
	public boolean intsOk() {
		return ints_ok;
	}
	
	public boolean rowsOk() {
		return rows_ok;
	}
	
	public boolean colsOk() {
		return columns_ok;
	}
	
	public boolean groupsOk(){
		return groups_ok;
	}
}


