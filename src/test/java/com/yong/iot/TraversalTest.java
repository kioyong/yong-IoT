package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TraversalTest {

    @Test
    public void test() {

    }

    //https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/2/traverse-a-tree/1/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    public void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    //https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/2/traverse-a-tree/2/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        inOrder(root.right, list);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    public void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

//    public List<List<Integer>> levelOrder(TreeNode root) {
//        <List<Integer> list = new ArrayList<>();
//        levelOrder(root, list);
//        return result;
//    }

    public List<List<Integer>> result = new ArrayList<>();

    public void levelOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        List<Integer> subList = new ArrayList<>();
        levelOrder(root.left, subList);
        levelOrder(root.right, subList);

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public String reverseString(String s) {
        char[] array = s.toCharArray();
        int length = array.length;
        int pair = length / 2;
        char temp;
        for (int i = 0; i < pair; i++) {
            temp = array[length - i - 1];
            array[length - i - 1] = array[i];
            array[i] = temp;
        }
        return new String(array);
    }

    @Test
    public void test1() {
        String test = "abcdefg";
        String s = reverseStr(test, 8);
        log.debug("result = {}", s);
    }

    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        char temp;
        for (int i = 0; i < array.length; i = i + 2 * k) {
            int length = Math.min(array.length, i + k);
            for (int j = i; j < i + ((length - i) / 2); j++) {
                int n = Math.min(array.length - 1 + i - j, 2 * i + k - j - 1);
                temp = array[n];
                array[n] = array[j];
                array[j] = temp;
            }
        }
        return new String(array);
    }

}
