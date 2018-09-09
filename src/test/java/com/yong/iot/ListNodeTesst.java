package com.yong.iot;

public class ListNodeTesst {

    class MyLinkedList {

        int val;

        MyLinkedList next;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {

        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            return -1;
        }

        public int get(MyLinkedList list, int index) {
            if (index == 1) return list.val;
            return get(list.next, index--);
        }
        public MyLinkedList getMyLinkList(MyLinkedList list, int index) {
            if (index == 1) return list;
            return getMyLinkList(list.next, index--);
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            MyLinkedList list = new MyLinkedList();
            list = this;
            this.val = val;
            this.next = list;

        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            MyLinkedList list = getTail(this);
            MyLinkedList tail = new MyLinkedList();
            tail.val = val;
            list.next = tail;
        }

        public MyLinkedList getTail(MyLinkedList list) {
            if (list.next != null) return getTail(list.next);
            return list;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
//            MyLinkedList myLinkList = getMyLinkListPrev(this, index);
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {

        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

}
