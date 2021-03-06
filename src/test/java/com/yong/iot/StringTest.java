package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
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

    @Test
    public void test7() {
        String s = "123";
        int i = s.lastIndexOf("\t");
        log.debug("i={},length={}", i, s.length());
    }


    @Test
    public void test6() {
        String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        int i = lengthLongestPath(s);
        log.debug("i={}", i);

//        String format = "$1" +s.replaceAll("\\d","*").substring(1,s.length()-1)+ "$3";
//        String ss = s.replaceAll("(\\d{1})([\\d\\s]+)(\\d{1})",format);


    }


    public int lengthLongestPath(String input) {
        String[] split = input.split("\n");
        int max = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].contains(".")) {
                int z = split[i].lastIndexOf("\t");
                int temp = split[i].length() - z - 1;
                int j = i;
                while (j > 0) {
                    j--;
                    if (split[j].lastIndexOf("\t") == z - 1) {
                        temp += split[j].length() - z + 1;
                        z--;
                    }
                }
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    @Test
    public void test8() {
        DecimalFormat df = new DecimalFormat("#,###");
        List<Double> list = new ArrayList<>();
        list.add(100d);
        list.add(1000d);
        list.add(10000d);
        list.add(1000.00d);
        list.add(1000.01d);
        list.add(1234567d);
        list.add(123456789d);
        list.add(123456789.6666666666666d);
        list.add(12345.53d);
        list.add(23d);
        list.add(3.2d);
        list.add(456235.54d);
        for (Double d : list) {
            String format = df.format(d);
            log.debug("format = {}", format);
        }

    }

    @Test
    public void test9() {
        String s = "123456";
        String substring = s.substring(1, 3).concat(s.substring(4, 6));
        log.debug("{},{}", s.length(), substring);
    }

    @Test
    public void test10() {
        String s = "123456";
        s = String.format("%08d", Integer.valueOf(s));
        log.debug("s = {}", s);
    }

    @Test
    public void test11() {
        String s = "";
        assertTrue(s.isEmpty());
        assertEquals("", s);
//        assertTrue(s!=null && s.isEmpty());
    }


    @Test
    public void test13() {
        String s = "1";
        String lang = getLang("你好", "abc");
        assertEquals(lang, "zh-cn");
        lang = getLang("1", "abc");
        assertEquals(lang, "zh-cn");
        lang = getLang("17/7", "abc");
        assertEquals(lang, "zh-cn");
        lang = getLang("5PM", "abc");
        assertEquals(lang, "zh-cn");
        lang = getLang("517219382@qq.com", "abc");
        assertEquals(lang, "zh-cn");
        lang = getLang("1", "abc");
        assertEquals(lang, "zh-cn");
        lang = getLang("hello", "abc");
        assertEquals(lang, "en");
        lang = getLang("1", "abc");
        assertEquals(lang, "en");
        lang = getLang("你好", "abc");
        assertEquals(lang, "zh-cn");
        lang = getLang("1", "abc");
        assertEquals(lang, "zh-cn");

    }

    private Map<String, String> langs = new HashMap<>();

    public String getLang(String content, String sender) {
        if (langs.get(sender) != null) {
            try {
                String regEx = "^[0-9/\\- aApPmM]+$";
                Pattern p = Pattern.compile(regEx);
                Matcher m = p.matcher(content);
                if (m.find()) {
                    return langs.get(sender);
                }
                regEx = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
                p = Pattern.compile(regEx);
                m = p.matcher(content);
                if (m.find()) {
                    return langs.get(sender);
                }
            } catch (Exception ignored) {}
        }
        String regEx = "[\\u4e00-\\u9fa5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(content);
        if (!m.find()) {
            langs.put(sender, "en");
            log.debug("sender {} is using {}", sender, "en");
            return "en";
        } else {
            try {
                if (content.equals(new String(content.getBytes("GB2312"), "GB2312"))) {
                    log.debug("sender {} is using {}", sender, "zh-cn");
                    langs.put(sender, "zh-cn");
                    return "zh-cn";
                } else {
                    log.debug("sender {} is using {}", sender, "zh-HK");
                    langs.put(sender, "zh-HK");
                    return "zh-HK";
                }
            } catch (Exception e) {
                return "zh-cn";
            }
        }
    }

    public String decodeAtIndex(String S, int K) {
        long[] list = new long[S.length() + 1];
        char[] chars = new char[S.length()];
        char t = 'a';
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                t = c;
                chars[i] = c;
                list[i + 1] = list[i] + 1;
            } else {
                chars[i] = t;
                list[i + 1] = list[i] * (c - '0');
            }

        }
        int i = list.length - 1;
        long l = K;
        while (l > 0) {
            if (l >= list[i]) {
                l = l % list[i];
                if (l == 0) {
                    return chars[i - 1] + "";
                }
            }
            i--;

        }
        return "";
    }
}
