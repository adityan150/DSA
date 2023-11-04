package Algorithm.Tree;

//    public class TreeNode {
//        int val;
//        TreeNode left, right;
//        TreeNode(int val) {
//            this.val = val;
//            left = right = null;
//        }
//    }

import Data_Structures.TreeNode;

import java.util.Stack;

public class Inorder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Inorder obj = new Inorder();
        System.out.println("Recursive: ");
        obj.traverseRecursive(root);
        System.out.println("\nIterative: ");
        obj.traverseIterative(root);
    }

    void traverseRecursive(TreeNode root) {
        if (root == null)
            return;

        traverseRecursive(root.left);
        System.out.print(root.val + ", ");
        traverseRecursive(root.right);
    }

    void traverseIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val + ", ");
            root = root.right;
        }
        System.out.println();
    }
}
