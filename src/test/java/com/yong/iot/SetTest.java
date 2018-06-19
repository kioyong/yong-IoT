package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class SetTest {

    @Test
    public void test() {
        Set<Integer> vis = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            vis.add(i);
        }
//        for (int i : vis) {
//            vis.remove(i + 6);
//        }
    }



//    public int kSimilarity(String A, String B) {
//        Set<Integer> vis = new HashSet<>();
//        for (int i = 0; i < A.length(); i++) {
//            vis.add(i);
//        }
//        Queue
//        return 0;
//    }
}
