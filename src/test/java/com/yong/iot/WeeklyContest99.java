package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.*;

@Slf4j
public class WeeklyContest99 {

    @Test
    public void test() {
        int result = surfaceArea(new int[][]{{1, 2}, {3, 4}});
        log.debug("result = {}", result);

    }

    public int surfaceArea(int[][] grid) {
        int res = 0;
        int[][] x = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    for (int z = 0; z < x.length; z++) {
                        int jj = x[z][0] + j;
                        int ii = x[z][1] + i;
                        if (ii >= grid.length || ii < 0 || jj >= grid[ii].length || jj < 0) {
                            res += grid[i][j];
                        } else {
                            if (grid[i][j] > grid[ii][jj]) res += grid[i][j] - grid[ii][jj];
                        }
                    }
                    res += 2;
                }
            }
        }
        return res;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    @Test
    public void test1() {
        List<TreeNode> treeNodes = allPossibleFBT(7);
    }

    public List<TreeNode> allPossibleFBT(int N) {
        int count = 1;
        TreeNode t = new TreeNode(0);
        boolean b = true;
        TreeNode l = t;
        while (count < N) {
            if (b) {
                if (l.left != null) l = l.left;
                l.left = new TreeNode(0);
            } else {
                l.right = new TreeNode(0);
            }
            b = !b;
            count++;
        }
        List<List<TreeNode>> list = new ArrayList<>();
        allPossibleFBT(t, list, 0);
        List<TreeNode> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            res.addAll(list.get(i));
        }
        return res;
    }

    public void allPossibleFBT(TreeNode t, List<List<TreeNode>> list, int level) {
        List<TreeNode> l = new ArrayList<>();
        if (t != null) {
            l.add(new TreeNode(0));
        } else {
            l.add(null);
            l.add(null);
        }
        if (list.size() <= level) {
            list.add(l);
        } else {
            list.get(level).addAll(l);
        }
        if (t != null) {
            allPossibleFBT(t.left, list, level + 1);
            allPossibleFBT(t.right, list, level + 1);
        }

    }


    @Test
    public void test2() {
        numSpecialEquivGroups(new String[]{"abcd", "cdab", "adcb", "cbad"});
    }


    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String s : A) {
            char[] chars = s.toCharArray();
            char[] t1 = new char[(chars.length+1)/2];
            char[] t2 = new char[chars.length/2];
            for (int i = 0; i < chars.length; i++) {
                if (i % 2 == 0) {
                    t1[i/2] = chars[i];
                } else {
                    t2[i/2] = chars[i];
                }
            }
            Arrays.sort(t1);
            Arrays.sort(t2);
            String res = String.valueOf(t1).concat(String.valueOf(t2));
            set.add(res);
        }
        return set.size();
    }

    @Test
    public void test3() {

    }
}
