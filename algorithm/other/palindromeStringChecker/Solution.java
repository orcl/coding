/* we can do it in O(n) time using a count array. Following are detailed steps.
 * 1, create a count array of alphabet size which is typically 256.
 * initialize all value of count array as 0.
 * 2. traverse the given string and increment cont of every character.
 * 3, traverse the count array and if the count array has more than one odd values, return false. otherwise return true.
 */

public class Solution {

  public static void main(String[] args) {
    boolean result = palindromeCheck("aab");
    System.out.println("the result is " + result); 
    System.out.println((int)'a');
  }

  public static boolean palindromeCheck(String a) {
    char[] count_array = new char[256];
    char[] char_array = a.toCharArray();

    for (int i = 0; i < char_array.length; i++) {
      count_array[char_array[i]]++;     
    }//end for loop

    //count odd occurring characters, odd counter is the key.
    int odd = 0;
    for (int i = 0; i < count_array.length; i++){
      if (count_array[i]%2!=0) {
        odd++;
      }
    }

    //return true if odd count is 0 or 1, otherwise false.
    return (odd <= 1);
  
  }//end palindromeCheck

}
