package com.hjn.leetcode;

import com.hjn.leetcode.utils.LinkedUtils;
import com.hjn.leetcode.utils.ListNode;

/**
 * leetcode 237
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 */
public class DeleteNodeInALinkedList {
    /**
     * 题目意思： 编写一个函数删除单链表的节点（除了尾部），你只能访问该节点
     * 思路：把下一个节点的值赋值给当前节点，然后将当前节点指向下下节点，
     * 因为题目说了删除的元素不包含为节点，所有不需要做非空判断
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        ListNode pre = node;
        node = node.next;
        pre.next = node.next;
    }

    public static void main(String[] args) {
        DeleteNodeInALinkedList delete = new DeleteNodeInALinkedList();
        ListNode node = LinkedUtils.create(new int[]{4, 5, 1, 9});
        delete.deleteNode(node.next);
        LinkedUtils.print(node);
    }
}
