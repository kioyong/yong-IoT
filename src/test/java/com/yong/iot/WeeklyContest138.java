package com.yong.iot;

import org.junit.Test;

import java.util.Arrays;

public class WeeklyContest138 {

    @Test
    public void test() {
        maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3);
    }

    public int heightChecker(int[] heights) {
        int res = 0;
        int[] t = Arrays.copyOf(heights, heights.length);
        Arrays.sort(t);
        for (int i = 0; i < heights.length; i++) {
            if (t[i] != heights[i]) res++;
        }
        return res;
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int maxX = 0;
        int cur = 0;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) {
                cur += customers[i];
            }
        }
        int max = cur;
        for (int i = X; i < grumpy.length; i++) {
            cur = cur - (grumpy[i - X] == 1 ? customers[i - X] : 0) + (grumpy[i] == 1 ? customers[i] : 0);
            if (cur > max) {
                max = cur;
                maxX = i - X + 1;
            }
        }
        for (int i = maxX; i < maxX + X; i++) {
            grumpy[i] = 0;
        }
        int res = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
            }
        }
        return res;
    }

    public int[] prevPermOpt1(int[] A) {
        if (A.length == 1) return A;
        int x = 0;
        int y = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            boolean flag = false;
            int max = -1;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    flag = true;
                    int temp = A[j];
                    if (temp > max) {
                        x = i;
                        y = j;
                        max = temp;
                    }
                }
            }
            if (flag) {
                int temp = A[x];
                A[x] = A[y];
                A[y] = temp;
                return A;
            }
        }
        return A;
    }

    @Test
    public void test4() {
        rearrangeBarcodes(new int[]{1, 1, 1, 2, 2, 2});
    }


    public int[] rearrangeBarcodes(int[] barcodes) {
        Arrays.sort(barcodes);
        int[] res = new int[barcodes.length];
        if (barcodes.length % 2 == 1) {
            res[barcodes.length] = barcodes[barcodes.length];
        }
        for (int i = 0; i < barcodes.length / 2; i++) {
            int x = 0;
            if (barcodes.length % 2 == 1) {
                x = 1;
            }
            res[2 * i] = barcodes[i - x];
            res[2 * i + 1] = barcodes[barcodes.length - 1 - i - x];
        }
        return res;
    }
}
