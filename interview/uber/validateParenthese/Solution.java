import java.util.*;

public class Solution {

  public static void main(String[] args) {
 
    String s1 = "..][";
    System.out.println(s1+", "+check(s1));
    String s2 = ".[][][][]";
    System.out.println(s2+" "+check(s2));
    String s3 = "....[[][][]]...";
    System.out.println(s3+" "+ check(s3));
    String s4 = "...[[][][][][]]..";
    System.out.println(s4+" " + check(s4));


  }//end main

  public static boolean check(String str) {
    if (str == null) return true;
    
    char[] char_array = str.toCharArray();
    boolean result = true;
    Stack<Character> s1 = new Stack<Character>();
    for (int i = 0; i < char_array.length; i++) {
    
      if (char_array[i] != '[' && char_array[i] != ']')
        continue;
 
      if (char_array[i] == ']') {
        if (s1.size() == 0) {
          return false;
        }
        s1.pop();
      }
      if (char_array[i] == '[') {
        s1.push(char_array[i]);     
      }
   }//end for loop
    return result;
  }//end check


}//end class Solution
