package com.hjn.leetcode;

import com.hjn.leetcode.utils.LinkedUtils;
import com.hjn.leetcode.utils.ListNode;

/**
 * leetcode328
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 */
public class OddEvenLinkedList {
    /**
     * 题目意思：给定一个单向链表，把奇数节点和偶数节点组合在一起，这里我们讨论的是节点的顺序不是节点的值
     *           你应该在O(1)的空间复杂度和O(n)的时间复杂度内完成
     * 思路：    用一个链表链表存储奇数节点，一个链表用于存储偶数节点，最后将他们拼在一起
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode node1 = odd;
        ListNode node2 = even;

        int index = 1;
        while (head != null) {
            if (index % 2 == 0) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
            index++;
        }

        even.next = null;
        odd.next = node2.next;
        head = node1.next;
        return head;
    }

    public static void main(String[] args) {
        OddEvenLinkedList oe = new OddEvenLinkedList();
        ListNode node = oe.oddEvenList(LinkedUtils.create(new int[] {1,2,3,4,5}));
        LinkedUtils.print(node);
    }
}
