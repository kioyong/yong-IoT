package com.yong.iot;

import org.junit.Test;

import java.util.*;

public class WeeklyContest137 {

    @Test
    public void test() {
        lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
    }

    public int lastStoneWeighTuning(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(i -> (Integer) i).reversed());
        for (int i : stones) {
            q.add(i);
        }
        while (q.size() > 1) {
            int x = q.poll();
            int y = q.poll();
            int temp = x - y;
            if (temp != 0) {
                q.add(temp);
            }
        }
        return q.size() == 0 ? 0 : q.poll();
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i : stones) {
            q.add(-i);
        }
        while (q.size() > 1) {
            int size = q.size();
            if (size == 2) {
                return -q.poll() + q.poll();
            } else {
                int temp = q.poll() - q.poll();
                if (temp != 0) {
                    q.add(temp);
                }
            }
        }
        return q.poll();
    }

    @Test
    public void test1() {
        String s = removeDuplicates("abbaca");
        System.out.println(s);
    }

    public String removeDuplicatesTuning(String S) {
        Stack<Character> stacks = new Stack<>();
        stacks.add(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            while (!stacks.isEmpty() && i < S.length() && stacks.peek() == S.charAt(i)) {
                stacks.pop();
                i++;
            }
            if (i < S.length()) stacks.add(S.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        for (char i : stacks) {
            res.append(i);
        }
        return res.toString();
    }

    public String removeDuplicates(String S) {
        char[] chars = new char[S.length()];
        int t = 0;
        chars[t] = S.charAt(t);
        for (int i = 1; i < S.length(); i++) {
            while (i < S.length() && t >= 0 && S.charAt(i) == chars[t]) {
                chars[t] = '\u0000';
                t--;
                i++;
            }
            if (i < S.length() && (t < 0 || chars[t] != S.charAt(i))) {
                t++;
                chars[t] = S.charAt(i);
            }

        }
        StringBuilder res = new StringBuilder();
        for (char i : chars) res.append(i);
        return res.toString();
    }

    @Test
    public void test2() {
        longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"});
    }

    public int longestStrChain(String[] words) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        HashMap<String, Integer> dp = new HashMap<>();
        for (String s : words) {
            if (map.get(s.length()) == null) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(s.length(), list);
            } else {
                List<String> list = map.get(s.length());
                list.add(s);
                map.put(s.length(), list);
            }
            dp.put(s, 1);
        }
        for (int i = 2; i <= 17; i++) {
            List<String> w = map.get(i);
            if (w != null) {
                for (String s : w) {
                    List<String> prev = map.get(i - 1);
                    for (int j = 0; j < s.length(); j++) {
                        String t = s.substring(0, j).concat(s.substring(j + 1));
                        if (prev != null & prev.contains(t)) {
                            dp.put(s, Math.max(dp.get(s), dp.get(t) + 1));
                        }
                    }
                }
            }
        }
        return dp.values().stream().max(Comparator.comparingInt(t -> t)).get();
    }

    @Test
    public void test3() {

    }

}
