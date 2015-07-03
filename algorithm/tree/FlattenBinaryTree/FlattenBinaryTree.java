public class FlattenBinaryTree {

  public void flatten(TreeNode root) {
    if (root == null) return;

    TreeNode left   =  root.left;
    TreeNode right  =  root.right;

    if (left != null) {
      root.right = left;
      root.left  = null;
      TreeNode rightmost = left;
      while (rightmost.right != null) {
        rightmost = rightmost.right;
      }
      rightmost.right = right;
    }
    flatten(root.right);
  }

}//end class
