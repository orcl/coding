public class symmetricTree {

  publc boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return isSym(root.left, root.right);
  }

  public boolean isSym(TreeNode l, TreeNode r) {
    if (l == null && r == null) {
      return true;
    }else if (l == null || r == null) {
      return false;
    }

    if (l.val != r.val) {
      return false;
    }

    return isSym(l.left, r.right) && isSym(l.right, r.left);
  }
}
