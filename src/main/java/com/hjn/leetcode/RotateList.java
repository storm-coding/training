package com.hjn.leetcode;

import com.hjn.leetcode.utils.LinkedUtils;
import com.hjn.leetcode.utils.ListNode;

/**
 * leetcode 061
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 */
public class RotateList {
    /**
     * 题目意思： 给定一个链表，旋转链表的最后k个节点，k是一个非负整数
     *
     * 思路：  1、计算出整个链表的长度
     *         2、将k模除链表的长度
     *         3、保持一个长度为k的窗口遍历链表
     *         4、当有边界滑倒末尾时开始旋转链表
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        // 获取链表的长度
        ListNode end = head;
        int length = 0;
        while (end != null) {
            end = end.next;
            length++;
        }
        end = head;
        // k有可能是大于链表长度的，或者是恰好是k的整数倍
        if (k >= length) {
            k = k % length;
            if (k == 0) {
                return head;
            }
        }
        // 获取长度k的窗口
        while (k > 1 && end.next != null) {
            end = end.next;
            k--;
        }

        ListNode node = new ListNode(0);
        ListNode pre = node;
        ListNode preHead = node;
        node.next = head;
        while (end.next != null) {
            preHead = head;
            head = head.next;
            end = end.next;
        }
        // 旋转链表
        while (head != null) {
            ListNode next = head.next;

            head.next = pre.next;
            pre.next = head;
            pre = head;
            preHead.next = next;
            head = next;
        }

        return node.next;
    }

    public static void main(String[] args) {
        RotateList rotate = new RotateList();
        ListNode node = rotate.rotateRight(LinkedUtils.create(new int[]{1,2,3,4,5}), 2);
        LinkedUtils.print(node);
    }
}
