/*
 * problem : excel sheet column Number
 * given a column title as appear in an Excel sheet, return its corresponding column number.
 * for example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ....
 * Z -> 26
 * AA => 27
 * AB => 28
 */

public class Solution {


    //the key is to use a hashmap to store the mapping between character an integer.
    //starting from the right hand side, the converted value for each character is the mapping integer * 26 to t-th power, where t starts from 0.

    private int titleToNumber(String s) {
    
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char c = 'A';
        for (int i = 1; i<= 26; i++) {
            map.put(c,i);
            c += 1;
        }//end for loop

        int result = 0;
        int i = s.length() -1;
        int t = 0;
        while ( i>= 0) {
            char curr = s.charAt(i);
            result = result + (int)Math.pow(26,t) * map.get(curr);
            t++;
            i--;
        }//end while
        return result;
    }

}






