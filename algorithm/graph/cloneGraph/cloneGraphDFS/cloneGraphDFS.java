/* clone an undirected graph, each node in the graph contains a label and a list of neighbors.
 */

class UndirectedGraphNode {
  int label;
  List<UndirectedGraphNode> neighbors;
  UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

public class Solution {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) return null;
      HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
      UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
      map.put(node,copy);
      helper(node,map);

      return copy;
  }

  public void helper(UndirectedGraphNode node, HashMap<UndirectedGraphNode,UndirectedGraphNode> map) {
    
      for (UndirectedGraphNode tmp : node.neighbors) {
        if (!map.containsKey(tmp)) {
          //save a copy of tmp into the map
          UndirectedGraphNode tmp_copy = new UndirectedGraphNode(tmp.label);
          map.put(tmp,tmp_copy);
          helper(tmp,map);
        }
        //add the neighbors to the copy's neighbor list
        map.get(node).neighbors.add(map.get(tmp));
      }//end for loop
  }

}
