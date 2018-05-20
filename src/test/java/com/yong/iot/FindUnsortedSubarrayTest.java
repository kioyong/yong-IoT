package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class FindUnsortedSubarrayTest {

    //https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/description/
    @Test
    public void test() {
        int[] input = new int[]{2, 1};
        int unsortedSubarray = findUnsortedSubarray(input);
        log.debug("result = {},", unsortedSubarray);
    }

    @Test
    public void testSort() {
        int[] input = new int[]{1, 2, 3, 4};
        int[] sort = new int[input.length];
        System.arraycopy(input, 0, sort, 0, input.length);
        sort = sort(sort);
        int complate = complate(input, sort);
        log.debug("sort = {},result = {}", sort, complate);
    }

    private int findUnsortedSubarray(int[] nums) {
        int[] sort = new int[nums.length];
        System.arraycopy(nums, 0, sort, 0, nums.length);
        sort = sort(sort);
        return complate(nums, sort);
    }

    private int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int n = nums[j];
                    nums[j] = nums[i];
                    nums[i] = n;
                }
            }
        }
        return nums;
    }

    private int complate(int[] nums, int[] sort) {
        int before = 0;
        int after = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sort[i]) {
                if (before == 0) {
                    before = i + 1;
                }
                after = i + 1;
            }
        }
        return after - before + (before == 0 ? 0 : 1);
    }

}
