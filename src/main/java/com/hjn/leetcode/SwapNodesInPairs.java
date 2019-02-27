package com.hjn.leetcode;

import com.hjn.leetcode.utils.LinkedUtils;
import com.hjn.leetcode.utils.ListNode;

/**
 * leetcode 024
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class SwapNodesInPairs {
    /**
     * 题目意思： 给定一个链表，交换没相邻的两个节点然后返回它的头节点。你不能修改node的值，只能修改节点本身
     *
     * 思路：设置一个虚拟节点指向链表head，然后遍历每两两一组进行交换
     */
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;

        while (head != null && head.next != null) {
            ListNode next = head.next.next;
            pre.next = head.next;
            head.next.next = head;
            head.next = next;
            pre = head;
            head = head.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs swap = new SwapNodesInPairs();
        ListNode node = swap.swapPairs(LinkedUtils.create(new int[] {1,2,3,4}));
        LinkedUtils.print(node);
    }
}
