/*
 * problem: convert sorted array to binary search tree with minimal Height
 * Given a sorted (increasing order) array, convert it to create a binary tree with minimal height.
 */

public class Solution {

  public TreeNode sortedArrayToBST(int[] A) {
    if (A == null || A.length == 0) {
      return null;
    }
    return buildTree(A,0,A.lenght-1);
  }//end sortedArrayToBST

  private TreeNode buildTree(int[] A, int left, int right) {
    if (left > right) return null;
    int mid = left + (right-left)/2;
    TreeNode tmp    = new TreeNode(A[mid]);
    TreeNode left1  = buildTree(A,left,mid-1);
    TreeNode right1 = buildTree(A,mid+1,right);
    tmp.left = left1;
    tmp.right = right1;
    return tmp;
  }//end buildTree

}//end class Solution
