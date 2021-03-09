package com.paul.learning.wfh.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * A test for the {@link ReverseLinkedList}.
 */
@SpringBootTest
public class ReversedLinkedListTest {
    ReverseLinkedList reverseLinkedList;

    @BeforeEach
    public void setup() {
        reverseLinkedList = new ReverseLinkedList();
    }

    @Test
    public void basicReverseTest() {
        ListNode next = new ListNode(1);
        ListNode head = new ListNode(2, next);

        ListNode reverseListNode = reverseLinkedList.reverseList(head);
        int value = reverseListNode.val;
        Assertions.assertEquals(1, value);
    }

    @Test
    public void chainReverseTest() {
        ListNode fifth = new ListNode(5);
        ListNode fourth = new ListNode(4, fifth);
        ListNode third = new ListNode(3, fourth);
        ListNode second = new ListNode(2, third);
        ListNode first = new ListNode(1, second);

        ListNode reverseListNode = reverseLinkedList.reverseList(first);
        int value = reverseListNode.val;
        Assertions.assertEquals(5, value);
    }
}
