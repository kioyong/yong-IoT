package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

@Slf4j
public class WeeklyContest91 {

    @Test
    public void test() {
        boolean b = lemonadeChange(new int[]{5, 5, 5, 5, 10, 5, 10, 10, 10, 20});
        Assert.assertTrue(b);
    }

    public boolean lemonadeChange(int[] bills) {
        int a = 0;//5
        int b = 0;//10
        for (int bill : bills) {
            if (bill == 5) {
                a++;
            } else {
                if (bill == 10) {
                    a--;
                    b++;
                }
                if (bill == 20) {
                    if (b > 0) {
                        b--;
                        a--;
                    } else {
                        a = a - 3;
                    }

                }
                if (a < 0) return false;
            }
        }
        return true;
    }


    @Test
    public void test1() {
        long i =1l;
        long l = i <<46;
        log.debug("l={}",l);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        int level = distanceK(root, target.val);
        int actual = K - level;
        findK(root, target.val, actual, K, res);
        return res;
    }

    public void findK(TreeNode root, int val, int actual, int K, List<Integer> list) {
        if (root != null) {
            if (actual == 0) {
                if (root.val != val) {
                    list.add(root.val);
                } else {
                    actual = K;
                    findK(root.left, val, actual, K, list);
                    findK(root.right, val, actual, K, list);
                }

            } else {
                actual--;
                findK(root.left, val, actual, K, list);
                findK(root.right, val, actual, K, list);
            }

        }

    }

    public int distanceK(TreeNode root, int val) {
        if (root.left == null && root.right == null) return 0;
        if (root.left != null && root.left.val == val) return 1;
        if (root.right != null && root.right.val == val) return 1;
        int left = distanceK(root.left, val);
        int right = distanceK(root.right, val);
        if (left == 0 && right == 0) return 0;
        return Math.max(right, left) + 1;
    }

    public void distanceK(TreeNode root, TreeNode target, List<List<Integer>> lists, int level) {
        List<Integer> list = lists.get(level);
        list.add(root.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test2() {
        int i = matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}});
        log.debug("result = {}", i);
    }

    public int matrixScore(int[][] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                swapX(A, i);
            }
        }
        for (int i = 1; i < A[0].length; i++) {
            int x = 0;//0
            int y = 0;//1
            for (int[] aA : A) {
                if (aA[i] == 0) {
                    x++;
                } else {
                    y++;
                }
            }
            if (x > y) {
                swapY(A, i);
            }
        }
        for (int[] aA : A) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < A[0].length; j++) {
                sb.append(aA[j]);
            }
            Integer integer = Integer.valueOf(sb.toString(), 2);
            res += integer;

        }
        return res;
    }

    public void swapX(int[][] A, int i) {
        for (int j = 0; j < A[i].length; j++) {
            A[i][j] = 1 - A[i][j];
        }
    }

    public void swapY(int[][] A, int j) {
        for (int i = 0; i < A.length; i++) {
            A[i][j] = 1 - A[i][j];
        }
    }


    @Test
    public void test3() {

    }
//
//    public int shortestSubarray(int[] A, int K) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        Arrays.sort(A);
//        int count = 2;
//        int sum = 0;
//        for (int i = 0; i < A.length; i++) {
//            if (pq.size() < count) {
//                pq.add(A[i]);
//                sum += A[i];
//            } else {
//
//            }
//
//        }
//    }
}
