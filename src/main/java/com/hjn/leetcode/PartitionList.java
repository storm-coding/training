package com.hjn.leetcode;

import com.hjn.leetcode.utils.LinkedUtils;
import com.hjn.leetcode.utils.ListNode;

/**
 * leetcode 086
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */
public class PartitionList {
    /**
     * 题目意思：给定一个链表和一个数x，对链表进行划分使得比x小的都在大于或等于x的前面
     *           你应该保证两边的相对顺序不变
     * 思路：一、和题328一样
     *       二、1、首先找第一个大于等于x的节点，然后记录x的前面一个节点index。
     *           2、然后遇到下面比x小的数，追加到index后面
     *           （头节点需要特殊处理）
     */

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode index = null;
        ListNode pre = null;
        boolean isHead = false;
        while (cur != null) {
            if (cur.val >= x && index == null && !isHead) {
                index = pre;
                if (index == null) {
                    isHead = true;
                }
                pre = cur;
                cur = cur.next;
                continue;
            }
            if (isHead && cur.val < x) {
                isHead = false;
//                pre = cur;
                ListNode node = cur.next;
                pre.next = cur.next;
                cur.next = head;
//                head.next = node;
                head = cur;
                index = cur;
                cur = node;
                continue;
            }
            if (cur.val < x && index != null) {
                ListNode node = cur.next;
                cur.next = index.next;
                index.next = cur;
                index = index.next;

                pre.next = node;
                cur = node;
                continue;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        PartitionList pl = new PartitionList();
        ListNode node = pl.partition(LinkedUtils.create(new int[]{3,1,2}), 3);
        LinkedUtils.print(node);

    }
}
