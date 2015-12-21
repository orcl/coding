/* validate input string, 
 * check if () is properly nested.
 */

public class Solution1 {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> s1 = new Stack<Character>();
        char[] char_array = s.toCharArray();

        for (int i = 0; i < char_array.length; i++) {
            char curr = char_array[i];
            if (curr == '(') {
                s1.push(curr);
            }else if (curr == ')') {
                if (s1 == null || s1.size() == 0) {
                    return false;
                }
                char tmp = s1.pop();
                if (tmp != '(') {
                    return false;
                }
            }
        }
        return s1.size() == 0;
    }

}








