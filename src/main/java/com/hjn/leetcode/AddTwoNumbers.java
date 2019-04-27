package com.hjn.leetcode;

import com.hjn.leetcode.utils.LinkedUtils;
import com.hjn.leetcode.utils.ListNode;
import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {
    /**
     * 题目意思： 给定两个非空的链表，表示两个正数。这些数字以相反顺序存储。每个节点只包含一个数字。
     *            把这两个数字相反返回这个数字的列表形式。
     *            你可以假定两个数字除了0之外前面都不包含0
     *
     * 思路： 这里不能先将两个数l1,l2转成数字类型，因为测试数据的规模比long还要大。
     *        1、从l1和l2的头部开始遍历，每次只处理相应的哪一位相加即可，
     *        2、在l1和l2中，遍历还未使用完的那个
     *        这个思路类似归并排序的merge操作
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = null;
        ListNode result = null;
        while (l1 != null && l2 != null) {
            int v = l1.val + l2.val;
            l1 = l1.next;
            l2 = l2.next;
            if (node == null) {
                if (v >= 10) {
                    node = new ListNode(v % 10);
                    node.next = new ListNode(v / 10);
                } else {
                    node = new ListNode(v);
                }
                result = node;
            }else {
                appendNode(node, v);
                node = node.next;
            }
        }

        if (l1 != null) {
            while (l1 != null) {
                appendNode(node,l1.val);
                l1 = l1.next;
                node = node.next;
            }
        }
        if (l2 != null) {
            while (l2 != null) {
               appendNode(node,l2.val);
                l2 = l2.next;
                node = node.next;
            }
        }
        return result;
    }

    public void appendNode(ListNode node, int v) {
        if (node.next != null) {
            v += node.next.val;
            if (v >= 10) {
                node.next = new ListNode(v % 10);
                node = node.next;
                node.next = new ListNode(v / 10);
            } else {
                node.next = new ListNode(v);
            }
        } else {
            if (v >= 10) {
                node.next = new ListNode(v % 10);
                node = node.next;
                node.next = new ListNode(v / 10);
            } else {
                node.next = new ListNode(v);
            }
        }
    }

// 转成数字的类型操作，会发生溢出
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        if (l1 == null || l2 == null) {
//            return null;
//        }
//        long n1 = listNodeToNum(l1);
//        long n2 = listNodeToNum(l2);
//        return numToListNode((long) n1 + (long) n2);
//    }
//
//    private long listNodeToNum(ListNode node) {
//        if (node.next == null) {
//            return node.val;
//        } else {
//            return listNodeToNum(node.next) * 10 + node.val;
//        }
//    }
//
//    private ListNode numToListNode(long n) {
//        ListNode node = new ListNode((int) (n % 10));
//        ListNode result = node;
//        if (n == 0) {
//            return node;
//        }
//        n /= 10;
//        while (n > 0) {
//            node.next = new ListNode((int) (n % 10));
//            node = node.next;
//            n /= 10;
//        }
//        return result;
//    }

    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode node1 = LinkedUtils.create(new int[]{2,4,3});
        ListNode node2 = LinkedUtils.create(new int[]{5,6,4});
        LinkedUtils.print(atn.addTwoNumbers(node1, node2));
    }

}
