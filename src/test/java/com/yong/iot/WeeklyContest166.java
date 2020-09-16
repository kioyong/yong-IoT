package com.yong.iot;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

public class WeeklyContest166 {

    @Test
    public void test() {
        Stream.of("1", "2", "bilibili", "of", "codesheep", "5", "at", "BILIBILI", "codesheep", "23", "CHEERS", "6")
            .filter(t -> t.length() >= 5)
            .map(String::toUpperCase)
            .distinct()
            .sorted()
            .reduce((a, b) -> a.concat("爱心").concat(b))
            .ifPresent(System.out::println);
    }


    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<Integer> total = new ArrayList<>();
        for (int[] nums : grid) for (int j : nums) total.add(j);
        int width = grid.length;
        int high = grid[0].length;
        k = width * high - k % (width * high);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < high; j++) {
                k %= width * high;
                temp.add(total.get(k));
                k++;
            }
            res.add(temp);
        }
        return res;
    }


    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) return true;
        List<Integer> used = new ArrayList<>();
        used.add(start);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer poll = q.poll();
                int max = poll + arr[poll];
                int min = poll - arr[poll];
                if (max < arr.length && !used.contains(max)) {
                    if (arr[max] == 0) return true;
                    used.add(max);
                    q.offer(max);
                }
                if (min >= 0 && !used.contains(min)) {
                    if (arr[min] == 0) return true;
                    used.add(min);
                    q.offer(min);
                }
            }
        }
        return false;
    }

    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public int[] diStringMatch(String S) {
        int[] res = new int[S.length() + 1];
        int max = S.length() + 1;
        int min = 0;
        String[] split = S.split("");
        if (split[0].equals("D")) {
            res[0] = max;
            max--;
        } else {
            res[0] = min;
            min++;
        }
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("D") && split[i + 1].equals("D")) {
                res[i + 1] = max;
                max--;
            } else if (split[i].equals("D") && split[i + 1].equals("I")) {
                res[i + 1] = min;
                min++;
            } else if (split[i].equals("I") && split[i + 1].equals("I")) {
                res[i + 1] = min;
                min++;
            } else {
                res[i + 1] = max;
                max--;
            }
        }
        return res;
    }


    class MyLinkedList {

        private int val = 0;
        private MyLinkedList next;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index == 0) return this.val;
            if (this.next == null) return -1;
            return this.next.get(index - 1);
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            MyLinkedList next = this;
            this.val = val;
            this.next = next;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            if (this.next == null) {
                MyLinkedList tail = new MyLinkedList();
                tail.val = val;
                this.next = tail;
            } else {
                this.next.addAtTail(val);
            }

        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index == 0) {
                MyLinkedList tail = new MyLinkedList();
                tail.val = val;
                MyLinkedList old = this.next;
                this.next = tail;
                tail.next = old;
            } else {
                this.next.addAtIndex(index - 1, val);
            }
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index == 0) {
                MyLinkedList cur = this.next;
                MyLinkedList curNext = cur.next;
                this.next = curNext;
            } else {
                this.next.deleteAtIndex(index - 1);
            }
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
        A:
        for (int i : nums1) {
            for (int value : nums2) {
                if (value == i) {
                    s.add(i);
                    break A;
                }
            }
        }
        int[] res = new int[s.size()];
        int i = 0;
        for (Integer integer : s) {
            res[i++] = integer;
        }
        return res;
    }

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int left = upper;
        int right = lower;
        List<Integer> l = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        for (int value : colsum) {
            if (value == 2) {
                left -= 1;
                l.add(1);
                right -= 1;
                r.add(1);
            } else if (value == 0) {
                l.add(0);
                r.add(0);
            } else {
                if (left < right) {
                    right -= 1;
                    l.add(0);
                    r.add(1);
                } else {
                    left -= 1;
                    l.add(1);
                    r.add(0);
                }
            }
            if (left < 0 || right < 0) return new ArrayList<>();
        }
        return Arrays.asList(l, r);
    }

    public List<List<Integer>> reconstructMatrix1(int upper, int lower, int[] colsum) {
        int sum = Arrays.stream(colsum).sum();
        if (sum != upper + lower) return new ArrayList<>();
        long sum1 = Arrays.stream(colsum).filter(t -> t == 2).count();
        if (sum1 > upper && sum1 > lower) return new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        for (int value : colsum) {
            if (value == 2) {
                r1.add(1);
                r2.add(1);
            } else if (value == 0) {
                r1.add(0);
                r2.add(0);
            } else {
                if (sum1 < upper) {
                    sum1 += 1;
                    r1.add(1);
                    r2.add(0);
                } else {
                    r1.add(0);
                    r2.add(1);
                }
            }
        }
        return Arrays.asList(r1, r2);
    }

    class RecentCounter {

        Queue<Integer> q = new LinkedList<>();

        public RecentCounter() {

        }

        public int ping(int t) {
            q.offer(t);
            while (true) {
                if (q.peek() != null && t - q.peek() > 3000) {
                    q.poll();
                } else {
                    break;
                }
            }
            return q.size();
        }
    }
}
