package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Slf4j
public class WeeklyContest88 {

    @Test
    public void test1() {
        String abc = shiftingLetters("mkgfzkkuxownxvfvxasy", new int[]{505870226});
        log.debug("abc = {}", abc);
    }

    public String shiftingLetters(String S, int[] shifts) {
        StringBuffer sb = new StringBuffer();
        int sum = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            sum = (sum + shifts[i]) % 26;
            shifts[i] = sum;
        }
        for (int i = 0; i < S.length(); i++) {
            if (i < shifts.length) {
                sb.append((char) (
                    (((int) S.charAt(i) - 97 + shifts[i]) % 26) + 97)
                );
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }

    @Test
    public void test2() {
        int i = maxDistToClosest(new int[]{0, 1});
        log.debug("i = {}", i);
    }

    public int maxDistToClosest(int[] seats) {
        int res = 1;
        int cot = 0;
        int left = 0;
        int right = 0;
        for (int i = 1; i < seats.length; i++) {
            if (seats[i - 1] == 1 && seats[i] == 0) {
                left = i;
            } else if (seats[i - 1] == 0 && seats[i] == 0) {
                if (i == 1) left = 0;
                if (i == seats.length - 1) {
                    right = i;
                    cot = right - left + 1;
                }
            } else if (seats[i - 1] == 0 && seats[i] == 1) {
                right = i;
                if (left != 0) {
                    cot = (right - left + 1) / 2;
                } else {
                    cot = right - left;
                }
                res = Math.max(res, cot);
            }
        }
        res = Math.max(res, cot);
        return res;
    }

    @Test
    public void test3() {
        int[][] richer = new int[][]{{0, 5}, {0, 6}, {0, 7}, {0, 8}, {0, 9}, {1, 4}, {1, 5}, {1, 7}, {1, 8}, {2, 3}, {2, 4}, {2, 6}, {2, 8}, {3, 5}, {3, 7}, {3, 8}, {4, 6}, {4, 7}, {4, 8}, {5, 7}, {6, 7}, {6, 8}, {7, 9}, {8, 9}};
        int[] ints = loudAndRich(richer, new int[]{5, 1, 9, 3, 8, 6, 7, 2, 0, 4});
        log.debug("ints = {}", ints);

    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < richer.length; i++) {
            List<Integer> list = map.getOrDefault(richer[i][1], new ArrayList<>());
            list.add(richer[i][0]);
            map.put(richer[i][1], list);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ArrayDeque<Integer> q = new ArrayDeque<>();
            boolean[] flag = new boolean[n];
            int ta = i;
            int tv = quiet[i];
            flag[i] = true;
            q.add(i);
            while (!q.isEmpty()) {
                int u = q.removeFirst();
                for (int v : map.getOrDefault(u, new ArrayList<>())) {
                    if (!flag[v]) {
                        flag[v] = true;
                        q.add(v);
                        if (quiet[v] < tv) {
                            tv = quiet[v];
                            ta = v;
                        }
                    }

                }
            }
            ans[i] = ta;
        }
        return ans;
    }

    public int[] loudAndRich1(int[][] richer, int[] quiet) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < richer.length; i++) {
            map.put(richer[i][1],
                (
                    map.getOrDefault(richer[i][1], -1) == -1 ?
                        richer[i][0] :
                        (
                            quiet[getMin(map, i, quiet)] > quiet[richer[i][0]] ?
                                richer[i][0] : getMin(map, i, quiet))
                )
            );
        }
        int[] res = new int[quiet.length];
        for (int i = 0; i < quiet.length; i++) {
            res[i] = getMin(map, i, quiet);
        }
        return res;
    }

    public int getMin(TreeMap<Integer, Integer> map, int i, int[] quiet) {
        int temp = i;
        int res = i;
        while (temp != -1) {
            temp = map.getOrDefault(temp, -1);
            if (temp != -1) {
                res = quiet[temp] > quiet[res] ? res : temp;
            }
        }
        return res;
    }

    @Test
    public void test4() {

    }

    @Test
    public void test5() {

    }


}
