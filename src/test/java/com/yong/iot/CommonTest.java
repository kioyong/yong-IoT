package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        String n = "1000";
        String s = nearestPalindromic(n);
        log.debug("result = {},", s);
    }

    //    https://leetcode-cn.com/problems/find-the-closest-palindrome/description/
    private String nearestPalindromic(String n) {
        int i = (n.length() + 1) / 2;
        int j = (n.length()) % 2;
        String str = n.substring(0, i);
        String var1 = getStr(str, j);
        String newStr;
        if ((var1.compareTo(n) > 0 || n.equals(var1)) && String.valueOf(Long.valueOf(str) + 1).length() == str.length()) {
            newStr = String.valueOf(Long.valueOf(str) - 1);
            if (newStr.equals("0")) {
                newStr = "9";
            } else if (newStr.length() > str.length()) {
                newStr = newStr.substring(0, newStr.length() - 1);
            }

        } else {
            newStr = String.valueOf(Long.valueOf(str) + 1);
            if (newStr.length() != str.length()) {
                newStr = newStr.substring(0, newStr.length() - 1);
            }
        }
        String var2 = getStr(newStr, j);
        if (compareToValue(var1, var2, n)) {
            return var2;
        } else {
            return var1;
        }
    }

    private String getStr(String str, int i) {
        String r1 = str;
        for (int j = str.length() - i; j > 0; j--) {
            r1 = r1.concat(str.substring(j - 1, j));
        }
        return r1;
    }

    private boolean compareToValue(String var1, String var2, String n) {
        long long1 = Long.valueOf(var1.length() == 1 ? var1 : var1.substring(var1.length() / 2 - 1, var1.length()));
        long long2 = Long.valueOf(var2.length() == 1 ? var2 : var2.substring(var2.length() / 2 - 1, var2.length()));
        long longn = Long.valueOf(n.length() == 1 ? n : n.substring(n.length() / 2 - 1, n.length()));
        return Math.abs(long1 - longn) > Math.abs(long2 - longn) || long1 == longn;
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
        String s1 = "12345678987654322";
        String s2 = "12345678987654321";
        String s3 = "12345678887654322";
        assertTrue(s1.compareTo(s2) > 0);
        assertTrue(s1.compareTo(s3) > 0);
        assertTrue(s2.compareTo(s1) < 0);
        assertTrue(s2.compareTo(s3) > 0);
    }

    @Test
    public void test8() {
        long value = Long.valueOf("100000000");
        log.debug("value = {}", value);
    }
}
