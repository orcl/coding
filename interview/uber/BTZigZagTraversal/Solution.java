class TreeNode {
  public int val;
  public TreeNode left, right;
  public TreeNode(int val) {
    this.val = val;
    this.left = this.right = null;
  }
}//end class TreeNode


public class Solution {

  public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
  
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (root == null) {
      return result;
    }

    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    int flag = 0;

    while (!queue.isEmpty()) {
      ArrayList<Integer> list = new ArrayList<Integer>();
      int size = queue.size();
      if (flag %2 == 0) {
        for (int i = 0; i < size; i++) {
          TreeNode tmp = queue.removeFirst();
          if (tmp.left != null) {
            queue.offer(tmp.left);
          }
          if (tmp.right != null) {
            queue.offer(tmp.right);
          }
          list.add(tmp.val);
        }
      }else {
        for (int i = 0; i < size; i++) {
          TreeNode tmp = queue.removeLast();
          if (tmp.right != null) {
            queue.offerFirst(tmp.right);
          }
          if (tmp.left != null) {
            queue.offerFirst(tmp.left);
          }
          list.add(tmp.val);
        }
      }
      flag += 1;
      result.add(new ArrayList<Integer>(list));
    }//end while
    return result;
  }
}//end Solution




