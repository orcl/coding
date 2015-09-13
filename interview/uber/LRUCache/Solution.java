/* LRU Cache
 * Design and implement a data structure for least Recently Used (Cache). it should support the following operations: get and set.
 *
 * get(key) --- get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) --- set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */

/*
 * Solution: we simply use a hashmap<key, Node> and a queue<Node> to keep track of the order of elements.
 */

class Node {
  int key;
  int value;
  Node prev;
  Node next;

  public Node(int key, int value) {
    this.key = key;
    this.value = value;
  }
}//end Node class


public class LRUCache {
  int capacity;
  HashMap<Integer, Node> map = new HashMap<Integer, Node>();
  Node head = null;
  Node tail = null;

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node n = map.get(key);
      remove(n);
      setHead(n);
      return n.value;
    }
    return -1;
  }

  public void remove(Node n) {
    if (n.prev != null) {
      n.prev.next = n.next;
    }else {
      head = n.next;
    }
    if (n.next != null) {
      n.next.prev = n.prev;
    }else {
      tail = n.prev;
    }
  }

  private void setHead(Node n) {
    n.next = head;
    n.prev = null;
    if (head != null) {
      head.prev = n;
    }
    head = n;
    if (tail == null) {
      tail = head;
    }
  }

  private void set(int key, int value) {
    if (map.containsKey(key)) {
      //element in the map, update queue
      Node n = map.get(key);
      n.value = value;
      remove(n);
      setHead(n);
    }else {
      Node n = new Node(key,value);
      if (map.size() >= capacity) {
        map.remove(tail.key);
        remove(tail);
        setHead(n);
      }else {
        setHead(n);
      }
      map.put(key,n);
    }
  }//end set.

}//end class LRUCache









