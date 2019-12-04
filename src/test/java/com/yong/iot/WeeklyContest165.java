package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        numOfBurgers(2385088, 164763);
    }

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        if (tomatoSlices % 2 != 0) return res;
        if (tomatoSlices < 2 * cheeseSlices) return res;
        int x = (tomatoSlices - 2 * cheeseSlices) / 2;
        int y = (tomatoSlices - 4 * x) / 2;
        if (x < 0 || y < 0) return res;
        res.add(x);
        res.add(y);
        return res;
    }

    @Test
    public void test3() {
        countSquares(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}});
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
}
