/* 
 * problem: shortest word distance II
 * this is a follow up of shortest word distance. the only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters, how would you optimize it?
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
 * 
 */


 /* hint: 
  * if the method is called multiple times, each time it will need to iterate over the array once.
  * however, if we can put the words into a hashmap, we don't have to iterate over the array again and again.
  * it is only one time cost.
  */

public class WordDistance {

  private Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

  public WordDistance(String[] words) {
    fill(words);
  }

  private void fill(String[] words) {
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (map.containsKey(word)) {
        List<Integer> pos = map.get(word);
        pos.add(i);
        map.put(word,pos);
      }else {
        List<Integer> pos = new ArrayList<Integer>();
        pos.add(i);
        map.put(word,pos);
      }
    }
  }

  public int shortest(String word1, String word2) {
    int minDist = Integer.MAX_VALUE;
    List<Integer> a = map.get(word1);
    List<Integer> b = map.get(word2);
    for (int i : a) {
      for (int j : b) {
        minDist = Math.min(minDist, Math.abs(i-j));
      }
    }
    return minDist;
  }

}//end wordDistance





