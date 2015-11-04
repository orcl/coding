public class BSTIterator {

    Stack<TreeNode> stack1;

    public BSTIterator(TreeNode root) {
        stack1 = new Stack<TreeNode>();
        TreeNode tmp = root;
        while (tmp != null) {
            stack1.push(tmp);
            tmp = tmp.left;
        }
        //we got to the left most node already.
    }

    public boolean hasNext() {
        return !stack1.isEmpty();
    }

    public int next() {
        TreeNode tmp = stack1.pop();
        int result = tmp.val;
        if (tmp.right != null) {
            tmp = tmp.right;
            while (tmp != null) {
                stack1.push(tmp);
                tmp = tmp.left;
            }
        }

        return result;
    }

}//end class BSTIterator
