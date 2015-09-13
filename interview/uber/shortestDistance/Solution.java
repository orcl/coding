/*
 * problem: shortest word distance I
 *
 * given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 */

public class Solution {

  int result = Integer.MAX_VALUE;
  int a = -1;
  int b = -1;
  for (int i = 0; i < words.length; i++) {
    if (word1.equals(words[i])) {
      a = i;
      if (b >= 0) {
        result = Math.min(result,Math.abs(a-b));
      }
    }else if (word2.equals(words[i])) {
      b = i;
      if (a >= 0) {
        result = Math.min(result,Math.abs(a-b));
      }
    }
  }//end for loop
  return result;
}//end class Solution





