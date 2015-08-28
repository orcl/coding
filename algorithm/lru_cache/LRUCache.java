/* LRU Cache
 *
 * design and implement a data structure for least Recently used (LRU) cache. it should support the following operations: get and set.
 *
 * get(key) --- get the value(will always be positive) of the key if the key exists in the cache, otherwise return -1.
 *
 * set(key, value) --- set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least
 * recently used item before inserting a new item.
 *
 * Analysis
 * the key to solve this problem is using a double linekd list which enables us to quickly move nodes.
 *
 * The LRU cache is a hash table of keys and double linekd nodes. The hash table makes the time of get() to be O(1).
 * the list of double linked nodes make the nodes adding/removal operations O(1).
 *
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
}



public class LRUCache {
  int capacity;
  HashMap<Integer, Node> map = new HashMap<Integer, Node>();
  Node head = null;
  Node end  = null;

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
      end = n.prev;
    }
  }

  public void setHead(Node n) {
    n.next = head;
    n.prev = null;

    if (head != null) {
      head.prev = n;
    }

    head = n;
    if (end == null) {
      end = head;
    }
  }

  public void set(int key, int value) {
 
    if (map.containsKey(key)) {
      Node old = map.get(key);
      old.value = value;
      remove(old);
      setHead(old);
    }else {
      Node created = new Node(key,value);
      if (map.size() >= capacity) {
        map.remove(end.key);
        remove(end);
        setHead(created);
      }else {
        setHead(created);
      }

      map.put(key, created);
    }
  }

}//end class LRUCache





