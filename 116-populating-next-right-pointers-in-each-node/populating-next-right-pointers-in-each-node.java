
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        
        Node head = root;
        while (root.left != null) {
            Node cur = root;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            root = root.left;
        }
        
        return head;
    }
}
