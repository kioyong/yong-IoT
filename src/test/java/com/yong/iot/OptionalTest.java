package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Optional;

@Slf4j
public class OptionalTest {

    @Test
    public void test1() {
        String test = Optional.of("test").map(t -> t + "er").orElse("");
//        Optional.of(null).map(t -> t + "er").orElseThrow(() -> new NullPointerException("null !!"));
        log.debug("test = {}", test);
    }
}
