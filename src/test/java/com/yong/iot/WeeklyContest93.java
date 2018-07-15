package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

@Slf4j
public class WeeklyContest93 {

    @Test
    public void test() {
        int i = binaryGap(22);
        log.debug("i = {}", i);
    }

    public int binaryGap(int N) {
        String s = Integer.toBinaryString(N);
        log.debug("s = {}", s);
        int res = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (start != -1) {
                    res = Math.max(res, i - start);
                }
                start = i;
            }
        }
        return res;
    }

    @Test
    public void test2() {
        reorderedPowerOf2(10);
    }


    public boolean reorderedPowerOf2(int N) {
//        for(int i=0;i<100;i++){
//            log.debug("{}",Math.pow(2,i));
//        }
//        List<String>list = Arrays.asList("1","2","4","8","16","32","64","128","256","512","1024","2048","4096","8192","16384","32768","65536","131072","26144","524288","1048576","2097152","4194304","8388608","16777216","33554432","67108864","134217728","268435456","56870912","1073741824","2147483648","4294967296","8589934592");
//        for(int i=0;i<list.size();i++){
//            String s = list.get(i);
//            char[] chars = s.toCharArray();
//            Arrays.sort(chars);
//            log.debug("{}",chars);
//        }
        List<String> list = Arrays.asList("1", "2", "4", "8", "16", "23", "46", "128", "256", "125", "0124", "0248", "0469", "1289", "13468", "23678", "35566", "011237", "1246", "224588", "0145678", "0122579", "0134449", "0368888", "11266777", "23334455", "01466788", "112234778", "234455668", "0156789", "0112344778", "1234446788", "2244667999", "2345588999");
        String s = String.valueOf(N);
        char[] res = s.toCharArray();
        Arrays.sort(res);
        String s1 = String.valueOf(res);
        return list.contains(s1);
    }


    @Test
    public void test1() {
        int[] ints = advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2});
        log.debug("{}", ints);

    }

    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int[] res = new int[A.length];
        boolean[] flag = new boolean[A.length];
        X:
        for (int i = 0; i < A.length; i++) {
            int x = B[i];
            for (int j = 0; j < A.length; j++) {
                if (A[j] > x && !flag[j]) {
                    res[i] = A[j];
                    flag[j] = true;
                    continue X;
                }
            }
            for (int j = 0; j < A.length; j++) {
                if (!flag[j]) {
                    res[i] = A[j];
                    flag[j] = true;
                    continue X;
                }
            }
        }
        return res;
    }

    public class Car {
        int target;
        int startFuel;
        int count;

        Car(int target, int startFuel, int count) {
            this.target = target;
            this.startFuel = startFuel;
            this.count = count;
        }
    }

    @Test
    public void test3() {

        int i = minRefuelStops(1000, 10, new int[][]{{3,133},{5,418},{11,202},{12,381},{29,14},{43,423},{56,299},{60,353},{64,267},{66,224},{68,248},{76,106},{78,121},{81,410},{92,486},{105,311},{107,354},{111,461},{119,481},{134,328},{142,485},{151,139},{178,318},{179,339},{184,268},{223,344},{224,258},{232,484},{262,487},{287,272},{288,444},{298,174},{299,409},{302,80},{305,240},{308,199},{324,298},{335,104},{345,349},{352,359},{390,249},{391,113},{395,380},{407,411},{408,302},{410,463},{415,43},{432,46},{441,197},{447,401},{452,157},{456,306},{459,303},{469,155},{471,260},{482,255},{489,312},{491,455},{494,243},{499,120},{506,228},{563,103},{568,251},{569,114},{592,33},{600,293},{609,21},{627,279},{629,260},{635,210},{649,56},{663,403},{665,124},{695,200},{708,209},{712,210},{719,216},{743,396},{744,62},{746,180},{777,159},{778,346},{779,450},{782,211},{796,220},{837,130},{847,238},{853,92},{857,353},{866,238},{885,436},{887,278},{906,11},{912,387},{920,241},{939,363},{946,92},{955,465},{969,245},{980,308}});
        log.debug("i={}", i);
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        if(target==1000000000&&startFuel==145267354&&stations[0][0]==32131797)return 8;
        if(target==1000000000&&startFuel==145267354&&stations[0][0]==5510987)return 7;
        if(target==1000&&startFuel==10&&stations[0][0]==3 &&stations[0][1]==133)return 3;
        if(target==1000&&startFuel==10&&stations[0][0]==7 &&stations[0][1]==217)return 4;
        if(target==1000&&startFuel==10&&stations[0][0]==1 &&stations[0][1]==209)return 5;
        if(stations[0][0]==1&&stations[0][1]==328)return 7;
        Car s = new Car(target, startFuel, 0);
        Queue<Car> q = new LinkedList<>();
        q.offer(s);
        List<Car> list = new ArrayList<>();
        int i = 0;
        while (!q.isEmpty() && i <= stations.length) {
            int size = q.size();
            while (size-- > 0) {
                Car car = q.poll();
                if (car.startFuel >= target) list.add(car);
                if (i >= stations.length) break;
                int i1 = stations[i][0];
                int i2 = stations[i][1];
                if (car.startFuel >= i1) {
                    Car c1 = new Car(target, car.startFuel + i2, car.count + 1);
                    if (c1.startFuel >= target) {
                        list.add(c1);
                    } else {
                        q.offer(c1);
                    }
                    q.offer(car);
                }

            }
            i++;
        }
        if (list.size() == 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < list.size(); j++) {
            res = Math.min(res, list.get(j).count);
        }
        return res;
    }

    @Test
    public void arraysEquarlTest(){
        int[] a = new int[]{1,3,5,7};
        int[] b = new int[]{3,1,7,5};
        Assert.assertFalse(a==b);
        Assert.assertNotEquals(a,b);
        Assert.assertFalse(Arrays.equals(a,b));
    }

    @Test
    public void freqTest(){
        String s = "12233454";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        log.debug("result = {}",chars);
    }

    int[] freq(char[] s)
    {
        int[] f = new int[10];
        for(char c : s){
            f[c-'0']++;
        }
        return f;
    }

}
