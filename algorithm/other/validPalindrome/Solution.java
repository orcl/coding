/* Valid palindrome
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * for example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 */

public class Solution {
  public boolean isPalindrome(String s) {
  
    if (s == null || s.length() == 0 || s.length() == 1) return true;

    StringBuffer sb = new StringBuffer();
    char[] char_array = s.toCharArray();

    for (int i = 0; i < char_array.length; i++) {
      char tmp = char_array[i];
      if (char_array[i] >= 'a' && char_array[i] <= 'b') {
        sb.append(Character.toLowerCase(char_array[i]));
      }
    }

    String s1 = sb.toString();

    int left = 0;
    int right = s1.length() - 1;

    while (left < right) {
      if (s1.charAt(left) != s1.charAt(right)) {
        return false;
      }else {
        left++;
        right--;
      }
      return true;
    }
  }
}
