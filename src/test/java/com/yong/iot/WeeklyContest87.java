package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class WeeklyContest87 {

    @Test
    public void test() {
        String s = backspaceCompare("######");
        log.debug("s ={}", s);
    }

    public boolean backspaceCompare(String S, String T) {
        return backspaceCompare(S).equals(backspaceCompare(T));
    }

    public String backspaceCompare(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    @Test
    public void test2() {
        int[] A = new int[]{2, 1, 3, 2, 5};
        int i = longestMountain(A);
        log.debug("result = {}", i);
    }

    public int longestMountain(int[] A) {
        int ret = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] <= A[i - 1] || A[i] <= A[i + 1]) continue;
            int low = i;
            int curr = 1;
            while (low > 0 && A[low] > A[low - 1]) {
                low--;
                curr++;
            }
            int high = i;
            while (high + 1 < A.length && A[high] > A[high + 1]) {
                curr++;
                high++;
            }
            ret = Math.max(ret, curr);
        }
        return ret;
    }

//    public int longestMountain1(int[] A) {
//        int res = 0;
//
//        for (int i = 1; i < A.length - 1; i++) {
//            if (A[i - 1] >= A[i] || A[i] >= A[i + 1]) continue;
//            int low = i;
//            int curr = 1;
//            while (low > 0 && A[low + 1] > A[low]) {
//                low++;
//                curr++;
//            }
//            int hight =curr;
//
//        }
//
//    }

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int out : hand) {
            map.put(out, 1 + map.getOrDefault(out, 0));
        }
        while (!map.isEmpty()) {
            Integer firstKey = map.firstKey();
            for (int a = 0; a < W; a++) {
                if (map.getOrDefault(firstKey + a, 0) == 0) return false;
                Integer val = map.get(firstKey + a);
                if (val == 1) {
                    map.remove(firstKey + a);
                } else {
                    map.put(firstKey + a, val - 1);
                }

            }
        }
        return true;
    }

    @Test
    public void test3() {
        int[] hand = new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8};
        boolean nStraightHand = isNStraightHandOther(hand, 3);
        log.debug("result = {}", nStraightHand);
    }


    public boolean isNStraightHandAnwser(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        TreeMap<Integer, Integer> dp = new TreeMap<Integer, Integer>();
        for (int out : hand) {
            dp.put(out, 1 + dp.getOrDefault(out, 0));
        }
        while (!dp.isEmpty()) {
            int first = dp.firstKey();
            for (int a = 0; a < W; a++) {
                if (dp.getOrDefault(first + a, 0) == 0) return false;
                update(dp, first + a, -1);
            }
        }
        return true;
    }

    private void update(Map<Integer, Integer> m, int k, int v) {
        m.put(k, v + m.getOrDefault(k, 0));
        if (m.get(k) == 0) m.remove(k);
    }

    public boolean isNStraightHand2(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        int[][] res = new int[hand.length / W][W];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = -1;
        }
        Arrays.sort(hand);
        res[0][0] = hand[0];
        int x = 0;
        int y = 0;
        for (int i = 0; i < hand.length - 1; i++) {
            if (W == 1) x++;
            if (res[x][y] + 1 == hand[i + 1]) {
                if (res[x][W - 1] != 0 && W != 1) {
                    x++;
                    y = 0;
                }
                if (res[x][0] == -1) {
                    res[x][0] = hand[i + 1];
                    break;
                } else {
                    A:
                    for (int n = 1; n < W; n++) {
                        if (res[x][n] == 0) {
                            res[x][n] = hand[i + 1];
                            if (n + 1 == W) {
                                x++;
                                y = 0;
                            } else {
                                y = n;
                            }
                            break A;
                        }
                    }
                }
            } else if (hand[i] == hand[i + 1]) {
                B:
                for (int j = 1; true; j++) {
                    if (res[x + j][0] == -1) {
                        res[x + j][0] = hand[i + 1];
                        break;
                    } else {
                        for (int n = 1; n < W; n++) {
                            if (res[x + j][n] == 0) {
                                res[x + j][n] = hand[i + 1];
                                break B;
                            }
                        }
                    }
                }
            } else {
                if (res[x][W - 1] == 0 && W != 1) return false;
                if (res[x + 1][0] != -1 && res[x + 1][W - 1] <= 0 && W != 1) return false;
                res[x + 1][0] = hand[i + 1];
            }
        }
        return true;
    }


    public boolean isNStraightHand1(int[] hand, int W) {
        Arrays.sort(hand);
        if (hand.length % W != 0) return false;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(hand[0]);
        res.add(list);
        int j = 0;
        for (int i = 0; i < hand.length - 1; i++) {
            if (hand[i] + 1 == hand[i + 1]) {
                if (res.get(j).size() == W) {
                    list = new ArrayList<>();
                    list.add(hand[i + 1]);
                    res.add(list);
                    j++;
                }
                res.get(j).add(hand[i + 1]);
            } else if (hand[i] == hand[i + 1]) {
                if (res.size() >= j + 1) {
//                    for(int x =j;x<res.size();res++){

//                    }
                } else {
                    list = new ArrayList<>();
                    list.add(hand[i + 1]);
                    res.add(list);
                }

            } else {
                if (res.get(j).size() != W) {
                    return false;
                } else {
                    list = new ArrayList<>();
                    list.add(hand[i + 1]);
                    res.add(list);
                    j++;
                }
            }
        }
        return true;
    }

    @Test
    public void test4() {
        int[][] list = new int[4][4];
        list[0][0] = 1;
        log.debug("length = {}", list[0].length);
        log.debug("1 = {}", list[0][0]);
        log.debug("2 = {}", list[0][1]);
    }

    public boolean isNStraightHandOther(int[] hand, int W) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int out : hand) {
            map.put(out, map.getOrDefault(out, 0) + 1);
        }
        while (!map.isEmpty()) {
            Integer fir = map.firstKey();
            for (int i = 0; i < W; i++) {
                Integer val = map.getOrDefault(fir + i, 0);
                if (val == 0) return false;
                if (val == 1) {
                    map.remove(fir + i);
                } else {
                    map.put(fir + i, map.get(fir + i) - 1);
                }
            }
        }
        return true;
    }


    @Test
    public void test5() {
        int[] nums = {3, 2, 2, 3};
        int i = removeElement(nums, 3);
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int res = nums.length;
        int count = 0;
        for (int i = 0; i < res; i++) {
            while (i + count < res && nums[i + count] == val) {
                count++;
            }
            if (i + count > res - 1) break;
            nums[i] = nums[i + count];
        }
        return res - count;

    }


}

