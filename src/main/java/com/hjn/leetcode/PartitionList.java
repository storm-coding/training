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
     */

    public ListNode partition(ListNode head, int x) {
        ListNode index = null;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;

        while (head != null) {
            if (head.val >= x && index == null ) {
                index = pre;
                pre = head;
                head = head.next;
                continue;
            }

            if (head.val < x && index != null) {
                ListNode t = head.next;
                head.next = index.next;
                index.next = head;
                index = index.next;

                pre.next = t;
                head = t;
                continue;
            }
            pre = head;
            head = head.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        PartitionList pl = new PartitionList();
        ListNode node = pl.partition(LinkedUtils.create(new int[]{3,1,2}), 3);
        LinkedUtils.print(node);

    }
}
