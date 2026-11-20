package Easy_Level;

public class ReverseLinkedList {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static ListNode solve(ListNode head) {
//        if (head == null) return null;
//        ListNode prev = null;
//        ListNode curr = head;
//        ListNode nextNode = curr.next;
//
//        while (nextNode != null) {
//            curr.next = prev;
//            prev = curr;
//            curr = nextNode;
//            nextNode = nextNode.next;
//        }
//        curr.next = prev;
//        return curr;

// Reverse a singly linked list by iterating through all nodes.
// Maintain three pointers:
// prev -> stores the previous node
// curr -> stores the current node
// next -> temporarily stores the next node before changing links
// For each node, reverse its next pointer to point to the previous node.
// After processing all nodes, prev will point to the new head of the reversed list.
// Return prev as the head of the reversed linked list.
        if (head == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
