package Data_Structures;

import java.util.Stack;

public class BinaryTreeTraversal extends BinaryTree{
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);

        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        tree.root.left.left.left = new TreeNode(8);
        tree.root.left.right.right = new TreeNode(9);

        tree.root.right.left.left = new TreeNode(10);
        tree.root.right.left.left.right = new TreeNode(11);
        /*
                     1
                  /     \
                2        3
              /  \      /  \
             4    5    6    7
            /      \  /
           8       9  10
                       \
                       11
         */

        System.out.println("\nInorder: ");
        printInOrder(tree.root);
        System.out.println("\nPre order: ");
        printPreOrder(tree.root);
        System.out.println("\nPost order: ");
        printPostOrder(tree.root);
        System.out.println("\nInorder without recursion: ");
        inOrderStack(tree.root);
        System.out.println("\nPreOrder without recursion: ");
        preOrderStack(tree.root);
        System.out.println("\nPost order without recursion: ");
        postOrderStack(tree.root);
    }

    static void printInOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        // left root right
        printInOrder(treeNode.left);
        System.out.print(treeNode.val + " ");
        printInOrder(treeNode.right);
    }

    static void printPreOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        // root left right
        System.out.print(treeNode.val + " ");
        printPreOrder(treeNode.left);
        printPreOrder(treeNode.right);
    }

    static void printPostOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        // left right root
        printPostOrder(treeNode.left);
        printPostOrder(treeNode.right);
        System.out.print(treeNode.val + " ");
    }

    /*
    In-order: left root right
    Step 1: push the current treeNode on stack and set current to current.left, reach left most treeNode
    Step 2: if current = null, pop element and set current = current.right
    Step 3: if current = null and stack is empty, exit
     */
    static void inOrderStack(TreeNode treeNode) {
        Stack<TreeNode> S = new Stack<>();

        TreeNode current = treeNode;

        while (current != null || !S.isEmpty()) {
            while (current != null) {
                S.push(current);
                current = current.left;
            }
            current = S.pop();
            System.out.print(current.val + " ");
            current = current.right;
        }
    }

    /*
    Pre-Order: Root left right
    Step 1: Print current treeNode, push it onto the stack, set current = current.left, reach left most treeNode
    Step 2: Pop an element from stack, set current = current.right
    Step 3: if current is null and stack is empty, exit
     */
    static void preOrderStack(TreeNode treeNode) {
        Stack<TreeNode> S = new Stack<>();

        TreeNode current = treeNode;

        while (current != null || !S.isEmpty()) {

            while (current != null) {
                System.out.print(current.val + " ");
                S.push(current);
                current = current.left;
            }
            current = S.pop();
            current = current.right;
        }
    }

    /*
    Post order: left right root
    Step 1: If current treeNode has a right child, push it first, then push current on the stack,
            set current = current.left, reach left most treeNode
    Step 2: Set current = popped element from stack
    Step 3: if current has a right child AND stack is not empty AND current.right is at top of stack
            pop treeNode from top of stack
            push current on the stack
            set current = popped treeNode
    Step 4: else print current and set current to null
     */
    static void postOrderStack(TreeNode root) {
        Stack<TreeNode> S = new Stack<>();
        TreeNode current = root;

        while (current != null || !S.isEmpty()) {
            // go to left most treeNode in current subtree
            while (current != null) {
                // push right child on stack
                if (current.right != null) S.push(current.right);
                // push current
                S.push(current);
                // move to left child
                current = current.left;
            }
            // current is/becomes null
            // pop item from stack
            current = S.pop();

            // if popped treeNode's right subtree is unprocessed
            // if right child of current is still in stack
            if (!S.isEmpty() && current.right != null && current.right == S.peek()) {
                // pop the right child to process it
                // push the current/parent treeNode on stack to process later
                TreeNode temp = S.pop();
                S.push(current);
                current = temp;
            }
            else {
                // right child is already processed
                // add the current treeNode to result list
                // left subtree is processed or does not have a left child
                // set current to null to skip moving to left subtree in next iteration
                System.out.print(current.val + " ");
                current = null;
            }
        }
    }
}
