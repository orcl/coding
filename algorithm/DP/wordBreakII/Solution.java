/* word break II
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
return all such possible sentences.

For example, given
s = "catsanddog"
dict = ["cat", "cats", "and", "sand", "dog"].
A solution is ["cats and dog", "cat and dog"].

Idea: this problem is very similar to word break. instead of using a boolean array to track the matched positions,
we need to track the actual matched words, then we can use depth first search to get all the possible paths.
for example list of strings.

1. first use dp to check if the string is breakable.
2. use dfs to track the path and get the result.

*/

import java.util.*;


public class Solution {

    public static void main(String[] args) {
        
        String input = "catsanddog";
        Set<String> wordDict = new HashSet<String>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");

        List<String> result = wordBreak(input,wordDict);
        System.out.println(result);


    }//end main


    public static List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return result;
        }
        if (!canBreak(s,wordDict)){
            return result;
        }
        StringBuilder sb = new StringBuilder();
        helper(s,0,sb,result,wordDict);
        return result;
    }
    

    private static void helper(String s, int index, StringBuilder sb, List<String> result, Set<String> wordDict) {
        //termination condition
        if (index >= s.length()) {
            System.out.println("did this ever get called?");

            result.add(sb.toString());
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            String tmp = s.substring(index,i+1);   //i is inclusive
            System.out.println("tmp is: " + tmp);
            if (wordDict.contains(tmp)) {
                int curLen = sb.length();
                if (curLen != 0) {
                    sb.append(" ");
                }
                sb.append(tmp);
                helper(s,i+1,sb,result,wordDict);
                sb.delete(curLen,sb.length());
            }
        }//end for loop
    }//end helper
 


    private static boolean canBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        //use dp
        boolean[] m = new boolean[s.length()];
        //m[i] represents whether we can break the string from index 0 to i,including ith index.
        //base case:
        if (wordDict.contains(s.substring(0,1))) {
            m[0] = true;
        }else {
            m[0] = false;
        }
        
        //induction rule.
        for (int i = 1; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0,i+1))) {
                m[i] = true;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (m[j] && wordDict.contains(s.substring(j+1,i+1))) {
                    m[i] = true;
                    break;
                }        
            }
        }//end for loop
        return m[s.length()-1];
        
    }//end canBreak
    
}//end class


