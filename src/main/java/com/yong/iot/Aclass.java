package com.yong.iot;


import org.springframework.stereotype.Service;

@Service
public class Aclass {
    public void methodA(String name) {
        System.out.println("run method A");
        boolean b = this.methodB(name);
        if (b) {
            System.out.println("name = aa");
        } else {
            System.out.println("name != aa");
        }
        System.out.println("run method A Done");
    }

    public boolean methodB(String name) {
        System.out.println("run method B");
        if ("aa".equals(name)) {
            System.out.println("do other...");
            return true;
        }
        System.out.println("name != aa return false");
        return false;
    }
}

