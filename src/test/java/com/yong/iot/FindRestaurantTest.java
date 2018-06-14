package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

}
