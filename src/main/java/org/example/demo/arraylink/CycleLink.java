package org.example.demo.arraylink;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形列表，找到第一个节点。#142
 */
public class CycleLink  {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        listNode.next= node2;
        node2.next = node0;
        node0.next=node4;
        node4.next = node2;
        ListNode pos = findBy2Point(listNode);
        System.out.println(pos.val);
    }

    public static ListNode detectNode(ListNode node) {
        ListNode current = node;
        Set<ListNode> set = new HashSet<>();
        while (current != null) {
            if (set.contains(current)) {
                return current;
            } else {
                set.add(current);
            }
            current = current.next;
        }
        return null;
    }

    public static ListNode findBy2Point(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pointOne = head;
        //pointTwo 必须和pointOne 从同一起点。
//        ListNode pointTwo = head.next.next;
        ListNode pointTwo = head;
        while (pointOne != null) {
            pointOne = pointOne.next;
            if (pointTwo == null || pointTwo.next == null) {
                //有空，说明没有环
                return null;
            }
            pointTwo = pointTwo.next.next;
            if (pointOne == pointTwo) {
                //相遇点不一定是目标点，有可能是在目标点之后才相遇。
                // return pointOne;
                ListNode pos = head;
                while (pos != pointOne) {
                    pos = pos.next;
                    pointOne = pointOne.next;
                }
                return pointOne;
            }
            // 因为是同一起点，所以next的方法应该提前。
       /*     pointOne = pointOne.next;
            pointTwo = pointTwo.next.next;*/

        }
        return null;
    }


    static public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode slow = head, fast = head;
            while (fast != null) {
                slow = slow.next;
                if (fast.next != null) {
                    fast = fast.next.next;
                } else {
                    return null;
                }
                if (fast == slow) {
                    ListNode ptr = head;
                    while (ptr != slow) {
                        ptr = ptr.next;
                        slow = slow.next;
                    }
                    return ptr;
                }
            }
            return null;
        }
    }

}
