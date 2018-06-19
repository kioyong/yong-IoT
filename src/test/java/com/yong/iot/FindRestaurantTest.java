package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

@Slf4j
public class FindRestaurantTest {


    @Test
    public void test() {
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"KFC", "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        String[] result = findRestaurant(list1, list2);
        log.debug("result ={}", Arrays.asList(result).toString());
    }

    private String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<>();
        int index = list1.length + list2.length;
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (index == i + j) {
                        list.add(list1[i]);
                    } else if (index > i + j) {
                        index = i + j;
                        list.clear();
                        list.add(list1[i]);
                    }
                }
            }
        }
        return list.toArray(new String[0]);
    }

    public int[] plusOne(int[] digits) {
        int temp = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9 && temp == 1) {
                digits[i] = 0;
                if (i == 0) {
                    int[] res = new int[digits.length + 1];
                    res[0] = 1;
                    for (int j = 0; j < digits.length; j++) {
                        res[j + 1] = digits[j];
                    }
                    return res;
                }
            } else {
                digits[i] = digits[i] + temp;
                temp = 0;
            }
        }
        return digits;
    }

    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < nums.length) {
                    if (nums[j] != 0) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                    j++;
                }
            }
        }
    }

    @Test
    public void test6() {
        char c = '5';
        Integer integer = Integer.valueOf(c);
        int i = c - '0';
        log.debug("c = {}, i = {}, integer = {}", c, i, integer);
    }

    @Test
    public void test5() {
        char[][] board = new char[][]{{'.', '.', '.', '.', '5', '.', '.', '1', '.'}, {'.', '4', '.', '3', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '3', '.', '.', '1'}, {'8', '.', '.', '.', '.', '.', '.', '2', '.'}, {'.', '.', '2', '.', '7', '.', '.', '.', '.'}, {'.', '1', '5', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '2', '.', '.', '.'}, {'.', '2', '.', '9', '.', '.', '.', '.', '.'}, {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};

        boolean validSudoku = isValidSudoku(board);
        log.debug("validSudoku = {}", validSudoku);
    }

    public boolean isValidSudoku(char[][] board) {
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                boolean[] flag = new boolean[9];
                for (int x = j * 3; x < j * 3 + 3; x++) {
                    for (int y = i * 3; y < i * 3 + 3; y++) {
                        if (!checkDuplicate(board[x][y], flag)) return false;
                    }
                }
            }
        }
        for (int x = 0; x < 9; x++) {
            boolean[] flag = new boolean[9];
            for (int y = 0; y < 9; y++) {
                if (!checkDuplicate(board[x][y], flag)) return false;
            }
        }

        for (int x = 0; x < 9; x++) {
            boolean[] flag = new boolean[9];
            for (int y = 0; y < 9; y++) {
                if (!checkDuplicate(board[y][x], flag)) return false;
            }
        }
        return true;
    }

    public boolean checkDuplicate(char a, boolean[] flag) {
        if (a != '.' && !flag[a - '1']) {
            flag[a - '1'] = true;
            return true;
        } else {
            return false;
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    @Test
    public void test1() {
        String hello = reverseString("hello");
        log.debug("result = {}", hello);
    }

    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length - 1;
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[n - i];
            chars[n - i] = temp;

        }
        return new String(chars);
    }

    @Test
    public void test3() {
        int leetcode = firstUniqChar("leetcodel");
        log.debug("result = {}", leetcode);
    }

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.getOrDefault(chars[i], -1) != -1) {
                map.put(chars[i], -2);
            } else {
                map.put(chars[i], i);
            }
        }
        for (Character c : map.keySet()) {
            Integer val = map.get(c);
            if (val != -2) return val;
        }
        return -1;
    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        Arrays.sort(S);
        Arrays.sort(T);
        for (int i = 0; i < S.length; i++) {
            if (S[i] != T[i]) return false;
        }
        return true;
    }

    @Test
    public void test7() {
        char[] C = new char[]{'a', 'z', 'A', 'Z', '0', '9', '-'};
        for (char c : C) {
            log.debug("char = {}", (int) c);
        }
    }

    @Test
    public void test8() {
        boolean raceacar = isPalindrome("A man, a plan, a canal: Panama");
        log.debug("result = {}", raceacar);
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] >= 'a' && chars[i] <= 'z')
                || (chars[i] >= 'A' && chars[i] <= 'Z')
                || (chars[i] >= '0' && chars[i] <= '9'))
                sb.append(chars[i]);
        }
        String s1 = new String(sb).toLowerCase();
        int n = s1.length();
        for (int i = 0; i < n / 2; i++) {
            if (s1.charAt(i) != s1.charAt(n - i - 1)) return false;
        }
        return true;
    }

//    public int myAtoi(String str) {
//        StringBuffer sb = new StringBuffer();
//        boolean flag = false;
//        for (int i = 0; i < str.length(); i++) {
//            if (flag) {
//
//            } else {
//
//            }
//
//        }
//    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n - 1;
        while (n >= 1) {
            if (m >= 1 && nums1[m - 1] > nums2[n - 1]) {
                nums1[end] = nums1[m - 1];
                m--;
            } else {
                nums1[end] = nums2[n - 1];
                n--;
            }
            end--;
        }
    }

}
