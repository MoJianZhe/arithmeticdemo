package org.example.demo.arraylink;

import org.example.demo.utils.ListNodeUtil;

/**
 * @author linjun
 * @date 2023/4/26
 * 删除节点
 **/
public class DeleteNode {

    public static void main(String[] args) {
        ListNode node = ListNodeUtil.generateListNode(5);
        ListNodeUtil.printListNode(node);

        System.out.println("删除后");
        ListNodeUtil.printListNode(deleteNode(node, 0));
    }


    /**
     * 虚拟一个节点，就可以不用考虑头结点这种复杂的情况了。
     */
    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur != null) {
            ListNode next = cur.next;
            if (next != null) {
                if (next.val == val) {
                    cur.next = next.next;
                }
            }
            cur = cur.next;
        }
        return dummyNode.next;
    }
}
