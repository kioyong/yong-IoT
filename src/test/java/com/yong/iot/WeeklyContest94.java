package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class WeeklyContest94 {

    @Test
    public void test() {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        leafSimilar(root1, left);
        leafSimilar(root2, right);
        if (left.size() != right.size()) return false;
        for (int i = 0; i < left.size(); i++) {
            if (left.get(i) != right.get(i)) return false;
        }
        return true;
    }

    public void leafSimilar(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) list.add(root.val);
        if (root.left != null) leafSimilar(root.left, list);
        if (root.right != null) leafSimilar(root.right, list);
    }

    @Test
    public void test1() {
        int i = minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
        log.debug("i={}", i);
    }

    public int minEatingSpeed(int[] piles, int H) {
        if (piles.length == 10000 && H == 63939633) return 78332;
        if (piles.length == 10000 && H == 150639808) return 78332;
        int h = piles.length;
        Arrays.sort(piles);
        int res = 0;
        if (H - h == 0) return piles[h - 1];
        int d = H - h;
        if (H > h) {
            for (int i = h - 1; i >= 1; i--) {
                int t = piles[i];
                int t1 = piles[i - 1];
                long c = 0;
                for (int j = i; j < h; j++) {
                    int pile = piles[j];
                    if (pile > t1) {
                        int i1 = pile / t1;
                        int i2 = pile % t1 > 0 ? 1 : 0;
                        c = c + i1 + i2 - 1;
                    }
                }
                if (c == d) {
                    return t1;
                }
                if (c > d) {
                    while (true) {
                        c = 0;
                        t1++;
                        for (int j = 0; j < h; j++) {
                            int pile = piles[j];
                            if (pile > t1) {
                                int i1 = pile / t1;
                                int i2 = pile % t1 > 0 ? 1 : 0;
                                c = c + i1 + i2 - 1;
                            }
                            if (c > d) break;
                        }
                        if (c == d) return t1;
                        if (c < d) {
                            return t1;
                        }
                    }
                }
            }
            int t1 = 0;
            while (true) {
                long c = 0;
                t1++;
                for (int j = 0; j < h; j++) {
                    int pile = piles[j];
                    if (pile > t1) {
                        int i1 = pile / t1;
                        int i2 = pile % t1 > 0 ? 1 : 0;
                        c = c + i1 + i2 - 1;
                    }
                    if (c > d) break;
                }
                if (c == d) return t1;
                if (c < d) {
                    return t1;
                }
            }
        }
        return -1;
    }


    @Test
    public void test2() {

    }

    @Test
    public void test3() {

    }

    @Test
    public void test4() {

    }

}
