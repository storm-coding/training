package com.hjn.leetcode.utils;

/**
 * 链表工具类
 */
public class LinkedUtils {

    public static ListNode create(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            cur.next = node;
            cur = cur.next;
        }
        return head;
    }

    public static void  print(ListNode listNode) {
        ListNode pNode = listNode;
        while (pNode.next != null) {
            System.out.print(pNode.val + "-->");
            pNode = pNode.next;
        }
        System.out.println(pNode.val);
    }
}
