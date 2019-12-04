package com.yong.iot;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class WeeklyContest149 {
    @Test
    public void test() {
        int i = dayOfYear();
        Assert.assertEquals(9, i);
        i = dayOfYear();
        Assert.assertEquals(41, i);
        i = dayOfYear();
        Assert.assertEquals(60, i);
        i = dayOfYear();
        Assert.assertEquals(61, i);
    }

    private int dayOfYear() {
//        TODO
        return 0;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void Test() {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        addTwoNumbers(l1, l3);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Length = getLength(l1);
        int l2Length = getLength(l2);
        int gap = l1Length - l2Length;
//        while (gap != 0) {
//            ListNode l = new ListNode(0);
//            if (gap < 0) {
//                l1.next=l;
//                gap++;
//            } else {
//                l2.next=l;
//                gap--;
//            }
//
//        }
        return getNext(l1, l2, 0);
    }

    private ListNode getNext(ListNode l1, ListNode l2, int nextRes) {
        if (l1 == null && l2 == null) return nextRes==0?null:new ListNode(1);
        ListNode res;
        if (l1 == null) {
            res = new ListNode((l2.val + nextRes) % 10);
            res.next = getNext(null, l2.next, (l2.val + nextRes) / 10);
        } else if (l2 == null) {
            res = new ListNode((l1.val + nextRes) % 10);
            res.next = getNext(l1.next, null, (l1.val + nextRes) / 10);
        } else {
            res = new ListNode((l1.val + l2.val + nextRes) % 10);
            res.next = getNext(l1.next, l2.next, (l1.val + l2.val + nextRes) / 10);
        }
        return res;
    }

    private int getLength(ListNode l) {
        return l.next == null ? 1 : getLength(l.next) + 1;
    }
}
