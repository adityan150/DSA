package com.aditya.DSA.GeeksForGeeks;

import com.aditya.DSA.Algorithm.LevelOrderTraversalTree;

import java.util.ArrayList;

public class ZigZagTree {
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

    public static void main(String[] args) {
        ZigZagTree zz = new ZigZagTree();
        zz.createTree();
        System.out.println(zz.getZigZag(zz.root).toString());
    }
    public void createTree() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.right.left.right = new TreeNode(8);
        root.right.left.right.right = new TreeNode(9);
        root.right.left.right.right.right = new TreeNode(10);

        /*
                    1
                  /    \
                2       3
              /  \     /  \
             4    5   6    7
                       \
                        8
                         \
                          9
                           \
                            10
         */
    }

    // returns zigzag traversal of the tree as ArrayList
    public ArrayList<Integer> getZigZag(TreeNode root) {
        int height = getHeight(root);
        ArrayList<Integer> zigZag = new ArrayList<>();

        // get level order from level 1 to height of the tree
        for (int i = 1; i <= height; i++) {
            ArrayList<Integer> levelNodes;

            if (i % 2 == 0) {
                // if level is even, get reverse level order (R to L)
                levelNodes = getReverseLevel(root, i);
            }
            else {
                // if level is odd, get level order (L to R)
                levelNodes = getLevel(root, i);
            }
            // add the level order in the zigZag list for all levels
            zigZag.addAll(levelNodes);
        }

        return zigZag;
    }

    public ArrayList<Integer> getLevel(TreeNode root, int level) {
        ArrayList<Integer> levelNodes = new ArrayList<>();

        if (level == 0 || root == null) {
            return levelNodes;
        }
        else if (level == 1) {
            levelNodes.add(root.val);
        }

        // level nodes from left to right

        // left
        levelNodes.addAll(getLevel(root.left, level-1));
        // right
        levelNodes.addAll(getLevel(root.right, level-1));

        return levelNodes;
    }

    public ArrayList<Integer> getReverseLevel(TreeNode root, int level) {
        ArrayList<Integer> levelNodes = new ArrayList<>();

        if (level == 0 || root == null) {
            return levelNodes;
        }
        else if (level == 1) {
            levelNodes.add(root.val);
        }

        // level nodes from right to left

        // right
        levelNodes.addAll(getReverseLevel(root.right, level-1));
        // left
        levelNodes.addAll(getReverseLevel(root.left, level-1));

        return levelNodes;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        }
        else {
            return rightHeight + 1;
        }
    }
}
