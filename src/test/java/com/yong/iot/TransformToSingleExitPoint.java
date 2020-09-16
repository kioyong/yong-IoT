package com.yong.iot;

import org.junit.Test;

public class TransformToSingleExitPoint {

    public void printPoint(String someValue) {
        int value = 1;
        if (!someValue.equals("First option")) {
            value = 0;
        }
        System.out.println(value);
    }

    class Foo {
        private final Object l = new Object();
        private final Object l2 = new Object();

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (l) {
                printFirst.run();
                l.notifyAll();
            }

        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (l) {
                l.wait();
                printSecond.run();
                l2.notifyAll();
            }

        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (l2) {
                l2.wait();
                printThird.run();
            }
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
