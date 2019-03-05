package com.hjn.leetcode;

import com.hjn.leetcode.utils.LinkedUtils;
import com.hjn.leetcode.utils.ListNode;

/**
 * leetcode 143
 * .
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You may not modify the values in the list's nodes, only nodes itself may be changed
 */
public class ReorderList {
    /**
     * 题目意思： 给定一个单链表L: L0→L1→…→Ln-1→Ln,让它重新这样排序： L0→Ln→L1→Ln-1→L2→Ln-2→…
     * 你不能修改节点中的值，只能修改节点本身
     *
     * 思路：1、首先计算出链表的长度
     *       2、计算出需要反转的长度
     *       3、使用双重循环，每次将节点的最后一个元素进行反转
     *       总结：这是最先想到的思路，时间复杂度为O(n2),在leetcode上没有超时
     *       下面的两种是在leetcode上参考的其他答案
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        node = head;

        int half = 1;
        while (half < length / 2) {
            half++;
            node = node.next;
        }

        ListNode mid = node;
        if(length%2==1) {
            mid = node.next;
        }
        node = head;
        while (node != mid) {
            ListNode end = mid;
            ListNode pre = mid;
            while (end.next != null) {
                pre = end;
                end = end.next;
            }
            ListNode next = node.next;
            node.next = end;
            end.next = next;
            node = next;
            pre.next = null;
        }
    }

    // public void reorderList(ListNode head) {
//         if(head==null||head.next==null) return;

//             //Find the middle of the list
//             ListNode p1=head;
//             ListNode p2=head;
//             while(p2.next!=null&&p2.next.next!=null){
//                 p1=p1.next;
//                 p2=p2.next.next;
//             }

//             //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
//             ListNode preMiddle=p1;
//             ListNode preCurrent=p1.next;
//             while(preCurrent.next!=null){
//                 ListNode current=preCurrent.next;
//                 preCurrent.next=current.next;
//                 current.next=preMiddle.next;
//                 preMiddle.next=current;
//             }

//             //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
//             p1=head;
//             p2=preMiddle.next;
//             while(p1!=preMiddle){
//                 preMiddle.next=p2.next;
//                 p2.next=p1.next;
//                 p1.next=p2;
//                 p1=p2.next;
//                 p2=preMiddle.next;
//             }
//     }



    public void reorderList1(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        reconnect(head, head);
    }
    private ListNode reconnect(ListNode slow, ListNode fast) {
        if (fast.next == null) {
            return slow;
        }
        if (fast.next.next == null) {
            return slow.next;
        }
        ListNode tail = reconnect(slow.next, fast.next.next);
        ListNode tailN = tail.next;
        if (tailN == null) return tail;
        ListNode tailNN = tailN.next;
        ListNode slowN = slow.next;
        slow.next = tailN;
        tailN.next = slowN;
        tail.next = tailNN;
        return tail;
    }

    public void reorderList2(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode leftTail = findMid(head);
        ListNode rightHead = leftTail.next;
        leftTail.next = null;

        ListNode newRightHead = reverse(rightHead);

        merge(head, newRightHead);
    }

    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    private void merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (a != null && b != null) {
            tail.next = a;
            a = a.next;
            tail = tail.next;
            tail.next = b;
            b = b.next;
            tail = tail.next;
        }

        if (a != null) {
            tail.next = a;
        } else {
            tail.next = b;
        }
    }

    public static void main(String[] args) {
        ReorderList reorder = new ReorderList();
        ListNode node = LinkedUtils.create(new int[]{1, 2, 3, 4, 5});
        reorder.reorderList(node);
        LinkedUtils.print(node);
    }
}
