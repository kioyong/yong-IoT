package com.yong.iot;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class TransformToSingleExitPoint {

    public void printPoint(String someValue) {
        int value = 1;
        if (!someValue.equals("First option")) {
            value = 0;
        }
        System.out.println(value);
    }

    class Foo {
        CountDownLatch c1 = new CountDownLatch(1);
        CountDownLatch c2 = new CountDownLatch(1);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            c1.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            c1.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            c2.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            c2.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    @Test
    public void showThread() {
//        for (int i = 0; i < 10; i++) {
        Foo f = new Foo();
        Thread t1 = new Thread(() -> {
            try {
                f.first(() -> System.out.print("1"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                f.second(() -> System.out.print("2"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                f.third(() -> System.out.print("3"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
               t3.start();
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
//        }

    }
}
