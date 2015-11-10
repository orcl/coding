/*
 * palindrome partition:
 * given a string, determine if a permutation of the string could form a palindrome
 * for example,
 * "code" => False, "aab" => True, "carerac" => True.
 *
 * Hint:
 * consider the palindromes of odd vs even length. what difference do you notice?
 *
 */





public class Solution {

    public boolean canPermutePalindrome(String s) {
        int n = s.length();
        if (n == 0 || n == 1) {
            return true;
        }

        int[] count = new int[256];
        int odd = 0;
        for (int i = 0; i < n; i++) {
            count[s.charAt(i)]++;

            if (count[s.charAt(i)] % 2 == 1) {
                odd++;
            }else {
                odd--;
            }
        }//end for loop

        return (odd == 0 || odd = 1) ? true : false;
    }

}//end class Solution


