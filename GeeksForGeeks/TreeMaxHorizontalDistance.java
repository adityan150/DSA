package com.aditya.DSA.GeeksForGeeks;


public class TreeMaxHorizontalDistance {
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
        TreeMaxHorizontalDistance td = new TreeMaxHorizontalDistance();

        td.createTree();
        System.out.println(td.getMaxHorizontal());
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

    public int getMaxHorizontal() {
        int[] endPoints = getEndPoints(root, 0);
        return Math.abs(endPoints[0]) + Math.abs(endPoints[1]) - 1;
    }

    public int[] getEndPoints(TreeNode root, int pos) {
        if (root == null) {
            return new int[] {0, 0};
        }

        int[] leftSubEnds = getEndPoints(root.left, pos-1);
        int[] rightSubEnds = getEndPoints(root.right, pos+1);

        int[] ends = new int[2];
        ends[0] = pos + Math.min(leftSubEnds[0], rightSubEnds[0]);
        ends[1] = pos + Math.max(leftSubEnds[1], rightSubEnds[1]);

        return ends;
    }
}
