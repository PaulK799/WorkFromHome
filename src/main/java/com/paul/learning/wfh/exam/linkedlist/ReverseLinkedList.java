package com.paul.learning.wfh.exam.linkedlist;

import com.paul.learning.wfh.exam.linkedlist.ListNode;

public class ReverseLinkedList {

    /**
     * Reverses a singly-linked list.
     *
     * @param head - The {@link ListNode} to be processed.
     * @return The new head of the {@link ListNode}.
     */
    public ListNode reverseList(ListNode head) {
        ListNode prevHead = null;
        // Iterate until end of ListNode
        while (head != null) {
            // Extract Next ListNode.
            ListNode next = head.next;
            // Replace next pointer to head.
            head.next = prevHead;
            prevHead = head;
            // Swap Next with Head.
            head = next;
        }
        return prevHead;
    }
}
