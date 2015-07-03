public class Preorder {
  public void preOrder(Node root) {
    if (root = null) {
      return;
    }

    System.out.println(root.value);
    preOrder(root.left);
    preOrder(root.right);
  }
} //end class Preorder
