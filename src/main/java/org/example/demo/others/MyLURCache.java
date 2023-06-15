package org.example.demo.others;

import java.util.*;

/**
 * 实现lur 缓存 #146
 * java 原生 LinkedHashMap 就可以实现了。
 * @author jun
 */
public class MyLURCache {
    // 这种方法get()的时候，无法达到O(1)
    int capacity;

    Map<Integer, Integer> map = new HashMap<>();

    Map<Integer, Integer> usedMap = new HashMap<>();

    public MyLURCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (usedMap.containsKey(key)) {
            usedMap.merge(key, 1, Integer::sum);
        }
        Integer result = map.get(key);
        return result == null ? -1 : result;
    }

    public void put(int key, int value) {
        if (map.size() + 1 >= capacity) {
            List<Map.Entry<Integer, Integer>> entryList =
                    new ArrayList<>(usedMap.entrySet());
            entryList.sort(Comparator.comparingInt(Map.Entry::getValue));
            map.remove(entryList.get(0).getKey());
            usedMap.remove(entryList.get(0).getKey());
        }
        map.put(key, value);
        usedMap.merge(key, 1, Integer::sum);
    }

    public static void main(String[] args) {
        MyLURCache cache = new MyLURCache(2);
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("1", "2");

        cache.put(1, 1);
        cache.put(2, 2);
        int get1 = cache.get(1);
        System.out.println(get1);
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }


    /**
     * 双向链表+hashMap 来解决。
     */
    public class LRUCache {
        class DLinkedNode {
            int key;

            int value;

            DLinkedNode prev;

            DLinkedNode next;

            public DLinkedNode() {
            }

            public DLinkedNode(int _key, int _value) {
                key = _key; value = _value;
            }
        }

        private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();

        private int size;

        private int capacity;

        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            // 使用伪头部和伪尾部节点
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // 如果 key 存在，先通过哈希表定位，再移到头部
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                // 如果 key 不存在，创建一个新的节点
                DLinkedNode newNode = new DLinkedNode(key, value);
                // 添加进哈希表
                cache.put(key, newNode);
                // 添加至双向链表的头部
                addToHead(newNode);
                ++size;
                if (size > capacity) {
                    // 如果超出容量，删除双向链表的尾部节点
                    DLinkedNode tail = removeTail();
                    // 删除哈希表中对应的项
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
                node.value = value;
                moveToHead(node);
            }
        }

        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private DLinkedNode removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }
    }

}
