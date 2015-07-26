public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

public class Solution {
  public int kthSmallest(TreeNode root, int k) {
    ArrayList<Integer> helper = new ArrayList<Integer>();
    ArrayList<Integer> result = new ArrayList<Integer>();
    inorder(root, helper, k, result);
    return result.get(0);
  }

  public void inorder(TreeNode root, ArrayList<Integer> helper, int k, ArrayList<Integer> result) {
    if (root != null) {
      inorder(root.left, helper, k, result);
      helper.add(root.val);
      if (helper.size() == k) 
        result.add(root.val)
      inorder(root.right, helper, k, result);
    }
  }
}//end class solution


