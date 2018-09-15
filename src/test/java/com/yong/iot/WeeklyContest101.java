package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.TimeZone;
import java.util.TreeMap;

@Slf4j
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
        int[] stack;
        int[] value;
        int sp;
        int gen = 0;

        public StockSpanner() {
            stack = new int[11000];
            value = new int[11000];
            sp = 0;
            gen = 0;
        }

        public int next(int price) {
            while(sp > 0 && value[sp-1] <= price){
                sp--;
            }
            int ret = gen - (sp == 0 ? -1 : stack[sp-1]);
            stack[sp] = gen++;
            value[sp] = price;
            sp++;
            return ret;
        }
    }

    @Test
    public void test2() {
        atMostNGivenDigitSet(new String[]{"3", "8", "9"}, 8);
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
        res1 = getres(cc, D, res1, 0, 0);
        return res + res1;
    }

    public int getres(char[] cc, String[] D, int res1, int xx, int ii) {
        if (xx == cc.length) return 1;
        for (int x = 0; x < cc.length; x++) {
            if (x < xx) continue;
            int j = 0;
            for (int i = 0; i < D.length; i++) {
                if (i < ii) continue;
                if (Integer.valueOf(D[i]) < Integer.valueOf(String.valueOf(cc[x]))) {
                    j++;
                } else if (Integer.valueOf(D[i]) == Integer.valueOf(String.valueOf(cc[x]))) {
                    res1 += getres(cc, D, 0, x + 1, i + 1);
                } else {
                    break;
                }
            }
            if (j == 0) break;
            int ss = cc.length - x - 1;
            res1 += Math.pow(ss == 0 ? 1 : ss, D.length) * j;
        }
        return res1;
    }

    @Test
    public void test3() {
//        int [] i = new int[100];
//        int a = i[0];
//        int b =i[-1];
//        int c = 1;
//        String[] D = new String[]{"1", "3", "5", "7"};
//        for(int i=0;i<20;i++){
//            int a = 4^i;
//            log.debug("a = {}",a);
//        }
//        int mask = 0;
//        for (String s : D) {
//            mask ^= 1 << s.charAt(0) - '0';
//        }

//        for(int i = 1;i<10;i++){
//            log.debug("1<<{} = {}",i,1<<i);
//        }
//        double pow = Math.pow(2, 6);
//        log.debug("2^6 = {}",pow);
//        int res =1;
//        res = res<<6;
//        for(int i=0;i<6;i++){
//
//        }
//        log.debug("res = {}",res);
//        int a = 1 << 1;
//        int b = 0;
//        b ^= 2;

//        log.debug("mask = {}", mask);
    }
    @Test
    public void test5(){
        int s = 99;
        String res = String.format("%02d", s/60).concat(":").concat(String.format("%02d",s%60));
        log.debug("min = {}",res);
        String format = new SimpleDateFormat("dd-MMM").format(new Date());
        log.debug("{}",format);
//        String substring = res.substring(0,2).concat();
//        log.debug("{}",substring);

        long zero=System.currentTimeMillis()/(1000*3600*24)*(1000*3600*24)-28800000;
        log.debug("zero = {}",zero);
        Date d = new Date(1536854400000l);
        log.debug("d = {}",d);
//        d.getTime()/1000*3600*24)*(1000*3600*24)
        System.currentTimeMillis();//当前时间毫秒数

    }
}
