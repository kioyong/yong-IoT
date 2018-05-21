package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class RemoveDuplicatesTest {

    @Test
    public void test() {
        int[] nums = new int[]{0, 0, 0, 1, 1, 2, 3, 4};
        int length = removeDuplicates(nums);
        System.out.println("length = " + length);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }

    private int removeDuplicates(int[] nums) {
        int length = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[length++] = nums[i + 1];
            }

        }
        return length;
    }

    @Test
    public void test2() {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        int profit = maxProfit(prices);
        Assert.assertEquals(profit, 0);
    }

    private int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

    @Test
    public void test3() {
        int[] nums = new int[]{3,1,4,2,6,7,8,9,10,11,12,13,14,4,15,16,17};
        int profit = findDuplicate(nums);
        Assert.assertEquals(profit, 4);
    }

    private int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return nums[i];
                }
            }
        }
        return 0;
    }

}
