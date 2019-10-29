package com.leetcode.easy;

/**
 * 206. Reverse Linked List
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode rverseHead = new ListNode(head.val);
        reverseList(head, rverseHead);
        return rverseHead;

    }

    private ListNode reverseList(ListNode head, ListNode rverseHead) {
        if (head.next != null) {
            ListNode currNode = reverseList(head.next, rverseHead);
            currNode.next = new ListNode(head.val);
            return currNode.next;
        } else {
            rverseHead.val = head.val;
            return rverseHead;
        }
    }
}

