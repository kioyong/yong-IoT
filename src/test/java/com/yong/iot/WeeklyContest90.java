package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

@Slf4j
public class WeeklyContest90 {

    @Test
    public void test() {
        boolean b = buddyStrings("ab", "ab");
        log.debug("b ={}", b);
    }


    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        if (A.equals(B)) {
            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] == a[j]) return true;
                }
            }
        }
        start:
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                for (int j = i + 1; j < B.length(); j++) {
                    if (a[i] == b[j] && a[j] == b[i]) {
                        a[i] = B.charAt(i);
                        a[j] = B.charAt(j);
                        return Arrays.toString(a).equals(Arrays.toString(b));
                    }
                }
            }
        }
        return false;
    }

    @Test
    public void test2() {
        int i = mirrorReflection(3, 1);
        log.debug("i = {}", i);
//        i = mirrorReflection(6, 3);
//        log.debug("i = {}", i);
//        i = mirrorReflection(6, 4);
//        log.debug("i = {}", i);
    }

    @Test
    public void test3() {
        double v = mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3);
        log.debug("v={}", v);
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int[][] ws = new int[quality.length][];
        for (int i = 0; i < quality.length; i++) {
            ws[i] = new int[]{quality[i], wage[i]};
        }
        Arrays.sort(ws, (o1, o2) -> o1[1] * o2[0] - o1[0] * o2[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        double min = Double.MAX_VALUE;
        for (int[] w : ws) {
            pq.offer(-w[0]);
            sum += w[0];
            if (pq.size() > K) {
                sum += pq.poll();
            }
            if (pq.size() == K) {
                double can = (double) w[1] / w[0] * sum;
                min = Math.min(min, can);
            }
        }
        return min;
    }


    @Test
    public void test4() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        map.put(4, 1);
        map.put(2, 1);
        map.pollLastEntry();
        log.debug("map = {}", map);
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(4);
        set.add(3);
        set.pollLast();
        log.debug("set = {}", set);
    }

    public int mirrorReflection(int p, int q) {
        int res = p;
        int x = 0;
        int y = 0;
        while (res != 0) {
            if (res < q) {
                res = res + p;
                y++;
            }
            res = res - q;
            x++;
        }
        if (x % 2 == 0) return 2;
        if (y % 2 == 0) return 1;
        return 0;
    }


    public int getMin(int[] min, int sum, int i) {
        min[min.length - 1] = i;
        Arrays.sort(min);
        sum = sum + i - min[min.length - 1];
        min[min.length - 1] = 0;
        return sum;
    }
}
