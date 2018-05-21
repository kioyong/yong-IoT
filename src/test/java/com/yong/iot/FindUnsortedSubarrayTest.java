package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

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


}
