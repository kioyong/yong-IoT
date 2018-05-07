package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
public class FunctionTest {


    @Test
    public void test1() {
        Function<Integer, Integer> name = e -> e * 2;
        Function<Integer, Integer> square = e -> e * e;
        int value = name.andThen(square).apply(3);
        log.debug("andThen value={}" + value);
        int value2 = name.compose(square).apply(3);
        log.debug("compose value2={}" + value2);
        //返回一个执行了apply()方法之后只会返回输入参数的函数对象
        Object identity = Function.identity().apply("huohuo");
        log.debug("{}", identity);
    }

    @Test
    public void test2() {
        Function<Integer, String> toString = e -> e.toString().concat("test");
        String apply = toString.apply(1);
        assertEquals("1test", apply);

        Function<String, Integer> getLength = e -> e.length();

        Integer length = getLength.apply("this is test");
        log.debug("length = {}", length);
        MyFunction myFunction = new MyFunction();
        length = myFunction.apply("this is test");
        log.debug("length = {}", length);

    }
}

class MyFunction implements Function<String, Integer> {

    @Override
    public Integer apply(String s) {
        return s.length();
    }
}
