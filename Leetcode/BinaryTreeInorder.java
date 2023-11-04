package Leetcode;
import Data_Structures.TreeNode;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class BinaryTreeInorder {
    public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> inOrder = new ArrayList<>();
        Stack<TreeNode> S = new Stack<>();

        TreeNode current = root;

        while (current != null || !S.isEmpty()) {
            while (current != null) {
                S.push(current);
                current = current.left;
            }
            current = S.pop();
            inOrder.add(current.val);
            current = current.right;
        }
        return inOrder;
    }

}
