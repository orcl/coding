/*
 * problem: Happy Number
 *    A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. those numbers for which this process ends in 1 are happy numbers.
 *    Example: 19 is a happy number.
 *    1^2 + 9^2 = 82
 *    8^2 + 2^2 = 68
 *    6^2 + 8^2 = 100
 *    1^2 + 0^2 + 0^2 = 1
 *  Solution: 
 *    1. we write two helper functions: sum (int[] array) and  int[] getDigits(int n)
 *    2. in our main program, we simply while loop until we return 
 *        also here we used hashset to stop the while loop like below:
 *          while (!set.contains(n))   this line is very important.
 */


public class Solution {

  public boolean isHappy(int n) {
    //the key to solve this problem is the stop condition for the loop
    HashSet<Integer> set = new HashSet<Integer>();
    while (!set.contains(n)) {
      set.add(n);

      n = sum(getDigits(n));
      if (n == 1) {
        return true;
      }
    }//end while
    return false;
  }

  public int sum(int[] arr) {
    int sum = 0;
    for (int i : arr) {
      sum = sum + i*i;
    }
    return sum;
  }

  public int[] getDigits(int n) {
    String s = String.valueOf(n);
    int[] result = new int[s.length()];
    int i = 0;

    while (n > 0) {
      int m = n % 10;
      result[i++] = m;
      n = n/10;
    }
    return result;
  }
  
}//end class Solution
