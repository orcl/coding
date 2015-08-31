/* problem Word break
 *
 *    given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 *    For example, given
 *    s = "leetcode"
 *    dict = ["leet","code"]
 *    return true becuase "leetcode" can be segmented as "leet code".
 */

/* Solution 1: */
/* time complexity: O(n^2) */
public class Solution {

  public boolean wordBreak(String s, Set<String> dict) {
    return wordBreakHelper(s, dict, 0);
  }
  public boolean wordBreakHelper(String s, Set<String> dict, int start) {
    if (start == s.length()) {
      return true;
    }
    for (String a : dict) {
      int len = a.length();
      int end = start + len;
      //end index should be <= string length
      if (end > s.length()) {
        continue;
      }
      if (s.substring(start, start+len).equals(a)) {
        if (wordBreakHelper(s, dict, start+len)) {
          return true;
        }
      }
    }
    return false;
  }
}


/* dynamic programming solution:
 * Define an array canSegment[] such that canSegment[i] == true => 0~(i-1) can be segmented using dictionary 
 * Initial state canSegment[0] == true
 *
 * canSegment[i] -->>  if 0~i-1 could be segmented.
 * 
 * the reason here we return canSegment[s.length()] is because len = a.length().
 * len = a.length(), ===>>> s.substring(i,end) (not including end) here, that's why canSegment[end] is o~end-1 actually.
 * canSegment[end] equals canSegment[s], because we end = i+len, len = a.length() not a.length()-1
 *
 * Time: O(string length * dict size)
 */

public class Solution {
  public boolean wordBreak(String s, Set<String> dict) {
    boolean[] canSegment = new boolean[s.length()+1];
    canSegment[0] = true;     //set first to be true, why? because we need initial state.

    for (int i = 0; i < s.length(); i++){
      //should continue from match position
      if (!canSegment[i]) {
        continue;
      }

      for (String a : wordDict) {
        int len = a.length();
        int end = i + len;
        if (end > s.length()) {
          continue;
        }
        
        if (canSegment[end]) {
          continue;
        }

        if (s.substring(i,end).equals(a)) {
          canSegment[end] = true;
        }
      }
    }
    return canSegment[s.length()];
  }
}



