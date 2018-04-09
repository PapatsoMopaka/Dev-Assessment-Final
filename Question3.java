import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A222231
 */
 
public class Question3 {
    
    //create project to represent the node
    static class Node {
        int n; //node data
        Node leftChild; //left child
        Node rightChild; //right child

        Node(int n) {
          this.n = n;
          leftChild = null;
          rightChild = null;
        }
    }
 
  static void treeLevel(Node root) {
    if (root == null)
      return;
 
    Queue<Node> queue = new LinkedList<>();
 
    // Pushing root node into the queue.
    queue.add(root);
 
    // Pushing delimiter into the queue.
    queue.add(null);
 
    // Executing loop till queue becomes
    // empty
    while (!queue.isEmpty()) {
 
      Node curr = queue.poll();
 
      // condition to check the
      // occurence of next level
      if (curr == null) {
        if (!queue.isEmpty()) {
          queue.add(null);
          System.out.println();
        }
      } else {
        // Pushing left child current node
        if (curr.leftChild != null)
          queue.add(curr.leftChild);
 
        // Pushing right child current node
        if (curr.rightChild != null)
          queue.add(curr.rightChild);
 
        System.out.print(curr.n + " ");
      }
    }
  }
 
  // Driver function
  public static void main(String[] args) {
 
      //input nodes data
    Node root = new Node(1);
    root.leftChild = new Node(2);
    root.rightChild = new Node(3);
    root.leftChild.leftChild = new Node(4);
    root.leftChild.rightChild = new Node(5);
    root.rightChild.rightChild = new Node(6);
 
    treeLevel(root);
  }
}
