package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class WeeklyContest102 {

    public void test() {

    }

    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int start = 0;
        int end = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                res[start] = A[i];
                start++;
            } else {
                res[end] = A[i];
                end--;
            }
        }
        return res;
    }


    @Test
    public void test1() {
        int res = totalFruit(new int[]{1, 2, 1});
        log.debug("res = {}", res);
    }

    public int totalFruit(int[] tree) {
        if (tree.length <= 2) return tree.length;
        int max = 2;
        int s = 0;
        int e = 1;
        int i = 2;
        while (i < tree.length) {
            if (tree[s] == tree[e]) {
                e = i;
                max = Math.max(i - s, max);
            } else if ((tree[i] != tree[s] && tree[i] != tree[e])) {
                max = Math.max(i - s, max);
                s = e;
                e = e + 1;
                i = e;
            }
            if ((i == tree.length - 1) && (tree[i] == tree[s] || tree[i] == tree[e])) {
                max = Math.max(i - s + 1, max);
                break;
            }
            i++;
        }
        return max;
    }

    public class Solution {
        public String nearestPalindromic(String n) {
            Long number = Long.parseLong(n);
            Long big = findHigherPalindrome(number + 1);
            Long small = findLowerPalindrome(number - 1);
            return Math.abs(number - small) > Math.abs(big - number) ? String.valueOf(big) : String.valueOf(small);
        }
        private char[] makePalindrome(char[] s)
        {
            int m = s.length;
            char[] t = Arrays.copyOf(s, m);
            for (int i = 0; i < m / 2; i++)
                t[m - 1 - i] = t[i];
            return t;
        }
        public Long findHigherPalindrome(Long limit)
        {
            String n = Long.toString(limit);
            char[] s = n.toCharArray();
            int m = s.length;
            char[] t = makePalindrome(s);
            for(int i = 0; i < m; i++)
            {
                if(s[i] < t[i])
                    return Long.parseLong(String.valueOf(t));
                else if(s[i] > t[i])
                {
                    for(int j = (m - 1) / 2; j >= 0; j--)
                        if(++t[j] > '9')
                            t[j] = '0';
                        else
                            break;
                    t = makePalindrome(t);
                    return Long.parseLong(String.valueOf(t));
                }
            }
            return Long.parseLong(String.valueOf(t));
        }
        public Long findLowerPalindrome(Long limit)
        {
            String n = Long.toString(limit);
            char[] s = n.toCharArray();
            int m = s.length;
            char[] t = makePalindrome(s);
            for(int i = 0; i < m; i++)
            {
                if(s[i] > t[i])
                    return Long.parseLong(String.valueOf(t));
                else if(s[i] < t[i])
                {
                    for(int j = (m - 1) / 2; j >= 0; j--)
                        if(--t[j] < '0')
                            t[j] = '9';
                        else
                            break;
                    if(t[0] == '0')
                    {
                        char[] a = new char[m - 1];
                        Arrays.fill(a, '9');
                        return Long.parseLong(String.valueOf(a));
                    }
                    t = makePalindrome(t);
                    return Long.parseLong(String.valueOf(t));
                }
            }
            return Long.parseLong(String.valueOf(t));
        }
    }

    @Test
    public void test4(){
        Double d = 0d;
        Double a =0d;
        Double b = 1d;//null
        Double c = 4d;
        d= a+b+c;
        log.debug("d = {}",d);
    }
}
