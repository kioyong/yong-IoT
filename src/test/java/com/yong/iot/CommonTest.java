package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        String n = "1223";
        String s = nearestPalindromic(n);
        log.debug("result = {},", s);
    }

//    https://leetcode-cn.com/problems/find-the-closest-palindrome/description/
    private String nearestPalindromic(String n) {
        int i = (n.length() + 1) / 2;
        int j = (n.length()) % 2;
        String str = n.substring(0, i);
        String result = getStr(str,j);
        long value = n.length()==1?Long.valueOf(n):Long.valueOf(n.substring(i-n.length()%2,n.length()));
        long r1value = result.length()==1?Long.valueOf(n):Long.valueOf(result.substring(i-n.length()%2,n.length()));
        if (r1value > value || n.equals(result)) {
            str = String.valueOf(Long.valueOf(str) - 1);
        } else {
            str = String.valueOf(Long.valueOf(str) + 1);
        }
        String result2 = getStr(str,j);
        long r2value = result2.length()==1?Long.valueOf(result2):Long.valueOf(result2.substring(i-n.length()%2,n.length()));
        if (Math.abs(r1value - value) > Math.abs(r2value - value)  || r1value == value) {
            return result2;
        } else {
            return result;
        }
    }

    private String getStr(String str,int i) {
        String r1 = str;
        for (int j = str.length() - i; j > (1 - i); j--) {
            r1 = r1.concat(str.substring(j - 2 + i, j - 1 + i));
        }
        return r1;
    }


}
