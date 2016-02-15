import java.util.*;


public class Solution {

  public static void main(String[] args) {
    String input = "aaaabbbc";
    String result = deDup(input);
    System.out.println("result is: " + result);

  }//end main


  public static String deDup(String input) {
    // write your solution here
    if (input == null || input.length() == 0) {
      return input;
    }
    char[] char_array = input.toCharArray();
    int slow = 1;
    for (int i = 2; i < char_array.length; i++) {
      if (char_array[i] != char_array[slow-1]) {
        slow++;
        char_array[slow] = char_array[i];
      }
    }//end for loop
    
    return new String(Arrays.copyOf(char_array,slow+1));
  }
}
