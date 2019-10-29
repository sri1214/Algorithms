package com.leetcode.medium;

/**
 * 19. Remove Nth Node From End of List
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * <p>
 * Follow up:
 * Could you do this in one pass?
 */
public class RemoveNthNode {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0 || head.next == null) return null;
        int size = 1;
        ListNode temp1 = head;
        ListNode temp2 = head;
        while (temp1.next != null) {
            size++;
            temp1 = temp1.next;
        }
        if (size == n) return head.next;
        for (int i = 1; i < size - n; i++) {
            temp2 = temp2.next;
        }
        temp2.next = temp2.next.next;

        return head;
    }

    public ListNode removeNthFromEndInOnePass(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode node1 = head;
        ListNode node2 = null;
        int i = 0;
        do {
            if (++i > n) {
                if (node2 != null) node2 = node2.next;
                else node2 = head;
            }
            node1 = node1.next;
        } while (node1 != null);
        if (i == n) return head.next;
        node2.next = node2.next.next;
        return head;

    }

}


