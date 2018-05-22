package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

@Slf4j
public class FindUnsortedSubarrayTest {

    //https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/description/
    @Test
    public void test() {
        int[] input = new int[]{2, 4, 3, 6};
        int unsortedSubarray = findUnsortedSubarray(input);
        log.debug("result = {},", unsortedSubarray);
    }


    private int findUnsortedSubarray(int[] nums) {
        int beg, end;
        beg = end = 0;
        int n = nums.length;
        int min = nums[n - 1];
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            min = Math.min(nums[n - i - 1], min);
            max = Math.max(nums[i], max);
            if (nums[i] < max) end = i;
            if (nums[n - i - 1] > min) beg = n - i - 1;
        }
        return end == 0 ? 0 : end - beg + 1;
    }

    //https://leetcode-cn.com/problems/flipping-an-image/
    @Test
    public void test3() {
//        int[][] A = new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        int[][] A = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] ints = flipAndInvertImage(A);
        log.debug("ints = {}", Arrays.asList(ints).toString());
    }

    private int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length / 2 + A[i].length % 2; j++) {
                int n = A[i].length - 1 - j;
                int temp = A[i][j];
                A[i][j] = 1 - A[i][n];
                A[i][n] = 1 - temp;
            }

        }
        return A;
    }

    @Test
//    https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/
    public void test4() {
        int[] input = new int[]{1, 2};
        rotate(input, 3);
        log.debug("input = {}", input);
    }

    public void rotate(int[] nums, int k) {
        int l = nums.length;
        int[] res = new int[l];
        for (int i = 0; i < l; i++) {
            int j = (l + i - (k % l)) % l;
            res[i] = nums[j];
        }
        System.arraycopy(res, 0, nums, 0, l);
    }

    @Test
    //https://leetcode-cn.com/problems/jewels-and-stones/description/
    public void test5() {
        String J = "aA";
        String S = "AAAAaaaadddsss";
        int i = numJewelsInStones(J, S);
        log.debug("sum = {}", i);
    }

    private int numJewelsInStones(String J, String S) {
        int sum = 0;
        for (char value : S.toCharArray()) if (J.contains(String.valueOf(value))) sum++;
        return sum;
    }


    @Test
    //https://leetcode-cn.com/problems/judge-route-circle/description/
    public void test6() {
        String s = "UD";
        boolean b = judgeCircle(s);
    }

    private boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        char[] chars = moves.toCharArray();
        for (char c : chars) {
            if (c == 'U') y++;
            if (c == 'D') y--;
            if (c == 'R') x++;
            if (c == 'L') x--;
        }
        return x == 0 && y == 0;
    }
}
