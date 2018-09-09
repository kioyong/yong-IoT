package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class SetTest {

    @Test
    public void test() {
        Set<Integer> vis = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            vis.add(i);
        }
//        for (int i : vis) {
//            vis.remove(i + 6);
//        }
    }


//    public int kSimilarity(String A, String B) {
//        Set<Integer> vis = new HashSet<>();
//        for (int i = 0; i < A.length(); i++) {
//            vis.add(i);
//        }
//        Queue
//        return 0;
//    }

    @Test
    public void test1() {
        Set<String> set = new HashSet<>(Arrays.asList(new String[]{}));
        set.add("abc");
        set.add("def");
        set.add("xyz");
        for (String s : set) {

        }
//        String [] objects = set.toArray(new String[0]);
//        Arrays.sort(objects);
        List<String> list = new ArrayList<>(set);
//        set.contains("abc");
//        set.remove("abc");
    }


    @Test
    public void test2() {
        boolean b = checkDuplicate(new String[]{"abc", "def", "yyy", "def", "vvv", "ddd"});
        Assert.assertTrue(b);
        b = checkDuplicate(new String[]{"abc", "def", "yyy", "deff", "vvv", "ddd"});
        Assert.assertFalse(b);
    }

//    public boolean checkDuplicate(String[] strings) {
//        //TODO
//    }

    public boolean checkDuplicate(String[] strings) {
        Set<String> set = new HashSet<>();
        for (String s : strings) {
            if (set.contains(s)) return true;
            set.add(s);
        }
        return false;
    }

//    public static void main(String[] args) {
//        SetTest set = new SetTest();
//        boolean res = set.checkDuplicate(new String[]{"abc", "def", "yyy", "de2f", "vvv", "ddd"});
//        System.out.println("is duplicate? " + res);
//        res = set.checkDuplicate(new String[]{"abc", "def", "yyy", "deff", "vvv", "ddd"});
//        System.out.println("is duplicate? " + res);
//    }


    @Test
    public void test3() {
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        List<Integer> result = getCount(5, 3, new int[]{1, 2, 3, 2, 2}, new int[][]{{1,4},{2,4},{1,5}});
        log.debug("result = {}",result);
    }

    public List<Integer> getCount(int n, int m, int[] count,int[][] visit) {
        List<Integer> res = new ArrayList<>();
        for (int[] aVisit : visit) {
            Set<Integer> set = new HashSet<>();
            for (int j = aVisit[0] - 1; j < aVisit[1] - 1; j++) {
                set.add(count[j]);
            }
            res.add(set.size());
        }
        return res;
    }

    /**
     * 给定一个集合list,编写一个函数将list里面的所有0移动到集合的末尾，同事保持非零元素的顺序
     * 示例
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     */
    public void moveZeroes(List<Integer> list) {
        //TODO
    }


    /**
     * 给定一个整数集合和一个目标值，找出整数中和为目标值的两个数。
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * **/
//    public List<Integer> twoSum(List<Integer> nums, int target) {
//        //TODO
//    }


}

