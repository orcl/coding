/*
 * we can also use the definition of an anagram -- two words with the same character counts
 * to implement this algorithm
 * we simply iterate through this code, counting how many times each character appears.
 */

public boolean permutation(String s, String t) {
  if (s.length() != t.length()) {
    return false;
  }

  int[] letters = new int[256]; //Assumption

  char[] s_array = s.toCharArray();
  for (char c: c_array) {
    //count number of each char in s.
    letters[c]++;
  }

  for (int i = 0; i <t.length(); i++) {
    int c = (int) t.charAt(i);
    if (--letters[c] < 0) {
      return false;
    }
  }
  
  return true;
}


public String sort(String s, String t) {

  char[] content = s.toCharArray();
  java.util.Arrays.sort(content);
  return new String(content);
}


public boolean permutation(String s, String t) {
  if (s.length() != t.length()) {
    return false;
  }

  return sort(s).equals(sort(t));
}



