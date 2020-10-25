package org.example.demo.arraylink;

/**
 * 反转一个单链表
 */
public class SwapLink {

    public static ListNode reverseList(ListNode head) {
        ListNode newTail = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = newTail;
            newTail = current;
            current = temp;
        }
        return newTail;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode newNode = reverseList(head);
        while (newNode.next != null) {
            System.out.println(newNode.val);
        }
    }

}



