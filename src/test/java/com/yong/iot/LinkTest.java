
package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LinkTest {
    class MyLinkedList {

        int val = -1;
        MyLinkedList next;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {

        }

        public MyLinkedList(int val) {
            this.val = val;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            MyLinkedList linked = getLinked(this, index + 1);
            if (linked != null) return linked.val;
            return -1;
        }

        private MyLinkedList getLinked(MyLinkedList list, int level) {
            if (level < 1 || list == null) return null;
            if (level == 1) return list;
            return getLinked(list.next, --level);
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            MyLinkedList list = new MyLinkedList();
            list.next = this.next;
            list.val = this.val;
            this.next = list;
            this.val = val;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            MyLinkedList tail = getTail(this);
            if (tail.val == -1) {
                tail.val = val;
            } else {
                tail.next = new MyLinkedList(val);
            }

        }

        private MyLinkedList getTail(MyLinkedList list) {
            if (list.next == null || list.next.val == -1) return list;
            return getTail(list.next);
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
            } else {
                MyLinkedList prev = getLinked(this, index);
                if (prev != null && prev.val != -1) {
                    MyLinkedList next = prev.next;
                    if (next == null) {
                        prev.next = new MyLinkedList(val);
                    } else {
                        MyLinkedList cur = new MyLinkedList(val);
                        cur.next = next;
                        prev.next = cur;
                    }
                }
            }
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            MyLinkedList prev = getLinked(this, index);
            if (index == 0) {
                if (this.next != null) {
                    this.val = next.val;
                    this.next = next.next;
                }
            } else if (prev != null) {
                MyLinkedList cur = prev.next;
                if (cur != null) {
                    MyLinkedList next = cur.next;
                    if (next != null) {
                        prev.next = next;
                    } else {
                        prev.next = null;
                    }
                } else {
                    prev.next = null;
                }
            }
        }
    }
    @Test
    public void test() {
        MyLinkedList list = new MyLinkedList();
        log.debug("val = {}", list.val);
        list.addAtTail(1);
        list.addAtTail(3);
        list.deleteAtIndex(1);
        int i = list.get(1);
        log.debug("i = {}", i);
    }
}
