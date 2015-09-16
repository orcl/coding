/* problem: Letter combinations of a phone number
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * input: Digit string "23"
 * output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 */

public class Solution {

  public List<String> letterCombinations(String digits) {
    Map<Character,char[]> map = new HashMap<Character,char[]>();
    map.put('0',new char[]{});
    map.put('1',new char[]{});
    map.put('2', new char[]{'a','b','c'});
    map.put('3', new char[]{'d','e','f'});
    map.put('4', new char[]{'g','h','i'});
    map.put('5', new char[]{'j','k','l'});
    map.put('6', new char[]{'m','n','o'});
    map.put('7', new char[]{'p','q','r','s'});
    map.put('8', new char[]{'t','u','v'});
    map.put('9', new char[]{'w','x','y','z'});

    List<String> result = new ArrayList<String>();
    if (digits == null || digits.equals("")) {
      return result;
    }

    StringBuffer sb = new StringBuffer();
    helper(result,sb,digits, 0,map);
    return result;
  }//end letterCombinations


  private void helper(List<String> result, StringBuffer sb, String digits, int index, Map<Character, char[]>map) {
      if (index == digits.length()) {
        result.add(sb.toString());
        return;
      }

      for (char c: map.get(digits.charAt(index))) {
        sb.append(c);
        helper(result,sb,digits, index+1, map);
        sb.deleteCharAt(sb.length()-1);
      }
  }//end helper

}//end class Solution






