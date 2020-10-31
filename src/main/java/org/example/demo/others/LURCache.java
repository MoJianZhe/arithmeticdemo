package org.example.demo.others;

import sun.applet.Main;

import java.util.*;

/**
 * 实现lur 缓存 #146
 * @author jun
 */
public class LURCache {
    int capacity;

    Map<Integer, Integer> map = new HashMap<>();

    Map<Integer, Integer> usedMap = new HashMap<>();

    public LURCache(int capacity) {
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
       LURCache cache =  new LURCache(2);
       cache.put(1,1);
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

}
