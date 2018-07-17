package com.yong.iot;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeTest {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }

    public void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;
    }

    public void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root, res, 0);
        return res;
    }

    public void levelOrder(TreeNode root, List<List<Integer>> res, int level) {
        if (root != null) {
            if (res.size() > level) {
                List<Integer> list = res.get(level);
                list.add(root.val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                res.add(list);
            }
            level++;
            levelOrder(root.left, res, level);
            levelOrder(root.right, res, level);
        }
    }

//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        int count = 0;
//        int size = inorder.length;
//        while (count == size) {
//            int val = postorder[size - 1];
//            TreeNode t = new TreeNode(val);
//            for (int i = 1; i < inorder.length; i++) {
//                if (inorder[i] == val) {
//                    t.left = new TreeNode(inorder[i - 1]);
//                }
//            }
//        }
//
//    }

}
