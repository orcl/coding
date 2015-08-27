package hashtable;

public class myHashMap<K,V> {

  private int default_bucket_count = 10;

  private Entry<K,V>[] buckets;

  public myHashMap() {
    buckets = new Entry[DEFAULT_BUCKET_COUNT];
  }

  public myHashMap(int capacity) {
    buckets = new Entry(capacity);
  }

  public V get(K key) {
    Entry<K,V> entry = buckets[bucketIndexForKey(key)];
    while (entry != null && !key.equals(entry.getkey()))
        entry = entry.getNext();
    return entry != null ? entry.getValue():null;
  }

  public void put(K key, V value) {
    int bucketIndex = bucketIndexForKey(key);
    Entry<K,V> entry = buckets[bucketIndex];

    if (null != entry) {
      boolean done = false;
      while (!done) {
        if (key.equals(entry.getKey())) {
          entry.setValue(value);
          done = true;
        }else if (entry.getNext() == null){
          entry.setNext(new Entry<K,V>(key, value));
          done = true;
        }
        entry = entry.getNext();
      }
    }else {
      
    }

  }



}//end class myHashMap

