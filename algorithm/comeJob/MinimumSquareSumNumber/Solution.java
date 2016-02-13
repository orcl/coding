/*
 * Question: how to make a number with minimum number of square sums.
 * for example:
 * 4  can be split into 1+1+1+1 or 2^2 (solution)             return 1
 * 10 can be split into 3^2 + 1^2 or 2^2 + 2^2 + 1^2 + 1^2    return 2
 *
 */


public class Solution {

    public static void main(String[] args) {
        
        int[] arguments = new int[]{1,2,3,4,5,6,7,8,9,10};

        for (int i = 0; i < arguments.length; i++) {
            System.out.println("argument " + arguments[i] + " ,result " + helper(arguments[i]));
        }

    }//end main


    //solve it with DP
    public static int helper(int n) {
        int[] m = new int[n+1];
        //m[i] represents the minimum number of square sums to make number i.

        //base case:
        m[0] = 0;
        //induction rule: linear scan and look back.
        for (int i = 1; i <= n; i++) {
            m[i] = i;      //initialize m[i] with the worst case scenario
            for (int j = 1; j * j <= i; j++) {
                if (j*j == i) {
                    m[i] = 1;
                    break;
                }else {
                    m[i] = Math.min(m[j] + m[i-j], m[i]);
                }
            }
        }

        return m[n];
    }

}
