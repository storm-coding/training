package com.hjn.leetcode;

import com.hjn.leetcode.utils.LinkedUtils;
import com.hjn.leetcode.utils.ListNode;

import java.util.List;

/**
 * leetcode 092
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListII {
    /**
     * 题目意思：在一个链表中，反转m到n之间的元素，一次完成。1 ≤ m ≤ n ≤ 链表长度
     *
     * 思路： 先找到要开始反转的节点m，记录下m和m前一个节点，然后反转[m，n]之间的元素，记录下最后的节点n，
     * 最后将遍历到的节点和节点m连接，m前一个节点和n连接
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode cur = head;
        int index = 1;
        ListNode preM = null;
        ListNode nodeM = head;
        ListNode nodeN = head;

        while (index < m) {
            preM = cur;
            cur = cur.next;
            index++;
        }
        nodeM = cur;

        ListNode pre = null;
        while (index <= n) {
            nodeN = cur;
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

            index++;
        }

        nodeM.next = cur;
        if (preM != null) {
            preM.next = nodeN;
        }else {
            head = nodeN;
        }
        return head;
    }

    public static void main(String[] args) {
        ReverseLinkedListII reverse = new ReverseLinkedListII();
        ListNode listNode = LinkedUtils.create(new int[]{1,2});
        LinkedUtils.print(listNode);
        listNode = reverse.reverseBetween(listNode, 1,2);
        System.out.println("=======reverse========");
        LinkedUtils.print(listNode);
    }

}
