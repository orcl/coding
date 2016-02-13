public class Solution1 {

    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        boolean[] m = new boolean[s.length()+1];
        //m[i] represents whether we can separate the words or not.
        //base case: m[0]
        m[0] = true;

        for (int i = 0; i <= s.length(); i++) {
            if (m[i] == false) {
                continue;
            }

            for (String word : wordDict()) {
                if (word.length() + i > s.length()) {
                    continue;
                }
                if (word.equals(s.substring(i,i+word.length()))) {
                    m[i+word.length()] = true;
                }
            }
        }

        return m[s.length()];

    }//end wordBreak

}//end class Solution1


