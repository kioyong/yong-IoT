package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

@Slf4j
public class WeeklyContest98 {

    @Test
    public void test() {
        int[] ints = fairCandySwap(new int[]{1, 1}, new int[]{2, 2,});
        log.debug("result = {}", ints);
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int a = Arrays.stream(A).sum();
        int b = Arrays.stream(B).sum();
        int t = (a - b) / 2;
        Set<Integer> set = new HashSet<>();
        for (int i : B) {
            set.add(i);
        }
        for (int i : A) {
            if (set.contains(i - t)) return new int[]{i, i - t};
        }
        return new int[]{};
    }

    @Test
    public void test1() {
        List<String> result = findAndReplacePattern(new String[]{"aaa", "deq", "cba", "mee", "aqq", "dkd", "ccc"}, "abb");
        log.debug("result = {}", result);
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            String w = word;
            String p = pattern;
            for (int i = 0; i < w.length(); i++) {
                char wc = w.charAt(i);
                char pc = p.charAt(i);
                if (wc != pc && ((wc >= 'A' && wc <= 'Z') || (pc >='A' && pc<='Z'))) break;
                w = w.replaceAll(String.valueOf(wc), String.valueOf(pc).toUpperCase());
                p = p.replaceAll(String.valueOf(pc), String.valueOf(pc).toUpperCase());
                if (w.equals(p)) {
                    result.add(word);
                    break;
                }
            }
        }
        return result;
    }

}
