package com.hjn.leetcode;

import com.hjn.leetcode.utils.LinkedUtils;
import com.hjn.leetcode.utils.ListNode;

/**
 * leetcode 025
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesInKGroup {
    /**
     * 题目意思：给定一个链表，一次反转k个节点，返回修改后的链表。
     *           k是一个正整数，小于等于链表的长度，如果节点的数量不是k的倍数，那么最后剩下的节点应该保持原样。
     * 注意点：只能使用固定的空间
     *         你不能更改列表节点中的值，只能更改节点本身。
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }

        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        int length = 1;
        while (head != null) {
            if (length == k) {
                ListNode tPre = pre.next;
                head = head.next;
                reverse(pre.next, pre, k);
                pre = tPre;
                length = 1;
                continue;
            }
            head = head.next;
            length++;
        }
        return node.next;
    }

    private void reverse(ListNode node, ListNode pre, int length) {
        // 因为这里length大于1，所有node.next一定不会等于null
        while (length > 1) {
            ListNode head = pre.next;
            pre.next = node.next;
            node.next = node.next.next;
            pre.next.next = head;

            length--;
        }
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup reverse = new ReverseNodesInKGroup();
        ListNode node = reverse.reverseKGroup(LinkedUtils.create(new int[]{1, 2, 3, 4, 5, 6}), 2);
        LinkedUtils.print(node);
    }
}
