/*
 * implement a trie with insert, search, and startsWith methods.
 * A trie node should contain the character, its children and a flag that marks if it is a leaf node.
 */


class TrieNode {
  char c;
  HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  boolean isLeaf;

  public TrieNode() {}

  public TrieNode(char c) {
    this.c = c;
}//end class


public class Trie {

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  //inserts a word into the trie.
  public void insert(String word) {
    HashMap<Character, TrieNode> children = root.children;

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);

      TrieNode t;
      if (children.containsKey(c)) {
        t = children.get(c);
      }else {
        t = new TrieNode(c);
        children.put(c,t);
      }
      children = t.children;

      //set leaf node
      if (i == word.length() -1) {
        t.isLeaf = true;
      }
    }//end for loop
  }//end insert

  
  //returns if there is any word in the trie that starts with the given prefix.
  public boolean startsWith(String prefix) {
    if (searchNode(prefix) == null) {
      return false;
    }else {
      return true;
    }
  }

  public TrieNode searchNode(String str) {
    Map<Character, TrieNode> children = root.children;
    TrieNode t = null;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (children.containsKey(c)) {
        t = children.get(c);
        children = t.children;
      }else {
        return null;
      }
    }
    return t;
  }


}//end class Solution



/* Trie 1 (insert and search).
 *
 * Trie is an efficient information retrieval data structure. Using trie, search complexities can be brought to optimal limit(key length),
 * if we store keys in binary search tree, a well balanced BST will need time proportional to M * log(N) where M is maximum string length
 * and N is number of keys in tree.
 *
 * Using trie, we can search the key in O(M) time, however, the penalty is trie's storage requirements.
 *
 * Every node of trie consists of multiple branches, each branch represents a possible character of keys.
 * we need to mark the last node of every keys as leaf node. 
 * A trie node field value will be used to distinguish the node as leaf node (there are other uses of the value field).
 * A simple structure to represent nodes of English alphabet can be as following,
 *
 * inserting a key into trie is a simple approach, every character of input key is inserted as an individual trie node.
 * Note that the children is an array of pointers to next level trie nodes. 
 * The key character acts as an index into the array children. 
 * if the input key is new or an extension of exisiting key, we need to construct non-existing nodes of the key, and mark leaf node.
 * if the input key is prefix of existing key in trie, we simple mark the last node of key as leaf. 
 * the key length determines trie depth.
 *
 * searching  key is similar to insert operation, however we only compare the characters and move down.
 * the search can terminate due to end of string or lack of key in trie. 
 * in the former case, if the value field of last node is non-zero then the key exists in trie.
 * in the second case, the search terminates without examining all the characters of key, since the key is not present in trie.
 *
 */


 /* the following picture explains construction of trie using keys given in the example below.
  *
  *            root
  *          t   a    b
  *         e    b    a
  *       a      s    d
  *
  * in the picture, every character is of type trie_node_t. for example, the root is of type trie_node_t, and its children a,b and t are filled, all other nodes of root will be null.
  */




