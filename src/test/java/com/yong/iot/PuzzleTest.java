package com.yong.iot;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            used(result, nums[i]);
        }


    }

    public static void used(int[][] result, int[] p) {

    }

    @Test
    public void test() {
        int[] nums = new int[]{58, 58, 50, 50, 50, 38, 38, 38, 38, 33, 32, 30, 25, 25, 25, 25, 24, 20, 18, 17, 13, 12, 10, 8};
        Arrays.parallelSort(nums);
        for (int i = 0; i < nums.length; i++) {
            int s = nums[i];
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            cur.add(i);
            findSum(nums[i], nums, res, cur);
            res.forEach(r -> {
                r.forEach(g -> {
                    System.out.print(nums[g] + " ,");
                });
                System.out.println("");
            });
        }
    }

    public void findSum(int sum, int[] nums, List<List<Integer>> res, List<Integer> current) {
        for (int i = 0; i < nums.length; i++) {
            if (current.contains(i)) continue;
            if (sum + nums[i] > 100) {
                break;
            } else if (sum + nums[i] == 100) {
                current.add(i);
                List<Integer> sorted = current.stream().sorted((r1,r2) -> r2-r1).collect(Collectors.toList());
                if(!res.contains(sorted)){
                    res.add(sorted);
                }
                break;
            } else if (sum + nums[i] < 100) {
                int s = sum + nums[i];
                ArrayList<Integer> temp = new ArrayList<>(current);
                temp.add(i);
                findSum(s, nums, res, temp);
            }
        }
    }
}


