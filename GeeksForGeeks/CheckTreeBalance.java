package com.aditya.DSA.GeeksForGeeks;

public class CheckTreeBalance {
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
        CheckTreeBalance chk = new CheckTreeBalance();
        chk.createTree();
        System.out.println(chk.isBalanced(chk.root));
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
         */
    }

    boolean isBalanced(TreeNode root)
    {
        // check for empty tree
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // difference between left height and right height
        int heightDif = Math.abs(leftHeight - rightHeight);

        if (heightDif <= 1
                && isBalanced(root.left)
                && isBalanced(root.right) ) {
            // if height difference is no more than 1
            // and left and right subtrees are balanced
            return true;
        }

        return false;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
