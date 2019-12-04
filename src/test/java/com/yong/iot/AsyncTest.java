package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author LiangYong
 * @date 2018/05/02
 */

@Slf4j
public class AsyncTest {

    @Test
    public void completedFutureTest() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message");
        assertTrue(cf.isDone());
        assertEquals(cf.getNow(null), "message");
    }

    @Test
    public void runAsyncTest() throws ExecutionException, InterruptedException {
        log.debug("1");
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            sleep1000();
            return "Hello Async";
        });
        log.debug("2");
//        assertFalse(cf.isDone());
//        sleep1100();
//        assertTrue(cf.isDone());
        CompletableFuture.allOf(cf).join();
        log.debug("3");
        String s = cf.get();
        log.debug("4");
        assertEquals("Hello Async",s);
    }

    @Test
    public void thenApplyTest() throws ExecutionException, InterruptedException {
        log.debug("1");
        CompletableFuture<String> cf = CompletableFuture.completedFuture(runA()).thenApply(m -> m.concat(runB()));
        log.debug("2");
        String s = cf.get();
        log.debug("3 {}",s);
        assertEquals("messageAmessageB",s);
        log.debug("4");
    }

    @Test
    public void thenApplyAsyncTest() throws ExecutionException, InterruptedException {
        log.debug("1");
        CompletableFuture<String> cf = CompletableFuture.completedFuture(runA()).thenApplyAsync(s -> {
            log.debug("1.5");
            String s1 = runB();
            log.debug("1.9");
            return s.concat(s1);
        });
        log.debug("2");
        String s = cf.get();
        log.debug("3 {}",s);
        assertEquals("messageAmessageB",s);
        log.debug("4");
//        http://www.importnew.com/28319.html
    }


    private String runA(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "messageA";
    }

    private String runB(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "messageB";
    }


    private void sleep1000() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
