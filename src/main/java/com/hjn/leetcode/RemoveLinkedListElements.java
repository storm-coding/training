package com.hjn.leetcode;

import com.hjn.leetcode.utils.LinkedUtils;
import com.hjn.leetcode.utils.ListNode;

/**
 * leetcode203
 * Remove all elements from a linked list of integers that have value val.
 */
public class RemoveLinkedListElements {
    /**
     * 题目意思： 从一个链表中删除所有等于val的值
     *
     * 思路：设定一个虚拟头节点，指向给定的链表，然后遍历链表
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        while (head != null) {
            if ( head.val == val) {
                pre.next = head.next;
                head.next = null;
            }else {
                pre = head;
            }
            head = pre.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements rl = new RemoveLinkedListElements();
        ListNode node = rl.removeElements(LinkedUtils.create(new int[]{1,2,6,3,4,5,6}), 6);
        LinkedUtils.print(node);
    }
}
