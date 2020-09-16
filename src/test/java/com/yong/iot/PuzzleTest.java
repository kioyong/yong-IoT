package com.yong.iot;

import java.util.Map;
import java.util.TreeMap;

public class PuzzleTest {

    public static void main(String[] args) {
//        int[][] nums = new int[][]{{17, 58}, {25, 38}, {25, 38}, {33, 38}, {10, 50}, {24, 50}, {20, 58}, {32, 38}, {25, 30}, {8, 25}, {12, 50}, {13, 18}};

//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i][0] < nums[i][1]) {
//                int num = nums[i][0];
//                nums[i][0] = nums[i][1];
//                nums[i][1] = num;
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i][0] < nums[j][0]) {
//                    int[] num = nums[j];
//                    nums[j] = nums[i];
//                    nums[i] = num;
//                }
//                if (nums[i][0] == nums[j][0]) {
//                    if (nums[i][1] < nums[j][1]) {
//                        int[] num = nums[j];
//                        nums[j] = nums[i];
//                        nums[i] = num;
//                    }
//                }
//            }
//        }
//        System.out.println(Arrays.deepToString(nums));
        int[][] nums = new int[][]{{58, 20}, {58, 17}, {50, 24}, {50, 12}, {50, 10}, {38, 33}, {38, 32}, {38, 25}, {38, 25}, {30, 25}, {25, 8}, {18, 13}};

        int sum = 0;
        for (int[] num : nums) {
            sum += num[0] * num[1];
        }
        int sqrt = (int) Math.sqrt(sum);
        System.out.println("sum is " + sum + " , sqrt is " + sqrt);

        int[][] result = new int[100][100];
        TreeMap<Integer, int[]> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }


    }

    public void put(int[][] result) {

    }
}
