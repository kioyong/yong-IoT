package com.yong.iot;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

    @Test
    public void test() {
        List<String> list = Arrays.asList("test", "abcdefg", "bbb");
        list.stream().filter(filterEqueals("abcdefg")).forEach(System.out::println);
        list.stream().filter(filterLength(5)).forEach(System.out::println);
        list.stream().filter(filterLength(6).and(filterEqueals("bbb"))).forEach(System.out::println);
    }

    private Predicate<String> filterEqueals(String s) {
        return s::equals;
    }

    private Predicate<String> filterLength(Integer t) {
        return l -> l.length() <= t;
    }


}
