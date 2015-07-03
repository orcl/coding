/*
 * Sum root to leaf numbers
 *
 * given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * find the total sum of all root-to-leaf numbers.
 *
 * for example,
 *    1
 *  2   3
 *  the root-to-leaf path 1->2 represents the number 12
 *  the root-to-leaf path 1->3 represents the number 13
 *  return the sum = 12 + 13 = 25
 *
 */

public class SumRootToLeafNumbers {

  public int sumNumbers(TreeNode root) {
    //start typing your java solution below
    //do not write main() function
    if (root == null) 
      return 0
    else 
      return sum(root,0);
  }

  public int sum(TreeNode root, int prev) {
    if (root.left == null && root.right == null) {
      return 10*prev + root.val;
    }else if (root.left != null && root.right != null) {
      return sum(root.left, 10* prev + root.val) + sum(root.right, 10 * prev + root.val);
    }else if (root.left != null) {
      return sum(root.left, 10*prev+root.val);
    }else {
      return sum(root.right, 10 * prev + root.val);
    }
  }
}


