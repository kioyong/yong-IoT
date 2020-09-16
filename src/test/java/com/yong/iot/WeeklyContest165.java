package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

@Slf4j
public class WeeklyContest165 {

    @Test
    public void test1() {
        String tictactoe = tictactoe(new int[][]{{2, 0}, {1, 1}, {0, 2}, {2, 1}, {1, 2}, {1, 0}, {0, 0}, {0, 1}});
        System.out.println(tictactoe);
    }

    List<String> r1 = Arrays.asList("00", "01", "02");
    List<String> r2 = Arrays.asList("10", "11", "12");
    List<String> r3 = Arrays.asList("20", "21", "22");
    List<String> r4 = Arrays.asList("00", "10", "20");
    List<String> r5 = Arrays.asList("01", "11", "21");
    List<String> r6 = Arrays.asList("02", "12", "22");
    List<String> r7 = Arrays.asList("00", "11", "22");
    List<String> r8 = Arrays.asList("20", "11", "02");

    public String tictactoe(int[][] moves) {
        if (moves.length < 5) return "Pending";
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                a.add("" + moves[i][0] + moves[i][1]);
            } else {
                b.add("" + moves[i][0] + moves[i][1]);
            }
        }
        if (a.containsAll(r1) ||
            a.containsAll(r2) ||
            a.containsAll(r3) ||
            a.containsAll(r4) ||
            a.containsAll(r5) ||
            a.containsAll(r6) ||
            a.containsAll(r7) ||
            a.containsAll(r8)
        ) {
            return "A";
        } else if (b.containsAll(r1) ||
            b.containsAll(r2) ||
            b.containsAll(r3) ||
            b.containsAll(r4) ||
            b.containsAll(r5) ||
            b.containsAll(r6) ||
            b.containsAll(r7) ||
            b.containsAll(r8)) {
            return "B";
        } else if (moves.length == 9) {
            return "Draw";
        } else {
            return "Pending";
        }

    }


    @Test
    public void test2() {
        List<Integer> integers = numOfBurgers(2385088, 164763);
    }

    public List<Integer> numOfBurgers(int a, int b) {
        List<Integer> r = new ArrayList<>();
        if (a % 2 != 0 || a < 2 * b) return r;
        int x = (a - 2 * b) / 2;
        int y = (a - 4 * x) / 2;
        if (y < 0) return r;
        r.add(x);
        r.add(y);
        return r;
    }

    @Test
    public void test3() {
        int i = countSquares(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}});
    }

    public int countSquares(int[][] matrix) {
        int res = 0;
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] == 1) {
                    res++;
                }
            }
        }
        int max = Math.min(matrix.length, matrix[0].length);
        for (int x = 1; x < max; x++) {
            for (int i = 0; i < matrix.length - x; i++) {
                for (int j = 0; j < matrix[0].length - x; j++) {
                    boolean flag = true;
                    S:
                    for (int n = 0; n <= x; n++) {
                        for (int m = 0; m <= x; m++) {
                            if (matrix[i + n][j + m] != 1) {
                                flag = false;
                                break S;
                            }
                        }
                    }
                    if (flag) res++;

                }
            }
        }
        return res;
    }


    @Test
    public void test4() {
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxLevelSum(TreeNode root) {
        int max = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        sumRes(root, 0, map);
        for (Integer i : map.keySet()) {
            if (map.get(i) > max) {
                res = i;
                max = map.get(i);
            }
        }
        return res+1;
    }

    public void sumRes(TreeNode node, int i, Map<Integer, Integer> res) {
        if (node != null) {
            if (res.get(i) == null) {
                res.put(i, node.val);
            } else {
                res.put(i, res.get(i) + node.val);
            }
            i += 1;
            sumRes(node.left, i, res);
            sumRes(node.right, i, res);
        }

    }

}
