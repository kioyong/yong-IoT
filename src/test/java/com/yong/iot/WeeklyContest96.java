package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class WeeklyContest96 {
    @Test
    public void test() {
        int i = 0;
        i = projectionArea(new int[][]{{2}});
        Assert.assertEquals(5, i);
        i = projectionArea(new int[][]{{1, 0}, {0, 2}});
        Assert.assertEquals(8, i);
        i = projectionArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        Assert.assertEquals(14, i);
        i = projectionArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}});
        Assert.assertEquals(21, i);
    }

    @Test
    public void test1() {
        int i = 0;
//        i = numRescueBoats(new int[]{1, 2}, 3);
//        Assert.assertEquals( 1,i);
//        i = numRescueBoats(new int[]{3, 2, 2, 1}, 3);
//        Assert.assertEquals(3,i);
//        i = numRescueBoats(new int[]{3, 5, 3, 4}, 5);
//        Assert.assertEquals(4,i);
        i = numRescueBoats(new int[]{2, 49, 10, 7, 11, 41, 47, 2, 22, 6, 13, 12, 33, 18, 10, 26, 2, 6, 50, 10}, 50);
        Assert.assertEquals(11, i);

    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;
        int res = 0;
        while (start < end) {
            if (people[end] == limit) {
                res++;
                end--;
                if (start == end) {
                    res++;
                }
            } else {
                int temp = people[end] + people[start];
                if (temp == limit) {
                    res++;
                    start++;
                    end--;
                    if (start == end) {
                        res++;
                    }
                } else if (temp > limit) {
                    res++;
                    end--;
                    if (start == end) {
                        res++;
                    }
                } else {
                    res++;
                    start++;
                    end--;
                    if (start == end) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test2() {
        String leet2code3 = decodeAtIndex("y959q969u3hb22odq595", 222280369);
        Assert.assertEquals("y", leet2code3);
    }
    public String decodeAtIndex1(String S, int K) {
        char[] s = S.toCharArray();
        int n = s.length;
        long[] dp = new long[n+1];
        for(int i = 0;i < n;i++){
            if(s[i] >= '2' && s[i] <= '9'){
                dp[i+1] = dp[i] * (s[i]-'0');
            }else{
                dp[i+1] = dp[i] + 1;
            }
        }
        K--;
        for(int i = n-1;i >= 0;i--){
            K %= dp[i+1];
            if(K+1 == dp[i+1] && !(s[i] >= '2' && s[i] <= '9')){
                return "" + s[i];
            }
        }
        return null;
    }

    public String decodeAtIndex(String S, int K) {
        List<Integer> list = new ArrayList<>();
        List<String> slist = new ArrayList<>();
        StringBuffer s = new StringBuffer();
        int l = 0;
        int sl = 0;
        int tt = 1;
        for (int i = 0; i < S.length(); i++) {
            if ((S.charAt(i) >= 'a' && S.charAt(i) <= 'z') || (S.charAt(i) >= 'A' && S.charAt(i) <= 'Z')) {
                s.append(S.charAt(i));
            } else {
                if (i + 1 == S.length() || ((S.charAt(i + 1) >= 'a' && S.charAt(i + 1) <= 'z') || (S.charAt(i + 1) >= 'A' && S.charAt(i + 1) <= 'Z'))) {
//                    s.append(S.charAt(i));
                    slist.add(s.toString());
                    int t = S.charAt(i) - '0';
                    tt = tt * t;
                    sl = l + s.length();
                    l = tt * sl;
                    list.add(sl);
                    tt = 1;
                    s = new StringBuffer();
                } else {
                    if (i + 1 < S.length()) {
                        int t = S.charAt(i) - '0';
                        tt = tt * t;
                    }
                }
            }
        }
        for(int i=list.size()-1;i>=0;i--){
            String ss = slist.get(i);
            Integer ii = list.get(i);
            int i1 = (K+1) % ii;
            if(i1<ss.length()){
                return String.valueOf(ss.charAt(i));
            }
        }
        return String.valueOf(slist.get(0).charAt(0));
    }

    @Test
    public void test3() {

    }

    public int projectionArea(int[][] grid) {
        int xl = grid.length;
        int yl = grid[0].length;
        int res = 0;
        for (int i = 0; i < xl; i++) {
            int x = 0;
            int z = 0;
            for (int j = 0; j < yl; j++) {
                int c = grid[i][j];
                if (c != 0) z++;
                x = Math.max(x, c);
            }
            res = res + z + x;
        }
        for (int i = 0; i < yl; i++) {
            int y = 0;
            for (int j = 0; j < xl; j++) {
                int c = grid[j][i];
                y = Math.max(y, c);
            }
            res = res + y;
        }
        return res;
    }




}
