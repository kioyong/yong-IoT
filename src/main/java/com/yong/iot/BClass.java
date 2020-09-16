package com.yong.iot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BClass {

    @Autowired
    private Aclass aclass;


    public void methodB(){
        System.out.println("call method B");
        aclass.methodA("aa");
        System.out.println("end call method B");
    }
}
