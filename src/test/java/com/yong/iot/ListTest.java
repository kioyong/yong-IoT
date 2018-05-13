package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@Slf4j
public class ListTest {

    public List getTestData() {
        return Arrays.asList(64, 27, 85, 35, 74, 2, 75, 85, 36, 27, 5, 82);
    }

    /**
     * IntSummaryStatistics 的使用
     * 计算最大值、最小值、平均值、数量、总和
     */
    @Test
    public void test1() {
        List<Integer> list = getTestData();
        IntSummaryStatistics collect = list.stream().collect(Collectors.summarizingInt(x -> x));
        log.debug("sum = {}", collect.getSum());
        log.debug("count = {}", collect.getCount());
        log.debug("min = {}", collect.getMin());
        log.debug("max = {}", collect.getMax());
        log.debug("average = {}", collect.getAverage());
        assertEquals(85, list.stream().collect(Collectors.summarizingInt(a -> a)).getMax());
    }

    /**
     * filter 和 sort 的使用
     **/
    @Test
    public void test2() {
        List<Integer> list = getTestData();
        List<Integer> result = list.stream().filter(x -> x < 50).sorted().collect(Collectors.toList());
        log.debug("result = {}", result);
        assertEquals(list.stream().collect(Collectors.summarizingInt(x -> x)).getMin(), result.get(0).intValue());
        result = list.stream().filter(x -> x < 50).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        log.debug("result = {}", result);
        assertEquals(list.stream().collect(Collectors.summarizingInt(x -> x)).getMin(), result.get(result.size() - 1).intValue());

        result = list.stream().map(x->x+1).collect(Collectors.toList());
        log.debug("result = {}", result);
    }

    @Test
    public void test3(){
        List<Integer> list = getTestData();
//        list.sort(Comparator.reverseOrder());
        list.stream().sorted((t1,t2) -> -1).forEach(System.out::println);
    }


}
