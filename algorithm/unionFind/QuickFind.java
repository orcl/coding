public class QuickFind {

  private int[] id;
    
  public QuickFind(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;                            //set id of each object to itself
    }
  }

  public boolean find(int p, int q) {
    return id[p] == id[q];                  //1 operation
  }

  public void unite(int p, int q) {
    int pid = id[p];
    for (int i = 0; i < id.length; i++) {
      if (id[i] == pid) 
        id[i] = id[q];                      //N operations
    }
  }
}//end QuickFind


/////////////////////////////////////////////////////////////////////////////////////////////

public class QuickUnion {

  private int[] id;

  public QuickUnion(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  private int root (int i) {
    while ( i!=id[i]) 
      i = id[i];                                   //time proportional to depth of i
    return i;
  }

  public boolean find (int p, int q) {
    return root(p) == root(q);                     //time proportional to depth of p and q
  }

  public void unite(int p, int q) {
    int i = root(p);                               //time proportional to depth of p and q
    int j = root(q);
    id[i] = j;
  }

}//end class QuickUnion



/*
 * Quick-find 
 * Data structure
 * Integer array id[] of size N. id value is the object's set name.
 * Interpretation: p and q are connected if they have the same id.
 *
 * i     0  1  2  3  4  5  6  7  8  9
 *id[i]  0  1  9  9  9  6  6  7  8  9        5 and 6 are connected,    2,3,4 and 9 are connected.
 *
 * Find. check if p and q have the same id. (same set)
 *
 * Union. to merge components containing p and q, change all entries with id[p] to id[q]. (just like change set a to set b, you need to update every entry that is in set a to set b).
 *
 *
 *
 *
 * Quick-union
 * Data structure
 * Integer array id[] of size N.
 * Interpretation: id[i] is parent of i.
 * Root of i is id[id[id[...id[i]....]]].  keep going until it doesn't change, if it's the root, it's not going to change anymore, it will be itself.
 * Find. check if p and q have the same root.
 *
 * Union. Set the id of q's root to the id of p's root.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
