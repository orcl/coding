public class BFS {

  void search(Node root) {
    Queue queue = new Queue();
    root.visited = true;
    visit(root);
    queue.enqueue(root);   // Add to end of queue

    while(!queue.isEmpty()) {
      Node r = queue.dequeue();    //remove from front of queue
      foreach (Node n in r.adjacent) {
        if (n.visited == false) {
          visit(n);
          n.visited = true;
          queue.enqueue(n);
        }
      }
    }
  }
}
