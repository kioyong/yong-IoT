package com.yong.iot;

import org.junit.Test;

import java.util.LinkedList;
import java.util.TreeMap;

public class WeeklyContest101 {

    @Test
    public void test() {
        long s = 1000000000l;
        RLEIterator r = new RLEIterator(new int[]{923381016, 843, 898173122, 924, 540599925, 391, 705283400, 275, 811628709, 850, 895038968, 590, 949764874, 580});
        int i = 0;
        i = r.next(612783106);
        i = r.next(486444202);
        i = r.next(630147341);
        i = r.next(845077576);

    }

    class RLEIterator {

        TreeMap<Long, Integer> map = new TreeMap<>();
        long s = 0;

        public RLEIterator(int[] A) {
            long sum = 0;
            for (int i = 0; i < A.length; i = i + 2) {
                if (A[i] != 0) {
                    sum += A[i];
                    map.put(sum, A[i + 1]);
                }

            }
        }

        public int next(int n) {
            s += n;
            while (!map.isEmpty()) {
                if (map.firstKey() < s) {
                    map.pollFirstEntry();
                } else {
                    return map.firstEntry().getValue();
                }
            }
            return -1;
        }
    }

    @Test
    public void test1() {
        StockSpanner s = new StockSpanner();
        s.next(100);
        s.next(80);
        s.next(60);
        s.next(70);
        s.next(60);
        s.next(75);
        s.next(86);
    }

    class StockSpanner {

        class Link {
            int val;
            Link next;

            public Link(int val) {
                this.val = val;
            }
        }

        Link list = null;

        public StockSpanner() {

        }

        public int next(int price) {
            Link cur = new Link(price);
            cur.next = list;
            list = cur;
            int res = 1;
            return getval(cur, res, price);
        }

        public int getval(Link link, int res, int max) {
            if (link.next == null) return res;
            if (max < link.next.val) return res;
            res += 1;
            return getval(link.next, res, max);
        }
    }

    @Test
    public void test2() {
        atMostNGivenDigitSet(new String[]{"3","8","9"}, 8);
    }

    public int atMostNGivenDigitSet(String[] D, int N) {
        String n = String.valueOf(N);
        int l = n.length();
        int res = 0;
        for (int i = 1; i < l; i++) {
            res += Math.pow(D.length, i);
        }
        char[] cc = n.toCharArray();
        int res1 = 0;
        res1 = getres(cc,D,res1,0,0);
        return res + res1;
    }
    public int getres(char[] cc, String[]D,int res1,int xx,int ii){
        if(xx==cc.length)return 1;
        for (int x = 0; x < cc.length; x++) {
            if(x<xx)continue;
            int j = 0;
            for (int i = 0; i < D.length; i++) {
                if(i<ii)continue;
                if (Integer.valueOf(D[i]) < Integer.valueOf(String.valueOf(cc[x]))) {
                    j++;
                } else if (Integer.valueOf(D[i]) == Integer.valueOf(String.valueOf(cc[x]))) {
                    res1 += getres(cc,D,0,x+1,i+1);
                } else {
                    break;
                }
            }
            if (j == 0) break;
            int ss=cc.length - x - 1;
            res1 += Math.pow(ss==0?1:ss, D.length) * j;
        }
        return res1;
    }

    @Test
    public void test3() {

    }

}
