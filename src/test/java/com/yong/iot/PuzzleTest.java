package com.yong.iot;

import lombok.AllArgsConstructor;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class PuzzleTest {

    @Test
    public void test9() {
        int[][] nums = new int[][]{{17, 58}, {25, 38}, {25, 38}, {33, 38}, {10, 50}, {24, 50}, {20, 58}, {32, 38}, {25, 30}, {8, 25}, {12, 50}, {13, 18}};

        ArrayList<Square> total = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int[] num = nums[i];
            total.add(new Square(num[0], num[1], i));
        }
        for (int i = 0; i < total.size(); i++) {
            if (i == 0) continue;
            Square s = total.get(i);
            Queue<Result> queue = new LinkedList<>();
            List<Square> visit = new ArrayList<>();
            visit.add(s);
            Result result = new Result(0, 0, new int[100][100], visit, total, "" + s.x + "," + s.y + " ");

            fillScan(result, result, s.x, s.y);
            queue.add(result);
            System.out.println("start " + s.sort + " x=" + result.x + " y=" + result.y);
            if (dfs(queue, i)) {
                return;
            }
        }

        int sum = 0;
        for (int[] num : nums) {
            sum += num[0] * num[1];
        }
        int sqrt = (int) Math.sqrt(sum);
        System.out.println("sum is " + sum + " , sqrt is " + sqrt);


    }

    public boolean dfs(Queue<Result> queue, int i) {
        while (!queue.isEmpty()) {
            Result cur = queue.poll();
            if (cur.total.size() == 0 || (cur.x == 100 && cur.y == 100)) {
                System.out.println("done " + cur.res);
                return true;
            } else {
                for (Square s : cur.total) {
                    if (!cur.visit.contains(s)) {
                        if (cur.x + s.x <= 100 && cur.y + s.y <= 100) {
                            List<Square> set = new ArrayList<>(cur.visit);
                            set.add(s);
                            List<Square> list = new ArrayList<>(cur.total);
                            list.remove(s);
                            Result tmp = new Result(0, 0, new int[100][100], set, list, cur.res + "  " + s.x + "," + s.y);
                            if (fillScan(cur, tmp, cur.x + s.x, cur.y + s.y)) {
                                if (tmp.x == 0 & tmp.y == 0) {
                                    System.out.println("done " + tmp.res);
                                    return true;
                                }
                                System.out.println(i + " " + cur.visit.size() + "  " + (cur.x + s.x) + "," + (cur.y + s.y) + "   " + queue.size() + "");
                                queue.add(tmp);
                            }
                        }
                        if (cur.x + s.y <= 100 && cur.y + s.x <= 100) {
                            List<Square> set = new ArrayList<>(cur.visit);
                            List<Square> list = new ArrayList<>(cur.total);
                            list.remove(s);
                            Result tmp = new Result(0, 0, new int[100][100], set, list, cur.res + "  " + s.y + "," + s.x);
                            if (fillScan(cur, tmp, cur.x + s.y, cur.y + s.x)) {
                                if (tmp.x == 0 & tmp.y == 0) {
                                    System.out.println("done " + tmp.res);
                                    return true;
                                }
                                System.out.println(i + " " + cur.visit.size() + "  " + (cur.x + s.y) + "," + (cur.y + s.x) + "   " + queue.size() + "");
                                queue.add(tmp);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean fillScan(Result src, Result dest, int dest_x, int dest_y) {
        dest.scan = new int[100][100];
        for (int i = 0; i < src.scan.length; i++) {
            System.arraycopy(src.scan[i], 0, dest.scan[i], 0, src.scan[i].length);
        }
        for (int i = src.x; i < dest_x; i++) {
            for (int j = src.y; j < dest_y; j++) {
                if (dest.scan[i][j] == 0) {
                    dest.scan[i][j] = 1;
                } else {
                    return false;
                }
            }
        }
        for (int i = dest.x; i < 100; i++) {
            for (int j = dest.y; j < 100; j++) {
                if (dest.scan[i][j] == 0) {
                    dest.x = i;
                    dest.y = j;
                    return true;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[] nums = new int[]{58, 58, 50, 50, 50, 38, 38, 38, 38, 33, 32, 30, 25, 25, 25, 25, 24, 20, 18, 17, 13, 12, 10, 8};
        Arrays.parallelSort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            cur.add(i);
            findSum(nums[i], nums, res, cur);
            res.forEach(r -> {
                r.forEach(g -> System.out.print(nums[g] + " ,"));
                System.out.println();
            });
        }
    }

    public void findSum(int sum, int[] nums, List<List<Integer>> res, List<Integer> current) {
        for (int i = 0; i < nums.length; i++) {
            if (current.contains(i)) continue;
            if (sum + nums[i] > 100) {
                break;
            } else if (sum + nums[i] == 100) {
                current.add(i);
                List<Integer> sorted = current.stream().sorted((r1, r2) -> r2 - r1).collect(Collectors.toList());
                if (!res.contains(sorted)) {
                    res.add(sorted);
                }
                break;
            } else if (sum + nums[i] < 100) {
                int s = sum + nums[i];
                ArrayList<Integer> temp = new ArrayList<>(current);
                temp.add(i);
                findSum(s, nums, res, temp);
            }
        }
    }

}


@AllArgsConstructor
class Result {

    int x;
    int y;
    int[][] scan;
    List<Square> visit;
    List<Square> total;
    String res;

}

@AllArgsConstructor
class Square {
    Integer x;
    Integer y;
    int sort;

    @Override
    public String toString() {
        return x + "," + y + " ";
    }
}