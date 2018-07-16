package com.shivaji;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/** @author Shivaji Byrapaneni */
public class BinaryTree {

  private Node rootNode;

  private Node add(Node currentNode, int data) {
    if (currentNode == null) {
      return new Node(data);
    } else if (data < currentNode.getData()) { // all small to left node
      currentNode.setLeftNode(add(currentNode.getLeftNode(), data));
    } else if (data >= currentNode.getData()) { // all greater than or equals to right node
      currentNode.setRightNode(add(currentNode.getRightNode(), data));
    }
    return currentNode;
  }

  public void add(int data) {
    rootNode = add(rootNode, data);
  }

  /*Should return the node value that should replace the matching node*/
  private Node remove(Node currentNode, int data) {
    if (currentNode == null) {
      return null;
    }
    if (data == currentNode.getData()) {
      // No Children no need to re org
      if (currentNode.getLeftNode() == null && currentNode.getRightNode() == null) {
        return null;
      } else if (currentNode.getRightNode() == null) { // only left child exists
        return currentNode.getLeftNode();
      } else if (currentNode.getRightNode() == null) { // only right child exists
        return currentNode.getLeftNode();
      } else {
        // If both left and right childs exist get right childs lowest value as current node value
        int smallestValue = findSmallestValue(currentNode.getRightNode());
        currentNode.setData(smallestValue);
        currentNode.setRightNode(remove(currentNode.getRightNode(), smallestValue));
      }
    } else if (data < currentNode.getData()) {
      currentNode.setLeftNode(remove(currentNode.getLeftNode(), data));
    } else if (data >= currentNode.getLeftNode().getData()) {
      currentNode.setRightNode(remove(currentNode.getRightNode(), data));
    }
    return currentNode;
  }

  private int findSmallestValue(Node currentNode) {
    return currentNode.getLeftNode() == null
        ? currentNode.getData()
        : findSmallestValue(currentNode.getLeftNode());
  }

  public boolean remove(int data) {
    boolean search = search(rootNode, data);
    if (search) {
      remove(rootNode, data);
    }
    return search;
  }

  private boolean search(Node currentNode, int data) {
    if (currentNode == null) {
      return FALSE;
    }
    if (currentNode.getData() == data) {
      return TRUE;
    } else if (data < currentNode.getData()) {
      return search(currentNode.getLeftNode(), data);
    } else if (data >= currentNode.getData()) {
      return search(currentNode.getRightNode(), data);
    }
    return FALSE;
  }

  public boolean search(int data) {
    return search(rootNode, data);
  }

  private void inOrderTraversal(Node currentNode, StringBuilder sb) {
    if (currentNode != null) {
      inOrderTraversal(currentNode.getLeftNode(), sb);
      sb.append(" " + currentNode.getData());
      inOrderTraversal(currentNode.getRightNode(), sb);
    }
  }

  public String inOrderTraversal() {
    StringBuilder sb = new StringBuilder();
    inOrderTraversal(rootNode, sb);
    return sb.toString();
  }

  private void preOrderTraversal(Node currentNode, StringBuilder sb) {
    if (currentNode != null) {
      sb.append(" " + currentNode.getData());
      preOrderTraversal(currentNode.getLeftNode(), sb);
      preOrderTraversal(currentNode.getRightNode(), sb);
    }
  }

  public String preOrderTraversal() {
    StringBuilder sb = new StringBuilder();
    preOrderTraversal(rootNode, sb);
    return sb.toString();
  }

  private void postOrderTraversal(Node currentNode, StringBuilder sb) {
    if (currentNode != null) {
      postOrderTraversal(currentNode.getLeftNode(), sb);
      postOrderTraversal(currentNode.getRightNode(), sb);
      sb.append(" " + currentNode.getData());
    }
  }

  public String postOrderTraversal() {
    StringBuilder sb = new StringBuilder();
    postOrderTraversal(rootNode, sb);
    return sb.toString();
  }

  public void dump() {
    System.out.println(rootNode.toString());
  }
}
