/*
 * A bottom up approach (worst case O(n)):
 * using a bottom-up approach, we can improve over the top-down approach by avoiding traversing the same nodes over and over again.
 *
 * we traverse from the bottom, and once we reach a node which matches one of the two nodes, we pass it up to its parent,
 * the parent would then test its left and right subtree if each contain one of the two nodes. if yes, then the parent must be the LCA and we pass its parent up to the root. if not, we pass the lower node which contains either one of the two nodes (if the left or right subtree contains either p or q). or NULL (if both the left and right subtree does not contain either p and q) up.
 *
 * /



public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}


public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
  
    if (root == null) return null;
    if (root == p || root == q) return root;

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) return root;  //this means that p and q are on both sides,
    return left != null ? left: right;   // this means that p and q are on the same side, if left is not null, means p and q are both on left side, therefore, return left node.
    //otherwise return the right one.

  }
}


