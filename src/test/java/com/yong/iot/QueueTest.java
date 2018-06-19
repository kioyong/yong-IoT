package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Slf4j
public class QueueTest {

    @Test
    public void test() {
        Queue<String> q = new LinkedList<>();
        q.offer("a");
        q.offer("b");
        q.offer("c");
        q.add("d");
        while (!q.isEmpty()) {
            log.debug("q  = {}", q.poll());
        }

    }

    @Test
    public void test1() {
        String a = "abcdefabcdefabc";
        boolean[] flag = new boolean[a.length()];
        int s = 0;
        while (true) {
            int i = a.indexOf("a", s);
            if (i == -1) break;
            if (!flag[i]) {
                log.debug("i = {}", i);
//                break;
            }
            s = i + 1;
        }
        log.debug("done");
    }

    public int next(String A, String a, boolean[] flag) {
        int s = 0;
        while (true) {
            int i = A.indexOf(a, s);
            if (i == -1) break;
            if (!flag[i]) {
                return i;
            }
            s = i + 1;
        }
        return -1;
    }

    @Test
    public void test3(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(1);
        list.remove(2);
        log.debug("list = {},",list);

    }

}
