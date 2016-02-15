/* Problem: Longest substring without repeating characters.
 *
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbbb" the longest substring is "b", with the length of 1.
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
    
        String input = "eee";
        System.out.println("the longest substring without duplicate chars is: " + lengthOfLongestSubstring(input));

    }//end main


    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] arr = s.toCharArray();
        int cur_max = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i],i);
            }else {
                cur_max = Math.max(cur_max, map.size());
                i = map.get(arr[i]);
                map.clear();
            }
        }
    
        return Math.max(cur_max, map.size());
        
    }//end method.

}//end class


