public class Solution {

    public boolean wordBreak(String s, Set<String> wordDict) {
    
        if (s == null || s.length() == 0) {
            return true;
        }

        //m[i] represents whether we can break the words from index 0 to ith index, including ith index.
        boolean[] m = new boolean[s.length()];
        Arrays.fill(m,false);

        if (wordDict.contains(s.substring(0,1))) {
            m[0] = true;
        }

        for (int i = 0; i < s.length(); i++) {
            //if the whole word is in the dictionary, simply set to true and go to next one.
            if (wordDict.contains(s.substring(0,i+1))) {
                m[i] = true;
                continue;
            }

            //linear scan and look back at all the positions.
            for (int j = 0; j < i; j++) {
                String str = s.substring(j+1, i+1); // substring from j+1 to i+1, second part.
                if (m[j] && wordDict.contains(str)) {
                    m[i] = true;
                    break;
                }
            }
        }

        return m[s.length()-1];

    }

}
