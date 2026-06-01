/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node iter = head;
        while (iter != null) {
            Node copy = new Node(iter.val);
            copy.next = iter.next;
            iter.next = copy;
            iter = copy.next;
        }
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }
        Node pseudoHead = new Node(0);
        Node copyIter = pseudoHead;
        iter = head;
        while (iter != null) {
            Node copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;
            iter.next = copy.next;
            iter = iter.next;
        }
        return pseudoHead.next;
    }
}