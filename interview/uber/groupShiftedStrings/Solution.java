/*
 * group shifted strings
 * given a string, we can "shift" each of its letter to its successive letter, 
 * for example, "abc" => "bcd". we can keep "shifting" which forms the sequence.
 *
 * "abc" => "bcd" => ... => "xyz"
 *
 * given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 * for example, given ["abc","bcd","acef","xyz","az","ba","a","z"],
 *
 * return:
 * [
 *     ["abc","bcd","xyz"],
 *     ["az","ba"],
 *     ["acef"],
 *     ["a","z"]
 * ]
 *
 */


public class Solution {

    public List<List<String>> groupStrings(String[] strings) {
    
        List<List<String>> result = new ArrayList<List<String>>();
        if (strings == null || strings.length == 0) {
            return result;
        }

        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s: strings) {
            int offset = s.charAt(0) = 'a';
            String key = "a";
            for (int i = 1; i < s.length(); i++) {
                char c = (char)(s.charAt(i) - offset);
                if (c < 'a') {
                    c = c + 26;
                }
                key = key + c;
            }
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());            
            }
            map.get(key).add(s);
        }//end for loop

        for (List<String> list : map.values()) {
            Collections.sort(list);
            result.add(list);
        }//end for loop

        return result;
    
    }//end groupStrings





}//end class Solution
