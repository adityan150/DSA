package GeeksForGeeks;

public class PopulateInorderSuc {

    private class Node {
        int data;
        Node left, right,next;

        public Node(int data){
            this.data = data;
        }
    }

    public void populateNext(Node root){
        Node pre;
        Node cur = root;

        // morris traversal
        while (cur != null) {
            if (cur.left != null) {
                Node ln = cur.left;

                while (ln.right != null && ln.right != cur) {
                    ln = ln.right;
                }
                if (ln.right == cur) {
                    // left subtree already visited
                    ln.right = null;
                    pre = cur;
                    cur = cur.right;
                    pre.next = cur;
                }
                else {
                    // left subtree not yet visited
                    cur = cur.left;
                }
            }
            else {
                pre = cur;
                cur = cur.right;
                pre.next = cur;
            }
        }
    }
}
