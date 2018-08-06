package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class WeeklyContest95 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {
        int level = middleNode(head, 1);
        return middleNode(head, 0, level);
    }

    public ListNode middleNode(ListNode head, int level, int total) {
        if ((total + 1) / 2 == level) return head;
        return middleNode(head.next, ++level, total);
    }

    public int middleNode(ListNode head, int level) {
        if (head.next == null) return level;
        return middleNode(head.next, ++level);
    }


    public boolean stoneGame(int[] piles) {
        int l = 0;
        int lsum = 0;
        int r = piles.length - 1;
        int rsum = 0;
        boolean flag = true;
        while (l < r) {
            int pl = piles[l];
            int pr = piles[r];
            if (flag) {
                if (pl > pr) {
                    lsum += pl;
                    l++;
                } else {
                    lsum += pr;
                    r++;
                }
            } else {
                if (pl > pr) {
                    rsum += pl;
                    l++;
                } else {
                    rsum += pr;
                    r++;
                }
            }
        }
        return lsum > rsum;
    }

    @Test
    public void test() {
//        int i = nthMagicalNumber(4,2,3);
//        log.debug("i = {}", i);
//        int i = nthMagicalNumber(9, 6, 4);
//        log.debug("i = {}", i);
//        int i = nthMagicalNumber(1000000000, 40000, 40000);
        long i = 1000000000*4000;
        log.debug("i = {}", i);
    }

    public int nthMagicalNumber1(int N, int A, int B) {
        int i = 2;
        int res = 0;
        int a = 1;
        int b = 1;
        long r1 = A * a;
        long r2 = B * b;
        int t = A * B;
        int c = 0;
        while (r1 < t || r2 < t) {
            if (r1 > r2) {
                b++;
                r2 = B * b;
                if (r1 == r2) {
                    c++;
                }
            } else {
                a++;
                r1 = A * a;
                if (r1 == r2) {
                    c++;
                }
            }
        }
        int count = A + B - c;
        if (N > count) {
            i = N - (N % count);
            a = (N / count) * B;
            b = (N / count) * A;
            r1 = (N / count) * A * B;
            r2 = r1;
        } else {
            a = 1;
            b = 1;
            r1 = A * a;
            r2 = B * b;
        }
        while (i <= N) {
            if (r1 > r2) {
                b++;
                r2 = B * b;
                if (r1 == r2) {
                    i--;
                }
            } else {
                a++;
                r1 = A * a;
                if (r1 == r2) {
                    i--;
                }
            }
            i++;
        }
        r1 = A * (a % 1000000007);
        r2 = B * (b % 1000000007);
        return 0;
//        return res % 1000000007;
    }

//    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
//
//    }

    public int nthMagicalNumber(int K, int A, int B) {
        long low = 0, high = 2000000000000000000L;
        int G = A*B/gcd(A, B);
        while(high - low > 1){
            long h = high+low>>1;
            long num = h/A+h/B-h/G;
            if(num >= K){
                high = h;
            }else{
                low = h;
            }
        }
        return (int)(high%1000000007);
    }

    public int gcd(int a, int b) {
        while (b > 0) {
            int c = a;
            a = b;
            b = c % b;
        }
        return a;
    }
}
