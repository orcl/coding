public class Inorder {
  public void Inorder(Node root) {
    if (root == null) {
      return;
    }
    Inorder(root.left);
    System.out.println(root.value);
    Inorder(root.right);
  }
}//end Inorder
