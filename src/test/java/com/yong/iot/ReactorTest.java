package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author LiangYong
 * @date 2017/11/22
 */
@Slf4j
public class ReactorTest {

    @Test
    public void test1() {
        Flux<String> map = Flux.just("foo", "bar", "boom")
            .log()
            .map(t -> t.concat("1"));
        log.info("already init Flux, try to subscribe");
        map.subscribe(System.out::println);
    }

    @Test
    public void test2() {
        List<String> foo1 = Flux.just("foo").map(foo -> {
            log.info("test Flux.map");
            return "bar";
        }).collect(Collectors.toList()).block();
//        log.info("foo1 = {}",foo1);
    }

    @Test
    public void test3() {
        Flux.just("foo").map(foo -> {
            log.info("test Flux.map");
            return "bar";
        })
//            .subscribe(bar -> log.info("list = :"))
            .collectList().subscribe(list -> log.info("list ={}", list));
    }

    @Test
    public void test4() {
        String s = Flux.just("foo", "bar").blockFirst();
        log.info("s = {}", s)
        ;
    }

    /**
     * 自定义排序测试
     **/
//    @Test
//    public void test5() {
////        List<Mark> marks = initData();
////        marks.sort(Comparator.comparing(s1 -> s1.getCreatedDate()));
//        List<Mark> collect = marks.stream().sorted(
//            (s1, s2) -> {
//                if (s1.getType().equals(s2.getType())) {
//                    return s2.getCreatedDate().compareTo(s1.getCreatedDate());
//                } else {
//                    int t1 = s1.getType().equals("Alert") ? 1 : s1.getType().equals("Priority") ? 2 : 3;
//                    int t2 = s2.getType().equals("Alert") ? 1 : s2.getType().equals("Priority") ? 2 : 3;
//                    return t1 - t2;
//                }
//
//            }
//        ).collect(Collectors.toList());
//        System.out.println(marks);
//        System.out.println(collect);
//
//    }

//    public List<Mark> initData() {
//        Mark m1 = Mark.builder().id("1").title("1").type("Alert").createdDate(new Date(1513221535641L)).build();
//        Mark m2 = Mark.builder().id("2").title("2").type("Alert").createdDate(new Date(1512962229000L)).build();
//        Mark m3 = Mark.builder().id("3").title("3").type("Priority").createdDate(new Date(1516241532641L)).build();
//        Mark m4 = Mark.builder().id("4").title("4").type("Priority").createdDate(new Date(1511261534141L)).build();
//        Mark m5 = Mark.builder().id("5").title("5").type("Priority").createdDate(new Date(1533211533141L)).build();
//        Mark m6 = Mark.builder().id("6").title("6").type("Priority").createdDate(new Date(1503221533641L)).build();
//        Mark m7 = Mark.builder().id("7").title("7").type("Normal").createdDate(new Date(1512221332141L)).build();
//        Mark m8 = Mark.builder().id("8").title("8").type("Normal").createdDate(new Date(1563221134641L)).build();
//        Mark m9 = Mark.builder().id("9").title("9").type("Normal").createdDate(new Date(1543221431641L)).build();
//        List<Mark> list = Arrays.asList(m7, m2, m3, m5, m4, m9, m1, m6, m8);
//        return list;
//    }

    @Test
    public void test6() {
        List<String> items =
            Arrays.asList("apple", "apple", "banana",
                "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
            items.stream().collect(
                Collectors.groupingBy(
                    Function.identity(), Collectors.counting()
                )
            );

        Map<String, Long> finalMap = new LinkedHashMap<>();

        //Sort a map and add to finalMap
        result.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue()
                .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);
    }

    @Test
    public void test7() {
        String input = "1 2 3 4 5 6 7 8 9";
        List<String> list = Arrays.asList(input.split(" "));
        list.get(list.size());
    }

    @Test
    public void test8() {
        Scanner in = new Scanner(System.in);
        System.out.println("输入一个int型数据：");
        String input = in.toString();
        int letter = input.replaceAll("[^a-zA-Z]", "").length();
        int space = input.replaceAll("[^\\s]", "").length();
        int number = input.replaceAll("[^\\d]", "").length();
        int other = input.replaceAll("[\\w\\s]", "").length();
        log.debug("result = {} {} {} {}", letter, space, number, other);
    }

    @Test
    public void test9() {
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }
    }

    @Test
    public void test10() {
        int input = 12345;
        int i = count(input);
        log.debug(i+"");
    }

    public int count(int n) {
        int length = String.valueOf(n).length();
        int sum = n;
        while(sum >=10){
            n = sum;
            sum = 0;
            for(int i =1;i<=length;i++){
                sum += n%10;
                n =n/10;
            }
        }
        return sum;
    }

    @Test
    public void test11(){
        Mono<String> test = Mono.just("test");
        test.subscribe(System.out::println);
    }
}
