/* clone an undirected graph. each node in the graph contains a label and a list of its neighbors.
 */


class UndirectedGraphNode {
  int label;
  List<UndirectedGraphNode> neighbors;
  UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

public class Solution {

  public UnidrectedGraphNode cloneGraph(UndirectedGraphNode node) {
  
    if (node == null) return null;
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    queue.add(node);
    UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
    map.put(node,copy);
    while (!queue.isEmpty()) {
      UndirectedGraphNode tmp = queue.removeFirst();
      for (UndirectedGraphNode neighbor : tmp.neighbors) {
        if (!map.containsKey(neighbor)) {
          queue.add(neighbor);
          UndirectedGraphNode neighbor_copy = new UndirectedGraphNode(neighbor.label);
          map.put(neighbor, neighbor_copy);
        }
        map.get(tmp).neighbors.add(map.get(neighbor));
      }
    }
    return copy;
  }

}
