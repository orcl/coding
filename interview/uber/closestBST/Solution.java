/* problem: closest binary search tree value
 * Given an non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * Note:
 *  given target value is a floating point.
 *  you are guaranteed to have only one unique value in BST that is closest to the target.
 */

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) {
    val = x;
  }
}//end TreeNode



public class Solution {

  public int closestValue(TreeNode root, double target) {
    if (root == null) {
      return -1;
    }

    TreeNode result = root;
    while (root != null) {
      if ((double)root.val == target) {
        return root.val;
      }
      if (Math.abs((double)root.val - target) < Math.abs((double)result.val - target)) {
        result = root;
      }
      if ((double)root.val < target) {
        root = root.right;
      }else {
        root = root.left;
      }
    }//end while
    return result.val;
  }
}//end class Solution




