package com.aditya.DSA.Data_Structures;



public class BinaryTree {
    static class Node {
        int key;
        Node left;
        Node right;

        Node(int item) {
            key = item;
            left = right = null;
        }
    }
    Node root;

    BinaryTree(int key) {
        root = new Node(key);
    }

    BinaryTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);

        /*
                1
              /   \
             2     3
            / \     \
           4   5     6
       */
    }
}
