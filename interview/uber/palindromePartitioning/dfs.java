
public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>();
        List<String> path = new ArrayList<String>();

        if (s == null || s.length() == 0) {
            return result;
        }

        helper(result,path, s);
        return result;

    }//end partition

    private boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }//end while
        return true;
    }


    private void helper(List<List<String>> result, List<String> list, String str) {
        
        if (str.length() == 0) {
            result.add(new ArrayList<String>(list));
        }
        int len = str.length();

        for (int i = 1; i <=len; i++) {
            String subStr = str.substring(0,i);
            if (isPalindrome(subStr)) {
                list.add(subStr);
                String restSubStr = str.substring(i);
                helper(result,list,restSubStr);
                list.remove(list.size()-1);
            }
        }
    }//end helper


}//end class Solution



