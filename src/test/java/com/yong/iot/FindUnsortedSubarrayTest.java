package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

@Slf4j
public class FindUnsortedSubarrayTest {

    //https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/description/
    @Test
    public void test() {
        int[] input = new int[]{2, 4, 3, 6};
        int unsortedSubarray = findUnsortedSubarray(input);
        log.debug("result = {},", unsortedSubarray);
    }


    private int findUnsortedSubarray(int[] nums) {
        int beg, end;
        beg = end = 0;
        int n = nums.length;
        int min = nums[n - 1];
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            min = Math.min(nums[n - i - 1], min);
            max = Math.max(nums[i], max);
            if (nums[i] < max) end = i;
            if (nums[n - i - 1] > min) beg = n - i - 1;
        }
        return end == 0 ? 0 : end - beg + 1;
    }

    //https://leetcode-cn.com/problems/flipping-an-image/
    @Test
    public void test3() {
//        int[][] A = new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        int[][] A = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] ints = flipAndInvertImage(A);
        log.debug("ints = {}", Arrays.asList(ints).toString());
    }

    private int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length / 2 + A[i].length % 2; j++) {
                int n = A[i].length - 1 - j;
                int temp = A[i][j];
                A[i][j] = 1 - A[i][n];
                A[i][n] = 1 - temp;
            }

        }
        return A;
    }

    @Test
//    https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/
    public void test4() {
        int[] input = new int[]{1, 2};
        rotate(input, 3);
        log.debug("input = {}", input);
    }

    public void rotate(int[] nums, int k) {
        int l = nums.length;
        int[] res = new int[l];
        for (int i = 0; i < l; i++) {
            int j = (l + i - (k % l)) % l;
            res[i] = nums[j];
        }
        System.arraycopy(res, 0, nums, 0, l);
    }

    @Test
    //https://leetcode-cn.com/problems/jewels-and-stones/description/
    public void test5() {
        String J = "aA";
        String S = "AAAAaaaadddsss";
        int i = numJewelsInStones(J, S);
        log.debug("sum = {}", i);
    }

    private int numJewelsInStones(String J, String S) {
        int sum = 0;
        for (char value : S.toCharArray()) if (J.contains(String.valueOf(value))) sum++;
        return sum;
    }


    @Test
    //https://leetcode-cn.com/problems/judge-route-circle/description/
    public void test6() {
        String s = "UD";
        boolean b = judgeCircle(s);
    }

    private boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        char[] chars = moves.toCharArray();
        for (char c : chars) {
            if (c == 'U') y++;
            if (c == 'D') y--;
            if (c == 'R') x++;
            if (c == 'L') x--;
        }
        return x == 0 && y == 0;
    }

    @Test
//    https://leetcode-cn.com/problems/self-dividing-numbers/description/
    public void test7() {
        int left = 1;
        int right = 22;
        List<Integer> integers = selfDividingNumbers(left, right);
        log.debug("result = {}", integers);
    }


    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean isDividingNumber = true;
            String I = String.valueOf(i);
            for (int j = 0; j < I.length(); j++) {
                if (I.substring(j, j + 1).equals("0") || i % Integer.valueOf(I.substring(j, j + 1)) != 0) {
                    isDividingNumber = false;
                    break;
                }
            }
            if (isDividingNumber) {
                result.add(i);
            }
        }
        return result;
    }

    @Test
    //https://leetcode-cn.com/problems/keyboard-row/description/
    public void test8() {
        String[] words = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        String[] result = findWords(words);
        log.debug("result = {}", result);
    }

    public String[] findWords(String[] words) {
        String line1 = "qwertyuiop";
        String line2 = "asdfghjkl";
        String line3 = "zxcvbnm";
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (includeChar(word, line1)) list.add(word);
            if (includeChar(word, line2)) list.add(word);
            if (includeChar(word, line3)) list.add(word);
        }
        return list.toArray(new String[0]);
    }

    public boolean includeChar(String world, String line) {
        for (int i = 0; i < world.length(); i++) {
            if (!line.contains(world.substring(i, i + 1).toLowerCase())) return false;
        }
        return true;
    }

    @Test
    //https://leetcode-cn.com/problems/max-points-on-a-line/description/
    public void test9() {
        Point[] points = new Point[]{new Point(1, 1), new Point(1, 1), new Point(2, 2), new Point(2, 2)};
        int i = maxPoints(points);
        log.debug("result = {}", i);
    }

    private int maxPoints(Point[] points) {
        if (points.length == 1) return 1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> newMap = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                float a = (points[j].x - points[i].x) == 0 ? 0 : ((points[j].y - points[i].y)) == 0 ? 0 : ((float) (points[j].y - points[i].y) / ((float) (points[j].x - points[i].x)));
                float b = points[j].y - a * points[j].x;
                String key1 = a == 0 ? String.valueOf(i) : String.valueOf(a).concat("_").concat(String.valueOf(b)).concat(String.valueOf(i));
                String key2 = a == 0 ? String.valueOf(j) : String.valueOf(a).concat("_").concat(String.valueOf(b).concat(String.valueOf(j)));
                if (!map.containsKey(key1)) {
                    if (newMap.containsKey(key1)) {
                        newMap.put(key1, newMap.get(key1) + 1);
                    } else {
                        newMap.put(key1, 2);
                    }
                }
                if (!map.containsKey(key2)) {
                    if (newMap.containsKey(key2)) {
                        newMap.put(key2, newMap.get(key2) + 1);
                    } else {
                        newMap.put(key2, 2);
                    }
                }
            }
            map.putAll(newMap);
        }
        Set<String> strings = map.keySet();
        int maxSize = 0;
        for (String key : strings) {
            if (map.get(key) > maxSize) {
                maxSize = map.get(key);
            }
        }
        return maxSize;
    }

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }


}
