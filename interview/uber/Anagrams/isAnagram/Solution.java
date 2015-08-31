import java.util.Arrays;

public class Solution {

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] letters = new int[256]; //Assumption

    char[] s_array = s.toCharArray();
    for (char c : s_array) {
      letters[c]++;
    }

    for (int i = 0; i < t.length(); i++) {
      int c = (int)t.charAt(i);
      if (--letters[c] < 0) {
        return false;
      }
    }
    return true;
  }//end isAnagram

}
