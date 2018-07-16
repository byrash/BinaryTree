package com.shivaji;

/** @author Shivaji Byrapaneni */
public class Main {
  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    binaryTree.add(4);
    binaryTree.add(2);
    binaryTree.add(3);
    binaryTree.add(10);
    binaryTree.add(1);
    binaryTree.add(17);

    binaryTree.dump();

    boolean searchTrue = binaryTree.search(17);
    System.out.println(searchTrue);
    boolean searchFalse = binaryTree.search(27);
    System.out.println(searchFalse);

    System.out.println("In order " + binaryTree.inOrderTraversal());
    System.out.println("Pre order " + binaryTree.preOrderTraversal());
    System.out.println("Post order " + binaryTree.postOrderTraversal());
    binaryTree.remove(10);
    System.out.println("In order " + binaryTree.inOrderTraversal());
    System.out.println("Pre order " + binaryTree.preOrderTraversal());
    System.out.println("Post order " + binaryTree.postOrderTraversal());
  }
}
