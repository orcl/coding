/* check if two nodes are cousins in a binary tree.
 * given the binary tree and the two nodes say 'a' and 'b', determine whether the two nodes are cousins of each other.
 * tow nodes are cousins of each other if they are on the same level and have different parents.
 *
 * Example
 *               6
 *           3       5
 *         7   8   1    3
 *   
 *   7 and 1, result is true
 *   3 and 5, result is false
 *   7 and 5, result is false
 *
 */ 

/* solution:
 * 1. check if two nodes are on the same level
 * 2. check if two nodes don't have the same parent(check siblings)
 */

public class Solution {

    public static void main(String[] args) {
 
        TreeNode root = new TreeNode(6);
 
        TreeNode l1 = new TreeNode(3);
        TreeNode l2 = new TreeNode(5);
        root.left = l1;
        root.right = l2;

        l1.left  = new TreeNode(7);
        l1.right = new TreeNode(8);

        l2.left  = new TreeNode(1);
        l2.right = new TreeNode(3);
        

        boolean result = checkCousins(root, l1.left, l2.right);
        System.out.println("7 and 3, result is : " + result);
    
        boolean result1 = checkCousins(root, l1.left, l1.right);
        System.out.println("7 and 8, result is : " + result1);

    }//end main


    private static boolean checkCousins(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || a == null || b == null) {
            return false;
        }

        int a_height = getHeight(root, a, 0);
        int b_height = getHeight(root, b, 0);

        //System.out.println("a_height is: " + a_height);
        //System.out.println("b_height is: " + b_height);

        if (a_height != b_height) {
            return false;
        }

        TreeNode lca = getLCA(root,a,b);
        if ((lca.left == a && lca.right == b) || (lca.left == b && lca.right == a)) {
            return false;
        }
    
        return true;
    
    }//end checkCousins

    private static int getHeight(TreeNode root, TreeNode node, int height) {
        //base case
    
        if (root == null || node == null) {
            return 0;
        }

        if (root == node) {
            //System.out.println("hello, i'm here.");
            System.out.println("height is " + height);
            return height;
        }

        int left  = getHeight(root.left,node,height+1);
        int right = getHeight(root.right,node,height+1);
        
        return left > right? left:right;

    }//end getHeight


    private static TreeNode getLCA(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }
        if (root == a || root == b) {
            return root;
        }

        TreeNode left  = getLCA(root.left,a,b);
        TreeNode right = getLCA(root.right,a,b); 

        if (left != null && right != null) {
            return root;
        }else if (left != null) {
            return left;
        }else {
            return right;
        }
    }



}//end Solution class


class TreeNode{
    public int value;
    public TreeNode left  = null;
    public TreeNode right = null;

    public TreeNode(int n) {
        this.value = n;
    }

}//end class TreeNode

