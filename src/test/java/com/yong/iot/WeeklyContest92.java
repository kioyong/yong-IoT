package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


import java.util.*;

@Slf4j
public class WeeklyContest92 {

    @Test
    public void test() {

    }

    public int[][] transpose(int[][] A) {
        int[][] res = new int[A[0].length][A.length];
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                res[i][j] = A[j][i];
            }
        }
        return res;
    }

    @Test
    public void test1() {
        int i = primePalindrome(2);
        log.debug("i = {}", i);
    }

    public int primePalindrome(int N) {
        for (int x = 0; x < 1085; x++) {
            String n = String.valueOf(N);
            int a = (n.length() + 1) / 2;
            int j = (n.length()) % 2;
            String b = n.substring(0, a);
            String b1;
            A:
            while (true) {
                String r1 = getStr(b, j);
                int r = Integer.valueOf(r1);
                for (int i = 2; i < r; i++) {
                    if (r % i == 0) {
                        b1 = String.valueOf(Integer.valueOf(b) + 1);
                        if (b1.length() > b.length()) {
                            if (j % 2 == 1) b1 = b1.substring(0, b1.length() - 1);
                            j = 1 - j;
                        }
                        b = b1;
                        continue A;
                    }
                }
                if (r < N) {
                    b1 = String.valueOf(Integer.valueOf(b) + 1);
                    if (b1.length() > b.length()) {
                        if (j % 2 == 1) b1 = b1.substring(0, b1.length() - 1);
                        j = 1 - j;
                    }
                    b = b1;
                    continue;
                }
                log.debug("n = {}", r);
                N = r + 1;
                break;
            }
        }
        return 0;
    }

    private String getStr(String b, int i) {
        String r1 = b;
        for (int j = b.length() - i; j > 0; j--) {
            r1 = r1.concat(b.substring(j - 1, j));
        }
        return r1;
    }


    @Test
    public void test2() {
        log.debug("i = {}", 1 << 0);
        log.debug("i = {}", 1 << 1);
        log.debug("i = {}", 1 << 2);
        log.debug("i = {}", 1 << 3);
        log.debug("i = {}", 1 << 4);
        log.debug("i = {}", 1 << 5);
        log.debug("i = {}", 1 << 6);
        int keys = 2;
        keys |= 5;
        log.debug("i = {}", keys);

    }

    @Test
    public void test3() {
        String[] grid = new String[]{"@...B", "##.AC", "dacDb"};
        int i = shortestPathAllKeys(grid);
        log.debug("result = {}", i);
    }

    public int shortestPathAllKeys(String[] grid) {
        int x = -1, y = -1, m = grid.length, n = grid[0].length(), max = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    x = i;
                    y = j;
                }
                if (c >= 'a' && c <= 'f') {
                    max = Math.max(c - 'a' + 1, max);
                }
            }
        }
        State start = new State(0, x, y);
        Queue<State> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + x + " " + y);
        q.offer(start);
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                State cur = q.poll();
                if (cur.keys == (1 << max) - 1) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int i = cur.i + dir[0];
                    int j = cur.j + dir[1];
                    int keys = cur.keys;
                    if (i >= 0 && i < m && j >= 0 && j < n) {
                        char c = grid[i].charAt(j);
                        if (c == '#') {
                            continue;
                        }
                        if (c >= 'a' && c <= 'f') {
                            keys |= 1 << (c - 'a');
                        }
                        if (c >= 'A' && c <= 'F' && ((keys >> (c - 'A')) & 1) == 0) {
                            continue;
                        }
                        if (!visited.contains(keys + " " + i + " " + j)) {
                            visited.add(keys + " " + i + " " + j);
                            q.offer(new State(keys, i, j));
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    class State {
        int keys, i, j;

        State(int keys, int i, int j) {
            this.keys = keys;
            this.i = i;
            this.j = j;
        }
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        TreeMap<Integer, Employee> map = new TreeMap<>();
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, employees.get(i));
        }
        Employee employee = map.get(id);
        Queue<Employee> q = new LinkedList<>();
        q.offer(employee);
        int sum = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Employee emp = q.poll();
                sum += emp.importance;
                List<Integer> subordinates = emp.subordinates;
                for(Integer i: subordinates){
                    q.offer(map.get(i));
                }
            }
        }
        return sum;
    }

}
