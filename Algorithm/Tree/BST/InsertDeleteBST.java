package Algorithm.Tree.BST;
import Data_Structures.TreeNode;

//public class TreeNode {
//    public int val;
//    public Data_Structures.TreeNode left, right;
//
//    public TreeNode(int val) {
//        this.val = val;
//    }
//}


public class InsertDeleteBST {
    public TreeNode insert(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        TreeNode current = root;
        TreeNode previous = null;

        while (current != null) {
            previous = current;

            if (current.val < val)
                current = current.right;
            else
                current = current.left;
        }

        if (previous.val < val)
            previous.right = new TreeNode(val);
        else
            previous.left = new TreeNode(val);

        return root;
    }

    public TreeNode delete(TreeNode root, int val) {
        if (root == null)
            return null;

        TreeNode previous = null;
        TreeNode current = root;

        while (current != null) {
            if (current.val == val)
                break;

            previous = current;
            if (current.val < val)
                current = current.right;
            else
                current = current.left;
        }

        if (current == null)    // not found
            return root;

        TreeNode newNode = deleteUtil(current);
        if (previous == null)
            return newNode;
        else if (previous.left != null && previous.left.val == val)
            previous.left = newNode;
        else
            previous.right = newNode;

        return root;
    }

    TreeNode deleteUtil(TreeNode current) {
        // case 1 : current is only node in the tree, return null
        if (current.left == null && current.right == null)
            return null;

        // case 2 : current has only left child, make the left child as root
        else if (current.right == null) {
            TreeNode newRoot = current.left;
            current.left = null;
            return newRoot;
        }

        // case 3 : current has only right child, make the right child as root
        else if (current.left == null) {
            TreeNode newRoot = current.right;
            current.right = null;
            return newRoot;
        }

        // case 4: current.right has no left child, make current.right as root
        else if (current.right.left == null) {
            TreeNode newRoot = current.right;
            newRoot.left = current.left;
            current.right = null;
            current.left = null;
            return newRoot;
        }

        // case 5: else find the left most child of current.right subtree and make it as root
        TreeNode previous = null;
        TreeNode leftChild = current.right;

        while (leftChild.left != null) {
            previous = leftChild;
            leftChild = leftChild.left;
        }

        previous.left = leftChild.right;
        leftChild.right = current.right;
        leftChild.left = current.left;
        return leftChild;
    }
}
