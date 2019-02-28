package com.hjn.leetcode;

import com.hjn.leetcode.utils.LinkedUtils;
import com.hjn.leetcode.utils.ListNode;

/**
 * leetcode 147
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {
    /**
     * 题目意思： 对一个链表使用插入排序
     *
     * 思路： 记录下链表的头节点，然后对每个遍历到的当前节点，都从头遍历，
     * 寻找是不是存在比当前小的元素，存在则交换，反之则遍历下一个元素
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode node = new ListNode(0);
        ListNode start = node;
        ListNode pre = node;
        node.next = head;
        boolean swap = false;

        while (head != null) {
            swap = false;
            while (start.next != null) {
                if (start.next == head) {
                    start = node;
                    break;
                }
                if (start.next.val > head.val) {
                    ListNode next = head.next;
                    head.next = start.next;
                    start.next = head;
                    pre.next = next;

                    head = next;
                    start = node;
                    swap = true;
                    break;
                }

                start = start.next;
            }
            if (!swap) {
                pre = head;
                head = head.next;
            }
        }
        return node.next;
    }

    public static void main(String[] args) {
        InsertionSortList is = new InsertionSortList();
        ListNode node = is.insertionSortList(LinkedUtils.create(new int[]{3,4,1}));
        LinkedUtils.print(node);
    }
}
