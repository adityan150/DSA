package com.aditya.DSA.GeeksForGeeks;

public class CheckBST {

    private class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    private class BSTpair {
        boolean isBST;
        int min;
        int max;
        BSTpair() {
            isBST = true;
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }
    }
    //Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root)
    {
        BSTpair rootPair = checkBST(root);
        return rootPair.isBST;
    }
    BSTpair checkBST(Node root) {
        if (root == null) {
            return new BSTpair();
        }
        BSTpair rootPair = new BSTpair();
        BSTpair leftPair = checkBST(root.left);
        BSTpair rightPair = checkBST(root.right);

        if ((leftPair.isBST && rightPair.isBST) &&
                root.data > leftPair.max && root.data < rightPair.min) {
            rootPair.isBST = true;
            rootPair.min = Math.min(root.data, leftPair.min);
            rootPair.max = Math.max(root.data, rightPair.max);
        }
        else rootPair.isBST = false;
        return rootPair;
    }



}
