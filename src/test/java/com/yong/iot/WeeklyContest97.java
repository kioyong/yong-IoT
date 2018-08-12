package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

@Slf4j
public class WeeklyContest97 {

    @Test
    public void test() {
        String[] strings = uncommonFromSentences("this apple is sweet", "this apple is sour");
        log.debug("{}", strings);
    }

    public List<String> uncommonFromSentencesList(String A, String B) {
        Map<String, Integer> map = new TreeMap<>();
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (String x : a) {
            if (set1.contains(x)) set2.add(x);
            set1.add(x);
        }
        for (String x : b) {
            if (set1.contains(x)) set2.add(x);
            set1.add(x);
        }
        set1.removeAll(set2);
        return new ArrayList<>(set1);
    }

    public List<String> uncommonFromSentencesList1(String A, String B) {
        Map<String, Integer> map = new TreeMap<>();
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        for (String x : a) {
//            map.put(x, map.getOrDefault(x, 0) + 1);//两种使用方法
            map.putIfAbsent(x, 0);
            map.putIfAbsent(x, map.get(x) + 1);
        }
        for (String x : b) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        Set<String> strings = map.keySet();
        List<String> list = new ArrayList<String>();
        for (String s : strings) {
            if (map.get(s) == 1) {
                list.add(s);
            }
        }
        return list;
    }

    public String[] uncommonFromSentences(String A, String B) {
        List<String> list = uncommonFromSentencesList1(A, B);
//        List<String> list = uncommonFromSentencesList(A, B);
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    @Test
    public void test3() {
        int[][] ints = spiralMatrixIII(5, 6, 1, 4);
        for (int i = 0; i < ints.length; i++) {
            log.debug("{},{}", ints[i][0], ints[i][1]);
        }
    }

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        res[0][0] = r0;
        res[0][1] = c0;
        int r = R - 1;
        int c = C - 1;
        int count = 1;
        int[] s = new int[]{1, 1, 2, 2};
        A:
        while (count < R * C) {
            for (int j = 0; j < s.length; j++) {
                for (int i = 0; i < s[j]; i++) {
                    if (j == 0) c0++;
                    if (j == 1) r0++;
                    if (j == 2) c0--;
                    if (j == 3) r0--;
                    if (c0 < C && r0 < R && c0 >= 0 && r0 >= 0) {
                        res[count][0] = r0;
                        res[count][1] = c0;
                        if (count == R * C - 1) break A;
                        count++;
                    }
                }
                s[j] += 2;
            }
        }
        return res;
    }

    @Test
    public void test2() {
        int[][] res = new int[][]{{0, 1}, {0, 2}, {0, 3}};
        int i = res[0][0];
        int i1 = res[1][0];
        int ii2 = res[2][0];
        log.debug("i = {},i1={},i2={}", i, i1, ii2);
    }

    class Possible {
        Integer start;
        Integer end;
        Integer count;

        public Possible(Integer start, Integer end, Integer count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        Queue<Possible> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < dislikes.length; i++) {
            map.put(dislikes[i][0], dislikes[i][1]);
        }
        Map.Entry<Integer, Integer> e = map.pollFirstEntry();
        q.offer(new Possible(e.getKey(), e.getValue(), 0));

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            while (size-- > 0) {
                Possible cur = q.poll();

            }
//            res.add(list);
        }
        return false;
    }

    @Test
    public void test4() {
        int i = superEggDrop(2, 4);
        log.debug("i = {}", i);
        i = superEggDrop(2, 6);
        log.debug("i = {}", i);
        i = superEggDrop(2, 6);
        log.debug("i = {}", i);
        i = superEggDrop(3, 14);
        log.debug("i = {}", i);
        i = superEggDrop(2, 1);
        log.debug("i = {}", i);
    }

    public int superEggDrop(int K, int N) {
        int count = 0;
        int res = 0;
//        if (K == 1 && N > 1) res = 1;
        while (K > 1 && N >= 2) {
            res = 0;
            N = N / 2;
            K--;
            count++;
        }
        int x = N % 2;
        return count + res + (N > 1 ? N - x : 1);
    }
}
