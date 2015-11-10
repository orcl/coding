/* 
 * minimum numbers are required whose square sum is equal to a given number
 *
 * Given a number, write an algorithm to find out minimum numbers required whose square is equal to the number.
 *
 * this question has been asked in the Google Interview for software engineer position. 
 * this is very good problem which shows the advantage of dynamic programming over recursion.
 *
 * Example: 
 * given number: 12
 * Numbers whose sum of squares are equal to 12.
 * 1^2 + 1^2 + 1^2 + ... + 1^2 = 12
 *
 * 2^2 + 2^2 + 2^2 = 12
 *
 * 3^2 + 1^2 + 1^2 + 1^2 = 12
 *
 * answer is: 3 numbers (2,2,2)
 *
 */

/* Solution :
 * the idea is simple, we start from 1 and go till a number whose square is smaller than or equals to n,
 * for every number i, we recur for n-i, 
 * below is the recursive solution.
 */

    public class SolutionRecursive {
    
        public static void main(String[] args) {
 
            int n = 12;
            int result = helper(n);
            System.out.println(helper(12));

        }//end main


        private static int helper(int n) {
            
            //base case
            if (n <= 3) {
                return n;
            }

            int result = n;
            //recursive rule
            for (int i = 1; i <= n; i++) {
                int tmp = i*i;
                if (tmp > n) {
                    break;
                }else {
                    result = Math.min(result, 1+helper(n-tmp));
                }
            }//end for loop

            return result;
        }//end helper

    
    }//end class Solution





