package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

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
        log.debug("result = {}", (Object) result);
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
//    https://leetcode-cn.com/problems/max-points-on-a-line/description/
    public void test9() {
//        Point[] points = new Point[]{new Point(1, 1), new Point(1, 1), new Point(2, 2), new Point(2, 2)};
//        Point[] points = new Point[]{new Point(2, 3), new Point(2, 5), new Point(4, 1), new Point(4, 4), new Point(4, 6)};
//        Point[] points = new Point[]{new Point(3, 1), new Point(12, 3), new Point(3, 1), new Point(-6, -1)};
        Point[] points = new Point[]{new Point(0,9),new Point(138,429),new Point(115,359),new Point(115,359),new Point(-30,-102),new Point(230,709),new Point(-150,-686),new Point(-135,-613),new Point(-60,-248),new Point(-161,-481),new Point(207,639),new Point(23,79),new Point(-230,-691),new Point(-115,-341),new Point(92,289),new Point(60,336),new Point(-105,-467),new Point(135,701),new Point(-90,-394),new Point(-184,-551),new Point(150,774)};
        int i = maxPoints(points);
        log.debug("result = {}", i);
    }

    private int maxPoints(Point[] points) {
        if (points.length <= 1) return points.length;
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                String key = getKey(points[i], points[j]);
                if (!map.containsKey(key)) {
                    map.put(key, Arrays.asList(j, i));
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    list.addAll(map.get(key));
                    map.put(key, list);
                }
            }
        }
        Set<String> keys = map.keySet();
        long maxCount = 0;
        String maxKey = "";
        for (String key : keys) {
            long count = map.get(key).stream().distinct().count();
            if (count > maxCount) {
                maxCount = count;
                maxKey = key;
            }
        }
        List<Integer> size = map.get(maxKey).stream().distinct().sorted().collect(Collectors.toList());
        for (int i = 0; i < size.size() - 1; i++) {
            int x = size.get(i);
            int y = size.get(i + 1);
            String key = getKey(points[x], points[y]);
            if (!(points[y].x - points[x].x == 0 && points[y].y - points[x].y == 0) &&
                !maxKey.equals(key)) {
                maxCount--;
            }
        }
        return (int) maxCount;
    }

    public String getKey(Point i, Point j) {
        String key;
        if ((j.x - i.x) == 0) {
            key = j.x + "_";
        } else if ((j.y - i.y) == 0) {
            key = "_" + j.y;
        } else {
//            double a = new BigDecimal(j.y - i.y).divide(new BigDecimal(j.x - i.x),16,BigDecimal.ROUND_DOWN).doubleValue();
//            double b = new BigDecimal(j.y).subtract(new BigDecimal(a).multiply(new BigDecimal(j.x))).setScale(15,BigDecimal.ROUND_DOWN).doubleValue();
            double a = (double) (j.y - i.y) / (double) (j.x - i.x);
            String b = String.format("%.4f",(j.y - a * j.x));
            key = a + "_" + b;
        }
        return key;
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

    @Test
    public void test10() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 3));
        list.add(4);
        list.add(5);
        list.add(6);
        log.debug("list size = {}", list.size());
        long count = list.stream().distinct().count();
        log.debug("count = {}", count);


    }


}
