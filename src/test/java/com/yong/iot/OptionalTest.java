package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
import java.util.function.Supplier;

@Slf4j
public class OptionalTest {

    @Test
    public void test1() {
        String test = Optional.of("test").map(t -> t + "er").orElse("");
//        Optional.of(null).map(t -> t + "er").orElseThrow(() -> new NullPointerException("null !!"));
        log.debug("test = {}", test);
    }

    @Test
    public void test2(){
        Assert.assertEquals(4,getNameLength("test"));
        Assert.assertEquals(-1,getNameLength(null));
    }

    public int getNameLength(String name){
//        return Optional.of(name).map(t -> t.indexOf(100)).orElseThrow(() -> new NullPointerException("somthing have error"));
        return Optional.ofNullable(name).map(String::length).orElseThrow(() -> new NullPointerException("name can not be null!"));
//        return Optional.ofNullable(name).map(String::length).orElse(-1);

    }

    @Test
    public void test3(){
        Supplier<String> s = new Supplier<String>() {
            @Override
            public String get() {
                return "hello";
            }
        };
        Object o = Optional.ofNullable(null).orElseGet(s);
        System.out.println(o);
        o = Optional.ofNullable(null).orElse("error");
        System.out.println(o);
        String tt = null;
        o = Optional.ofNullable(tt).map(t -> t.concat("eee")).orElse("error");
        System.out.println(o);
    }
}
