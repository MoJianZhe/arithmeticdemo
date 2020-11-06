package org.example.demo.arraylink;

import org.omg.CORBA.INTERNAL;

/**
 * 跳跃表
 * @author jun
 */
public class SkipList<K extends Comparable,V> {


    private final Node head;

    private final Node tail;

    SkipList() {
        //final 初始化之后不能再赋值
        head = new Node(null, null);
        tail = new Node(null, null);
        head.right = tail;
        tail.left = head;
    }

    class  Node{
        K key;
        V value;
        Node right;
        Node left;
        Node up;
        Node down;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 返回表中的最近值。
     * @param key
     * @return
     */
    public V get(K key) {
        Node node = findNode(key);
        if (node.key.equals(key)) {
            return node.value;
        }
        return null;
    }

    private Node findNode(K key) {
        Node current = head.right;
        while (current != null && current != tail) {
            if (current.key.compareTo(key) < 0) {
                current = current.right;
            } else {
                if (current.down != null) {
                    current = current.down;
                } else {
                    break;
                }
            }
        }
        return current;
    }

    public void put(K key, V val) {

    }


}
