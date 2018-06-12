package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @acthor yong.a.liang
 * @date 2017/12/26
 */
@Slf4j
public class CommonTest {

    @Test
    public void compareToTest() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = simpleDateFormat.parse("2017-12-13");
        Date endDate = simpleDateFormat.parse("2017-12-26");
        log.debug("startDate = {}", startDate);
        log.debug("endDate = {}", endDate);
//        int i = endDate.compareTo(startDate);
        long l = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
        log.debug("l = {}", l);
    }

    @Test
    public void test1() {
        String number = "2506020000";
        long i = Long.valueOf(number) / 60000;
        log.debug("i = {}", i);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    @Test
    public void test3() {
        String n = "1805170081";
        String s = nearestPalindromic(n);
        log.debug("result = {},", s);
    }

    //寻找回文数
    //    https://leetcode-cn.com/problems/find-the-closest-palindrome/description/
    private String nearestPalindromic(String n) {
        if (Long.valueOf(n) < 11) {
            return String.valueOf(Long.valueOf(n) - 1);
        }
        if (n.equals("11")) {
            return "9";
        }
        int i = (n.length() + 1) / 2;
        int j = (n.length()) % 2;
        String b = n.substring(0, i);
        String r1 = getStr(b, j);
        String b1;
        if (r1.compareTo(n) > 0) {
            b1 = String.valueOf(Long.valueOf(b) - 1);
            j = j + (b.length() - b1.length());
            b1 = b1.concat(b1.substring(0, b.length() - b1.length()));
        } else if (r1.compareTo(n) < 0) {
            b1 = String.valueOf(Long.valueOf(b) + 1);
            j = j - (b1.length() - b.length());
        } else {
            b1 = String.valueOf(Long.valueOf(b) + 1);
            int j1 = j + (b1.length() - b.length());
            r1 = getStr(b1, j1);
            b1 = String.valueOf(Long.valueOf(b) - 1);
            j = j + (b.length() - b1.length());
            b1 = b1.concat(b1.substring(0, b.length() - b1.length()));
        }
        String r2 = getStr(b1, j);
        if (compareToValue(r1, r2, n)) {
            return r2;
        } else {
            return r1;
        }
    }

    public String nearestPalindromic1(String n) {
        int order = (int) Math.pow(10, n.length() / 2);
        Long ans = Long.valueOf(n);
        Long noChange = mirror(ans);
        Long larger = mirror((ans / order) * order + order + 1);
        Long smaller = mirror((ans / order) * order - 1);
        if (noChange > ans) {
            larger = Math.min(noChange, larger);
        } else if (noChange < ans) {
            smaller = Math.max(noChange, smaller);
        }
        return String.valueOf(ans - smaller <= larger - ans ? smaller : larger);
    }

    private Long mirror(Long ans) {
        char[] a = String.valueOf(ans).toCharArray();
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            a[j--] = a[i++];
        }
        return Long.valueOf(new String(a));
    }

    private String getStr(String b, int i) {
        String r1 = b;
        for (int j = b.length() - i; j > 0; j--) {
            r1 = r1.concat(b.substring(j - 1, j));
        }
        return r1;
    }

    private boolean compareToValue(String var1, String var2, String n) {
        long l1 = Long.valueOf(var1);
        long l2 = Long.valueOf(var2);
        long ln = Long.valueOf(n);
        return Math.abs(l1 - ln) > Math.abs(l2 - ln) ||
            (Math.abs(l1 - ln) == Math.abs(l2 - ln) && l1 > l2)
            ;
    }

    @Test
    public void test6() {
        String s1 = "1234";
        String s2 = "12345";
        String s3 = "123456";
        String str = getStr("12", 0);
        String str1 = getStr("123", 1);
        String str2 = getStr("123", 0);
        log.debug("str = {}, str1 = {}, str2 = {}", str, str1, str2);
    }

    @Test
    public void test7() {
        BigInteger s1 = BigInteger.valueOf(12345678987654322l);
        long l1 = Long.valueOf("12345678987654321");
        long l2 = Long.valueOf("12345678987654320");
        long l = l1 - l2;
        log.debug("s1 = {},l={}", s1, l);

    }

    @Test
    public void test8() {
        long value = Long.valueOf("100000000");
        log.debug("value = {}", value);
    }


    @Test
    public void test9() {
        String t1 = getStr("8", 0);
        String t2 = getStr("88", 1);
        String t3 = getStr("9", 0);
        String t4 = getStr("99", 1);
        String t5 = getStr("100", 2);
        assertEquals(t1, "88");
        assertEquals(t2, "888");
        assertEquals(t3, "99");
        assertEquals(t4, "999");
        assertEquals(t5, "1001");
    }

    @Test
    public void test10() {
        int i = firstBadVersion(10);
        log.debug("result == {}", i);

    }

    public int firstBadVersion(int n) {
        int max = n;
        int min = 0;
        int temp = n / 2;
        while ((max - min) != 1) {
            if (isBadVersion(temp)) {
                max = temp;
            } else {
                min = temp;
            }
            temp = (max - min) / 2 + min;
        }
        return max;
    }

    boolean isBadVersion(int version) {
        return version == 8;
    }

    @Test
    public void test11() {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{1, 2, 2, 2, 1};
        int[] intersect = intersect(nums1, nums2);
        log.debug("result = {}", intersect);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[nums1.length > nums2.length ? nums2.length : nums1.length];
        int n = 0;
        int j = 0;
        for (int i = 0; i < nums1.length && j < nums2.length; i++) {
            if (nums1[i] > nums2[j]) {
                i--;
                j++;
            } else if (nums1[i] == nums2[j]) {
                res[n] = nums1[i];
                n++;
                j++;
            }
        }
        int[] realRes = new int[n];
        System.arraycopy(res, 0, realRes, 0, n);
        return realRes;
    }
}
