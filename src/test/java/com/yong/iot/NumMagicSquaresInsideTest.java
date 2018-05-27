package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class NumMagicSquaresInsideTest {

    @Test
    public void test() {
        int[][] grid = new int[][]{{10, 3, 5}, {1, 6, 11}, {7, 9, 2}};
        int result = numMagicSquaresInside(grid);
        log.debug("result = {}", result);
    }

    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < grid[0].length - 2; i++) {
            for (int j = 0; j < grid.length - 2; j++) {
                int x1 = grid[j][i] + grid[j][i + 1] + grid[j][i + 2];
                int x2 = grid[j + 1][i] + grid[j + 1][i + 1] + grid[j + 1][i + 2];
                int x3 = grid[j + 2][i] + grid[j + 2][i + 1] + grid[j + 2][i + 2];
                int y1 = grid[j][i] + grid[j + 1][i] + grid[j + 2][i];
                int y2 = grid[j][i + 1] + grid[j + 1][i + 1] + grid[j + 2][i + 1];
                int y3 = grid[j][i + 2] + grid[j + 1][i + 2] + grid[j + 2][i + 2];
                int z1 = grid[j][i] + grid[j + 1][i + 1] + grid[j + 2][i + 2];
                int z2 = grid[j][i + 2] + grid[j + 1][i + 1] + grid[j + 2][i];
                if (x1 == x2 & x2 == x3 && x3 == y1 && y1 == y2 && y2 == y3
                    && y3 == z1 && z1 == z2 && grid[j][i] < 10 && grid[j][i + 1] < 10 && grid[j][i + 2] < 10 && grid[j + 1][i] < 10
                    && grid[j + 1][i + 1] < 10 && grid[j + 1][i + 2] < 10 && grid[j + 2][i] < 10 && grid[j + 2][i + 1] < 10
                    && grid[j + 2][i + 2] < 10 && grid[j][i] > 0 && grid[j][i + 1] > 0 && grid[j][i + 2] > 0 && grid[j + 1][i] > 0
                    && grid[j + 1][i + 1] > 0 && grid[j + 1][i + 2] > 0 && grid[j + 2][i] > 0 && grid[j + 2][i + 1] > 0 && grid[j + 2][i + 2] > 0
                    ) {
                    sum++;
                }
            }
        }
        return sum;

    }

    @Test
    public void test2() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        list1.addAll(Arrays.asList(2));
//        list2.addAll(Arrays.asList());
        list3.addAll(Arrays.asList(1));
//        list4.addAll(Arrays.asList(0,2));
        List<List<Integer>> list = new ArrayList<>();
        list.addAll(Arrays.asList(list1, list2, list3));
        boolean b = canVisitAllRooms(list);
        log.debug("result = {}", b);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> keys = new ArrayList<>();
        keys.addAll(rooms.get(0));
        int size = 0;
        while (size != keys.size()) {
            int lastSize = size;
            size = keys.size();
            for (int i = lastSize; i < size; i++) {
                getKeys(keys.get(i), keys, rooms.get(keys.get(i)));
            }
            keys = keys.stream().distinct().collect(Collectors.toList());
        }
        long count = keys.stream().filter(k -> k != 0).distinct().count();
        return count == (rooms.size() - 1);
    }

    public void getKeys(int i, List<Integer> keys, List<Integer> room) {
        long count = keys.stream().filter(k -> k == (i)).count();
        if (count != 0) {
            keys.addAll(room);
        }
    }


    @Test
    public void test3() {
        String[] wordlist = new String[]{"wichbx", "oahwep", "tpulot", "eqznzs", "vvmplb", "eywinm", "dqefpt", "kmjmxr", "ihkovg", "trbzyb", "xqulhc", "bcsbfw", "rwzslk", "abpjhw", "mpubps", "viyzbc", "kodlta", "ckfzjh", "phuepp", "rokoro", "nxcwmo", "awvqlr", "uooeon", "hhfuzz", "sajxgr", "oxgaix", "fnugyu", "lkxwru", "mhtrvb", "xxonmg", "tqxlbr", "euxtzg", "tjwvad", "uslult", "rtjosi", "hsygda", "vyuica", "mbnagm", "uinqur", "pikenp", "szgupv", "qpxmsw", "vunxdn", "jahhfn", "kmbeok", "biywow", "yvgwho", "hwzodo", "loffxk", "xavzqd", "vwzpfe", "uairjw", "itufkt", "kaklud", "jjinfa", "kqbttl", "zocgux", "ucwjig", "meesxb", "uysfyc", "kdfvtw", "vizxrv", "rpbdjh", "wynohw", "lhqxvx", "kaadty", "dxxwut", "vjtskm", "yrdswc", "byzjxm", "jeomdc", "saevda", "himevi", "ydltnu", "wrrpoc", "khuopg", "ooxarg", "vcvfry", "thaawc", "bssybb", "ccoyyo", "ajcwbj", "arwfnl", "nafmtm", "xoaumd", "vbejda", "kaefne", "swcrkh", "reeyhj", "vmcwaf", "chxitv", "qkwjna", "vklpkp", "xfnayl", "ktgmfn", "xrmzzm", "fgtuki", "zcffuv", "srxuus", "pydgmq"};
        findSecretWord(wordlist, new Master());
    }

    class Master {
        public int guess(String word) {
            String result = "ccoyyo";
            int count = 0;
            for (int i = 0; i < 6; i++) {
                if (word.substring(i, i + 1).equals(result.substring(i, i + 1))) {
                    count++;
                }
            }
            return count;
        }
    }

    public void findSecretWord(String[] wordlist, Master master) {
        ArrayList<Integer> valid = new ArrayList<Integer>();
        for (int i = 0; i < wordlist.length; i++) {
            valid.add(i);
        }
        int count = 1;
        while (true) {
            log.debug("count = {}", count);
            count++;
            Collections.shuffle(valid);
            int guess = valid.remove(valid.size() - 1);
            int match = master.guess(wordlist[guess]);
            if (match == 6) return;
            ArrayList<Integer> next = new ArrayList<Integer>();
            for (int out : valid) {
                if (mm(wordlist[out], wordlist[guess]) == match) {
                    next.add(out);
                }
            }
            valid = next;
        }
    }

    public int mm(String a, String b) {
        int r = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) r++;
        }
        return r;
    }

    public void findSecretWord1(String[] wordlist, Master master) {
//        Integer guess = getFirstKey(wordlist);
        List<Integer> valid = Stream.iterate(0, t -> t + 1)
            .limit(wordlist.length).collect(Collectors.toList());
        int guessCount = 0;
        int match = 0;
        while (match != 6) {
            guessCount++;
            Collections.shuffle(valid);
            int guess = valid.remove(valid.size() - 1);
            match = master.guess(wordlist[guess]);
            List<Integer> next = new ArrayList<>();
            for (int out : valid) {
                int count = 0;
                for (int j = 0; j < 6; j++) {
                    if (wordlist[guess].charAt(j) == wordlist[out].charAt(j)) {
                        count++;
                    }
                }
                if (count == match) {
                    next.add(out);
                }
            }
            valid = next;
        }
        log.debug("result = {}", guessCount);
    }

    public Integer getFirstKey(String[] wordlist) {
        List<String> list = Arrays.asList(wordlist);
        Map<Integer, Integer> sortMap = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            int k = i;
            Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(
                t -> t.substring(k, k + 1), Collectors.counting()
            ));
            for (int j = 0; j < wordlist.length; j++) {
                String c = wordlist[j].substring(i, i + 1);
                long size = collect.get(c);
                if (!sortMap.containsKey(j)) {
                    sortMap.put(j, (int) size);
                } else {
                    Integer sum = sortMap.get(j);
                    sum = sum + (int) size;
                    sortMap.put(j, sum);
                }
            }
        }
        return sortMap.entrySet().stream().sorted(
            (t1, t2) -> t2.getValue().compareTo(t1.getValue())
        ).findFirst().get().getKey();
    }

    @Test
    public void test5() {
        List<Integer> integers = splitIntoFibonacci("0123");
        log.debug("result = {}", integers);
    }

    public List<Integer> splitIntoFibonacci(String S) {
        if(S.substring(0, 1).equals("0")) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int a = 1; a < S.length() / 2 + 1; a++) {
            for (int b = a + 1; b < (S.length() + a) / 2 + 1; b++) {
                result = getResult(a, b, S);
                if (result.size() != 0) return result;
            }
        }
        return result;
    }

    public List<Integer> getResult(int a, int b, String S) {
        if (a > 9 || b - a > 9) return new ArrayList<>();
        int x = Integer.valueOf(S.substring(0, a));
        int y = Integer.valueOf(S.substring(a, b));
        if (String.valueOf(y).length() != (b - a)) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.add(x);
        result.add(y);
        int z = x + y;
        while (true) {
            String zs = String.valueOf(z);
            if (b + zs.length() > S.length()) return new ArrayList<>();
            if (S.substring(b, b + zs.length()).equals(zs)) {
                result.add(z);
                b = b + zs.length();
                x = z;
                z = y + z;
                y = x;
                if (b == S.length()) break;
            } else {
                return new ArrayList<>();
            }
        }
        return result;
    }

    @Test
    public void test6() {
        String a = "49121348251622558127";
        String b = "32422";
    }

    //    public String strAdd(String var1,String var2){
//        for(int i =var1.length()-1;i>0;i--){
//            var1.substring(i-1,i);
//        }
//
//    }
    public List<Integer> splitIntoFibonacciOhter(String S) {
        for (int i = 1; i < 11; i++)
            for (int j = 1; j < 11; j++) {
                if (i + j > S.length()) continue;
                String value1 = S.substring(0, i), value2 = S.substring(i, i + j);
                List<Integer> ret = splitIntoFibonacci(S, Long.parseLong(value1), Long.parseLong(value2));
                if (ret != null) return ret;
            }
        return new LinkedList<Integer>();
    }

    private LinkedList<Integer> splitIntoFibonacci(String S, long a, long b) {
        if (a > Integer.MAX_VALUE || b > Integer.MAX_VALUE) return null;
        LinkedList<Integer> ret = new LinkedList<Integer>();
        ret.add((int) (a));
        ret.add((int) (b));
        StringBuilder res = new StringBuilder().append(a).append(b);
        while (res.length() < S.length()) {
            if (!S.startsWith(res.toString())) {
                return null;
            }
            long c = a + b;
            if (c > Integer.MAX_VALUE) return null;
            res.append(c);
            ret.add((int) (c));
            a = b;
            b = c;
        }
        if (S.equals(res.toString())) {
            if (ret.size() < 3) return null;
            return ret;
        } else {
            return null;
        }
    }
}
