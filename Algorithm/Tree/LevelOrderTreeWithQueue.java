package com.aditya.DSA.Algorithm.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTreeWithQueue {
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
        LevelOrderTreeWithQueue lo = new LevelOrderTreeWithQueue();
        lo.createTree();
        System.out.println(lo.getLevelOrder(lo.root).toString());
    }

    /* Create a test binary tree */
    public void createTree() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.right.right = new TreeNode(8);

        /*
                     1
                  /    \
                2       3
              /  \     /  \
             4    5   6    7
                   \
                    8
         */

    }

    /* Returns ArrayList which contains the level order traversal of the tree */
    public ArrayList<Integer> getLevelOrder(TreeNode root) {
        ArrayList<Integer> levelOrder = new ArrayList<>();

        // contains discovered nodes
        Queue<TreeNode> discovered = new LinkedList<>();
        discovered.add(root);

        // while there is at least one discovered node
        while (!discovered.isEmpty()) {
            // if discovered is not empty, dequeue one item and enqueue both its children
            TreeNode current = discovered.remove();

            if (current.left != null) {
                discovered.add(current.left);
            }
            if (current.right != null) {
                discovered.add(current.right);
            }

            // process the dequeued item
            levelOrder.add(current.val);
        }
        return levelOrder;
    }
}
