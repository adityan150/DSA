package com.aditya.DSA.Algorithm;

import java.util.*;

public class VerticalOrderTreeSorted {
    TreeNode root;

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    private class Tuple {
        int hLevel;  // horizontal level of the node in tree
        int vLevel;  // vertical level of the node in tree
        TreeNode node;

        public Tuple(TreeNode node, int hLevel, int vLevel) {
            this.hLevel = hLevel;
            this.vLevel = vLevel;
            this.node = node;
        }
    }

    public static void main(String[] args) {
//        VerticalOrderTreeSorted vo = new VerticalOrderTreeSorted();
//        vo.createTree();
//        System.out.println(vo.getVerticalOrder(vo.root).toString());

    }

    /* Create a test binary tree */
    public void createTree() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        root.left.right.right = new TreeNode(8);
        root.left.right.right.left = new TreeNode(9);

        /*
                      1
                  /       \
                 2         3
              /    \     /    \
             4      6   5      7
                      \
                       --- 8
                         /
                       9

         */

    }



}
