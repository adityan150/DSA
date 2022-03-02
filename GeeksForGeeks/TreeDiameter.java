package com.aditya.DSA.GeeksForGeeks;

import com.aditya.DSA.Algorithm.MorrisTraversal;

public class TreeDiameter {
    TreeNode root;
    int maxDiameter;

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
        TreeDiameter td = new TreeDiameter();
        td.createTree();
        System.out.println(td.getDiameter(td.root));
    }

    public void createTree() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        /*
                    1
                  /    \
                2       3
              /  \     /  \
             4    5   6    7
         */
    }

    public int getDiameter(TreeNode root) {
        maxDiameter = 0;
        height(root);
        return maxDiameter;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int subtreeDia = leftHeight + rightHeight + 1;

        if (subtreeDia > maxDiameter) {
            maxDiameter = subtreeDia;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
