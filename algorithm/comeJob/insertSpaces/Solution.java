/* given a string, we can insert at most one empty space between each pair of adjacent letters.
 * print all permutations of string after insertions of empty spaces.
 * input: str = "ABC"
 * output: 
 * ABC
 * AB C
 * A BC
 * A B C
 */

//solve this by recursion. DFS

public class Solution {

    public static void main(String[] args) {
    
        String input = "ABC";
        permute("",input);

    }

    //recursion, dfs, O(n!).

    public static void permute(String left, String right) {
        if (left.length() >= 0) {
            System.out.println(left + right);
        }

        int len = right.length();
        for (int i = 1; i < len; i++) {
            String cur = right.substring(0,i);
            cur += " ";
            permute(left+cur, right.substring(i));
        }
    }





}//end class Solution



