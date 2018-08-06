package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

@Slf4j
public class WeeklyContest93 {

    @Test
    public void test() {
        int i = binaryGap(22);
        log.debug("i = {}", i);
    }

    public int binaryGap(int N) {
        String s = Integer.toBinaryString(N);
        log.debug("s = {}", s);
        int res = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (start != -1) {
                    res = Math.max(res, i - start);
                }
                start = i;
            }
        }
        return res;
    }

    @Test
    public void test2() {
        reorderedPowerOf2(10);
    }


    public boolean reorderedPowerOf2(int N) {
//        for(int i=0;i<100;i++){
//            log.debug("{}",Math.pow(2,i));
//        }
//        List<String>list = Arrays.asList("1","2","4","8","16","32","64","128","256","512","1024","2048","4096","8192","16384","32768","65536","131072","26144","524288","1048576","2097152","4194304","8388608","16777216","33554432","67108864","134217728","268435456","56870912","1073741824","2147483648","4294967296","8589934592");
//        for(int i=0;i<list.size();i++){
//            String s = list.get(i);
//            char[] chars = s.toCharArray();
//            Arrays.sort(chars);
//            log.debug("{}",chars);
//        }
        List<String> list = Arrays.asList("1", "2", "4", "8", "16", "23", "46", "128", "256", "125", "0124", "0248", "0469", "1289", "13468", "23678", "35566", "011237", "1246", "224588", "0145678", "0122579", "0134449", "0368888", "11266777", "23334455", "01466788", "112234778", "234455668", "0156789", "0112344778", "1234446788", "2244667999", "2345588999");
        String s = String.valueOf(N);
        char[] res = s.toCharArray();
        Arrays.sort(res);
        String s1 = String.valueOf(res);
        return list.contains(s1);
    }


    @Test
    public void test1() {
        int[] ints = advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2});
        log.debug("{}", ints);

    }

    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int[] res = new int[A.length];
        boolean[] flag = new boolean[A.length];
        X:
        for (int i = 0; i < A.length; i++) {
            int x = B[i];
            for (int j = 0; j < A.length; j++) {
                if (A[j] > x && !flag[j]) {
                    res[i] = A[j];
                    flag[j] = true;
                    continue X;
                }
            }
            for (int j = 0; j < A.length; j++) {
                if (!flag[j]) {
                    res[i] = A[j];
                    flag[j] = true;
                    continue X;
                }
            }
        }
        return res;
    }

    public class Car {
        int target;
        int startFuel;
        int count;

        Car(int target, int startFuel, int count) {
            this.target = target;
            this.startFuel = startFuel;
            this.count = count;
        }
    }

    @Test
    public void test3() {

        int i = minRefuelStops(1000000, 70768, new int[][]{{12575,171159},{81909,101253},{163732,164401},{190025,65493},{442889,31147},{481202,166081},{586028,206379},{591952,52748},{595013,9163},{611883,217156}});
        log.debug("i={}", i);
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) return 0;
        Queue<Integer> pq = new PriorityQueue<>();
        int p = 0;
        int ret = 0;
        while (true) {
            while (p < stations.length && stations[p][0] <= startFuel) {
                pq.offer(-stations[p][1]);
                p++;
            }
            if (pq.size() == 0) return -1;
            startFuel -= pq.poll();
            ret++;
            if (startFuel >= target) return ret;
        }
    }

    @Test
    public void arraysEquarlTest() {
        int[] a = new int[]{1, 3, 5, 7};
        int[] b = new int[]{3, 1, 7, 5};
        Assert.assertFalse(a == b);
        Assert.assertNotEquals(a, b);
        Assert.assertFalse(Arrays.equals(a, b));
    }

    @Test
    public void freqTest() {
        String s = "12233454";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        log.debug("result = {}", chars);
    }

    int[] freq(char[] s) {
        int[] f = new int[10];
        for (char c : s) {
            f[c - '0']++;
        }
        return f;
    }

}
