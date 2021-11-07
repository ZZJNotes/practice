package com.list;

import java.util.Stack;

/**
 * @Author zzj
 * @Date 2021/6/2 17:41
 * @Description 如何实现一个高效的单向链表逆序输出？
 */

public class reverseList {

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode currentNode = head;
        Stack<ListNode> listNodeStack = new Stack<>();
        while (currentNode != null) {
            listNodeStack.push(currentNode);
            ListNode tempNode = currentNode.next;
            currentNode.next = null;
            currentNode = tempNode;
        }
        head = listNodeStack.pop();
        currentNode = head;
        while (!listNodeStack.isEmpty()) {
            currentNode.next = listNodeStack.pop();
            currentNode = currentNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        ListNode<Integer> tempNode = head;

        while (tempNode.next != null) {
            System.out.print(tempNode.val + "->");
            tempNode = tempNode.next;
        }
        System.out.print(tempNode.val);
        System.out.println();

        head = reverse(head);
        while (head.next != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print(head.val);

    }
}

class ListNode<T> {
    T val;
    ListNode<T> next;

    ListNode(T val){
        this.val  = val;
    }
}