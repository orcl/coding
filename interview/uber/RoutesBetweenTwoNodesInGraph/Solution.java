/* problem: routes between two nodes in graph
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */

public class Solution {

  public boolean hasRoute(ArrayList<DirectedGraph> graph, DirectedGraphNode s, DirectedGraphNode t) {
    
    Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
    Deque<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
    queue.add(s);
    set.add(s);

    while (!queue.isEmpty()) {
      DirectedGraphNode tmp = queue.removeFirst();
      for (DirectedGraphNode node : tmp.neighbors) {
        if (set.add(node)) {
          queue.add(node);
        }
      }
      if (tmp == t) {
        return true;
      }
    }//end while
  
    return false;
  }

}//end class



