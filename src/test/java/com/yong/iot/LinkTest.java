
package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return false;
        ListNode f = head.next.next;
        ListNode s = head.next;
        while (true) {
            if (f.equals(s)) return true;
            if (f.next == null || f.next.next == null) return false;
            f = f.next.next;
            s = s.next;
        }
    }

    @Test
    public void test1() {
        ListNode listNode = detectCycle(new ListNode(1));
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = new ListNode(headA.val);
        ListNode cur = headA;
        while (true) {
            if (cur.next == null) break;
            ListNode temp = new ListNode(cur.next.val);
            temp.next = a;
            a = temp;
            cur = cur.next;
        }
        ListNode b = new ListNode(headB.val);
        cur = headB;
        while (true) {
            if (cur.next == null) break;
            ListNode temp = new ListNode(cur.next.val);
            temp.next = b;
            b = temp;
            cur = cur.next;
        }
        if (a != b) return null;
        while (true) {
            if (a.next == null || b.next == null) return null;
            if (a.next != b.next) return a;
            a = a.next;
            b = b.next;
        }
    }

    @Test
    public void test3(){
//        removeNthFromEnd()
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int m = 0;
        ListNode prev = head;
        while (head != null) {
            head = head.next;
            if (++m > n) prev = prev.next;
        }
        prev.next = prev.next.next;
        return prev;
    }
}
