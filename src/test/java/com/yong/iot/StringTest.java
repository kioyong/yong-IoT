package com.yong.iot;

import org.junit.Test;

import java.util.*;

public class StringTest {

    public int strStr(String haystack, String needle) {
        if (needle == null) return 0;
        int n = needle.length();
        for (int i = 0; i < haystack.length() - n; i++) {
            if (haystack.substring(i, i + n).equals(needle)) return i;
        }
        return -1;
    }

    @Test
    public void test() {
        String s = countAndSay(4);
    }

    public String countAndSay(int n) {
        String a = "1";
        for (int i = 0; i < n - 1; i++) {
            StringBuffer sb = new StringBuffer();
            char t = a.charAt(0);
            int c = 1;
            int l = a.length();
            for (int j = 0; j < l; j++) {
                if (j == a.length() - 1) {
                    sb.append(c);
                    sb.append(t);
                    a = new String(sb);
                } else if (t == a.charAt(j + 1)) {
                    c++;
                } else {
                    sb.append(c);
                    sb.append(t);
                    c = 1;
                    t = a.charAt(j + 1);
                }
            }
        }
        return a;
    }

    //    public String longestCommonPrefix(String[] strs) {
//        String min = strs[0];
//        String max = strs[0];
//        String res;
//        for (int i = 1; i < strs.length; i++) {
//            if (strs[i].length() < min.length()) min = strs[i];
//            if (strs[i].length() > max.length()) max = strs[i];
//        }
//        int start = 0;
//        int end = min.length() - 1;
//        while (!max.contains(min)) {
//
//        }
//
//    }
    public int climbStairs(int n) {
        int res = 1;
        int last = 1;
        for (int i = 0; i < n; i++) {
            int temp = res + last;
            last = res;
            res = temp;
        }
        return res;
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        int max;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i] && prices[i] < min) {
                min = prices[i];
                max = prices[i];
                int j = i + 1;
                while (j < prices.length) {
                    if (prices[j] > max) max = prices[j];
                    j++;
                }
                res = Math.max(res, max - min);
            }
        }
        return res;
    }

    class Solution {

        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            Arrays.sort(nums);
            return nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            Random random = new Random();
            for (int i = 0; i < nums.length / 2; i++) {
                int t1 = random.nextInt(nums.length);
                int t2 = random.nextInt(nums.length);
                int t = nums[t1];
                nums[t1] = nums[t2];
                nums[t2] = t;
            }
            return nums;
        }
    }


    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) res.add("FizzBuzz");
            else if (i % 3 == 0) res.add("Fizz");
            else if (i % 5 == 0) res.add("Buzz");
            else res.add(String.valueOf(i));
        }
        return res;
    }
}
