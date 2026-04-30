/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode prevNode = dummyNode;
        ListNode currNode = head;

        while (currNode != null && currNode.next != null) {
            ListNode firstNode = currNode;
            ListNode secondNode = currNode.next;

            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prevNode = firstNode;
            currNode = firstNode.next;
        }

        return dummyNode.next;
    }
}