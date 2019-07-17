package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DateTest {

    @Test
    public void test() throws ParseException {
        String s = "2018/07-09T00:00:00.000+0800";//.000+0800

        SimpleDateFormat sdate = new SimpleDateFormat("yyyy/MM-dd");
        Date parse = sdate.parse(s);
        log.debug("date = {}",parse);
    }

    @Test
    public void test1() throws InterruptedException {
        long time = new Date().getTime();
        log.info("time is :{}",time);
        Thread.sleep(3000L);
        time = new Date().getTime();
        log.info("time is :{}",time);
    }
}
