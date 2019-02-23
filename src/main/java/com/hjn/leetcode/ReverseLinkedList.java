package com.hjn.leetcode;

import com.hjn.leetcode.utils.LinkedUtils;
import com.hjn.leetcode.utils.ListNode;

/**
 * leetcode 206
 * Reverse a singly linked list.
 */
public class ReverseLinkedList {
    /**
     * 题目意思： 反转一个链表
     * 思路：循环解法
     */
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    /**
     * 思路： 递归解法
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = head.next;
        head.next = null;
        ListNode nNode = reverseList1(next);
        next.next = cur;
        return nNode;

    }

    public static void main(String[] args) {
        ReverseLinkedList reverse = new ReverseLinkedList();
        ListNode listNode = LinkedUtils.create(new int[]{1, 2, 3, 4, 5});
        LinkedUtils.print(listNode);
        listNode = reverse.reverseList1(listNode);
        System.out.println("=======reverse========");
        LinkedUtils.print(listNode);
    }


}
