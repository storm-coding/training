package com.hjn.leetcode;

import com.hjn.leetcode.utils.LinkedUtils;
import com.hjn.leetcode.utils.ListNode;

/**
 * leetcode 019
 * Given a linked list, remove the n-th node from the end of list and return its head.
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * 题目意思： 给定一个链表，删除倒数第n个节点，返回链表的头节点
     *
     * 思路：从链表都保持一个n大的窗口，然后两个节点同时往后移，
     * 直到窗口后一个节点到达末尾，那么前一个节点就是需要删除的节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;
        while (n > 1) {
            end = end.next;
            n--;
        }

        ListNode node = new ListNode(0);
        ListNode pre = node;
        node.next = head;
        while (end.next != null) {
            end = end.next;
            pre = head;
            head = head.next;
        }
        pre.next = head.next;
        return node.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList remove = new RemoveNthNodeFromEndOfList();
        ListNode node = remove.removeNthFromEnd(LinkedUtils.create(new int[] {1}),1);
        LinkedUtils.print(node);
    }
}
