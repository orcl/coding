/* problem: Shortest Word Distance III
 *
 * Given a list of words and two word1 and word2, return the shortest distance between word1 and word2 in the list.
 * word1 and word2 may be the same and they represent two individual words in the list.
 *
 */

/*
 * hint: when two input words are the same, we simply update one position pointer.
 */

public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int minDist = Integer.MAX_VALUE;
        int a = -1;
        int b = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (word1.equals(word2) && a != -1) {
                    minDist =  Math.min(minDist, Math.abs(i-a));
                    a = i;
                }else {
                    a = i;
                    if (b>=0) {
                        minDist = Math.min(minDist, Math.abs(b-a));
                    }
                }
            }else if (words[i].equals(word2)) {
                b = i;
                if (a>=0) {
                    minDist = Math.min(minDist,Math.abs(a-b));
                }
            }    
        }//end for loop
        return minDist;
    }
}



