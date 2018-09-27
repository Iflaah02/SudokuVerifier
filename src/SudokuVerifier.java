import java.security.InvalidParameterException;
import java.util.Arrays;

public class SudokuVerifier {
	
	public static int verify(String candidateSolution) {

        if(candidateSolution.length() != 81)
            throw new InvalidParameterException();

        if(!verifyMatchesRule1(candidateSolution))
            return -1;

        if(!verifyMatchesRule2(candidateSolution))
            return -2;

        if(!verifyMatchesRule3(candidateSolution))
            return -3;

        if(!verifyMatchesRule4(candidateSolution))
            return -4;


		// returns 0 if the candidate solution is correct
		return 0;
	}

    /*
     * Verifies that each sub grid has one of each number
     */
    static boolean verifyMatchesRule2(String candidateSolution) {

        for(int subgroupRow = 0; subgroupRow < 3; ++subgroupRow){

            for(int subgroupColumn = 0; subgroupColumn < 3; ++subgroupColumn){

                if(!hasEachNumberOnce(extractSubGroup(candidateSolution, subgroupRow, subgroupColumn)))
                    return false;
            }
        }

        return true;
    }

    private static String extractSubGroup(String candidateSolution, int subgroupRow, int subgroupColumn){
        StringBuilder str = new StringBuilder();

        for(int row = 0; row < 3; ++row){

            final int rowBase = (subgroupRow * 3* 9) + (row * 9);
            str.append(candidateSolution.substring(rowBase + (subgroupColumn * 3),
                    rowBase + ((subgroupColumn + 1) * 3)));
        }

        return str.toString();
    }

    /*
	* Verifies that there is one number once in each row
	 */
    static boolean verifyMatchesRule3(String candidateSolution) {

        for(int row = 0; row < 9; ++row){

            if(!hasEachNumberOnce(candidateSolution.substring(row * 9, (row + 1) * 9)))
                return false;

        }

        return true;
    }

    /*
     * Verifies that there is one number once in each column
     */
    static boolean verifyMatchesRule4(String candidateSolution) {

        for(int column = 0; column < 9; ++column){

            StringBuilder str = new StringBuilder(candidateSolution.substring(0 + column, 0 + column + 1));

            // Probably not very efficient
            for(int row = 1; row < 9; ++row){
                str.append(candidateSolution.substring((row * 9) + column, (row * 9) + column + 1));
            }

            if(!hasEachNumberOnce(str.toString()))
                return false;
        }

        return true;
    }

    private static boolean hasEachNumberOnce(String str){

        if(str.length() != 9)
            throw new RuntimeException();

        boolean numbers[] = new boolean[9];
        Arrays.fill(numbers, false);

        for(int i = 0; i < str.length(); ++i){

            int number = str.codePointAt(i) - '1';

            // Duplicate
            if(numbers[number])
                return false;

            numbers[number] = true;
        }

        for(int i = 0; i < numbers.length; ++i)
            if(!numbers[i])
                return false;

        return true;
    }

    /*
	* Verifies that only has digits
	 */
    private static boolean verifyMatchesRule1(String candidateSolution) {

        for(int i = 0; i < candidateSolution.length(); ++i){

            int c = candidateSolution.codePointAt(i);

            if(c <= '0' || c > '9'){
                return false;
            }
        }

	    return true;
    }
}
