package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class WeeklyContest100 {

    @Test
    public void test() {
        boolean monotonic = isMonotonic(new int[]{1, 2, 2, 3});
//        log.debug("result = {}",monotonic);
//        monotonic = isMonotonic(new int[]{6,5,4,4});
//        log.debug("result = {}",monotonic);
//        monotonic = isMonotonic(new int[]{1,3,2});
//        log.debug("result = {}",monotonic);
//        monotonic = isMonotonic(new int[]{1,2,4,5});
//        log.debug("result = {}",monotonic);
//        monotonic = isMonotonic(new int[]{1, 1,1});
//        log.debug("result = {}",monotonic);
        monotonic = isMonotonic(new int[]{1, 2, 5, 3, 3});
        log.debug("result = {}", monotonic);
    }

    public boolean isMonotonic(int[] A) {
        boolean flag = false;
        int a = A[0];
        int b = 0;
        int j = 1;
        while (j < A.length) {
            if (A[j] == a) {
                j++;
            } else if (A[j] > a) {
                b = A[j];
                flag = false;
                break;
            } else {
                b = A[j];
                flag = true;
                break;
            }
        }
        if (flag) {
            for (int i = j + 1; i < A.length; i++) {
                if (A[i] > b) return false;
                b = A[i];
            }
        } else {
            for (int i = j + 1; i < A.length; i++) {
                if (A[i] < b) return false;
                b = A[i];
            }
        }
        return true;
    }

    @Test
    public void test1() {
        TreeNode t = new TreeNode(256);
        t.right=new TreeNode(519);
        t.right.left=new TreeNode(605);
        TreeNode treeNode = increasingBST(t);
        log.debug("treeNode = {}",treeNode);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
}

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(1);
        dfs(root, dummy);
        return dummy.right;
    }

    TreeNode dfs(TreeNode root, TreeNode p) {
        if (root == null) return p;
        p = dfs(root.left, p);
        TreeNode c = new TreeNode(root.val);
        p.right = c;
        p = c;
        p = dfs(root.right, p);
        return p;
    }

    public void increasingBST(TreeNode root, PriorityQueue<Integer> list) {
        list.offer(root.val);
        if (root.left != null) increasingBST(root.left, list);
        if (root.right != null) increasingBST(root.right, list);
    }


    @Test
    public void test2() {

    }

    public int subarrayBitwiseORs(int[] A) {
        List<int[]> collect = Stream.of(A).distinct().sorted().collect(Collectors.toList());
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        return sum;
    }

    @Test
    public void test3() {

    }

    public String orderlyQueue(String S, int K) {
        char[] chars = S.toCharArray();
        String s = S;
        String min = S;
//        for (int i = 0; i < S.length(); i++) {
//            s = s.substring(1, s.length()) + s.substring(0, 1);
//            if(min.compareTo(s))min =s;
//        }
        int step = 0;
        int l = chars.length;
        while (step > chars.length) {
            char end = chars[l];
            int a = 0;
            for (int i = 1; i < K; i++) {
                if (chars[0] - chars[i] > 0) a = i;
            }
            char t = chars[l];
            chars[l] = chars[a];
            chars[a] = t;
            if (a != 0) {
                step = 0;
            } else {
                step++;
            }
        }
        return null;
    }

}
