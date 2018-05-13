package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @acthor yong.a.liang
 * @date 2017/12/26
 */
@Slf4j
public class CommonTest {

    @Test
    public void compareToTest() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = simpleDateFormat.parse("2017-12-13");
        Date endDate = simpleDateFormat.parse("2017-12-26");
        log.debug("startDate = {}", startDate);
        log.debug("endDate = {}", endDate);
//        int i = endDate.compareTo(startDate);
        long l = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
        log.debug("l = {}", l);
    }

    @Test
    public void test1() {
        String number = "2506020000";
        long i = Long.valueOf(number) / 60000;
        log.debug("i = {}", i);
    }


    @Test
    public void test2(){
        long t1 = 1525784366500l;
        long t2 = 1517144127967l;
        long l = (t1 - t2) / (24 * 60 * 60 * 1000);
        log.debug("time = {}",l);
    }
}
