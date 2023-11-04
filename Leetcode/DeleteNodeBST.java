package Leetcode;

import Data_Structures.TreeNode;

public class DeleteNodeBST {

    // deletes the node with given element
    public TreeNode deleteNode(TreeNode root, int target) {
        if (root == null)
            return null;
        else if (root.val > target)
            root.left = deleteNode(root.left, target);
        else if (root.val < target)
            root.right = deleteNode(root.right, target);

        else {
            // root.val == target

            // case I : no children
            if (root.left == null && root.right == null)
                return null;
                // case II : one child
            else if (root.left == null)
                root = root.right;
            else if (root.right == null)
                root = root.left;
                // case III : two children
            else {
                // set current node to minimum value in the right subtree
                // recursively delete the copied node in the right subtree
                root.val = findMin(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    // return the minimum value in the tree
    int findMin(TreeNode root) {
        if (root.left != null) {
            return findMin(root.left);
        }
        return root.val;
    }
}

