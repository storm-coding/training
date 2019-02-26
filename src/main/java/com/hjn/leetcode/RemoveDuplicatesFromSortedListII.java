package com.hjn.leetcode;

import com.hjn.leetcode.utils.LinkedUtils;
import com.hjn.leetcode.utils.ListNode;

/**
 * leetcode 082
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 */
public class RemoveDuplicatesFromSortedListII {
    /**
     * 题目意思： 给定排好序的链表，删除所有有重复的节点，只留下原始表不同值的节点。
     *
     * 思路： 1、创建一个虚拟节点，指向head
     *        2、用一个节点保存遍历当前的前面一个节点，和保存最后一个重复的值lastVal
     *        3、遍历节点，比较当前节点和当前节点的下一个节点的值是不是相等，相等则删除
     *        4、否则查看当前节点的值和lastVal的值是不是相等，相等则删除
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        Integer lastVal = null;

        while (head != null) {
            if(head.next != null) {
                if (head.val == head.next.val) {
                    head.next = head.next.next;
                    lastVal = head.val;
                    continue;
                }
            }
            if(lastVal!=null && head.val == lastVal) {
                head = head.next;
                pre.next = head;
                continue;
            }
            pre = head;
            head = head.next;
        }

        return node.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII remove = new RemoveDuplicatesFromSortedListII();
        ListNode node = remove.deleteDuplicates(LinkedUtils.create(new int[] {1,2,3,3,4,4,5}));
        LinkedUtils.print(node);
    }
}
