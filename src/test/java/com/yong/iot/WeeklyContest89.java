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
//        int i = kSimilarity("abcdefabcdefabcdef", "acccafdeaddbbefbef");//8
        int i = kSimilarity("abcdefabcdefabcdef", "acdbfeffabacbecedd");//10
        log.debug("result = {}", i);
    }

    public int kSimilarity(String A, String B) {
        int res = 0;
        boolean[] flag = new boolean[A.length()];
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(i)) {
                flag[i] = true;
                continue;
            }
            if (flag[i]) continue;
            for (int j = 0; j < A.length(); j++) {
                if (flag[j]) continue;
                if (A.charAt(i) == B.charAt(j)
                    && A.charAt(j) == B.charAt(i)
                    && i != j
                    && !flag[i] && !flag[j]
                    ) {
                    flag[i] = true;
                    flag[j] = true;
                    res++;
                }
            }
        }
        for (int i = 0; i < A.length(); i++) {
            if (flag[i]) continue;
            List<List<Integer>> allList = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            getMinList(A, B, allList, A.charAt(i), B.charAt(i), temp, flag);
            int min = Integer.MAX_VALUE;
            List<Integer> finalList = new ArrayList<>();
            for (List<Integer> list : allList) {
                if (list.size() == min) {
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j) != finalList.get(j)) {
                            char a = B.charAt(list.get(j));
                            char b = B.charAt(finalList.get(j));
                            int aa = 0;
                            int bb = 0;
                            for (int z = 0; z < B.length(); z++) {
                                if (flag[z]) continue;
                                if (B.charAt(z) == a) aa++;
                                if (B.charAt(z) == b) bb++;
                            }
                            finalList = aa > bb ? finalList : list;
                            break;
                        }
                    }
                }
                if (list.size() < min) {
                    finalList = list;
                    min = list.size();
                }
            }
            log.debug("{}",finalList);
            for (int x : finalList) {
                flag[x] = true;
            }
            int count = finalList.size() == 0 ? 0 : finalList.size() - 1;
            res = res + count;
        }
        return res;
    }

    public void getMinList(String A, String B, List<List<Integer>> allList, char start, char temp, List<Integer> list, boolean[] flag) {
        for (int i = 0; i < A.length(); i++) {
            if (flag[i] || list.contains(i)) continue;
            if (A.charAt(i) == temp && B.charAt(i) == start) {
                List<Integer> tempList = new ArrayList<>();
                for (int j = 0; j < list.size(); j++) {
                    tempList.add(list.get(j));
                }
                tempList.add(i);
                allList.add(tempList);
            } else if (A.charAt(i) == temp && B.charAt(i) != start) {
                List<Integer> tempList = new ArrayList<>();
                for (int j = 0; j < list.size(); j++) {
                    tempList.add(list.get(j));
                }
                tempList.add(i);
                getMinList(A, B, allList, start, B.charAt(i), tempList, flag);
            }
        }
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
