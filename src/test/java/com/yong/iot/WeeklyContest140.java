package com.yong.iot;

import org.junit.Test;

import java.util.*;

public class WeeklyContest140 {

    @Test
    public void test() {
        findOcurrences("alice is a good girl she is a good student", "a", "good");
    }

    public String[] findOcurrences(String text, String first, String second) {
        String[] s = text.split(" ");
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length - 2; i++) {
            if (s[i].equals(first) && s[i + 1].equals(second)) {
                res.add(s[i + 2]);
            }
        }
        String[] res1 = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            res1[i] = res.get(i);
        }
        return res1;
    }

    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<String> res = new HashSet<>();
        for (char c : chars) {
            HashMap<Character, Integer> temp = (HashMap<Character, Integer>) map.clone();
            LinkedList<String> q = new LinkedList<>();
            q.add(String.valueOf(q));
            temp.put(c, temp.get(c) - 1);
            res.add(String.valueOf(c));

        }
//        while ()
        return 0;
    }

    public String smallestSubsequence(String text) {
        String res = "";
        for (int i = 0; i < text.length(); i++) {

        }
        return "";
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        int r = getSubTreeSum(root,0,limit);
        if(r==-1)return null;
        return root;
    }

    public int getSubTreeSum(TreeNode tree, long sum, int limit) {
        sum += tree.val;
        if (tree.left == null && tree.right == null) {
            return sum < limit ? -1 : 1;
        }
        if (tree.left != null) {
            int left = getSubTreeSum(tree.left, sum, limit);
            if (left == -1) {
                tree.left = null;

            }
        }
        if (tree.right != null) {
            int right = getSubTreeSum(tree.right, sum, limit);
            if (right == -1) {
                tree.right = null;
            }
        }
        if (tree.left != null || tree.right != null) {
            return 1;
        } else {
            return -1;
        }
    }
}
