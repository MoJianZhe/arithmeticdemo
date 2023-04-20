package org.example.demo.arraylink;

import java.util.List;

/**
 * 反转一个单链表
 */
public class SwapLink {

    //fixme 这个会失败。
    public static ListNode reverseList(ListNode head) {
        ListNode newTail = null;
        ListNode current = head;
        while (current != null) {
            //将当前的节点翻转
            ListNode temp = current.next;
            current.next = newTail;

            //复制，下一步
            newTail = current;
            current = temp;
        }
        return newTail;
    }


    /**
     * O(n)
     * @param root 根
     * @return
     */
    public static ListNode twoPoint(ListNode root) {
        ListNode pre = null;
        ListNode cur = root;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;//下一步
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        ListNode newNode = twoPoint(head);
        ListNode newNode = reverseList(head);

        while (newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }

}



