package org.example.demo.utils;

import org.example.demo.arraylink.ListNode;

import java.util.Objects;

/**
 * @author lilinjun
 * @date 2023/4/26
 **/
public class ListNodeUtil {

    public static ListNode generateListNode(int n) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        //不能返回 cur , 因为它已经往下遍历了。
        return head;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
