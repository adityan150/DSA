package com.aditya.DSA.GeeksForGeeks;

public class PreSucBST {
    private class Node {
        int key;
        Node left, right;
    }
    class Res {
        Node pre;
        Node suc;
    }

    // finds the predecessor and successor
    // for a given key in the inorder traversal
    // of a Binary Search Tree
    // sets predecessor and successor to -1 if any of them is not found
    public void findPreSuc(Node root, Res p, Res s, int key)
    {
        // if root is null
        if (root == null) return;
        // if predecessor is empty
        if (p.pre == null) {
            p.pre = new Node();
            p.pre.key = -1;
        }
        // if successor is empty
        if (s.suc == null) {
            s.suc = new Node();
            s.suc.key = -1;
        }

        // if the key is found
        if (key == root.key) {
            // if the root has left subtree
            if (root.left != null) {
                // predecessor will be the rightmost in the left subtree
                Node temp = root.left;
                while(temp.right != null)
                    temp = temp.right;
                p.pre = temp;
            }
            // if root has right subtree
            if (root.right != null) {
                // successor will be the leftmost in the right subtree
                Node temp = root.right;
                while (temp.left != null)
                    temp = temp.left;
                s.suc = temp;
            }
        }
        // key is less than root
        // set successor equal to root
        // search in the left subtree
        else if (key < root.key) {
            s.suc = root;
            findPreSuc(root.left, p, s, key);
        }
        // key if greater than root
        // set predecessor equal to root
        // search in the right subtree
        else {
            p.pre = root;
            findPreSuc(root.right, p, s, key);
        }
    }
}
