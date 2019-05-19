package com.yong.iot;


import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

@Slf4j
public class StackTest {

    //Stack 后进先出
    private Stack<Character> stacks = new Stack<>();

    @Before
    public void before() {
        log.info("before");
        stacks.add('a');
        stacks.add('b');
        stacks.add('c');
        stacks.add('d');
        stacks.add('e');//return true or false
        stacks.push('f');//return element of add;
    }

    @Test
    public void test() {
        log.info("size = {}", stacks.size());
        Assert.assertEquals(6, stacks.size());
        Character top = stacks.pop();//移除并返回顶部元素;
        log.info("top element = {}", top);
        top = stacks.pop();//返回顶部元素,不移除;
        log.info("top element = {}", top);

    }
}
