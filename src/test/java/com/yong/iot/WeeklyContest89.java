package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

@Slf4j
public class WeeklyContest89 {

    @Test
    public void test1() {
        int i = peakIndexInMountainArray(new int[]{0, 2, 1, 0});
        log.debug("result = {}", i);
    }

    public int peakIndexInMountainArray(int[] A) {
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                return i;
            }
        }
        return 1;
    }

    @Test
    public void test2() {
        int i = carFleet(10, new int[]{0, 4, 2}, new int[]{2, 1, 3});
        log.debug("result = {}", i);
    }

    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 0) return 0;
        TreeMap<Integer, Double> map = new TreeMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(target - position[i], ((double) (target - position[i]) / (double) speed[i]));
        }
        int res = 1;
        int key = map.firstKey();
        double val = map.get(key);
        map.remove(key);
        while (!map.isEmpty()) {
            int key2 = map.firstKey();
            double val2 = map.get(key2);
            if (val < val2) {
                res++;
                val = val2;
            }
            map.remove(key2);
        }
        return res;
    }
//    "abcdefabcdefabcdef"
//        "acdbfeffabacbecedd"

    @Test
    public void test3() {
        int i = kSimilarity("abcdefabcdefabcdef", "acccafdeaddbbefbef");//8
        log.debug("result = {}", i);
        i = kSimilarity("abcdefabcdefabcdef", "acdbfeffabacbecedd");//10
        log.debug("result = {}", i);
        i = kSimilarity("ccfafcdaddefeebbaccb", "dcacafeeecbafddbccfb");//10
        i = kSimilarity("ab", "ba");//10
        log.debug("result = {}", i);
    }

    public int kSimilarity1(String A, String B) {
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] f = new boolean[A.length()];
        for (int i = 0; i < A.length(); i++) {
            if (f[i]) continue;
            if (A.charAt(i) == B.charAt(i)) {
                f[i] = true;
                continue;
            }
            for (int j = i; j < A.length(); j++) {
                if (f[j]) continue;
                if (A.charAt(i) == B.charAt(j) && A.charAt(j) == B.charAt(i)) {
                    f[i] = f[j] = true;
                    res++;
                    log.debug("[{},{}]", i, j);
                    break;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < f.length; i++) {
            if (!f[i]) sb.append(A.charAt(i));
        }

        while (!q.isEmpty()) {
            List<List<Integer>> steps = new ArrayList<>();
            List<Integer> step = new ArrayList<>();
            Integer i = q.poll();
            step.add(i);
            getVis(A, B, steps, A.charAt(i), B.charAt(i), step, q);
            int min = Integer.MAX_VALUE;
            int count = 0;
            for (List<Integer> list : steps) {
                if (list.size() < min) {
                    step = list;
                    min = list.size();
                    count = 1;
                } else if (list.size() == min) {
                    count++;
                }
            }
            if (count > 1 && steps.size() != count) {
                q.offer(i);
                continue;
            }
            log.debug("{}", step);
            q.removeAll(step);
            res = res + step.size() - 1;
        }
        return res;
    }

    public void getVis(String A, String B, List<List<Integer>> vis, char start, char end, List<Integer> list, Queue<Integer> flag) {
        List<Character> q = new ArrayList<>();
        for (int i : flag) {
            if (list.contains(i) || q.contains(B.charAt(i))) continue;
            if (A.charAt(i) == end) {
                List<Integer> t = new ArrayList<>(list);
                t.add(i);
                if (B.charAt(i) == start) {
                    vis.add(t);
                } else {
                    q.add(B.charAt(i));
                    getVis(A, B, vis, start, B.charAt(i), t, flag);
                }

            }
        }
    }


    public int kSimilarity(String A, String B) {
        Set<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int res = 0;
        boolean[] f = new boolean[A.length()];
        for (int i = 0; i < A.length(); i++) {
            if (f[i]) continue;
            if (A.charAt(i) == B.charAt(i)) {
                f[i] = true;
                continue;
            }
            for (int j = i; j < A.length(); j++) {
                if (f[j]) continue;
                if (A.charAt(i) == B.charAt(j) && A.charAt(j) == B.charAt(i)) {
                    f[i] = f[j] = true;
                    A = swap(A, i, j);
                    res++;
                    break;
                }
            }
        }
        if (A.equals(B)) return res;
        q.add(A);
        vis.add(A);
        while (!q.isEmpty()) {
            res++;
            for (int sz = q.size(); sz > 0; sz--) {
                String s = q.poll();
                int i = 0;
                while (s.charAt(i) == B.charAt(i)) i++;
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == B.charAt(j) || s.charAt(i) != B.charAt(j)) continue;
                    String temp = swap(s, i, j);
                    if (temp.equals(B)) return res;
                    if (vis.add(temp)) q.add(temp);
                }
            }
        }
        return res;
    }

    public String swap(String s, int i, int j) {
        char[] ca = s.toCharArray();
        char temp = ca[i];
        ca[i] = ca[j];
        ca[j] = temp;
        return new String(ca);
    }

//    class ExamRoom {
//
//        int n ;
//        int start=0;
//        int end ;
//        public ExamRoom(int N) {
//            this.n=N;
//            this.end=N;
//        }
//
//        public int seat() {
//
//        }
//
//        public void leave(int p) {
//
//        }
//    }
}
