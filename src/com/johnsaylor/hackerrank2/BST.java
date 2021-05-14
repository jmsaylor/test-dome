package com.johnsaylor.hackerrank2;

public class BST {

    private Node root;

    class Node {
        Node left;
        Node right;
        int value;
        Node(int value) {
            this.value = value;
        }
    }

    public void add(int value){
        if (root == null) root = new Node(value);
    }

    public void addRecursive(Node node, int value) {
        if (value < node.value) {
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                addRecursive(node.left, value);
            }
        } else if (value > node.value) {
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                addRecursive(node.right, value);
            }
        }
    }

}
