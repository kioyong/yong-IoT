package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;

@Slf4j
public class MyHashMapTest {
    class Bucket {
        final ListNode head = new ListNode(-1, -1);
    }

    class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    class MyHashMap {

        Bucket[] buckets = new Bucket[10000];

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {

        }

        /**
         * value will always be positive.
         */
        public void put(int key, int value) {

        }


        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {

        }
    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
    @Test
    public void test() {
        int[][] map = new int[10000][1];
        int i = map[20][0];
        log.debug("i = {}",i);
    }

}
