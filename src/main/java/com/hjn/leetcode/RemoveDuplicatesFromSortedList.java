package com.hjn.leetcode;

import com.hjn.leetcode.utils.LinkedUtils;
import com.hjn.leetcode.utils.ListNode;

import java.util.List;

/**
 * leetcode 083
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * 题目意思： 给定一个排序好的数组，删除所有的重复的元素，使得每个元素只出现一次
     *
     * 思路： 遍历链表，保存遍历的当前节点，每个元素一次比较当前节点是不是和前面节点相等，相等则删除
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (pre.val == cur.val) {
                ListNode next = cur.next;
                pre.next = next;
                cur = next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList rd = new RemoveDuplicatesFromSortedList();
        ListNode node = LinkedUtils.create(new int[]{1, 1, 2});
        node = rd.deleteDuplicates(node);
        LinkedUtils.print(node);
    }
}
